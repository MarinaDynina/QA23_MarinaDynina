package com.qa.trello.tests.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        waitForElementClickableAndClick(By.cssSelector("a[href$=manage-profile]"));
    }
}
