FROM eclipse-temurin:17-jdk-jammy

WORKDIR /order-service

COPY target/order-service.jar order-service.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "order-service.jar"]