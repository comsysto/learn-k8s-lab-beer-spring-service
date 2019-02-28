FROM java:8u111-jre-alpine

RUN mkdir /app
COPY target/*.jar /app/beer-service.jar

EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/app/beer-service.jar"]