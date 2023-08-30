package com.example.amazoncom;
import static org.testng.Assert.assertEquals;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonMainPage {
  WebDriver driver;
  @FindBy(id = "twotabsearchtextbox")
  WebElement  searchField;
  @FindBy(id = "nav-search-submit-button")
  WebElement searchButton;
  final static String WEB="https://www.amazon.es/";
public AmazonMainPage(WebDriver driver) {
  this.driver=driver;
  driver.get(WEB);
  WebElement waiting = (new WebDriverWait(driver, Duration.ofSeconds(30)).until(
      ExpectedConditions.presenceOfElementLocated((By.xpath("//input[contains(@id,'twotabsearchtextbox')]")))));
  PageFactory.initElements(driver,this);
}

 public String textChecker(){
   return searchField.getAttribute("value");
 }
}
