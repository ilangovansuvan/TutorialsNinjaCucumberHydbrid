Feature: Registering functionality

Scenario: user creates account only with  mandatory fields
Given user navigate to Registe page
When  user enters the details in below fields
|firstName | Ilango |
|lastName	|Suvan	|
|email		|ilangosuvan	|
|telephone	|123456789	|
|password	|12345	|
And user selects privacy policy
And user click continue button
Then  user should get account successfully created

Scenario: user creates account only with  mandatory fields
Given user navigate to Registe page
When  user enters the details in below fields
|firstName | Ilango |
|lastName	|Suvan	|
|email		|ilangosuvan	|
|telephone	|123456789	|
|password	|12345	|
And user selects Yes for news letter
And user selects privacy policy
And user click continue button
Then  user should get account successfully created

Scenario: user creates a duplicate account
Given user navigate to Registe page
When  user enters the existing details in below fields
|firstName | Ilango |
|lastName	|Suvan	|
|email		|ilangosuvan1@gmail.com	|
|telephone	|123456789	|
|password	|12345	|
And user selects Yes for news letter
And user selects privacy policy
And user click continue button
Then  user should get a proper warning about email


Scenario: user creates an account without filling any fields
Given user navigate to Registe page
When  user dont enters the details
And user click continue button
Then  user should get a proper warning message for every mandatory fields

