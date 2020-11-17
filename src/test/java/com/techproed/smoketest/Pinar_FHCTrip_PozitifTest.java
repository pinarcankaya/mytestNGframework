package com.techproed.smoketest;

import com.aventstack.extentreports.ExtentTest;
import com.techproed.pages.Pinar_FHCTrip_Page;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBaseFinal;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Pinar_FHCTrip_PozitifTest extends TestBaseFinal {

    Pinar_FHCTrip_Page pinar_fhcTrip_page;


    public void setup() {
        extentTest = extentReports.createTest("FhcTrip Room Reservation Test", "Room Reservation Create ");
        extentTest.info("Url'ye git");
        Driver.getDriver().get(ConfigReader.getProperty("fhc_trip_url"));
        pinar_fhcTrip_page = new Pinar_FHCTrip_Page();
    }

    @Test
    public void createHotelReservation() {
        setup();
        extentTest.info("Gecerli Username Gonder");
        pinar_fhcTrip_page.userName.sendKeys(ConfigReader.getProperty("username2"));

        extentTest.info("Gecerli Password Gonder");
        pinar_fhcTrip_page.passWord.sendKeys(ConfigReader.getProperty("password2"));

        extentTest.info("Login Butonuna Tikla");
        pinar_fhcTrip_page.loginButon.click();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        WebElement hotelButon = wait.until(ExpectedConditions.visibilityOf(pinar_fhcTrip_page.hotelManagement));

        extentTest.info("Hotel management menusune  Tikla");
        pinar_fhcTrip_page.hotelManagement.click();
        extentTest.info("Room reservation menusune  tikla");
        pinar_fhcTrip_page.roomReservation.click();
        extentTest.info("Add Room Reservatinon Butonuna Tikla");
        pinar_fhcTrip_page.addRoomReservationButton.click();

        extentTest.info("ID User Menusunden  Secim Yap");
        Select idUserSelect = new Select(pinar_fhcTrip_page.idUser);
        idUserSelect.selectByVisibleText("manager2");

        extentTest.info("ID Hotel Room  menusunden  Secim Yap");
        Select idHotelRoom = new Select(pinar_fhcTrip_page.idHotelRoom);
        idHotelRoom.selectByVisibleText("Kral Dairesi");

        extentTest.info("Gecerli fiyat bilgisi gir");
        pinar_fhcTrip_page.price.sendKeys("500");
        extentTest.info("gecreli baslangic tarih gir");
        pinar_fhcTrip_page.dateStart.sendKeys("08/04/2020");
        extentTest.info("Gecerli bitis tarihi gir");
        pinar_fhcTrip_page.dateEnd.sendKeys("08/20/2020");
        extentTest.info("Yetiskin Sayisini Gir");
        pinar_fhcTrip_page.adultAmount.sendKeys("2");
        extentTest.info("Cocuk Sayisini gir");
        pinar_fhcTrip_page.childrenAmount.sendKeys("4");
        extentTest.info("Gecerli name ve surname gir");
        pinar_fhcTrip_page.nameSurname.sendKeys("Ali CAN");
        extentTest.info("Gecerli telefon bilgisi gir");
        pinar_fhcTrip_page.phone.sendKeys("00331234567");
        extentTest.info("Gecerli email adresi gir");
        pinar_fhcTrip_page.contactEmail.sendKeys("ali123@gmail.com");
        extentTest.info("Herhangi bir not gir");
        pinar_fhcTrip_page.notes.sendKeys("Deniz Manzarali");
        extentTest.info("Approved checkbox'a tikla");
        pinar_fhcTrip_page.approved.click();
        extentTest.info("Ispaid checkbox'a tikla");
        pinar_fhcTrip_page.isPaid.click();
        extentTest.info("save butonuna tikla");
        pinar_fhcTrip_page.saveButton.click();


        WebElement mesaj = wait.until(ExpectedConditions.visibilityOf(pinar_fhcTrip_page.successfulyMesaj));

        extentTest.info("Dogrulama yap");
        Assert.assertTrue(pinar_fhcTrip_page.successfulyMesaj.isDisplayed());
        extentTest.pass("Test pass oldu");
        extentTest.info("succes mesajini consolda yazdir");
        System.out.println(pinar_fhcTrip_page.successfulyMesaj.getText());


        extentTest.info("driver kapatildi");
        Driver.closeDriver();

    }

}
