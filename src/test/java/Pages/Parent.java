package Pages;

import Utilities.PageDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Parent {

    WebDriverWait wait = new WebDriverWait(PageDriver.getDriver(), Duration.ofSeconds(20));

    public void sendKeysFunc(WebElement element, String text) {
        waitUntilVisible(element);
        scrollToElement(element);
        element.clear();
        element.sendKeys(text);
    }

    public void clickFunc(WebElement element) {
        waitUntilClickable(element);
        scrollToElement(element);
        element.click();
    }


    public void scrollToElement(WebElement element) {

        JavascriptExecutor js = (JavascriptExecutor) PageDriver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(false);", element); // false elementi sayfanın altında görünür hale getirir
        // true ise sayfanın üstüne kaydırma işlemi yapar.
    }

    public void verifyContainsTextFunction(WebElement element, String value) {
        wait.until(ExpectedConditions.textToBePresentInElement(element, value));
        Assert.assertTrue(element.getText().toLowerCase().contains(value.toLowerCase()));
        new Actions(PageDriver.getDriver()).sendKeys(Keys.ESCAPE).perform();
    }




    public void waitUntilVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


}
