FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /src
COPY pom.xml .
COPY lingo-backend/pom.xml lingo-backend/
COPY lingo-frontend/pom.xml lingo-frontend/
COPY lingo-frontend/package*.json lingo-frontend/
COPY . .
RUN mvn -B -P lingo-frontend -DskipTests package

FROM  eclipse-temurin:21-jre
WORKDIR /app
RUN useradd -r -u 1001 spring
COPY --from=build /src/lingo-backend/target/lingo-backend-*.jar app.jar
USER spring
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

