package com.qa.trello.tests.tests;

import com.qa.trello.tests.model.Team;
import org.testng.Assert;
import org.testng.annotations.*;

public class TeamCreationTests extends TestBase {

//@BeforeMethod
//public void ensurePreconditions(){
//    if(!app.getBoard().isOnBoardsPage())
//   {
//        app.getBoard().waitForElementLocatedAndClick(By.cssSelector("[href$=boards]"), 60);
//   }
//}
    @Test
    public void testTeamCreation() throws InterruptedException {
        Thread.sleep(20000);
        int before = app.getTeam().getTeamCount();
        app.getTeam().initTeamCreation();
        app.getTeam().fillTeamForm(
                new Team()
                        .withNameOfTeam("Trello Company")
                        .withFieldOfTeam("[data-test-id*=engineering-it]"));
        app.getTeam().confirmTeamCreation();
        Thread.sleep(2000);
        app.getTeam().inviteTeamLater();
        Thread.sleep(2000);
        app.getTeam().goToBoardsPageUrl();
        Thread.sleep(4000);
        int after = app.getTeam().getTeamCount();

        System.out.println("was: " + before + " now:" + after);
        Assert.assertEquals(after, before + 1);

    }



}
