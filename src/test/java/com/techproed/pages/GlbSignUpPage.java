package com.techproed.pages;


import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GlbSignUpPage {
    //Global Trader Sign Up Test.
    //Kullanici https://www.glbtrader.com/register.html adresine gitsin.
    //Kullanici kimlik bilgileri ile kayit oldugunda “Success!” mesajini gormeli.
    //pages  paketinin altina bir page class olusturun : GlbSignUpPage
    //Page objelerini(webelement) bulun.
    //smoketest  paketinin altina bir test classi olusturun : GlbSignUpTest
    //=====Page Object Model kullanin======

    ///driver yerine ===>Driver.getDriver()

    public GlbSignUpPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="email")
    public WebElement emailTextBox;

    @FindBy(id="name")
    public WebElement enterName;

    @FindBy(id="mobile")
    public WebElement mobile;

    @FindBy(id="password")
    public WebElement password;

    @FindBy(id="re_password")
    public WebElement rePassword;

    @FindBy(name = "submit")
    public WebElement signUpButton;

    @FindBy(xpath = "//strong")
    public  WebElement succes_mesaj;


}
