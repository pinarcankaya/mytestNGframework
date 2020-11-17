package com.techproed.excelautomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {

    @Test
    public void wroteExcel() throws IOException {
        String path=".\\src\\test\\resources\\ULKELER.xlsx";
        //file 'i acalim
        FileInputStream file=new FileInputStream(path);
        //workbook'u acalim
        Workbook workbook= WorkbookFactory.create(file);
        Sheet sheet=workbook.getSheetAt(0); //1.sheet'e git  //1.sayfa
        Row row=sheet.getRow(0); //1.row'a git (basliklar row'u)

        FileOutputStream fileOutputStream=new FileOutputStream(path);
        Cell cell4=row.createCell(3);
        cell4.setCellValue("NUFUS");

        Cell cell5=row.createCell(4);
        cell5.setCellValue("YUZOLCUMU");
        row.removeCell(cell5);  //cell5 i silmek icin

        workbook.getSheetAt(0).getRow(1).createCell(3).setCellValue("83000000"); //2.satir icin
        workbook.getSheetAt(0).getRow(2).createCell(3).setCellValue("10000000");  //3.satir
        workbook.getSheetAt(0).getRow(3).createCell(3).setCellValue("83000000");    //4.satir

        workbook.write(fileOutputStream); //cell e veri yazar ve kayit eder.en sonda bulunmali

        fileOutputStream.close();
        file.close();
        workbook.close();
    }
}
