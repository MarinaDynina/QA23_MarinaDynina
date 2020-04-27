package com.qa.trello.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if (getTeamCount() == 0) {
            createTeam();
        }
    }

    @Test
    public void testTeamDeletion() throws InterruptedException {
        Thread.sleep(10000);
        int before = getTeamCount();
        openFirstTeam();
        clickTeamSetting();
        Thread.sleep(3000);
        deletionTeam();
        returnToHomePage();
        int after = getTeamCount();

        System.out.println("was: " + before + " now: " + after);
        Assert.assertEquals(after, before - 1);

    }


}
