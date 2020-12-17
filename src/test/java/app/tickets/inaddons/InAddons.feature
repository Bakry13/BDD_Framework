Feature: In Addons

  Scenario Outline:  Validate In Addons returned successfully
  Given  user logged in using jwt using "<msisdn>" and "<password>"
  Then  Check on In addon  "<cardstate>" based on "<userType>"

    Examples:
      | msisdn      | password  |cardstate |userType|
      | 01032322955 | Test@1234 |Appear    |In      |
      | 01099759221 | Test@1234 |not_Appear|mass    |

   
