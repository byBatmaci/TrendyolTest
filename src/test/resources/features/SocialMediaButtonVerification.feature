@Social_Media
Feature: Social Media Button Verification


  Scenario: Enter The WebSite
    Given user go to "url"
    When close the popup
    And user click "Giriş Yap" button
    And user enter m "userMail"
    And user enter p "password"
    And enter the giris yap and go homepage
    And user goes to the bottom of the page

  Scenario Outline: Verify Social Media Buttons
    When user clicks "<button_name>" button
    And user switches to newly opened tab
    Then user should see "<button_name>" in the new tab
    And user closes the new tab

    Examples:
      | button_name |
      | facebook    |
      | instagram   |
      | twitter     |
      | youtube     |