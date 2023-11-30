package practice03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_FileUpload extends TestBase {
    // masaustunde bir deneme dosyası olusturun. İcine Merhaba Dunya yazınız.
    // 'https://cgi-lib.berkeley.edu/ex/fup.html' adresine gidiniz
    // 'Notes about the file' kısmına 'Benim Dosyam' notunu yazınız.
    // 'Dosya Seç' kısmına deneme dosyasını yükleyiniz.
    // 'Press' butonuna basın
    // Dosya notunun 'Benim Dosyam' oldugunu test ediniz
    // Dosya iceriginin 'Merhaba Dunya' icerdigini test ediniz.


    @Test
    public void test01() {
        driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");

        driver.findElement(By.xpath("//input[@name='note']")).sendKeys("Benim Dosyam");

        //"C:\Users\alika
        String dynamicPath=System.getProperty("user.home")+"\\Desktop\\Batch189.txt";

        driver.findElement(By.xpath("//input[@name='upfile']")).sendKeys(dynamicPath);

        driver.findElement(By.xpath("//input[@value='Press']")).click();

        WebElement dosyaNotu=driver.findElement(By.tagName("blockquote"));
        waitForSecond(2);
        Assert.assertEquals("Benim Dosyam",dosyaNotu.getText());

        WebElement dosyaIcerik=driver.findElement(By.tagName("pre"));
        Assert.assertEquals("Hello World!",dosyaIcerik.getText());
    }
}
