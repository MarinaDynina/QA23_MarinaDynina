package com.qa.trello.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardChangeTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if (getBoardsCount() == 1) {
            createBoard();
        }
    }

    @Test
    public void changeOfBoard() throws InterruptedException {
        openFirstPersonalBoard();
        Thread.sleep(5000);
        chageNameOfBoard();
        Thread.sleep(3000);
        returnToHomePage();
    }
}
