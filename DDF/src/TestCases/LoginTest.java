package TestCases;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base_DDF.BaseTest;
import excel_Util.Readdata;

public class LoginTest extends BaseTest{
	
	String TC="Login";
	String TestsheetName="sheet1";
	
	@Test(dataProvider="getData")
	public void Login_Orange(Hashtable<String,String> data) {
		
		test=ext.startTest("Login Test Get Login to Start execution......");
		test.log(LogStatus.INFO, "Login to Orange");
		openBro(pro.getProperty("Browser"));
		String str = "manoj-";
		String str_Last="kushwaha";
		String tString1 = data.get("Browser");
		String tString2 = data.get("User");
		String tString3 = data.get("Password");
		System.out.println(tString1+str+tString2+tString3+str_Last);
		
		
		//navigate("appurl");
		//screenshot();
	}
	
	@DataProvider
	public Object[][] getData(){
		return Readdata.getExcelTestData(xls, TC,TestsheetName);
	}

    @AfterMethod
    public void tearDown() {
    	ext.endTest(test);
    	ext.flush();
        wait(5);
        dr.quit();
    }
}
