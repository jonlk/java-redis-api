FROM openjdk:17

WORKDIR /app

COPY ./target/jredis-api-1.0.0.jar /app

CMD ["java", "-jar", "jredis-api-1.0.0.jar"]
