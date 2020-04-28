package com.qa.trello.tests;
import org.testng.Assert;
import org.testng.annotations.*;

public class BoardCreationTests extends TestBase {

    @Test
    public void testBoardCreation() throws InterruptedException {
        Thread.sleep(20000);
        int before = app.getBoardsCount();
        app.initBoardCreation();
        app.fillBoardForm();
        Thread.sleep(3000);
        app.returnToHomePage();
        int after = app.getBoardsCount();

        System.out.println("was: " + before+ " now: " + after);
        Assert.assertEquals(after, before+1);
    }

}
