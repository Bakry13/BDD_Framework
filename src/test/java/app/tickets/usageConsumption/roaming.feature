Feature: Roaming tab
					Verify the correct scripts and values for roaming tab

Scenario Outline: Verify the correct script of roaming tab while there is not subscribed bundles
        Given user logged in using jwt using "<msisdn>" and "<password>" 
        When press on roaming tab
        Then  The correct text of "<roamingScriptEn>" and "<roamingScriptAr>" appear
         
          Examples:
             | msisdn     | password | roamingScriptEn 											| roamingScriptAr |          
             |01060991916 |Test@1234 | You are not subscribed to any bundle | ليس لديك باقة تجوال  			|
             
Scenario Outline: Verify the correct script of roaming tab while there is unsused bundle
        Given user logged in using jwt using "<msisdn>" and "<password>" 
        When press on roaming tab
        Then  The correct text of "<roamingScriptEn1>", "<roamingScriptAr1>", "<roamingScriptEn2>", "<roamingScriptAr2>" appear
         
          Examples:
             | msisdn     | password | roamingScriptEn1 																				| roamingScriptAr1     			 | roamingScriptEn2 | roamingScriptAr2 |           
             |01068051444 |Test@1234 | Your bundle will get started automatically upon arrival. | هيتم تفعيل باقتك تلقائيا لما توصل المكان اللى هتسافر ليه. | Not started yet  | 	لم يبدأ استخدام الباقة      |

Scenario Outline: Verify that the correct value of used bundle returned from roaming tab
        Given user logged in using jwt using "<msisdn>" and "<password>" 
        When press on roaming tab
        Then  The correct values of "<internetEn>", "<internetAr>", "<outgoingMinEn>", "<outgoingMinAr>", "<incomingMinEn>", "<incomingMinAr>", "<smsEn>", "<smsAr>" appear
         
          Examples:
             | msisdn      | password | internetEn | internetAr | outgoingMinEn | outgoingMinAr | incomingMinEn | incomingMinAr | smsEn | smsAr |
             | 01000678688 |Test@1234 | 100        | 100  			| 10 						| 10 						| 30 						| 30						| 0			|	0			|
             