# Demo Spring Boot REST API

This is a Spring Boot Java project providing RESTful APIs for managing products and users. It follows best practices for MVC, JPA, and REST API design.

## Features
- CRUD operations for Users and Products
- H2 in-memory database (auto-populated with sample data)
- Pretty-printed JSON responses
- Java 8+ date/time support in JSON

## Requirements
- Java 17 or newer (Java 21 recommended)
- Maven 3.8+
- Git

## Setup
1. **Clone the repository:**
   ```sh
   git clone https://github.com/Nimakosa1/Demo.git
   cd Demo
   ```
2. **Ensure Java 17+ is installed:**
   ```sh
   java -version
   # Should show version 17 or newer
   ```
3. **Build the project:**
   ```sh
   ./mvnw clean package -DskipTests
   ```
4. **Run the application:**
   ```sh
   ./mvnw spring-boot:run
   ```
   The app will start on [http://localhost:8080](http://localhost:8080)

## API Endpoints
### Users
- `GET /users` — List all users
- `GET /users/{id}` — Get user by ID
- `POST /users` — Add user
- `PUT /users/{id}` — Update user
- `DELETE /users/{id}` — Delete user

### Products
- `GET /products` — List all products
- `GET /products/{id}` — Get product by ID
- `POST /products` — Add product
- `PUT /products/{id}` — Update product
- `DELETE /products/{id}` — Delete product

### Other
- `GET /` — Home endpoint (welcome message)
- H2 Console: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

## Example: Add a User
```sh
curl -X POST http://localhost:8080/users \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Diana Prince",
    "address": "100 Amazon Way",
    "country": "Greece",
    "username": "wonderwoman",
    "email": "diana@example.com"
  }'
```

## Example: Add a Product
```sh
curl -X POST http://localhost:8080/products \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Adobe Firefly",
    "description": "AI image generation tool",
    "category": "AI",
    "price": 29.99,
    "platform": "mac,windows",
    "release_date": "2025-06-05"
  }'
```

## License
MIT
