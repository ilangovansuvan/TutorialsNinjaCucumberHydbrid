Feature: Search Functionality
Scenario: user searches for a valid product
Given user opens the application
When user enters valid product "HP"
And  user clicks search button
Then user should get the valid product details

Scenario: user searches for a invalid product
Given user opens the application
When user enters invalid product "Honda"
And  user clicks search button
Then user should get the message about no product matching

Scenario: user searches without any product
Given user opens the application
When user enters dont enter product name
And  user clicks search button
Then user should get the message about no product matching



