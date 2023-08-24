package com.example.amazoncom;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrowserStackSetup {
  String driverPath = "C:\\geckodriver.exe";
  WebDriver driver;
  BrowserStackHomePage objBrowserStackHomePage;
  BrowserStackSignUpPage objBrowserStackSignUpPage;
  @BeforeTest
  public void setup() {
    System.setProperty("webdriver.chrome.driver",
        "C:\\Users\\Julio_Morales\\chromedriver\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("https://www.amazon.es/");
  }

  @Test(priority = 1)
  public void navigate_to_homepage_click_on_getstarted() {
    objBrowserStackHomePage = new BrowserStackHomePage(driver);
    objBrowserStackHomePage.veryStringOffer();
    objBrowserStackHomePage.clickOnGetOffer();
  }

  @Test(priority = 2)
  public void enter_userDetails() {
    objBrowserStackSignUpPage = new BrowserStackSignUpPage(driver);
    objBrowserStackHomePage.veryStringOffer();
    objBrowserStackSignUpPage.clickOnlinkLogging();
    objBrowserStackSignUpPage.enterBusinessEmail("julio_morales@epam.com");
    objBrowserStackSignUpPage.clickOnbuttonToLogging1();
    objBrowserStackSignUpPage.enterPasswrod("epamamazon123");
    objBrowserStackSignUpPage.clickOnbuttonEntrance();
    objBrowserStackSignUpPage.textIamInside();
  }
}

