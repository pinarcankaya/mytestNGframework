package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import sun.security.pkcs.SigningCertificateInfo;

import java.util.concurrent.TimeUnit;

public class IframeTest_day12 {
    //Bir class olusturun: IframeTest
    //https://the-internet.herokuapp.com/iframe  adresine gidin.
    //Bir metod olusturun: iframeTest
    //“An IFrame containing….” textini konsolda yazdirin.
    //Text Box’a “Merhaba Dunya!” yazin.
    //TextBox’in altinda bulunan “Elemental Selenium” linkini textini konsolda yazdirin.

    //TextBox’in altinda bulunan “Elemental Selenium” linkini textini konsolda yazdirin.

    @Test
    public void iframeTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //“An IFrame containing….” textini konsolda yazdirin
        System.out.println(driver.findElement(By.xpath("//h3")).getText());
        //Text Box’a “Merhaba Dunya!” yazin.
        // WebElement textBox = driver.findElement(By.xpath("//p")); //FAIL
        //textBox.sendKeys("Merhaba Dunya!");
        //TEST FAIL OLURSA NE YAPMALIYIZ??
        //1. Locator kontrol edilmeli
        //2. Wait(Bekleme) problemi var mi kontrol edilmeli
        //3. Sayfada Iframe var mi kontrol edilmeli

        //Bu sayfada IFRAME var. Dolayisiyla Iframe switchTo() yapmaliyiz.
        //Bir Iframe switch yapmanin 3 yolu vardir: 1. index ile, 2.id veya name value ile, 3.WebElement ile
        //driver.switchTo().frame(0); // index 0 dan baslar.//index kullanarak iframe'a gittik

       // driver.switchTo().frame("mce_0_ifr");  //id veya name value lazim iframe gitmek icin(value kullaninca).bu daha yavas gidiyor

        WebElement frameElement=driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(frameElement); //webelement kullanarak iframe'a gttik


        //Artik iframe icindeki elementi bulabiliriz
        WebElement textBox = driver.findElement(By.xpath("//p"));
        textBox.clear();
        textBox.sendKeys("Pinarcim Hosgeldin!");


   //1-Asagidaki soz dizimlzei ne anlama gelir?
    //a. driver.switch().alert().accept()  ==> Popop Kabul etme "Ok" a tiklama.
    //b. driver.switch().alert().dismiss() ==> Popop Iptal etme "Cancel" a tiklama.
    //c. driver.switch().alert().getText() ==> Popop ta yazan yaziyi almak.
    //d. driver.switch().alert().sendKeys() ==> Popop a text gonderme.
    //2.iframe nedir?
    // iframe ==> Bir html sayfasinda baska bir html sayasini cagirmak icin kullanilan html tag i dir.
    //3. Iframe varsa Iframe e gecisin 3 yolu vardir.
    //    1. Yontem = driver.switch().frame(0) ==> index ile gecis ilk iframe e gecer.
    //    2. Yontem = driver.switch().frame("id veya name valuesi") ==> id ve ya name valuesi ile gecis
    //    3. Yontem = driver.switch().frame(WebElement) ==> Daha once locate edilen ve Webelemente atanan elemanla iframe e gecis




        // //TextBox’in altinda bulunan “Elemental Selenium” linkini textini konsolda yazdirin.
        //locate ediyoruz selenium textini
        //parent frame a geri gelelim
        driver.switchTo().parentFrame(); //parente geri gider
      //2.yol--  driver.switchTo().defaultContent();  //default sayfaya gider. ilk basa.
        WebElement seleniumText=driver.findElement(By.linkText("Elemental Selenium"));
        System.out.println(seleniumText.getText());


        //iframe      ==> ilk bastakine gemek istersek "defaultContent" methodu kullanilir
                //iframe1  ===>buraya gelmek istiyorm bu durumda "parentFrame metodu" kullanilir
                        //iframe2  ====> buradayim
                                //iframe3



    }
}