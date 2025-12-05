# Étape de build
FROM eclipse-temurin:21-jdk-jammy as builder
WORKDIR /workspace
COPY . .
RUN ./mvnw clean package -DskipTests

# Étape d'exécution
FROM eclipse-temurin:21-jdk-jammy
WORKDIR /app
COPY --from=builder /workspace/target/argano-*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]