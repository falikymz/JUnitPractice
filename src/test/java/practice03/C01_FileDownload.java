package practice03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.devtools.v117.input.Input;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C01_FileDownload extends TestBase {

    @Test
    public void test01() {
        String dynamicPath= System.getProperty("user.home")+"/Downloads/some-file.txt";
        Path path= Paths.get(dynamicPath);

        try{
            Files.delete(path);
            System.out.println("dosya silindi");
        }catch (IOException e){
            System.out.println("dosya bulunamadı");
        }

        // 'https://the-internet.herokuapp.com/download' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/download");

           // some-file.txt dosyasini indirelim
        driver.findElement(By.linkText("some-file.txt")).click();

        // dosyanin bilgisayarınızda Downloads(indirilenler)'a basariyla indirilip indirilmedigini test ediniz
        waitForSecond(2);

        Assert.assertTrue(Files.exists(Path.of(dynamicPath)));
    }
}
