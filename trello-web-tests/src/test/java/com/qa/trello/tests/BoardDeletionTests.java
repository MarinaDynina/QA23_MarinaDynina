package com.qa.trello.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if (getBoardsCount() == 1) {
            createBoard();
        }

    }

    @Test
    public void testBoardDeletion() throws InterruptedException {
        Thread.sleep(10000);
        int before = getBoardsCount();
        System.out.println(before);
        Thread.sleep(2000);
        openFirstPersonalBoard();
        clickMoreButton();
        initBoardDeletionInMoreMenu();
        permanentlyDeleteBoard();
        returnToHomePage();
        int after = getBoardsCount();

        System.out.println("was: " + before + "now: " + after);

        Assert.assertEquals(after, before - 1);

    }


}
