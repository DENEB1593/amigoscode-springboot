## 실행
    java -jar target/demo-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod --server.port=8080
    java -jar target/demo-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev --server.port=9090

## Docker
    1 ./mvnw spring-boot:build-image -Dspring-boot.build-image.imageName=springio/gs-spring-boot-docker
    2 docker run -p 8080:8080 -t springio/gs-spring-boot-docker