package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class AmazonDropDown_Homework_day13 extends TestBase {
    //Amazon Dropdown - Homework
    // 1.)Tests packagenin altinda bir class olusturun: AmazonDropdown ***
    // 2.)https://www.amazon.com/ adresine gidin.
    // 3.)Dropdown elementini bulun
    //4.)-İlk seçilen seçeneği(firstSelectedOption)  konsolda yazdırın ve ilk secenegin
    // “All Departments” ile esit oldugunu dogrulayin.
    //5)-6.seçeneği(option) index kullanarak secin ve 6.seçeneğin “Books” oldugunu dogrulayin.
    // (Seçtikten sonra getFirstSelectedOption() metodunu kullanmanız gerekir)
    //6.Butun dropdown seçeneklerini konsolda yazdırın
    // 7.Dropdowndaki eleman sayisini konsolda yazdırın
    //8.“Electronics” ın dropdownda olup olmadığını kontrol edin.
    // “Electronics” dropdownda bulunuyorsa konsolda True yazdırın. Aksi takdirde False yazdırın.
//NOT: TestBase classini kullanalim. Dogrulama yaparken Assertion kullanalim.
// Test case’de verilen secenekler sizde farkli olabilir. Sizde gorunen seceneklere gore kodunuzu yazabilirsiniz


    @Test
    public void amazonDropDown() {
        // 2.)https://www.amazon.com/ adresine gidin.
        driver.get("https://www.amazon.com/");

        // 3.)Dropdown elementini bulun
        WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));

        //  4.)-İlk seçilen seçeneği(firstSelectedOption)  konsolda yazdırın ve ilk secenegin
        // “All Departments” ile esit oldugunu dogrulayin.
        Select optionsAmazon = new Select(dropDown);
        String firstOption = optionsAmazon.getFirstSelectedOption().getText();  //get text string verir
        System.out.println("ilk secilen secenek :" + firstOption);
        Assert.assertEquals(firstOption, "All Departments");
        //Assert.assertTrue(options.getFirstSelectedOption().getText().equals("All Departments"));  ///2.yol

        //  5)-6.seçeneği(option) index kullanarak secin ve 6.seçeneğin “Books” oldugunu dogrulayin.
        // (Seçtikten sonra getFirstSelectedOption() metodunu kullanmanız gerekir)

        optionsAmazon.selectByIndex(5);
        String altinciOption = optionsAmazon.getFirstSelectedOption().getText();
        System.out.println("6. option :" + altinciOption);
        Assert.assertEquals(altinciOption, "Books");

        //6.Butun dropdown seçeneklerini konsolda yazdırın
        List<WebElement> tumOptions = optionsAmazon.getOptions();
        for (WebElement element : tumOptions) {
            System.out.println(element.getText());
        }
        // 7.Dropdowndaki eleman sayisini konsolda yazdırın
        int elemanSayisi=tumOptions.size();
        System.out.println("Tum elemanlarin sayisi: " +elemanSayisi);

        //8.“Electronics” ın dropdownda olup olmadığını kontrol edin.
        // “Electronics” dropdownda bulunuyorsa konsolda True yazdırın. Aksi takdirde False yazdırın.

      //  List<String> allOptionsString=new ArrayList<String>();

        int count=0;
        for(WebElement w : tumOptions){
            if(w.getText().equals("Electronics")){
                count++;
          //   allOptionsString.add(w.getText());
            }
        }
        if(count>0){
            System.out.println("True");
        }else{
            System.out.println("False");
        }
      //  System.out.println(allOptionsString.contains("Electronics");
    }

    //yorum satirlari== 2.yol yani containsle bakmak icin listleri stringe cevirdik

    //hocanin cozumu:::
    // boolean flag = false;
    //        for(WebElement option : allOptions){
    //            if(option.getText().equals("Electronics")){
    //                flag = true;
    //                break;
    //            }
    //        }
    //        System.out.println(flag);


}

