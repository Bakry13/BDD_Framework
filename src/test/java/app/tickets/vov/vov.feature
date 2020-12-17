Feature: VOV cards
				Verify that the correct VOV cards appear

	@Keycloak
	Scenario Outline: Verify that recharge card appears in prepaid number that has balance < 10LE
	       Given user logged in using jwt using "<msisdn>" and "<password>" 
	       Then  Verify recharge button "<btnNameEn>" and "<btnNameAr>" in VOV card
	    
	    Examples:
	             | msisdn      | password  | btnNameEn | btnNameAr |
	             | 01099759221 | Test@1234 | Recharge  | إشحن				 |