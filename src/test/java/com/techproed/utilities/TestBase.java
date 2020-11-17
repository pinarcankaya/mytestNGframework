package com.techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {

//surekli kullandigimiz methodlari tekrar yazmamak icin
   // obje kullanladigimiz icin abstract class olusturduk
    //driver burda uretildigi icin diger sayfalardan driver otomatik calisir
     protected   WebDriver driver;  ///protected yapmaliyiz ki diger package"tan gorunsun yoksa gorunmez
    protected Actions actions;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        actions=new Actions(driver);
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}