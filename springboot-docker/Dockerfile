FROM openjdk:8-jdk-alpine
ADD  target/springboot-docker-1.0-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar" ]
