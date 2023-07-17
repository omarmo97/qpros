package helpers;

import Base.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementHelper extends BaseClass {


    public static WebElement elementToBeClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.elementToBeClickable(element));

    }public static WebElement elementToBeVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static void scrollTo(String width){
        ((JavascriptExecutor)webDriver).executeScript("window.scrollBy(0"+width+")");
    }
    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(false);", element);
    }
    public static void waitForTime(int milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void scrollByWebPage(String width) {
        ((JavascriptExecutor) webDriver).executeScript("window.scrollBy(0," + width + ")");
    }
//    public static int getRandNumber(int maxNumber) {
//        int randomNumber = (int) Math.floor(Math.random() * maxNumber);
//        if (randomNumber == 0) {
//            return 1;
//        }
//        return randomNumber;
//    }
}
