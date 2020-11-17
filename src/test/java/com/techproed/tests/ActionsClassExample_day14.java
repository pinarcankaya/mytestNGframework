package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsClassExample_day14 extends TestBase {

    //class olusturma : ActionsClassExample
    //Create  test method : contextClickMethod() ve aşağıdaki senaryoyu test edin:
    //https://the-internet.herokuapp.com/context_menu web sitesine gidin.
    //Dikdörtgen kutu icinde sağa tıklayın.
    //Alert mesajinin “You selected a context menu” oldugunu dogrulayin.
    //Alert’te OK ye basin


    @Test
    public void contextClickMethod(){
        //web sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //Dikdörtgen kutu icinde sağa tıklayın.
        WebElement dikdortgen=driver.findElement(By.id("hot-spot"));

       // create actions class
        //Actions actions=new Actions(driver); ///TestBase ye alalim
        actions.contextClick(dikdortgen).perform();

        //Alert mesajinin “You selected a context menu” oldugunu dogrulayin.
      String actualText=driver.switchTo().alert().getText();
      String expectedText="You selected a context menu";  //(icerik menusu demek)
        Assert.assertEquals(actualText,expectedText);

        //Alert’te OK ye basin
        driver.switchTo().alert().accept();
    }
    @Test
    public void  hoverOver() {
        //Create  test method : hoverOver() ve aşağıdaki senaryoyu test edin:
        //https://www.amazon.com/  web sitesine gidin.
        //“Your Account” linkine tıklayın.
        //Sayfa basliginin(page title) “Your Account) icerdigini(contains) dogrulayin.
        driver.get("https://www.amazon.com/");

        WebElement helloSignIn = driver.findElement(By.xpath("//span[.='Hello, Sign in']"));
        actions.moveToElement(helloSignIn).perform();
        WebElement yourAccount = driver.findElement(By.linkText("Your Account"));
        yourAccount.click();

        String amazonTitle= driver.getTitle();
        Assert.assertTrue(amazonTitle.contains("Your Account"));
    }


    @Test
    public void keysUpDown(){
       //https://www.google.com/ adresine gidin.
        //Google text box’a IPHONE (capital) yazdirin
        //( input(giris) => iphone , output => IPHONE)  !!
        //Text box’ta cift tiklayin(double click).

        driver.get("https://www.google.com/");
        WebElement searchBox=driver.findElement(By.name("q"));
     //   searchBox.sendKeys("iphone"); //boyle yine oldugu gibi kucuk harfle yazar
        //Bizde istenen kucuk harflerle yazip searchBox a BUYUK yazilmasi.

        //buyuk harf icin 1.yol
      //  searchBox.sendKeys(Keys.SHIFT+"iphone");

        //buyuk harf 2.yol //Actions class kullnaacaz
//            actions.
//                moveToElement(searchBox).click().
//                keyDown(Keys.SHIFT).
//                sendKeys("iphone").perform();


        actions.
                keyDown(searchBox,Keys.SHIFT).
                sendKeys("iphone").
                keyUp(searchBox,Keys.SHIFT);

        // Text box’ta cift tiklayin(double click). //kelimeyi yazinca mavi secili moda donusme durumu
        actions.doubleClick(searchBox).perform();

// *1 Eger bir yerde keyDown yaparsak hep oyle kalir(SHIFT Basili kalir)
//    onun icin tekrar yazacaksak keyUp yapmaliyiz.
// ACTION kullandigimiz zaman en sonunda mutlaka PERFORM kullanmak zorundayiz.
    }
    @Test
    public void scrollUp() throws InterruptedException{
        driver.get("https://www.amazon.com/");
        //sayfayi asagi dogru kaydirma
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        //bir sayfada birdn fazla page down ve page up kullanabiliriz
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Thread.sleep(5000);

        //ARROW_DOWN kullandiginizda sayfa inmeyi saglar ama daha az liktarda iner
        actions.sendKeys(Keys.ARROW_DOWN).perform();//page down a gore daha az inmesini saglar
        Thread.sleep(5000);
        //sayfayi yukari dogru kaydirma
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(5000);
        actions.sendKeys(Keys.ARROW_UP).perform();
      // actions.sendKeys(Keys.)
    }


//choose file i tiklayip dosya yuklemek  icin tag input olmali ve attribute type ve value file olmali


}
