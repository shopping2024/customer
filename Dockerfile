FROM openjdk:17
EXPOSE 8060
ADD target/customer-docker.jar customer-docker.jar
ENTRYPOINT ["java","-jar","/customer-docker.jar"]