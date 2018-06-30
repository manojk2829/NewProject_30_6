package base_DDF;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import excel_Util.Xls_Reader;
import extentReport.ExtentReport_DDF;

public class BaseTest {
	
	public WebDriver dr;
	public Properties pro;
	public Logger log=Logger.getLogger(BaseTest.class.getName());
	public ExtentReports ext=ExtentReport_DDF.getReporting();
	public ExtentTest test;
	public Xls_Reader xls;
	
	public BaseTest(){
		init();
		//xls=new Xls_Reader(pro.getProperty("ExcelPath"));
		xls=new Xls_Reader("D://report//Data_Test1.xlsx");
	    PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\properties_Package\\Log4j_Pro.properties");
	  }

     public void init(){
		if(pro==null){
			pro=new Properties();
			try{FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\properties_Package\\or.properties");
			pro.load(fis);}
			catch(Exception ex){
				System.out.println(ex.getMessage());
			}
		}
		System.out.println(pro.getProperty("Browser"));
      }
	
     public void wait(int s) {
    	 try {
    		 Thread.sleep(s*1000);
    	 }catch(Exception ex){
    		 System.out.println(ex.getMessage());
    	 }
     }
     
	public void openBro(String b){
		if(b.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "D://MANOJ//chromedriver.exe");
			dr=new ChromeDriver();
		}else{
			dr=new FirefoxDriver();
		}
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Browser Open " + pro.getProperty(b));
		log.info("URL entered in Browser -- > " + pro.getProperty("Browser"));
	}
	
	public void navigate(String url){
		dr.get(url);
		log.info("URL entered in Browser -- > " + pro.getProperty(url));
		test.log(LogStatus.INFO, "URL entered in Browser " + pro.getProperty(url));
		//System.out.println(pro.getProperty("appurl"));
	}
	
	public void screenshot(){
		Date d=new Date();
		String FN=d.toString().replace(":", "_").replace(" ", "_")+".jpg";
		File srcFile = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(srcFile, new File(System.getProperty("user.dir")+"report"+FN));
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		log.info("Screen shot capture done.");
		test.log(LogStatus.INFO, "Screenshot taken -- > " + test.addScreenCapture(System.getProperty("user.dir")+"report"+FN));
		System.out.println("Screen shot Done .....");
	}
}
