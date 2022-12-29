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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class DropDown02 {

    WebDriver driver;


    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1. http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");
    }

    @After
    public void tearDown() throws Exception {
        // driver.close();
    }

    @Test
    public void test01() {
        // 2. Sign in butonuna basin
        driver.findElement(By.id("signin_button")).click();

        //3. Login kutusuna “username” yazin
        //4. Password kutusuna “password.” yazin
        //5. Sign in tusuna basin
        driver.findElement(By.id("user_login")).sendKeys("username", Keys.TAB, "password", Keys.TAB, Keys.TAB, Keys.SPACE);
        driver.navigate().back();

        //6. Pay Bills sayfasina gidin
        driver.findElement(By.id("online-banking")).click();
        driver.findElement(By.id("pay_bills_link")).click();

        //7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']")).click();

        //8. “Currency” drop down menusunden Eurozone’u secin
        WebElement currency = driver.findElement(By.xpath("//*[@id='pc_currency']"));
        Select select = new Select(currency);
        select.selectByVisibleText("Eurozone (euro)");


        //9. “amount” kutusuna bir sayi girin
        //11. “Selected currency” butonunu secin
        //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.xpath("//*[@id='pc_amount']")).sendKeys("1000", Keys.TAB, Keys.RIGHT, Keys.TAB, Keys.SPACE);


        //10. “US Dollars” in secilmedigini test edin
        WebElement secilimi = driver.findElement(By.id("pc_inDollars_true"));
        Assert.assertFalse(secilimi.isSelected());

        driver.findElement(By.id("purchase_cash")).click();


        //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
        WebElement successfully = driver.findElement(By.xpath("//*[@id='alert_content']"));
        Assert.assertTrue(successfully.isDisplayed());
        String suc = successfully.getText();
        System.out.println(suc);


    }


}
