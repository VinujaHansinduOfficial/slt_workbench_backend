# Stage 1: Build the Spring Boot app using Java 21
FROM eclipse-temurin:21-jdk AS build

WORKDIR /app

# Copy Maven wrapper and make it executable
COPY mvnw .
COPY .mvn .mvn
RUN chmod +x mvnw

# Copy project files
COPY pom.xml .
COPY src ./src

# Build the app
RUN ./mvnw clean package -DskipTests

# Stage 2: Create lightweight container using Java 21
FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY --from=build /app/target/backend-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
