package com.techproed.smoketest;

import com.techproed.pages.FHCLoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstDriverTest {

    @Test
    public void gecersizPassword(){
        //driver=Driver.getDriver   //artik driver yerine bunu kullanacaz Driver classindan gelecek
        Driver.getDriver().get(ConfigReader.getProperty("fhc_login_url"));
        FHCLoginPage fhcLoginPage = new FHCLoginPage(Driver.getDriver());
        fhcLoginPage.username.sendKeys(ConfigReader.getProperty("gecerli_username"));
        fhcLoginPage.password.sendKeys(ConfigReader.getProperty("gecersiz_password"));
        fhcLoginPage.loginButton.click();

        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
        WebElement hataMesaji=wait.until(ExpectedConditions.visibilityOf(fhcLoginPage.error_mesaj));
        Assert.assertTrue(hataMesaji.isDisplayed());
    }
}
