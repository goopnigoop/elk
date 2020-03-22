FROM openjdk:8-jdk-alpine
VOLUME /tmp
ENV JAVA_OPTS="-Xmx300m -Dfile.encoding=UTF-8 -agentlib:jdwp=transport=dt_socket,address=5005,server=y,suspend=n"
ADD target/zuul-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar