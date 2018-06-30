package base_DDF;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OpenBrowser {
	@Test
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "D://MANOJ//chromedriver.exe");
		WebDriver dr=new ChromeDriver();
		dr.navigate().to("http://google.com/");
		
	}

}
