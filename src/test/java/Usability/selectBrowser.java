package Usability;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class selectBrowser 
{
 public static WebDriver driver;
 static String dir = System.getProperty("user.dir");

 
  @BeforeClass
  public void beforeClass() 
  {
	  String browser = "Firefox";
	  String url = "https://www.expedia.com";
	  
	  if(browser.equalsIgnoreCase("firefox"))
	  {
		  System.setProperty("webdriver.gecko.driver", dir+"/Driver/geckodriver");
		  driver = new FirefoxDriver();
		  
		  driver.get(url);
		  driver.manage().window().maximize();
	  }
	  
	  if(browser.equalsIgnoreCase("chrome"))
	  {
		  System.setProperty("webdriver.chrome.driver", dir+"/Driver/chromedriver");
		  driver = new ChromeDriver();
		  
		  driver.get(url);
		  driver.manage().window().maximize();
	  }
  }

  @AfterClass
  public void afterTest() 
  {
	  driver.quit();
  }

}
