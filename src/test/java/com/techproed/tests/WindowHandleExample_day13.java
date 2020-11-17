package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandleExample_day13 extends TestBase {
    //Tests package’inda yeni bir class olusturun: WindowHandleExample
    //newWindowTest adinda methot olusturun
    //https://the-internet.herokuapp.com/windows adresine gidin.
    //Sayfadaki textin  “Opening a new window” olduğunu doğrulayın.
    //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    //Click Here butonuna basın.
    //Acilan yeni pencerenin sayfa başlığının (title)  “New Window” oldugunu dogrulayin.
    //Sayfadaki textin   “New Window” olduğunu doğrulayın.
    //Bir önceki pencereye geri döndükten sonra sayfa başlığının  “The Internet” olduğunu doğrulayın

    @Test
    public void newWindowTest(){
        driver.get("https://the-internet.herokuapp.com/windows");
        String parentWindowHandle=driver.getWindowHandle();
        System.out.println("parent window handle" +parentWindowHandle);
        //window handle string return ettigi icin string olusturruyoruz

        String actualText= driver.findElement(By.xpath("//h3[.='Opening a new window']")).getText();
        String expectedText="Opening a new window";
         Assert.assertEquals(actualText,expectedText);

        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle=driver.getTitle();  //title alirken locate etmeye gerek yok
        String expectedTitle="The Internet";
        Assert.assertEquals(actualTitle,expectedTitle);

        //Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();

        //Acilan yeni pencerenin sayfa başlığının (title)  “New Window” oldugunu dogrulayin.
        Set<String> allWindowHandle=driver.getWindowHandles(); //handles larda set kullanilir genelde
        for (String childWindowHandle : allWindowHandle){
              if(!childWindowHandle.equals(parentWindowHandle)){
                  driver.switchTo().window(childWindowHandle);
                  System.out.println("child window handle=>" + childWindowHandle);
              }

        }


        String newWindowTitle=driver.getTitle();        //assert ile daha kolay yapilir esitlik kontrolu
        Assert.assertEquals(newWindowTitle,"New Window");

        //Sayfadaki textin   “New Window” olduğunu doğrulayın.
        String newWindowText=  driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals(newWindowText,"New Window");
        //driver.close(); bunu yaparsak bulundugu sayfayi kapatir ama ilk sayfaya donemez fail olur

        //Bir önceki pencereye geri döndükten sonra sayfa başlığının  “The Internet” olduğunu doğrulayın
        driver.switchTo().window(parentWindowHandle);
        Assert.assertEquals(driver.getTitle(),"The Internet"); //string olusturmadan actual ve expected lari boyle kolay yapiyoruz


    }


}
