## Spring different environment properties

To run in each environment;

		mvn clean install

Then run by default environment
		
		cd target

		java -jar demo.jar

To change the environment

		java -jar demo.jar --spring.profiles.active={environment}