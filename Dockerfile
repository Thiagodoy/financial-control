#
# Build stage
# Stage One
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean install -DskipTests

# Stage Second
FROM openjdk:11-jdk-slim
EXPOSE 8961
COPY --from=build /home/app/target/financial-0.0.1-SNAPSHOT.jar /opt/target/financial-0.0.1-SNAPSHOT.jar
WORKDIR /opt/target
ENTRYPOINT ["java","-jar","financial-0.0.1-SNAPSHOT.jar"]