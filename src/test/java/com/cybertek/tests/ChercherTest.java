package com.cybertek.tests;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ChercherTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //implicitly wait

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test

    public void alertPresentTest(){
        WebElement initiateAlert = driver.findElement(By.id("alert"));
        initiateAlert.click();
        wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.alertIsPresent());
        //hande JS alert
        //NoAlertPresentException
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }


}
