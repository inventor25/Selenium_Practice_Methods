
package practice01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class NavigationMethod {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("web.driver.chrome.driver","/Users/apple/IdeaProjects/selenium_practice/src/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Youtube ana sayfasina gidelim . https://www.youtube.com/

        driver.get("https://www.youtube.com/");

        Thread.sleep(2000);
        //  Amazon soyfasina gidelim. https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com/");


        // Tekrar YouTube’sayfasina donelim
        Thread.sleep(2000);
        driver.navigate().back();

        // Yeniden Amazon sayfasina gidelim
        Thread.sleep(2000);
        driver.navigate().forward();
        // Sayfayi Refresh(yenile) yapalim
        Thread.sleep(2000);
        driver.navigate().refresh();
        // Sayfayi kapatalim / Tum sayfalari kapatalim
        Thread.sleep(2000);
        driver.close();
    }

}
