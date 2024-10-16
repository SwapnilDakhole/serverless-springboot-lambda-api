
---

# Serverless Spring Boot API with AWS Lambda

This project demonstrates a Spring Boot application integrated with AWS Lambda to build a serverless API. The application manages employee and course data, stores records in a MySQL database, and utilizes AWS Lambda to serve HTTP requests.

## Table of Contents
- [Features](#features)
- [Technologies](#technologies)
- [Configuration](#configuration)
- [Setup](#setup)
- [Endpoints](#endpoints)
- [Deployment](#deployment)

## Features
- Serverless architecture using AWS Lambda.
- CRUD operations for Course and Employee entities.
- MySQL database integration with Spring Data JPA.
- Lightweight and scalable API with Spring Boot 3.
- Fully managed serverless container using AWS.

## Technologies
- **Java**: 17
- **Spring Boot**: 3.2.6
- **Spring Data JPA**: For database interaction
- **AWS Lambda**: For serverless execution
- **AWS API Gateway**: For routing API requests
- **MySQL**: As the database for storing data
- **Maven**: For project build and dependencies management
- **Lombok**: For reducing boilerplate code

## Configuration
The application uses `application.properties` for database configuration and logging. You can modify these properties based on your AWS setup and database credentials.

```properties
# MySQL Database Configuration
spring.datasource.url=jdbc:mysql://your-db-endpoint.amazonaws.com:3306/employee
spring.datasource.username=admin
spring.datasource.password=your_password

# Hibernate settings
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Logging
logging.level.root=WARN
```

## Setup
1. Clone the repository:
    ```bash
    git clone https://github.com/your-username/serverless-springboot-lambda-api.git
    cd serverless-springboot-lambda-api
    ```

2. Configure your database connection in `src/main/resources/application.properties`.

3. Build the project using Maven:
    ```bash
    mvn clean install
    ```

4. Deploy to AWS Lambda using your preferred deployment method (e.g., AWS Console, AWS SAM, or AWS CLI).

## Endpoints

### Courses API
- **POST** `/courses` - Add a new course
- **GET** `/courses` - Get all courses
- **GET** `/courses/{id}` - Get course by ID
- **PUT** `/courses/{id}` - Update course by ID
- **DELETE** `/courses/{id}` - Delete course by ID

### Employees API (similar structure for employees)

## Deployment
To deploy the project on AWS Lambda, use the `StreamLambdaHandler` class provided in the project. Ensure you package the application correctly with the necessary dependencies using the Maven Shade plugin.

```bash
mvn package -Pshaded-jar
```

You can then upload the JAR file to AWS Lambda and configure the API Gateway for routing.

---

