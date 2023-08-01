@CustomerMovements
Feature: Product search,liking the product,add product to cart

  Scenario: Enter The WebSite
    Given user go to "url"
    When close the popup
    And user click "Giriş Yap" button
    And user enter m "userMail"
    And user enter p "password"
    And enter the giris yap and go homepage

  @SearchProduct
  Scenario: search product
    When user should in homepage
    And user should "any write" in searchbox
    And user enter the search button
    And actual result verification,result should contains any write

  @LikingTheProduct
  Scenario: liking the product
    And user selected "Sneaker" in category
    And user selected size shoes
    And user selected gender "erkek"
    And user selected price of the cheapest
    And user selected price of the cheapest on the sorting price
    And the user should see the lowest priced product first in the ranking
    And user liked one of the cheapest
    And user should see click like button
    And user go the favorite list
    And user should be able to see product likes here reference to product name

  @AddToShoppingCart-WhenInFavorites
  Scenario: add product to shopping cart
    And user clicks add to shopping cart for this favorite product
    And user should see number is rising after click add to shopping cart in next to my shopping cart
    And user clicks my shopping cart button
    And user should be able to see product likes in the my shopping cart list
    And close driver




