package practice01;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02 extends TestBase {


    @Test
    public void name() {
        // https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

        // arama kutusunun, tagName'inin 'input' oldugunu test ediniz
      WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
      String actualAmazonTagName = searchBox.getTagName();
      Assert.assertEquals("input",actualAmazonTagName);


      // arama kutusunun, name attribute'nun degerinin 'field-keywords' oldugunu test edin
       String actualAmazonAttribute = searchBox.getAttribute("name");
        Assert.assertEquals("field-keywords",actualAmazonAttribute);

    }

}
