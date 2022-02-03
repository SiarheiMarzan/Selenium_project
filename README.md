## A project for calculating the cost of using the Google cloud platform and checking the cost sent to the user's email to compare the costs from the calculator's page and the received value to the mail.
* When performing a task, you need to use the capabilities of Selenium WebDriver, the TestNG framework and the Page Object concept.

## Description:

* Checking the compliance of the cost of calculating the rental of the Google cloud platform received through Google Cloud Pricing Calculator and the sent information about the cost to the work email.

# Requirements
***
* JDK (version 8 or later)
* Maven
* Selenium WebDriver
* TestNG

# Running 
* VM options -ea -Dbrowser=chrome -Denvironment=test-data
# Running with Selenoid. 
* It is using Docker to launch browsers.
* VM options -ea -Dbrowser=remoteChrome -Denvironment=test-data