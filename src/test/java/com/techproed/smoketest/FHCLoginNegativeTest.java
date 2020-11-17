package com.techproed.smoketest;

import com.techproed.pages.FHCLoginPage;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FHCLoginNegativeTest extends TestBase {
    //fhctrip uygulamasının oturum açma işlevselliğini test edin.
    // http://www.fhctrip.com/Account/Logon
    //Iki ayri class olusturun (package:smoketest) : PositiveTest ve NegativeTest
    //Positive Test : her ikisi de geçerli username ve password
    //Negative test :
    //geçerli  username fakat geçersiz password
    //geçerli password  fakat geçersiz username
    //her ikisi de geçersiz username ve password.

    FHCLoginPage fhcLoginPage;
    WebDriverWait wait;
    public void login() {
        driver.get("http://fhctrip-qa.com/Account/Logon");
        fhcLoginPage = new FHCLoginPage(driver);
    }


    public void GecersizuserName() {
        login();
        fhcLoginPage.username.sendKeys("mana");
        fhcLoginPage.password.sendKeys("Man1ager2!");
        fhcLoginPage.loginButton.click();

        wait=new WebDriverWait(driver,10);
        WebElement tryAgain=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='Try again please']")));
        Assert.assertTrue(tryAgain.isDisplayed());
        //Assert.assertTrue(fhcLoginPage.error_mesaj.getText().contains("Try again please"));
        //Assert.assertTrue(fhcLoginPage.error_mesaj.isDisplayed());

    }

    @Test
    public void GecersizPassword() {
    login();
        fhcLoginPage.username.sendKeys("manager2");
        fhcLoginPage.password.sendKeys("Man1!");
        fhcLoginPage.loginButton.click();
        Assert.assertTrue(fhcLoginPage.error_mesaj.isDisplayed());
    }

    @Test
    public void GecersizUsernamevePassword() {
    login();
        fhcLoginPage.username.sendKeys("mana");
        fhcLoginPage.password.sendKeys("Man1!");
        fhcLoginPage.loginButton.click();
//onceki iki testte wrong password yazisi cikarken ikiside yanlis oldugunda wrong password yazisi cikmiyor//unutma video cekiminde soyle

    }
}