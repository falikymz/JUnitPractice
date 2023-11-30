package practice03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C05_Screenshot extends TestBase {
    @Test
    public void test01() {
        // https://www.teknosa.com/ adresine gidin
        driver.get("https://www.teknosa.com/");

        // arama cubuguna oppo yazip enter'a basınız
        WebElement searchBox=driver.findElement(By.id("search-input"));
        searchBox.sendKeys("oppo", Keys.ENTER);

        // sonuc yazısını yazdiriniz
        WebElement resultText = driver.findElement(By.cssSelector(".plp-panel-block1"));
        System.out.println(resultText.getText());
        // ilk urunun fotografını cekin
        WebElement firstProduct = driver.findElement(By.xpath("//div[@data-product-id='125078660']"));

        //src/test/java/ScreenShots
        String date= DateTimeFormatter.ofPattern("yyMMdd-HHmmss").format(LocalDateTime.now());
        String path="src\\test\\java\\ScreenShots\\"+date+".jpeg";

        try {
            Files.write(Paths.get(path),firstProduct.getScreenshotAs(OutputType.BYTES));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



        // cikan ilk urune tiklayiniz
        try {
            driver.findElement(By.xpath("//div[@id='ins-editable-button-1580496494']")).click();
            driver.findElement(By.id("31cd32c1-b03e-4463-948d-1347667e64a4")).click();
        } catch (Exception e) {
            System.out.println("Cookie çıkmadı");
        }
        firstProduct.click();

        // sepete ekleyiniz
        driver.findElement(By.xpath("//button[@id ='addToCartButton' and @type='submit']")).click();

        // sepetim'e git tilayiniz
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();

        // Siparis Ozeti kısmındaki toplam tutarın ekran goruntusunu alınız ve yazdırınız
        WebElement orderSummary =driver.findElement(By.xpath("//div[@class='checkout-sidebar']"));
        try {
            Files.write(Paths.get(path),orderSummary.getScreenshotAs(OutputType.BYTES));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(orderSummary.getText());

        // Alisverisi tamamlayiniz
        driver.findElement(By.xpath("//a[@class='btn btn-primary js-checkout-controls']")).click();

        // "Teknosa'ya hos geldiniz" webelementinin gorundugunu test ediniz
        WebElement welcomeText =driver.findElement(By.xpath("//div[@class='lrp-title']"));
        Assert.assertTrue(welcomeText.isDisplayed());
    }
}
