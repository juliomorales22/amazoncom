package com.example.amazoncom;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.By;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AmazonTest {

  public WebDriver driver;
  AmazonMainPage mainPage;

  @BeforeAll
  public void setupBrowser() {
    WebDriverManager.chromedriver().setup();
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("incognito");
    driver = new ChromeDriver(chromeOptions);
    mainPage = new AmazonMainPage(driver);
    mainPage.openHomePage();
  }

  @AfterAll
  public void teardown() {
    driver.quit();
  }

  @Test
  public void searchProductTest() {
    // 1 assertion
    mainPage.searchField.sendKeys("Selenium");
    mainPage.searchButton.click();
    Assertions.assertEquals("Selenium", mainPage.getSearchFieldValue());
  }
}
