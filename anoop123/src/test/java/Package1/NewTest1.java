package Package1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class NewTest1 
{
  	WebDriver wd ;
  @BeforeTest
  public void beforeTest() 
  {
	  	System.setProperty("webdriver.chrome.driver", "C:\\selenium-java-4.7.0\\chromedriver.exe");
	  	wd = new ChromeDriver();
		wd.manage().window().maximize();
		wd.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
  }
  @Test
  public void f()
  {
	  String str = wd.getTitle();
		String expected_Title ="OrangeHRM1";
		org.testng.Assert.assertEquals(str, expected_Title);
  }
  @AfterTest
  public void afterTest()
  {
  }
}
