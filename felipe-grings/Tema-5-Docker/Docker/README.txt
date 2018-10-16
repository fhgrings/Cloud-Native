Create container by Dockerfile
Open terminal at Tema-5-Docker

======== Terminal commands =========
	
	Create .war from java project
$ ./gradlew clean war

	Move .war to Docker file
$ mv build/libs/RestAPI-1.0-SNAPSHOT.war Docker/

	Enter in Docker file
$cd Docker

	Build an image from Dockerfile
$sudo docker build -t jetty9 .

	Run a container from image builded
$sudo docker run -p 8080:8080 jetty9

=========== Finished ===============


	Access URL
http://localhost:8080/Rest/rest/toll/pricelist


