# Gradle Release Plugin

[![Master](https://github.com/simonhauck/gradle-release-plugin/actions/workflows/on-master-push.yml/badge.svg)](https://github.com/simonhauck/gradle-release-plugin/actions/workflows/on-master-push.yml)

[Warning] This plugin is still in active development and not yet released.

## How to start development

This plugin is inspired by the [researchgate/release-plugin](https://github.com/researchgate/gradle-release) but
addresses some of the shortcomings and provides additional functionalities.

- Can be applied to projects with a composite build [issue](https://github.com/researchgate/gradle-release/issues/383)
- Can be used in projects with configuration cache [issue](https://github.com/researchgate/gradle-release/issues/346)
- provides additional a simplified API - Just select the type of release you want to have. Let the plugin do the rest

### Important commands and development setup

- To format the code run `./gradlew format` and `./gradlew plugin:format` for the plugin
- To build the project use `./gradlew assemble` and `gradlew plugin:assemble` for the plugin
- To run all checks use `./gradlew check` and `./gradlew plugin:check` for the plugin
