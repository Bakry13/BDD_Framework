Feature: Login
  Check positive and negative scenarios for login feature

  @Keycloak
  Scenario Outline: user login with registered msisdn and valid/invalid password
    When   user login using "<msisdn>" and "<password>" with "<status>"
    Then    view "<result>" based on password "<status>" with errorMsg "<msgEn>" , "<msgAr>"
        # check database inserted data
    Examples:
      | msisdn      | password  | result       | status  | msgEn                       | msgAr                   |
      | 01068051444 | Test@1234 | home         | valid   | NONE                        | NONE                    |
      | 01068051444 | TesT@1234 | errorMessage | invalid | Incorrect login credentials | بيانات الدخول غير صحيحة |