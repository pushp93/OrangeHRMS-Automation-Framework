package pages;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {

	    WebDriver driver;
	    WebDriverWait wait;

	    // Constructor
	    public LoginPage(WebDriver driver) {

	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    }
	    
	 // Locators

	    @FindBy(xpath = "//input[@name ='username']")
	    WebElement txtUsername;

	    @FindBy(xpath = "//input[@name ='password']")
	    WebElement txtPassword;

	    @FindBy(xpath = "//button[@type='submit']")
	    WebElement btnLogin;

	    @FindBy(xpath = "//h6[text()='Dashboard']")
	    WebElement dashboardText;

	    @FindBy(xpath = "//p[contains(@class,'oxd-alert-content-text')]")
	    WebElement errorMessage;
	    // Actions / Methods
	
	    public void enterUsername(String username) {

	    	wait.until(ExpectedConditions.visibilityOf(txtUsername));
	        txtUsername.clear();
	        txtUsername.sendKeys(username);
	    }

	    public void enterPassword(String password) {
	   
	        wait.until(ExpectedConditions.visibilityOf(txtPassword));
	        txtPassword.clear();
	        txtPassword.sendKeys(password);
	    }

	    public void clickLoginButton() {
	    	
	    	wait.until(ExpectedConditions.elementToBeClickable(btnLogin));
	        btnLogin.click();
	    }

	    public void login(String username, String password) {

	        enterUsername(username);
	        enterPassword(password);
	        clickLoginButton();
	    }

	    public boolean isDashboardDisplayed() {
	    	
	    	wait.until(ExpectedConditions.visibilityOf(dashboardText));
	        return dashboardText.isDisplayed();
	    }

	    public String getErrorMessage() {

	    	wait.until(ExpectedConditions.visibilityOf(errorMessage));
	        return errorMessage.getText();
	    }
	}
