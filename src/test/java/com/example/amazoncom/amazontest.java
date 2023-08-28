package com.example.amazoncom;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class amazontest {
    public WebDriver driver;
    MainPage mainPage;


    @BeforeAll
    public void setupBrowser() {
       // System.out.println("Test starts in amazon.es");
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("incognito");
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.amazon.com/");
        this.driver = driver;
        WebElement waiting = (new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated((By.xpath("//input[contains(@id,'twotabsearchtextbox')]")))));
    }
    @AfterEach
    public void teardown() {
        driver.quit();
    }
    @Test
    public void sarch() {
        //   WebDriver driver=this.driver;
        // 1 assertion
        mainPage.searchField.sendKeys("Selenium");
        mainPage.searchButton.click();
        Assertions.assertEquals("Selenium", mainPage.searchField.getAttribute("value"));
//    Assertions.assertFalse(titleMainCategories.contains("destacadas"));


    }
}//
