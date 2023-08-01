package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import jdk.dynalink.linker.LinkerServices;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.HomePageWebElement;
import pages.ProductDetails;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethod;

import java.util.List;

public class Homepage_Verification {
    HomePageWebElement hpw = new HomePageWebElement();
    ProductDetails pd=new ProductDetails();

    @Given("user go to {string}")
    public void user_go_to(String string) {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }

    @When("close the popup")
    public void closeThePopup() {
        ReusableMethod.waitForPageToLoad(20);
        pd.popUpClose.click();
    }

    @When("user should in homepage")
    public void user_should_in_homepage() {
        Assert.assertTrue(pd.logo.isDisplayed());
    }

    @And("user should {string} in searchbox")
    public void userShouldInSearchbox(String arg0) {
        ReusableMethod.waitForClickablility(pd.searchBoxTextBase, 15);
        pd.searchBoxTextBase.sendKeys(ConfigReader.getProperty("anyWrite"));
    }

    @And("user enter the search button")
    public void userEnterTheSearchButton() {
        pd.searchBoxTextBase.sendKeys(Keys.ENTER);
    }

    @And("actual result verification,result should contains any write")
    public void actualResultVerificationResultShouldContainsAnyWrite() {
        //String s=ConfigReader.getProperty("anyWrite");
        String result = Driver.getDriver().
                findElement(By.xpath("//*[@class='srch-ttl-cntnr-wrppr']")).getText();
        Assert.assertTrue(result.contains(ConfigReader.getProperty("anyWrite")));
    }

    @And("user click {string} button")
    public void iClickLoginOrAccountButton(String buttonType) {
        WebElement button=Driver.getDriver().
                findElement(By.xpath("//p[normalize-space(text())='"+buttonType+"']"));
        button.click();
    }

    @And("user enter m {string}")
    public void userEnterM(String arg0) {
        pd.emailText.sendKeys(ConfigReader.getProperty("userMail"));
    }

    @And("user enter p {string}")
    public void userEnterP(String arg0) {
        pd.passwordText.sendKeys(ConfigReader.getProperty("password"));
    }


    @When("enter the giris yap and go homepage")
    public void enter_the_giris_yap_and_go_homepage() {
        pd.userEnterButton.click();
        ReusableMethod.waitFor(7);
        ReusableMethod.waitForClickablility(hpw.logo,15);
    }

    @And("user should see success message for login")
    public void userShouldSeeSuccessMessageForLogin() {
        ReusableMethod.waitFor(4);
        pd.logo.click();
    }

    @And("user wait {string} button")
    public void userWaitButton(String buttonType) {
        WebElement button=Driver.getDriver().
                findElement(By.xpath("//p[normalize-space(text())='"+buttonType+"']"));
        ReusableMethod.waitForVisibility(button,15);
        ReusableMethod.hover(button);
    }

    @And("user logout click")
    public void userLogoutClick() {
        pd.logoutButton.click();
    }

    @And("user should see success message to for logout")
    public void userShouldSeeSuccessMessageToForLogout() {
        ReusableMethod.waitForPageToLoad(15);
        String expected="Giriş Yap";
        Assert.assertEquals(expected,pd.girisYap.getText());
    }
    @And("i should see first category and click the elements inside the category")
    public void iShouldSeeFirstCategoryAndClickTheElementsInsideTheCategory() {
        List<WebElement> categoryList=Driver.getDriver().
                findElements(By.xpath("//*[@class='tab-link']"));
        ReusableMethod.listElementsClickableVerification(categoryList);
    }
    @And("close driver")
    public void closeDriver() {
        Driver.getDriver().close();
    }
}