package hooks;
import io.cucumber.java.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.ProductDetails;
import utilities.Driver;
import utilities.ReusableMethod;

public class Hooks {
    ProductDetails productD=new ProductDetails();

    //@BeforeStep("@CustomerMovements")
    @AfterStep("@ChoosingProductCriteria")
    public void closeUpPopUpIf1() {
        if (isPopUp()){
            closePUp();
        }
    }

    private boolean isPopUp(){
        try {
            WebElement body = Driver.getDriver().findElement(By.xpath("//*[@class='overlay']"));
            return body.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }
    private void closePUp(){
        WebElement body = Driver.getDriver().findElement(By.xpath("//*[@class='overlay']"));
        body.click();
    }

}
