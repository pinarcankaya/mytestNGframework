package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class EnableTest_day16 extends TestBase {
   //enable= etkin mi degil mi ulasilabiliyor mu//erisilebilir mi

//Bir class olusturun : EnableTest
//2.	Bir metod olusturun :  isEnabled()
//3.	https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
//4.	Enable butonuna basin.
//5.	Textbox’in etkin olup olmadigini(enabled) dogrulayin.
//6.	“It’s enabled!” mesajinin goruntulendigini dogrulayin.


    @Test
    public void isEnable(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement enableButton=driver.findElement(By.xpath("//button[.='Enable']"));
        enableButton.click();

       // 6.	“It’s enabled!” mesajinin goruntulendigini dogrulayin.
        //explicty wait gerekli cunku yuklema icin zaman gerekiyor ve belirli bir kosul var
        WebDriverWait wait=new WebDriverWait(driver,10);

        WebElement enableMesaj=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        //enable mesaji icin bekle
        Assert.assertEquals(enableMesaj.getText(),"It's enabled!");
        //mesaji dogruladik



        //   5.	Textbox’in etkin olup olmadigini(enabled) dogrulayin.
        WebElement enableTextBox=driver.findElement(By.xpath("//input[@type='text']"));
        boolean isEnable=enableTextBox.isEnabled();
        Assert.assertTrue(isEnable);

        //isEnable metodu()===>>bir elementin etkin olup olmadigini kontrol eder ekinse true degilse false olur
        //isDisplayed()=========>bir elementin gorunup gorunmedigini kontrol eder
        //isSelected()=========>bir element secmek icin //radio button ve checkbox lar icin
    }




}
