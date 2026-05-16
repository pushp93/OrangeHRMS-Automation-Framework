package listeners;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utils.ExtentManager;
import utils.ScreenshotUtil;
import base.BaseTest;




	public class TestListener implements ITestListener {
		
		ExtentReports extent =
		        ExtentManager.getInstance();

		    // Thread safe ExtentTest
		    ThreadLocal<ExtentTest> test =
		            new ThreadLocal<>();

		    @Override
		    public void onTestStart(ITestResult result) {

		        ExtentTest extentTest =
		                extent.createTest(result.getName());

		        test.set(extentTest);

		        System.out.println("Test Started : "
		                + result.getName());
		    }

		    @Override
		    public void onTestSuccess(ITestResult result) {

		        test.get().log(Status.PASS,
		                "Test Passed");

		        System.out.println("Test Passed : "
		                + result.getName());
		    }

		    @Override
		    public void onTestFailure(ITestResult result) {

		        String screenshotPath =
		                ScreenshotUtil.captureScreenshot(
		                        BaseTest.driver,
		                        result.getName());

		        test.get().log(Status.FAIL,
		                "Test Failed");

		        test.get().fail(result.getThrowable());

		        try {

		            test.get().addScreenCaptureFromPath(
		                    screenshotPath);

		        } catch (Exception e) {

		            e.printStackTrace();
		        }

		        System.out.println("Test Failed : "
		                + result.getName());
		    }

		    @Override
		    public void onTestSkipped(ITestResult result) {

		        test.get().log(Status.SKIP,
		                "Test Skipped");

		        System.out.println("Test Skipped : "
		                + result.getName());
		    }

		    @Override
		    public void onFinish(ITestContext context) {

		        extent.flush();

		        System.out.println("Execution Finished");
		    }
		}
