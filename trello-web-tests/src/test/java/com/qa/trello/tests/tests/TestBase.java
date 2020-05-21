package com.qa.trello.tests.tests;

import com.qa.trello.tests.framework.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeSuite
    public void setUp() throws InterruptedException {
        app.init();
    }

    @BeforeMethod
    public void logTestStart(Method m, Object[] p) {
        logger.info("Start test "+ m.getName() + " with parametrs " + Arrays.asList(p));
    }

    @AfterMethod
    public void logTestStop(Method m) {
        logger.info("Stop test "+ m.getName());

    }

    @AfterSuite(enabled = false)
   public void tearDown() {
     app.stop();
    }


}
