package com.qa.trello.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardDeletionTests extends TestBase {

    @Test
    public void testBoardDeletion() throws InterruptedException {

        int before = getBoardsCount();
        Thread.sleep(2000);
        openFirstPersonalBoard();
        clickMoreButton();
        initBoardDeletionInMoreMenu();
        permanentlyDeleteBoard();
        returnToHomePage();
        int after = getBoardsCount();

        System.out.println("was: " + before+ "now: " + after );

        Assert.assertEquals(after, before-1);

    }
    public int getBoardsCount() {

        return wd.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size()-1;
    }
}
