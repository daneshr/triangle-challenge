FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD target/triangle-1.0-SNAPSHOT.jar challenge.jar
ENTRYPOINT [ "java" ,"-jar" , "challenge.jar"]