# API RESTful for User Creation

API that allows user management, in this version user registration is allowed, it is implemented using Spring Boot, Hibernate, H2 Database and JWT that allows authentication. In addition to registering users, a JWT authentication token is generated.

## Features

- **User Registration**: Users can be registered with name, email, password and a list of phone numbers.
- **JWT Authentication**: The API uses JWT for authentication and endpoint protection.
- **Swagger Documentation**: The API is documented and can be explored with Swagger UI through http://localhost:8080/swagger-ui.html.

## Requirements

- **Java**: 8+
- **Gradle**: 8.9 or higher
- **IDE**: Developed with IntelliJ IDEA, but can be worked with Eclipse, Netbeans or any IDE compatible with Spring Boot

## Installation and Execution

1. **Clone the repository**:
   ```sh
   git clone https://github.com/david-caballero-cl/smartJob.git
   cd smartJob
    ```
   
2. **Run using gradlew**:
   
   ```sh
    ./gradlew bootRun
   ```
 
4. **Access to the application**:

The API will be available at http://localhost:8080
The Swagger UI interface will be available at http://localhost:8080/swagger-ui.html

4. ** Sample JSON**:
  ```sh
{
    "name": "David Caballero",
    "email": "davidcaballero@mail.org",
    "password": "password1",
    "phones": [
            {
            "number": "1234567",
            "cityCode": "11",
            "countryCode": "43"
            }
    ]
}
  ```
