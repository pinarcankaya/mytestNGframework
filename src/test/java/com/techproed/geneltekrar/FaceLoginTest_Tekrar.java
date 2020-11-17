package com.techproed.geneltekrar;

import com.techproed.pages.FaceLoginPage;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FaceLoginTest_Tekrar extends TestBase {

    @Test
    public void faceLoginTest (){
        driver.get("https://www.facebook.com");
        FaceLoginPage_Tekrar  loginPage=new FaceLoginPage_Tekrar(driver);

        loginPage.email.sendKeys(" fakeusername");
        loginPage.passwor.sendKeys("fakepassword");
        loginPage.loginButon.click();

        //login buttondan sonra bekleme koymaliyiz
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alert']")));

        Assert.assertTrue(loginPage.hataMesaji.isDisplayed());
    }
}
