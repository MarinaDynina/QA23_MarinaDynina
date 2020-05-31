package com.qa.trello.tests.framework;

import com.google.common.io.Files;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class HelperBase {
    WebDriver wd;
//    WebDriverWait wait;


    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void goToBoardsPageUrl() {
        wd.navigate().to("https://trello.com/marinadynina/boards");
//        waitForElementClickableAndClick(By.cssSelector("[name='house']"), 50);
//        waitForElementLocatedAndClick(By.cssSelector("[name='house']"), 60);
    }

    public void type(By locator, String text) {
        if(text != null) {
            waitForElementLocatedAndClick(locator, 60);
            wd.findElement(locator).clear();
            wd.findElement(locator).sendKeys(text);
        }
    }

    public void waitForElementLocatedAndClick(By locator, int timeOut) {
        new WebDriverWait(wd, timeOut).until(ExpectedConditions.presenceOfElementLocated(locator)).click();
//        wd.findElement(locator).click();
    }

    public void waitForElementClickableAndClick(By locator) {
        long timeOut = 60;
        new WebDriverWait(wd, timeOut).until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void confirm() {
        waitForElementLocatedAndClick(By.cssSelector(".js-confirm"), 60);
    }

    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size() > 0;
    }

    public void takeScreenshot(long timeMillis) {
        File tmp = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
        File screenshot = new File("screen" + timeMillis +".png");

        try {
            Files.copy(tmp, screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void refreshPage() {
        wd.navigate().refresh();
    }
}
