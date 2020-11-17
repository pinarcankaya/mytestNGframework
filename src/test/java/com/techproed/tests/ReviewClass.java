package com.techproed.tests;

import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ReviewClass {
    //https://www.airbnb.co.in/ adresine git
    //Sayfa basligini(title) al ve konsolda yazdir.
    //Sayfanin mevcut url’ ini (current url) al
    //Sayfanin source(page source) ‘u al.


    @Test
    public void airbnbTest() {

        Driver.getDriver().get("https://www.airbnb.co.in/");
        String title = Driver.getDriver().getTitle();
        System.out.println("Page title" + title);
        String currentUrl = Driver.getDriver().getCurrentUrl();
        System.out.println("Cureent url" + currentUrl);
        String pageSource = Driver.getDriver().getPageSource();
        System.out.println("Page source" + pageSource);
    }

    //http://ebay.com adresine git
    //Search box’a “Selenium” yaz
    //Search butonuna tikla
    //Selenium icin kac sonuc var kontrol et ve konsolda yazdir.
    //Sayfa basligini(title) al ve konsolda yazdir.
    //Sayfanin mevcut url’ini (current url) al
    //Sayfanin source(page source) ‘u al.
    @Test
    public void ebayTest() {
        WebElement searcbox = Driver.getDriver().findElement(By.id("gh-ac"));
        searcbox.sendKeys("Selenium");
        WebElement search = Driver.getDriver().findElement(By.id("gh-btn"));
        search.click();
        WebElement results = Driver.getDriver().findElement(By.className("srp-controls__count-heading"));
        //sadece sayiyi almak icin ==>(//span[@class='BOLD'])[15]
        System.out.println(results.getText());

        String title = Driver.getDriver().getTitle();
        System.out.println(title);

        String currentUrl=Driver.getDriver().getCurrentUrl();
        System.out.println(currentUrl);

        String source=Driver.getDriver().getPageSource();
        System.out.println(source);
    }
}