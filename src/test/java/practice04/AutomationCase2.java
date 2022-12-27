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

public class AutomationCase2 {


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

    //AssertTrue methodu
    public void assertTrueMethod(WebElement element) {
        Assert.assertTrue(element.isDisplayed());

    }

    @Before
    public void setUp() {

        setUps();

        driver.get("http://automationexercise.com");

    }

    @After
    public void tearDown() {
          driver.close();

    }
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'


    //3. Verify that home page is visible successfully
    @Test
    public void homePageTest() {

        WebElement homPage = webElementXpath("//*[@class='fa fa-home']");

        assertTrueMethod(homPage);
    }


    //4. Click on 'Signup / Login' button
    @Test
    public void signupLogin() {

        webElementXpath("//*[@class='fa fa-lock']").click();
    }

    //5. Verify 'Login to your account' is visible
    @Test
    public void loginToAccountTest() {
        webElementXpath("//*[@class='fa fa-lock']").click();

        WebElement loginToAccount=  webElementXpath("//h2['Login to your account']");

        assertTrueMethod(loginToAccount);
    }

    @Test
    public void firstSignup() {

        webElementXpath("//*[@class='fa fa-lock']").click();

        WebElement name1 = webElementXpath("(//*[@name='name'])[1]");

        name1.sendKeys("Can", Keys.ENTER);

        WebElement email1 = webElementXpath("(//*[@type='email'])[2]");

        email1.sendKeys("can1@gmail.com");

        WebElement signup = webElementXpath("(//*[@class='btn btn-default'])[2]");

        signup.click();

        webElementXpath("//*[@id='uniform-id_gender1']").click();

        webElementXpath("(//*[@id='password'])[1]").sendKeys("1234f");

        WebElement date01 = webElementXpath("//*[@id='uniform-days']");

        date01.click();

        webElementXpath("(//*[@value='5'])[1]").click();

        webElementXpath("//*[text()='April']").click();

        webElementXpath("//*[text()='2011']").click();

        webElementXpath("//*[@id='newsletter']").click();

        webElementXpath("//*[@id='optin']").click();

        webElementXpath("//*[@id='first_name']").sendKeys("Can", Keys.ENTER);

        webElementXpath("//*[@id='last_name']").sendKeys("Kara", Keys.ENTER);

        webElementXpath("//*[@id='company']").sendKeys("QA", Keys.ENTER);

        webElementXpath("//*[@id='address1']").sendKeys(" Adnan mh. 3430 , QA Company", Keys.ENTER);

        webElementXpath("//*[@id='address2']").sendKeys("Menderes cd. No:45", Keys.ENTER);

        webElementXpath("//*[text()='Singapore']").click();

        webElementXpath("//*[@id='state']").sendKeys("Bollywood", Keys.ENTER);

        webElementXpath("//*[@id='city']").sendKeys("Mumbai", Keys.ENTER);

        webElementXpath("//*[@id='zipcode']").sendKeys("3468", Keys.ENTER);

        webElementXpath("//*[@id='mobile_number']").sendKeys("5435537");

        webElementXpath("//*[text()='Create Account']").click();
    }
    //9. Click 'Delete Account' button
    //8. Verify that 'Logged in as username' is visible
    //7. Click 'login' button
    //6. Enter correct email address and password
    @Test
    public void correctInformations() {
        webElementXpath("//*[@class='fa fa-lock']").click();
        webElementXpath("//input[@data-qa='login-email']").sendKeys("can1@gmail.com",Keys.ENTER);
        driver.findElement(By.name("password")).sendKeys("1234f",Keys.ENTER);
        driver.findElement(By.xpath("(//*[@class='btn btn-default'])[1]")).click();
        WebElement can = webElementXpath("//*[text()='Can']");
        assertTrueMethod(can);

        WebElement userDelete = webElementXpath("(//*[@style='color:brown;'])[2]");
        userDelete.click();
        assertTrueMethod(userDelete);
    }





    //10. Verify that 'ACCOUNT DELETED!' is visible
}
