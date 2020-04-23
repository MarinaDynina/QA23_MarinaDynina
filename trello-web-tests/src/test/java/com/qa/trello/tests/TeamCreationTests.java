package com.qa.trello.tests;
import org.testng.annotations.*;

public class TeamCreationTests extends TestBase{

    @Test
    public void testTeamCreation() throws InterruptedException {
        initLogin();
        fillLoginFormAtlassianAcc("Dyninamarina3@gmail.com", "1qaz2wsx3edcmad");
        confirmLogin();
        initTeamCreation();
        fillTeamForm();
        confirmTeamCreation();
        returnToHomePage();
    }
}
