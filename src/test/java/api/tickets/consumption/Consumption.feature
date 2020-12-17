Feature: Usage consumption

  
  Scenario Outline: Validate Usage consumption API response with new inputs same as old response with old inputs
    Given user Called consumption Api once using jwt and other using & old auth with "<msisdn>" and "<password>"   
    Then  compare two responses of consumption 
     
    
         Examples:
             | msisdn    |password | 
             |1099759221|Test@1234|
             
             
    
    
#These test cases can not be automated because it needs to fail configuration api    
#   Scenario Outline: consumption failure
#       Given user logged in using jwt using "<msisdn>" and "<password>"
#       And consumption API failed
#       Then user "<data>" appear based "<cached>"
    
#         Examples:
#             | msisdn     | password | cached   | data|   
#             |1099759221  |Test@1234|    yes    |Yes  |
#             |1099759221  |Test@1234|    no     |Error view  |