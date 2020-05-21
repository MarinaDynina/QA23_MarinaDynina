package com.qa.trello.tests.tests;

import org.testng.annotations.Test;

public class ProfileModificationTests extends TestBase {

    @Test
    public void testChangeProfileAvatar() throws InterruptedException {
     app.getProfile().clickAvatar();
     app.getProfile().selectProfileAndVisibility();
     app.getProfile().goToAtlassianProfile();
        Thread.sleep(3000);
        //initChangeProfilePhoto();
        //uoLoadPhoto();


    }




}
