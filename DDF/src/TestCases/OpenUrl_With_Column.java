package TestCases;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base_DDF.BaseTest;
import excel_Util.Readdata;

public class OpenUrl_With_Column extends BaseTest{

	String sheetName="sheet1";
	String Result_sheetName="sheet2";
	String TestCase_Name = "Result";
	String url="https://google";
	String last= "/";
	String colName="Result";

	@DataProvider
	public Object[][] getData(){
		return Readdata.getExcelTestData(xls, TestCase_Name,Result_sheetName);
	}
	
	@BeforeTest
	public void writeTestURL() {
		//xls=new Xls_Reader("D://report//Data_Test.xlsx");
		int rowC=xls.getRowCount(sheetName);
		int colC=xls.getColumnCount(sheetName);
		System.out.println(colC);
		System.out.println(rowC);
		for(int r=3;r<=rowC;r++){
			String fullurl=url+xls.getCellData(sheetName, 1, r)+xls.getCellData(sheetName, 2, r);//+last;
			xls.setCellData(Result_sheetName, colName, r, "");
			xls.setCellData(Result_sheetName, colName, r, fullurl);
			System.out.println(xls.getCellData(sheetName, colName, r));
	}
}
	
	@Test(dataProvider="getData")
	public void Login_Orange(Hashtable<String,String> data){
		test=ext.startTest("Login Test Get Login to Start execution......");
		test.log(LogStatus.INFO, "Login to Orange");
		openBro(pro.getProperty("Browser"));
		int rowC_Result=xls.getRowCount(Result_sheetName);
		System.out.println("========================================================");
		System.out.println(rowC_Result);
		//int colC=xls.getColumnCount(Result_SheetName);
		for(int r=2;r<=rowC_Result;r++){
			System.out.println(xls.getCellData(Result_sheetName, colName, r));
		}
		navigate(data.get("URL"));
}
	
    @AfterMethod
    public void tearDown() {
    	ext.endTest(test);
    	ext.flush();
        wait(5);
        dr.quit();
    }

}
