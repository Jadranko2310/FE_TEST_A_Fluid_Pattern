
# FE_TEST_POM_DP

# Introcution
This project is a test automation framework built using Selenium WebDriver and TesNG with Alllure as reporting tool.
It is created with Fluid design pattern.

# Prerequisites
To set up and run this project, you need to have the following installed on your system:

Java Development Kit (JDK) 17 or above
Maven (build and dependency management tool)
WebDriver-compatible browser (e.g., Chrome, Firefox)

# Configuration
Open the src/main/resources/config.properties file.
Modify the configuration properties as per your setup, including the base URL, browser type, and other relevant settings.

# Running Tests
Open a terminal or command prompt.
Navigate to the project root directory: cd test-automation-project.
Execute the following command to run the tests: `mvn clean test' for runing all reports. 
For running just the postive tests execute: mvn clean test -Dfile=Positive
For running just the negative tests execute: mvn clean test -Dfile=Negative



