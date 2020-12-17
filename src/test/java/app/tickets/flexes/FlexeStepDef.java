package app.tickets.flexes;

import app.pages.Home;
import io.cucumber.java.en.Then;
import utilities.ExtentReport;
import utilities.Screenshot;
import utilities.TestBase;
import utilities.Verification;

import java.io.IOException;

public class FlexeStepDef
{


	@Then("^check \"([^\"]*)\" and \"([^\"]*)\" card based on \"([^\"]*)\"$")
	public void check_and_card_based_on(String FlexEn, String FlexAr, String status) throws Throwable
	{
		try {
			ExtentReport.startTC("Check flex card based on flex his status (" +status+")");
				Home.pressflexcardEn();
			if (status.equals("has_flexes"))
				Verification.verifyElementText(Home.remaingvalue, FlexEn, FlexAr, "flexes are correctly appeard", "Wrong flexes value appeared");
			if (status.equals("expired"))
				Verification.verifyElementText(Home.contentscript, FlexEn, FlexAr, "Expired flexes script correctly appeard", "Wrong script  appeared");
			Screenshot.saveScreenshot(TestBase.driver, "Check flex card based on flex his status (" +status+")"); //take screenshot

			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
