package Pages;

import Utilities.PageDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DialogContent extends Parent{


    public DialogContent(){
        PageFactory.initElements(PageDriver.getDriver(),this);


    }


   @FindBy (css = "[class='links']>a:first-child ")
    public WebElement closeIkea;

    @FindBy (xpath = "(//div[@class='row'])[4]/div[2]/a")
    public WebElement store;

    @FindBy (css = "[class='header-nav']>ul>li:first-child")
    public WebElement products;

    @FindBy (css = "[class='font-weight-bold']:first-child>a")
    public WebElement allFurniture;

    @FindBy (xpath = "(//*[@class='category-item'])[22]")
    public WebElement gardenFurniture;

    @FindBy (css = "[alt='IKEA Bahçe Masaları']")
    public WebElement gardenTable;

    @FindBy (xpath = "(//*[@class='product-item'])[1]")
    public WebElement randomProduct;

    @FindBy (xpath = "(//*[@class='product-detail-btn'])/a[2]")
    public WebElement favoriBtn;

    @FindBy (xpath = "(//*[@class='global-modal-header'])[5]/a")
    public WebElement closeMember;

    @FindBy (css = "[class='icon-new-fav']")
    public WebElement goFavori;


    @FindBy (css = "[class='shopping-basket']")
    public WebElement goCart1;


    @FindBy (xpath = "//*[text()='Sepete Git']")
    public WebElement goCart2;

    @FindBy (xpath = "//*[text()='Üye Olmadan Devam Et']")
    public WebElement continueClick;

    @FindBy (xpath = "(//*[text()='Ürünü Sil'])[2]")
    public WebElement deleteProduct;

    @FindBy (xpath = "//*[text()='Alışveriş Sepetiniz şu anda boş']")
    public WebElement verifyBasket;

    @FindBy (xpath = "//*[text()='Alışverişe Başla']")
    public WebElement startShopping;

    @FindBy (xpath = "(//*[text()='Dekorasyon'])[1]")
    public WebElement dekoration;

    @FindBy (xpath = "//*[text()='Vazolar']")
    public WebElement vases;

    @FindBy (xpath = "(//*[@class='category-item-box']/div/a)[2]")
    public WebElement glassVase;

    @FindBy (xpath = "(//*[@class='product-item'])[1]")
    public WebElement firstProduct;

    @FindBy (xpath = "//*[@class='links']/a[9]")
   public WebElement checkStock;

    @FindBy (css = "[id='txtSPRCode']")
   public WebElement inputCode;

    @FindBy (xpath = "(//*[@aria-expanded='false'])[2]")
   public WebElement selectStore;

    @FindBy (xpath = "//*[@class='select2-results__options']/li[5]")
    public WebElement storeAdress;

    @FindBy (css = "[id='btnCheckStock']")
   public WebElement check;

    @FindBy (css = "[class='links'] >a:nth-child(5)")
    public WebElement isvecRest;

    @FindBy (xpath = "//*[text()='Restoran menüsünü görüntüleyin']")
  public WebElement restMenu;

    @FindBy (css = "[alt='Tatlı Menüsü']")
   public WebElement desertMenu;


















































}
