package utilities;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class TestBase {
   protected WebDriver driver;

   @Before
   public void setUp() throws Exception {
      driver=new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
   }

   @After
   public void tearDown() throws Exception {
      driver.quit();
   }

   public void waitForSecond (int saniye){
      try {
         Thread.sleep(saniye*1000);
      } catch (InterruptedException e) {
         throw new RuntimeException(e);
      }
   }

   public void pageScreenShot(String pageName){
      String date= DateTimeFormatter.ofPattern("yyMMdd-HHmmss").format(LocalDateTime.now());
      String path="src/test/java/ScreenShots/"+date+pageName+".jpeg";
      TakesScreenshot ts=(TakesScreenshot) driver;
      try {
         Files.write(Paths.get(path),ts.getScreenshotAs(OutputType.BYTES));
      } catch (IOException e) {
         throw new RuntimeException(e);
      }
   }



}
