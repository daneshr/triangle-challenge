# Triangle Challenge

Simple implementation for the triangle challenge, this program can determine the type of
a triangle.

### Used Stack

   * Spring Boot
   * Java 8
   * maven
   * Swagger
   * React
 
## Fetching project
Clone this repository via the following address:
 
```
git clone git@github.com:daneshr/triangle-challenge.git
```
For opening in ide please install suitable Lombok plugin for your ide.

### How to install

1- This is a maven project so Maven should be installed in your machine.

2- Use the following command to build required artifact:

```
mvn clean install
```

## How to run

with docker compose use the following command to run:

```
docker-compose up
```
## UI
A simple ui can be found on the following address:

```
http://localhost:8080/

```
## Rest Api 
Rest api for determine the type of a triangle is:
            
```
http://localhost:8080/shape/triangle/{sideA}/{sideB}/{sideC}
```
### Swagger 
To access the swagger, use the following address:

```
swagger path: http://localhost:8080/swagger-ui.html