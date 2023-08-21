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

    @BeforeAll
    public void setupBrowser() {
        System.out.println("Test starts in amazon.es");
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("incognito");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://www.amazon.es/");
        this.driver = driver;
        WebElement waiting = (new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated((By.xpath("//input[contains(@id,'twotabsearchtextbox')]")))));
    }

    @Test
    public void myTest() {
        //   WebDriver driver=this.driver;
        // 1 assertion
        String ActualTitle = driver.getTitle();
        Assertions.assertTrue(ActualTitle.contains("Amazon.es"));
        /*  */ // 2 assertion
        WebElement checkInpuText = driver.findElement(By.xpath("//input[contains(@id,'twotabsearchtextbox')]"));
        Assertions.assertTrue(checkInpuText.isDisplayed());
        // 3 assertion
        WebElement checkInputHidden = driver.findElement(By.xpath("//input[contains(@name,'glow-validation-token') ]"));
        Assertions.assertFalse(checkInputHidden.isDisplayed());
        // 4 assertion

        driver.get("https://www.amazon.es/b/?_encoding=UTF8&node=667049031");
        WebElement waiting = (new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated((By.xpath("//input[contains(@id,'twotabsearchtextbox')]")))));
        String categoryNameTitle = driver.findElement(By.xpath("//div[contains(@class,'pageBanner')]/h1/span")).getText();
        Assertions.assertTrue(categoryNameTitle.contains("Inform"));

        // 5 assertion change need a different xpath
        String titleMainCategories = driver.findElement(By.xpath("//h2[not(contains(@class,'a'))]")).getText();
        Assertions.assertFalse(titleMainCategories.contains("destacadas"));


    }
}//
