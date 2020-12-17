package app.tickets.inaddons;

import app.pages.Home;
import io.cucumber.java.en.Then;
import utilities.ExtentReport;
import utilities.Screenshot;
import utilities.TestBase;
import utilities.Verification;

import java.io.IOException;

public class InAddonStepDef
{
	

	@Then("^Check on In addon  \"([^\"]*)\" based on \"([^\"]*)\"$")
	public void check_on_In_addon_based_on(String cardstate, String userType) throws Throwable
	{
		try {
			ExtentReport.startTC("Check joker card incase "+userType+" ");
			if( cardstate.equals("Appear") && userType.equals("In"))
			{
				Verification.verifyElement( Home.jokercard, "Card is visible", "Card is not visible");
			}
			else if(cardstate.equals("not_Appear") && userType.equals("mass"))
			{
				Verification.verifyElementNotExists(Home.jokercard,"Card is not visible", "Card is visible");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		Screenshot.saveScreenshot(TestBase.driver, "Check card incase "+userType+"  "); //take screenshot
  
	}

	
}
