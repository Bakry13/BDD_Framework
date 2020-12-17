Feature: Usage managment

  
  Scenario Outline: Validate Usage managment API response with new inputs same as old response with old inputs
    Given user Called management Api once using jwt and other using & old auth with "<msisdn>" and "<password>"   
    Then  compare two responses of managment 
     
    
         Examples:
             | msisdn    |password | 
             |1099759221|Test@1234|
             