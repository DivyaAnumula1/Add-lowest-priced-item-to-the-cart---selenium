package com.automation.Commons;

import com.configurations.ConfigFileReader;
import cucumber.api.DataTable;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class Common {
  public static WebDriver driver;

  ConfigFileReader configFileReader = new ConfigFileReader();
  public Common() {
    System.setProperty("webdriver.chrome.driver",configFileReader.getDriverPath());
    this.driver = new ChromeDriver();
  }
  public static WebDriver getDriver(){
    return driver;
  }

  @When("^I am adding the address with the below details$")
  public void createTestData(DataTable input) throws InterruptedException {
    List<List<String>> data = input.raw();
    driver.get(data.get(0).get(0));
    WebElement element = driver.findElement(By.xpath("//a[@title='Log in to your customer account']"));
    String href = element.getAttribute("href");
    driver.findElement(By.xpath("//a[@href='"+href+"']")).click();
    driver.manage().window().maximize();
    Thread.sleep(2000);
    driver.findElement(By.id("email")).sendKeys(data.get(0).get(1));
    driver.findElement(By.id("passwd")).sendKeys(data.get(0).get(2));
    driver.findElement(By.id("SubmitLogin")).click();
    element = driver.findElement(By.xpath("//a[@title='Addresses']"));
    href = element.getAttribute("href");
    driver.findElement(By.xpath("//a[@href='"+href+"']")).click();
    if(driver.findElements(By.xpath("//h3[text()='xyz']")).size()==0){
      WebElement element1 = driver.findElement(By.xpath("//a[@title='Add an address']"));
      String href1 = element1.getAttribute("href");
      driver.findElement(By.xpath("//a[@href='"+href1+"']")).click();
      Common.getDriver().findElement(By.id("firstname")).clear();
      Common.getDriver().findElement(By.id("firstname")).sendKeys(data.get(0).get(3));
      Common.getDriver().findElement(By.id("address1")).sendKeys(data.get(0).get(4));
      Common.getDriver().findElement(By.id("city")).sendKeys(data.get(0).get(5));
      Select state = new Select(Common.getDriver().findElement(By.id("id_state")));
      state.selectByIndex(22);
      Common.getDriver().findElement(By.id("postcode")).sendKeys(data.get(0).get(6));
      Select country = new Select(Common.getDriver().findElement(By.id("id_country")));
      country.selectByIndex(0);
      Common.getDriver().findElement(By.id("phone")).sendKeys(data.get(0).get(7));
      Common.getDriver().findElement(By.id("phone_mobile")).sendKeys(data.get(0).get(8));
      Common.getDriver().findElement(By.id("alias")).clear();
      Common.getDriver().findElement(By.id("alias")).sendKeys("  "+data.get(0).get(9));
      Common.getDriver().findElement(By.id("submitAddress")).click();
    }
    driver.close();
  }
}
