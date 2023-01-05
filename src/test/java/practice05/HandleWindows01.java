package practice05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utulities.TestBase;

import java.util.Set;

public class HandleWindows01 extends TestBase {
    @Test
    public void test01() throws InterruptedException {


        //● Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com/");


        //● Sayfa’nin window handle degerini String bir degiskene atayin
        String window1 = driver.getWindowHandle();
        System.out.println(window1);
        //● Sayfa title’nin “Amazon” icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Amazon"));

        //● Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin ● Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://techproeducation.com/");
        Thread.sleep(3000);
        Assert.assertFalse(driver.getTitle().contains("TECHPROEDUCATION"));

        //● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("http://walmart.com");
        //● Sayfa title’nin “Walmart” icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Walmart"));
        //● Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        Set<String> handles = driver.getWindowHandles();
        System.out.println(handles);
        driver.switchTo().window(window1);
        String sonBaslik = driver.getWindowHandle();
        System.out.println(sonBaslik);
        Assert.assertEquals(window1, sonBaslik);


    }
}
