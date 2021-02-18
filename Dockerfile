FROM adoptopenjdk/openjdk11:latest
LABEL maintainer=alfredoalejandro05@gmail.com
RUN apt-get update && apt-get install -y
VOLUME /tmp

EXPOSE 8080

ARG JAR_FILE=target/user-management-service-1.0.0.jar
ADD ${JAR_FILE} user-management-service.jar

ENTRYPOINT ["java","-jar", "-Dspring.profiles.active=prod","/user-management-service.jar"]