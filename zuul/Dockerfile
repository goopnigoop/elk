FROM java:8-jdk
RUN mkdir /app
WORKDIR /app
COPY target/zuul-0.0.1-SNAPSHOT.jar /app
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar",\
            "/app/zuul-0.0.1-SNAPSHOT.jar"]
EXPOSE 8766