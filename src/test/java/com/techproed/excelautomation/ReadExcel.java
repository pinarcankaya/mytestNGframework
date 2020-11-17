package com.techproed.excelautomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadExcel {

    @Test
    public void readExcelFile() throws IOException { //excel dosyayi oku
        //data okuyacagimiz dosyanin path'ini yazalim
        String path = "C:\\Users\\pinar\\Downloads\\ULKELER.xlsx";
        //dosyayi acalim
        FileInputStream fileInputStream = new FileInputStream(path);
        //fileinputStream kullanarak workbook u acalim
        Workbook workbook = WorkbookFactory.create(fileInputStream);//fileinputStrem'i kullabarak work book u aciyoruz
        //1.worksheet" gidelim(index 0'dan basliyor
        Sheet sheet = workbook.getSheetAt(0); //ilk sheetin indexi 0'dir
        //1.satira(row) gidelim..index 0'dan baslar
        Row row = sheet.getRow(0);
        //artik test datalarini(cell) okuyabiliriz
        Cell cell = row.getCell(0);
        System.out.println("birinci CELL'deki data : " + cell);
        System.out.println("2. CELL'deki data: " + row.getCell(1));

        //2. row'daki 1.cell'i konsolda yazdiralim

        Row row2 = sheet.getRow(1);
        Cell cell1=row2.getCell(0);
        System.out.println(cell1);


        //2.yol chain methodu ///zincirleme methoz
        System.out.println(workbook.getSheetAt(0).getRow(1).getCell(0));
        //chain methodu
        String row2cell1 = workbook.getSheetAt(0).getRow(1).getCell(0).toString();
        System.out.println(row2cell1);

        //son row numarasini alalim//(index 0 dan baslar)
        int rowSayisi=sheet.getLastRowNum();
        System.out.println(rowSayisi);

        //kullanilan(icinde veri olan  satirlarin sayisini nasol aliriz(index 1 den baslar)
       int numberOfphsicalRows= sheet.getPhysicalNumberOfRows();//fiziksel olarak kullanilan no sayisi)
        //kac satir kullaniliyorsa o kadarini aliyor
        System.out.println(numberOfphsicalRows); //12


        Map<String,String> ulkeler=new HashMap<>();
        int ulkeSutunu=0;
        int baskentSutunu=1;
        for(int rowNum = 1 ; rowNum<=rowSayisi; rowNum++){
            String ulke=sheet.getRow(rowNum).getCell(ulkeSutunu).toString();
            System.out.print(ulke);
            String baskent=sheet.getRow(rowNum).getCell(baskentSutunu).toString();
            System.out.println(baskent);

            //hashmap olarak yazdirmak icin
            ulkeler.put(ulke,baskent);
        }

        System.out.println(ulkeler );

    }
}