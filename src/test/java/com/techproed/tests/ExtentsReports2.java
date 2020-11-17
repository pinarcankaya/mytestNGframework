package com.techproed.tests;

import com.techproed.pages.FHCLoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBase;
import com.techproed.utilities.TestBaseFinal;
import org.testng.Assert;
import org.testng.annotations.Test;
import sun.awt.ConstrainableGraphics;

public class ExtentsReports2 extends TestBaseFinal {

    FHCLoginPage fhcLoginPage;
    @Test
    public void negativeTest(){
        extentTest=extentReports.createTest("FHC Login Test","FHC login fonsiyonunun testi");

        extentTest.info("url'e git");
        Driver.getDriver().get(ConfigReader.getProperty("fhc_login_url"));

        extentTest.info("gecersiz user name gonder");
        fhcLoginPage.username.sendKeys(ConfigReader.getProperty("gecersiz_username"));

       extentTest.info("gecersiz password gonder");
        fhcLoginPage.password.sendKeys(ConfigReader.getProperty("gecersiz_password"));

        extentTest.info("login butonuna tikla");
        fhcLoginPage.loginButton.click();

        extentTest.info("dogrulama(asseertion) yap");
        Assert.assertTrue(fhcLoginPage.error_mesaj.getText().contains("Try again please"));
        extentTest.pass("passed: test gecti");  //pass olursa cikacak yazi

        ///sadece fail olma durulunda screen shot alir pass olunca almiyor
        extentTest.pass("Driver kapatildi");
        Driver.closeDriver();
    }
}
