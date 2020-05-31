package com.qa.trello.tests.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    public void initChangeProfilePhoto() throws InterruptedException {
        WebElement avatar = wd.findElement(By.cssSelector("[data-test-selector=profile-avatar]"));
        new Actions(wd).moveToElement(avatar).perform();
        waitForElementClickableAndClick(By.cssSelector(".sc-kgoBCf.gtmiag"));
        //("[data-test-selector=trigger-avatar-picker]"))
    }

    public void attachFile(By locator, File file) {
        wd.findElement(locator).sendKeys(file.getAbsolutePath());
    }

    public void upLoadPhoto() throws InterruptedException {
        Thread.sleep(3000);
        attachFile(By.cssSelector("input#image-input"),
                new File("C:\\Users\\Марина\\Documents\\GitHub\\QA23_MarinaDynina\\trello-web-tests\\src\\test\\resources\\flower.png"));
        Thread.sleep(4000);
        waitForElementClickableAndClick(By.xpath("//*[@class='css-1yx6h60']"));
    }

    public boolean avatarAdded() {
        return isElementPresent(By.cssSelector(".sc-giadOv"));
    }

    public void returnToTrello() {
//        String atlassianAcc = wd.getWindowHandle();
//        System.out.println(atlassianAcc);
        wd.close();
        List<String> availableWindows = new ArrayList<>(wd.getWindowHandles());

        if (!availableWindows.isEmpty()) {
            wd.switchTo().window(availableWindows.get(0));
        }
//        String trello = wd.getWindowHandle();
//        System.out.println(trello);
    }

}

