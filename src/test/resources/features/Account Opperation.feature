@AccountOperation
  Feature: Enter the account and account operation

    Background: go to website
      Given user go to "url"
      When close the popup
      And user click "Giriş Yap" button
      And user enter m "userMail"
      And user enter p "password"
      And enter the giris yap and go homepage

@account_operation-to-comment
      Scenario: account operation
      And user click "Hesabım" button
      And user click trendyol Elite
      And user click yorum yapma
      And user click urunu degerlendir
      When user gift five star product
      And user writer "Urun cok guzel,severek kullaniyorum"
      And user click yorum yap
      And user should see success message for to comment
      And close driver




