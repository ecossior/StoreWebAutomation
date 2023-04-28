Feature: Select a date
  As an user, I want to select a date in the page.

  Scenario Outline: Select a date in the calendar
    Given the DateWeb app should be enabled
    When the user displays the calendar
    And enters the following date: <selectDate>
    Examples:
      | selectDate       |
      | 1 May 2024       |



# Tests:
#  32 May 2023
#  50 May 2023
#  1 May 2024
#  30 February 2024
#  29 February 2024
