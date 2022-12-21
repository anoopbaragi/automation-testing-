package Package2;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Extent_Report 
{
	ExtentReports extent;
	ExtentTest logger;
	WebDriver wb;
  @BeforeTest
  public void beforeTest()
  {
	  extent = new ExtentReports(System.getProperty("user.dir")+ "/test-output/anoop.html",true);
	  extent.loadConfig(new File(System.getProperty("user.dir")+ "src\\test\\java\\extent-config.xml"));
	  WebDriverManager.chromedriver().setup();
	  wb = new ChromeDriver();
  }
	@Test
  public void ohrm()
  {
	  logger = extent.startTest("Demo");
	  wb.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
  }
	
	@AfterTest
	public void afterTest()
	{
		
	}
}
