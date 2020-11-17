package com.techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverCross {

    private DriverCross() {
    }
    private static WebDriver driver;
    //test base cross'dan  browser'i cagiriyorum
    public static WebDriver getDriver(String browser) { //test basecross tan cagiriyorz.xml den test base cross a ordan da buraya cagiriyoz
        if (driver == null) {
            //eger xml'deki  browser null degilse , xml file'daki browser kullanilir
            //eger xml'deki  browser null ise, Configuration.properties File'daki browser kullanilir
            browser = browser == null ? ConfigReader.getProperty("browser") : browser;
            //test base==atama
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver=new InternetExplorerDriver();
                    break;
                case "safari":
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driver=new SafariDriver();
                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
            }
        }
        return driver;
    }
    public static WebDriver getDriver() {
        return getDriver(null);
    }
    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
