package com.techproed.smoketest;

import com.techproed.pages.FHCLoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class FHCLoginPositiveTest extends TestBase {
////Username : manager2
////Password : Man1ager2!
    @Test
    public void positiveTestLogin(){

    driver.get(ConfigReader.getProperty("fhc_login_url"));

        FHCLoginPage fhcLoginPage=new FHCLoginPage(driver); //simdi ulasabiliriz diger classa
        fhcLoginPage.username.sendKeys(ConfigReader.getProperty("gecerli_username"));
        fhcLoginPage.password.sendKeys(ConfigReader.getProperty("gecerli_password"));
        fhcLoginPage.loginButton.click();
    }
}
