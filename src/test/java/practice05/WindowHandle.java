package practice05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utulities.TestBase;

import java.util.Set;

public class WindowHandle extends TestBase {

    @Test
    public void testWindow() {


        // url'ye git: http://demo.guru99.com/popup.php
        driver.get("http://demo.guru99.com/popup.php");
        // ilk pencereyi al
        String window1 = driver.getWindowHandle();
        // "Click Here" butonuna tıklayın
        driver.findElement(By.xpath("//a[.='Click Here']")).click();
        // setteki tüm pencereyi al
        Set<String> handles = driver.getWindowHandles();
        // diğer pencereye geç
        for (String eachHandle : handles) {
            if (!eachHandle.equals(window1)) {
                driver.switchTo().window(eachHandle);
                break;
            }
        }
        // Gönder düğmesine tıklayarak
        // e-posta kimliğini (somepne@gmail.com) girin ve bu girişe bir şey yazın
        driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("somepne@gmail.com", Keys.TAB, Keys.SPACE);

        // ""This access is valid only for 20 days."" ifadesinin beklendiği gibi olduğunu doğrula
        String yazi = driver.findElement(By.xpath("//h3[.='This access is valid only for 20 days.']")).getText();
        Assert.assertEquals(yazi, "This access is valid only for 20 days.");

        // Tekrar ilk pencereye geç
        driver.switchTo().window(window1);

        // İlk pencerede olduğunu doğrula
        Assert.assertEquals(driver.getWindowHandle(), window1);

    }
}
