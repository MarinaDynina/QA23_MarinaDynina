package com.qa.trello.tests.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperBase {
    WebDriver wd;
    WebDriverWait wait;


    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void returnToHomePage() {
        click(By.cssSelector("[name='house']"), 60);
        click(By.cssSelector("[name='house']"), 60);
    }

    public void type(By locator, String text) {
        click(locator, 60);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void click(By locator, int timeOut) {
       new WebDriverWait(wd, timeOut).until(ExpectedConditions.presenceOfElementLocated(locator)).click();
//        wd.findElement(locator).click();
    }

    public void confirm() {
        click(By.cssSelector(".js-confirm"), 60);
    }

    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size() > 0;

    }
}
