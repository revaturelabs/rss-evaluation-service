### Employ the builder pattern
FROM maven:3.6.1-jdk-8 as builder

### Provide Default Argument
WORKDIR /usr/src/app 

COPY ./target .  

## Use only a JRE to run application
FROM gcr.io/distroless/java:8
# FROM openjdk:7

## Copy Artifact from maven image
WORKDIR /app 
#RUN pwd && ls

COPY --from=builder /usr/src/app/rss-evaluation-0.0.1-SNAPSHOT.jar /app/app.jar 


EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
