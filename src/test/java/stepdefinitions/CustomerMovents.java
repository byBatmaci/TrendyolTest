package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pages.DropDownSorting;
import pages.HomePageWebElement;
import pages.ProductDetails;
import utilities.Driver;
import utilities.ReusableMethod;

import java.util.List;

public class CustomerMovents {
    ProductDetails pd=new ProductDetails();
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    String expectedTextInProduct;
    int count;
    @When("user selected {string} in category")
    public void user_selected_in_category(String model) {
        ReusableMethod.categorySearchWriteStringAndClick(model);
        ReusableMethod.waitFor(2);

    }
    @And("user selected size shoes")
    public void userSelectedSizeShoes() {
        ReusableMethod.sendKeysWithActions();
        ReusableMethod.waitFor(2);
    }
    @When("user selected gender {string}")
    public void user_selected_gender(String gender) {
        String genderOpenString = "//div[text()='Cinsiyet']";
        ReusableMethod.downWithJS(genderOpenString);
        ReusableMethod.waitFor(1);
        pd.genderOpen.click();
        ReusableMethod.waitFor(1);
        pd.clickGenderMan.click();
        ReusableMethod.waitFor(1);
        ReusableMethod.downWithJS(genderOpenString);
        ReusableMethod.waitFor(1);
        pd.genderOpen.click();
        ReusableMethod.waitFor(1);
    }

    @And("user selected price of the cheapest")
    public void userSelectedPriceOfTheCheapest() {
        String priceOpenString="//div[text()='Fiyat']";
        ReusableMethod.downWithJS(priceOpenString);
        ReusableMethod.waitFor(1);
        pd.priceOpen.click();
        ReusableMethod.waitFor(1);
        List<WebElement> aTags = pd.priceBox.findElements(By.tagName("a"));
        ReusableMethod.waitFor(1);
        ReusableMethod.webElementClickInListWithActions(aTags,1);
        ReusableMethod.waitFor(1);
    }

    @And("user selected price of the cheapest on the sorting price")
    public void userSelectedPriceOfTheCheapestOnTheSortingPrice() {
        ReusableMethod.waitFor(2);
        WebElement a=Driver.getDriver().findElement(By.xpath("//*[@class='banner-rush-delivery']"));
        if (!a.isDisplayed()){
            ReusableMethod.priceSortingBoxClick("En düşük fiyat");
        }else {
            ReusableMethod.dropDownSelect("En düşük fiyat");
        }
        //ReusableMethod.dropDownSelect("En düşük fiyat");
        //ReusableMethod.priceSortingBoxClick("En düşük fiyat");
        ReusableMethod.waitFor(2);
    }

    @And("the user should see the lowest priced product first in the ranking")
    public void theUserShouldSeeTheLowestPricedProductFirstInTheRanking() {
        Assert.assertTrue(ReusableMethod.cheapPriceVerification());
    }

    @When("user liked one of the cheapest")
    public void user_liked_one_of_the_cheapest() {
        expectedTextInProduct=pd.firstProductBox.
                findElement(By.xpath("//*[@class='prdct-desc-cntnr-ttl-w two-line-text']//span[2]")).
                getAttribute("title");
        ReusableMethod.waitFor(1);
        WebElement likeButton=pd.firstProductBox.findElement(By.xpath("//*[@class='fvrt-btn']"));
        likeButton.click();
    }

    @And("user should see click like button")
    public void userShouldSeeClickLikeButton() {
        Assert.assertTrue(ReusableMethod.likeButtonClickVerification());
    }
    @When("user go the favorite list")
    public void user_go_the_favorite_list() {
        pd.favoriLink.click();
    }
    @And("user should be able to see product likes here reference to product name")
    public void userShouldBeAbleToSeeProductLikesHereReferenceToProductName() {
        String actualLikedTitleInProduct=pd.lastLikeProductBox.
                findElement(By.xpath("//*[@class='prdct-desc-cntnr']//span[2]")).
                getAttribute("title");
        Assert.assertEquals(actualLikedTitleInProduct,expectedTextInProduct);
    }


    @And("user clicks add to shopping cart for this favorite product")
    public void userClicksAddToShoppingCartForThisFavoriteProduct() {
        WebElement addShoppinCart=pd.lastLikeProductBox.
                findElement(By.xpath("//*[@class='basket-button   ']"));
        ReusableMethod.scrollIntoViewJS(addShoppinCart);
        ReusableMethod.clickByJS(addShoppinCart);
        count++;
        WebElement text=Driver.getDriver().
                findElement(By.xpath("(//*[@class='prdct-desc-cntnr'])[1]//span[2]"));
        ReusableMethod.scrollIntoViewJS(text);
        expectedTextInProduct=text.getAttribute("title");
    }


    @And("user should see number is rising after click add to shopping cart in next to my shopping cart")
    public void userShouldSeeNumberIsRisingAfterClickAddToShoppingCartInNextToMyShoppingCart() {
        ReusableMethod.scrollIntoViewJS(pd.myShoppingCartCount);
        Assert.assertEquals(count, Integer.parseInt(pd.myShoppingCartCount.getText()));
    }

    @Given("user clicks my shopping cart button")
    public void user_clicks_my_shopping_cart_button() {
        ReusableMethod.scrollIntoViewJS(pd.myShoppingCart);
        ReusableMethod.clickByJS(pd.myShoppingCart);
    }

    @Given("user should be able to see product likes in the my shopping cart list")
    public void user_should_be_able_to_see_product_likes_in_the_my_shopping_cart_list() {
        String actualTextInProduct=pd.lastAddedProductInShoppingCartText.
                findElement(By.xpath("//p[@class='pb-item']")).getAttribute("title");
        System.out.println("actualTextInProduct = " + actualTextInProduct);
        Assert.assertTrue(actualTextInProduct.contains(expectedTextInProduct));
    }

}
