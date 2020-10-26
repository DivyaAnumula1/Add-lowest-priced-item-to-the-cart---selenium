Feature: Automation practice
  Scenario: Purchase lowest priced item
    Given I am on home page of "http://automationpractice.com/"
    When Search for the below item
    And select the lowest priced item
    And Add the item to cart
    And verify the checkout option
    And login using the below credentials
	And update the address with the below details
		|zarmanshah@malomiesed.com|Testing123|
	And check the shipping details
	And pay the amount for the item
	Then the user's order should be successful with the below details