package com.techproed.excelautomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelMethodTekrar {

    String path = "C:\\Users\\pinar\\Downloads\\ULKELER.xlsx";
    FileInputStream fileInputStream ;
    Workbook workbook;
    Sheet sheet;
    Row row;
    Cell cell;

    public void excelVeri() throws IOException {
        fileInputStream = new FileInputStream(path);
        workbook = WorkbookFactory.create(fileInputStream);
        sheet =  workbook.getSheetAt(0);
        row = sheet.getRow(2);
        cell = row.getCell(3);
    }

    public void getHucre(int indexRow, int indexCell)  {
        System.out.println(sheet.getRow(indexRow).getCell(indexCell));
    }

    @Test
    public void testMethod() throws IOException {
        excelVeri();
        getHucre(2,1);
    }

}