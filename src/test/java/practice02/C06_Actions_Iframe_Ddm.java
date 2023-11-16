package practice02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.Set;

public class C06_Actions_Iframe_Ddm extends TestBase {

    @Test
    public void test01() {

        // https://amazon.com adresine gidiniz
        driver.get("https://amazon.com");
        waitForSecond(2);
        driver.navigate().refresh();
        String amazonHandle= driver.getWindowHandle();
        // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
        Actions actions =new Actions(driver);
        WebElement languageButton = driver.findElement(By.xpath("//span[@class='icp-nav-link-inner']"));
        actions.moveToElement(languageButton).perform();
        waitForSecond(2);

        // Change country/region butonuna basiniz
       WebElement changeCountryButton = driver.findElement(By.xpath("(//div[text()='Change country/region.'])[1]"));
        changeCountryButton.click();
        waitForSecond(2);
        String handle2=driver.getWindowHandle();

        //DDM handle ederken
        //1- ddm locate etmek
        //2- select objesi olusturmak
        //3- select objesi ile opsiyon secmek
        WebElement ddm=driver.findElement(By.id("icp-dropdown"));

        Select select=new Select(ddm);

        // United States dropdown'undan 'Turkey (Türkiye)' seciniz
        select.selectByVisibleText("Turkey (Türkiye)");
        waitForSecond(3);

        driver.findElement(By.xpath("//span[text()='Changing country/region website']")).click();
        //acılan dil menusu kapanmadıgı için go to website butonu gorunmuyor
        //menuyu kapatıp butonu görunur hale getirmek için driveri sayfada herhangi bir yere tıklattım

        // Go to website butonuna tiklayiniz
        driver.findElement(By.className("a-button-input")).click();
        waitForSecond(2);
        String handle3=driver.getWindowHandle();

        // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz

        System.out.println("amazonHandle = " + amazonHandle);
        System.out.println("handle2 = " + handle2);
        System.out.println("handle3 = " + handle3);

        Set<String> whSet=driver.getWindowHandles();
        System.out.println(whSet);

        String amazonHandle2=whSet.toArray()[1].toString();

         /*
       for (String handle:whSet) {

            if (!handle.equals(amazonHandle)){
                amazonHandle2=handle;
            }

        }*/

        driver.switchTo().window(amazonHandle2);
        String title= driver.getTitle();
        Assert.assertTrue(title.contains("Elektronik"));


    }
}
