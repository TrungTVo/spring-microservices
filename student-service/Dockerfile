FROM openjdk

COPY . /usr/apps/spring-consul/student-service

WORKDIR /usr/apps/spring-consul/student-service

RUN ./mvnw clean package

CMD ["java","-jar","target/student-service-0.0.1-SNAPSHOT.jar"]
