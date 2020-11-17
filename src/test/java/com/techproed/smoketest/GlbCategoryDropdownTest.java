package com.techproed.smoketest;

import com.techproed.pages.GlbHomePage_CategoryDropdown;
import com.techproed.pages.GlbSignUpPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

//Kullanıcı https://www.glbtrader.com/ adresine gittiğinde
//All Categories dropdown elementinde Furniture seçeneğinin bulunduğunu doğrulayın.
//Adım 1: Page objelerini oluşturmak için GlbHomePage'i kullanabilirsiniz.
//Adım 2: Test classı oluşturun GlbCategoryDropdownTest

public class GlbCategoryDropdownTest {

    GlbHomePage_CategoryDropdown glbHomePage=new GlbHomePage_CategoryDropdown();

    @Test
    public void glbDropDowntest(){
       // Driver.getDriver().get(ConfigReader.getProperty("glb_url"));



        Select options=new Select(glbHomePage.allCategoriesDropDown);
       boolean flag=false;
        for(WebElement secenek:options.getOptions()){
            if(secenek.getText().equals("Furniture")){
                System.out.println("Dropdownda Furniture vardir");
                flag=true;
                break;
            }
        }
        Assert.assertTrue(flag);
        Driver.closeDriver();
    }
}
