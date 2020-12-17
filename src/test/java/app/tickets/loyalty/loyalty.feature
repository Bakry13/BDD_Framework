Feature: Red Loyalty points module
  Check appearance of loyalty card in different tariffs

  @Keycloak
  Scenario Outline:check DXL_FLAG and  update the UI accordingly.
    Given   User have "<msisdn>" and "<password>"
    Then Get red points value "<redPointsEn>" , "<redPointsAr>" from  "<state>" based on "<ConsumptionDXLFlag>"

    Examples:
      | msisdn      | password  | ConsumptionDXLFlag | state           | redPointsEn | redPointsAr |
      | 01030021755 | Test@1234 | false              | old home        | 0           | 0           |
      | 01068051444 | Test@1234 | true               | red loyalty api | 20          | 20          |

  @Keycloak
  Scenario Outline: check red loyalty eligibility
    Given User have "<msisdn>" and "<password>"
    Then loyalty card visibility is "<cardState>" based on "<userType>"

    Examples:
      | msisdn      | password  | cardState | userType      |
      | 01090338557 | Test@1234 | false     | mass          |
      | 01012447053 | Test@1234 | false     | red business  |
      | 01030693069 | Test@1234 | true      | red converged |

#This test case can not be automated now as it needs to fail loyalty api
# @Keycloak
# Scenario Outline: Check that cashed value of red points are returned in case of loyalty api failure
#       Given user logged in using jwt using "<msisdn>" and "<password>"
#       And   check consumption dxl flag is "<ConsumptionDXLFlag>"
#       And   "<API>" failed
#       And   red points is "<cached>"
#       Then  show "<cardType>"
#
#        Examples:
#            | msisdn     | password | ConsumptionDXLFlag | API             | cached | cardType |
#            | 0101528552 | TEST     | false              | old home        | yes    | normal   |
#            | 0101528552 | TES      | true               | red loyalty api | no     | failure  |
#            | 0101528552 | TES      | true               | red loyalty api | yes    | normal   |
#            | 0101528552 | TEST     | false              | old home        | no     | failure  |