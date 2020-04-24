package com.qa.trello.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver wd;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws InterruptedException {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //implicit expectation
        wait = new WebDriverWait(wd, 60);
        wd.manage().window().maximize(); //stretch the screen to maximum
        wd.navigate().to("https://trello.com/");
        login("Dyninamarina3@gmail.com", "1qaz2wsx3edcmad");
    }

    public void returnToHomePage() {
        click(By.cssSelector("[name='house']"));
        click(By.cssSelector("[name='house']"));
    }

    public void fillBoardForm() throws InterruptedException {
        type(By.cssSelector("[data-test-id='create-board-title-input']"), "My board");
        click(By.cssSelector(".W6rMLOx8U0MrPx"));
        click(By.cssSelector("._1uK2vQ_aMRS2NU"));
        Thread.sleep(10000);
        click(By.cssSelector("[type='button']"));
        Thread.sleep(3000);
        click(By.cssSelector("[class*='js-fill-background-preview']"));
        click(By.cssSelector("[class*=photos]"));
        click(By.xpath("//div[@class='photo-attribution-component large']/../../..//div[21]"));
    }

    public void initBoardCreation() {
        click(By.cssSelector("[name='add']"));
        click(By.cssSelector("[data-test-id=\"header-create-board-button\"] span"));
    }

    public void confirmLogin() {
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-submit"))).click(); //waiting for item on page
        click(By.id("login-submit"));
    }

    public void fillLoginFormAtlassianAcc(String userEmail, String password) throws InterruptedException {
        type(By.name("user"), userEmail);
        Thread.sleep(2000);
        click(By.cssSelector(".button-green"));
        type(By.cssSelector("#password"), password);
    }

    public void initLogin() {
        click(By.cssSelector("[href='/login']"));
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator)).click();
    }

    @AfterClass
    public void tearDown() {
        // wd.quit();
    }

    public void confirmTeamCreation() throws InterruptedException {
        click(By.cssSelector("[type=submit]"));
        Thread.sleep(2000);
        click(By.cssSelector("[data-test-id=show-later-button]"));
    }

    public void fillTeamForm() {
        type(By.cssSelector("._1CLyNodCAa-vQi"), "Trello Company");
        click(By.cssSelector("#teamTypeSelect"));
        click(By.cssSelector("[data-test-id*=engineering-it]"));
        type(By.cssSelector("[id*=create-team-org-description]"), "we are cool");
    }

    public void initTeamCreation() {
        click(By.cssSelector("[name='add']"));
        click(By.cssSelector("[data-test-id=header-create-team-button] p"));
    }

    public void login(String email, String password) throws InterruptedException {
        initLogin();
        fillLoginFormAtlassianAcc(email, password);
        confirmLogin();
    }

    public void permanentlyDeleteBoard() {
        click(By.cssSelector(".js-delete"));
        confirm();
    }

    public void initBoardDeletionInMoreMenu() {
        clickCloseBoardFromMoreMenu();
        confirm();
    }

    public void confirm() {
        click(By.cssSelector(".js-confirm"));
    }

    public void clickCloseBoardFromMoreMenu() {
        click(By.cssSelector(".js-close-board"));
    }

    public void clickMoreButton() {
        click(By.cssSelector(".js-open-more"));
    }

    public void openFirstPersonalBoard() {
        click(By.xpath("//*[@class='icon-lg icon-member']/../../..//li"));

    }
}
