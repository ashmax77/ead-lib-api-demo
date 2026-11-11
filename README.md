# Library API

This project is a practice demo for learning how to build REST APIs with
Spring Boot. It provides a simple library service for creating, viewing,
updating, and deleting books.

## Features

- RESTful CRUD operations for books
- Spring Web MVC controllers
- Spring Data JPA persistence
- MySQL database integration
- Request validation for book title, author, and price

## API Endpoints

All endpoints are available under `/api/books`.

| Method | Endpoint | Description |
| --- | --- | --- |
| `GET` | `/api/books` | Get all books |
| `GET` | `/api/books/{id}` | Get a book by ID |
| `POST` | `/api/books` | Create a book |
| `PUT` | `/api/books/{id}` | Update a book |
| `DELETE` | `/api/books/{id}` | Delete a book |

Example request body:

```json
{
  "title": "The Hobbit",
  "author": "J. R. R. Tolkien",
  "isbn": "9780547928227",
  "price": 12.99
}
```

## Technologies

- Java 21
- Spring Boot
- Spring Web MVC
- Spring Data JPA
- MySQL
- Maven

## Running with Docker Compose

Docker Compose runs the API and MySQL database together. The API connects to
the database using the Compose service name `db`, while the database remains
available from the host on port `3307`.

1. Copy the environment template and set the database root password:

   ```powershell
   Copy-Item .env.example .env
   ```

2. Build and start both services:

   ```powershell
   docker compose up --build -d
   ```
3. Check service status and API logs:

   ```powershell
   docker compose ps
   docker compose logs api
   ```

The API is available at `http://localhost:8080`. The books endpoint is
`http://localhost:8080/api/books`, and Swagger UI is available at
`http://localhost:8080/swagger-ui.html`.

To stop and recreate the containers while preserving database records:

```powershell
docker compose down
docker compose up -d
```

The named `library-data` volume preserves MySQL data. To remove the volume
and all stored records, run `docker compose down -v`.

For MySQL Workbench or another host client, connect to `localhost:3307` with
username `root`, database `library_db`, and the password from `.env`.

## Running Locally

1. Create a MySQL database named `library`.
2. Update the database connection settings in
   `src/main/resources/application.yaml` for your local environment.
3. Start the application with Maven:

   ```bash
   ./mvnw spring-boot:run
   ```

   On Windows, use:

   ```powershell
   .\mvnw.cmd spring-boot:run
   ```

The API will be available at `http://localhost:8080`.

## Project Purpose

This is an educational practice project rather than a production-ready
application. It is intended for experimenting with REST API concepts,
Spring Boot controllers, service layers, repositories, validation, and
database persistence.
