FROM eclipse-temurin:17-jdk-jammy

WORKDIR /payment-service

COPY target/payment-service.jar payment-service.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "payment-service.jar"]