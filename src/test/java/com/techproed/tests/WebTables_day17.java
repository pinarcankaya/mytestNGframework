package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTables_day17 extends TestBase {
    //Bir class oluşturun : WebTables
    //login() metodun oluşturun ve oturum açın.
    //http://www.fhctrip.com/admin/HotelRoomAdmin
    //Username : manager2
    //Password : Man1ager2!
    //table() metodu oluşturun
    //Tüm table body’sinin boyutunu(size) bulun.
    //Table’daki başlıkları(headers) konsolda yazdırın.
    //printRows() metodu oluşturun
    //table body’sinde bulunan toplam satir(row) sayısını bulun.
    //Table body’sinde bulunan satirlari(rows)  konsolda yazdırın.
    //4.satirdaki(row) elementleri konsolda yazdırın.
    
    //printCells() metodu oluşturun
    //table body’sinde bulunan toplam hücre(cell) sayısını bulun.
    //Table body’sinde bulunan hücreleri(cells)  konsolda yazdırın.
    //printColumns() metodu oluşturun
    //table body’sinde bulunan toplam sutun(column) sayısını bulun.
    //Table body’sinde bulunan sutunlari(column)   konsolda yazdırın.
    //5.column daki elementleri  konsolda yazdırın.

   // @Test burdan testi silersek asagidaki methodun icinde cagirabiliriz
    public void login(){
        driver.get("http://www.fhctrip.com/admin/HotelRoomAdmin");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!");
        driver.findElement(By.xpath("//button")).click();

    }
    @Test
    public void table(){
        login();  //
        //Tüm table body’sinin boyutunu(size) bulun.
        //Table’daki başlıkları(headers) konsolda yazdırın.

        //gerek olursa bekleme koymayi unutma
        WebElement tbody=driver.findElement(By.xpath("//tbody")); //tbody baslik haric diger verileri verir
        System.out.println(tbody.getText());

        //tum table body sinin boyutunu(size) bulun kac tane hucre(cell) var
        List<WebElement> table=driver.findElements(By.xpath("//tbody//td"));
        System.out.println("table body size: " + table.size()); //bir tane table body var bir sayfada

        //Table’daki başlıkları(headers) konsolda yazdırın.
        //list oldugu icin findElementS olmasina dikkat!!!
        List<WebElement> tumBasliklar=driver.findElements(By.tagName("th"));  // sayfada bir tane baslik satiru oldugu icin tag name kullandik
        for(WebElement baslik: tumBasliklar){  //allHeader(tum basliklar
            System.out.println(baslik.getText());
        }

    }
    @Test
    public void printRows(){
        login();  //bekleme koyulabilir fail cikarsa unutma
        //    //table body’sinde bulunan toplam satir(row) sayısını bulun.
        //    //Table body’sinde bulunan satirlari(rows)  konsolda yazdırın.
        //    //4.satirdaki(row) elementleri konsolda yazdırın.

         //tr satirlar  demek ama tbody icindeki satirlari istiyoruz
        System.out.println("tabloda toplam " +driver.findElements(By.xpath("//tbody//tr")).size() +" tane satir(row) vardir");

        List<WebElement> butunSatirlar=driver.findElements(By.xpath("//tbody//tr"));  //allRows=butun satirlar demek)
        for(WebElement satir:butunSatirlar){
            System.out.println(satir.getText());
        }

        //    //4.satirdaki(row) elementleri konsolda yazdırın.

        //WebElement tbody4 = driver.findElement(By.xpath("//tbody//tr[4]"));
        //System.out.println("4. satir 2. yontem: " + tbody4.getText());

        //list ile yapilis

        List<WebElement> elementsRow4=driver.findElements(By.xpath("//tr[4]//td"));  ///tbody//tr[4]//td
        for(WebElement element: elementsRow4){
            System.out.print("4.satir: "+ element.getText());
        }
    }



}
