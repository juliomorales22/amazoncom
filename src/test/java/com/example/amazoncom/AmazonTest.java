package com.example.amazoncom;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AmazonTest {

  public WebDriver driver;
  AmazonMainPage mainPage;


  @Given("Obtain the content a website: amazon.es")
  @BeforeAll
  public void visitAmazon() {
    WebDriverManager.chromedriver().setup();
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("incognito");
    driver = new ChromeDriver(chromeOptions);
    mainPage = new AmazonMainPage(driver);
    mainPage.openHomePage();
  }

  @When("When it searches 'selenium' and checks the assertion of 'Selenium' in the search box")
  @Test
  @Order(1)
  public void searchAndCheckTheAssersion() {
    // 1 assertion
    mainPage.searchField.sendKeys("Selenium");
    mainPage.searchButton.click();
    Assertions.assertThat(mainPage.getSearchFieldValue())
        .as("Message Error: Word selenium not found").isEqualTo("Selenium");

  }


  @And("Click link to cart and Check the assertion 'Tu cesta de Amazon est")
  @Test
  @Order(3)
  public void visitLinkOfferAndCheckTitle() {
    // 3 assertion
    mainPage.linkCart.click();
    Assertions.assertThat(mainPage.emptyCartMessage.getText())
        .as("Failure message: Offer doesn't appear").containsIgnoringCase("Tu cesta de Amazon est");

  }

  @And("Click link to cart and check the assertion of 'con Amazon Recargas'")
  @Test
  @Order(2)
  public void clickToCartAndCheckOffers() {
    // 2 assertion
    mainPage.linkCart.click();
    Assertions.assertThat(mainPage.textAmazonRecargas.getText())
        .as("Failure message: Today Offer doesn't appear")
        .containsIgnoringCase("con Amazon Recargas");

  }

  @Then("Then It will close all browser drivers which have been opened")
  @AfterAll
  public void teardown() {
    driver.quit();
  }
}
