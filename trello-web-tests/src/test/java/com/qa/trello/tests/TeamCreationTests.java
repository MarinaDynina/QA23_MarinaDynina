package com.qa.trello.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TeamCreationTests {

    WebDriver wd;
    WebDriverWait wait;

    @BeforeMethod
    public void setUt() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //implicit expectation
        wait = new WebDriverWait(wd, 50);
        wd.manage().window().maximize(); //stretch the screen to maximum
        wd.navigate().to("https://trello.com/");
    }

    @Test
    public void testTeamCreation() throws InterruptedException {
        initLogin();
        fillLoginFormAtlassianAcc("Dyninamarina3@gmail.com", "1qaz2wsx3edcmad");
        confirmLogin();

        click(By.cssSelector("[name='add']"));
        click(By.cssSelector("[data-test-id=header-create-team-button] p"));
        type(By.cssSelector("._1CLyNodCAa-vQi"), "Trello Company");

        click(By.cssSelector("#teamTypeSelect"));
        click(By.cssSelector("[data-test-id*=engineering-it]"));
        type(By.cssSelector("[id*=create-team-org-description]"), "we are cool");
        click(By.cssSelector("[type=submit]"));
        Thread.sleep(2000);

        click(By.cssSelector("[data-test-id=show-later-button]"));


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
        //wd.quit();
    }

}
