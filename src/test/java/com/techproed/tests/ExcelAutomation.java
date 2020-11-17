package com.techproed.tests;

import com.techproed.pages.DataTablesExcel;
import com.techproed.utilities.Driver;
import com.techproed.utilities.ExcelUtil;
import org.omg.CORBA.WStringSeqHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class ExcelAutomation {

    DataTablesExcel dataTablesExcel=new DataTablesExcel();
    ExcelUtil excelUtil;
    List<Map<String,String>> testData;   ///birden fazla data gondermek icin list//key value yazmak icin de map kullandik

    @BeforeMethod
    public void getTestData(){
        excelUtil=new ExcelUtil("src\\test\\resources\\exceldata.xlsx","Sheet1");
        //excel util classindan getdatalist() methodunu,excelden data alabilmek icin cagiriyorz
        testData=excelUtil.getDataList();
    }

    @Test
    public void excelDataAutomation() throws InterruptedException {
        for (Map<String,String> data: testData) {
            Driver.getDriver().get("https://editor.datatables.net/");
            dataTablesExcel.newButton.click();
            dataTablesExcel.firstname.sendKeys(data.get("First name"));
            Thread.sleep(1000);
            dataTablesExcel.lastname.sendKeys(data.get("Last name"));
            dataTablesExcel.position.sendKeys(data.get("position"));
            dataTablesExcel.office.sendKeys(data.get("office"));
            dataTablesExcel.extension.sendKeys(data.get("extension"));
          //  dataTablesExcel.startDate.sendKeys(data.get("Start date"));
            dataTablesExcel.startDate.click();
            dataTablesExcel.day.click();
            dataTablesExcel.salary.sendKeys(data.get("salary"));
            dataTablesExcel.createButton.click();
            dataTablesExcel.searchBox.sendKeys(data.get("First name"));
            Thread.sleep(1000);
            Assert.assertTrue(dataTablesExcel.nameField.getText().contains(data.get("First name")));

            if(data.get("First name").equals("Ali")){
                break;
            }

        }

    }
}
