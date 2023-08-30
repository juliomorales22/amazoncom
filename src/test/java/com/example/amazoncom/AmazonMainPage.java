package com.example.amazoncom;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class AmazonMainPage {
  WebDriver driver;
  final static String WEB="https://www.amazon.es/";
public AmazonMainPage(WebDriver driver) {
  this.driver=driver;
  driver.get(WEB);

  PageFactory.initElements(driver,this);
}
  @FindBy(id = "twotabsearchtextbox")
  WebElement  searchField;
  @FindBy(id = "nav-search-submit-button")
  WebElement searchButton;

 public String textChecker(){
   return searchField.getAttribute("value");
 }
}
