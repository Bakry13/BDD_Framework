Feature: Usage consumption-Internet card
Scenario Outline: Check red internet returned  incase Dxlflag is true and consumption API up & working
    Check on  red internet Card returned in home
        Given user logged in using jwt using "<msisdn>" and "<password>" 
        Then  check on "<internet_en>" and "<internet_ar>" card   Based on "<precondition>"
      
         
          Examples:              
             | msisdn     | password |precondition   |internet_en|internet_ar|
             |01099733078 |Test@1234 |has no mi      |You are not subscribed to any bundle.|انت غير مشترك في باقة موبايل انترنت.|    
             |01099655920 |Test@1234 |has extreme    |150        |150| 
             |01000678688 |Test@1234 |has plus bundle|500        |500|      