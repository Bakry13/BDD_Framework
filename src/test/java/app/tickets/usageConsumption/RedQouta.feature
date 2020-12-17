Feature: Usage consumption-Red min & sms
Scenario Outline: Check red min & red sms returned  incase Dxlflag is true and consumption API up & working
    Check on  red min & red sms Card returned in home
        Given user logged in using jwt using "<msisdn>" and "<password>" 
        Then  Based on "<Rate_plan>" check on "<red_min>" and "<red_min_ar>" card
        And   Based on "<Rate_plan>" check "<red_sms>" and "<red_sms_ar>" card
         
          Examples:              
             | msisdn     | password |Rate_plan|red_min|red_sms|red_min_ar|red_sms_ar|
             |01068051444 |Test@1234 |Red      |4000   |2000   |4000       |2000       |



Scenario Outline: Check red internet returned  incase Dxlflag is true and consumption API up & working
    Check on  red internet Card returned in home
        Given user logged in using jwt using "<msisdn>" and "<password>" 
        Then  check on "<internet_en>" and "<internet_ar>" card  Based on "<Rate_plan>"
      
         
          Examples:              
             | msisdn     | password |Rate_plan|internet_en|internet_ar|
             |01068051444 |Test@1234 |Red      |20480      |20480|     