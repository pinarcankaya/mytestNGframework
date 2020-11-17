package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class
HotelRoomCreation extends TestBase {
    //Tests packagenin altina class olusturun: HotelRoomCreation
    //Bir method olusturun:  RoomCreateTest()
    //http://www.fhctrip.com/admin/HotelRoomAdmin adresine gidin.
    //Username textbox ve password textboxlarini locate edin ve asagidaki verileri girin.
    //Username : manager2
    //Password : Man1ager2!
    //Login butonuna basin.
    //Add hotelroom butonun a tiklayin
    //Acilan sayfadaki butun textboxlara istediginiz verileri girin
    //Save butonuna basin.
    //“HotelRoom was inserted successfully” textinin goruntulendigini dogrulayin.
    //OK butonuna tiklayin.
    //Hotel rooms linkine tiklayin.
    //"LIST OF HOTELROOMS" textinin goruntulendigini(isDisplayed) dogrulayin.

    @Test
    public void RoomCreateTest(){
        driver.get("http://fhctrip-qa.com/admin/HotelAdmin/Create");
        WebElement userNameTextBox=driver.findElement(By.id("UserName"));
        WebElement passwordTextBox=driver.findElement(By.id("Password"));
        userNameTextBox.sendKeys("manager2");
        passwordTextBox.sendKeys("Man1ager2!");
        WebElement loginButton=driver.findElement(By.xpath("//button"));
        loginButton.click();

        //Add hotelroom butonun a tiklayin
      WebElement addButton=driver.findElement(By.className("hidden-480"));
        addButton.click();

        //dropdown menuyu locat ettik
        WebElement idHotel=driver.findElement(By.id("IDHotel"));
        Select select=new Select(idHotel);
        select.selectByIndex(9);

        //Acilan sayfadaki butun textboxlara istediginiz verileri girin

        WebElement code=driver.findElement(By.id("Code"));
        code.sendKeys("GezginRuhlar");
        WebElement name=driver.findElement(By.id("Name"));
        name.sendKeys("Bir Cift Mutluluk");
        WebElement location=driver.findElement(By.id("Location"));
        location.sendKeys("Her Yer Uyar");

        WebElement iframeTextBox=driver.findElement(By.xpath("//textarea[@dir='ltr']"));
        iframeTextBox.sendKeys("En Guzel Manzaram Esim");

        WebElement kaynak= driver.findElement(By.linkText("500"));
        WebElement hedef=driver.findElement(By.id("Price"));
        actions.dragAndDrop(kaynak,hedef).perform();

        WebElement roomType=driver.findElement(By.id("IDGroupRoomType"));
        Select select1=new Select(roomType);
        select1.selectByIndex(5);
        //value yada visibility ile de secilabilir

        WebElement yetiskinSayisi=driver.findElement(By.id("MaxAdultCount"));
        yetiskinSayisi.sendKeys("2");

        WebElement cocukSayisi=driver.findElement(By.id("MaxChildCount"));
        cocukSayisi.sendKeys("4");

        WebElement saveButton=driver.findElement(By.xpath("//button[.='Save']"));
        saveButton.click();



      //  WebElement hotelRoomText=driver.findElement(By.className("bootbox-body"));
       // Assert.assertEquals(hotelRoomText,);

        //explicit wait
        WebDriverWait wait=new WebDriverWait(driver,10);
        WebElement okMesaj = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bootbox-body")));
      //boolean isTrue=  wait.until(ExpectedConditions.textToBe(By.className("bootbox-body")));  ///bu yontemle de bekleme yapilabilir
        Assert.assertTrue(okMesaj.getText().equals("HotelRoom was inserted successfully"));
        System.out.println("ok mesaji: " +okMesaj);


        WebElement okButton=driver.findElement(By.xpath("//button[.='OK']"));
        okButton.click();


        //Hotel rooms linkine tiklayin.

        //"LIST OF HOTELROOMS" textinin goruntulendigini(isDisplayed) dogrulayin.
        actions.sendKeys(Keys.PAGE_UP).perform();
        actions.sendKeys(Keys.PAGE_UP).perform();


        //WebElement hotelRoomsLink=wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[@href='/admin/HotelRoomAdmin']"))));

        WebElement hotelRoomsLink=driver.findElement(By.partialLinkText("Hotel Rooms"));
        hotelRoomsLink.click();

        WebElement listText=driver.findElement(By.xpath("//span[.='List Of Hotelrooms']"));
       Assert.assertTrue(listText.isDisplayed());

       // actions.sendKeys(Keys.PAGE_DOWN).perform();  asagi inmedigi durumlarda kullan
    }
}
