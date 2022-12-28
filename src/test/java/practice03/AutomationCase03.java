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

public class AutomationCase03 {
    WebDriver driver;

    //1. Launch browser(tarayıcıyı başlat)
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //2. Navigate to url 'http://automationexercise.com'(url'ye gidin)
        driver.navigate().to("http://automationexercise.com");
    }

    @After
    public void tearDown() throws Exception {
        driver.close();

    }

    //3. Verify that home page is visible successfully(Ana sayfanın başarıyla göründüğünü doğrulayın)
    @Test
    public void homePage() {

        WebElement hp= driver.findElement(By.xpath("//*[@class='nav navbar-nav']"));

        Assert.assertTrue(hp.isDisplayed());

    }

    //4. Click on 'Signup / Login' button('Kaydol / Giriş Yap' düğmesine tıklayın)
    @Test
    public void signupLogin() {
        driver.findElement(By.xpath(" //*[text()=' Signup / Login']")).click();
    }

    //5. Verify 'Login to your account' is visible('Hesabınıza giriş yapın'ın görünür olduğunu doğrulayın)
    @Test
    public void loginToAccount() {
        driver.findElement(By.xpath(" //*[text()=' Signup / Login']")).click();//Signup butona tıkla
       WebElement la= driver.findElement(By.xpath("//*[@class='login-form']"));//sonra bu yazı görünür mü test yap
       Assert.assertTrue(la.isDisplayed());
    }

    //6. Enter incorrect email address and password(Yanlış e-posta adresi ve şifre girin)
    //7. Click 'login' button('Giriş' düğmesini tıklayın)
    //8. Verify error 'Your email or password is incorrect!' is visible(Hatayı doğrulayın 'E-postanız veya şifreniz yanlış!' görünür)
    @Test
    public void emailPassTest() {
        driver.findElement(By.xpath(" //*[text()=' Signup / Login']")).click();//Signup butona tıkla
        driver.findElement(By.xpath("//*[@data-qa='login-email']")).sendKeys("asdf@gmail.com", Keys.TAB,"-*",Keys.TAB,Keys.ENTER);
       WebElement mistake= driver.findElement(By.xpath("//*[text()='Your email or password is incorrect!']"));
       Assert.assertTrue(mistake.isDisplayed());

    }

}
