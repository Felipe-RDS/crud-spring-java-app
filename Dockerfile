FROM amazoncorretto:21
WORKDIR /crud-app
COPY build/libs/*.jar crud-app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "crud-app.jar"]