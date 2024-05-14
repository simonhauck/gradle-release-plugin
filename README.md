# Gradle Release Plugin

[![Master](https://github.com/simonhauck/gradle-release-plugin/actions/workflows/on-master-push.yml/badge.svg)](https://github.com/simonhauck/gradle-release-plugin/actions/workflows/on-master-push.yml)

[Warning] This plugin is still in active development and not yet released.

The Gradle Release Plugin is a small tool designed to streamline and automate the release process for your Gradle
projects. The plugin will increment the version number, commit, tag and push the changes to the git repository and
increase the version again to a new snapshot version. It is inspired by
the [researchgate/release-plugin](https://github.com/researchgate/gradle-release), but
addresses some of its shortcomings and provides additional functionalities.

- **Multiple Release Types**: You can either directly specify the release version or use a simplified API and just
  select the release type. Let the plugin do the rest (this feature is still
  WIP, [issue](https://github.com/simonhauck/gradle-release-plugin/issues/15)).
- **Adaptable Release Workflow**: The plugin offers flexibility by allowing you to incorporate custom tasks into the
  release process to make it fit your specific projects requirements
- **Composite Build Support**: This plugin can be applied to projects with a composite build, addressing an issue
  found in the above-mentioned project issue](https://github.com/researchgate/gradle-release/issues/383).
- **Configuration Cache Support**: This plugin can be used in projects where the configuration cache is
  enabled [issue](https://github.com/researchgate/gradle-release/issues/346)

## Feature overview

Here is an overview of the planned features. To vote for an feature, either create an issue or give a thumbs up on an
existing issue.

| **Feature**                           | **Description**                                                                               | **Implemented** | **Related issues**                                                   |
|---------------------------------------|-----------------------------------------------------------------------------------------------|-----------------|----------------------------------------------------------------------|
| Release with explicit version numbers | Release with while providing explicit version numbers                                         | [ ] WIP         | [#3](https://github.com/simonhauck/gradle-release-plugin/issues/3)   |
| Simplified API                        | Release with a signle parameter like major, minor, patch                                      | [ ]             | [#15](https://github.com/simonhauck/gradle-release-plugin/issues/15) |
| Support Gitflow                       | The plugin should be able to perform merge commits from a development branch to a main branch | [ ]             | No issue created yet                                                 |
| Support Trunk based released          | The plugin can perform a release on a given branch                                            | [ ] WIP         | [#3](https://github.com/simonhauck/gradle-release-plugin/issues/3)   |
| Check for snapshot versions           | Add an optional check to verify the project does not use any snapshot versions.               | [ ]             | No issue created yet                                                 |

## How to use the plugin

### Configuration

Add a `version.properties` file to your project with the current version. An example is
shown [here](version.properties).

In your `build.gradle.kts` file, apply the plugin and configure it as shown below:

```kotlin
import io.github.simonhauck.release.version.api.Version

plugins {
    id("io.github.simonhauck.release") version "<the-current-version>"
}

release {
    versionPropertyFile.set(layout.projectDirectory.file("version.properties"))
}

// If you want to set the version in you gradle project you can use this helper method
version = Version.fromPropertiesFile(layout.projectDirectory.file("version.properties").asFile)
```

The plugin provides sensible defaults for the release process. If you want to customize the release process, have a look
at the [configuration options](release-plugin/src/main/kotlin/io/github/simonhauck/release/plugin/ReleaseExtension.kt).

### Trigger a release

#### Option 1: Specify the versions explicitly

You can trigger a release by running the following gradle
command  `./gradlew  release -PreleaseVersion=1.0.0> -PpostReleaseVersion=1.0.1-SNAPSHOT`. The plugin will first tag and
push a commit where `releaseVersion` is written in the `verion.properties` file and afterward a second commit with
the `postReleaseVersion`.

#### Option 2: Use the release type

[WIP] This feature is not yet fully implement. This feature is tracked in
this [issue](https://github.com/simonhauck/gradle-release-plugin/issues/15)

### Customizing the release process

TODO(Add documentation)

## How to contribute

Issues and pull requests are welcome. Please fill out the issue template and provide as much information as possible.
Please have a look at the [CONTRIBUTING.md](CONTRIBUTING.md) for more information.
