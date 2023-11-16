package practice01;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01Ilk {

    WebDriver driver;
    // "https://testpages.herokuapp.com/styled/calculator" adresine gidin
    // ilk kutucuga 20 giriniz
    // ikinci kutucuga 30 giriniz
    // calculate'e tıklayınız
    // sonucu yazdırınız
    // sayfayi kapatiniz


    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void name() {

        // "https://testpages.herokuapp.com/styled/calculator" adresine gidin
        driver.get("https://testpages.herokuapp.com/styled/calculator");

        // ilk kutucuga 20 giriniz
        driver.findElement(By.xpath("//input[@id='number1']")).sendKeys("20");

        // ikinci kutucuga 30 giriniz
        driver.findElement(By.xpath("//input[@id='number2']")).sendKeys("30");

        // calculate'e tıklayınız
        driver.findElement(By.xpath("//input[@id='calculate']")).click();

        // sonucu yazdırınız
        System.out.println(driver.findElement(By.xpath("//span[@id='answer']")).getText());
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
        driver.quit();
    }
}
