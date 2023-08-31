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
  WebElement searchField;

  @FindBy(id = "nav-search-submit-button")
  WebElement searchButton;
  final static String URL_WEB_AMAZON = "https://www.amazon.es/";

  public AmazonMainPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void useDriver() {
    driver.get(URL_WEB_AMAZON);
    WebElement waiting = (new WebDriverWait(driver, Duration.ofSeconds(30)).until(
        ExpectedConditions.visibilityOf(searchField)));
  }

  public String getSearchFieldValue() {
    return searchField.getAttribute("value");
  }
}
