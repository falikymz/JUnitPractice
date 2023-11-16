package practice02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_Iframe extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        // https://html.com/tags/iframe sayfasına gidiniz
        driver.get("https://html.com/tags/iframe");


        // Videoyu görecek kadar asagiya ininiz
        Actions actions =new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

       WebElement iframe =driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(iframe);



        // Videoyu izlemek icin Play tusuna basiniz
        driver.findElement(By.xpath("//button[@title='Oynat']")).click();
        Thread.sleep(3000);

        // Videoyu calistirdiginizi test ediniz
        WebElement youtubeText =driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        Assert.assertTrue(youtubeText.isDisplayed());

        // 'Powerful,but easy to misuse' yazısının gorunur oldugunu test ediniz
        driver.switchTo().defaultContent();
        driver.findElement(By.id("Powerful_but_easy_to_misuse"));

    }
}
