package com.techproed.tests;

import org.testng.annotations.*;

public class TestNGAnnotations_day10 {
    @Ignore // sadace @Test'ler icin calisiyor suan before methodu etkilemiyor
    //test methodlarini gormezden gelir @Test annotation yoksa calismaz
    @BeforeMethod //istedigumiz yere yazabiliriz ama before lar icin basa yazmak after lar icin sona yazmak uygundur
   //beforemethod her test metodundan once calisir
    public void beforeMethod() {
        System.out.println("====Before Method====");

    }
    @BeforeClass  //sadece en basta yazili cikar///sadece class'in basinda calisir 1 defa.
    public void beforeClass(){
        System.out.println("===Before Class===");
    }

    @BeforeTest //
    public void beforeTest(){
        System.out.println("===Before Test====");
    }


    @Test   //dependency eksik olursa kirmizi cizer
    public void Test1(){

        System.out.println("Bu Test1 Metodudur");
    }
    @Test
    public void Test2(){
        System.out.println("Bu Test2 Metodudur");
    }
    @Ignore  //gormek istemedigimiz zaman
    @Test
    public void Test3(){
        System.out.println("Bu Test3 Metodudur");
    }
    @AfterMethod //her test methodundan sonra calisir(@Test//bunlardan sonra calisacak
    public void afterMethod(){
        System.out.println("=====After method====");
    }
    @AfterClass//clasin sonunda sadece 1 defa calisir
    public void afterClass(){
        System.out.println("====After Class");
    }
    @AfterTest //sadece bir defa calisir
    public void afterTest(){
        System.out.println("====After TEst====");
    }
    //suit>test>class>grup>method diye kucukluk siralamsi var
    //suit en buyuk



    //1--Dropdow ile 3 farkli yol var:
    //selectByindex()
    //selectByValue()
    //selectVisbleText()
    //2.Dropdownda object Select classda olusturulur -- Select options = newSelect(locate isim);
    //3-annotationlarin siralamasi
   //(En buyuk) @BeforeSuite ==> @BeforeTest ==> @BeforeClass ==> @BeforeGroup ==> @BeforeMethod (En kucuk)
    //(En buyuk) @AfterSuite ==> @AfterTest ==> @AfterClass ==> @AfterGroup ==> @AfterMethod (En kucuk)
    //4-testlerde oncelik vermek icin kullanilan annotation
    // @Test(priorty=0)
    //5--annatationlar;
    //@Before method=her test metodundan once calisir.her testen once gorunur
    //@BeforeClass=sadece bir kere class basinda calisir
    //@ignore=gorunmesini istemedigimiz yerde kullanilir.@Before ve @After methodlarinda ise yaramaz
    //@Test=main method gibi islevi gorur.yazilan metodu run eder ve teste sokar


}
