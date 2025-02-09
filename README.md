# Test project for excessive logging

Fork of the ddm-akka to test excessive logging. It is a simple project that logs a lot of
messages to the console.

## How to run the project

Build the project with the following command:

```bash
mvn clean install
```

Run the project with the following command:

```bash
java -jar target/ddm-akka-1.0.jar master -ptls 4 -msbl 500
```

The command ptls is the performance test log message size in bytes and msbl is the number of milliseconds the program
waits between printing log messages.
The mode "master" or "worker" has no effect in this project.