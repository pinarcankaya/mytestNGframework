package com.techproed.smoketest;

import com.techproed.pages.GlbHomePage_CategoryDropdown;
import com.techproed.pages.GlbSignUpPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GlbSignUpTest {
    //Global Trader Sign Up Test.
    //Kullanici https://www.glbtrader.com/register.html adresine gitsin.
    //Kullanici kimlik bilgileri ile kayit oldugunda “Success!” mesajini gormeli.
    //pages  paketinin altina bir page class olusturun : GlbSignUpPage
    //Page objelerini(webelement) bulun.
    //smoketest  paketinin altina bir test classi olusturun : GlbSignUpTest
    //=====Page Object Model kullanin======
    //config reader ve driver clasi kullan

    GlbSignUpPage glbSignUpPage=new GlbSignUpPage();
    GlbHomePage_CategoryDropdown glbHomePage=new GlbHomePage_CategoryDropdown();


    @Test
    public void signUpTest() throws InterruptedException {
        //driver===>>Driver.getDriver()
        //Driver.getDriver().get(ConfigReader.getProperty("glb-signup-url"));
       //joinnow linki bulacaz
        Driver.getDriver().get(ConfigReader.getProperty("glb_url"));
        glbHomePage.joinNowLink.click();


        glbSignUpPage.emailTextBox.sendKeys(ConfigReader.getProperty("test_email"));
        glbSignUpPage.enterName.sendKeys(ConfigReader.getProperty("test_username"));
        glbSignUpPage.mobile.sendKeys(ConfigReader.getProperty("test_phone"));
        glbSignUpPage.password.sendKeys(ConfigReader.getProperty("test_password"));
        glbSignUpPage.rePassword.sendKeys(ConfigReader.getProperty("test_password"));
        glbSignUpPage.signUpButton.click();

        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(glbSignUpPage.succes_mesaj)).isDisplayed());


        System.out.println("Succes Mesaj: " + glbSignUpPage.succes_mesaj.getText());
        //test fail olacak cunku actuel test ile expected ayni degil unlem !! fazla birinde
        Driver.closeDriver();
    }
}
