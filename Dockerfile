FROM openjdk:8-jre-alpine
VOLUME /tmp
ADD /target/myapp.jar myapp.jar

ENTRYPOINT ["java", "-jar" , "myapp.jar"]
