### Employ the builder pattern
FROM maven:3.6.1-jdk-8 as builder

### Provide Default Argument
WORKDIR /usr/src/app 
#RUN CD ./target
COPY ./target . 

 
# RUN mvn clean package
 

## Use only a JRE to run application
FROM gcr.io/distroless/java:8
# FROM openjdk:7

## Copy Artifact from maven image
WORKDIR /app 
#RUN pwd && ls

# COPY Evaluation-0.0.1-SNAPSHOT.jar /app/app.jar
 COPY --from=builder /usr/src/app/Evaluation-0.0.1-SNAPSHOT.jar /app/app.jar 


EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
