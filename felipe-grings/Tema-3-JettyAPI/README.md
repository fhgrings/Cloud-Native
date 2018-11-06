# Jetty Servlet implementation

This is a PoC with simple methods to implament a program in these reposytory, called Calculadora, you cant use to compare the differences between those codes.


## Jetty download and configure
Download Jetty 9.3.12 package:

		$ wget -c http://repo1.maven.org/maven2/org/eclipse/jetty/jetty-distribution/9.3.12.v20160915/jetty-distribution-9.3.12.v20160915.tar.gz

Extract the Jetty package:

		$ tar xzf jetty-distribution-9.3.12.v20160915.tar.gz	

Rename the directory to jetty and move it to /opt:

		$ mv jetty-distribution-9.3.12.v20160915 jetty9
		$ sudo mv jetty9 /opt

We will create a user and group named jetty that will be used to run Jetty. Create the group first:

		$ sudo addgroup --quiet --system jetty

Create the jetty system user.

		$ sudo adduser --quiet --system --ingroup jetty --no-create-home --disabled-password jetty

Modify the /etc/passwd entry to change home and group for jetty user.

		$ sudo usermod -c "Jetty 9" -d /opt/jetty9 -g jetty jetty

Change ownership of /opt/jetty9 directory to user jetty and group jetty.

		$ sudo chown -R jetty:jetty /opt/jetty9

Change the permission of /opt/jetty9 directory.

		$ sudo chmod u=rwx,g=rxs,o= /opt/jetty9
    



## Run your project

In project file, create .WAR project

		./gradlew clean war

Move to jetty webapp

		mv build/lib/exampleProject /opt/jetty9/webapp


Enter jetty path

		cd /opt/jetty9

Start Jetty

		java -jar start.jar


Test API
Access URL
-http://localhost:8080/CalculatorAPI-1.0-SNAPSHOT/rest/calculator/calculate?value1=2&value2=3&operator=div

