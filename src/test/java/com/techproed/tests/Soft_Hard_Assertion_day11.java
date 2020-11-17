package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import javax.xml.bind.SchemaOutputResolver;

public class Soft_Hard_Assertion_day11 {
    //Class name : Soft_Hard_Assertion
    //http://a.testaddressbook.com/sign_in adresine gidin.
    //email textbox,password textbox, ve signin button elementlerini locate edin.
    //Aşağıdaki username ve password girin ve signin buttonuna tıklayın.
    //Username :  testtechproed@gmail.com
    //Password :   Test1234!
    //Daha sonra farklı iddialar(assertions) kullanarak sayfaya doğru giriş yaptığınızı doğrulayın.
    //Daha sonra farklı iddialar(assertions) kullanarak testtechproed@gmail.com beklenen kullanıcı  kimliğinin(userID) doğrulayın

    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://a.testaddressbook.com/sign_in");
    }

    @Test
    public void login() {
        WebElement emailTextBox = driver.findElement(By.id("session_email"));
        emailTextBox.sendKeys("testtechproed@gmail.com");

        WebElement passwordTextBox = driver.findElement(By.id("session_password"));
        passwordTextBox.sendKeys("Test1234!");

        WebElement signinButton = driver.findElement(By.name("commit"));
        signinButton.click();
        driver.manage().window().maximize();
    }

    @Test(dependsOnMethods = "login")  //(priorty de yazsak olurdu
    public void homePackage() {  //once homepackage calisir cunku alfabetik bakiyor
        WebElement welcomeMessage = driver.findElement(By.xpath("//h1[.='Welcome to Address Book']"));
        System.out.println(welcomeMessage.getText());
        Assert.assertTrue(welcomeMessage.isDisplayed());
        //hard assert fail olursa bundan sonraki satirlar calismayacak demektir
        System.out.println("hard assert fail olursa bu satir calismayacak");
        System.out.println("bu yaziyi goruyorsan testin fail olmamistir ");

        //// "Hard Assert" kullandigimizda bir fail/hata alinca geriye kalani test etmez.
        //// Eger biz bir hata oldugunda hemen sonucu ogrenmek istiyorsak bunu kullaniriz.
        //// "Soft Assert" ise hata bulsa da sonuna kadar devam eder hepsini test eder ve
        //// sonuc olarak daha ayrintili rapor verir.
        //// "Soft Assert"  icin ilk once obje olusturmak zorundayiz. (SoftAssert class'inda)
        //// a) SoftAssert softAssert = new SoftAssert();
        //// b) softAssert.assertTrue();
        //// c) softAssert.assertAll(); //asil test yapan kisim.

        //SOFT ASSERT
        //1.adim obje olusturlur//create obje
        SoftAssert softAssert = new SoftAssert();
        //2.Adim==assertion ile olusturulan obje kullanilir
        //softAssert.assertTrue(!welcomeMessage.isDisplayed()); //fail
        softAssert.assertTrue(welcomeMessage.isDisplayed()); //pass
        //  softAssert.assertEquals(3,5); // ornek 3 esit mi 5'e //fail
        //softAssert te sona assert all yazmawsak hep pass verir
        //3.adim asserAll
        // softAssert.assertAll();  ///asil dogrulamayi yapip bize raporlar.kac tane pass kac tane fail oldugunu
        //ONEMLI!!!! asserAll


        //soruya devam
        // Daha sonra farklı iddialar(assertions) kullanarak sayfaya doğru giriş yaptığınızı doğrulayın.
        WebElement userID = driver.findElement(By.className("navbar-text"));
        String actualID = userID.getText();
        String expectedID = "testtechproed@gmail.com";
        //  Assert.assertEquals(actualID,expectedID); //hard assert

        //SOftAssert //2.adim
        softAssert.assertEquals(actualID, expectedID);
        //3.adim
        softAssert.assertAll(); //sayfada bir kere kullanmak yeterli//gercek assertion u yapar
        // assertAll() yazilmazsa test fail olmasi gerektiginde de pass olur.

    }

    //soru-1--
    //dependsOnMethods
    // soru2---
    //Assertion
    //soru3-
    // Verification
    //soru4--
    // ikisi de if else statement gorevi gorur
    //soru5--
    //hardAssert fail gordugu zaman kirilir ve calismaz
    //softAssert tum metodlari sonuna kadar calistirir
    //soru6
    //Assert.assertTrue()
    // Assert.assertFalse()
    //Assert.assertEquals()
    //soru7--
    // SoftAssert soft=new SoftAssert();
    //softAssert.assertTrue();
    //softAssert.assertAll();


}





