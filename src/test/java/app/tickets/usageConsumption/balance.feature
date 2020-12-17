Feature: Balance card

#Scenario Outline: Check Internet & roaming returned for (Red & flex & VPN & mass) incase Dxlflag is true and consumption API up & working
    #Check on Cards returned in home(Red & flex & VPN & mass)
        #Given user logged in using jwt using "<msisdn>" and "<password>" 
        #Then  Based on "<rateplan>"  user view "<Internet>" and "<roaming>"
         #
          #Examples:
             #| msisdn    | password | rateplan             | Internet             |roaming               |           
             #|1099759221 |Test@1234 | Red has family       |Card displayed/data   |Card displayed/ data  |
             #|1099759221 |Test@1234 | Flex has no internet |Card displayed/no data|Card displayed/no data|
             #|1099759221 |Test@1234 | Flex /expired        |Card displayed/data   |Card displayed/no data|
             #|1099759221 |Test@1234 | Red has roaming qouta|Card displayed/data   |Card displayed/no data|
             #|1099759221 |Test@1234 | VPN                  |Card displayed/ data  |Card displayed/no data|
             #|1099759221 |Test@1234 | mass                 |Card displayed/ data  |Card displayed/no data|
  #
#
#Scenario Outline: Check family card returned  incase Dxlflag is true and consumption API up & working
    #Check on family Card returned in home
        #Given user logged in using jwt using "<msisdn>" and "<password>" 
        #Then  check "<family>" card
         #
          #Examples:              
             #| msisdn    | password |family            |
             #|1099759221 |Test@1234 |Card displayed    |
             #|1099759221 |Test@1234 |Card not displayed|    
#
#
#Scenario Outline: Check Flex returned  incase Dxlflag is true and consumption API up & working
    #Check on Flex Card returned in home
        #Given user logged in using jwt using "<msisdn>" and "<password>" 
        #Then  check "<Flex>" card
         #
          #Examples:              
             #| msisdn    | password |       Flex            |
             #|1099759221 |Test@1234 |Card displayed/has data|
             #|1099759221 |Test@1234 |Card displayedlexpired |    
#
#
#Scenario Outline: Check red min & red sms returned  incase Dxlflag is true and consumption API up & working
    #Check on  red min & red sms Card returned in home
        #Given user logged in using jwt using "<msisdn>" and "<password>" 
        #Then  check on "<red_min>" and "<red_sms>" card
         #
          #Examples:              
             #| msisdn    | password |red_min|red_sms|
             #|1099759221 |Test@1234 |yes    |yes|
             #|1099759221 |Test@1234 |no     |no|   


@Keycloak
Scenario Outline: Check balance returned successfully
      Check on Balance
       Given user log in using jwt using "<msisdn>" and "<password>" accourding to balance "<status>" 
       Then  user view "<balanceEn>" and "<balanceAr>" card accourding to balance "<status>"
    
    Examples:
             | msisdn      | password | balanceEn | balanceAr | status |
             | 01090338557 |Test@1234 | 0 EGP     | ٠ جنيه      | zero	 |
             | 01064423238 |Test@1234 | 50 EGP    | ٥٠ جنيه     | value  |    


#      check family member for all rate plans
#     rewrite yes  or no in (red_min-red_sms) to "Card displayed/ data"
#     failure state