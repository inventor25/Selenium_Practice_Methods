package practice04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class RadioButtonTest {


    WebDriver driver;


    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // 1- https://www.google.com/ adresine gidin
        driver.get("https://www.facebook.com");


    }

    //1. Bir class oluşturun : RadioButtonTest
    //2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    //- https://www.facebook.com adresine gidin
    //- Cookies’i kabul edin
    //- “Create an Account” button’una basin
    //- “radio buttons” elementlerini locate edin
    //- Secili degilse cinsiyet butonundan size uygun olani secin

    @Test
    public void createAccount() {

        //Siteye gidildi Create an Account sekmesi tıklantı karşımıza çıkan radio buttons lari günden başlanarak ve Keys geçişleri kullanılarak
        //hepsinin varlığı kontrol edildi ve cinsiyet button'u seçildi
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        driver.findElement(By.xpath("//*[@id='day']")).sendKeys("29",
        Keys.TAB,"Ara",Keys.TAB,"2022",Keys.TAB,Keys.TAB,"Kadın",Keys.RIGHT,Keys.RIGHT,Keys.LEFT);

    }
}
