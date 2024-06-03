# Logging Service

This uses springboot and and MySql as a database system.

## Features

- Logs events from other microservices

## Run Locally

Create a database schema on your MySQL named "logs_db"

```
CREATE DATABASE logs_db;
```

Clone the project

```bash
  git clone https://github.com/jc4balos/logging-service.git
```

Go to the project directory

```bash
  cd <my-project-directory>
```

On `storage-service\src\main\resources`, create a file named `secrets.properties` and apply configuration for the following:

```
spring.datasource.url=
spring.datasource.username=
spring.datasource.password=
server.port=
```

Clean and compile the project

```bash
  mvn clean
  mvn compile
```

Start the server (You may use springboot tools)

## API Reference

[Logging Service](https://voltesiv.postman.co/workspace/f79a4c53-0e6f-4352-8326-287d280bf697)

## Deployment

To create a build that will be used for deployment

```bash
  mvn package
```

Integrate the application using your API gateway.
