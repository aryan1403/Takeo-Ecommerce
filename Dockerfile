FROM eclipse-temurin:17-jdk-alpinealpine
VOLUME /tmp
COPY target/*jar -app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]