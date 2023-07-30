package pages;

import com.github.dockerjava.api.model.ResponseItem;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DropDownSorting extends HomePageWebElement {
    public DropDownSorting() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //dropdown yapısı bozuluyor. Bunu kullanma
    @FindBy(xpath = "//*[@class='sort-fltr-cntnr']")
    public WebElement sortingDropDown;

    //dropdown yapısı bozuluyor. Bunu kullanma
    @FindBy(xpath = "//*[@class='sort-fltr-cntnr']//select")
    public WebElement sortingDropDownTypes;

    @FindBy(xpath = "//*[@class='search-sort-container']")
    public WebElement sortingBox;





}
