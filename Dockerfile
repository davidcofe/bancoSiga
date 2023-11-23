FROM eclipse-temurin:17-jdk-jammy

COPY build/libs/banco-0.0.1-SNAPSHOT.jar banco-0.0.1-SNAPSHOT.jar

RUN apt-get update && \
    apt-get install -y python3 && \
    rm -rf /var/lib/apt/lists/*

CMD ["java", "-jar", "banco-0.0.1-SNAPSHOT.jar"]