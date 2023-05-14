FROM maven:3.8.6-openjdk-18 AS build

# Set the working directory to the application directory
WORKDIR /app

# Copy the application source code to the container
COPY . .

# Build the application using Maven
RUN mvn --batch-mode --update-snapshots package

# Set the artifacts to be saved as build output
RUN mkdir -p /build
RUN cp -r target/classes target/*.jar /build

# Set the artifacts to expire after 1 hour
CMD ["find", "/build", "-type", "f", "-mmin", "+60", "-delete"]

FROM openjdk:17.0

RUN useradd --create-home --shell /bin/bash spring
USER root
WORKDIR /home/spring

USER spring

COPY --from=build /build/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar", "com.hin.spatial.postgis"]