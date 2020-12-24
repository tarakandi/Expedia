package Flight;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Flight.Expedia.ExHomePage;
import Flight.Expedia.checkOutPage;
import Flight.Expedia.passengerInfoPage;
import Flight.Expedia.searchResultPage;
import Usability.selectBrowser;

public class FlightTest extends selectBrowser{
 
	@Parameters({"origin", "destination", "month"})
  @Test
  public void searchFlight(String origin, String destination, String month) throws InterruptedException 
  {
	  driver.manage().timeouts().implicitlyWait(8000, TimeUnit.MILLISECONDS);
	  ExHomePage ehp = new ExHomePage(driver);
	  ehp.clickFlightTab();
	  Thread.sleep(2000);
	  ehp.clickRoundtrip();
	  //Thread.sleep(2000);

	  ehp.enterLeavingFrom(origin);
	  ehp.enterGoingTo(destination);


	  ehp.clickDepartingDate();
	  Thread.sleep(2000);

	  ehp.selectDepartingDate(month, "03");
	  ehp.clickSearchButton();  
  }
  
  @Test
  public void getFirstFlight()
  {
	  driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	  //String parentWindow = driver.getWindowHandle();
	  searchResultPage srp = new searchResultPage(driver);
	  srp.clickDestTrip();
	  srp.clickContinueButton();
	  
	  srp.clickDestTrip();
	  srp.clickContinueButton();
	  
	  for(String winHandle: driver.getWindowHandles())
	  {
		  driver.switchTo().window(winHandle);
	  }
	  
	  checkOutPage cop = new checkOutPage(driver);
	  cop.clickcheckOutButton();
	  
  }
  
  @Parameters({"firstName", "lastName", "phone", "gender"})
  @Test
  public void inputPassengerInfo(String firstName, String lastName, String phone, String gender)
  {
	  driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	  passengerInfoPage pip = new passengerInfoPage(driver);
	  
	  pip.enterFirstname(firstName);
	  pip.enterLastName(lastName);
	  pip.enterPhoneNumber(phone);
	  pip.clickGender(gender);
	  pip.selectDOB();
	  
	  try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
  }
  
  
}
