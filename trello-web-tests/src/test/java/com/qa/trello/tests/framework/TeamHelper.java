package com.qa.trello.tests.framework;

import com.qa.trello.tests.model.Team;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class TeamHelper extends HelperBase {
    public TeamHelper(WebDriver wd) {
        super(wd);
    }

    public void confirmTeamCreation() throws InterruptedException {
        waitForElementLocatedAndClick(By.cssSelector("[type=submit]"), 60);
//      click(By.cssSelector("[data-test-id=show-later-button]"));
    }

    public void fillTeamForm(Team team) {
        type(By.cssSelector("._1CLyNodCAa-vQi"), team.getNameOfTeam());
        waitForElementLocatedAndClick(By.cssSelector("#teamTypeSelect"), 60);
        waitForElementLocatedAndClick(By.cssSelector(team.getFieldOfTeam()), 60);
        type(By.cssSelector("[id*=create-team-org-description]"), "we are cool");
    }

    public void initTeamCreation() {
        waitForElementLocatedAndClick(By.cssSelector("[name='add']"), 60);
        waitForElementLocatedAndClick(By.cssSelector("[data-test-id=header-create-team-button] p"), 60);
    }

    public void deletionTeam() {
        waitForElementLocatedAndClick(By.cssSelector(".quiet-button"), 60);
        confirm();
    }

    public void clickTeamSetting() {
        waitForElementLocatedAndClick(By.cssSelector(".icon-gear.icon-sm"), 60);
    }

    public void openFirstTeam() {
        waitForElementLocatedAndClick(By.cssSelector("[data-test-id=home-team-tab-name]"), 60);
    }

    public void createTeam() throws InterruptedException {
        initTeamCreation();
        fillTeamForm(
                new Team()
                .withNameOfTeam("Trello Company")
                .withFieldOfTeam("[data-test-id*=engineering-it]"));
        confirmTeamCreation();
        Thread.sleep(2000);
        inviteTeamLater();
        Thread.sleep(2000);
        goToBoardsPageUrl();
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
        waitForElementLocatedAndClick(By.cssSelector("[name=edit]"), 60);
    }

    public void inviteTeamLater() {
        if (isElementPresent(By.cssSelector("[data-test-id=show-later-button]"))) {
            waitForElementLocatedAndClick(By.cssSelector("[data-test-id=show-later-button]"), 60);
        }
    }
}
