package practice02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Trendyol_GetTitle {
    public static void main(String[] args) {
        System.setProperty("web.driver.chrome.driver", "src/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1. trendyol web sayfasına gidin ve sayfa başlığının “trendyol” olup olmadığını doğrulayın (verify),
        // eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.

        driver.get("https://www.trendyol.com/");

        // 2. Sayfa URL'sinin “trendyol” içerip içermediğini (contains) doğrulayın içermiyorsa doğru
        // URL'yi yazdırın, ve doğru Url olup olmadığını test edin

        String expectedUrl = driver.getCurrentUrl();
        String actualUrl = "https://www.trendyol.com/";

        if (expectedUrl.equals(actualUrl)) {
            System.out.println("Url TEST'i PASSED");

        } else {
            System.out.println("Url TEST'i FAILED");
        }
        if (expectedUrl.contains("trendyol")) {
            System.out.println("Url içerik TEST'i PASSED");
        } else {
            System.out.println("Url içerik TEST'i FAILED");

        }
        //3. sayfa başlığının "trendyol" içerip içermediğini (contains) doğrulayın,
        // Yoksa doğru başlığı(Actual Title) yazdırın.

        String expectedTitle = driver.getTitle();
        String actualTitle = "Trendyol";
        System.out.println(expectedTitle);

        if (expectedTitle.contains(actualTitle)) {
            System.out.println("Title testi PASSED");
        } else {
            System.out.println("Title testi FAILED");
        }

        // 4. Daha sonra Amazon sayfasina gidin https://www.amazon.com/

        driver.get("https://www.amazon.com/");

        // 5. trendyol sayfasina geri donun

        driver.navigate().back();

        // 6. Sayfayi yenileyin

        driver.navigate().refresh();

        // 7. Amazon sayfasina donun

        driver.navigate().forward();

        // 8. Sayfayi tamsayfa yapin

        driver.manage().window().maximize();

        // 9. Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın,
        // Yoksa doğru başlığı(Actual Title) yazdırın.

        String expectedTitle2 = driver.getTitle();
        System.out.println(expectedTitle2);
        String actualTitle2 = "Amazon";

        if (expectedTitle2.contains(actualTitle2)) {
            System.out.println("Title testi PASSED");
        } else {
            System.out.println("Title testi FAILED");

        }

        // 10.Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın,
        // degilse doğru URL'yi yazdırın

        String expectedUrl2 = driver.getCurrentUrl();
        String actualUrl2 = "https://www.amazon.com/";

        if (expectedUrl2.equals(actualUrl2)) {
            System.out.println("Url TEST'i PASSED");

        } else {
            System.out.println("Url TEST'i FAILED");
        }

        // 11.Sayfayi kapatin

        driver.close();
    }
}
