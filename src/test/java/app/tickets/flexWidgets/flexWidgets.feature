Feature: Flex Widgets
  As a user I want to view eligible flex widgets for each rate plan

  @keycloak
  Scenario Outline: Verify that the correct widgets appear for "<ratePlan>"
    Given user logged in using jwt using "<msisdn>" and "<password>"
    Then I verify "<superFlex>", "<offers365>", "<flexExtra>" and "<flexTransfer>" accourding to "<ratePlan>"

    Examples: 
      | ratePlan 	 | msisdn 		 | password  | superFlex | offers365 | flexExtra | flexTransfer |
      | flexOpen 	 | 01000678688 | Test@1234 |           |           | eligible  |              | 
      | flexCL 		 | 01032256600 | Test@1234 | eligible	 | 					 | eligible	 |							|
      | flex2019 	 | 01066118422 | Test@1234 | 					 | eligible  | eligible  | eligible			|
      | flex2017 	 | 01033700877 | Test@1234 | eligible  | eligible  | eligible  | eligible			|
      | flex2014 	 | 01065665166 | Test@1234 | 				   | eligible  | eligible  | eligible			|
      | flexWeekly | 01021811666 | Test@1234 |					 | eligible	 | eligible  | eligible			|
      | flexFamily | 01012440293 | Test@123  | 					 | 					 | eligible	 | eligible			|
