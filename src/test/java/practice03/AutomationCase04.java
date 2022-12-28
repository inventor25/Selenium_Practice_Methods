package practice03;

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

public class AutomationCase04 {

    WebDriver driver;

    public void setUps() {


        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    //Web elementin Xpath ile alımı methodu
    public WebElement webElementXpath(String xPath) {

        return driver.findElement(By.xpath(xPath));

    }

    //AssertTrue methodu
    public void assertTrueMethod(WebElement element) {
        Assert.assertTrue(element.isDisplayed());

    }

    @Before
    public void setUp() {

        setUps();

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

    }

    @After
    public void tearDown() {
        //  driver.close();

    }

    @Test
    public void accountCreate() {
        webElementXpath("//*[@class='fa fa-lock']").click();
        webElementXpath("//*[@data-qa='signup-name']").sendKeys("mehmet",
                Keys.TAB, "kara1234@gmail.com",
                Keys.TAB, Keys.SPACE);
        webElementXpath("//*[@value='Mr']").sendKeys("Mr", Keys.SPACE, Keys.TAB, "mehmet", Keys.TAB, "4321f", "4", Keys.SPACE,
                Keys.TAB, "5", Keys.SPACE, Keys.TAB, Keys.SPACE, "4", Keys.SPACE, Keys.TAB,
                Keys.SPACE, "2000", Keys.SPACE, Keys.ENTER, "ahmet", Keys.ENTER, "kara",
                Keys.ENTER, "adnan mh", Keys.ENTER, "india",
                Keys.ENTER, "Mumbai", Keys.ENTER, "1234", Keys.ENTER, "45665445", Keys.ENTER);

    }


    @Test
    public void test02() {
        //3. Verify that home page is visible successfully
        WebElement homPage = webElementXpath("//*[@class='fa fa-home']");
        assertTrueMethod(homPage);

        //4. Click on 'Signup / Login' button
        webElementXpath("//*[@class='fa fa-lock']").click();


    }

    @Test


    public void correctLogin() {
        webElementXpath("//*[@class='fa fa-lock']").click();

        //5. Verify 'Login to your account' is visible
        WebElement visibleLogin = webElementXpath("//*[@class='login-form']");
        assertTrueMethod(visibleLogin);

        //6. Enter correct email address and password
        //7. Click 'login' button
        webElementXpath("//*[@data-qa='login-email']").sendKeys("kara1234@gmail.com", Keys.TAB, "4321f", Keys.TAB, Keys.SPACE);

        //8. Verify that 'Logged in as username' is visible
        /*


       ----------------------- Site Hata veriyor--------------




         */

    }


    //9. Click 'Logout' button
    //10. Verify that user is navigated to login page
}
