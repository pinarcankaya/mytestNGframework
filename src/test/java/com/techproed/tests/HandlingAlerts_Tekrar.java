package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HandlingAlerts_Tekrar  extends TestBase {
   // Bir class olusturun: HandlingAlerts
    //https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    //Bir metod olusturun: acceptAlert
    //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının görüntülendiğini doğrulayın.
    //Bir metod olusturun: dismissAlert
    //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının görüntülendiğini doğrulayın.
    //Bir metod olusturun: sendKeysAlert
    //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna tıklayın ve result mesajının görüntülendiğini doğrulayın.

    @Test
    public void acceptAlert(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement alertButton=driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        alertButton.click();
        //alert mesaji
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        WebElement resulMesaj=driver.findElement(By.id("result"));
        Assert.assertTrue(resulMesaj.isDisplayed());

    }
    @Test
    public void dismissAlert(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement button2=driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        button2.click();
        driver.switchTo().alert().dismiss();

        WebElement resulMesaj2=driver.findElement(By.id("result"));
        Assert.assertTrue(resulMesaj2.isDisplayed());

    }
    @Test
    public void sendKeysAlert(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement button3=driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        button3.click();
        driver.switchTo().alert().sendKeys("Pinarcim");
        driver.switchTo().alert().accept();

        WebElement resultMesaj3=driver.findElement(By.id("result"));
        Assert.assertTrue(resultMesaj3.isDisplayed());

    }
}
