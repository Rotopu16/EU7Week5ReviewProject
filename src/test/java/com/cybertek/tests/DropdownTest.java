package com.cybertek.tests;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DropdownTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //implicitly wait

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
    }

    @AfterMethod
//    public void tearDown(){
//        driver.quit();
//    }

    @Test

    public void Test() {

        WebElement userInputBox = driver.findElement(By.id("ctl00_MainContent_username"));
        userInputBox.sendKeys("Tester");

        WebElement passwordBox = driver.findElement(By.id("ctl00_MainContent_password"));
        passwordBox.sendKeys("test"+ Keys.ENTER);

        WebElement orderLink = driver.findElement(By.linkText("Order"));
        orderLink.click();

        String expectedSelectedOption="MyMoney";
        WebElement productDropDownElement= driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct"));

        Select productDropDown = new Select(productDropDownElement);
        String actualSelectedOption = productDropDown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualSelectedOption,expectedSelectedOption, "verify options are same");

        // 5. Then select FamilyAlbum, make quantity 2, and click Calculate,

        productDropDown.selectByValue("FamilyAlbum");

        WebElement quantityBox = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));

        quantityBox.sendKeys("2");

        //    6. Then verify Total is equal to Quantity*PricePerUnit

        WebElement calculateButton = driver.findElement(By.className("btn_dark"));
        calculateButton.click();


    }

}
