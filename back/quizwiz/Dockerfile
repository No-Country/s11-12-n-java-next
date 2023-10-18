FROM openjdk:17-jdk-alpine

COPY target/quizwiz-v1.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]