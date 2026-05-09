package base;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;


public class BaseTest {
	
	public static WebDriver driver;

    @BeforeMethod
    public void setup() {

         
  
    	
    	  String browser = ConfigReader.getProperty("browser");

          // Launch Browser
          if(browser.equalsIgnoreCase("chrome")) {

              WebDriverManager.chromedriver().setup();
              driver = new ChromeDriver();

          } else if(browser.equalsIgnoreCase("edge")) {

              WebDriverManager.edgedriver().setup();
              driver = new EdgeDriver();
          }
          driver.get(ConfigReader.getProperty("url"));
        // Maximize Window
        driver.manage().window().maximize();

        // Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open Application
   
    }

    @AfterMethod
    public void tearDown() {

        if(driver != null) {
            driver.quit();
        }
    }
}


