package com.qa.trello.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    WebDriverWait wait;
    BoardHelper board;
    TeamHelper team;
    SessionHelper session;

    public void init() throws InterruptedException {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //implicit expectation
        wait = new WebDriverWait(wd, 60);
        wd.manage().window().maximize(); //stretch the screen to maximum
        wd.navigate().to("https://trello.com/");

        session = new SessionHelper(wd);
        session.login("Dyninamarina3@gmail.com", "1qaz2wsx3edcmad");

        board = new BoardHelper(wd);
        team = new TeamHelper(wd);
    }

    public void stop() {
        wd.quit();
    }

    public BoardHelper getBoard() {
        return board;
    }

    public TeamHelper getTeam() {
        return team;
    }

    public SessionHelper getSession() {
        return session;
    }
}
