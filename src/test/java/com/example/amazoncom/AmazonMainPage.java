package com.example.amazoncom;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonMainPage {
  WebDriver driver;

  @FindBy(id = "twotabsearchtextbox")
  WebElement  searchField;

  @FindBy(id = "nav-search-submit-button")
  WebElement searchButton;

 public String textChecker(){
   return searchField.getAttribute("value");
 }

}
