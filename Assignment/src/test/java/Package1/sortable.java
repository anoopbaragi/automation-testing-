package Package1;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class sortable
{
	WebDriver wd;
	String URl ="https://demoqa.com/sortable";
  @BeforeTest
  public void beforeTest() 
  {
	  WebDriverManager.chromedriver().setup();
	  wd = new ChromeDriver();
	  wd.get(URl);
	  wd.manage().window().maximize();
  }

  @Test
  public void so() throws InterruptedException
  {
	  JavascriptExecutor js = (JavascriptExecutor)wd;
	  Actions act =  new Actions(wd);
	  wd.findElement(By.id("demo-tab-list")).click();
	  WebElement we = wd.findElement(By.xpath("//*[@class='list-group-item list-group-item-action'][1]"));
	  //WebElement we1 = wd.findElement(By.xpath("//*[@class='list-group-item list-group-item-action'][7]"));
	  act.clickAndHold(we).build().perform();
	  act.moveToElement(we, -50, 0).build().perform();
	  act.click(we).build().perform();
	  js.executeScript("window.scrollBy(0,100)");
	  Thread.sleep(5000);
	  wd.findElement(By.id("demo-tab-grid")).click();
	  Thread.sleep(3000);
	  WebElement we1 = wd.findElement(By.xpath("//*[@class='list-group-item list-group-item-action'][3]"));
	  //WebElement we1 = wd.findElement(By.xpath("//*[@class='list-group-item list-group-item-action'][7]"));
	  act.clickAndHold(we1).build().perform();
	  act.moveToElement(we1, -50, 0).build().perform();
	  act.click(we1).build().perform();
  }
  
  @AfterTest
  public void afterTest() 
  {
	  
  }

}
