package Package1;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class DT 
{
	WebDriver wd;
	String URl ="https://demoqa.com/date-picker";
  
  @BeforeTest
  public void beforeTest()
  {
	  WebDriverManager.chromedriver().setup();
	  wd = new ChromeDriver();
	  wd.get(URl);
	  wd.manage().window().maximize();
  }

  @Test
  public void DateT() throws InterruptedException 
  {
	  wd.findElement(By.id("datePickerMonthYearInput")).clear();
	  Thread.sleep(1000);
	  //wd.findElement(By.id("datePickerMonthYearInput")).sendKeys("12/21/2022");
	  
	  
  }
  
  
  @AfterTest
  public void afterTest()
  {
	  
  }

}
