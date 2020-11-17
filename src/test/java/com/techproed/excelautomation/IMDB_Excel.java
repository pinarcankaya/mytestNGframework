package com.techproed.excelautomation;

import com.techproed.pages.IMDB_Top250_Page;
import com.techproed.smoketest.IMDB_Top250_Test;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IMDB_Excel {

    @Test
    public void imdb_film_list() throws IOException {
        String path=".\\src\\test\\resources\\ImdbFilm.xlsx";  //excel dosyasinin yolu
        FileInputStream fileInputStream = new FileInputStream(path);       //dosyayi ac diyoruz
        Workbook workbook= WorkbookFactory.create(fileInputStream);        //excel dosyasini oku
        Sheet sheet=workbook.getSheetAt(0);              //excel 1.sayfaya git
        Row row=sheet.getRow(0);                //1.sayfadaki 1.satira git
        Cell cell = row.getCell(0);

        FileOutputStream fileOutputStream=new FileOutputStream(path);
        sheet.getRow(0).createCell(0).setCellValue("FILM SIRASI");
        sheet.getRow(0).createCell(1).setCellValue("FILM ADI");
        sheet.getRow(0).createCell(2).setCellValue("FILM TARIHI");

        System.out.println(sheet.getRow(0).getCell(0));

        IMDB_Top250_Page imdb_top250_page=new IMDB_Top250_Page();

        Driver.getDriver().get(ConfigReader.getProperty("imdb_url"));
        System.out.println(imdb_top250_page.fimler.size());



        List<WebElement> imdbfilmler=new ArrayList<>();
        imdbfilmler.addAll(imdb_top250_page.fimler);
        System.out.println(imdbfilmler.size());



        workbook.write(fileOutputStream);
        workbook.close();
        fileOutputStream.close();
        fileInputStream.close();



    }


}
