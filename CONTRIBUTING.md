# Contributing Guide

We welcome and appreciate all contributions. Here's how you can participate:

## Reporting Bugs

1. Check if the bug has already been reported in the Issues section.
2. If not, create a new issue. Provide as much detail as possible, including steps to reproduce, the expected outcome,
   and your environment setup.

## Suggesting Enhancements

1. For feature requests, please first check the Issues section to see if it has already been suggested.
2. If not, feel free to open a new issue describing your feature, why you think it would be beneficial, and how it
   should work.

## Pull Requests

1. Fork the repository and create a new branch from main for your feature or fix.
2. Run the project locally and ensure that your changes do not break existing functionality.
3. Add tests for your changes. This helps ensure that your changes do not break existing functionality and that your
   feature works as expected.
4. Push your changes to your branch and submit a pull request to the main branch of the original repository.

## Development Setup

### Building & Testing

This plugin can be built and tested with the standard lifecycle tasks provided by Gradle.

- To build the project use `./gradlew assemble`
- To run all checks (including formatting) use `./gradlew check`
- To build and run tests use `./gradlew build`

If you just want to run the plugin related tests use `./gradlew release-plugin:test`.

### Formatting

This plugin uses [ktfmt](https://github.com/facebook/ktfmt) as formatting tool.
To format files run `./gradlew format`. To check if your files are formatted correctly use `./gradlew checkFormat`.