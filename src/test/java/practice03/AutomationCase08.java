package practice03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utulities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AutomationCase08 extends TestBase {

    public void clickOutside() {
        Actions action = new Actions(driver);
        action.moveByOffset(0, 0).click().build().perform();
    }

    @Test
    public void test01() throws InterruptedException {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");

        //3. Verify that home page is visible successfully
       WebElement homePage= driver.findElement(By.xpath("//i[@class='fa fa-home']"));
        Assert.assertTrue(homePage.isDisplayed());

        //4. Click on 'Products' button
        WebElement products=driver.findElement(By.xpath("//i[@class='material-icons card_travel']"));
        products.click();
        clickOutside();

        //5. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement allProducts=driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(allProducts.isDisplayed());

        //6. The products list is visible
        Thread.sleep(5000);
        List<WebElement> productsList=driver.findElements(By.xpath("//div[@class='product-image-wrapper']"));

        for (WebElement eachList:productsList) {
            System.out.println(eachList.getText());
        }
      Assert.assertTrue(driver.findElement(By.xpath("//div[@class='product-image-wrapper']")).isDisplayed());



        //7. Click on 'View Product' of first product
        WebElement firstPro= driver.findElement(By.xpath("(//i[@class='fa fa-plus-square'])[1]"));
        firstPro.click();
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.xpath("//h2[.='Blue Top']")).isDisplayed());


        //8. User is landed to product detail page
        Assert.assertTrue(driver.findElement(By.xpath("//h2[.='Blue Top']")).isDisplayed());


        //9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
        String firstInformation=driver.findElement(By.xpath("//*[@class='product-information']")).getText();
        List<String> firstinformationList= new ArrayList<>(Arrays.asList("Blue Top","Category","Rs. 500","Availability","Condition","Brand"));
        for (String w :firstinformationList){
            Assert.assertTrue(firstInformation.contains(w));
        }

    }
}
