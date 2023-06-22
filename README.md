
# Prestashop_E_Commerce - MOBILE
Project for test automation covering UI acceptance for mobile.

## Concepts included
* Page Object pattern
* Setup for testing mobile by Appium

## Tools
* Maven
* TestNG
* AndroidDriver
* Appium
* Allure

## Requirements - todo
In order to utilise this project you need to have the following installed locally:

* Java 11
* Maven 3
* Chrome and Chromedriver (UI tests use Chrome by default, but can be changed in config)
* Allure Framework
* Appium

Additionally, it is required to set Environment Variables for database connection.

For Appium:
* 

## Usage
start tests: mvn clean test

## Reporting
* generate report: allure serve allure-results 
* clean old data: allure generate --clean --output allure-results

## CI/CD - todo



