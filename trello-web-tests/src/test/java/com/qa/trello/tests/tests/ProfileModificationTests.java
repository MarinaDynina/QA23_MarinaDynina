package com.qa.trello.tests.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileModificationTests extends TestBase {

    @Test
    public void testChangeProfileAvatar() throws InterruptedException {
        long beforeScreenShot = System.currentTimeMillis();
        app.getProfile().takeScreenshot(beforeScreenShot);
        app.getProfile().clickAvatar();
        app.getProfile().selectProfileAndVisibility();
        Thread.sleep(2000);
        app.getProfile().goToAtlassianProfile();
        Thread.sleep(3000);
        app.getProfile().initChangeProfilePhoto();
        Thread.sleep(3000);
        app.getProfile().upLoadPhoto();
        long afterScreenShot = System.currentTimeMillis();
        app.getProfile().takeScreenshot(afterScreenShot);

        Assert.assertTrue(app.getProfile().avatarAdded());

        app.getProfile().returnToTrello();
        app.getProfile().refreshPage();
        app.getBoard().goToBoardsPageUrl();

        logger.info("screenShot before: screen- " + beforeScreenShot + ".png");
        logger.info("screenShot after: screen- " + afterScreenShot + ".png");

    }

}
