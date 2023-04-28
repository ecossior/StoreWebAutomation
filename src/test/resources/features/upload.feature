Feature: Upload images

  Scenario: Upload a set of images
    Given the Wep App should be enabled
    When the user uploads a set of images:
      | pato.jpg    |
      | poke.jpg    |
      | star.jpg    |
      | tortuga.jpg |
      | mon.png     |
      | murci.jpg   |
    Then the user should see the Images list uploaded