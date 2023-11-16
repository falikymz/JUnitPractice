package utilities;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestBase {
   public WebDriver driver;

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

}
