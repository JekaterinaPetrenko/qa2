Feature: This is test to check if email address is valid

  Scenario: Email address checking
    Given QA Test System is opened
    And User registration form is opened
    When User enter the following for registration
      | Field   | Value               |
      | name    | TestName            |
      | surname | TestSurname         |
      | phone   | 33355569            |
      | email   | Test.Test@gmail.com |
    And User confirm registration
    Then User see message Email is not valid




