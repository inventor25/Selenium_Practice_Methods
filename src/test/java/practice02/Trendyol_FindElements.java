package practice02;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Trendyol_FindElements {
    public static void main(String[] args) {
        System.setProperty("web.driver.chrome.driver", "src/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1. trendyol sayfasına gidin

        driver.get("https://www.trendyol.com/");

        //2. search "modagetir"

        driver.findElement(By.className("vQI670rJ")).sendKeys("modagetir", Keys.ENTER);

        //3.Arama sonuc yazısını konsola yazdırın,

        List<WebElement> aramaSonuc1 = driver.findElements(By.className("srch-ttl-cntnr-wrppr"));
        System.out.println("Arama Sonuc Yazısın: " + aramaSonuc1.get(0).getText());

        // WebElement aramaSonuc= driver.findElement(By.className("srch-ttl-cntnr-wrppr"));

        //  System.out.println(aramaSonuc);------>(doğru sonucu alamadık)

        String[] sonucSayisi = aramaSonuc1.get(0).getText().split(" ");
        System.out.println(Arrays.toString(sonucSayisi));
        System.out.println("Sonuc Sayisi: " + sonucSayisi[3]);

        //Sonuc yazısını Lambda ile yazdırın

        Arrays.stream(aramaSonuc1.get(0).getText().split(" ")).limit(4).skip(3).forEach(System.out::println);

        //Sonra karşınıza çıkan sonucun  ilk  resmine tıklayın.

        List<WebElement> ilkWebElement = driver.findElements(By.className("image-container"));
        ilkWebElement.get(0).click();
    }
}
