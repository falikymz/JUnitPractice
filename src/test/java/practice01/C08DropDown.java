package practice01;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;
import java.util.List;
public class C08DropDown extends TestBase {
    @Test
    public void test01() {
        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/");
        // dropdown'dan "Baby" secenegini secin
        WebElement ddm=driver.findElement(By.id("searchDropdownBox"));
        Select select=new Select(ddm);
        select.selectByVisibleText("Baby");
        // sectiginiz option'i yazdirin
        System.out.println(select.getFirstSelectedOption().getText());
        // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin
        List<WebElement> optionList=select.getOptions();
        System.out.println(optionList.size());
        Assert.assertEquals(28,optionList.size());
        // dropdown'daki optionların tamamını yazdırın
        int sayac=1;
        for (WebElement each : optionList) {
            System.out.println(sayac+". opsiyon : "+each.getText());
            sayac++;
        }
    }
}