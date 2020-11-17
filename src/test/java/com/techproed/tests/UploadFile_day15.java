package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadFile_day15 extends TestBase {
    //Tests packagenin altina bir class oluşturun : UploadFile
    //https://the-internet.herokuapp.com/upload
    //Bir metod oluşturun : uploadFileMethod
    //Yuklemek istediginiz dosyayi secin.
    //Upload butonuna basin.
    //“File Uploaded!” textinin goruntulendigini dogrulayin.

    @Test
    public void uploadFileMethod(){
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseFileButton= driver.findElement(By.id("file-upload"));
        String dosyaYolu="C:\\Users\\pinar\\Pictures\\Screenshots\\Screenshot (6).png";
        chooseFileButton.sendKeys(dosyaYolu);
        WebElement uploadButton=driver.findElement(By.id("file-submit"));
//        uploadButton.click();
//SENDKEYS KULLANABILMEK ICIN CHOOSE FILE ELEMENTININ TAG=INPUT Ve TYPE="file" OLMALI

        //“File Uploaded!” textinin goruntulendigini dogrulayin.
        WebElement fileUploadText=driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(fileUploadText.isDisplayed());

        //asagidaki gibi kisa olarak da yapilabilir
      //  Assert.assertEquals(driver.findElement(By.xpath("//h3")).getText(),"File Uploaded");

    }


}
