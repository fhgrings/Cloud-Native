## Tomcat POC

		gradlew clean war

Move .war to webapps in $TOMCAT_HOME/webapps

Start Tomcat

Access API by

http://localhost:8080/CalculatorAPI-1.0-SNAPSHOT/rest/calculator/calculate?value1=2&value2=3&operator=div