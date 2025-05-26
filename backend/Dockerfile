# Etapa 1: build
FROM maven:3.9.5-eclipse-temurin-17 AS builder
WORKDIR /app
COPY backend/pom.xml backend/pom.xml
COPY backend/src backend/src
RUN mvn -f backend/pom.xml clean package -DskipTests

# Etapa 2: imagem final
FROM eclipse-temurin:17-jdk-jammy
COPY --from=builder /app/backend/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]