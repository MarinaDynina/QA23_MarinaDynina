package com.qa.trello.tests.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperBase {
    WebDriver wd;
//    WebDriverWait wait;


    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void returnToHomePage() {
        waitForElementClickableAndClick(By.cssSelector("[name='house']"), 50);
//        waitForElementLocatedAndClick(By.cssSelector("[name='house']"), 60);
    }

    public void type(By locator, String text) {
        waitForElementLocatedAndClick(locator, 60);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void waitForElementLocatedAndClick(By locator, int timeOut) {
        new WebDriverWait(wd, timeOut).until(ExpectedConditions.presenceOfElementLocated(locator)).click();
//        wd.findElement(locator).click();
    }

    public void waitForElementClickableAndClick(By locator, int timeOut) {
        new WebDriverWait(wd, timeOut).until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void confirm() {
        waitForElementLocatedAndClick(By.cssSelector(".js-confirm"), 60);
    }

    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size() > 0;

    }
}
