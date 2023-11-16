package practice02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions extends TestBase {





    @Test
    public void test01() throws InterruptedException {

        // https://demoqa.com/droppable adresine gidiniz
        driver.get("https://demoqa.com/droppable");

        // 'Drag me' kutusunu tutup 'Drop here' kutusunun ustune birakiniz
        Actions actions =new Actions(driver);
        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.id("droppable"));

        actions.dragAndDrop(drag,drop).perform();
        Thread.sleep(300);

        // 'Drop here' yazisi yerine 'Dropped!' oldugunu test ediniz
        WebElement droppedText =  driver.findElement(By.xpath("//p[.='Dropped!']"));
        Assert.assertTrue(droppedText.isDisplayed());

    }
}
