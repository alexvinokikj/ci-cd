FROM openjdk:8-jdk-alpine
VOLUME /tmp
RUN apk update && apk upgrade
EXPOSE 8080
ADD build/libs/service.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT exec java $JAVA_OPTS -Duser.timezone=GMT -Djava.security.egd=file:/dev/./urandom -jar /app.jar

