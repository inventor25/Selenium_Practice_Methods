package practice04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class AppSpot {
    WebDriver driver;

    public void setUps() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    public WebElement webElementXpath(String xPath) {

        return driver.findElement(By.xpath(xPath));

    }



    public void assertTrue(WebElement webElement) {
        Assert.assertTrue(webElement.isDisplayed());

    }


    @Before
    public void setUp() {

        setUps();

        driver.get("https://books-pwakit.appspot.com/");

    }
         /*
        1-https://books-pwakit.appspot.com/ adresine gidin.
        2-"BOOKS" başlığının görünür olduğunu doğrulayın
        3-Arama çubuğunda "Selenium" u aratın.
        4-Arama sonuçlarındaki ilk ürün isminin "Selenium" içerdiğini doğrulayın.
           */

    @Test
    public void booksTest() {
       WebElement title =webElementXpath("//*[text()='BOOKS']");
        assertTrue(title);

    }
    //--------------------Shadow ile devam edilecek---------


    }




