package utilities;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePageWebElement;
import pages.ProductDetails;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ReusableMethod {
    static HomePageWebElement hpw = new HomePageWebElement();
    static ProductDetails productDetails = new ProductDetails();

    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));

    }

    public static void clickByJS(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", element);
    }

    public static void waitForPageToLoad(long timeout) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            System.out.println("Waiting for page to load...");
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
            wait.until(expectation);
        } catch (Throwable error) {
            System.out.println(
                    "Timeout waiting for Page Load Request to complete after " + timeout + " seconds");
        }
    }

    public static void hover(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }

    public static void waitFor(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static WebElement waitForVisibility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void scrollEndJS() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        // x koordınatı sabit sayfanın uzunlugu kadar asagı indir
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    public static void listElementsClickableVerification(List<WebElement> elements) {
        for (int i = 0; i < elements.size(); i++) {
            if (i == 9 || i == 10 || i==11) {
                break;
            }
            WebElement category = elements.get(i);
            hover(category);
            List<WebElement> insideCategory = Driver.getDriver().
                    findElements(By.xpath("//*[@class='tab-link'][" + (i + 1) + "]/div/div/div/div/div/ul/li"));
            for (WebElement a : insideCategory) {
                ReusableMethod.waitForVisibility(a, 3);
                Assert.assertTrue(a.isDisplayed());
            }

        }
    }

    public static void scrollIntoViewJS(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static String switchToNewWindow() {
        String currentTab = Driver.getDriver().getWindowHandle();

        for (String tab : Driver.getDriver().getWindowHandles()) {
            if (!tab.equals(currentTab)) {
                Driver.getDriver().switchTo().window(tab);
                break;
            }
        }
        return currentTab;
    }

    public static void assertUrlForSocialMedia(String string) {
        String currentTab = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(currentTab.contains(string));
    }

    public static void categorySearchWriteStringAndClick(String model) {
        ReusableMethod.waitFor(4);
        productDetails.searchCategory.sendKeys(model);
        WebElement categoriButton = Driver.getDriver().
                findElement(By.xpath("//div[@class='fltr-item-text' and text()='" + model + "']"));
        ReusableMethod.waitForVisibility(categoriButton, 15);
        categoriButton.click();
        ReusableMethod.waitForPageToLoad(15);
    }

    public static void sizeSearchWriteStringAndClick(String size) {
        ReusableMethod.waitForVisibility(productDetails.searchSize, 15);
        productDetails.searchSize.sendKeys(size);
        ReusableMethod.waitForPageToLoad(15);
        WebElement expectedSize = Driver.getDriver().
                findElement(By.xpath("//div[text()='" + size + "']"));
        ReusableMethod.waitForClickablility(expectedSize, 15);
        expectedSize.click();
        ReusableMethod.waitForPageToLoad(15);
    }


    public static void containnerDown() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
        jsExecutor.executeScript("arguments[0].scrollTop += 250;", productDetails.fullSticky);
    }

    public static void webElementClickInListWithActions(List<WebElement> list, int expectedWebElement) {
        WebElement expectedProduct = list.get(expectedWebElement - 1);
        Actions actions=new Actions(Driver.getDriver());
        actions.click(expectedProduct).perform();
    }

    public static void downWithJS(String xpathExpected) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
        String script = "var genderOpen = document.evaluate(\"" + xpathExpected + "\"," +
                " document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;" +
                "if (genderOpen) {" +
                "    genderOpen.scrollIntoView();" +
                "}";
        jsExecutor.executeScript(script, productDetails.fullSticky);
    }

    //yapi degistigi icin fail aliyor.
    public static void dropDownSelect(String expectedInTextSelect) {
        //productDetails.sortingDropDown.click();
        Select dropdown = new Select(productDetails.sortingDropDownTypes);
        dropdown.selectByVisibleText(expectedInTextSelect);
    }

    public static void priceSortingBoxClick(String expectedInTextSelect){
        Actions actions=new Actions(Driver.getDriver());
        actions.click(productDetails.sortingBox).perform();
        //ReusableMethod.clickByJS(productDetails.sortingBox);
        ReusableMethod.waitFor(2);
        WebElement expected=Driver.getDriver().
                findElement(By.xpath("//li[text()='"+expectedInTextSelect+"']"));
        //expected.click();
        ReusableMethod.clickByJS(expected);



    }
    public static void priceRanking(String expectedLi) {
        productDetails.sortingDropDown.click();
        WebElement expected=Driver.getDriver().
                findElement(By.xpath("//*[@class='search-dropdown']//li[text()='"+expectedLi+"']"));
        expected.click();
    }

    public static boolean cheapPriceVerification() {
        ReusableMethod.waitFor(2);
        List<WebElement> productPriceList = Driver.getDriver().
                findElements(By.xpath("//*[@class='prc-box-dscntd']"));
        ArrayList<Integer> productPriceInteger = new ArrayList<>();
        for (WebElement a : productPriceList) {
            String saltPrice = a.getText().substring(0,3);
            System.out.println("a.getText() = " + a.getText());
            int saltPriceInt = Integer.parseInt(saltPrice);
            productPriceInteger.add(saltPriceInt);
        }

        int firstPrice = productPriceInteger.get(0);
        for (int i = 1; i < productPriceInteger.size(); i++) {
            if (productPriceInteger.get(i) < firstPrice) {
                return false;
            }
        }
        return true;
    }

    public static void sendKeysWithActions(){
        Actions actions = new Actions(Driver.getDriver());
        actions.click(productDetails.searchSize).sendKeys("42").perform();
        WebElement expectedSize = Driver.getDriver().
                findElement(By.xpath("//div[text()='42']"));
        ReusableMethod.waitForClickablility(expectedSize, 15);
        expectedSize.click();
    }

    public static boolean likeButtonClickVerification(){
        productDetails.clickedLikeButton.isDisplayed();
        return true;
    }


}
