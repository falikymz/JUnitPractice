package practice02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C01_WindowHandle extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        // 1- https://www.amazon.com sayfasina gidelim
        driver.get("https://amazon.com");
        driver.navigate().refresh();
        driver.navigate().refresh();
        String amazonHandle=driver.getWindowHandle();

        // 2- url'in 'amazon' icerdigini test edelim
        String actualAmazonUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualAmazonUrl.contains("amazon"));

        // 3- yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String bestBuyHandle = driver.getWindowHandle();

        // 4- title'in 'Best Buy' icerdigini test edelim
         String actualBestTitle = driver.getTitle();
         Assert.assertTrue(actualBestTitle.contains("Best Buy"));

        // 5- ilk sayfaya(amazon) donup sayfada java aratalım

        driver.switchTo().window(amazonHandle);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java", Keys.ENTER);

        // 6- arama sonuclarının 'Java' icerdigini test edelim
        Thread.sleep(200);
        WebElement resulText = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(resulText.getText().contains("java"));

        // 7- ikinci sayfaya(bestbuy) donelim
        driver.switchTo().window(bestBuyHandle);

        // 8- logonun gorundugunu test edelim
       WebElement logo = driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));
       Assert.assertTrue(logo.isDisplayed());



    }
}
