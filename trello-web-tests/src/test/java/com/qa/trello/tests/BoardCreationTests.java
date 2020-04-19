package com.qa.trello.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BoardCreationTests {
    WebDriver wd;

    @BeforeMethod
    public void setUp() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //implicit expectation
        wd.manage().window().maximize(); //stretch the screen to maximum
        wd.navigate().to("https://trello.com/");
    }

    @Test
    public void testBoardCreation()  {
        click(By.cssSelector("[href='/login']"));

        click(By.name("user"));
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys("Dyninamarina3@gmail.com");



    }

    private void click(By locator) {
        wd.findElement(locator).click();
    }

    @AfterMethod
    public void tearDown() {
       // wd.quit();
    }
}
