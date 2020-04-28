package com.qa.trello.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardChangeTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
 //       if (!isOnBoardsPage()) {
 //           click(By.cssSelector("[href$=boards]"));
 //       }
        if (app.getBoardsCount() == 1) {
            app.createBoard();
        }
    }

    @Test
    public void changeOfBoard() throws InterruptedException {
        app.openFirstPersonalBoard();
        Thread.sleep(5000);
        app.chageNameOfBoard();
        Thread.sleep(3000);
        app.returnToHomePage();
    }
}
