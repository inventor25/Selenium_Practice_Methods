package practice01;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Trendyol_Webelement {
    public static void main(String[] args) {
        System.setProperty("web.driver.chrome.driver", "src/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1. trendyol sayfasına gidelim
        driver.get("https://www.trendyol.com/");
        //2. Search bölümünü locate edelim
       WebElement search = driver.findElement(By.className("vQI670rJ"));
        System.out.println(search);
        // Search bölümünde "modagetir" aratalım
        search.sendKeys("modagetir", Keys.ENTER);
     // // Arama sonuc yazisinda modagetir yazısını locate edip konsola yazdiralim.
     // WebElement aramaSonucYazisi = driver.findElement(By.id("sticky-aggregations"));
     // System.out.println(aramaSonucYazisi.getText());
        // Trensyol sayfasındaki <input> ve <a> tag'larının sayısını yazdırınız
        List<WebElement> inputTags = driver.findElements(By.tagName("input"));
        System.out.println("Input Tag Sayısı = "+inputTags.size());
        List<WebElement> linklerList = driver.findElements(By.tagName("a"));
        System.out.println("Link Sayısı = "+linklerList.size());

      // for (  WebElement w : linklerList ) {
      //     System.out.println(w.getText());

      // }
        driver.close();






    }
}
