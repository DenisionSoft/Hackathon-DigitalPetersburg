FROM openjdk:21

LABEL org.opencontainers.image.source=https://github.com/DenisionSoft/life-quality-index

ARG JAR_FILE=build/libs/*SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar"]