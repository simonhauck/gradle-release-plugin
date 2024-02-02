## How to start development

[![Master Build](https://github.com/crypto-juenger/startup-template/actions/workflows/on-master-push.yml/badge.svg)](https://github.com/crypto-juenger/startup-template/actions/workflows/on-master-push.yml)

### Setup

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