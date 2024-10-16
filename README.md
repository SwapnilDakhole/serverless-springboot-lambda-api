

# Spring Boot AWS Lambda Employee Management System

This repository contains a Spring Boot application deployed as an AWS Lambda function, providing an employee management system. The application is built with Spring Boot, Spring Data JPA, and MySQL, integrated with AWS services to offer a serverless architecture.

## Table of Contents
- [Features](#features)
- [Technologies](#technologies)
- [Configuration](#configuration)
- [Setup](#setup)
- [Endpoints](#endpoints)

## Features
- Manage course data (CRUD operations).
- AWS Lambda integration for serverless deployment.
- MySQL database for persistent course information.
- REST API endpoints for interacting with the course data.
- Spring Data JPA for seamless database operations.

## Technologies
- **Java**: 17 or higher
- **Spring Boot**: 3.2.6
- **Spring Data JPA**: For data persistence
- **MySQL**: Database for course data
- **AWS Lambda**: Serverless architecture
- **AWS RDS**: MySQL database hosted on AWS
- **Lombok**: For reducing boilerplate code

## Configuration
The application can be configured through the `application.properties` file:

```properties
spring.datasource.url=jdbc:mysql://<your-rds-endpoint>:3306/employee
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=<your-username>
spring.datasource.password=<your-password>
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

For AWS Lambda deployment, ensure you configure your AWS credentials appropriately.

## Setup

### Prerequisites
- Java 17+
- Maven
- AWS CLI configured with appropriate access
- MySQL database instance (preferably hosted on AWS RDS)

### Steps to Run Locally
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/springboot-lambda-employee-management.git
   ```
2. Update the `application.properties` with your MySQL database credentials.
3. Build the application:
   ```bash
   mvn clean package
   ```
4. Run the application locally:
   ```bash
   mvn spring-boot:run
   ```

### Steps to Deploy on AWS Lambda
1. Build the shaded JAR for AWS Lambda:
   ```bash
   mvn package -Pshaded-jar
   ```
2. Use the AWS CLI or AWS Management Console to upload the generated JAR to AWS Lambda.
3. Set up your Lambda function's handler to `org.example.StreamLambdaHandler`.

## Endpoints

### Base URL
The base URL is dependent on the AWS API Gateway (if used) or the local environment (e.g., `http://localhost:8080`).

### Available Endpoints
- `POST /courses` - Add a new course
- `GET /courses` - Retrieve all courses
- `GET /courses/{id}` - Retrieve a course by its ID
- `PUT /courses/{id}` - Update an existing course
- `DELETE /courses/{id}` - Delete a course by ID
