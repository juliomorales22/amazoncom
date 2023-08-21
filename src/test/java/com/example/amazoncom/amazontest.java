package com.example.amazoncom;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class amazontest {
    private  WebDriver driver;

    @BeforeAll
    public void myTest2(WebDriver driver) {
        System.out.println("Test starts in amazon.es");
       /* ChromeOptions option = new ChromeOptions();
        option.addArguments("incognito");
        driver = new ChromeDriver(option);
        WebDriverManager.chromedriver().setup();*/

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://www.amazon.es/");
        this.driver = driver;
        WebElement waiting = (new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated((By.xpath("//input[contains(@id,'twotabsearchtextbox')]")))));

        //
    }

    @Test
    public void myTest(WebDriver driver) {
        // visit webpage
     /*   ChromeOptions option = new ChromeOptions();
        option.addArguments("incognito");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(option);

        driver.get("https://www.amazon.es/");*/
        WebElement webElement = (new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated((By.xpath("//input[contains(@id,'twotabsearchtextbox')]")))));

        // 1 assertion
        String ActualTitle = driver.getTitle();
        Assertions.assertTrue(ActualTitle.contains("Amazon.es"));
        /*  */ // 2 assertion
        WebElement inputext = driver.findElement(By.xpath("//input[contains(@id,'twotabsearchtextbox')]"));
        Assertions.assertTrue(inputext.isDisplayed());
        // 3 assertion
        WebElement inputhidden = driver.findElement(By.xpath("//input[contains(@name,'glow-validation-token') ]"));
        Assertions.assertFalse(inputhidden.isDisplayed());
        // 4 assertion

        driver.get("https://www.amazon.es/b/?_encoding=UTF8&node=667049031");
        WebElement waiting = (new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated((By.xpath("//input[contains(@id,'twotabsearchtextbox')]")))));
        String topString = driver.findElement(By.xpath("//div[contains(@class,'pageBanner')]/h1/span")).getText();

        Assertions.assertTrue(topString.contains("Inform"));
        // 5 assertion change need a different xpath
        String bodytext = driver.findElement(By.xpath("//h2[not(contains(@class,'a'))]")).getText();


    }
}//
