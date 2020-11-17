package com.techproed.smoketest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.techproed.pages.Pinar_FHCTrip_Page;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBaseFinal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Pinar_FHCTrip_NegatifTest extends TestBaseFinal {
    Pinar_FHCTrip_Page pinar_fhcTrip_page;
    Actions actions = new Actions(Driver.getDriver());

    public void setup() {
        extentTest = extentReports.createTest("FhcTrip Room Reservation Test", "Room Reservation Create ");
        extentTest.info("Url'ye git");
        Driver.getDriver().get(ConfigReader.getProperty("fhc_trip_url"));
        pinar_fhcTrip_page = new Pinar_FHCTrip_Page();

        extentTest.info("Gecerli Username Gonder");
        pinar_fhcTrip_page.userName.sendKeys(ConfigReader.getProperty("username2"));
        extentTest.info("Gecerli Password Gonder");
        pinar_fhcTrip_page.passWord.sendKeys(ConfigReader.getProperty("password2"));
        extentTest.info("Login Butonuna Tikla");
        pinar_fhcTrip_page.loginButon.click();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        WebElement hotelManagementMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='Hotel Management']")));

        extentTest.info("Hotel management menusune  Tikla");
        pinar_fhcTrip_page.hotelManagement.click();
        extentTest.info("Room reservation menusune  tikla");
        pinar_fhcTrip_page.roomReservation.click();
        extentTest.info("Add Room Reservatinon Butonuna Tikla");
        pinar_fhcTrip_page.addRoomReservationButton.click();


    }

    @Test(priority = 1)
    public void eksikIDUserMenu() {
        setup();

        extentTest.info("ID Hotel Room  menusunden  Secim Yap");
        Select hotelRoomMenu = new Select(pinar_fhcTrip_page.idHotelRoom);
        hotelRoomMenu.selectByVisibleText("Kral Dairesi");

        extentTest.info("Gecerli fiyat bilgisi gir");
        pinar_fhcTrip_page.price.sendKeys("500");
        extentTest.info("gecreli baslangic tarih gir");
        pinar_fhcTrip_page.dateStart.sendKeys("20/11/2020");
        extentTest.info("Gecerli bitis tarihi gir");
        pinar_fhcTrip_page.dateEnd.sendKeys("30/11/202");
        extentTest.info("Yetiskin Sayisini Gir");
        pinar_fhcTrip_page.adultAmount.sendKeys("2");
        extentTest.info("Cocuk Sayisini gir");
        pinar_fhcTrip_page.childrenAmount.sendKeys("4");
        extentTest.info("Gecerli name ev surname gir");
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

        extentTest.info("Dogrulama yap");
        Assert.assertTrue(pinar_fhcTrip_page.selectMenuErrorMesaj.isDisplayed());
        extentTest.info("Test pass oldu");
        extentTest.info("Bos birakilan alani consolda yazdir");
        System.out.println("Zorunlu ALan :" + pinar_fhcTrip_page.selectMenuErrorMesaj.getText());

        extentTest.info("sayfadan cikis yap");
        actions.moveToElement(pinar_fhcTrip_page.mikeButton).perform();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(pinar_fhcTrip_page.logoutButton));
        pinar_fhcTrip_page.logoutButton.click();
    }


    @Test(priority = 2)
    public void eksikDateStartTextBox() {
        setup();

        extentTest.info("ID User Menusunden  Secim Yap");
        Select selectUserMenu = new Select(pinar_fhcTrip_page.idUser);
        selectUserMenu.selectByVisibleText("manager2");

        extentTest.info("ID Hotel Room  menusunden  Secim Yap");
        Select hotelRoomMenu = new Select(pinar_fhcTrip_page.idHotelRoom);
        hotelRoomMenu.selectByVisibleText("Kral Dairesi");

        extentTest.info("Gecerli fiyat bilgisi gir");
        pinar_fhcTrip_page.price.sendKeys("500");
        extentTest.info("Gecerli bitis tarihi gir");
        pinar_fhcTrip_page.dateEnd.sendKeys("30/11/2020");
        extentTest.info("Yetiskin sayisini gir");
        pinar_fhcTrip_page.adultAmount.sendKeys("2");
        extentTest.info("Cocuk sayisini gir");
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
        extentTest.info("IsPaid checkbox'a tikla");
        pinar_fhcTrip_page.isPaid.click();
        extentTest.info("Save butonuna tikla");
        pinar_fhcTrip_page.saveButton.click();

        extentTest.info("Dogrulama yap");
        Assert.assertTrue(pinar_fhcTrip_page.dateStartMenuError.isDisplayed());
        extentTest.info("Test pass oldu");
        extentTest.info("Bos birakilan alani consolda yazdir");
        System.out.println("Zorunlu Alan: " + pinar_fhcTrip_page.dateStartMenuError.getText());

        extentTest.info("Dogrulama yap");
        Assert.assertTrue(pinar_fhcTrip_page.dateEndMenuError.isDisplayed());
        extentTest.info("Test pass oldu");
        extentTest.info("Bos birakilan alani consolda yazdir");
        System.out.println("Zorunlu Alan: " + pinar_fhcTrip_page.dateEndMenuError.getText());

    }

    //GORUSLERIM
    /*1-Notes bolumune not girmek zorunlu olmamali
        phone ve email tercih edilebilir olmali ikisi de zorunlu olmamali
     zorunlu alanlar bos olarak save tiklandiginda hata mesaji alert olarak cikabilirdi succes gibi
     */
}
