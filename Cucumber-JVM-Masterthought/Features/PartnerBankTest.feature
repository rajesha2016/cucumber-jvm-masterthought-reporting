#author: rajeshamoharana@gmail.com
Feature: Validate xyz partner bank feature

@PartnerBank
Scenario: Validate Moody's Country rating and Invest Now functionalities
	Given User is on xyz partner banks page
	When User selects Learn More for the bank having A1 Moody's country rating
	Then User navigates to corresponding partner bank's offers page and can see Invest now option
	When User click on Invest now button
	Then User navigates to registration page
	