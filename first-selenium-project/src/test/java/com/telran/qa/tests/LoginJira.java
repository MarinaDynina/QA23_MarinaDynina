package com.telran.qa.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class LoginJira {
    WebDriver wd;

    @BeforeClass
    public void setUp() {
      wd = new ChromeDriver();
      wd.get("http://jira.tel-ran.net/secure/Dashboard.jspa");
    }

    @Test
    public void openJira() {
        wd.findElement(By.className("aui-nav-link")).click();
    }

    @Test
    public void jiraLogin() {
    wd.findElement(By.id("login-form-username")).click();
    wd.findElement(By.id("login-form-username")).clear();
    wd.findElement(By.id("login-form-username")).sendKeys("Dyninamarina3");
    }

    @Test
    public void jiraPass() {
    wd.findElement(By.id("login-form-password")).click();
    wd.findElement(By.id("login-form-password")).clear();
    wd.findElement(By.id("login-form-password")).sendKeys("1qaz2wsx3edc");
    }

   @Test
    public void enterJira() throws InterruptedException {
       wd.findElement(By.name("login")).click();
    }

    @AfterClass
    public void tearDown() {
//wd.quit();
    }
}
