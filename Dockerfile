FROM maven:3.5.2-jdk-8-alpine AS MAVEN_BUILD
MAINTAINER Divanio Silva
COPY / /build/
WORKDIR /build/
RUN mvn clean install -T 4

FROM openjdk:8-jre-alpine
WORKDIR /app
COPY --from=MAVEN_BUILD /build/target/docker-boot-intro-0.1.0.jar /app/
ENTRYPOINT ["java", "-jar", "docker-boot-intro-0.1.0.jar"]