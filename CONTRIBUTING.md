# Contributing Guide

We welcome and appreciate all contributions. Here's how you can participate:

## Reporting Bugs

1. Check if the bug has already been reported in the Issues section.
2. If not, create a new issue. Provide as much detail as possible, including steps to reproduce, the expected outcome,
   and
   your environment setup.

## Suggesting Enhancements

1. For feature requests, please first check the Issues section to see if it has already been suggested.
2. If not, feel free to open a new issue describing your feature, why you think it would be beneficial, and how it
   should
   work.

## Pull Requests

1. Fork the repository and create a new branch from main for your feature or fix.
2. Run the project locally and ensure that your changes do not break existing functionality.
3. Add tests for your changes. This helps ensure that your changes do not break existing functionality and that your
   feature works as expected.
4. Push your changes to your branch and submit a pull request to the main branch of the original repository.

## Development Setup

- To format the code run `./gradlew format` and `./gradlew release-plugin:format` for the plugin
- To build the project use `./gradlew assemble` and `gradlew release-plugin:assemble` for the plugin
- To run all checks use `./gradlew check` and `./gradlew release-plugin:check` for the plugin