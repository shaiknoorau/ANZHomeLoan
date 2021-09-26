Feature: ANZ Calculator test

@Test1
Scenario: Work out borrowing estimate using calculator
	Given User launches the anz home loan calculator page
	When User enters the income details
	Then Borrowing estimate should be displayed
	
@Test2
Scenario: Validate Start Over action
	Given User launches the anz home loan calculator page
	When User clicks start over to check borrowing estimate after initial estimate
	Then Form should be cleared

@Test3
Scenario: Validate Error Message
	Given User launches the anz home loan calculator page
	When User enters only living expenses
	Then Error message should be displayed
		
	
	
	