package com.automation;

import com.automation.Commons.Common;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Address {
  @And("update the address with the below details$")
  public void updateAddress(DataTable input){
    List<List<String>> data = input.raw();
    JavascriptExecutor js = (JavascriptExecutor) Common.getDriver();
    js.executeScript("window.scrollBy(0,200)");
    WebElement element = Common.getDriver().findElement(By.xpath("//option[contains(text(),'xyz')]"));
    String value = element.getAttribute("value");
    Select select = new Select(Common.getDriver().findElement(By.id("id_address_delivery")));
    select.selectByValue(value);
    Common.driver.findElement(By.name("processAddress")).submit();
  }
}
