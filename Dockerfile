# Base image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy jar file
COPY target/ReservationService-0.0.1-SNAPSHOT.jar reservationservice.jar

# Expose the port the service listens on
EXPOSE 8081

# Run the jar
ENTRYPOINT ["java", "-jar", "reservationservice.jar"]
