FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
ADD target/myjar-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT [“java”,”-jar”,”/app.jar”]
EXPOSE 8080
