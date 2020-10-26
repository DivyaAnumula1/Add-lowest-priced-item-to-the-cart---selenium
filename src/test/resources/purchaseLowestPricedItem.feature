Feature: Automation practice
  Scenario: Purchase lowest priced item
    Given I am adding the address with the below details
		|http://automationpractice.com/|zarmanshah@malomiesed.com|Testing123|pradeep|123 Street|Cambridge|02140|987654321|123456789|  xyz |
	And I am on home page of "http://automationpractice.com/"
    When Search for the below item
    And select the lowest priced item
    And Add the item to cart
    And verify the checkout option
    And login using the below credentials
		|zarmanshah@malomiesed.com|Testing123|
	And update the address with the below details
		|pradeep|123 Street|Cambridge|02140|987654321|123456789|  xyz |
	And check the shipping details
	And pay the amount for the item
	And confirm the order
	Then the user's order should be successful with the below details