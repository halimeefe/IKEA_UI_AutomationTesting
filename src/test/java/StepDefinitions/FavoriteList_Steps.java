package StepDefinitions;

import Pages.DialogContent;
import Utilities.PageDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.math3.analysis.function.Exp;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class FavoriteList_Steps {


    DialogContent dc=new DialogContent();

    WebDriverWait wait=new WebDriverWait(PageDriver.getDriver(), Duration.ofSeconds(60));



    @When("Click on all furniture")
    public void clickOnAllFurniture() {

        dc.clickFunc(dc.products);
        dc.clickFunc(dc.allFurniture);


    }

    @And("Click on garden furniture")
    public void clickOnGardenFurniture() {
        dc.clickFunc(dc.gardenFurniture);

    }

    @And("Click on the Garden tables")
    public void clickOnTheGardenTables() {
        dc.clickFunc(dc.gardenTable);
    }

    @And("Random choose a product")
    public void randomChooseAProduct() {
        dc.clickFunc(dc.randomProduct);
    }

    @And("Add product to favorites")
    public void addProductToFavorites()  {


        String mainWindowHandle = PageDriver.getDriver().getWindowHandle();

        // Yeni pencereye geçiş yap
        for (String windowHandle :PageDriver.getDriver().getWindowHandles()) {
            if (!windowHandle.equals(mainWindowHandle)) {
                PageDriver.getDriver().switchTo().window(windowHandle);
                break;
            }
        }
        dc.clickFunc(dc.favoriBtn);

        dc.clickFunc(dc.closeMember);
    }

    @And("Go to favorites and add the selected product to the cart")
    public void goToFavoritesAndAddTheSelectedProductToTheCart() {
        wait.until(ExpectedConditions.visibilityOf(dc.goFavori));
        dc.clickFunc(dc.goFavori);

        JavascriptExecutor jsExecutor = (JavascriptExecutor) PageDriver.getDriver();

        By elementLocator = By.cssSelector("[class='btn btn-basket btn-block']");
        WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));

        // Sayfayı hafifçe aşağı kaydır
        jsExecutor.executeScript("window.scrollBy(0, -100);");
        element.click();

    }

    @And("Go to cart and delete the product")
    public void goToCartAndDeleteTheProduct() {
        dc.clickFunc(dc.goCart1);
        dc.clickFunc(dc.goCart2);
        dc.clickFunc(dc.continueClick);
        dc.clickFunc(dc.deleteProduct);



    }

    @And("Verify cart is empty")
    public void verifyCartIsEmpty() {

        dc.verifyContainsTextFunction(dc.verifyBasket,"Alışveriş Sepetiniz şu anda boş");

    }


    @And("Go back to home page")
    public void goBackToHomePage() {
        dc.clickFunc(dc.startShopping);
    }
}
