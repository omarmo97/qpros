package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
    public static WebDriver webDriver;
 @BeforeMethod
    public static void setWebDriver(){
        webDriver = new ChromeDriver() ;
        webDriver.get("https://www.demoblaze.com/");
        webDriver.manage().window().maximize();

    }
    @AfterMethod
    public static void closeDriver(){
        webDriver.close();
    }
}
