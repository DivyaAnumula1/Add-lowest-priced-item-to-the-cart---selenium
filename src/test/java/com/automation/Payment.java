package com.automation;

import com.automation.Commons.Common;
import cucumber.api.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Payment {
  @And("^pay the amount for the item$")
  public void payment(){
    JavascriptExecutor js = (JavascriptExecutor) Common.getDriver();
    js.executeScript("window.scrollBy(0,200)");
    WebElement element = Common.getDriver().findElement(By.xpath("//a[@title='Pay by check.']"));
    String href = element.getAttribute("href");
    Common.getDriver().findElement(By.xpath("//a[@href='"+href+"']")).click();
  }
  @And("^confirm the order$")
  public void confirm(){
    JavascriptExecutor js = (JavascriptExecutor) Common.getDriver();
    js.executeScript("window.scrollBy(0,200)");
    Common.getDriver().findElement(By.xpath("//button[@class='button btn btn-default button-medium']")).click();
  }
}
