<div id="header" align="center">
  <img src="https://media.giphy.com/media/xSM46ernAUN3y/giphy.gif"/>
</div>
<div id="badges" align="center">
  <a href="https://www.linkedin.com/in/ewelinqa/">
    <img src="https://img.shields.io/badge/LinkedIn-blue?style=for-the-badge&logo=linkedin&logoColor=white" alt="LinkedIn Badge"/>
  </a>
</div>
<div id="visits" align="center">
  <img src="https://komarev.com/ghpvc/?username=elciak82&style=flat-square&color=blue" alt=""/>
</div>



# Prestashop_E_Commerce - MOBILE
Project for test automation covering UI acceptance for mobile.

## Concepts included
* Page Object pattern
* Common web page interaction methods
* Externalised test configuration

## Tools
* Maven
* TestNG
* Selenium AndroidDriver
* Appium

## Requirements - todo
In order to utilise this project you need to have the following installed locally:

* Java 11
* Maven 3
* Chrome and Chromedriver (UI tests use Chrome by default, can be changed in config)
* Allure Framework

Additionally, it is required to set Environment Variables for database connection.

## Usage
start tests: mvn clean test

## Reporting
* generate report: allure serve allure-results 
* clean old data: allure generate --clean --output allure-results

## CI/CD - todo



