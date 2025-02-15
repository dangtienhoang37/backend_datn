## Build stage ##
FROM maven:3.9.9-amazoncorretto-17-alpine AS build

WORKDIR /app

# Sao chép file cấu hình Maven để cache dependency
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Sao chép source code
COPY src ./src
RUN mvn clean package -DskipTests=true && rm -rf ~/.m2/repository


## Run stage ##
FROM eclipse-temurin:17-jre-alpine AS runtime

WORKDIR /run

# Sao chép file JAR từ build stage
COPY --from=build /app/target/datn-0.0.1-SNAPSHOT.jar /run/datn-0.0.1-SNAPSHOT.jar
COPY .env /run/.env
# Set environment variables (có thể dùng .env hoặc cấu hình trực tiếp ở đây)
#ENV DBUrl=jdbc:postgresql://localhost:5432/parkingsystem
#ENV DBUsername=hoanghoinee
#ENV DBPassword=1
#ENV jwtSignerKey=Ry5OGtcJ+5dTSUV30C1LMaNew2uOotz0zpaBT/F9DJ5fLbcC5EoYtK/Ldh3H8VZo
#ENV CLOUDINARY_URL=cloudinary://284869121846298:A1UJDl8OPaOUPA4jCQdeF2MAuqQ@dll0eotnd
#ENV MQTT_BROKER_URL=tcp://localhost:1883
#ENV MQTT_CLIENT_ID=UUID.randomUUID().toString()
#ENV MQTT_TOPIC=my/topic
#ENV MQTT_USER_NAME=admin
#ENV MQTT_PASSWD=12345678
# Mở cổng 8081
EXPOSE 8081

# Khởi chạy ứng dụng
ENTRYPOINT ["java", "-jar", "/run/datn-0.0.1-SNAPSHOT.jar"]
