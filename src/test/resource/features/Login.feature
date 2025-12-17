Feature: Login functionality

Scenario Outline:: Login with valid credentials
Given user navigate to login page
When User has enter valid email address <username>
And  user has enter valid password <password>
And user clicks on login button
Then user should get successfully logged in
Examples:
|username			|password	|
|"avdmbino@gmail.com"|"qnQwmSusSGL5#"|
|"avdmbino@gmail.com"|"qnQwmSusSGL5#"|
|"avdmbino@gmail.com"|"qnQwmSusSGL5#"|

Scenario: Login with invalid credentials
Given user navigate to login page
When User has enter invalid email address "1avdmbino@gmail.com"
And  user has enter invalid password "1qnQwmSusSGL5#"
And user clicks on login button
Then user should get proper warning message

Scenario: Login with valid email and invalid password
Given user navigate to login page
When User has enter valid email address "avdmbino@gmail.com"
And  user has enter invalid password "1qnQwmSusSGL5#"
And user clicks on login button
Then user should get proper warning message

Scenario: Login with invalid email and valid password
Given user navigate to login page
When User has enter invalid email address "avdmbino"
And  user has enter valid password "qnQwmSusSGL5#"
And user clicks on login button
Then user should get proper warning message

Scenario: Login without providing credentails
Given user navigate to login page
When User donot enter email address 
And  user donot enter password 
And user clicks on login button
Then user should get proper warning message
