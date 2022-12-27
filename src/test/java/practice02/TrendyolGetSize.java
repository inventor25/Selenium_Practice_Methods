package practice02;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TrendyolGetSize {
    public static void main(String[] args) {
        System.setProperty("web.driver.chrome.driver", "src/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1. trendyol sayfasına tekrar dönelim.

        driver.get("https://www.trendyol.com/");

        //2.//Sayfanın konumunu ve size'ını yazdıralım

        Dimension size = driver.manage().window().getSize();
        Point position = driver.manage().window().getPosition();
        System.out.println(size);
        System.out.println(position);

        //3.Sayfanın konumunu ve size'inı istediğimiz şekilde ayarlıyalım

        driver.manage().window().setSize(new Dimension(1000, 400));
        driver.manage().window().setPosition(new Point(50, 50));

        System.out.println("Sayfanın yeni size'i: " + driver.manage().window().getSize());
        System.out.println("Sayfanın yeni konumu: " + driver.manage().window().getPosition());

        //4.Sayfanın konum ve size'ının istediğimiz şekilde ayarlandığını test edin

        Dimension newSize = driver.manage().window().getSize();
        if (newSize.getWidth() == 1000 && newSize.getHeight() == 400) {
            System.out.println("Sayfanın Size TEST'i PASSED");

        } else {
            System.out.println("Sayfanın Size TEST'i FAILED");

        }

        Point newPosition = driver.manage().window().getPosition();

        if (newPosition.getX() == 50 && newPosition.getY() == 50) {
            System.out.println("Sayfanın konum TEST'i PASSED");
        } else {
            System.out.println("Sayfanın konum TEST'i FAILED");
        }
        driver.close();


    }

}
