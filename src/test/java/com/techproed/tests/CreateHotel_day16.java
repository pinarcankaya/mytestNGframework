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

public class CreateHotel_day16 extends TestBase {
    //Tests packagenin altina class olusturun: CreateHotel
    //Bir method olusturun: createHotel
    //http://www.fhctrip.com/admin/HotelAdmin/Create adresine gidin.
    //Username textbox ve password textboxlarini locate edin ve asagidaki verileri girin.
    //Username : manager2
    //Password : Man1ager2!
    //Login butonuna basin.
    //Acilan sayfadaki butun textboxlara istediginiz verileri girin (en sondaki dropdowna dikkat edin).
    //Save butonuna basin.
    //“Hotel was inserted successfully” textinin goruntulendigini dogrulayin.
    //OK butonuna tiklayin.

    @Test
    public void createHotel(){
        driver.get("http://www.fhctrip-qa.com/admin/HotelAdmin/Create");
        WebElement userNameTextBox=driver.findElement(By.id("UserName"));
        WebElement passwordTextBox=driver.findElement(By.id("Password"));
        userNameTextBox.sendKeys("manager2");
        passwordTextBox.sendKeys("Man1ager2!");
        WebElement loginButton=driver.findElement(By.xpath("//button"));
        loginButton.click();

        WebElement code=driver.findElement(By.id("Code"));
        code.sendKeys("Hotel");
        WebElement name=driver.findElement(By.id("Name"));
        name.sendKeys("ZabaaaKadarBurdayiz");

        WebElement adres=driver.findElement(By.id("Address"));
        adres.sendKeys("Paris");
        WebElement phone=driver.findElement(By.id("Phone"));
        phone.sendKeys("0033555555555");

        WebElement email=driver.findElement(By.id("Email"));
        email.sendKeys("butikZabah@gmail.com");


        WebElement idGroup=driver.findElement(By.id("IDGroup"));
        Select select=new Select(idGroup);
        select.selectByIndex(1);

        //actions.sendKeys(Keys.PAGE_DOWN).perform(); // save gozukmezse bu yolla asagiya indirilebilir

        //  //Save butonuna basin.
        WebElement saveButton=driver.findElement(By.id("btnSubmit"));
        saveButton.click();

        WebDriverWait wait=new WebDriverWait(driver,10);
        boolean isTrue=wait.until(ExpectedConditions.textToBe(By.xpath("//div[@class='bootbox-body']"),"Hotel was inserted successfully"));
        Assert.assertTrue(isTrue);

        //“Hotel was inserted successfully” textinin goruntulendigini dogrulayin.
     //   WebElement mesaj=driver.findElement(By.xpath("//div[@class='bootbox-body']"));
      //  Assert.assertTrue(mesaj.isDisplayed());

        //OK butonuna tiklayin.
        WebElement okButton=driver.findElement(By.xpath("//button[@data-bb-handler='ok']"));
        okButton.click();



    }
}
