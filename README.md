# kan-test

Automated test suite (UI + API) for the [Kan](app/README.md) project management application.

---

## Prerequisites

- [Docker Desktop](https://www.docker.com/products/docker-desktop/)
- [Java 21+](https://adoptium.net/)
- Microsoft Edge browser
- Gradle (or use the included `gradlew` wrapper)

---

## Starting the application

The `app/` directory is a Git submodule containing the Kan source code. The root `docker-compose.yml` builds and starts it locally.

### First-time setup

1. Create the environment file for the application:

```bash
cp app/.env.example app/.env
```

2. Build and start all services (app + database + migrations):

```bash
docker compose up --build
```

The app will be available at **http://localhost:3000**.

### Subsequent starts

Once the image is built, you can skip the build step:

```bash
docker compose up
```

### Stopping the application

```bash
docker compose down
```

> **Data persistence:** `docker compose down` keeps the database volume intact. Your data will be there when you start again. Only `docker compose down -v` deletes the volume — avoid this unless you intentionally want to wipe the database.

### Restarting a single service

```bash
docker compose restart web
```

### Rebuilding after source changes

If the Kan source code changes (e.g. after updating the submodule), rebuild the image:

```bash
docker compose up --build
```

### Updating the Kan submodule

To pull the latest version of Kan into this repo:

```bash
git submodule update --remote app
git add app
git commit -m "Update kan to latest"
```
---

## Running the tests

All commands are run from the repository root.

### Run all tests

```bash
./gradlew test
```

### Run only UI tests

```bash
./gradlew test --tests "ui.*"
```

### Run only API tests

```bash
./gradlew test --tests "api.*"
```

### Run a single test class

```bash
./gradlew test --tests "ui.BoardTests"
```

Test reports are generated at `target/build/reports/` after each run.

---

## Configuration

### Browser and timeouts — `src/main/resources/selenide.properties`

| Property | Default                | Description |
|---|------------------------|---|
| `selenide.baseUrl` | `http://localhost:3000` | Application URL |
| `selenide.browser` | `edge`                 | Browser to use |
| `selenide.browserSize` | `1600x1080`            | Viewport size |
| `selenide.headless` | `true`   | Run without UI |
| `selenide.timeout` | `10000`                | Element wait timeout (ms) |

### Test user — `src/test/resources/testData.properties`

The tests use a pre-existing user account seeded in the database:

| Property | Value |
|---|---|
| `user.email` | `joe@doe.com` |
| `user.password` | `joedoe123!` |
| `user.token` | API token for authenticated requests |

---

## Cloning this repository

Because `app/` is a Git submodule, clone with:

```bash
git clone --recurse-submodules <repository-url>
```

If you already cloned without the flag:

```bash
git submodule update --init
```
