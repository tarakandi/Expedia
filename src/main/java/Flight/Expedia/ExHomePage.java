package Flight.Expedia;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExHomePage 
{
	public WebDriver driver;
	
	public ExHomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By flights = By.xpath("(//span[@class='uitk-tab-text'])[2]");
	By roundTrip = By.xpath("//span[contains(text(), 'Roundtrip')]");
	By leavingFrom = By.xpath("//*[@aria-label='Leaving from']");
	By selectFrom = By.xpath("(//button[@data-stid = "
			+ "'location-field-leg1-origin-result-item-button'])[1]");
	By goingTo = By.xpath("//*[@aria-label='Going to']");
	By selectTo = By.xpath("(//button[@data-stid = "
			+ "'location-field-leg1-destination-result-item-button'])[1]");
	By departingDate = By.id("d1-btn");
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
	
	public void enterLeavingFrom(String from)
	{
		driver.findElement(leavingFrom).sendKeys(from);
		driver.findElement(selectFrom).click();

	}
	
	/*public void enterOrigin(String from)
	{
		driver.findElement(origin).sendKeys(from);
		driver.findElement(selectFrom).click();
	}*/
	
	public void enterGoingTo(String dest)
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
