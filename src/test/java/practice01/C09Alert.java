package practice01;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import utilities.TestBase;
public class C09Alert extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //http://demo.guru99.com/test/delete_customer.php adresine gidin
        driver.get("http://demo.guru99.com/test/delete_customer.php");
        //customer id kısmına 53920 yazın
        driver.findElement(By.name("cusid")).sendKeys("53920");
        //submit butonuna tıklayın
        driver.findElement(By.name("submit")).click();
        //cıkan alert mesajını yazdırın
        Alert alert=driver.switchTo().alert();
        System.out.println(alert.getText());
        //alerti kabul edin
        Thread.sleep(1500);
        alert.accept();
        Thread.sleep(1500);
        //cıkan 2. alert mesajını yazdırın
        System.out.println(alert.getText());
        //cıkan 2. alerti kabul edin
        alert.accept();
        Thread.sleep(1500);
    }
}