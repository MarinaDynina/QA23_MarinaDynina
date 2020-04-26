package com.qa.trello.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamChangeTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if (getTeamCount() == 0) {
            createTeam();
        }
    }

    @Test
    public void changeTeamTests() {

        openFirstTeam();
        clickTeamSetting();
        changeTeamProfile();
        changeTeamName();
        returnToHomePage();
    }

}
