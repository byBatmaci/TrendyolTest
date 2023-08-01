package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ProductDetails extends ShoppingCart {

    public ProductDetails() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "sticky-aggregations")
    public WebElement fullSticky;

    @FindBy(xpath = "//*[@placeholder='Kategori ara']")
    public WebElement searchCategory;

    @FindBy(xpath = "//*[@placeholder='Beden ara']")
    public WebElement searchSize;

    @FindBy(xpath = "//div[text()='Cinsiyet']")
    public WebElement genderOpen;

    @FindBy(xpath = "//div[text()='Erkek']")
    public WebElement clickGenderMan;

    @FindBy(xpath = "//div[text()='Fiyat']")
    public WebElement priceOpen;

    @FindBy(xpath = "(//*[@class='fltrs'])[4]")
    public WebElement priceBox;


    @FindBy(xpath = "//*[@class='prc-box-dscntd']")
    public WebElement productListAfterFiltre;

    @FindBy(xpath = "(//*[@class='p-card-wrppr with-campaign-view'])[1]")
    public WebElement firstProductBox;

    @FindBy(xpath = "(//*[@class='p-card-wrppr'])[1]")
    public WebElement lastLikeProductBox;



}
