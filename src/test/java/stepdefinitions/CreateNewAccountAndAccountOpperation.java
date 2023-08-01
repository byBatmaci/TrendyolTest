package stepdefinitions;

import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import pages.HomePageWebElement;
import pages.ProductDetails;
import utilities.Driver;
import utilities.ReusableMethod;

public class CreateNewAccountAndAccountOpperation {
    //HomePageWebElement hpw = new HomePageWebElement();
    ProductDetails pd=new ProductDetails();

    @When("user click trendyol Elite")
    public void user_click_trendyol_elite() {
        ReusableMethod.waitFor(3);
        ReusableMethod.scrollIntoViewJS(pd.TrendyolElite);
        pd.TrendyolElite.click();
    }
    @When("user click yorum yapma")
    public void user_click_yorum_yapma() {
        ReusableMethod.waitForPageToLoad(12);
        ReusableMethod.scrollIntoViewJS(pd.forToComment);
        pd.forToComment.click();
    }
    @When("user click urunu degerlendir")
    public void user_click_urunu_degerlendir() {
        ReusableMethod.waitForPageToLoad(12);
        if (pd.productEvaluate.isDisplayed()){
            pd.productEvaluate.click();
        }
    }
    @When("user gift five star product")
    public void user_gift_five_star_product() {
        Actions acti=new Actions(Driver.getDriver());
        acti.moveToElement(pd.fiveStar).click(pd.fiveStar).perform();
        //ReusableMethod.hover(pd.fiveStar);
        ReusableMethod.waitFor(3);
        //pd.fiveStar.click();
    }
    @When("user writer {string}")
    public void user_writer(String comment) {
        pd.commentText.sendKeys(comment);
    }
    @When("user click yorum yap")
    public void user_click_yorum_yap() {
        pd.commentButton.click();
    }
    @When("user should see success message for to comment")
    public void user_should_see_success_message_for_to_comment() {
        ReusableMethod.waitForVisibility(pd.checkBox,15);
        Assert.assertTrue(pd.checkBox.isDisplayed());
        Driver.getDriver().findElement(By.xpath("//*[@class='rvw-appr-ftr']/button")).click();
    }
}
