package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WaitTest_day15 extends TestBase {
    //1.  Bir class olusturun : WaitTest
    //2.  Iki tane metod olusturun :  implicitWait() , explicitWait()
    //    Iki metod icin de asagidaki adimlari test edin.
    //3.  https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //4.  Remove butonuna basin.
    //5.  “It’s gone!” mesajinin goruntulendigini dogrulayin.


    @Test
    public void implicitWait(){
    driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement removeButton=driver.findElement(By.xpath("//button[@type='button']"));
        removeButton.click();

        //mesajin yuklenlesi biraz zaman aldigi icin wait koymak gerekiyor
       // driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //==>burasi testbase de var

        WebElement goneMessage=driver.findElement(By.id("message"));

       // “It’s gone!” mesajinin goruntulendigini dogrulayin.
        Assert.assertEquals(goneMessage.getText(),"It's gone!");

    }

    @Test
    public void explicitWait(){
        //web objesini create edelim
        WebDriverWait  wait=new WebDriverWait(driver,20);

        //3.  https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4.  Remove butonuna basin.
        WebElement removeButton=driver.findElement(By.xpath("//button[@type='button']"));
        removeButton.click();

    WebElement goneMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

        // “It’s gone!” mesajinin goruntulendigini dogrulayin.
        Assert.assertEquals(driver.findElement(By.id("message")).getText(),"It's gone!");

        //implicy waitin ise yaramadigi yerlerde explicy wait kullaniriz
        //implicty nin snytaxi kolay oldugu icin tercihimizdir ve global oldugu icin ama ise yaraamdigi durumlar olabilir
    }
}
