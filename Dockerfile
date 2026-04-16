FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
# Copy the compiled jar file from the target directory to the image
COPY target/*.jar app.jar
# Command to run the application
ENTRYPOINT ["java","-jar","/app.jar"]
