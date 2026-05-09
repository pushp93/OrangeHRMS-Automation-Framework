package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import dataproviders.DataProviders;
import pages.LoginPage;

public class LoginTest extends BaseTest {
	
	
	
	  @Test(dataProvider = "loginData",
	          dataProviderClass = DataProviders.class)

	    public void loginTest(String username, String password,String expectedResult) {

	        LoginPage loginPage = new LoginPage(driver);

	        loginPage.login(username, password);
	        
	        
	     // VALID LOGIN ASSERTION
	        if(expectedResult.equalsIgnoreCase("Valid")) {

	            Assert.assertTrue(
	                    loginPage.isDashboardDisplayed(),
	                    "Valid login test failed");

	            System.out.println("Valid Login Passed");
	        }

	        // INVALID LOGIN ASSERTION
	        else if(expectedResult.equalsIgnoreCase("Invalid")) {

	            String actualMessage =
	                    loginPage.getErrorMessage();

	            Assert.assertEquals(
	                    actualMessage,
	                    "Invali credentials");

	            System.out.println("Invalid Login Passed");
	    }
	}
	
}
	
	
	
	

