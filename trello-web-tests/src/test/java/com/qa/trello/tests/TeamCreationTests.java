package com.qa.trello.tests;
import org.testng.Assert;
import org.testng.annotations.*;

import java.sql.SQLOutput;

public class TeamCreationTests extends TestBase{

    @Test
    public void testTeamCreation() throws InterruptedException {
        Thread.sleep(10000);
        int before = getTeamCount();
        initTeamCreation();
        fillTeamForm();
        confirmTeamCreation();
        Thread.sleep(2000);
        returnToHomePage();
        Thread.sleep(2000);
        int after = getTeamCount();

        System.out.println("was: " +before+ " now:" + after);
        Assert.assertEquals(after, before+1);

    }
// ДОПИСАТЬ КЛАСС УДАЛЕНИЕ ГРУППЫ, ДОБАВИТЬ
    public int getTeamCount() {
        wd.findElements()
    }
}
