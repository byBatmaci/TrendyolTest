package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import utilities.ConfigReader;
import utilities.Driver;

public class deneme {
    @Given("kullanici {string} girer")
    public void kullanici_girer(String string) {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }
    @When("close driver")
    public void close_driver() {
      Driver.getDriver().close();
    }

}
