package Flight.Expedia;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class checkOutPage 
{
	
public WebDriver driver;
	
	public checkOutPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By checkOutButton = By.xpath("//button[@data-test-id='goto-checkout-button']");
	
	public void clickcheckOutButton()
	{
		driver.findElement(checkOutButton).click();
	}

}
