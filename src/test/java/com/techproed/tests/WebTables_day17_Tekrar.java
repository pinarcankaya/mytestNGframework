package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTables_day17_Tekrar  extends TestBase {

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

    //Test  //diger metodlardan cagirmak icin kapattik
    public void login(){
        driver.get("http://www.fhctrip.com/admin/HotelRoomAdmin");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!");
        driver.findElement(By.xpath("//button")).click();
    }
    @Test
    public void table(){
        login();
        //Tüm table body’sinin boyutunu(size) bulun.
        //Table’daki başlıkları(headers) konsolda yazdırın.

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement tbody=driver.findElement(By.xpath("//tbody"));  //once tbody'i locate ettik
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println(tbody.getText());  //tbody deki tum basliklar haric satirdaki listeleri consola yazdir

        //table tbody den sayfada bir tane var
        List<WebElement> table=driver.findElements(By.xpath("//tbody//td")); //listlerde "S" cogul ekine dikkat
        System.out.println("Table Body Sayisi: " +table.size());

        List<WebElement> allHeader=driver.findElements(By.xpath("//th")); // bu ilk basligi veriyor //th[2]==ikinci basligi veriyor
        for(WebElement header: allHeader){  //for ile tum basliklari icine attik
            System.out.println(header.getText()); //get text ile tum basliklari yazdirdik
        }

    }
    @Test()
    public void printRows(){
        login();
        //table body’sinde bulunan toplam satir(row) sayısını bulun.
        //Table body’sinde bulunan satirlari(rows)  konsolda yazdırın.

        //tr=row=satir
        List<WebElement> rowSayisi=driver.findElements(By.xpath("//tbody//tr"));
        System.out.println(rowSayisi.size());
        for(WebElement row:rowSayisi){
            System.out.println(row.getText());
        }
        //4.satirdaki(row) elementleri konsolda yazdırın.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

       //  WebElement row4=driver.findElement(By.xpath("//tbody//tr[4]"));
       //  System.out.println("4.satir 1.yol: " + row4.getText()); //gettext

        List<WebElement> tbody=driver.findElements(By.xpath("//tr[4]//td"));
        for(WebElement satir:tbody){
            System.out.println("4.satir 2.yol : " +satir.getText());
        }
    }
    @Test
    public void printCells() {
        login();
        //table body’sinde bulunan toplam hücre(cell) sayısını bulun.
        //Table body’sinde bulunan hücreleri(cells)  konsolda yazdırın.


        //System.out.println("Tabloda toplam "+ driver.findElements(By.xpath("//tbody//td")).size()+ " tane cell(hucre) vardir.");
       //2.yol
        List<WebElement> hucreSayisi=driver.findElements(By.xpath("//tbody//td"));
        System.out.println(hucreSayisi.size());
        for (WebElement hucre:hucreSayisi){
            System.out.println("hucre adi: " + hucre.getText());
        }
    }
    @Test
    public void   printColumns()  throws InterruptedException{
        login();
        //table body’sinde bulunan toplam sutun(column) sayısını bulun.
        //Table body’sinde bulunan sutunlari(column)   konsolda yazdırın.
        //5.column daki elementleri  konsolda yazdırın.
        Thread.sleep(10);
        System.out.println("tabloda toplam :" + driver.findElements(By.xpath("//tr[3]//td")).size() +" tane sutun vardir");
    //tr da td den kac tane var diye dusunuyoruz-----sadece th yazarak da bulunabir//bir satirda kac data varsa o kadar sutun vardir
        List<WebElement> allColumn = driver.findElements(By.xpath("//th"));
        for (WebElement column : allColumn) {
            System.out.println(column.getText());
        }

    }
    ///*************************************************************************
    //WebTables class’ini kullanin.
    //Bir metod oluşturun : printData(int row, int column);
    //Satır(row) ve sütun(column) numarasını girdiğinizde, printData metodu bu hücredeki(cell) veriyi yazdırmalıdır.
    //Baska bir metod daha oluşturun: printDataTest();
    //Ve bu metodu printData() methodunu cagirmak icin kullanin.
    //Örnek: printData (3,5); => 3. satır, 5. Sütundaki veriyi yazdırmalıdır
    public void printData(int row, int column){  //kodlari buraya yazacaz

        //tbody//tr[8]//td[3] yapiyordi=uk normalde
        String xpath="//tbody//tr[" +row +" ]//td[" +column +"]";
        //elementleri xpat kullanarak bulduk
        WebElement data=driver.findElement(By.xpath(xpath));
            //datalari yazdiralim
        System.out.println(data.getText());


    }
    @Test
    public void printDataTest(){ //ustteki methoddan cagiracaz
        login();
        printData(8,3); //8.satir 3.sutun //1234
        printData(5,2);     //kalem
        printData(7,7);     //DOuble
    }





}
