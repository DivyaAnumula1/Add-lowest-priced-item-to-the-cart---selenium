package com.automation;

import com.automation.Commons.Common;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

public class OrderConfirmation {
  @Then("^the user's order should be successful with the below details$")
  public void confirmation() throws InterruptedException {
    WebElement element = Common.getDriver().findElement(By.xpath("//*[contains(text(),'$18.40')]"));
    Dimension dimension = new Dimension(0,0);
    if(element.getSize()==dimension){
      System.out.println("amount is $18.40");
    }
    Thread.sleep(10000);
    Common.driver.close();
  }
}
