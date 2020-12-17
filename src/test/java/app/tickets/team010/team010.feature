Feature: team 010 card

	@Keycloak
	Scenario Outline: Check 010 team returned successfully
	      Check on 010 team card
	       Given user login using jwt using "<msisdn>" and "<password>"
	       Then  user view 010teams card
	    
	    Examples:
	             | msisdn      | password  |
	             | 01090338557 | Test@1234 |