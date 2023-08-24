package com.example.amazoncom;


import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrowserStackSignUpPage {

  WebDriver driver;
  @FindBy(xpath = "//a[contains(@data-nav-role,'signin')]")
  WebElement signInLink;
  @FindBy(xpath = "//*[@id='ap_email']")
  WebElement businessEmail;
  @FindBy(xpath = " //input[@id=\"continue\"]")
  WebElement buttonToLogging1;
  @FindBy(xpath = " //input[@id=\"signInSubmit\"]")
  WebElement buttonEntrance;
  @FindBy(xpath = "//input[@type='password']")
  WebElement password;
  @FindBy(xpath = "//span[contains(@id,'nav-link')]")
  WebElement textIamInside;

  public BrowserStackSignUpPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void textIamInside() {
    String gettextIamInsideString = textIamInside.getText().trim();
    assertThat(gettextIamInsideString).isNotEmpty().contains("Hola Julio");//"Hola Julio",

  }

  public void clickOnlinkLogging() {
    signInLink.click();
  }

  public void clickOnbuttonToLogging1() {
    buttonToLogging1.click();
  }

  public void clickOnbuttonEntrance() {
    buttonEntrance.click();
  }

  public void enterBusinessEmail(String arg1) {
    businessEmail.sendKeys(arg1);
  }

  public void enterPasswrod(String arg1) {
    password.sendKeys(arg1);
  }
}


