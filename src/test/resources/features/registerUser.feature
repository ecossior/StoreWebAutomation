Feature: Login

  Scenario Outline: Register new user account
    Given the user opens login page
    And enters an account that it is not registered <email> <password>
    And the Login page displays, "Your email or password is incorrect!"
    When the user enters <name> and <email> for New User Signup
    And enters information to create a new account
      | title         | Mr                    |
      | password      | P@ssw0rd96            |
      | day           | 15                    |
      | month         | July                  |
      | year          | 2000                  |
      | newsletter    | y                     |
      | receiveOffers | y                     |
      | firstName     | Carlos                |
      | lastName      | Rojas                 |
      | company       | Company01             |
      | address       | 2602 W Townley Ave #5 |
      | address2      | 7017 E McDowell Rd    |
      | country       | United States         |
      | state         | Arkansas              |
      | city          | Phoenix               |
      | zipcode       | 85021                 |
      | mobileNumber  | (602) 997-2101        |
    Then the user should see in Account Created page: ACCOUNT CREATED!
    Examples:
      | name   | email          | password   |
      | Carlos | bdd10@gmail.com | P@ssw0rd96 |
