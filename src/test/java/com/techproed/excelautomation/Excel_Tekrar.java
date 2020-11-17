package com.techproed.excelautomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Excel_Tekrar {

    @Test
    public void excel() throws IOException {
        String path="C:\\Users\\pinar\\Downloads\\ULKELER.xlsx";
        FileInputStream fileInputStream=new FileInputStream(path);
        Workbook workbook= WorkbookFactory.create(fileInputStream);
        Sheet sheet=workbook.getSheetAt(0);
        Row row2=sheet.getRow(2);
        Cell cell3=row2.getCell(2);
        System.out.println("4.celldeki data : " + cell3);

    }


}
