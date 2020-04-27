package com.qa.trello.tests;
import org.testng.Assert;
import org.testng.annotations.*;

public class BoardCreationTests extends TestBase {

    @Test
    public void testBoardCreation() throws InterruptedException {
        Thread.sleep(20000);
        int before = getBoardsCount();
        initBoardCreation();
        fillBoardForm();
        Thread.sleep(3000);
        returnToHomePage();
        int after = getBoardsCount();

        System.out.println("was: " + before+ " now: " + after);
        Assert.assertEquals(after, before+1);
    }

}
