package com.qa.trello.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if (app.getTeamCount() == 0) {
            app.createTeam();
        }
    }

    @Test
    public void testTeamDeletion() throws InterruptedException {
        Thread.sleep(10000);
        int before = app.getTeamCount();
        app.openFirstTeam();
        app.clickTeamSetting();
        Thread.sleep(3000);
        app.deletionTeam();
        app.returnToHomePage();
        int after = app.getTeamCount();

        System.out.println("was: " + before + " now: " + after);
        Assert.assertEquals(after, before - 1);

    }


}
