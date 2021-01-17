FROM maven:3.3.9-jdk-8-alpine
WORKDIR /opt
ENV PORT 3000
EXPOSE 3000
COPY target/*.jar /opt/app.jar
ENTRYPOINT exec java $JAVA_OPTS -jar app.jar



