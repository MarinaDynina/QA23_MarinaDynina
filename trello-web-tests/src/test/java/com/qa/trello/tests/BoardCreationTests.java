package com.qa.trello.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BoardCreationTests extends TestBase {
    WebDriver wd;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //implicit expectation
        wait = new WebDriverWait(wd, 60);
        wd.manage().window().maximize(); //stretch the screen to maximum

        wd.navigate().to("https://trello.com/");
    }

    @Test
    public void testBoardCreation() throws InterruptedException {
        initLogin();
        fillLoginFormAtlassianAcc("Dyninamarina3@gmail.com", "1qaz2wsx3edcmad");
        confirmLogin();

        initBoardCreation();
        fillBoardForm();
        Thread.sleep(3000);
        returnToHomePage();

    }

    private void returnToHomePage() {
        click(By.cssSelector("[name='house']"));
    }

    private void fillBoardForm() throws InterruptedException {
        type(By.cssSelector("[data-test-id='create-board-title-input']"), "My board");
        Thread.sleep(10000);
        click(By.cssSelector("[type='button']"));
        Thread.sleep(3000);
        click(By.cssSelector("[class*='js-fill-background-preview']"));
        click(By.cssSelector("[class*=photos]"));
        click(By.xpath("//div[@class='photo-attribution-component large']/../../..//div[21]"));
    }

    private void initBoardCreation() {
        click(By.cssSelector("[name='add']"));
        click(By.cssSelector("[data-test-id=\"header-create-board-button\"] span"));
    }

    private void confirmLogin() {
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-submit"))).click(); //waiting for item on page
        click(By.id("login-submit"));
    }

    private void fillLoginFormAtlassianAcc(String userEmail, String password) throws InterruptedException {
        type(By.name("user"), userEmail);
        Thread.sleep(2000);
        click(By.cssSelector(".button-green"));
        type(By.cssSelector("#password"), password);
    }

    private void initLogin() {
        click(By.cssSelector("[href='/login']"));
    }

    private void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    private void click(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator)).click();
    }

    @AfterMethod
    public void tearDown() {
        // wd.quit();
    }
}
