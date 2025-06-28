FROM eclipse-temurin:17-jdk

EXPOSE 8080

COPY target/SpringAuthorizationService-0.0.1-SNAPSHOT.jar springapp.jar

CMD ["java", "-jar", "springapp.jar"]

