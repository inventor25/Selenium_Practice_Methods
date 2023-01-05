package practice05;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.w3c.dom.stylesheets.LinkStyle;
import utulities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class İframe01 extends TestBase {

    @Test
    public void iframeTest() throws InterruptedException {
        //go to web site : https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        //maximize the web site

        // ikinci emojiye tıklayın
        WebElement iframe =driver.findElement(By.xpath("//iframe[@id='emoojis']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();
        Thread.sleep(5000);
        // ikinci emoji altındaki tüm öğelere tıklayın
        List<WebElement> emojiler= driver.findElements(By.xpath("//div[@id='nature']/div/img"));
       emojiler.forEach(WebElement::click);

        // ana iframe'e geri dön
        driver.switchTo().defaultContent();
        //formu doldurun,(Formu istediğiniz metinlerle doldurun)
        List<WebElement> forum=driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));
        List<String> text = new ArrayList<>(Arrays.asList("1","2","3","4","5","6","7","8","9","10","11"));
        for (int i=0;i< text.size();i++) {
            forum.get(i).sendKeys(text.get(i));
        }

        Thread.sleep(3000);

        // uygula butonuna tıklayın
        driver.findElement(By.id("send")).click();

    }
}
