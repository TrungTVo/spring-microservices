FROM openjdk

COPY . /usr/apps/spring-consul/school-service

WORKDIR /usr/apps/spring-consul/school-service

RUN ./mvnw clean package

CMD ["java","-jar","target/school-service-0.0.1-SNAPSHOT.jar"]
