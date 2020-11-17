package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GlbSignInPage {

    public GlbSignInPage() {
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(id="email")
    public WebElement email;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(name = "submit")
    public WebElement loginbuton;

    @FindBy(xpath = "//div[@class='alert alert-danger']")
    public WebElement sorry_mesaj;

    @FindBy(xpath = "//strong['=My Account']")
    public WebElement error_Mesaj;


}
