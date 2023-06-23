FROM debian:stable-slim AS spring-boot-base
## Update and install dependencies
RUN apt update && apt -y upgrade
RUN apt install -y openjdk-17-jdk maven
## Clean up
RUN apt clean
RUN rm -rf /var/lib/apt/lists/*ß
## Run bash
CMD ["bash"]

FROM spring-boot-base AS spring-boot-build
## Set working directory
WORKDIR /app
COPY . .
## Install Dependencies
RUN mvn clean install -DskipTests
## Run
CMD ["java", "-jar", "target/heres-spring-0.0.1-SNAPSHOT.jar"]