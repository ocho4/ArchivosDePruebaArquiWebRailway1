FROM maven:3.9.11-eclipse-temurin-17 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]


#FROM amazoncorretto:17
#MAINTAINER EDO
#COPY target/trabajoparcial_primeraversion-0.0.1-SNAPSHOT.jar d.jar
#ENTRYPOINT ["java", "-jar", "/d.jar"]