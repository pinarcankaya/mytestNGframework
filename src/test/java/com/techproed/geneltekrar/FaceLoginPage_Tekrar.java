package com.techproed.geneltekrar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FaceLoginPage_Tekrar {
    //Yeni bir class oluşturun: FaceLogin
    //Bir test metodu oluşturun: faceLoginTest ()
    //Kullanıcı geçersiz kimlik bilgileri girdiğinde,
    // **kullanıcı “The email or phone number you’ve entered doesn’t match any account.” mesajini görmelidir.
    //https://www.facebook.com/
    //Username: fakeusername
    //Password: fakepassword

    WebDriver driver;

    public FaceLoginPage_Tekrar(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this); //page objelerini(web element) baslatmak icin PageFactory.initElements() kullnaiyoruz
        //Bu sayfa icerisinde, @FindBy annotationuyla locate edilen butun
        //        // web elementleri driver'i kullanarak baslat demis oluyoruz

    }
    @FindBy(id="email")
    public WebElement email;

    @FindBy(id="pass")
    public WebElement passwor;

    @FindBy(id="u_0_b")
    public WebElement loginButon;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement hataMesaji;


}
