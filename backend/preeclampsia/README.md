# Preeclampsia - Spring Boot Project

Welcome to the **Preeclampsia** Spring Boot project! 

---

## Requirements

To run this project, ensure you have the following installed:

- **Java 21+**  
  Install Java from [Oracle](https://www.oracle.com/java/technologies/javase-downloads.html) or [AdoptOpenJDK](https://adoptopenjdk.net/).

- **Maven 3.9 or higher**  
  Download and install Maven from [Apache Maven](https://maven.apache.org/download.cgi).

---

## Getting Started

Follow these steps to set up and run the project locally:

### Step 1: Clone the Repository
Clone the repository using the following command:

```bash
git clone https://github.com/darbynova/csc-8542-preeclampsia-backend.git
cd csc-8542-preeclampsia-backend/backend/preeclampsia
```

### Step 2: Create a Configuration File
Create an `application-dev.properties` file in the `src/main/resources` directory. Use the file that I posted in our Microsoft Teams channel


### Step 3: Running the Application
Navigate to the project directory and run:

```
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

This command will:
* Compile the source code.
* Resolve all dependencies.
* Launch the embedded server (e.g., Tomcat) and run the application.

The `-Dspring-boot.run.profiles=dev`: sets the active Spring profile to dev. Spring will load the configuration from application-dev.properties or other profile-specific resources.

### Step 4: Access the Application
The application will be accessible at http://localhost:8080



