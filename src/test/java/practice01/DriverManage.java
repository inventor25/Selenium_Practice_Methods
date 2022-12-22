package practice01;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverManage {
    public static void main(String[] args) {
        System.setProperty("web.driver.chrome.driver", "/Users/apple/IdeaProjects/selenium_practice/src/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Amazon soyfasina gidelim. https://www.amazon.com/

        driver.get(" https://www.amazon.com/");

        // Sayfanin konumunu ve boyutlarini yazdirin

        System.out.println("Browser’in koordinatlarini verir :" + driver.manage().window().getPosition());
        System.out.println("Browser’in olculerini verir: " + driver.manage().window().getSize());

        // Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin

        driver.manage().window().setPosition(new Point(15, 35));

        driver.manage().window().setSize(new Dimension(900, 300));


        // Sayfanin sizin istediginiz konum ve boyuta geldigini test edin
        Point point = driver.manage().window().getPosition();
        System.out.println(point);
        if (point.getX()==15 && point.getY()==35) {
            System.out.println("Browser konumu TEST'i PASSED");
        } else {
            System.out.println("Browser konumu TEST'i FAILED");
        }
        Dimension actualNewSize = driver.manage().window().getSize();
        System.out.println(actualNewSize);
        if (actualNewSize.getWidth()==900 && actualNewSize.getHeight()==300) {
            System.out.println("Browser boyutu TEST'i PASSED");
        } else {
            System.out.println("Browser boyutu TEST'i FAILED");
        }

        // Sayfayi kapatin

        driver.close();


    }
}
