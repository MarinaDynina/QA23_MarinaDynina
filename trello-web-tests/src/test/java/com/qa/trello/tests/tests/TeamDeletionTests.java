package com.qa.trello.tests.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        Thread.sleep(3000);
        if (app.getTeam().getTeamCount() == 0) {
            app.getTeam().createTeam();
        }
    }

    @Test
    public void testTeamDeletion() throws InterruptedException {
        app.getTeam().goToBoardsPageUrl();
        Thread.sleep(10000);
        int before = app.getTeam().getTeamCount();
        app.getTeam().openFirstTeam();
        app.getTeam().clickTeamSetting();
        Thread.sleep(3000);
        app.getTeam().deletionTeam();
        app.getTeam().goToBoardsPageUrl();
        int after = app.getTeam().getTeamCount();

        System.out.println("was: " + before + " now: " + after);
        Assert.assertEquals(after, before - 1);

    }


}
