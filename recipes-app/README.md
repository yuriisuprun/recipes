# Recipes App - Modern Full Stack Application

A full-stack recipe management application built with cutting-edge technologies.

## Backend Stack

- **Java 17** - Latest LTS Java version with modern language features
- **Spring Boot 3.3** - Latest Spring Boot with native compilation support
- **Spring WebFlux** - Reactive, non-blocking I/O with Reactor
- **MongoDB Reactive** - Async MongoDB driver with reactive streams
- **Jakarta EE** - Modern Jakarta validation and APIs
- **Lombok** - Boilerplate reduction with annotation processing
- **Gradle 8+** - Modern build automation

## Frontend Stack

- **Angular 18** - Latest Angular with standalone components and signals
- **TypeScript 5.3** - Strict mode with enhanced type safety
- **RxJS 7.8** - Reactive programming with latest Observables
- **Karma + Jasmine** - Modern testing framework
- **Angular CLI 18** - Latest development tooling

## Key Improvements

### Backend Refactoring
- Upgraded to Spring Boot 3.3 with Java 17 target
- Implemented Jakarta EE validation annotations
- Added request/response error handling with proper HTTP status codes
- Improved CORS configuration with restricted origins
- Enhanced reactive streams with proper error propagation
- Added Lombok annotations for cleaner code
- Fixed API endpoints with proper path variables

### Frontend Refactoring
- Updated to Angular 18 with modern compilation
- Strict TypeScript compilation enabled
- Improved bundle size budgets (500KB initial, 2KB component styles)
- SCSS support configured
- Modern test runner configuration
- Development and production build configurations

## Security Enhancements

- Restricted CORS to specific origins instead of wildcard
- Proper HTTP response handling
- Input validation with Jakarta constraints
- Environment-based configuration
- Credentials support in CORS

## Build & Run

### Backend
```bash
cd recipes-app
./gradlew build
./gradlew bootRun
```

### Frontend
```bash
cd recipes-ui
npm install
npm start
```

## API Endpoints

- `GET /api/v1/recipes` - List all recipes
- `GET /api/v1/recipes/{recipeId}` - Get recipe by ID
- `POST /api/v1/recipes` - Create new recipe
- `PUT /api/v1/recipes/{recipeId}` - Update recipe
- `DELETE /api/v1/recipes/{recipeId}` - Delete recipe
