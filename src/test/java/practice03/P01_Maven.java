package practice03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class P01_Maven {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");
        //2- cookies uyarisini kabul ederek kapatin

        //3 Sayfa basliginin “Google” ifadesi icerdigini test edin
        String actualTitle=driver.getTitle();
        System.out.println(actualTitle);
        String expectedTitle="Google";
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title Testi PASSED");
        } else {
            System.out.println("Title Testi FAILED");
        }
        //4 Arama cubuguna “Nutella” yazip aratin
        WebElement search = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        search.sendKeys("Nutella", Keys.ENTER);
        //5 Bulunan sonuc sayisini yazdirin
            List<WebElement> aramaSonucYazisi =driver.findElements(By.xpath("//*[@id='result-stats']"));
        System.out.println(aramaSonucYazisi.get(0).getText());
        String [] bolunmus = aramaSonucYazisi.get(0).getText().split(" ");
        System.out.println(Arrays.toString(bolunmus));
        String sayi =bolunmus[1];
        System.out.println(sayi);
        String newSayi= sayi.replace(".","");

        long yeniSayi = Long.parseLong(newSayi);
        System.out.println(yeniSayi);



        //6 sonuc sayisinin 10 milyon’dan fazla oldugunu test edin 8 Sayfayi kapatin
        if (yeniSayi > 10000000) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED");
        }

    }
}
