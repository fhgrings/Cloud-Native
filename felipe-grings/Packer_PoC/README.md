# HOW TO CREATE A DOCKER IMAGE WITH PACKER PLUS ANSIBLE


# Installing tools
- Install Packer

		$ sudo apt-get install packer 

- Verify packer version and if is installed

		$ packer version
    
- Install Ansible

		$ sudo apt-get install ansible
		
  

  
  

Generate json to run with packer 
-----------------------------------------------------
 Packer read a simple json and build a docker image with that.
 The Json file is divided in three parts, being;
 Builders;
 Provisioners;
 Post-processors.
 
 
 
 - Builders
 
    Builders are responsible for creating machines and generating images from them for various platforms.
    For example, there are separate builders for EC2, VMware, VirtualBox, etc. Packer comes with many builders by default,
    and can also be extended to add new builders.
    In builder we need to configure base image, in this case gona be java:8-jre. Type and commands when image starts.


		"builders": [
		{
		"type": "docker",
		"image": "java:8-jre",
		"commit": "true",
		"run_command": [
		"-d",
		"-i",
		"-t",
		"--name",
		"{{user `ansible_host`}}",
		"{{.Image}}",
		"/bin/bash"


		"changes": [
		"WORKDIR /opt/tomcat/bin",
		"CMD [\"catalina.sh\",\"run\"]",
		"ENV CATALINA_HOME /opt/tomcat",
		"ENV PATH $CATALINA_HOME/bin:$PATH"
		]
		}
    
  
 - Provisioners
 
    Provisioners are optional. By default if we put nothing the software will create a default container, but what we need here
    is to provide our container configurations, and to do this we need to use Ansible inside pakcer provisioner.
    
    
		"provisioners": [
		{
		"type": "shell",
		"inline": [
		"apt-get update",
		"apt-get install python -yq"
		]
		},
		{
		"type": "ansible",
		"user": "root",
		"playbook_file": "tomcat.yml",
		"extra_arguments": [
		"--extra-vars",
		"ansible_host={{user `ansible_host`}} ansible_connection={{user `ansible_connection`}}"
		]
		}
    
   - Post-processors
   
      Post-processors are optional. If no post-processors are defined within a template, 
      then no post-processing will be done to the image. The resulting artifact of a build 
      is just the image outputted by the builder.
      

		"post-processors": [
		[
		{
		"type": "docker-tag",
		"repository": "helloworld",
		"tag": "latest"
		}
		]
		
		

# ANSIBLE
 - To generate an ansible file, we need to create a .yml

Ansible are divided in three parts too.

- Playbook
- Play
- Tasks


## ansible.yml
- Ps.: Really take care with indentation. Ansible read that file by indentation and fails a lot because of that. 2 spaces for each indentation.




		---
		- name: all
		  hosts: all
		  become: true

		  tasks:
		  - name: Create WORKDIR
		    shell: mkdir -p opt/tomcat

		  - name: Download jetty9
		    get_url: url=https://www.apache.org/dist/tomcat/tomcat-8/v8.5.34/bin/apache-tomcat-8.5.34.tar.gz dest=opt/tomcat.tar.gz

		  - name: Unpac
		    shell: tar xzvf /opt/tomcat.tar.gz --strip-components=1 chdir=/opt/tomcat

		  - name: Download folder
		    shell: curl -u admin:ilegra -O "http://10.99.1.17:8081/artifactory/ilegra/HelloWorld.war"

		  - name: Copy folder
		    shell: mv HelloWorld.war /opt/tomcat/webapps/HelloWorld.war






# Build and Run 
- To build all these things is similar to docker

		$ sudo packer build template.json
  
- To verify if the image was succesfully 

		$ sudo docker images
  
- To run that image

		$ sudo docker run -p 8080:8080 helloworld
    

