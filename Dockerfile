FROM eclipse-temurin:17-jdk-jammy

COPY build/libs/banco-0.0.1-SNAPSHOT.jar banco-0.0.1-SNAPSHOT.jar

CMD ["java", "-jar", "banco-0.0.1-SNAPSHOT.jar"]