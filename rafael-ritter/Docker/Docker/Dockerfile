FROM openjdk:8

WORKDIR /app

COPY . /app

ENV JETTY jetty-distribution-9.4.12.v20180830

RUN apt-get update \
  && apt-get install -y wget \
	unzip \
  && rm -rf /var/lib/apt/lists/*

RUN wget https://repo1.maven.org/maven2/org/eclipse/jetty/jetty-distribution/9.4.12.v20180830/${JETTY}.zip

RUN unzip ${JETTY}.zip

RUN cp Docker-1.0-SNAPSHOT.war ${JETTY}/webapps/

EXPOSE 8080

WORKDIR /app/${JETTY}

CMD ["java", "-jar", "start.jar"]

