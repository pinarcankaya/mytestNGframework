package com.techproed.geneltekrar;

import com.techproed.pages.FHCLoginPage;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class FHCRezervasyon_Test_Tekrar  extends TestBase {

    @Test
    public void fhcRezervasyonTest(){
        driver.get("http://www.fhctrip.com/admin/RoomReservationAdmin/Create");

        //FHCLoginPage de bulunan login2() metodunu cagirmak icin obje olusturuyoruz.
        FHCLoginPage  fhcloginpage=new FHCLoginPage(driver);
        fhcloginpage.login2();
        FHCRezervasyonTest_Page_Tekrar fhcrezervasyonPage=new FHCRezervasyonTest_Page_Tekrar(driver);

//
//        Select idUserSelect = new Select(fhcRezervasyonPage.idUser);   //dropdown(idUser)
//        idUserSelect.selectByIndex(1);
//        Select idHotelRoomSelect = new Select(fhcRezervasyonPage.idHotelRoom);  //dropdown(idHotelRoom)
//        idHotelRoomSelect.selectByIndex(5);

    }
}
