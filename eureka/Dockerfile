FROM java:8-jdk
RUN mkdir /app
WORKDIR /app
COPY target/eureka-0.0.1-SNAPSHOT.jar /app
COPY wait-for-it.sh /usr/bin/wait-for-it.sh
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/eureka-0.0.1-SNAPSHOT.jar"]
EXPOSE 8761