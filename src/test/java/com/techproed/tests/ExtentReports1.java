package com.techproed.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.techproed.pages.GlbHomePage_CategoryDropdown;
import com.techproed.pages.GlbSignUpPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExtentReports1 {

    public ExtentReports extentReports; //raporlamaya baslamak icin buna ihtiyac var//raporu kapatmak(flush) icin kullaniyoruz
   //raporu hem acmak hem kapatmak icin
    public ExtentHtmlReporter extentHtmlReporter;//raporlari configre etmeye yapilandirmaya yardmci olur.html raporlarini create eder
    public ExtentTest extentTest;///Aciklama(logs=gunluk) eklemek icin,test adimlarini belirlemek icin kullanilir

    GlbSignUpPage glbSignUpPage=new GlbSignUpPage();
    GlbHomePage_CategoryDropdown glbHomePage=new GlbHomePage_CategoryDropdown();

    @BeforeTest
    public void setup(){
        //reporter'i baslatalim konumunu ayarlayalim
        //klasor adi=reports, dosya adi=extentreport.html
        //bizim verdigimiz path a gore bir dosya olusturacak
        extentHtmlReporter=new ExtentHtmlReporter("./reports/extentreport.html"); //obje olustuyorz//nerde istiyorsak
        //extentreporter'la bazi yapilandirmalar yapalim
        extentHtmlReporter.config().setReportName("GLB trader Report");
        extentHtmlReporter.config().setTheme(Theme.STANDARD);  //rapor rengi
        extentHtmlReporter.config().setDocumentTitle("GLB SignUp Report");
        extentHtmlReporter.config().setEncoding("UTF-8");  //klavye dili

        //ExtentReport'u create edelim
        extentReports=new ExtentReports();
        extentReports.attachReporter(extentHtmlReporter);

        //daha fazla aciklama ekleyebilriz//sistem bilgisi anlaminda
        extentReports.setSystemInfo("automation engineer", "Pinar");//bu raporu hangi tester gonderdi "pinar"
        extentReports.setSystemInfo("Browser","chrome");//hangi tarayiciyi kullandim onu yaziyorm


    }
        @AfterTest
        public void endReport(){  //test sonunda bu raporlamayi kapatmak icin kullanilir
        extentReports.flush();
        }



        @Test
        public void glbSignUp(){

        extentTest=extentReports.createTest("GLB SignUp Test");
        extentTest.info("URL'e git");
        Driver.getDriver().get(ConfigReader.getProperty("glb_url"));
        extentTest.info("join now linkine tikla");
        glbHomePage.joinNowLink.click();

        extentTest.info("email gonder");
        glbSignUpPage.emailTextBox.sendKeys(ConfigReader.getProperty("test_email"));

        extentTest.info("username gonder");
        glbSignUpPage.enterName.sendKeys(ConfigReader.getProperty("test_username"));

        extentTest.info("telefon numarasi gonder");
        glbSignUpPage.mobile.sendKeys(ConfigReader.getProperty("test_phone"));

        extentTest.info("password gonder");
        glbSignUpPage.password.sendKeys(ConfigReader.getProperty("test_password"));

        extentTest.info("password gonder");
        glbSignUpPage.rePassword.sendKeys(ConfigReader.getProperty("test_password"));

        extentTest.info("sign up'a tikla");
        glbSignUpPage.signUpButton.click();

        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(glbSignUpPage.succes_mesaj)).isDisplayed());


        System.out.println("Succes Mesaj: " + glbSignUpPage.succes_mesaj.getText());
        //test fail olacak cunku actuel test ile expected ayni degil unlem !! fazla birinde
            extentTest.pass("Passed : Test Basariyla Tamamlandi");

        Driver.closeDriver();
        extentTest.pass("Driver Basariyla Kapatildi");
    }
}