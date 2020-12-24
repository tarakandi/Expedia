package Flight.Expedia;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageExample {
	 public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException 
	{
		 
		 String dir = System.getProperty("user.dir");
		 String url = "https://www.expedia.com/";
		 
		System.setProperty("webdriver.chrome.driver", dir+"/Driver/chromedriver");
		driver = new ChromeDriver();
			
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15000, TimeUnit.MILLISECONDS);
		
		PageExample pe = new PageExample();
		pe.clickFlightTab();
		pe.clickRoundtrip();

		pe.clickLeavingFrom("JFK");
		//Thread.sleep(3000);
		pe.clickGoingTo("Dhaka");
		Thread.sleep(3000);


		pe.clickDepartingDate();
		Thread.sleep(3000);

		pe.selectDepartingDate("March", "18");
		Thread.sleep(3000);

		driver.quit();

		 

	}
	By flights = By.xpath("(//span[@class='uitk-tab-text'])[2]");
	By roundTrip = By.xpath("//span[contains(text(), 'Roundtrip')]");
	By leavingFrom = By.xpath("//*[@aria-label='Leaving from']");
	By origin = By.id("location-field-leg1-origin");
	By selectFrom = By.xpath("(//button[@data-stid = "
			+ "'location-field-leg1-origin-result-item-button'])[1]");
	By goingTo = By.xpath("//*[@aria-label='Going to']");
	By destination = By.id("location-field-leg1-destination");
	By selectTo = By.xpath("(//button[@data-stid = "
			+ "'location-field-leg1-destination-result-item-button'])[1]");
	By departingDate = By.xpath("(//button[@data-stid='open-date-picker'])[1]");
	By departingMonth = By.xpath("(//div[@class="
			+ "'uitk-new-date-picker-menu-months-container']/div/h2)[1]");
	//By departingDay = By.xpath("//div[@class='uitk-new-date-picker-menu-months-container']/div/table)[1]/tbody/tr[2]/td[5]/button");
	By doneButton = By.xpath("//span[contains(text(), 'Done')]");
	By nextButton = By.xpath("//div[@class='uitk-calendar']/div/button[2]");
	By searchButton = By.xpath("//button[@data-testid='submit-button']");
	
	
	public void clickFlightTab()
	{
		driver.findElement(flights).click();
	}
	
	public void clickRoundtrip()
	{
		driver.findElement(roundTrip).click();
	}
	
	public void clickLeavingFrom(String from)
	{
		driver.findElement(leavingFrom).sendKeys(from);
		driver.findElement(selectFrom).click();
	}
	
	
	public void clickGoingTo(String dest)
	{
		driver.findElement(goingTo).sendKeys(dest);
		driver.findElement(selectTo).click();
	}
	
	public void clickDepartingDate()
	{
		driver.findElement(departingDate).click();
	}
	
	public void selectDepartingDate(String month, String day)
	{

		Boolean statement = true;
		while(statement)
		{
			String calMonth = driver.findElement(departingMonth).getText();
			System.out.println(calMonth);
			String[] calMontharr = calMonth.split(" ");
			calMonth = calMontharr[0];
			System.out.println(calMonth);
		
			System.out.println(month.equalsIgnoreCase(calMonth));
			if(month.equalsIgnoreCase(calMonth))
			{
				driver.findElement(By.xpath(
					"(//div[@class='uitk-new-date-picker-menu-months-container']/div/table)[1]"
					+ "/tbody/tr["+1+"]/td["+4+"]/button")).click();
			
				driver.findElement(By.xpath(
					"(//div[@class='uitk-new-date-picker-menu-months-container']/div/table)[1]"
					+ "/tbody/tr["+4+"]/td["+5+"]/button")).click();
			
			statement = false;
			}
			else
			{
				driver.findElement(nextButton).click();

			}
		}
		
		driver.findElement(doneButton).click();
		
	}
	
	public void clickSearchButton()
	{
		driver.findElement(searchButton).click();
	}

}
