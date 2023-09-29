package StepDefinitions;

import Pages.DialogContent;
import Utilities.PageDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InquireStock_Steps {

    DialogContent dc=new DialogContent();


    WebDriverWait wait=new WebDriverWait(PageDriver.getDriver(), Duration.ofSeconds(20));


    @When("Click on Products")
    public void clickOnProducts() {
        dc.clickFunc(dc.products);


    }

    @And("Click on Decoration")
    public void clickOnDecoration() {
        dc.clickFunc(dc.dekoration);

    }

    @And("Click on the Vases")
    public void clickOnTheVases() {
        dc.clickFunc(dc.vases);

    }

    @And("Random select a vase and copy the product's code number")
    public void randomSelectAVaseAndCopyTheProductSCodeNumber() {

        dc.clickFunc(dc.glassVase);
        dc.clickFunc(dc.firstProduct);

        String mainWindowHandle = PageDriver.getDriver().getWindowHandle();

        // Yeni pencereye geçiş yap
        for (String windowHandle :PageDriver.getDriver().getWindowHandles()) {
            if (!windowHandle.equals(mainWindowHandle)) {
                PageDriver.getDriver().switchTo().window(windowHandle);
                break;
            }
        }


        String ProductCode = "205.119.53";

        By elementLocator = By.cssSelector("[class='product-code']");
       WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));


      String actualCode = element.getText();
      System.out.println("Beklenen Ürün Kodu: " + ProductCode);
      System.out.println("Gerçek Ürün Kodu: " + actualCode);


    }

    @And("Click onStock Query")
    public void clickOnStockQuery() {
        dc.clickFunc(dc.checkStock);

    }

    @And("Type the product code select a store")
    public void typeTheProductCodeSelectAStore() {
        dc.sendKeysFunc(dc.inputCode,"205.119.53");
        dc.clickFunc(dc.selectStore);
        dc.clickFunc(dc.storeAdress);

    }

    @And("Verify stock information")
    public void verifyStockInformation() {

        dc.clickFunc(dc.check);

        By checkResult = By.xpath("//*[@class='stock-progress over']/span[2]");

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(checkResult));
        String kontrolSonucu = element.getText();
        System.out.println("Kontrol Sonucu: " +kontrolSonucu);


    }
}
