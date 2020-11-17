package com.techproed.smoketest;

import com.techproed.pages.GlbSignInPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.annotations.Test;

public class PositiveTestGlbSignIn {
    GlbSignInPage glbHomePage;
    public void setup(){
        Driver.getDriver().get(ConfigReader.getProperty("glb-signin-url"));
    }
    @Test(groups = "GroupTest1")
    public void signInTest(){
        setup();
        glbHomePage.email.sendKeys(ConfigReader.getProperty("test_email"));
        glbHomePage.password.sendKeys(ConfigReader.getProperty("test_password"));
        glbHomePage.loginbuton.click();
    }
}
