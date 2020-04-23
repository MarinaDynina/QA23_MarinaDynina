package com.qa.trello.tests;
import org.testng.annotations.*;

public class BoardCreationTests extends TestBase {

    @Test
    public void testBoardCreation() throws InterruptedException {
        initLogin();
        fillLoginFormAtlassianAcc("Dyninamarina3@gmail.com", "1qaz2wsx3edcmad");
        confirmLogin();
        initBoardCreation();
        fillBoardForm();
        Thread.sleep(3000);
        returnToHomePage();
    }
}
