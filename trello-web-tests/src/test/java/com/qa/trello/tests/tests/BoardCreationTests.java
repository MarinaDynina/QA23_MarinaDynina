package com.qa.trello.tests.tests;
import org.testng.Assert;
import org.testng.annotations.*;

public class BoardCreationTests extends TestBase {

    @Test
    public void testBoardCreation() throws InterruptedException {
        Thread.sleep(20000);
        int before = app.getBoard().getBoardsCount();
        app.getBoard().initBoardCreation();
        app.getBoard().fillBoardForm();
        Thread.sleep(3000);
        app.getBoard().returnToHomePage();
        int after = app.getBoard().getBoardsCount();

        System.out.println("was: " + before+ " now: " + after);
        Assert.assertEquals(after, before+1);
    }

}
