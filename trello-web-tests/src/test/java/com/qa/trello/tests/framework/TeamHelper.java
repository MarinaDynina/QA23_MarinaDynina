package com.qa.trello.tests.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class TeamHelper extends HelperBase {
    public TeamHelper(WebDriver wd) {
        super(wd);
    }

    public void confirmTeamCreation() throws InterruptedException {
        click(By.cssSelector("[type=submit]"), 60);
//      click(By.cssSelector("[data-test-id=show-later-button]"));
    }

    public void fillTeamForm() {
        type(By.cssSelector("._1CLyNodCAa-vQi"), "Trello Company");
        click(By.cssSelector("#teamTypeSelect"), 60);
        click(By.cssSelector("[data-test-id*=engineering-it]"), 60);
        type(By.cssSelector("[id*=create-team-org-description]"), "we are cool");
    }

    public void initTeamCreation() {
        click(By.cssSelector("[name='add']"), 60);
        click(By.cssSelector("[data-test-id=header-create-team-button] p"), 60);
    }

    public void deletionTeam() {
        click(By.cssSelector(".quiet-button"), 60);
        confirm();
    }

    public void clickTeamSetting() {
        click(By.cssSelector(".icon-gear.icon-sm"), 60);
    }

    public void openFirstTeam() {
        click(By.cssSelector("[data-test-id=home-team-tab-name]"), 60);
    }

    public void createTeam() throws InterruptedException {
        initTeamCreation();
        fillTeamForm();
        confirmTeamCreation();
        Thread.sleep(2000);
        inviteTeamLater();
        Thread.sleep(2000);
        returnToHomePage();
    }

    public int getTeamCount() {
//        System.out.println(wd.findElements(By.cssSelector("[data-test-id=home-team-tab-name]")));
        return wd.findElements(By.cssSelector("[data-test-id=home-team-tab-name]")).size();
    }

    public void changeTeamName() {
        type(By.cssSelector("#displayName"), "New Trello Company");
        wd.findElement(By.cssSelector("#displayName")).sendKeys(Keys.ENTER);
    }

    public void changeTeamProfile() {
        click(By.cssSelector("[name=edit]"), 60);
    }

    public void inviteTeamLater() {
        if (isElementPresent(By.cssSelector("[data-test-id=show-later-button]"))) {
            click(By.cssSelector("[data-test-id=show-later-button]"), 60);
        }
    }
}
