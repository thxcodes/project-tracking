# RESTful API that allows you to manage project tracking
This project built using **Java** and the following tools:
- [Spring Boot](https://spring.io/projects/spring-boot) as server side framework
- [Maven](https://maven.apache.org/) as build automation tool
- [Hibernate](https://hibernate.org/) as ORM / JPA implementation
- [MySQL](https://www.mysql.com/) as database implementation
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa) as the top layer over Hibernate
- [Flyway](https://flywaydb.org/) as db migration tool
- [Querydsl](http://www.querydsl.com/) as an alternative framework for dynamic queries

# Application Structure

### Model

Domain model is organized under the **model** package and it consists of entity classes. Entities use various annotations that describe the
relationships between each other. All these annotations are used by JPA in order to map entities to database tables.

### Repository

Repositories are interfaces that are responsible for data persistence and retrieval. The repository layer is an abstraction that provides all
CRUD functionality and keeps hidden the data related information (e.g. specific database implmentation) from the other layers. This layer
should always persist entities.

### Service

Service layer depends on the repository layer and provides separation of concern, encapsulating all the business logic implementation. It is
there to apply business rules on data sent to and from the repository layer. Service layer does not care about the specific database implementation
and provides loose coupling. This technique makes the application super flexible in a possible data source replacement.

### Controller

Controller layer depends on the service layer and is responsible for the incoming requests and the outgoing responses. A controller determines all the
available endpoints that client side (or other api) is able to call. This layer should not apply logic on the receiving or returning data.

# Quick Start

## Prerequisites

#### 1. Create a MySQL database

```
CREATE DATABASE taskdb;
```
In case you want to use a different database name, follow the next steps:
 -  ```
    CREATE DATABASE DB_NAME;
    ```
 - Open ```src/main/resources/application.properties``` file
 - Change ```db.name``` property to match your preferred database name DB_NAME

#### 2. Modify MySQL username and password

- Open ```src/main/resources/application.properties``` file
- Change ```spring.datasource.username``` and ```spring.datasource.password``` properties to match your MySQL connection

## Build project

Build the application using the following **gradle wrapper** command:
```
./gradle clean
```
In case you want to use this project as a dependency in other
projects locally, use the following command:
```
./gradlew clean build
```
Each of these commands will create an executable ```.jar``` file at ```target``` directory.

## Run project

After packaging the application into an executable ```.jar``` file, you can start the server running the following command using any terminal in the project directory:
```
java -jar target/projecttracking-0.0.1.jar
```
Alternatively, you can start the server without packaging, by running the following command:
```
gradle bootRun
```
The server will start running at http://localhost:8080/projecttracking.


# After running

Every time the server is running, it triggers the flyway migration tool to look for possible schema changes. The first time, flyway will create a table called
```schema_version```, in order to write down all the scripts have already run, in a versioning way. Additionally, it will run all the available scripts at
```src/main/resources/db/mysql/``` directory.  

After the first run, flyway will detect and run only the new scripts.


# API Documentation

When server is up and running, you can use swagger to explore the available endpoints and try them out. Find it at:
http://localhost:8080/projecttracking/swagger-ui.html#/

# License
This project is licensed under the terms of the MIT license. Check LICENSE file.
