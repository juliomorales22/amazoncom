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
public class amazonTest {
    public WebDriver driver;
    AmazonMainPage mainPage;
    @BeforeAll
    public void setupBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("incognito");
        driver = new ChromeDriver(chromeOptions);
        mainPage = new AmazonMainPage(driver);
        WebElement waiting = (new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated((By.xpath("//input[contains(@id,'twotabsearchtextbox')]")))));
    }
    @AfterEach
    public void teardown() {
        driver.quit();
    }
    @Test
    public void search() {
        // 1 assertion
        mainPage.searchField.sendKeys("Selenium");
        mainPage.searchButton.click();
        Assertions.assertEquals("Selenium", mainPage.textChecker());
    }
}//
