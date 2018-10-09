FROM openjdk:8

WORKDIR /docker

COPY . /docker

ARG jettyVersion=9.3.12.v20160915

RUN apt-get update && apt-get install -y wget

RUN wget -c http://repo1.maven.org/maven2/org/eclipse/jetty/jetty-distribution/${jettyVersion}/jetty-distribution-${jettyVersion}.tar.gz

RUN tar xzf jetty-distribution-${jettyVersion}.tar.gz && mv jetty-distribution-${jettyVersion} jetty9

RUN cp RestAPI-1.0-SNAPSHOT.war jetty9/webapps/

EXPOSE 8080

WORKDIR /docker/jetty9

CMD ["java", "-jar", "start.jar"]
