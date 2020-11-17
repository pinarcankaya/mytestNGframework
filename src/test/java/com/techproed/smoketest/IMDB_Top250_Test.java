package com.techproed.smoketest;

import com.techproed.pages.IMDB_Top250_Page;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class IMDB_Top250_Test {

    IMDB_Top250_Page imdb_top250_page;

    public void setup(){
        Driver.getDriver().get(ConfigReader.getProperty("imdb_url"));
       imdb_top250_page=new IMDB_Top250_Page();
    }
    @Test
    public void imdbSignInPage(){
        setup();
        int film=imdb_top250_page.fimler.size();
        System.out.println(film);
        for (WebElement w:imdb_top250_page.fimler) {
            System.out.println(w.getText());
        }
    }
}
