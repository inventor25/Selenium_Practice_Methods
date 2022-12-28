package practice04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AssertionMethods {


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

        //2) https://www.youtube.com adresine gidin

        driver.get("https://www.youtube.com");

    }

    @After
    public void tearDown() throws Exception {
        //9. Sayfayi kapatin
        driver.close();
    }
    //3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin

    //○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
    @Test
    public void titleTest() {
        String actualTitle = "YouTube";
        String expectedTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

    }


    //○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    @Test
    public void imageTest() {
        webElementXpath("//*[@id='logo-icon']").isDisplayed();

    }


    //○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    @Test
    public void searchBox() {
        webElementXpath("//input[@id='search']").isDisplayed();
    }

    //○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
    @Test
    public void wrongTitleTest() {
        String expectedTitle = driver.getTitle();
        String wrongTitle = "youtube";
        Assert.assertNotEquals(expectedTitle, wrongTitle);

        //Assert.assertTrue(expectedTitle.equals(wrongTitle)); kodu ile de aynı sonuç alınabilir
    }
}
