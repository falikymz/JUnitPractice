package practice02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_IFrame extends TestBase {

    @Test
    public void test01() {
        // https://www.jqueryscript.net/demo/jQuery-Plugin-For-Responsive-Flexible-Iframes-Flexy/ sayfasına gidiniz
        driver.get("https://www.jqueryscript.net/demo/jQuery-Plugin-For-Responsive-Flexible-Iframes-Flexy/");

        // Videoyu görecek kadar asagiya ininiz
        Actions actions =new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        // Videoyu izlemek icin Play tusuna basiniz
        WebElement firstVideo = driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/x3kfyZJhC3U?rel=0&showinfo=0']"));
        driver.switchTo().frame(firstVideo);//iframe geçişi

        WebElement playButton=driver.findElement(By.xpath("//button[@title='Oynat']"));
        playButton.click();
        waitForSecond(3);

        // videoyu durdurunuz
        WebElement pauseButton =driver.findElement(By.xpath("//button[@class='ytp-play-button ytp-button']"));
        pauseButton.click();
        waitForSecond(2);

        // videoyu tam ekran yapınız
        WebElement fullScreenButton = driver.findElement(By.xpath("//button[@class='ytp-fullscreen-button ytp-button']"));
        fullScreenButton.click();
        waitForSecond(2);

        // videoyu calıstırınız
        pauseButton.click();
        waitForSecond(2);

        // videoyu kucultunuz
        fullScreenButton.click();
        waitForSecond(2);

        // videoyu durdurunuz
        pauseButton.click();
        waitForSecond(2);

        // Videoyu calistirdiginizi test ediniz
        WebElement youtubeText = driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        Assert.assertTrue(youtubeText.isDisplayed());

        // 'jQuery Flexy Plugin Demos' yazısının gorunur oldugunu test ediniz
        driver.switchTo().defaultContent();
       WebElement lastText = driver.findElement(By.xpath("//h1[text()='jQuery Flexy Plugin Demos']"));
       Assert.assertTrue(lastText.isDisplayed());



    }
}
