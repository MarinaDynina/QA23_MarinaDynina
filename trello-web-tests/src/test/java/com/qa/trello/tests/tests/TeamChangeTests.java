package com.qa.trello.tests.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamChangeTests extends TestBase {

    @BeforeMethod

    public void ensurePreconditions() throws InterruptedException {
        if (app.getTeam().getTeamCount() == 0) {
            app.getTeam().createTeam();
        }
    }

    @Test
    public void changeTeamTests() {

        app.getTeam().openFirstTeam();
        app.getTeam().clickTeamSetting();
        app.getTeam().changeTeamProfile();
        app.getTeam().changeTeamName();
        app.getTeam().returnToHomePage();
    }

}
