package com.qa.trello.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
  //      if (!isOnBoardsPage()) {
  //          click(By.cssSelector("[href$=boards]"));
  //      }

        if (app.getBoardsCount() == 1) {
            app.createBoard();
        }
    }

    @Test
    public void testBoardDeletion() throws InterruptedException {
        Thread.sleep(10000);
        int before = app.getBoardsCount();
        System.out.println(before);
        Thread.sleep(2000);
        app.openFirstPersonalBoard();
        app.clickMoreButton();
        app.initBoardDeletionInMoreMenu();
        app.permanentlyDeleteBoard();
        app.returnToHomePage();
        int after = app.getBoardsCount();

        System.out.println("was: " + before + "now: " + after);

        Assert.assertEquals(after, before - 1);

    }


}
