package com.automation;

import com.automation.Commons.Common;
import cucumber.api.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class Shipping {
  @And("^check the shipping details$")
  public void shipping(){
    JavascriptExecutor js = (JavascriptExecutor) Common.getDriver();
    js.executeScript("window.scrollBy(0,200)");
    Common.getDriver().findElement(By.id("cgv")).click();
    Common.getDriver().findElement(By.name("processCarrier")).click();
  }
}
