# Overview
This is Spring Boot application for Lightfeather management API. 

# Running locally with maven
Software needed locally 

    1. JDK 17 (https://jdk.java.net/archive/)

    2. Maven (https://maven.apache.org/download.cgi)
```
mvn clean install

mvn spring-boot:run
```
# Running with docker
To help ensure consistently correct startup across multiple platforms, you may choose to use Docker to containerize your application.  Installation steps for docker can be found on their main page.
https://docs.docker.com/engine/install/

With Docker installed, you can build your a new image. This build needs to be run after any changes are made to the source code.
```
docker build -t lightfeather .
```

After the image builds successfully, run a container from that image.
```
docker run -p8080:8080 lightfeather -d
```

# Swagger url
```
http://localhost:8080/swagger-ui/index.html#/
```

When you are done testing, stop the server and remove the container.
```
docker rm -f lightfeather
```

# Running with docker-compose
```
docker-compose up -d
```

# Shutting down with docker-compose
```
docker-compose down
```

# Postman collection
Postman collection can be imported to test API

```
location: src/main/resources/lightfeather-api.postman_collection.json
```
