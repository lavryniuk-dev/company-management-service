# Company-Management-Service

### General info
This project implements simple RESTfull web service for internal management of the IT company.
You can perform CRUD operations on a projects and employees.
Employee have different levels (Junior/Middle/Senior) and types (Developer, QA, DevOps). 
All of them can work on several projects at the same time.

Project based on 3-tier architecture (Presentation layer,
Service layer, Data access layer). 
For one of the requirements the application is covered by 30% tests
(Intellij idea shows 37% coverage of methods and 33% lines).

### Application functionality
```
- Create employees
- Create projects and link with employees
- Get all projects where employee work / Get all project workers
- Get all employees (and by id) / Get all projects (and by id)
- Update info about employees and projects
- Delete employee (and all employees) / Delete employee from project / Delete project
```

### Endpoints
*Available endpoints in the project:*
* POST: api/employees | Create an employee (required fields: name, surname, level, type)
* POST: api/employees/{employeeId}/projects | Create project (required fields: name, description) and link with an employee (if project exists you can send just its id for link with an employee)
* GET: api/employees/{employeeId}/projects | Get all projects on which employee work
* GET: api/projects/{projectId}/employees | Get all employees who work on the project
* GET: api/employees | Get all employees
* GET: api/employees/{employeeId} | Get an employee with projects his work on
* GET: api/projects | Get all projects
* GET: api/projects/{projectId} | Get an project
* PUT: api/projects/{projectId} | Update info about an project
* PUT: api/employees/{employeeId} | Update info about an employee
* DELETE: api/employees | Delete all employees
* DELETE: api/employees/{employeeId} | Delete an employee by id
* DELETE: api/employees/{employeeId}/projects/{projectId} | Delete employee from the project
* DELETE: api/projects/{projectId} | Delete project (before that unlink employees from this project)

### Technologies
*The following stack of technologies was used in the project:*
* JUnit 5
* Lombok
* Liquibase
* Postgresql
* Spring Boot Core
* Spring Boot Web
* Spring Boot Data JPA
* Maven checkstyle plugin

### Setup
*Project launch information:*
```
- Install IntelliJ IDEA Ultimate or other IDE
- Install Postgresql and create database
- Clone this project
- Add your connection url, username and password credentials
for connection to Postgres DB in application.properties file
- Run the application
- Execute the requests using an HTTP-client (Postman, Katalon Studio, etc)
```