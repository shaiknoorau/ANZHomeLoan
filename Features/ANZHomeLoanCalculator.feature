Feature: ANZ Calculator test

@e2etest
Scenario: Work out borrowing elgibility using calculator
	Given Launch anz page
	When User enter details
	Then User should be able to see the outcome
	And User should be able to start over
	And User should be able to try to work out with living expenses only
	
	
	