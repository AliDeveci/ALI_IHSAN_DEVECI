# Insider Selenium Automation Test

This project is created to perform automation tests using Selenium and TestNG on the Insider website.

Codes and Tests Prepared by:
Ali Ihsan Deveci

QA Test Automation Engineer

a.ihsan.deveci@gmail.com

https://www.linkedin.com/in/aliihsandeveci-qa/

___
### Getting Started
To get start with this framework, you will need to have the following software on your system.

• Java 8 or later \
• Maven 3 or later \
• Chrome or Firefox Web Browser\
• Clone the project to your computer: `git clone https://github.com/AliDeveci/ALI_IHSAN_DEVECI.git`

1. Open terminal or command prompt and navigate to the root directory of the project.
2. Run the following command to download the required dependencies:
   #### mvn clean install
3. Run the following command to run the tests:
   #### mvn test
4. Open the project with Intellij IDEA
    - Go to TestRunner class inside the project
    - Click Run button
5. Open the project with Intellij IDEA
    - Go to Maven User Interface from left sidebar
    - Double Click "clean"
    - Double Click "test"
___

## Used Libraries

- Selenium Java
- TestNG
- ExtentReports
- Commons io
- Maven Surefire Plugin
___
## Installation

1. Clone the project to your computer: `git clone https://github.com/AliDeveci/ALI_IHSAN_DEVECI.git`
2. Navigate to the project directory: `cd Insider_SeleniumAutomationTest`
3. Install Maven dependencies: `mvn clean install`

___

## How to Run:

1. You can run the tests using Maven commands, TestRunner class and by Test Annotations inside InsiderTest class.
2. Test reports are generated in the `target/surefire-reports` and`test-output` folders.

___

## Test Reports:

- TestNG reports
- Extent reports
- JUnit reports

___
## About Framework:
• I built my framework by using Java Programming Language.\
• I used maven as a build automation tool for this framework.\
• I used Selenium (4.27.0) and TestNG to orchestrate my tests, and put the dependencies and plugin inside pom.xml file.\
• For assertions/verifications, I utilized TestNG assertions to compare actual and expected results.\
• I created a properties file to store related data such as browser and urls.\
• I used Page Object Model Design Pattern to enhance test maintenance and reducing code duplication. \
• Inside pages package; I used Page Classes to store and identify the elements that I worked on. Also I stored related methods in page classes.\
• I used the PageFactory class and initElements method to initialize them.\
• Inside tests package;\
• I used TestRunner class and linked it to testRunner.xml file to run declared tests or suits.\
• I created TestBase class to run and instantiate related steps and initialize ExtendReport.\
• I stored test cases inside InsiderTests class.\
• I added a screenshot interface in After method in Hooks class; when the scenario fails, it takes a screenshot.\
• Inside utilities package, utility classes such as BrowserUtils, Driver, and ConfigurationReader were stored.\
• I used the Singleton Design Pattern in Driver class by declaring constructor of class as private, so that no one instantiates class outside of it. And declared a static method with return type as object of class which should check if class is already instantiated once.\
• Additionally after running tests and if any of them fails, you can have the screenshot attached report when you open the "test-output/report.html" on explorer.\
• If you run the test by TestRunner class, you can have JUnitReports inside test-output folder.\
• My framework is easy to maintain since I have elements stored in one centralized place. If any changes happen on the application about the elements, I know where to go and how to fix it to run test scripts correctly.
___

## N11 LOAD TEST TASK
• TASK:  Load tests and scenarios are needed to investigate the behavior of the search module of the
https://www.n11.com/ header and list the results after the search.\
• Load test cases which are related to the task are stored in `LOAD_TEST_CASES&CODES/ALI_IHSAN_DEVECI_INSIDER_LOAD_TEST_Task.pdf`\
• There is 1 User Story, 4 Acceptance Criterias, 4 Test Cases inside .pdf file.\
• You can reach out test codes via
___

## PET SORE API TEST CASES TASK
• TASK: Using “pet” endpoints from https://petstore.swagger.io/ write CRUD operations
API tests with positive and negative scenarios.\
• Positive and negative test cases which are related to the task are stored in `API_TEST_CASES/ALI_IHSAN_DEVECI_INSIDER_API_TestAutomation_Task.pdf`\
• There is 1 User Story, 7 Acceptance Criterias, 14 Positive, 40 Negative, Totally 54 Test Cases inside .pdf file. 
___

## Contact:

If you have any questions or feedback, please contact me via `a.ihsan.deveci@gmail.com`
