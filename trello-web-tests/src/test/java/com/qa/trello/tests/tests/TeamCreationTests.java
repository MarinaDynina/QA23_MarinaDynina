package com.qa.trello.tests.tests;

import com.qa.trello.tests.model.Board;
import com.qa.trello.tests.model.Team;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TeamCreationTests extends TestBase {

//@BeforeMethod
//public void ensurePreconditions(){
//    if(!app.getBoard().isOnBoardsPage())
//   {
//        app.getBoard().waitForElementLocatedAndClick(By.cssSelector("[href$=boards]"), 60);
//   }
//}

    @DataProvider
    public Iterator<Object[]> validTeamsEasy() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"kkkkkkkk", "[data-test-id*=engineering-it]"});
        list.add(new Object[]{"1", "[data-test-id*=small]"});
        list.add(new Object[]{"awsx okpopllk-ghjk", "[data-test-id*=sales]"});
        return list.iterator();
    }

    @Test(dataProvider = "validTeamsEasy")
    public void testTeamCreation(String teamName, String teamField) throws InterruptedException {
        Team team = new Team().withNameOfTeam(teamName).withFieldOfTeam(teamField);
        Thread.sleep(20000);
        int before = app.getTeam().getTeamCount();
        app.getTeam().initTeamCreation();
        app.getTeam().fillTeamForm(team);
//                new Team()
//                        .withNameOfTeam("Trello Company")
//                        .withFieldOfTeam("[data-test-id*=engineering-it]"));
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
