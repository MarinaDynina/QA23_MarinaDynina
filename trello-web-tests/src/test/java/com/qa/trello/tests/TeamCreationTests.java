package com.qa.trello.tests;

import org.testng.Assert;
import org.testng.annotations.*;

public class TeamCreationTests extends TestBase {

    @Test
    public void testTeamCreation() throws InterruptedException {
        Thread.sleep(20000);
        int before = app.getTeamCount();
        app.initTeamCreation();
        app.fillTeamForm();
        app.confirmTeamCreation();
        Thread.sleep(2000);
        app.inviteTeamLater();
        Thread.sleep(2000);
        app.returnToHomePage();
        Thread.sleep(2000);
        int after = app.getTeamCount();

        System.out.println("was: " + before + " now:" + after);
        Assert.assertEquals(after, before + 1);

    }



}
