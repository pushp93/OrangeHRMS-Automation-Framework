package tests;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import listeners.TestListener;
import base.BaseTest;
import dataproviders.DataProviders;
import pages.LoginPage;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {
	
	
	
	@Test(dataProvider = "loginData",
		      dataProviderClass = DataProviders.class)

		public void loginTest(String username,
		                      String password,
		                      String expectedResult) {

		    test = extent.createTest(
		            "Login Test - " + username + " / " + expectedResult);

		    test.info("Browser launched");

		    LoginPage loginPage = new LoginPage(driver);

		    test.info("Entering username");
		    test.info("Entering password");

		    loginPage.login(username, password);

		    test.info("Clicked login button");

		    // VALID LOGIN ASSERTION
		    if(expectedResult.equalsIgnoreCase("Valid")) {

		        Assert.assertTrue(
		                loginPage.isDashboardDisplayed(),
		                "Valid login test failed");

		        test.pass("Valid Login Passed");

		        System.out.println("Valid Login Passed");
		    }

		    // INVALID LOGIN ASSERTION
		    else if(expectedResult.equalsIgnoreCase("Invalid")) {

		        String actualMessage =
		                loginPage.getErrorMessage();

		        Assert.assertEquals(
		                actualMessage,
		                "Invalid credentials");

		        test.pass("Invalid Login Passed");

		        System.out.println("Invalid Login Passed");
		    }
		}
	
}
	

