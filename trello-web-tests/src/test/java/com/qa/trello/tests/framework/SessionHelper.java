package com.qa.trello.tests.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {
    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void confirmLogin() {
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-submit"))).click(); //waiting for item on page
        waitForElementLocatedAndClick(By.id("login-submit"), 60);
    }

    public void fillLoginFormAtlassianAcc(String userEmail, String password) throws InterruptedException {
        type(By.name("user"), userEmail);
        Thread.sleep(2000);
        waitForElementLocatedAndClick(By.cssSelector(".button-green"), 60);
        type(By.cssSelector("#password"), password);
    }

    public void initLogin() {
        waitForElementLocatedAndClick(By.cssSelector("[href='/login']"), 60);
    }

    public void login(String email, String password) throws InterruptedException {
        initLogin();
        fillLoginFormAtlassianAcc(email, password);
        confirmLogin();
    }
}
