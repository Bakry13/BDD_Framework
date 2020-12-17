Feature: Update
  As a user I want to check all update overlay scenarios on home
  @Keycloak
  Scenario Outline: Validate that update dialog appears when build number is less than last build number
    Given build number is less than last build number
    When  user login by jwt using "<msisdn>" and "<password>"
    Then  validate that update dialog exists

    Examples:
      | msisdn      | password  |
      | 01068051444 | Test@1234 |