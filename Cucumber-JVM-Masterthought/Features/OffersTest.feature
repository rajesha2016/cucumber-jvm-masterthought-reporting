#author: rajeshamoharana@gmail.com
Feature: Validate interest rate offers feature

@InterestOffers
Scenario: Validate number of offers for Easy access
	Given User is on xyz offers page
	When User selects easy access checkbox
	Then User see same number of search offers matches to easy access

@InterestOffers
Scenario: Validate navigation to registration page for highest interest rate
	When User gets list of interest rate
	Then User clicks on register for highest interest rate offer
	And Register with xyz now page will be open
