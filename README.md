# ascendant

Simple backend with client and case

Pre-requisites:
Spring Boot: 3.1.3
Packaging: Jar
Java: 11

Dependencies:
Lombok, Spring Data JPA, MS SQL Server Driver, Spring Web

Server: http://localhost:8080/

Software:
Intellij to run springboot
MySQL workbench to view tables and data
Postman to run API calls

API CALLS
Client:
http://localhost:8080/api/client (GET): returns list of all clients
http://localhost:8080/api/client (POST): Adds new clients, returns new client created
{
    "name": "cch",
    "age": 23,
    "address": "123 serang St",
    "birthday": "2000-05-14T16:00:00.000+00:00",
    "company": "asrtar Inc."
}

http://localhost:8080/api/client/2 (GET) returns client with id 2
http://localhost:8080/api/client/getCase/1 (GET) returns all cases that client with id 1 has

http://localhost:8080/api/client/3 (PUT) Updates client with id 3, returns updated client
{
    "id": 0,
    "name": "cccc",
    "age": 22,
    "address": "333 serang St",
    "birthday": "2003-05-14T16:00:00.000+00:00",
    "company": "corp Inc."
}

