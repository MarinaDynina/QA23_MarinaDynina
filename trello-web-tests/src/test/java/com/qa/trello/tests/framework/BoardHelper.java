package com.qa.trello.tests.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class BoardHelper extends HelperBase {

    public BoardHelper(WebDriver wd) {
        super(wd);
    }

    public void fillBoardForm() throws InterruptedException {
        type(By.cssSelector("[data-test-id='create-board-title-input']"), "My board");
        click(By.cssSelector(".W6rMLOx8U0MrPx"));
        click(By.cssSelector("._1uK2vQ_aMRS2NU"));
        Thread.sleep(10000);
        click(By.cssSelector("[type='button']"));
        Thread.sleep(3000);
        click(By.cssSelector("[class*='js-fill-background-preview']"));
        click(By.cssSelector("[class*=photos]"));
        click(By.xpath("//div[@class='photo-attribution-component large']/../../..//div[21]"));
    }

    public void initBoardCreation() {
        click(By.cssSelector("[name='add']"));
        click(By.cssSelector("[data-test-id=\"header-create-board-button\"] span"));
    }

    public int getBoardsCount() throws InterruptedException {
        // System.out.println(wd.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")));
        return wd.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size() - 1;
    }

    public void permanentlyDeleteBoard() {
        click(By.cssSelector(".js-delete"));
        confirm();
    }

    public void initBoardDeletionInMoreMenu() {
        clickCloseBoardFromMoreMenu();
        confirm();
    }

    public void clickCloseBoardFromMoreMenu() {
        click(By.cssSelector(".js-close-board"));
    }

    public void clickMoreButton() {
        click(By.cssSelector(".js-open-more"));
    }

    public void openFirstPersonalBoard() {
        click(By.xpath("//*[@class='icon-lg icon-member']/../../..//li"));

    }

    public void createBoard() throws InterruptedException {
        initBoardCreation();
        fillBoardForm();
        Thread.sleep(3000);
        returnToHomePage();
    }

    public void chageNameOfBoard() {
        click(By.cssSelector(".js-rename-board"));
        wd.findElement(By.cssSelector("input.js-board-name-input")).sendKeys("My new board" + Keys.ENTER);

    }

    public boolean isOnBoardsPage() {
        String url = wd.getCurrentUrl();
        return url.contains("boards");
    }

    public void openBoardsPage() {
        click(By.cssSelector("[href$=boards]"));
    }
}
