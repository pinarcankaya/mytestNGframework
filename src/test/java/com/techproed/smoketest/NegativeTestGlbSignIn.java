package com.techproed.smoketest;

import com.techproed.pages.GlbSignInPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;
//Kullanici https://www.glbtrader.com/login.html
// sayfasina gitsin.
// Sayfaya dogru ve yanlis veriler
// girerek sign in ozelligini test etsin.
// 1.pages  paketinin altina bir page class olusturun :
// GlbHomePagea.Page objelerini(webelement) bulun.2.smoketest  paketinin altina iki tane test
// classi olusturun :
// ●PositiveTestGlbSignIn●NegativeTestGlbSignIn
// =====Page Object Model kullanin======
public class NegativeTestGlbSignIn {
        GlbSignInPage glbSignInPage;
        public void setup(){
            Driver.getDriver().get(ConfigReader.getProperty("glb-signin-url"));
            glbSignInPage=new GlbSignInPage();
        }



    @Test(groups = "GroupTest1")
    public void validEmailInvalidPassword(){
      setup();
      glbSignInPage.email.sendKeys(ConfigReader.getProperty("test_email"));
      glbSignInPage.password.sendKeys(ConfigReader.getProperty("gecersiz_password"));
      glbSignInPage.loginbuton.click();


        Assert.assertTrue(glbSignInPage.sorry_mesaj.isDisplayed());
        System.out.println("Sorry mesaj" + glbSignInPage.error_Mesaj.getText());
       // Assert.assertTrue(glbSignInPage.error_Mesaj.getText().equals("Sorry!"));
    }
    @Test(groups = "GroupTest1")
    public void invalidEmailValidPassword(){
            setup();
            glbSignInPage.email.sendKeys(ConfigReader.getProperty("invalid_email"));
            glbSignInPage.password.sendKeys(ConfigReader.getProperty("test_password"));
            glbSignInPage.loginbuton.click();

       Assert.assertTrue(glbSignInPage.error_Mesaj.isDisplayed());
        System.out.println("Sorry mesaj" + glbSignInPage.sorry_mesaj.getText());
    }
    @Test(groups = "GroupTest1")
    public void invalidEmailInvalidPassword(){
            setup();
            glbSignInPage.email.sendKeys(ConfigReader.getProperty("invalid_email"));
            glbSignInPage.password.sendKeys(ConfigReader.getProperty("gecersiz_password"));
            glbSignInPage.loginbuton.click();


        Assert.assertTrue(glbSignInPage.sorry_mesaj.isDisplayed());
        System.out.println("Sorry mesaj" + glbSignInPage.error_Mesaj.getText());
    }
}
