package Package1;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Autocomplete 
{
	WebDriver wd;
	String URl ="https://demoqa.com/auto-complete";
	
  @BeforeTest
  public void beforeTest() 
  {
	  WebDriverManager.chromedriver().setup();
	  wd = new ChromeDriver();
	  wd.get(URl);
	  wd.manage().window().maximize();
  }
  
  @Test
  public void ac() throws InterruptedException
  {
	  JavascriptExecutor js = (JavascriptExecutor)wd;
	//js.executeScript("document.getElementsByClassName('auto-complete__control css-yk16xz-control')[0]).click()");
	  wd.findElement(By.xpath("//*[@class='auto-complete__control css-yk16xz-control'])[0]")).sendKeys("B");
	  Thread.sleep(3000);
	  //get the list of suggestet inputs 
	  List <WebElement> options = wd.findElements(By.cssSelector("li.ui-menu-item a"));
	  //loop through list of inputs an click specific Text + break out the loop
	  for ( WebElement option : options ) {
	    if (option.getText().equalsIgnoreCase("Blue")) {  
	       option.click();
	       break;
	     }
	  }
  }
  
  @AfterTest
  public void afterTest() {
  }

}
