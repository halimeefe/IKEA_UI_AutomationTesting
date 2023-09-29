package StepDefinitions;

import Pages.DialogContent;
import Utilities.PageDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SwedishRestaurant_Steps {



    DialogContent dc=new DialogContent();


    WebDriverWait wait=new WebDriverWait(PageDriver.getDriver(), Duration.ofSeconds(20));

    @When("Click to view restaurant menu")
    public void clickToViewRestaurantMenu() {

        dc.clickFunc(dc.isvecRest);
    }

    @And("Click on the Dessert menu")
    public void clickOnTheDessertMenu() {
        dc.clickFunc(dc.restMenu);
        dc.clickFunc(dc.desertMenu);

    }

    @And("Print the price of  Apple Tart")
    public void printThePriceOfAppleTart() {

        By PriceResult = By.xpath("(//*[@class='product-bottom'])[25]/h4/following-sibling::div//span");

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(PriceResult));
        String ürünFiyat = element.getText();
        System.out.println("Elmalı Tart Fiyatı: " +ürünFiyat);

    }
}
