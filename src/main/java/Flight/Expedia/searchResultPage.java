package Flight.Expedia;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class searchResultPage 
{
public WebDriver driver;
	
	public searchResultPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By destTrip = By.xpath("(//div[@class='uitk-type-heading-600'])[1]");
	By continueButton = By.xpath("//button[@data-test-id='select-button']");
	
	public void clickDestTrip()
	{
		driver.findElement(destTrip).click();
	}
	
	public void clickContinueButton()
	{
		driver.findElement(continueButton).click();
	}

}
