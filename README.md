# EvertonSSO_Project

## Overview
This project is to test Everton's Registration Form to ensure that users are able to successfully register.
<br>
<br>
***NOTE: this test will fail at the last step.***
<br>
<br>
A method to generate a random email each time the test is run has been commented out 
as to not overload Everton with new registration requests everytime this suite is run. As a result it will use the same email on
each test run.

## Installation
1. Clone the repo or 'Download ZIP'
   ```
   git clone https://github.com/OluJS/EvertonSSO_Project.git
   ```
2. Open the file in IntelliJ or your chosen IDE

## Usage
1. To run the BDD script using the [TestRunner](https://github.com/OluJS/EvertonSSO_Project/blob/master/src/test/java/com/example/TestRunner.java) class,
   ensure that the VM Options (in Run/Debug Configurations using IntelliJ) is:
   ```
   -ea -Dtestng.dtd.http=true
   ```
2. Then you can right-click the file and choose "Run 'Test Runner'" from the menu that appears
