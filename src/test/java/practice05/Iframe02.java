package practice05;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utulities.TestBase;

import java.util.List;

public class Iframe02 extends TestBase {
    @Test
    public void test01() throws InterruptedException {

        // 1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");
        // 2) sayfadaki iframe sayısını bulunuz.
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        System.out.println(iframes.size());

        // 3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        driver.findElement(By.xpath("(//div[@class='rt-grid-6 rt-omega'])[2]")).click();
        Thread.sleep(3000);
        // 4) ilk iframe'den çıkıp ana sayfaya dönünüz
        // 5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html) tıklayınız
        driver.switchTo().defaultContent();
        driver.switchTo().frame("a077aa5e");

        driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();
        Thread.sleep(3000);
        driver.switchTo().defaultContent();
    }

}
