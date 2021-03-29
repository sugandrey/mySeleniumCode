Feature: Login into Application

Scenario Outline: Positive test validation of login

Given Initialize the browser with chrome and delete cookies
And Navigate to "http://rahulshettyacademy.com" website
And Click on login link on the home page to land on secure sign in page
When User types <username> and <password> and logs in
Then Verify that User is successfuly logged in
And Close browsers

Examples:
|username				|password	|
|sugandrey1@gmail.com	|123456		|
|test@gmail.com			|12345		|
|test2@test.com			|54322		|