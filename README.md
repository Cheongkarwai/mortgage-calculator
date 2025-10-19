# Real Estate Backend

A Spring Boot reactive backend application for real estate management, powered by Spring AI and OpenAI integration.

## Tech Stack

- **Java 17**
- **Spring Boot 3.5.0**
- **Spring WebFlux** (Reactive web framework)
- **Spring AI 1.0.0** with OpenAI integration
- **Redis Stack** (Caching and data storage)
- **Lombok** (Code generation)
- **Maven** (Build tool)

## Prerequisites

- Java 17 or higher
- Maven 3.6+
- Docker and Docker Compose (for Redis)
- OpenAI API key

## Environment Variables

Set the following environment variables before running the application:

```bash
export OPENAI_BASE_URL=https://api.openai.com
export OPENAI_API_KEY=your-openai-api-key
```

## Getting Started

### 1. Start Redis

```bash
docker-compose up -d
```

This will start a Redis Stack container on port 6379 with password `test`.

### 2. Build the Application

```bash
./mvnw clean install
```

### 3. Run the Application

```bash
./mvnw spring-boot:run
```

The application will start on the default Spring Boot port (8080).

## Configuration

The application configuration is located in `src/main/resources/application.yml`:

- **Application Name**: real-estate-be
- **OpenAI Model**: gpt-4o
- **Logging**: DEBUG level enabled for Spring Web and Spring AI

## Project Structure

```
src/main/java/com/cheong/realestatebe/
├── config/        # Configuration classes
├── controller/    # REST controllers
├── converter/     # Data converters
├── dto/          # Data Transfer Objects
├── service/      # Business logic services
└── RealEstateBeApplication.java
```

## Development

### Running Tests

```bash
./mvnw test
```

### Maven Wrapper

The project includes Maven wrapper scripts:
- `./mvnw` (Unix/Linux/macOS)
- `mvnw.cmd` (Windows)

## Docker Services

### Redis Stack

- **Port**: 6379
- **Password**: test
- **Persistence**: Enabled (appendonly mode)
- **Data Volume**: `./data`

To connect to Redis CLI:

```bash
docker exec -it redis_container redis-cli
AUTH test
```

## License

This project is currently unlicensed.
