package com.example.amazoncom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrowserStackHomePage {

  WebDriver driver;
  @FindBy(xpath = "//input[contains(@id,'twotabsearchtextbox')]")
  WebElement inputtext;
  @FindBy(xpath = "//title")
  WebElement ActualTitle;
  @FindBy(xpath = "//h1")
  WebElement Header;
  @FindBy(xpath = "//a[contains(@data-csa-c-slot-id,\"nav_cs_5\")]")
  WebElement getOffer;

  public BrowserStackHomePage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void veryStringOffer() {
    String getStringOffer = getOffer.getText();
    assertEquals(getStringOffer, "Ofertas");
  }

  public void clickOnGetOffer() {
    getOffer.click();
  }
}