FROM eclipse-temurin:17-jdk-jammy

WORKDIR /DockerTestApp

COPY build/libs/*.jar DockerTestApp.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "DockerTestApp.jar"]