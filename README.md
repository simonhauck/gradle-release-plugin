## How to start development

[![Master](https://github.com/simonhauck/gradle-semantic-versioning/actions/workflows/on-master-push.yml/badge.svg)](https://github.com/simonhauck/gradle-semantic-versioning/actions/workflows/on-master-push.yml)

### How to use this Template

Clone this repository or use it as a template via GitHub. Afterward change the project name in the
root `settings.gradle.kts`.

### Important commands and development setup

Run the following command before starting frontend development:

```shell
./gradlew prepareEnv
```

After changing the backend API run the following command:

```shell
./gradlew generateOpenApiDocs
```

Run this command to format frontend and backend code

```shell
./gradlew format
```

Run this command to check the format in frontend and backend code

```shell
./gradlew checkFormat
```

To assemble all artifacts run

```shell
./gradlew assemble
```

To run all tests/checks run

```shell
./gradlew check
```