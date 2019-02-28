## Beer-reactive-service with Spring Boot 2 and WebFlux

Start the app: 
```
mvn spring-boot:run
```
Goto localhost:8081 

## Endpoints
```
curl -X GET http://localhost:8081/beers/

[{"id":"5c744a93273ece1aec187203","name":"Cornet"},{"id":"5c744a93273ece1aec187204","name":"Augustiner"},{"id":"5c744a93273ece1aec187205","name":"Paulaner"},{"id":"5c744a93273ece1aec187207","name":"Leffe"},{"id":"5c744a93273ece1aec187208","name":"Kilkenny"},{"id":"5c744a93273ece1aec187206","name":"Duval"}]%
```

```
curl -X GET http://localhost:8081/beers/5c744a93273ece1aec187204

{"id":"5c744a93273ece1aec187204","name":"Augustiner"}
```

```
curl -X GET http://localhost:8081/beers/5c744a93273ece1aec187204/orders

data:{"beerId":"5c744a93273ece1aec187204","whenOrdered":"2019-02-25T20:06:03.918Z"}
data:{"beerId":"5c744a93273ece1aec187204","whenOrdered":"2019-02-25T20:06:04.916Z"}
data:{"beerId":"5c744a93273ece1aec187204","whenOrdered":"2019-02-25T20:06:05.918Z"}
data:{"beerId":"5c744a93273ece1aec187204","whenOrdered":"2019-02-25T20:06:06.918Z"}
```
