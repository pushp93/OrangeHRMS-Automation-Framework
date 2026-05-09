package utils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
  
	static ExtentReports extent;

    public static ExtentReports getExtentReports() {

        if(extent == null) {

            String path = System.getProperty("user.dir")
                    + "/reports/ExtentReport.html";

            ExtentSparkReporter reporter =
                    new ExtentSparkReporter(path);

            reporter.config().setReportName(
                    "OrangeHRM Automation Report");

            reporter.config().setDocumentTitle(
                    "Test Execution Report");

            extent = new ExtentReports();

            extent.attachReporter(reporter);

            extent.setSystemInfo(
                    "Tester",
                    "Pushpendra");

            extent.setSystemInfo(
                    "Environment",
                    "QA");
        }

        return extent;
    }
}
