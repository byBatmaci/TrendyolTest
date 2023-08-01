package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.ProductDetails;
import utilities.Driver;
import utilities.ReusableMethod;

import java.util.ArrayList;
import java.util.List;

public class ForTheTechnicalSupport {

 ProductDetails pd=new ProductDetails();

    @When("a")
    public void a() {
       /* pd.searchCategory.sendKeys("Sneaker");
        WebElement categoriButton = Driver.getDriver().
                findElement(By.xpath("//div[@class='fltr-item-text' and text()='Sneaker']"));
        categoriButton.click();
        ReusableMethod.waitFor(5);*/
        //buraya kadar sneaker secildi ve tiklandi.
        //*****************************************************//
        //Sirada size var
        /*ReusableMethod.sizeSearchWriteStringAndClick("42");
        ReusableMethod.waitFor(5);*/
        //***********************************************/
        //sırada cinsiyet var
        /*String genderOpenString = "//div[text()='Cinsiyet']";
        ReusableMethod.downWithJS(genderOpenString);
        pd.genderOpen.click();
        pd.clickGenderMan.click();
        ReusableMethod.waitFor(5);
        pd.genderOpen.click();*/
        //************************************************
        //sırada para var
        /*String priceOpenString="//div[text()='Fiyat']";
        ReusableMethod.downWithJS(priceOpenString);
        pd.priceOpen.click();
        List<WebElement> aTags = pd.priceBox.findElements(By.tagName("a"));
        ReusableMethod.webElementClickInListWithActions(aTags,1);
        ReusableMethod.waitFor(5);*/

        //******************************
        //sırada düsük fiyat sıralaması yapılacak
        /*ReusableMethod.priceRanking("En düşük fiyat");
        ReusableMethod.waitFor(5);*/

        //fiyatı en düşük olan ürün seçilecek
        //**************************

      /*  List<WebElement> productPriceList=Driver.getDriver().
                findElements(By.xpath("//*[@class='prc-box-dscntd']"));
        ArrayList<Integer> productPriceInteger=new ArrayList<>();
        for (WebElement a:productPriceList){
            String saltPrice=a.getText().substring(0,a.getText().length()-3);
            int saltPriceInt=Integer.parseInt(saltPrice);
            productPriceInteger.add(saltPriceInt);
        }

        productPriceInteger.forEach(System.out::println);
        int firstPrice=productPriceInteger.get(0);
        for (int i=1;i<productPriceInteger.size();i++){
            if (productPriceInteger.get(i)<firstPrice){
            }
        }*/

      /*  List<WebElement> productPriceList = Driver.getDriver().
                findElements(By.xpath("//*[@class='prc-box-dscntd']"));
        Assert.assertTrue(ReusableMethod.cheapPriceVerification());*/
        WebElement a=Driver.getDriver().findElement(By.xpath("(//*[@class='p-card-wrppr'])[1]"));
        System.out.println("a.getAttribute(\"data-id\") = " + a.getAttribute("data-id"));

    }
}



