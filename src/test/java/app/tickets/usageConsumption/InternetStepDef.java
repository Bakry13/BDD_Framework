package app.tickets.usageConsumption;

import app.pages.Home;
import app.pages.Login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.ExtentReport;
import utilities.Screenshot;
import utilities.TestBase;
import utilities.Verification;

import java.io.IOException;

public class InternetStepDef {
	
	@Given("^user logged in using jwt using \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_logged_in_using_jwt_using_and(String msisdn, String password) throws Throwable
	{
		try {
		 Login.validLogin(msisdn, password); //login
	    } catch (Exception e) {
		e.printStackTrace();
	    }    
	}
	
	

	@Then("^check on \"([^\"]*)\" and \"([^\"]*)\" card   Based on \"([^\"]*)\"$")
	public void check_on_and_card_Based_on(String internet_en, String internet_ar, String precondition) throws Throwable
	{
		try {
			ExtentReport.startTC("Check internet card based on precondition  (" +precondition+")");
			Home.pressintcardEn();
			if (precondition.equals("has no mi"))
			{
				Verification.verifyElementText(Home.contentscript, internet_en, internet_ar, "script correctly appeard", "Wrong script appeared");
				Screenshot.saveScreenshot(TestBase.driver, "Check internet  card & script appear incase user has no internet bundle"); //take screenshot			
			}
			
			if (precondition.equals("has extreme"))
			{
				Verification.verifyElementText(Home.remaingvalue, internet_en, internet_ar, "internet correctly appeard", "Wrong internet value appeared");
				Screenshot.saveScreenshot(TestBase.driver, "Check internet  card & values appear incase user has extreme bundle"); //take screenshot			
			}
			
			if (precondition.equals("has plus bundle"))
			{
				Verification.verifyElementText(Home.remaingvalue, internet_en, internet_ar, "internet correctly appeard", "Wrong internet value appeared");
				Screenshot.saveScreenshot(TestBase.driver, "Check internet  card & values appear incase user has plus bundle"); //take screenshot			
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}   
	}

}
