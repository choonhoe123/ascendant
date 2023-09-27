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

To start:
git clone https://github.com/choonhoe123/ascendant.git in intellij
create my sql schema "ascendant" in mysql workbench
run dummyDataInit.sql in intellij ascendant\dummyDataInit.sql in intellij
warning shows and click setup db connector and fill in username and password in intellij
click on execute SQL script in intellij
under ascendant\src\main\resources\application.properties, change to personal sql username and password 
build in intellij
run: ascendant\AscendantApplication.java in intellij
check mysql table and refresh table in  mysql workbench
use postman to do api call

**API CALLS**

**Client:**

http://localhost:8080/api/client (GET): returns list of all clients

http://localhost:8080/api/client (POST): Adds new clients, returns Response.ok/badRequest()
{
    "name": "cch",
    "age": 23,
    "address": "123 serang St",
    "birthday": "2000-05-14T16:00:00.000+00:00",
    "company": "asrtar Inc."
}

http://localhost:8080/api/client/2 (GET): returns client with id 2

http://localhost:8080/api/client/getCase/1 (GET): returns all cases that client with id 1 has

http://localhost:8080/api/client/3 (PUT): Updates client with id 3, returns updated client
{
    "name": "cccc",
    "age": 22,
    "address": "333 serang St",
    "birthday": "2003-05-14T16:00:00.000+00:00",
    "company": "corp Inc."
}

**Case:**

http://localhost:8080/api/case (GET): returns all Cases

http://localhost:8080/api/case (POST): Adds new clients, returns Response.ok/badRequest()
{
"title": "Sample Case 5",
"msg": "This is the fifth case",
"client": {
"clientId": 4
}
}

http://localhost:8080/api/case/2 (GET): returns Case with id 2

http://localhost:8080/api/case/getClient/2 (GET):Returns the client with the Case with case id 2

http://localhost:8080/api/case/2 (PUT): update the Case with the case id 2
{
"title": "Sample Case 5",
"msg": "This is the fifth case updated",
"client": {
"clientId": 4
}
}

http://localhost:8080/api/case/case/endCase/4 (PUT): Change case id 4 from in progress to completed

http://localhost:8080/api/case/allOutstanding (GET): get all outstanding cases

http://localhost:8080/api/case/allCompleted (GET): get all completed cases

**ERD**

Client
-------
ClientID (Primary Key)
Name
Age
Address
Birthday
Company

Case
-----
CaseID (Primary Key)
CreateDate
Title
Message
StatusEnum
EndDate

Relationships:
- One Client can have many Cases (One-to-Many relationship)
  Client(ClientID) ----< Case(Client)

StatusEnum
IN_PROGRESS
COMPLETED

Challenges:
Settling the dependencies in the pom.xml file
