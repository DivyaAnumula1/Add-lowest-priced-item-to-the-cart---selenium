package com.automation;

import com.automation.Commons.Common;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AddLowestPriceItemToCart {
  Common common;
  public static double lowestPrice = Double.MAX_VALUE;
  public static WebElement addToCart;

  @Given("^I am on home page of \"(.*)\"$")
  public void getPage(String pageURI) {
    common = new Common();
    common.driver.get(pageURI);
    common.driver.manage().window().maximize();
  }

  @When("^Search for the below item$")
  public void searchElement() {
    WebElement searchProduct = common.driver.findElement(By.id("search_query_top"));
    searchProduct.sendKeys("printed");
    searchProduct.submit();
  }

  @And("^select the lowest priced item$")
  public void selectLowestPrElement(){
    List<WebElement> list = common.driver.findElements(By.xpath("//span[@class='price product-price']"));
    for(int i=0;i<list.size();i++){
      String strTemp = list.get(i).getAttribute("innerText");
      int temp = strTemp.indexOf('$');
      String str = strTemp.substring(temp+1,temp+6);
      double price = Double.valueOf(str);
      if(lowestPrice>price) {
        lowestPrice = price;
        addToCart = common.driver.findElement(By.xpath("//span[@class='price product-price' and text()='"+strTemp + "']//following::span[text()='Add to cart']"));
      }
    }
  }

  @And("^Add the item to cart$")
  public void addToCart(){
    JavascriptExecutor js = (JavascriptExecutor)common.driver;
    js.executeScript("arguments[0].click();", addToCart);
  }


  @And("^verify the checkout option$")
  public void verifyAndCheckout() throws InterruptedException {
    WebElement proceedCheckout;
    try {
       proceedCheckout = common.driver.findElement(By.xpath("//*[contains(text(),'Proceed to checkout')]"));
    } catch (Exception e){
      System.out.println("checkout option is not present");
      throw e;
    }
    WebDriverWait wait = new WebDriverWait(common.driver, 30);
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Proceed to checkout']"))).click();
    JavascriptExecutor js = (JavascriptExecutor)common.driver;
    js.executeScript("window.scrollBy(0,200)");
    WebElement ptc = common.driver.findElement(By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']"));
    String href = ptc.getAttribute("href");
    common.driver.findElement(By.xpath("//a[@href='"+href+"']")).click();
  }
}
