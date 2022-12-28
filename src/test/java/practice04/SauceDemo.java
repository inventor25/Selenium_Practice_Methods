package practice04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SauceDemo {

    WebDriver driver;

        //Web driver için hazır olusturulmuş method
    public void setUps() {


        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    //Web elementin Xpath ile alım methodu
    public WebElement webElementXpath(String xPath) {

        return driver.findElement(By.xpath(xPath));

    }

    @Before
    public void setUp() {

        setUps();

        //1. Launch browser

        //1. “https://www.saucedemo.com” Adresine gidin

        driver.get("https://www.saucedemo.com");

    }

    @After
    public void tearDown() throws Exception {
        //9. Sayfayi kapatin
        driver.close();
    }

    @Test
    public void informations() {

        //2. Username kutusuna “standard_user” yazdirin
        // 3. Password kutusuna “secret_sauce” yazdirin
        // 4. Login tusuna basin
        driver.findElement(By.id("user-name")).sendKeys("standard_user",
                Keys.TAB, "secret_sauce", Keys.TAB, Keys.SPACE);

        /*

        Keys.Tab ile geçişler sağlanarak istenilen bilgilerin girişleri yapıldı ve test sağlandı

         */

        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        String isim = webElementXpath("//*[text()='Sauce Labs Backpack']").getText();
        System.out.println(isim);
        webElementXpath("//*[text()='Sauce Labs Backpack']").click();

        //6. Add to Cart butonuna basin
        webElementXpath("//*[text()='Add to cart']").click();

        //7. Alisveris sepetine tiklayin
        driver.findElement(By.className("shopping_cart_badge")).click();

        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement sepet = driver.findElement(By.className("cart_item_label"));
        Assert.assertTrue(sepet.getText().contains(isim));





    }


}
