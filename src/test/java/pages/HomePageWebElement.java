package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import javax.swing.*;

public class HomePageWebElement {

    public HomePageWebElement() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id='logo']")
    public WebElement logo;

    @FindBy(xpath = "//*[@class='V8wbcUhU']")
    public WebElement searchBoxTextBase;

    @FindBy(xpath = "//*[@class='dscrptn']")
    public WebElement searchResultText;

    @FindBy(xpath = "//*[@id=\"onetrust-accept-btn-handler\"]")
    public WebElement popUpClose;

    @FindBy(xpath = "//*[@class='modal-close']")
    public WebElement advertClose;

    @FindBy(xpath = "//*[@class='link account-user']")
    public WebElement girisYap;

    @FindBy(id = "login-email")
    public WebElement emailText;

    @FindBy(id = "login-password-input")
    public WebElement passwordText;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement userEnterButton;

    @FindBy(xpath = "//*[@class='user-name']")
    public WebElement verificationTextToEnter;

    @FindBy(xpath = "//*[@class='i-exit-flat']")
    public WebElement logoutButton;

    @FindBy(xpath = "//*[@class='main-nav']")
    public WebElement FirstKatagoriList;

    @FindBy(xpath = "//span[text()='Trendyol Elite']")
    public WebElement TrendyolElite;

    @FindBy(xpath = "//*[@class='point-rules-icon REVIEW']")
    public WebElement forToComment;

    @FindBy(xpath = "(//*[@class='card-rate-button'])[1]")
    public WebElement productEvaluate;

    @FindBy(xpath = "//*[@class='ratings']//div[@class='star-w'][5]")
    public WebElement fiveStar;

    @FindBy(xpath = "//*[@class='tbwrapper']/textarea")
    public WebElement commentText;

    @FindBy(xpath = "(//*[@class='button'])[2]")
    public WebElement commentButton;

    @FindBy(xpath = "//*[@class='check']")
    public WebElement checkBox;

    @FindBy(xpath = "(//*[@class='fltr-srch-inpt'])[1]")
    public WebElement categorySearch;

    @FindBy(xpath = "//input[@placeholder='Beden ara']")
    public WebElement sizeSearch;

    @FindBy(xpath = "'(//*[@class='chckbox'])[1]'")
    public WebElement categoryClickButton;

    /*@FindBy(xpath = "(//*[@class='i-dropdown-arrow transform'])[5]")
    public WebElement genderSelect;

    @FindBy(xpath = "(//*[@class='i-dropdown-arrow'])[2]")
    public WebElement genderOpen;*/

    @FindBy(xpath = "(//p[text()='Sepetim'])[1]")
    public WebElement myShoppingCart;

    @FindBy(xpath = "//*[@class='basket-item-count-container visible']")
    public WebElement myShoppingCartCount;

}
