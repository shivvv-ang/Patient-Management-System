# Stage 1: Build the Spring Boot application
FROM maven:3-eclipse-temurin-25 AS builder

WORKDIR /app

# Copy Maven configuration first for better caching
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline -B

# Copy application source code
COPY src ./src

# Compile, test and package the application
RUN mvn clean package


# Stage 2: Run the packaged application
FROM eclipse-temurin:25-jre AS runner

WORKDIR /app

# Copy executable JAR from builder stage
COPY --from=builder /app/target/billing-service-0.0.1-SNAPSHOT.jar ./app.jar

# Document application port
EXPOSE 4001
EXPOSE 9001

# Start Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]