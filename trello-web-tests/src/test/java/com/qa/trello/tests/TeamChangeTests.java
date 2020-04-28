package com.qa.trello.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamChangeTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if (app.getTeamCount() == 0) {
            app.createTeam();
        }
    }

    @Test
    public void changeTeamTests() {

        app.openFirstTeam();
        app.clickTeamSetting();
        app.changeTeamProfile();
        app.changeTeamName();
        app.returnToHomePage();
    }

}
