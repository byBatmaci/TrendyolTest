package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Driver;
import utilities.ReusableMethod;

public class SocialMediaButtonVerification{

    public static String a;

    @And("user goes to the bottom of the page")
    public void userGoesToTheBottomOfThePage() {
        ReusableMethod.scrollEndJS();
    }

    @When("user clicks {string} button")
    public void user_clicks_button(String button) {
        WebElement sMButton= Driver.getDriver().
                findElement(By.xpath("//*[@class='footer__wrapper--socialImage sm sm-"+button+"']"));
        sMButton.click();
    }
    @When("user switches to newly opened tab")
    public void user_switches_to_newly_opened_tab() {
        a=ReusableMethod.switchToNewWindow();
    }
    @Then("user should see {string} in the new tab")
    public void user_should_see_in_the_new_tab(String button) {
        ReusableMethod.assertUrlForSocialMedia(button);
    }
    @Then("user closes the new tab")
    public void user_closes_the_new_tab() {
        Driver.getDriver().close();
        Driver.getDriver().switchTo().window(a);



    }

}
