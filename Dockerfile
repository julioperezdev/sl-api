FROM eclipse-temurin:17-jre-jammy
EXPOSE 8081
COPY target/sl-api-0.0.1-SNAPSHOT.jar sl-api-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/sl-api-0.0.1-SNAPSHOT.jar" ]