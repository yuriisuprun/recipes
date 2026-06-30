# Recipes UI - Modern Angular 18 Application

A responsive recipe management frontend built with the latest Angular technologies.

## Technology Stack

- **Angular 18** - Latest Angular framework with modern compilation
- **TypeScript 5.3** - Strict type checking enabled
- **RxJS 7.8** - Reactive programming library
- **Karma + Jasmine** - Testing framework
- **Angular CLI 18** - Development CLI tooling

## Development Setup

### Prerequisites
- Node.js 18+ 
- npm 9+

### Installation

```bash
npm install
```

### Development Server

```bash
npm start
```

Navigate to `http://localhost:4200/`. The app automatically reloads on source file changes.

## Available Commands

```bash
# Development server with live reload
npm start

# Production build with optimizations
npm run build:prod

# Run unit tests (single run)
npm test

# Run linter
npm lint

# Generate new component
ng generate component component-name
```

## Build

### Development Build
```bash
npm run build
```

### Production Build
```bash
npm run build:prod
```

Build artifacts are stored in the `dist/` directory.

## Testing

Run `npm test` to execute unit tests via Karma with Jasmine framework.

## Code Quality

- Strict TypeScript compilation enabled
- Strict templates enabled for type safety
- ESLint for code linting

## Configuration

- **Development**: Hot module replacement, source maps enabled
- **Production**: Minified, optimized, tree-shaken, with smaller bundle size budget

## API Configuration

Update the backend API URL in `src/environments/environment.ts` and `src/environments/environment.prod.ts` as needed.

## Browser Support

- Chrome (latest)
- Firefox (latest)
- Safari (latest)
- Edge (latest)
