# EmergencyGRPCApp
A gRPC service for receiving and processing emergency reports (such as floods or tsunamis), sending notifications, and confirming message receipt. Built with Spring Boot using grpc-spring-boot-starter.

## gRPC Clients
- [DisasterGRPCReporter](https://github.com/MykolaLytvynov/DisasterGRPCReporter)

## Features

- Accepts emergency reports with details like city, disaster code, and description.
- Sends formatted notifications every time a report is received.

## Generate gRPC code
Generate Code from the .proto File
To generate the Java classes required for gRPC from the .proto file, use the following Maven command:
   ```
   mvn clean compile
   ```

## Configuration
The default gRPC server port is 8090, which can be configured in application.properties.

## Dependencies
- Spring Boot.
- gRPC.
