package com.qa.trello.tests.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ProfileHelper extends HelperBase {
    public ProfileHelper(WebDriver wd) {
        super(wd);
    }

    public void clickAvatar() {
        waitForElementClickableAndClick(By.cssSelector("[data-test-id=header-member-menu-button]"));
    }

    public void selectProfileAndVisibility() {
        waitForElementClickableAndClick(By.cssSelector("[data-test-id=header-member-menu-profile]"));
    }

    public void goToAtlassianProfile() {
        String trello = wd.getWindowHandle();
        System.out.println(trello);
        waitForElementClickableAndClick(By.cssSelector("a[href$=manage-profile]"));
        List<String> availableWindows = new ArrayList<>(wd.getWindowHandles());

        if (!availableWindows.isEmpty()) {
            wd.switchTo().window(availableWindows.get(1));
        }
        String atlassianAcc = wd.getWindowHandle();
        System.out.println(atlassianAcc);
    }

    public void initChangeProfilePhoto() {
        WebElement avatar = wd.findElement(By.cssSelector("[data-test-selector=profile-avatar]"));
        new Actions(wd).moveToElement(avatar).perform();
        waitForElementClickableAndClick(By.cssSelector("[data-test-selector=trigger-avatar-picker]"));
    }

    public void attachFile(By locator, File file) {
wd.findElement(locator).sendKeys(file.getAbsolutePath());
    }

    public void upLoadPhoto() throws InterruptedException {
        attachFile(By.cssSelector(".css-1b4o0qu"),
                new File("src/test/resources/flower.png"));
   waitForElementClickableAndClick(By.cssSelector("button.css-1b4o0qu"));
    }

}
