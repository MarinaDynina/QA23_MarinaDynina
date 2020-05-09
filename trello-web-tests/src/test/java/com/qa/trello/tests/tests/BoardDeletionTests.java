package com.qa.trello.tests.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {


        if (app.getBoard().getBoardsCount() == 1) {
            app.getBoard().createBoard();
        }
    }

    @Test
    public void testBoardDeletion() throws InterruptedException {
        Thread.sleep(10000);
        int before = app.getBoard().getBoardsCount();
        System.out.println(before);
        Thread.sleep(2000);
        app.getBoard().openFirstPersonalBoard();
        app.getBoard().clickMoreButton();
        app.getBoard().initBoardDeletionInMoreMenu();
        app.getBoard().permanentlyDeleteBoard();
        app.getBoard().goToBoardsPageUrl();
        int after = app.getBoard().getBoardsCount();

        System.out.println("was: " + before + "now: " + after);

        Assert.assertEquals(after, before - 1);

    }


}
