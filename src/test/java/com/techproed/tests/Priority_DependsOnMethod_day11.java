package com.techproed.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class Priority_DependsOnMethod_day11 {
   //// ilk once [priority] vermedigimiz classlari alfabetik olarak siralar.
    //// Alfabetik siralamadan sonra bizim belirtigimiz siraya devam eder.
    //// sayilar sirayla olmak zorunda degil (1,2,3...) her zaman kucukten buyuge dogru siralar. {-4, 0, 7, 20...}
    //// ayni sayi verildiginde de alfabetik sirada hangisi ondeyse o ilk yazdirilir.
    //// Kucuk harfle baslayan 'priority' secilmeli.

   // @Ignore priority olunca calismiyor
    @Test//(priority = 1)
    public void login() {

        System.out.println("Bu method login");
    }
///oncelik numarasi verilmezse once onlar calisir alfabetik olarak. sonra numarali olanlar sirayla calisir
    @Test(priority = 2,dependsOnMethods = "login") //sadece burdan run etsek bile bagli oldugu logini de calistirir
    //ayni no verilirse alfabetik siraya koyar

    public void homePackage() {

        System.out.println("Bu method homePackage");
    }
    // dependsOnMethods = "hongi Method'a bagli calismasini istedigimiz MethodIsmi" yazilir.
// bagladigimiz method'i @Ignore yaparsak ikisi de calismamis olacak.
// Bagli olan Methodu calistirdigimizda ise Bagli olan Method ve Baglanan Method ikisi de calisir.

    @Test(priority = 3)//5 //9 vs de denilebilir yine sayilari kensi siraya koyar //ardisik olma sarti yok
    public void search()
    {
        System.out.println("Bu method search");
    }

    @Test(priority = 4) ///(2-4) de yazilabilir -2 olarak siraya koyar//negatif sayi da verilebilir yani
    public void result() {

        System.out.println("Bu method result");
    }

}