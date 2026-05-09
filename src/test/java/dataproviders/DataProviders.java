package dataproviders;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import utils.ExcelUtils;

public class DataProviders {
	
	  @DataProvider(name = "loginData")
	    public Object[][] getLoginData() throws IOException {

	        return ExcelUtils.getExcelData(
	                "LoginData.xlsx",
	                "logindataset");
	    }
	}
