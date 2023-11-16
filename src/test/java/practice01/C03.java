package practice01;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03 extends TestBase {
    // https://www.bestbuy.com/ sayfasına gidin
    // sayfa Title'ini alın "Best" içerdigini test edin
    // BestBuy logosunun görüntülendigini test edin
    // Canada logosunun görüntülendigini test edin


    @Test
    public void test01() {
        // https://www.bestbuy.com/ sayfasına gidin
        driver.get("https://www.bestbuy.com/");
        // sayfa Title'ini alın "Best" içerdigini test edin
        //driver.getTitle().contains("Best")
        Assert.assertTrue(driver.getTitle().contains("Best"));


        // BestBuy logosunun görüntülendigini test edin
        WebElement bestBuyLogo=driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(bestBuyLogo.isDisplayed());


        // Canada logosunun görüntülendigini test edin
        WebElement canadaLogo = driver.findElement(By.xpath("(//img[@alt='Canada'])[1]"));
        Assert.assertTrue(canadaLogo.isDisplayed());

    }















}
