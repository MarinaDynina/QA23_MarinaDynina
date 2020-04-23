package com.qa.trello.tests;
import org.testng.annotations.*;

public class BoardCreationTests extends TestBase {

    @Test
    public void testBoardCreation() throws InterruptedException {
        initBoardCreation();
        fillBoardForm();
        Thread.sleep(3000);
        returnToHomePage();
    }

}
