package utils;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {
            
	public static String captureScreenshot(WebDriver driver,
            String testName) {

				String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());	
				String path = System.getProperty("user.dir")
				+ "/src/test/resources/screenshots/" + testName + "_" + timeStamp + ".png";
				
				TakesScreenshot ts = (TakesScreenshot) driver;
				
				File src = ts.getScreenshotAs(OutputType.FILE);
				
				File dest = new File(path);
				
				try {
					System.out.println("Screenshot Path : " + path);
				FileUtils.copyFile(src, dest);
				
				System.out.println("Screenshot saved : "
	                    + path);
				
				} catch (IOException e) {
				
				e.printStackTrace();
				}
				
				return path;
				}
				
				}
