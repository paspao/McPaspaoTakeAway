# syntax=docker/dockerfile:1.0-experimental
ARG openjdkversion=11-jre-openj9
FROM maven:3.6-jdk-11-slim as builder
WORKDIR /app
COPY settings.xml /root/.m2/
COPY ./* ./
RUN  --mount=type=cache,target=/root/.m2 mvn  -e  -B package


FROM adoptopenjdk:$openjdkversion as order-service
COPY --from=builder  /app/order-service/target/order-service-1.0-SNAPSHOT.jar /usr/order-service/
WORKDIR /usr/order-service
EXPOSE 8090
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-Dserver.port=8090", "-jar", "order-service-1.0-SNAPSHOT.jar"]


