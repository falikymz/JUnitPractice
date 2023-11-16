package practice02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_Actions_IFrame extends TestBase {

    @Test
    public void test01() {

        // https://demo.automationtesting.in/Vimeo.html sayfasına gidiniz
        driver.get("https://demo.automationtesting.in/Vimeo.html");

        // ust bolumde bulunan Video menusunun acilmasi icin mouse'u bu menunun ustune getiriniz. Ve Vimeo kısmına tıklayınız.
        Actions actions =new Actions(driver);
       WebElement videoMenu = driver.findElement(By.xpath("//a[text()='Video']"));
        actions.moveToElement(videoMenu).perform();
        waitForSecond(2);

        // play tusuna basınız.
        WebElement iframe =driver.findElement(By.xpath("//iframe[@id='foo']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//*[@class='PlayButton_module_playIcon__fc6bec57']")).click();
        waitForSecond(3);

        // 'Automation Demo Site' yazısının gorunur oldugunu test ediniz
        driver.
                switchTo().
                defaultContent();

        WebElement homePageTitle = driver.
                findElement(By.xpath("//h1[text()='Automation Demo Site ']"));

        System.out.println("homePageTitle.getText() = " + homePageTitle.getText());

        Assert.
                assertTrue(homePageTitle.isDisplayed());



    }
}
