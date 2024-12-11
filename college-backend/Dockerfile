# Use OpenJDK base image to run the application
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the built jar file from the target folder to the container
COPY target/college-backend-0.0.1-SNAPSHOT.jar /app/college-backend.jar

# Expose the application port
EXPOSE 8080

# Command to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/college-backend.jar"]



