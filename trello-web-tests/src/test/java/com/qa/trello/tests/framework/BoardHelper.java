package com.qa.trello.tests.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BoardHelper extends HelperBase {

    public BoardHelper(WebDriver wd) {
        super(wd);
    }

    public void fillBoardForm() throws InterruptedException {
        type(By.cssSelector("[data-test-id='create-board-title-input']"), "My board");
        waitForElementLocatedAndClick(By.cssSelector(".W6rMLOx8U0MrPx"), 60);
        waitForElementLocatedAndClick(By.cssSelector("._1uK2vQ_aMRS2NU"), 60);
        Thread.sleep(10000);
        waitForElementLocatedAndClick(By.cssSelector("[type='button']"), 60);
        Thread.sleep(3000);
        waitForElementLocatedAndClick(By.cssSelector("[class*='js-fill-background-preview']"), 60);
        waitForElementLocatedAndClick(By.cssSelector("[class*=photos]"), 60);
        waitForElementLocatedAndClick(By.xpath("//div[@class='photo-attribution-component large']/../../..//div[17]"), 60);
    }

    public void initBoardCreation() {
        waitForElementLocatedAndClick(By.cssSelector("[name='add']"), 60);
        waitForElementLocatedAndClick(By.cssSelector("[data-test-id=\"header-create-board-button\"] span"), 60);
    }

    public int getBoardsCount() throws InterruptedException {
        // System.out.println(wd.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")));
        return wd.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size() - 1;
    }

    public void permanentlyDeleteBoard() {
        waitForElementLocatedAndClick(By.cssSelector(".js-delete"), 60);
        confirm();
    }

    public void initBoardDeletionInMoreMenu() {
        clickCloseBoardFromMoreMenu();
        confirm();
    }

    public void clickCloseBoardFromMoreMenu() {
        waitForElementLocatedAndClick(By.cssSelector(".js-close-board"), 60);
    }

    public void clickMoreButton() {
        WebElement moreButton = new WebDriverWait(wd, 30).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".js-open-more")));
        if(!moreButton.isDisplayed()) {
            wd.findElement(By.cssSelector(".board-header-btn.mod-show-menu.js-show-sidebar")).click();
        }
        wd.findElement(By.cssSelector(".js-open-more")).click();

//        waitForElementLocatedAndClick(By.cssSelector(".js-open-more"), 60);
    }

    public void openFirstPersonalBoard() {
        waitForElementLocatedAndClick(By.xpath("//*[@class='icon-lg icon-member']/../../..//li"), 60);

    }

    public void createBoard() throws InterruptedException {
        initBoardCreation();
        fillBoardForm();
        Thread.sleep(3000);
        returnToHomePage();
    }

    public void chageNameOfBoard() {
        waitForElementLocatedAndClick(By.cssSelector(".js-rename-board"), 60);
        wd.findElement(By.cssSelector("input.js-board-name-input")).sendKeys("My new board" + Keys.ENTER);

    }

    public boolean isOnBoardsPage() {
        String url = wd.getCurrentUrl();
        return url.contains("boards");
    }

    public void openBoardsPage() {
        waitForElementLocatedAndClick(By.cssSelector("[href$=boards]"), 60);
    }
}
