FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} nani.jar
ENTRYPOINT ["JAVA","-jar","/nani.jar"]