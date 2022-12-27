package practice03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class O04 {

    static WebDriver driver;
    @Test
    public void test01() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        //1. Launch browser
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.cssSelector("body[style]"));
        Assert.assertTrue(homePage.isDisplayed());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@href=\"/login\"]")).click();

        //5. Verify 'New User Signup!' is visible
        WebElement newUser = driver.findElement(By.xpath("//*[text()=\"New User Signup!\"]"));
        Assert.assertTrue(newUser.isDisplayed());

        //6. Enter name and email address
        driver.findElement(By.xpath("//*[@type=\"text\"]")).sendKeys("ahmet");
        driver.findElement(By.cssSelector("input[data-qa='signup-email']")).sendKeys("caxzvbn_8566@gmail.com");

        //7. Click 'Signup' button
        driver.findElement(By.cssSelector("button[data-qa=\"signup-button\"]")).click();

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement enterAccount = driver.findElement(By.xpath("//*[text()='Enter Account Information']"));
        Assert.assertTrue(enterAccount.isDisplayed());

        //9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.xpath("//*[@value=\"Mr\"]")).click();
        driver.findElement(By.xpath("//*[@type=\"password\"]")).sendKeys("12345");
        WebElement date01 = driver.findElement(By.xpath("//*[@id='uniform-days']"));
        date01.click();
        driver.findElement(By.xpath("//*[text()='April']")).click();
        driver.findElement(By.xpath("//*[text()='2011']")).click();

        // 🔺 Sayfanın altından kayan reklam çıkmıyorsa aşağıdaki 3 satırı yoruma alın 🔻
       // Thread.sleep(2000);
       // driver.findElement(By.xpath("//*[@class=\"grippy-host\"]")).click();
       // Thread.sleep(2000);
//
        //10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.xpath("//*[@id=\"newsletter\"]")).click();

        //11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.xpath("//*[@id=\"optin\"]")).click();

        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        WebElement firstName = driver.findElement(By.xpath("//*[@id=\"first_name\"]"));
        firstName.sendKeys("Ahmet", Keys.TAB, "Yılmaz", Keys.TAB, "company", Keys.TAB, "address", Keys.TAB, "address2", Keys.TAB, "Canada", Keys.TAB, "state", Keys.TAB, "city", Keys.TAB, "14586 ", Keys.TAB, "852");

        //13. Click 'Create Account button'
        driver.findElement(By.xpath("//*[@data-qa=\"create-account\"]")).click();

        //14. Verify that 'ACCOUNT CREATED!' is visible
        WebElement created = driver.findElement(By.xpath("//*[text()='Account Created!']"));
        Assert.assertTrue(created.isDisplayed());

        //15. Click 'Continue' button
        driver.findElement(By.cssSelector("a[data-qa=\"continue-button\"]")).click();

        //🔺 Tam sayfa açılan reklamı kapatmak için kullanılan method. Reklam çıkmıyorsa aşağıdaki 1 satırı yoruma alın 🔻
       clickOutside();

        //16. Verify that 'Logged in as username' is visible
        WebElement loggedUsername = driver.findElement(By.cssSelector("i[class=\"fa fa-user\"]"));
        Assert.assertTrue(loggedUsername.isDisplayed());

        //17. Click 'Delete Account' button
        driver.findElement(By.cssSelector("a[href=\"/delete_account\"]")).click();

        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        WebElement deleted = driver.findElement(By.cssSelector("h2[data-qa=\"account-deleted\"]"));
        Assert.assertTrue(deleted.isDisplayed());
        driver.findElement(By.cssSelector("a[data-qa=\"continue-button\"]")).click();
    }

    //Tam sayfa açılan reklamı kapatmak için oluşturulan method. Reklamın açıldığı yerde kapatmak methodu çağırın.
   public void clickOutside() {
       Actions action = new Actions(driver);
       action.moveByOffset(0, 0).click().build().perform();
   }
}
