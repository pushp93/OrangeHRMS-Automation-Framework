package utils;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WaitUtils {

	WebDriverWait wait;

    public WaitUtils(WebDriver driver) {

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitForElement(WebElement element) {

        wait.until(ExpectedConditions.visibilityOf(element));
    }
}

