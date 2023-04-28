Feature: Buying products online

  Background: login
    Given the web should be enabled

  Scenario Outline: It allows perform all buy process 'by category' via online.
    When the user selects items from Clothing Catalog
      | category | type  | name             | quantity |
      | Women    | Dress | Sleeveless Dress | 3        |
      | Women    | Tops  | Blue Top         | 1        |
    And reviews the Shopping Card with selected products
    And adds a comment to Order: "This is my order"
    And enters info about the credit card
      | name   | cardNumber   | CVC   | month   | year   |
      | <name> | <cardNumber> | <CVC> | <month> | <year> |
    And confirms the process payment
    Then the user should see this message Congratulations! Your order has been confirmed!
    Examples:
      | name         | cardNumber       | CVC | month | year |
      | Carlos Rojas | 4532063711734092 | 8   | 2025  | 750  |

  Scenario Outline: It allows perform all buy process using 'Search' via online.
    Given the user navigates to Products page
    When the user searches^chooses items from list
      | Premium Polo T-Shirts          |
      | Soft Stretch Jeans             |
      | Blue Cotton Indie Mickey Dress |
      | Frozen Tops For Kids           |
      | Sleeves Printed Top - White    |
      | Winter Top                     |
      | Sleeveless Dress               |
      | Fancy Green Top                |
    And reviews the Shopping Card with selected products
    And adds a comment to Order: "This is my order"
    And enters info about the credit card
      | name   | cardNumber   | CVC   | month   | year   |
      | <name> | <cardNumber> | <CVC> | <month> | <year> |
    And confirms the process payment
    Then the user should see this message Congratulations! Your order has been confirmed!
    Examples:
      | name         | cardNumber       | CVC | month | year |
      | Carlos Rojas | 4532063711734092 | 8   | 2025  | 750  |


#  Dudas
#  -locator add to cart directo
#  - waits ... cuando usar
#        wait until visibilityOf
#                   elementToBeClickable
#                  .presenceOfElementLocated(
#
