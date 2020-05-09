package com.qa.trello.tests.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardChangeTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if (!app.getBoard().isOnBoardsPage()) {
        app.getBoard().openBoardsPage();
              }
        if (app.getBoard().getBoardsCount() == 1) {
            app.getBoard().createBoard();
        }
    }

    @Test
    public void changeOfBoard() throws InterruptedException {
        app.getBoard().openFirstPersonalBoard();
        Thread.sleep(5000);
        app.getBoard().chageNameOfBoard();
        Thread.sleep(3000);
        app.getBoard().goToBoardsPageUrl();
    }
}
