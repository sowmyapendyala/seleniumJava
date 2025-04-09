# Selenium Test Project 

This is a Selenium automation framework using Java, Maven, and TestNG. 

Below are the required Prerequisites for using the framework

- Java JDK (8 or later)
- Maven
- Chrome browser
- Chrome Driver
- Install Dependencies 
- Set Up WebDriver

Project Structures

The ElementHelper.java class encapsulates common interactions with web elements. This helps in keeping the test methods clean and maintainable.

The Selenium.java class contains the test that navigates the ATG website, interacts with various elements, and uses the ElementHelper class to simplify element interactions.

# To run the test daily 
.bat file has been provided to automate the running of the tests. This batch file can be scheduled to run daily using Windows Task Scheduler.

API Test Automation Framework Documentation

Overview
This project is an API Test Automation Framework designed to test the Petstore API. It uses Java, Maven, RestAssured, and TestNG to facilitate API testing. The framework reads request payloads from a JSON file, sends requests to the API, and validates the responses.

Explanation
ConfigPet.java: Contains the base URL and default headers for the API.
ClientApi.java: Contains methods for sending API requests using RestAssured.
Main.java: Main class for running API requests directly if needed (optional).
ApiTest.java: Contains the TestNG test methods for testing the API endpoints.
request.json: JSON file containing the request payload for the API.
               
     
This API Test Automation Framework is designed to make testing RESTful APIs simple and effective by using Java, Maven, RestAssured, and TestNG. The framework reads request payloads from a JSON file, sends requests to the API, and validates the responses(ex: response code, response body contains) with assertions. This ensures that the API functions as expected and helps catch any issues early in development.


C#, .NET and UFT
