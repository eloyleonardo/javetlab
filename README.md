# Javet Lab

## Overview

This project is designed to test the GraalVM native compilation feature with Javet.

## Testing

- **Runtime Tests**:

  ```
  ./gradlew test
  ```

  This command is working as expected.

- **Native Test Command**:

  ```
  ./gradlew test nativeTest
  ```

  This one I cannot make work.

## Configuration Note

It is important to note that within the `build.gradle` file of this project, a full path to the Javet native libraries has been specified. This was necessary to ensure the correct loading of these libraries during both development and testing phases.