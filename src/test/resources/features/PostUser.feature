Feature: Rest Service with serenity

  @PostUser
  Scenario: Rest user store

    When I use my API request for testing CRUD
    Then I validate the response of my API is 200




