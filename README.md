# Recipes Application - Modern Full Stack

A production-ready full-stack recipe management application built with cutting-edge technologies and best practices for security, performance, and maintainability.

## 🏗️ Project Structure

```
recipes/
├── recipes-app/          # Spring Boot 3.3 backend (Java 17)
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/recipes/
│   │   │   │   ├── RecipesApplication.java
│   │   │   │   ├── config/          # API and Data configuration
│   │   │   │   ├── controller/      # REST endpoints
│   │   │   │   ├── model/           # Entity models
│   │   │   │   └── service/         # Business logic
│   │   │   └── resources/           # Application properties
│   │   └── test/                    # Unit tests
│   ├── build.gradle                 # Gradle dependencies
│   ├── gradlew & gradlew.bat       # Gradle wrapper
│   └── README.md                    # Backend documentation
│
├── recipes-ui/          # Angular 18 frontend (TypeScript 5.3)
│   ├── src/
│   │   ├── app/
│   │   │   ├── app.component.*      # Root component
│   │   │   ├── app.module.ts        # Main module
│   │   │   ├── app-routing.module   # Routing
│   │   │   └── recipe.ts            # Data models
│   │   ├── assets/                  # Static images
│   │   ├── environments/            # Environment configs
│   │   └── index.html               # Entry point
│   ├── angular.json                 # Angular CLI config
│   ├── package.json                 # npm dependencies
│   ├── tsconfig.json                # TypeScript config (strict mode)
│   └── README.md                    # Frontend documentation
│
└── README.md            # This file
```

## 🚀 Quick Start

### Prerequisites

- **Java 17 LTS** or later
- **Node.js 18+** and npm 9+
- **MongoDB** (local or cloud instance)

### Backend Setup

```bash
cd recipes-app

# Build the project
./gradlew build

# Run in development mode (embedded MongoDB)
./gradlew bootRun

# Or run with Gradle tasks
./gradlew clean bootRun
```

The backend will start on `http://localhost:8080`

### Frontend Setup

```bash
cd recipes-ui

# Install dependencies
npm install

# Start development server with live reload
npm start

# Build for production
npm run build:prod
```

The frontend will open at `http://localhost:4200`

## 📚 Technology Stack

### Backend
| Technology | Version | Purpose |
|-----------|---------|---------|
| Spring Boot | 3.3.0 | Application framework |
| Java | 17 LTS | Runtime language |
| Spring WebFlux | 3.3.0 | Reactive web framework |
| MongoDB Reactive | 3.3.0 | NoSQL database driver |
| Jakarta EE | 3.0 | Validation & APIs |
| Lombok | 1.18.30 | Boilerplate reduction |
| Gradle | 8.6 | Build automation |

### Frontend
| Technology | Version | Purpose |
|-----------|---------|---------|
| Angular | 18.0.0 | Web framework |
| TypeScript | 5.3.3 | Type-safe JavaScript |
| RxJS | 7.8.1 | Reactive programming |
| Karma | 6.4.0 | Test runner |
| Jasmine | 5.1.0 | Testing framework |
| Angular CLI | 18.0.0 | Development tooling |

## 🔌 API Endpoints

All endpoints are prefixed with `/api/v1/recipes`

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/` | Get all recipes |
| GET | `/{recipeId}` | Get recipe by ID |
| POST | `/` | Create new recipe |
| PUT | `/{recipeId}` | Update existing recipe |
| DELETE | `/{recipeId}` | Delete recipe |

### Example Requests

```bash
# Get all recipes
curl http://localhost:8080/api/v1/recipes

# Get specific recipe
curl http://localhost:8080/api/v1/recipes/{recipeId}

# Create recipe
curl -X POST http://localhost:8080/api/v1/recipes \
  -H "Content-Type: application/json" \
  -d '{
    "recipeName": "Pasta Carbonara",
    "description": "Classic Italian pasta",
    "addedDate": "2024-06-30"
  }'

# Update recipe
curl -X PUT http://localhost:8080/api/v1/recipes/{recipeId} \
  -H "Content-Type: application/json" \
  -d '{
    "recipeName": "Updated Name",
    "description": "Updated description",
    "addedDate": "2024-06-30"
  }'

# Delete recipe
curl -X DELETE http://localhost:8080/api/v1/recipes/{recipeId}
```

## 🔐 Security Features

- ✅ **Restricted CORS** - Limited to specific origins (no wildcard)
- ✅ **Input Validation** - Jakarta constraints on all inputs
- ✅ **HTTP Status Codes** - Proper 200, 404, 400, 204 responses
- ✅ **Credentials Support** - CORS configured for auth headers
- ✅ **Strict TypeScript** - Full type safety on frontend
- ✅ **Environment Configuration** - Environment-based settings
- ✅ **Reactive Streams** - Non-blocking I/O with error handling

## 🧪 Testing

### Backend Tests

```bash
cd recipes-app

# Run all tests
./gradlew test

# Run specific test class
./gradlew test --tests RecipeControllerTest

# Run with coverage
./gradlew test --info
```

### Frontend Tests

```bash
cd recipes-ui

# Run tests (single run)
npm test

# Run tests in watch mode
npm test -- --watch

# Run with coverage
npm test -- --code-coverage
```

## 📦 Build & Deployment

### Backend Production Build

```bash
cd recipes-app
./gradlew build -x test    # Skip tests if needed
# Generated JAR: build/libs/recipes-app-1.0.0.jar
```

### Frontend Production Build

```bash
cd recipes-ui
npm run build:prod
# Generated artifacts: dist/recipes-ui/
# Bundle size target: 500KB (initial), 2KB per component
```

## 🛠️ Development

### Code Quality

```bash
# Frontend linting
cd recipes-ui
npm run lint

# Format code
npm run format
```

### IDE Configuration

- **IntelliJ IDEA**: Open `recipes-app/` as Gradle project
- **VS Code**: Install Angular extensions and ESLint
- **Lombok Support**: Enable annotation processing in IDE

### Hot Reload

**Backend**: Refresh will restart the Spring Boot app
**Frontend**: Changes auto-compile and refresh in browser

## 📝 Environment Configuration

### Backend (application.properties)

```properties
# MongoDB configuration
spring.data.mongodb.uri=mongodb://localhost:27017/recipes
spring.data.mongodb.auto-index-creation=true

# Server settings
server.port=8080
server.servlet.context-path=/

# Logging
logging.level.root=INFO
logging.level.com.recipes=DEBUG
```

### Frontend (environment.ts)

```typescript
export const environment = {
  production: false,
  apiUrl: 'http://localhost:8080/api/v1'
};
```

## 🐛 Troubleshooting

### Java Version Issue
```bash
# Verify Java version
java -version
# Should be 17 or later
```

### MongoDB Connection Error
```bash
# Ensure MongoDB is running
# For local development, embedded MongoDB is used automatically
```

### Frontend Build Errors
```bash
cd recipes-ui
rm -rf node_modules
npm install
npm start
```

### Gradle Daemon Issues
```bash
cd recipes-app
./gradlew --stop
./gradlew clean build
```

## 📖 Documentation

- [Backend Documentation](./recipes-app/README.md)
- [Frontend Documentation](./recipes-ui/README.md)

## 🔄 Project Updates

This project has been modernized with:
- ✅ Spring Boot 3.3 (from 2.1)
- ✅ Java 17 (from Java 8)
- ✅ Angular 18 (from Angular 9-21 mixed)
- ✅ TypeScript 5.3 (from 3.8)
- ✅ Gradle 8.6 (from 5.6)
- ✅ Jakarta EE (from javax)
- ✅ RxJS 7.8 (from 6.5)
- ✅ Latest security practices

## 📄 License

[Add your license here]

## 👥 Contributors

- Yurii Suprun

---

**Last Updated**: June 30, 2024
**Version**: 1.0.0
