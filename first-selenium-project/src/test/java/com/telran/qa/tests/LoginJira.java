package com.telran.qa.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginJira {
    WebDriver wd;

    @BeforeClass
    public void setUp() {
        wd = new ChromeDriver();
        wd.get("http://jira.tel-ran.net/secure/Dashboard.jspa");
    }

    @Test
    public void loginMyJira() throws InterruptedException {
        click(By.className("aui-nav-link"));

        type(By.id("login-form-username"), "Marinna"); // write the text "..." to the login location

        type(By.id("login-form-password"), "1qaz2wsx3"); // write the text "..." to the password location

        click(By.name("login"));

        Thread.sleep(10000);

        Assert.assertTrue(isElementPresent(By.id("usernameerror"))); //check if there is such an element on the page

        String errorMessage = wd.findElement(By.id("usernameerror")).getText();
        Assert.assertEquals(errorMessage, "Sorry, your username and password are incorrect - please try again.");
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void click(By user) {
        wd.findElement(user).click();
    }

    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size() > 0;
    }

    @AfterClass
    public void tearDown() {
        //wd.quit();
    }
}
