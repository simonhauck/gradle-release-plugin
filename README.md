# Gradle Release Plugin

[![Main](https://github.com/simonhauck/gradle-release-plugin/actions/workflows/on-main-push.yml/badge.svg)](https://github.com/simonhauck/gradle-release-plugin/actions/workflows/on-main-push.yml)
[![Plugin Portal](https://img.shields.io/maven-metadata/v/https/plugins.gradle.org/m2/io/github/simonhauck/release/io.github.simonhauck.release.gradle.plugin/maven-metadata.xml?label=Gradle%20Plugin%20Portal&colorB=brightgreen&logo=gradle)](https://plugins.gradle.org/plugin/io.github.simonhauck.release)


<!-- TOC -->

* [Gradle Release Plugin](#gradle-release-plugin)
    * [Feature overview](#feature-overview)
    * [How to use the plugin](#how-to-use-the-plugin)
        * [Prerequisites](#prerequisites)
        * [Configuration](#configuration)
        * [Trigger a release](#trigger-a-release)
            * [Option 1: Specify the versions explicitly](#option-1-specify-the-versions-explicitly)
            * [Option 2: Use the release type](#option-2-use-the-release-type)
        * [Customizing the release process](#customizing-the-release-process)
        * [Parameter specification](#parameter-specification)
        * [Example with GitHub Actions](#example-with-github-actions)
    * [How to contribute](#how-to-contribute)

<!-- TOC -->


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
- **Composite Build Support**: This plugin can be applied to projects with a composite build, addressing
  an [issue](https://github.com/researchgate/gradle-release/issues/383)
  found in the above-mentioned project.
- **Configuration Cache Support**: This plugin can be used in projects where the configuration cache is
  enabled [issue](https://github.com/researchgate/gradle-release/issues/346)

## Feature overview

Here is an overview of the planned features. To vote for a feature, either create an issue or give a thumbs up on an
existing issue.

| **Feature**                           | **Description**                                                                               | **Implementation Status** | **Related issues**                                                   |
|---------------------------------------|-----------------------------------------------------------------------------------------------|---------------------------|----------------------------------------------------------------------|
| Release with explicit version numbers | Release with while providing explicit version numbers                                         | :white_check_mark:        | [#3](https://github.com/simonhauck/gradle-release-plugin/issues/3)   |
| Support Trunk based released          | The plugin can perform a release on a given branch                                            | :white_check_mark:        | [#3](https://github.com/simonhauck/gradle-release-plugin/issues/3)   |
| Simplified API                        | Release with a single parameter like major, minor, patch                                      | :white_check_mark:        | [#15](https://github.com/simonhauck/gradle-release-plugin/issues/15) |
| Support Gitflow                       | The plugin should be able to perform merge commits from a development branch to a main branch | :x:                       | No issue created yet                                                 |
| Check for snapshot versions           | Add an optional check to verify the project does not use any snapshot versions.               | :x:                       | No issue created yet                                                 |

## How to use the plugin

Here is quick guide on how to get started using this plugin.

### Prerequisites

1. Git: In order to perform the different git operations the plugin requires git to be available in the path
2. Version properties file: A version file must be available. The file should contain a key `version` which contains the
   current project version as in this example [here](version.properties). The plugin will write the updated version
   there. By default, the file should be located in the root project and be named `version.properties`. You can change
   the name and location with the configuration.

### Configuration

In your `build.gradle.kts` file, apply the plugin and configure it as shown below:

```kotlin
// build.gradle.kts
import io.github.simonhauck.release.version.api.Version

plugins {
    id("io.github.simonhauck.release") version "<the-current-version>"
}

val versionFile = layout.projectDirectory.file("version.properties")

release {
    versionPropertyFile.set(versionFile)
}

// If you want to set the version in you gradle project you can use this helper method
version = Version.fromPropertiesFile(versionFile.asFile)
```

The plugin provides sensible defaults for the release process. If you want to customize the release process, have a look
at the [configuration options](#parameter-specification).

### Trigger a release

If you have a project layout as described in the [prerequisites](#prerequisites) section, you can already start
releasing. The plugin will provide several ways to how to set the new version.

In all cases, the plugin will create two commits. The first commit will contain the release version. This commit will be
tagged and pushed. Afterward, a second commit with the post release version will be performed and pushed. Typically, you
want to set here the next snapshot version.
If you are running this in an CI environment, these commits can trigger a new build where you can perform
additional release logic. An example for GitHub actions is shown [here](#example-with-github-actions)

If your want to test your configuration locally without bothering your team with constant commits, you can
disable the push with the shown configuration. It will still generate commits and tags, but you can delete them locally
afterward.

```kotlin
// build.gradle.kts
release {
    disablePush = true
}
```

#### Option 1: Specify the versions explicitly

The first option is to specify the release and post release version explicitly. For this you can use the following
gradle command
You can trigger a release by running the following gradle command

```shell
./gradlew release -PreleaseVersion=1.0.0 -PpostReleaseVersion=1.0.1-SNAPSHOT
```

Replace the values for the `releaseVersion` and `postReleaseVersion` with your desired target values.

#### Option 2: Use the release type

If you have a [semver](https://semver.org/) compatible version you can choose to use the simplified api.

```shell
./gradlew release -PreleaseType=<release-type>
```

Replace the _release-type_ with ``major``, ``minor`` or ``patch``. This will determine the version automatically.

### Customizing the release process

You can quite easily customize the release process by adding additional tasks to the release process and make the
relevant tasks depend on your custom tasks. Here are the most interesting tasks:

1. _writeReleaseVersion_: This tasks writes the release version in your version file.
2. _commitReleaseVersion_: This task will create a tagged commit with the release version.
3. _pushRelease_: This task will perform the push operation.
4. _writePostReleaseVersion_: This task with write the post release version in your version file.
5. _commitPostReleaseVersion_: This task will commit the post release version. This is not tagged.
6. _pushPostRelease_: This task will push the post release version.

Please note: The plugin will just write the version in the specified version file. Gradle will not automatically reload
the version property. The `version` variable from gradle will still show the old version. If you need the
version for your custom task, you either have to read the version directly from the file or run multiple gradle
commands.

Let's assume, you want to write an additional file during the release. You could register your custom task and make the
commit release version task depend on that. If you want to commit this file with the release commit, you can edit the
_git add_ command in the `release` configuration to include both the version file and your custom file. An example for
that is shown below:

```kotlin
// build.gradle.kts

// Modify the git add command to include your file. You have to specify all files (including the version file). 
// By default, this is just the version file.
release {
    releaseCommitAddFiles.set(listOf(file("version.properties"), file("release-file.txt")))
}

// This is your custom task
val customTask = tasks.register("myCustomTask") {
    // If you want to do something with the version, depend on the writeReleaseVersion task
    dependsOn(tasks.writeReleaseVersion)
    val outputFile = layout.projectDirectory.file("release-file.txt")

    doLast { outputFile.asFile.writeText("value") }
}


// The commit task should depend on your task
tasks.commitReleaseVersion { dependsOn(customTask) }
```

### Parameter specification

Here are all parameters listed for the `release` extension. The plugin provides sensible defaults for all parameters, so
you can start without any configuration.

| **Parameter Name**          | Type         | **Description**                                                                                                  | **Default value**                         |
|-----------------------------|--------------|------------------------------------------------------------------------------------------------------------------|-------------------------------------------|
| _rootGitDirectory_          | RegularFile  | The root of your git project.                                                                                    | <gradle-project-dir>                      |
| _versionPropertyFile_       | RegularFile  | The file containing the version. The content should contain _version=<your-version>_                             | <gradle-project-dir>/version.properties   |
| _releaseCommitAddFiles_     | List\<File>  | The files that should be added for the release commit                                                            | [<gradle-project-dir>/version.properties] |
| _releaseCommitMessage_      | String       | The commit message used for the release commit. The key {version} is replaced with the release version           | "Release commit: v{version}"              |
| _postReleaseCommitAddFiles_ | List \<File> | The files that should be added for the post release commit                                                       | <gradle-project-dir>/version.properties   |
| _postReleaseCommitMessage_  | String       | The commit message used for the post release commit. The key {version} is replaced with the post release version | "Post release commit: v{version}"         |
| _commitMessagePrefix_       | String       | A prefix that is added for all commits                                                                           | ""                                        |
| _tagName_                   | String       | The name for the release tag. The key {version} is replaced with the release version                             | v{version}                                |
| _sshKeyFile_                | RegularFile  | A location to an ssh key file. If the value is null, the standard git authentication methods are used            | null                                      |
| _disablePush_               | Boolean      | Disable the actual push operation. This is useful for local testing / development                                | false                                     |
| _delayBeforePush_           | Duration     | Some systems aggregate commits that are done to qickly. You can specify a delay before the second push operation | Duration.ZERO                             |

### Example with GitHub Actions

You can use this plugin with any CI/CD system. Here is an example how you can use this plugin with GitHub actions.

The general workflow will be:

1. Trigger a release with a manual job
2. For tagged commits, run your release procedure like publishing the artifacts.

To trigger the release you can take inspiration from the following configuration. This task has two inputs for the
release version and post release version.

```yaml
# .github/workflows/trigger-release.yml
name: Trigger Release

on:
  workflow_dispatch:
    inputs:
      release-version:
        description: 'The version with which the code should be released'
        type: string
        required: true
      post-release-version:
        description: 'The next snapshot version'
        type: string
        required: true


jobs:
  trigger-release:
    runs-on: ubuntu-latest
    name: Trigger the release
    steps:
      - name: Checkout repository
        uses: actions/checkout@v4
        with:
          # It is important to perform the checkout with an access token. Only with that can the commit trigger a new build!          
          token: ${{secrets.PERSONAL_ACCESS_TOKEN}}

      # Your setup actions

      # Set the git username and email for the commit
      - name: Set Git User and Email
        run: |
          git config --global user.email "no-replay@github-action.de"
          git config --global user.name "GitHub Action"

      - name: Run gradle release task
        run: ./gradlew release -PenablePush=true -PreleaseVersion=${{ github.event.inputs.release-version }} -PpostReleaseVersion=${{ github.event.inputs.post-release-version }} --no-daemon
```

To do something with the release add another workflow file that is triggered with a tag is pushed.

```yaml
# .github/workflows/on-release-tag.yml

name: Release

on:
  push:
    tags:
      - v*

jobs:
  release:
  # Your jon configuration
```

## How to contribute

Issues and pull requests are welcome. Please fill out the issue template and provide as much information as possible.
Please have a look at the [CONTRIBUTING Guide](CONTRIBUTING.md) for more information.
