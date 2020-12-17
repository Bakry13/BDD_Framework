Feature: bill card


  Scenario Outline: Check bill card returned successfully
  Check on bill card
    Given user login using jwt using "<msisdn>" and "<password>" and "<RatePlan>"
    Then  user view bill card for "<RatePlan>"

    Examples:
      | msisdn      | password  | RatePlan   |
      | 01001200136 | Test@1234 | PostPaid   |
      | 01012447053 | Test@1234 | Enterprise |