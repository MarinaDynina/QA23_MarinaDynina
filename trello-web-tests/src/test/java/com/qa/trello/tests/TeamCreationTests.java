package com.qa.trello.tests;
import org.testng.annotations.*;

public class TeamCreationTests extends TestBase{

    @Test
    public void testTeamCreation() throws InterruptedException {
        initTeamCreation();
        fillTeamForm();
        confirmTeamCreation();
        returnToHomePage();
    }
}
