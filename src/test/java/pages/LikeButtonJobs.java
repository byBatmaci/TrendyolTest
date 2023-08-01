package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LikeButtonJobs extends DropDownSorting{

    public LikeButtonJobs() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//*[@class='p-card-wrppr with-campaign-view'])[1]//*[@class='fvrt-btn fvred']")
    public WebElement clickedLikeButton;

    @FindBy(xpath = "//p[text()='Favorilerim']")
    public WebElement favoriLink;




}
