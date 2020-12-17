Feature: Usagemanagment

Scenario Outline: Check  data under Min card returned successfully from Managment Api 
Given user logged in using jwt using "<msisdn>" and "<password>"
When  user press on Min card
Then  based on "<Usertype>" check on Min "<Min_en>" and "<Min_ar>" card and "<usedScript_en>" card and "<usedScript_ar>" card
Examples:
            | msisdn    |password | Usertype |Min_en|Min_ar|usedScript_en|usedScript_ar|
            |01012447239|Test@1234|   Mass   |0     |0     | used for the last 30 days| مستخدمة اخر 30 يوم|           
            |01060991916|Test@1234|flexrevamp|0     |0     | used for the last 30 days| مستخدمة اخر 30 يوم|
            
            
            
Scenario Outline: Check  data under SMS card returned successfully from Managment Api 
Given user logged in using jwt using "<msisdn>" and "<password>"
When  user press on SMS card
Then  based on "<Usertype>" check on SMS "<sms_en>" and "<sms_ar>" card and "<usedScript_en>" card and "<usedScript_ar>" card

Examples:
            | msisdn    |password | Usertype |sms_en|sms_ar|usedScript_en|usedScript_ar|
            |01060991916|Test@1234|flexrevamp|0     |0     |used for the last 30 days| مستخدمة اخر 30 يوم|
 

   
#failure
#Scenario Outline: Management failure
#      Given: user logged in using jwt using "<msisdn>" and "<password>"
#      And: API failed
#       And: Min card data "<cashed>" before
#       Then: press on Min card show "<result1>" and show "<result2>"

#        Examples:
#            | msisdn     | password | cashed   | result1          |result2             |
#            |1099759221  |Test@1234 | yes      | old data appear  |Error script appear |
#            |1099759221  |Test@1234 | no       |  No data appear  |Error script appear|

