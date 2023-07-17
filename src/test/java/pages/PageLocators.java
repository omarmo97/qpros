package pages;

import Base.BaseClass;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

import static helpers.ElementHelper.*;
@Getter
public class PageLocators extends BaseClass {

    public PageLocators(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);
    }
@FindBy(xpath = "//a[@id='signin2']")
    private WebElement signUp;

    @FindBy(xpath = "//input[@id='sign-username']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@id='sign-password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@onclick='register()']")
    private WebElement signUpButton;


    @FindBy(xpath = "//a[@id='login2']")
    private WebElement logIn;

    @FindBy(xpath = "//input[@id='loginusername']")
    private WebElement logInUserName ;

    @FindBy(xpath = "//input[@id='loginpassword']")
    private WebElement logInPassword;

    @FindBy(xpath = "//button[@onclick='logIn()']")
    private WebElement logInButton;

    @FindBy(xpath = "//a[@id='itemc']")
    private List<WebElement>  category ;

    @FindBy(xpath = "//a[@class='btn btn-success btn-lg']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div[@class='col-lg-4 col-md-6 mb-4']")
    private List<WebElement>  items ;

    @FindBy(xpath = "//a[@id='cartur']")
    private WebElement cart;

    @FindBy(xpath = "//a[text()='Delete']")
    private WebElement deleteButton ;

    @FindBy(xpath = "(//a[@class='nav-link'])[1]")
    private WebElement homeButton;

    @FindBy(xpath = "//button[@class='btn btn-success']")
    private WebElement placeOrderButton ;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement nameField;

    @FindBy(xpath = "//input[@id='card']")
    private WebElement cardField;

    @FindBy(xpath = "//div[@class='sa-placeholder']")
    private WebElement success;

    @FindBy(xpath = "//button[@onclick='purchaseOrder()']")
    private WebElement purchaseButton;


          Random random = new Random();
          String userName = "omar"+random.nextInt(2000)+"";
          String password = "omar123";


    public void register(){
     elementToBeVisible(signUp).click();
     elementToBeVisible(usernameField).sendKeys(userName);
     elementToBeVisible(passwordField).sendKeys(password);
     elementToBeClickable(signUpButton).click();
     waitForTime(1000);
     String a = webDriver.switchTo().alert().getText();
        System.out.println(a);
        webDriver.switchTo().alert().accept();
        System.out.println("the username : "+userName+"");
   }

   public void logIn(){
       elementToBeVisible(logIn).click();
       elementToBeVisible(logInUserName).sendKeys(userName);
       elementToBeVisible(logInPassword).sendKeys(password);
       elementToBeClickable(logInButton).click();
       waitForTime(400);


   }
   public void checkCategory(){
        waitForTime(2000);

       for (WebElement cat : category){
         cat.click();
        if (items.size()>0){
            System.out.println("the category has items");
        }
        else {
            System.out.println("the category has no items");
        }
       }
   }
   public void addRandom(){
        waitForTime(400);
       waitForTime(2000);
        int randomIndex =random.nextInt(category.size()) ;
        WebElement randomCat= category.get(randomIndex);
        randomCat.click();



        waitForTime(3000);
        if(items.size() == 1){
            elementToBeVisible(this.items.get(0)).click();


        }
             else if(items.size()>1) {
              int randomIndex1 = random.nextInt(items.size());
              WebElement randomItem = items.get(randomIndex1);
            elementToBeVisible(randomItem).click();

        }

       elementToBeClickable(this.addToCartButton).click();
       waitForTime(1500);
       webDriver.switchTo().alert().accept();
       waitForTime(500);
       elementToBeVisible(this.cart).click();
       waitForTime(1500);
       System.out.println(webDriver.findElement(By.xpath("//tbody[@id='tbodyid']")).getSize());

   }
   public void removeItem(){
       elementToBeClickable(this.homeButton).click();
        elementToBeClickable(this.cart).click();
        elementToBeVisible(this.deleteButton).click();
        waitForTime(1500);

   }
   public void checkOut(){
       elementToBeVisible(this.placeOrderButton).click();
       elementToBeVisible(this.nameField).sendKeys("omar");
       elementToBeVisible(this.cardField).sendKeys("424242424242");
       elementToBeClickable(this.purchaseButton).click();
   }

}
