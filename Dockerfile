FROM openjdk:8

COPY target/RestAPIProject-0.0.1-SNAPSHOT.jar RestAPIProject-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/RestAPIProject-0.0.1-SNAPSHOT.jar"]