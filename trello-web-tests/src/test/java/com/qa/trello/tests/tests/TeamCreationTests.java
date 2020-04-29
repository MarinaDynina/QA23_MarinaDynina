package com.qa.trello.tests.tests;

import org.testng.Assert;
import org.testng.annotations.*;

public class TeamCreationTests extends TestBase {

    @Test
    public void testTeamCreation() throws InterruptedException {
        Thread.sleep(20000);
        int before = app.getTeam().getTeamCount();
        app.getTeam().initTeamCreation();
        app.getTeam().fillTeamForm();
        app.getTeam().confirmTeamCreation();
        Thread.sleep(2000);
        app.getTeam().inviteTeamLater();
        Thread.sleep(2000);
        app.getTeam().returnToHomePage();
        Thread.sleep(2000);
        int after = app.getTeam().getTeamCount();

        System.out.println("was: " + before + " now:" + after);
        Assert.assertEquals(after, before + 1);

    }



}
