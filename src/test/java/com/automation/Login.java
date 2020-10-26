package com.automation;

import com.automation.Commons.Common;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.util.List;

public class Login {
  @And("login using the below credentials$")
  public void login(DataTable input){
    List<List<String>> data = input.raw();
    JavascriptExecutor js = (JavascriptExecutor) Common.getDriver();
    js.executeScript("window.scrollBy(0,200)");
    Common.getDriver().findElement(By.id("email")).sendKeys(data.get(0).get(0));
    Common.getDriver().findElement(By.id("passwd")).sendKeys(data.get(0).get(1));
    Common.getDriver().findElement(By.id("SubmitLogin")).click();
  }
}
