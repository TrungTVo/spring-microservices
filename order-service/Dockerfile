# Stage 1: Build the application using JDK
FROM eclipse-temurin:21-jdk AS build

WORKDIR /usr/app/order-service

COPY . .

RUN ./mvnw clean package -DskipTests=true

# Stage 2: Run the application using a smaller JRE/slim image
FROM eclipse-temurin:21-jre-alpine

WORKDIR /usr/app/order-service

COPY --from=build /usr/app/order-service/target/order-service-0.0.1-SNAPSHOT.jar target/order-service-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "target/order-service-0.0.1-SNAPSHOT.jar"]
