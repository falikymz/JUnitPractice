package practice03;

import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C04_Screenshot extends TestBase {

    @Test
    public void name() throws IOException {
        // https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com");
        waitForSecond(1);
        driver.navigate().refresh();

        // arama kutusuna Nutella yazip aratın
        WebElement searchBox =driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("nutella", Keys.ENTER);

        // ilk ürüne tıklayın
        driver.findElement(By.xpath("//a[@class='a-link-normal s-no-outline']")).click();

        // tüm sayfanın fotografını cekin

        String date= DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss").format(LocalDateTime.now());
        String ssPath="src\\test\\java\\ScreenShots\\"+date+"amazon.jpeg";
        TakesScreenshot ts =(TakesScreenshot) driver;
        Files.write(Paths.get(ssPath),ts.getScreenshotAs(OutputType.BYTES));
    }

    @Test
    public void test03() {
        // https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com");
        waitForSecond(1);
        driver.navigate().refresh();

        // arama kutusuna Nutella yazip aratın
        WebElement searchBox =driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("nutella", Keys.ENTER);

        // ilk ürüne tıklayın
        driver.findElement(By.xpath("//a[@class='a-link-normal s-no-outline']")).click();

        // tüm sayfanın fotografını cekin
        pageScreenShot("ilk ürün");
    }
}
