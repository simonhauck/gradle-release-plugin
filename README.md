# Gradle Release Plugin

[![Main](https://github.com/simonhauck/gradle-release-plugin/actions/workflows/on-main-push.yml/badge.svg)](https://github.com/simonhauck/gradle-release-plugin/actions/workflows/on-main-push.yml)
[![Plugin Portal](https://img.shields.io/maven-metadata/v/https/plugins.gradle.org/m2/io/github/simonhauck/release/io.github.simonhauck.release.gradle.plugin/maven-metadata.xml?label=Gradle%20Plugin%20Portal&colorB=brightgreen&logo=gradle)](https://plugins.gradle.org/plugin/io.github.simonhauck.release)

The Gradle Release Plugin is a small tool designed to streamline and automate the release process for your Gradle
projects. The plugin will increment the version number, commit, tag and push the changes to the git repository and
increase the version again to a new snapshot version. It is inspired by
the [researchgate/release-plugin](https://github.com/researchgate/gradle-release), but
addresses some of its shortcomings and provides additional functionalities.

- **Multiple Release Types**: You can either directly specify the release version or use a simplified API and just
  select the release type. Let the plugin do the rest.
- **Adaptable Release Workflow**: The plugin offers flexibility by allowing you to incorporate custom tasks into the
  release process to make it fit your specific project requirements
- **Composite Build Support**: This plugin can be applied to projects with a composite build, addressing
  an [issue](https://github.com/researchgate/gradle-release/issues/304)
  found in the above-mentioned project.
- **Configuration Cache Support**: This plugin can be used in projects where the configuration cache is
  enabled [issue](https://github.com/researchgate/gradle-release/issues/346)

## How to use the plugin

Here is quick guide on how to get started using this plugin.

### Prerequisites

1. Git: In order to perform the different git operations the plugin requires git to be available in the path
2. Version properties file: A file with a containing a key `version` and as value the current project version (like in
   this example[example](version.properties)). By default, the file should be located in the root project and be named
   `version.properties`. You can change the name and location with the configuration.
3. Gradle: Version 8.2 or higher

### Configuration

In your `build.gradle.kts` file, apply the plugin and configure it as shown below:

```kotlin
// build.gradle.kts
import io.github.simonhauck.release.version.api.Version

plugins {
    id("io.github.simonhauck.release") version "<the-current-version>"
}

release {
    // Here you can apply additional configuration
}

// If you want to set the version in you gradle project you can use this helper method
version = Version.fromPropertiesFile(layout.projectDirectory.file("version.properties"))
```

The plugin provides sensible defaults for the release process. If you want to customize the release process, have a look
at the [configuration options](#configuration-options).

### Trigger a release

If you have a project layout as described in the [prerequisites](#prerequisites) section, you can already start
releasing. The plugin provides several ways to set the new version.

You can set the release and post-release version explicitly with the following gradle command:

```shell
./gradlew release -PreleaseVersion=1.0.0 -PpostReleaseVersion=1.0.1-SNAPSHOT
```

Alternately, if you have a [semver](https://semver.org/) compatible version you can use the simplified API:

```shell
# Current version: 1.0.0, release-type=major -> Release Version: 2.0.0, Post Release Version: 2.0.1-SNAPSHOT
./gradlew release -PreleaseType=<release-type>

# Or 

# Current version: 1.0.0, release-type=major, preReleaseType=RC -> Release Version: 2.0.0-RC1, Post Release Version: 1.0.0
./gradlew release -PreleaseType=<release-type> -PpreReleaseType=<pre-release-type>
```

Replace the _release-type_ with ``major``, ``minor`` or ``patch``. This will determine the version automatically.
The _pre-release-type_ is an optional string (e.g. ALPHA). If set, the plugin will automatically apply a counter based
on the existing git tags and set the post release version back to the current project version, so when you create the "
final" release, you can select the same release type - just without the _pre-release-type_.

### What does the plugin do?

The plugins checks, that you do not have uncommited file changes and do not depend on snapshot or pre-release versions.
If these checks pass, the plugin will create two commits. The first commit will contain the release version. This commit
will be
tagged and pushed. Afterward, a second commit with the post release version will be performed and pushed. Typically, you
want to set the next snapshot version here.
If you are running this in an CI environment, these commits can trigger a new build where you can perform
additional release logic. An example for GitHub actions is shown [here](#example-with-github-actions).

If your want to test your configuration locally without bothering your team with constant commits, you can
disable pushes with the shown configuration. It will still generate commits and tags, but you can delete them locally
afterward.

```kotlin
// build.gradle.kts
release {
    disablePush = true
}
```

### Configuration options

The `release` class provides several configuration options for customizing the release process. Below are the available
properties and if not optional their default values:

```kotlin
release {
    // Project properties
    rootGitDirectory.set(layout.projectDirectory.file("./")) // Root directory of the Git repository
    versionPropertyFile.set(layout.projectDirectory.file("version.properties")) // File containing the version information

    // Check for snapshot / pre-release versions
    checkForPreReleaseVersions.set(true) // Enable/disable pre-release version checks
    ignorePreReleaseDependenciesFile.set(null) // File listing dependencies to ignore for pre-release checks in form of group:name
    ignorePreReleaseDependencies.set(emptyList()) // List of dependencies to ignore for pre-release checks in form of group:name

    // Check for uncommitted files
    checkForUncommittedFiles.set(true) // Enable/disable uncommitted files check

    // Git config
    gitName.set(null) // If not set, uses the host Git name
    gitEmail.set(null) //  If not set, uses the host Git email
    sshKeyFile.set(null) // SSH key file for Git operations, if not set uses the host authentication
    commitMessagePrefix.set("") // Prefix for commit messages
    disablePush.set(false) // Disable pushing commits to the remote repository. Useful for local testing

    // Release commit
    releaseCommitAddFiles.set(listOf(file("version.properties"))) // Files to add in the release commit
    tagName.set("v{version}") // Tag name format for the release
    releaseCommitMessage.set("Release commit: v{version}") // Commit message for the release

    // Post release commit
    postReleaseCommitAddFiles.set(listOf(file("version.properties"))) // Files to add in the post-release commit
    postReleaseCommitMessage.set("Post release commit: v{version}") // Commit message for the post-release
    delayBeforePush.set(Duration.ofSeconds(0)) // Delay before pushing the second commit. Some systems aggregate commits that are to close together
}
```

### Example with GitHub Actions

You can use this plugin with any CI/CD system. Here is an example how you can use this plugin with GitHub actions.

The general workflow will be:

1. Trigger a release with a manual job
2. For tagged commits, run your release procedure like publishing the artifacts.

To trigger the release you can take inspiration from the following configuration. This task has two inputs for the
release version and post release version.

<details>
<summary>Trigger Release Action</summary>

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
      # This is optional if you use the gitName & gitEmail properties from the plugin
      - name: Set Git User and Email
        run: |
          git config --global user.email "no-replay@github-action.de"
          git config --global user.name "GitHub Action"

      - name: Run gradle release task
        run: ./gradlew release -PreleaseVersion=${{ github.event.inputs.release-version }} -PpostReleaseVersion=${{ github.event.inputs.post-release-version }}
```

</details>

To do something with the release add another workflow file that is triggered when a tag is pushed.

<details>
<summary>Release Tag action</summary>

```yaml
# .github/workflows/on-release-tag.yml

name: Release

on:
  push:
    tags:
      - v*

jobs:
  release:
  # Your job configuration
```

</details>

### Customizing the release process

You can easily customize the release process by adding additional tasks and making the
relevant tasks depend on your custom tasks. Here are the most interesting tasks performed by the plugin:

1. _writeReleaseVersion_: This task writes the release version to your version file.
2. _commitReleaseVersion_: This task will create a commit tagged with the release version.
3. _pushRelease_: This task will perform the push operation.
4. _writePostReleaseVersion_: This task with write the post release version to your version file.
5. _commitPostReleaseVersion_: This task will commit the post release version. This commit will not be tagged.
6. _pushPostRelease_: This task will push the post release version.

Please note: The plugin will just write the version to the specified version file. Gradle will not automatically reload
the version property. The `version` variable from gradle will still show the old version. If you need the
version for your custom task, you either have to read the version directly from the file or run multiple gradle
commands.

#### Example

Let's assume, you want to write an additional file during the release. You could register your custom task and make the
_commitReleaseVersion_ task depend on that. If you want to commit this file with the release commit, you can edit the
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

## How to contribute

Issues and pull requests are welcome. Please fill out the issue template and provide as much information as possible.
Please have a look at the [CONTRIBUTING Guide](CONTRIBUTING.md) for more information.
