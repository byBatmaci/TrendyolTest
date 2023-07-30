@Home_page_verification
  Feature: HomePage verification

    Background: go to website
        Given user go to "url"


    @q1
    Scenario: Button and slide and line in homepage verification
      When close the popup
      When user should in homepage
      And user should "any write" in searchbox
      And user enter the search button
      And actual result verification,result should contains any write

    @q2
    Scenario:user can login and logout website
      And user click "Giriş Yap" button
      And user enter m "userMail"
      And user enter p "password"
      And enter the giris yap and go homepage
      And user should see success message for login
      And user wait "Hesabım" button
      And user logout click
      And user should see success message to for logout

    @q3
    Scenario: First Line verification-SendeAl-SanaOzel-..
      And i should see first category and click the elements inside the category
      And close driver
