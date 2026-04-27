FROM eclipse-temurin:17-jdk-jammy

WORKDIR /user-service

COPY target/user-service.jar user-service.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "user-service.jar"]