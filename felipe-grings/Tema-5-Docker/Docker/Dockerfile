FROM openjdk:8

WORKDIR /docker

COPY . /docker

RUN apt-get update && apt-get install -y wget

RUN wget -c http://repo1.maven.org/maven2/org/eclipse/jetty/jetty-distribution/9.3.12.v20160915/jetty-distribution-9.3.12.v20160915.tar.gz

RUN tar xzf jetty-distribution-9.3.12.v20160915.tar.gz && mv jetty-distribution-9.3.12.v20160915 jetty9

RUN cp RestAPI-1.0-SNAPSHOT.war jetty9/webapps/

EXPOSE 8080

WORKDIR /docker/jetty9

CMD ["java", "-jar", "start.jar"]
