package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FaceLoginPage {
    // create driver
    WebDriver driver;

    //Yeni bir class oluşturun: FaceLogin
    //Bir test metodu oluşturun: faceLoginTest ()
    //Kullanıcı geçersiz kimlik bilgileri girdiğinde,
    // kullanıcı “The email or phone number you’ve entered doesn’t match any account.” mesajini görmelidir.
    //https://www.facebook.com/
    //Username: fakeusername
    //Password: fakepassword
    public FaceLoginPage(WebDriver driver) {
        this.driver=driver;
        //page objelerini(web element) baslatmak icin PageFactory.initElements() kullnaiyoruz
        PageFactory.initElements(driver,this); //face e gidilmedigi halde face deki elemanlari getirir

        //PageFactory.initElements(driver,page:this);
        //satiriyla, ==> Bu sayfa icerisinde, @FindBy annotationuyla locate edilen butun
        // web elementleri driver'i kullanarak baslat demis oluyoruz
    }
    //buraya kadar her zaman kulllanacaz
    //yeni locate etme yolu
    @FindBy(id="email")  //diger class tan ulasmak icin public yada protected koymaliyiz
    public WebElement email;

    @FindBy(id="pass")
    public WebElement password;

    @FindBy(id="u_0_b")
    public WebElement loginButton;

    @FindBy(xpath="//div[@role='alert']")
    public WebElement error_mesaj;


}
