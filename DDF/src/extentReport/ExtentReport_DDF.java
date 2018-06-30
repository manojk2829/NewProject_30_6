package extentReport;

import java.util.Date;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentReport_DDF {
	public static ExtentReports ext;
	public static ExtentReports getReporting() {
		if(ext==null) {
			Date d=new Date();
			String FN=d.toString().replace("_", " ").replace(":", "_")+".html";
			ext=new ExtentReports("D://report//"+FN,true,DisplayOrder.NEWEST_FIRST);
		}
		return ext;
	}

}
