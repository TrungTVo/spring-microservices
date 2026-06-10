# Stage 1: Build the application using JDK
FROM eclipse-temurin:21-jdk AS build

WORKDIR /usr/app/customer-service

COPY . .

RUN ./mvnw clean package -DskipTests=true

# Stage 2: Run the application using a smaller JRE/slim image
FROM eclipse-temurin:21-jre-alpine

WORKDIR /usr/app/customer-service

COPY --from=build /usr/app/customer-service/target/customer-service-0.0.1-SNAPSHOT.jar target/customer-service-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "target/customer-service-0.0.1-SNAPSHOT.jar"]
