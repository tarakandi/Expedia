package Flight.Expedia;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class passengerInfoPage 
{
	
	public WebDriver driver;
	
	public passengerInfoPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By firstName = By.id("firstname[0]");
	By lastName = By.id("lastname[0]");
	By phoneNumber = By.id("phone-number[0]");
	By mgender = By.id("gender_male[0]");
	By fgender = By.id("gender_female[0]");
	By dobMonth = By.id("date_of_birth_month0");
	By dobDay = By.id("date_of_birth_day[0]");
	By dobYear = By.id("date_of_birth_year[0]");
	
	
	public void enterFirstname(String fname)
	{
		driver.findElement(firstName).sendKeys(fname);
	}
	
	public void enterLastName(String lname)
	{
		driver.findElement(lastName).sendKeys(lname);
	}
	
	public void enterPhoneNumber(String number)
	{
		driver.findElement(phoneNumber).sendKeys(number);
	}
	
	public void clickGender(String gender)
	{
		if(gender.equalsIgnoreCase("male"))
		{
			driver.findElement(mgender).click();
		}
		else
		{
			driver.findElement(fgender).click();
		}
	}
	
	public void selectDOB()
	{
		Select month = new Select(driver.findElement(dobMonth));
		Select day = new Select(driver.findElement(dobDay));
		Select year = new Select(driver.findElement(dobYear));
		
		month.selectByValue("03");
		day.selectByValue("07");
		year.selectByValue("1995");
			
	}

}
