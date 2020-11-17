package com.techproed.tests;

import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JSExecutor {

    @Test
    public void javascripExecutorTest() {
        Driver.getDriver().get(ConfigReader.getProperty("fhc_login_url"));
        WebElement loginButton = Driver.getDriver().findElement(By.id("btnSubmit"));
        // clickElementByJS(loginButton);
        // WebElement createButton=Driver.getDriver().findElement(By.xpath("//span[@class='btn btn-primary py-3 px-5']"));
        //clickElementByJS(createButton);
        // System.out.println(getTitleBYJS());
        //scrollDownByJS();

        // WebElement instagram = Driver.getDriver().findElement(By.xpath("//*[.='Instagram']"));
        // scrollInToViewJS(instagram);  //instagram yazisina kadar kay demek

        //WebElement image = Driver.getDriver().findElement(By.xpath("(//a[@class='blog-img mr-4'])[4]"));
       // scrollInToViewJS(image);  //backgroud rengi degisecek

        //flash(loginButton);  //renk degistirme

        genereteAlert("Sayfada bir bug bulundu");
    }

    //Bu method bir parametre alir(Webelement element)
    //elementi methodun icine yazdigimizda js bu elemente tiklar
    public void clickElementByJS(WebElement element) {
        JavascriptExecutor jsExecutor = ((JavascriptExecutor) Driver.getDriver());  //cast etmek gerek//yani driveri kontroletmesine izin verecez.yani drivedrden once JAVAexec. kulnaacaz
        jsExecutor.executeScript("arguments[0].click();", element);
        //herhangi bir elemente tiklamak icin bunu hep kullanbilirz//kopyala yapistir
    }


    //sayfa basligini JS ile alma metodu
    public String getTitleBYJS() {
        JavascriptExecutor jsExecutor = ((JavascriptExecutor) Driver.getDriver());
        String title = jsExecutor.executeScript("return document.title;").toString();
        return title;
    }

    //sayfada asagi kaydrima//sayfanin en sonuna kadar gelir
    public void scrollDownByJS() {
        JavascriptExecutor jsExecuter = ((JavascriptExecutor) Driver.getDriver());
        jsExecuter.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    //bu method bir parametre alir
    //JS ile bir elemnte kadar kaydirma (scrollDown)
    public void scrollInToViewJS(WebElement element) {
        JavascriptExecutor jsExecuter = ((JavascriptExecutor) Driver.getDriver());
        jsExecuter.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    //secilen elementin backgorud rengini degistirmek icin
    public void flash(WebElement element) {
        String bgColor = element.getCssValue("backgroundcolor");
        for (int i = 0; i < 10; i++) {
            changeColor("rgb(0,200,0", element); //buraya 200 yerine farkli renk kodu da girilebilir
            changeColor(bgColor, element);
        }
    }

    public void changeColor(String color, WebElement element) {
        JavascriptExecutor javascriptExecutor = ((JavascriptExecutor) Driver.getDriver());
        javascriptExecutor.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    //Gerektiginde bir uyari(alert) olusturma
    public  void genereteAlert(String message){
        JavascriptExecutor javascriptExecutor = ((JavascriptExecutor) Driver.getDriver());
        javascriptExecutor.executeScript(("alert('"+ message +"')"));
    }
}