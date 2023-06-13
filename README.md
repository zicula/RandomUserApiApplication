# Running the RandomUserApiApplication in IntelliJ IDEA

RandomUserApiApplication is a Kotlin-based Spring Boot application which facilitates various user-related functionalities. This document outlines the steps required to run the RandomUserApiApplication.kt file within the IntelliJ IDEA environment.

## Prerequisites
- Java Development Kit (JDK), version 1.8 or higher.
- The latest version of IntelliJ IDEA.

## Setup & Execution

1. **Clone the Repository:**

On your local machine, clone the repository by executing the following command in your terminal:

```bash
git clone https://github.com/zicula/RandomUserApiApplication.git

## Open the Project in IntelliJ IDEA:

2. Launch IntelliJ IDEA and select "Open". In the dialog box, navigate to the directory where you cloned the project and open it.

## Import Gradle Project:

3. Once the project is loaded in IntelliJ, a popup should appear in the bottom-right corner asking to "Import Gradle Project". Click on this button. If this popup doesn't appear, you can manually initiate the import process by navigating to "File" -> "New" -> "Module from Existing Sources". Select the `build.gradle` file located in your project's root directory.

## Build the Project:

4. After successfully importing the Gradle project, navigate to "Build" -> "Build Project" to build the application.

## Run the Application:

5. To run the application, locate the `RandomUserApiApplication.kt` file within your project structure (`src/main/kotlin/com/api/randomuserapi/RandomUserApiApplication.kt`). Right-click on the file and select "Run 'RandomUserApiApplicationKt'". The Spring Boot application should now start.

## Accessing the Application

6. After successfully starting the application, you can access it by opening a web browser and navigating to http://localhost:8089, or another port if you have configured it differently from the default. (edit port at -> src/main/resources/application.properties)

## API: Get RandomUser Data
7. http://127.0.0.1:8089/v1/users/{seed}

{seed} is the unique identifier associated with each user. Replace {seed} with the actual seed value of the user.
