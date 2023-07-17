package test;

import Base.BaseClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PageLocators;

public class Testing extends BaseClass {
   private PageLocators pageLocators;

   @Test(description = "validate registration and login",priority = 1)
    public void registerAndLogIn() {
      pageLocators = new PageLocators(webDriver);
      pageLocators.register();
      pageLocators.logIn();
      Assert.assertEquals(pageLocators.getSignUp().getAttribute("style"),"display: block;");

   }
   @Test(description = "validate if the listed categories has items",priority = 2)
   public void category() {
      pageLocators = new PageLocators(webDriver);
      pageLocators.checkCategory();
      Assert.assertNotEquals(pageLocators.getItems().size(), 0);
   }
   @Test(description = "validate add and remove item from the cart",priority = 3)
   public void randomItem() {
      pageLocators = new PageLocators(webDriver);
      pageLocators.addRandom();
      Assert.assertTrue(pageLocators.getDeleteButton().isDisplayed());
      pageLocators.removeItem();
      Assert.assertEquals(webDriver.findElement(By.xpath("//tbody[@id='tbodyid']")).getSize().toString(),
              "(1013, 0)");
   }
   @Test(description = "validate successful checkout",priority = 4)
   public void successfulCheckout() {
       pageLocators = new PageLocators(webDriver);
       pageLocators.addRandom();
       pageLocators.checkOut();
       Assert.assertTrue(pageLocators.getSuccess().isDisplayed());

   }
}
