package Package1;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.awt.AWTException;
import java.awt.Robot;

import javax.swing.event.MenuKeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
  public void DateT() throws InterruptedException, AWTException 
  {
	  wd.findElement(By.id("datePickerMonthYearInput"));
	  Thread.sleep(1000);
	  JavascriptExecutor  js = (JavascriptExecutor)wd;
	  Robot rb = new Robot();
	  js.executeScript("document.getElementById('datePickerMonthYearInput').click()");
	  Thread.sleep(3000);
	  js.executeScript("document.getElementById('datePickerMonthYearInput').value='12/20/2022'");
	  Thread.sleep(2000);
	  rb.keyPress(MenuKeyEvent.VK_ESCAPE);
	  Thread.sleep(3000);
	  js.executeScript("document.getElementById('dateAndTimePickerInput').click()");
	  Thread.sleep(3000);
	  js.executeScript("document.getElementById('dateAndTimePickerInput').value='March 25 2022'");
	  wd.findElement(By.xpath("//*[@class='react-datepicker__time-box']/ul/li[50]")).click();
	  rb.keyPress(MenuKeyEvent.VK_ESCAPE);  
  }
  
  
  @AfterTest
  public void afterTest()
  {
	  
  }

}
