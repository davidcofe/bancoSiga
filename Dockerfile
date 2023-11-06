FROM openjdk:17-oracle

COPY build/libs/banco-0.0.1-SNAPSHOT.jar banco.jar

CMD ["java", "-jar", "/banco.jar"]