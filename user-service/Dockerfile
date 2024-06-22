# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Maintainer information
LABEL maintainer="vamsipachipala"

# Copy the packaged jar file to the working directory
COPY target/user-service-0.0.1-SNAPSHOT.jar user-service-0.0.1-SNAPSHOT.jar

# Run the application
ENTRYPOINT ["java", "-jar", "user-service-0.0.1-SNAPSHOT.jar"]

# Creating the docker image by file method
