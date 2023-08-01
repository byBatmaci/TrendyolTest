package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ShoppingCart extends LikeButtonJobs{
    public ShoppingCart() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//*[@class='pb-basket-item'])[1]")
    public WebElement lastAddedProductInShoppingCartText;
}
