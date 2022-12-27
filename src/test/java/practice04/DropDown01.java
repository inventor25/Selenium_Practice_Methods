package practice04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class DropDown01 {

    WebDriver driver;

    //Driver Methotları sayfanın başında istediğimiz şekilde istenilen komutlar

    public void setUps() {


        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    //Web elementin Xpath ile alımı methodu

    public WebElement webElementXpath(String xPath) {

        return driver.findElement(By.xpath(xPath));

    }




    // ● https://the-internet.herokuapp.com/dropdown adresine gidin.

    @Before
    public void setUp() {

        setUps();

        driver.get("https://the-internet.herokuapp.com/dropdown");

    }

    @After
    public void tearDown() {
        //  driver.close();

    }




    // 1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın

    @Test

    public void option01() {

        WebElement number01 = webElementXpath("//*[@id='dropdown']");
        Select optiondropdown = new Select(number01);
        List<WebElement> optionList = optiondropdown.getOptions();


        optiondropdown.selectByIndex(1);
        System.out.println(optionList.get(1).getText());


    }

    // 2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın

    @Test

    public void option02() {

        WebElement number01 = webElementXpath("//*[@id='dropdown']");
        Select optiondropdown = new Select(number01);
        List<WebElement> optionList = optiondropdown.getOptions();

        optiondropdown.selectByValue("2");

        System.out.println(optionList.get(2).getText());


    }


    // 3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın

    @Test

    public void option03() {

        WebElement number01 = webElementXpath("//*[@id='dropdown']");
        Select optiondropdown = new Select(number01);
        List<WebElement> optionList = optiondropdown.getOptions();


        optiondropdown.selectByVisibleText("Option 1");
        System.out.println(optionList.get(1).getText());


    }

    // 4.Tüm dropdown değerleri(value) yazdırın

    @Test

    public void option034() {

        WebElement number01 = webElementXpath("//*[@id='dropdown']");
        Select optiondropdown = new Select(number01);
        List<WebElement> optionList = optiondropdown.getOptions();

        // optiondropdown.stream().forEach(t-> System.out.println(t.getText())); //lambda ile yazdırıldı

        for (WebElement allElement : optionList) {
            System.out.println(allElement.getText());
        }


    }

    // 5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.

    @Test

    public void boyut() {

        WebElement dropDown = driver.findElement(By.xpath("//*[@id='dropdown']"));
        Dimension boyut = dropDown.getSize();
        System.out.println(boyut);

    }

    //Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.

    @Test

    public void ogeTest() {

        WebElement number01 = webElementXpath("//*[@id='dropdown']");
        Select optiondropdown = new Select(number01);
        List<WebElement> optionList = optiondropdown.getOptions();

        int size = optionList.size();

        Assert.assertFalse(size == 4);

        if (size == 3) {
            System.out.println("False");

        }
    }
}
