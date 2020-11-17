package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.nio.file.Files;
import java.nio.file.Paths;



public class FileDownload_day15 extends TestBase {
    //Tests packagenin altina bir class oluşturun : FileDownload
    //Iki tane metod oluşturun : isExist() ve downloadTest()
    //downloadTest () metodunun icinde aşağıdaki testi yapın:
    //https://the-internet.herokuapp.com/download adresine gidin.
    //image1.jpg dosyasını indir
    //Ardından dosyanın başarıyla indirilip indirilmediğini doğrulayın.
    @Test
    public void isExist(){
        String mevcutKlasor=System.getProperty("user.dir");
        System.out.println("MEVCUT KLASOR=>" + mevcutKlasor);

        String userKlasor=System.getProperty("user.home");
        //users/pinar/
        System.out.println("USER KLASOR=>" +userKlasor);

        String filePath=userKlasor+"/Pictures\\Screenshots\\Screenshot (6).png";
       // String filePath="C:\\Users\\pinar\\Pictures\\Screenshots\\Screenshot (6).png";
        //boyle de yapilabilir ama ustteki daha guzel..
        boolean isFileExist = Files.exists(Paths.get(filePath));
        Assert.assertTrue(isFileExist);//eger dosya varsa(file exist yani) true olacak ve test Pass olacak.yoksa fail olur


    }


    @Test
    public void downloadTest() throws InterruptedException {
        //https://the-internet.herokuapp.com/download adresine gidin.
        //image1.jpg dosyasını indir
        //Ardından dosyanın başarıyla indirilip indirilmediğini doğrulayın.
    driver.get("https://the-internet.herokuapp.com/download");
        WebElement image1=driver.findElement(By.linkText("image1.jpg"));
        image1.click();
        //dosyanin yuklenmesi icin zamana ihtiyac olursa bekleme suresu koyun
        Thread.sleep(5000);  //HARD WAIT//bu waiti mecbur kalmadikca kullanmayacaz
        //kullanici klasoru
        String userKlasor=System.getProperty("user.home");
        //indirilen dosyanin konumunu(path) buluyoruz
        String filePath=userKlasor+"/Downloads/image (1).png";
      //  String filePath="buraya direkt path de yazilabilir"
        boolean isDownloaded=Files.exists(Paths.get(filePath));

        Assert.assertTrue(isDownloaded); //dosya yuklendiyse test pass olacak

    }
}
