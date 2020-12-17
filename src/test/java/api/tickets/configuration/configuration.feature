Feature: Configuration
    Check Configuration API response and its content contents correctness
    @Keycloak
    Scenario Outline: Validate Configuration API response with new inputs same as old response with old inputs
        Given user Called configuration Api once using jwt and other using & old auth" with <msisdn>" and "<password>"
        Then compare two responses

        Examples:
            | msisdn   |password |
            |1099759221|Test@1234|

    #These test cases can not be automated because it needs to fail configuration api
#    @Keycloak
#    Scenario Outline: When the Configuration API fails, call the menu API to get the flag Information with default values.
#        Given configuration api is down
#        And  user logged in using jwt using "<msisdn>" and "<password>"
#        When user refresh home screen
#        Then call menu api
#        And  Consumption <state> loaded successfully
#
#        Examples:
#            | msisdn      | password  | state            |
#            | 01099759221 | Test@1234 | call old Home    |
#            | 01099759221 | Test@1234 | call consumption |
#
#    @Keycloak
#    Scenario Outline: When the Configuration API fails, and the menu API also fails
#        Given user logged in using jwt using "<msisdn>" and "<password>"
#        And configuration api is down
#        And menu api is down
#        And no cached content
#        When user refresh home screen
#        Then vov and content cards are not visible
#
#        Examples:
#            | msisdn      | password   |
#            | 01099759221 | Test@1234  |
#            | 01099759221 | Test@1234  |