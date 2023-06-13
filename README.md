# Running the RandomUserApiApplication in IntelliJ IDEA

RandomUserApiApplication is a Kotlin-based Spring Boot application which facilitates various user-related functionalities. This document outlines the steps required to run the RandomUserApiApplication.kt file within the IntelliJ IDEA environment.

## Prerequisites
- Java Development Kit (JDK), version 1.8 or higher.
- The latest version of IntelliJ IDEA.

## Setup & Execution

### 1. Clone the Repository:

On your local machine, clone the repository by executing the following command in your terminal:

```bash
git clone https://github.com/zicula/RandomUserApiApplication.git
```

### 2. Open the Project in IntelliJ IDEA:

Launch IntelliJ IDEA and select "Open". In the dialog box, navigate to the directory where you cloned the project and open it.

### 3. Import Gradle Project:

Once the project is loaded in IntelliJ, a popup should appear in the bottom-right corner asking to "Import Gradle Project". Click on this button. If this popup doesn't appear, you can manually initiate the import process by navigating to "File" -> "New" -> "Module from Existing Sources". Select the `build.gradle` file located in your project's root directory.

### 4. Build the Project:

After successfully importing the Gradle project, navigate to "Build" -> "Build Project" to build the application.

### 5. Run the Application:

To run the application, locate the `RandomUserApiApplication.kt` file within your project structure (`src/main/kotlin/com/api/randomuserapi/RandomUserApiApplication.kt`). Right-click on the file and select "Run 'RandomUserApiApplicationKt'". The Spring Boot application should now start.

### 6. Accessing the Application

After successfully starting the application, you can access it by opening a web browser and navigating to http://localhost:8089, or another port if you have configured it differently from the default. (edit port at -> src/main/resources/application.properties)

### 7. API: Get RandomUser Data
go to http://127.0.0.1:8089/v1/users/{seed}

{seed} is the unique identifier associated with each user. Replace {seed} with the actual seed value of the user.
