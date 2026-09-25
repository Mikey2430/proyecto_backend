# Etapa 1: compila el jar con Maven
FROM maven:3.9-eclipse-temurin-25 AS build

WORKDIR /app

COPY pom.xml .
COPY .mvn .mvn
COPY mvnw mvnw.cmd ./

# Permisos y fin de linea por si el contexto viene de Windows
RUN chmod +x mvnw && sed -i 's/\r$//' mvnw || true

RUN mvn dependency:go-offline -B

COPY src src

RUN mvn clean package -DskipTests -B

# Etapa 2: imagen liviana solo para correr
FROM eclipse-temurin:25-jre

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
