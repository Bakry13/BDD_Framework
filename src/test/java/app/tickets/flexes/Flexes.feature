Feature: Usage consumption-flexes

Scenario Outline: Check Flex returned  incase Dxlflag is true and consumption API up & working
    Check on Flex Card returned in home
        Given user logged in using jwt using "<msisdn>" and "<password>" 
        Then  check "<FlexEn>" and "<FlexAr>" card based on "<status>"
         
           Examples:              
             | msisdn     | password |status    |       FlexEn          |FlexAr |                                           
             |01099733078 |Test@1234 |has_flexes|600                    |600     |
             |01000678688 |Test@1234 |expired   |Your bundle has expired, Renew now to enjoy your Flexes.|انتهت صلاحية باقتك, جدد دلوقتي علشان تستخدم من فليكساتك.|
             
                






