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
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class AutomationCase01 {

    static WebDriver driver;
    public void clickOutside() {
        Actions action = new Actions(driver);
        action.moveByOffset(0, 0).click().build().perform();
    }

    public void setUps() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    public WebElement webElementXpath(String xPath) {

        return driver.findElement(By.xpath(xPath));

    }

    public WebElement webElementId(String id) {

        return driver.findElement(By.xpath(id));

    }


    public void assertTrue(WebElement webElement) {
        Assert.assertTrue(webElement.isDisplayed());

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


    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully


    @Test
    public void test02() {

        WebElement homPage = webElementXpath("//*[@class='fa fa-home']");

        assertTrue(homPage);
    }


    //4. Click on 'Signup / Login' button

    @Test
    public void test03() {

        webElementXpath("//*[@class='fa fa-lock']").click();
    }


    //5. Verify 'New User Signup!' is visible


    @Test
    public void test04() {

        webElementXpath("//*[@class='fa fa-lock']").click();

        WebElement newUser = webElementXpath("//*[@class='signup-form']");

        assertTrue(newUser);
    }


    //6. Enter name and email address

    @Test
    public void test05() {
        webElementXpath("//*[@class='fa fa-lock']").click();

        WebElement name1 = webElementXpath("(//*[@name='name'])[1]");

        name1.sendKeys("Ahmet", Keys.ENTER);

        WebElement email1 = webElementXpath("(//*[@type='email'])[2]");

        email1.sendKeys("ahmet12345@gmail.com");

    }


    //7. Click 'Signup' button

    @Test
    public void test06() {

        webElementXpath("//*[@class='fa fa-lock']").click();

        WebElement name1 = webElementXpath("(//*[@name='name'])[1]");

        name1.sendKeys("Ahmet", Keys.ENTER);

        WebElement email1 = webElementXpath("(//*[@type='email'])[2]");

        email1.sendKeys("ahmet12345@gmail.com");

        WebElement signup = webElementXpath("(//*[@class='btn btn-default'])[2]");

        signup.click();
    }

    //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible

    @Test
    public void test07() {

        webElementXpath("//*[@class='fa fa-lock']").click();

        WebElement name1 = webElementXpath("(//*[@name='name'])[1]");

        name1.sendKeys("Ahmet", Keys.ENTER);

        WebElement email1 = webElementXpath("(//*[@type='email'])[2]");

        email1.sendKeys("ahmet12345@gmail.com");

        WebElement signup = webElementXpath("(//*[@class='btn btn-default'])[2]");

        signup.click();

        WebElement information = webElementXpath("(//*[@class='title text-center'])[1]");

        assertTrue(information);
    }

    //9. Fill details: Title, Name, Email, Password, Date of birth

    @Test
    public void test08() {

        webElementXpath("//*[@class='fa fa-lock']").click();

        WebElement name1 = webElementXpath("(//*[@name='name'])[1]");

        name1.sendKeys("Ahmet", Keys.ENTER);

        WebElement email1 = webElementXpath("(//*[@type='email'])[2]");

        email1.sendKeys("ahmet12345@gmail.com");

        WebElement signup = webElementXpath("(//*[@class='btn btn-default'])[2]");

        signup.click();

        webElementXpath("//*[@id='uniform-id_gender1']").click();

        webElementXpath("(//*[@id='password'])[1]").sendKeys("1234f");

        WebElement date01 = webElementXpath("//*[@id='uniform-days']");

        date01.click();

        webElementXpath("(//*[@value='5'])[1]").click();

        webElementXpath("//*[text()='April']").click();

        webElementXpath("//*[text()='2011']").click();

        //10. Select checkbox 'Sign up for our newsletter!'

        webElementXpath("//*[@id='newsletter']").click();

        //11. Select checkbox 'Receive special offers from our partners!'

        webElementXpath("//*[@id='optin']").click();

        //12. Fill details: First name, Last name,

        // Company, Address, Address2, Country, State, City, Zipcode, Mobile Number

        webElementXpath("//*[@id='first_name']").sendKeys("Ahmet", Keys.ENTER);

        webElementXpath("//*[@id='last_name']").sendKeys("Kara", Keys.ENTER);

        webElementXpath("//*[@id='company']").sendKeys("QA", Keys.ENTER);

        webElementXpath("//*[@id='address1']").sendKeys("Mehmet akif mh. 3430 , QA Company", Keys.ENTER);

        webElementXpath("//*[@id='address2']").sendKeys("Barboros cd. No:45", Keys.ENTER);

        webElementXpath("//*[text()='Singapore']").click();

        webElementXpath("//*[@id='state']").sendKeys("Bollywood", Keys.ENTER);

        webElementXpath("//*[@id='city']").sendKeys("Mumbai", Keys.ENTER);

        webElementXpath("//*[@id='zipcode']").sendKeys("3468", Keys.ENTER);

        webElementXpath("//*[@id='mobile_number']").sendKeys("5435537");

        //13. Click 'Create Account button'

        webElementXpath("//*[text()='Create Account']").click();


        //13. Click 'Create Account button'

        //14. Verify that 'ACCOUNT CREATED!' is visible

        WebElement account = webElementXpath("  //*[text()='Account Created!']");

        assertTrue(account);

        //15. Click 'Continue' button

        webElementXpath("//*[text()='Continue']").click();
        //-- Açılan reklamı kapatmak için kullanılan method. Reklam çıkmıyorsa aşağıdaki  satırı yoruma alın
        clickOutside();


        //17. Click 'Delete Account' button

        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button

    }

    @Test
    public void test09() {

        //16. Verify that 'Logged in as username' is visible

        webElementXpath("//*[@class='fa fa-lock']").click();

        webElementXpath("(//*[@placeholder='Email Address'])[1]").sendKeys("ahmet12345@gmail.com", Keys.ENTER);

        webElementXpath("//*[@data-qa='login-password']").sendKeys("1234f", Keys.ENTER);

        WebElement user = webElementXpath("//*[text()='Ahmet']");

        assertTrue(user);

        //17. Click 'Delete Account' button

        webElementXpath("(//*[@style='color:brown;'])[2]").click();


        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        clickOutside();
        WebElement userDelete = webElementXpath("//*[@style='margin-top: 100px !important;']");

        assertTrue(userDelete);


    }




}
