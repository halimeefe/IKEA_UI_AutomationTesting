package StepDefinitions;

import Pages.DialogContent;
import Utilities.PageDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class ClosestToYouIKEA_Steps {


    DialogContent dc=new DialogContent();

    WebDriverWait wait=new WebDriverWait(PageDriver.getDriver(), Duration.ofSeconds(20));

    @Given("Navigate to website")
    public void navigateToWebsite() {
        PageDriver.getDriver().get("https://www.ikea.com.tr");
        PageDriver.getDriver().manage().window().maximize();


    }

    @When("Verify you are on the IKEA website")
    public void verifyYouAreOnTheIKEAWebsite() {
        String expectedUrl="https://www.ikea.com.tr";
        String actualUrl=PageDriver.getDriver().getCurrentUrl();
        Assert.assertNotEquals(expectedUrl,actualUrl,"URL'ler eşleşmiyor" );




    }

    @And("Click on the Ikea tab closest to you")
    public void clickOnTheIkeaTabClosestToYou() {
        dc.clickFunc(dc.closeIkea);
    }

    @And("Random choose an IKEA store")
    public void randomChooseAnIKEAStore() {


        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='row'])[4]/div[2]/a")));
        dc.clickFunc(dc.store);
    }

    @And("Print the store's address and working hours information to an Excel file")
    public void printTheStoreSAddressAndWorkingHoursInformationToAnExcelFile() {



      wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='address-block']>div")));

        List<WebElement> storeInfo=PageDriver.getDriver().findElements(By.cssSelector("[class='address-block']>div"));


        Workbook workbook=new XSSFWorkbook();
        Sheet sheet =workbook.createSheet("Mağaza Adres Bilgileri");

        for (int i = 0; i < storeInfo.size(); i++) {

            WebElement store=storeInfo.get(i);
            Row row =sheet.createRow(i);

            String storeText=store.getText();
            String[] magazaInfo=storeText.split("\n");

            for (int j = 0; j < magazaInfo.length; j++) {
                Cell cell=row.createCell(j);
                cell.setCellValue(magazaInfo[j].trim());


            }


        }

        try (FileOutputStream outputStream = new FileOutputStream("Mağaza Adres Bilgileri.xlsx")) {//Excel dosyasına verileri yazmak için
            // bir çıktı akışı oluşturur ve dosyayı kaydeder.
            workbook.write(outputStream);// bu satır verilerin dosyaya yazılmasını gerçekleştirir.
        } catch (IOException e) { //eğer bir hata (IOException) meydana gelirse, bu hatayı yakalar ve ekrana yazdırır
            e.printStackTrace();

            }
        }


    @And("Return to home page")
    public void returnToHomePage() {
        for (int i = 0; i < 2; i++) {
            PageDriver.getDriver().navigate().back();


        }

    }
    @Then("verify you are back to the home page")
    public void verifyYouAreBackToTheHomePage() {
        String HomePageUrl = PageDriver.getDriver().getCurrentUrl();
        System.out.println("Home Page URL: "+HomePageUrl);


    }




    }





