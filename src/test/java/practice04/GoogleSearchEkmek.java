package practice04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GoogleSearchEkmek {

    WebDriver driver;


    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // 1- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    //2 Sayfa basliginin “Google” ifadesi icerdigini test edin
    @Test
    public void title() {
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Google"));

        //5 Arama cubuguna “Ekmek” yazip aratin
        driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("Ekmek", Keys.ENTER);
        WebElement bulunan = driver.findElement(By.xpath("//*[text()='Yaklaşık 105.000.000 sonuç bulundu']"));


        String[] sonucSayi = bulunan.getText().split(" ", 3); // Array boşluklardan 3 parçaya bölündü çünkü limit 3 yazıldı
        System.out.println(Arrays.toString(sonucSayi));
        System.out.println("sonucSayi = " + sonucSayi[1]);//3 parçaya bölünmüş Array'in 1'inci index'inde bulunan sayı alındı


        // 2.Yol bulunan sonuc sayısının alınması
        //bulunan web elementin bir string'e atanıp ardından getText() metodu ile yazısının alınıp
        //akabinde split() metodu ile boşluklardan kesilip 1'inci index'inde bulunan sayının alınıp sonucun noktalama işaretlerinden temizlenip
        // ve integer'a çevrilip test edilmiştir
        String sonuc = bulunan.getText().split(" ")[1].replaceAll("\\D", "");
        System.out.println("sonuc = " + sonuc);
        int sayi = Integer.parseInt(sonuc);
        int actualSayi = 15000000;
        Assert.assertTrue(sayi > actualSayi);


    }


    //6 Bulunan sonuc sayisini yazdirin
    //7 sonuc sayisinin 15 milyon’dan fazla oldugunu test edin 8 Sayfayi kapatin

}
