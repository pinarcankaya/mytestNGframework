package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class IframeTest_Tekrar extends TestBase {
    //Bir class olusturun: IframeTest
    //https://the-internet.herokuapp.com/iframe  adresine gidin.
    //Bir metod olusturun: iframeTest
    //“An IFrame containing….” textini konsolda yazdirin.
    //Text Box’a “Merhaba Dunya!” yazin.
    //TextBox’in altinda bulunan “Elemental Selenium” linkini textini konsolda yazdirin.

    //TextBox’in altinda bulunan “Elemental Selenium” linkini textini konsolda yazdirin

    @Test
    public void IframeTest(){
        driver.get("https://the-internet.herokuapp.com/iframe");

        System.out.println( driver.findElement(By.xpath("//h3")).getText());

       // WebElement textBox=driver.findElement(By.xpath("//p"));
       // textBox.sendKeys("Merhaba Dunya!");   //fail cikti
        // //TEST FAIL OLURSA NE YAPMALIYIZ??
        //        //1. Locator kontrol edilmeli
        //        //2. Wait(Bekleme) problemi var mi kontrol edilmeli
        //        //3. Sayfada Iframe var mi kontrol edilmeli

        WebElement frameElement=driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(frameElement); ///sayfadaki iframe'yi locate ettik yani artik ikinci bir
        // pencerede islem yapabiliriz

        WebElement textBox=driver.findElement(By.xpath("//p")); //simdi framedaki textbox i locate ettik
        textBox.clear();  ///icindeki otomatik yazilan yaziyi sildik
        textBox.sendKeys("Merhaba Dunya!"); //text box a yazi gonderdik

        //TextBox’in altinda bulunan “Elemental Selenium” linkini textini konsolda yazdirin.
        //bunun icin parent frame a geri gelmeliyiz yani ilk pencereye
        driver.switchTo().parentFrame();//bir ust parente gider
       // driver.switchTo().defaultContent();//her zaman ilk sayfaya gider
        WebElement seleniumText=driver.findElement(By.linkText("Elemental Selenium"));
        System.out.println(seleniumText.getText());  //consolda yazdirdik


    }
}
