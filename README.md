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
* Java
* Spring Boot
* PostgreSQL
* Tomcat
* Nginx
* Docker
* Docker Compose
* Liquibase
* Lombok
* JUnit 5
* Maven checkstyle plugin

### Setup
*Project launch information:*

1. Clone this project
```
git clone https://github.com/lavryniuk-dev/company-management-service.git
```
2. Run the command to export environment variables
```
. ./sets/set-env.sh
```
3. Run the command to start the services
```
docker compose -f compose.prod.yml up -d --scale api=2
```
4. Perform HTTP requests to the available endpoints on localhost on port 8080 using Postman, Katalon Studio, etc.