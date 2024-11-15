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

You should see the following ouptput

```
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                

2024-11-15T02:57:29.139-05:00  INFO 38262 --- [preeclampsia] [           main] e.v.c.p.PreeclampsiaApplication          : Starting PreeclampsiaApplication using Java 23.0.1 with PID 38262 (/Users/chaddarby/csc-8542-preeclampsia-backend/backend/preeclampsia/target/classes started by chaddarby in /Users/chaddarby/csc-8542-preeclampsia-backend/backend/preeclampsia)
2024-11-15T02:57:29.140-05:00 DEBUG 38262 --- [preeclampsia] [           main] e.v.c.p.PreeclampsiaApplication          : Running with Spring Boot v3.3.5, Spring v6.1.14
2024-11-15T02:57:29.140-05:00  INFO 38262 --- [preeclampsia] [           main] e.v.c.p.PreeclampsiaApplication          : The following 1 profile is active: "dev"
...
...
2024-11-15T02:57:29.822-05:00  INFO 38262 --- [preeclampsia] [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path '/'
2024-11-15T02:57:29.829-05:00  INFO 38262 --- [preeclampsia] [           main] e.v.c.p.PreeclampsiaApplication          : Started PreeclampsiaApplication in 0.836 seconds (process running for 0.975)
```

### Step 4: Access the Application
The application will be accessible at http://localhost:8080



