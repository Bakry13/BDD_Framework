package app.tickets.usageConsumption;

import app.pages.Home;
import io.cucumber.java.en.Then;
import utilities.ExtentReport;
import utilities.Screenshot;
import utilities.TestBase;
import utilities.Verification;

import java.io.IOException;

public class RedQoutaStepDef
{


	@Then("^Based on \"([^\"]*)\" check on \"([^\"]*)\" and \"([^\"]*)\" card$")
	public void based_on_check_on_and_card(String Rate_plan, String red_min, String red_min_ar)throws Throwable
	{
		try {
			ExtentReport.startTC("Check Min & sms card based on rate plan (" +Rate_plan+")");
				Home.pressmincardEn();
			if (Rate_plan.equals("Red"))
			{
				Verification.verifyElementText(Home.remaingvalue, red_min, red_min_ar, "min are correctly appeard", "Wrong min value appeared");
				System.out.println(Home.remaingvalue.getText());
				Screenshot.saveScreenshot(TestBase.driver, "Check Min appear for red"); //take screenshot			
				
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	@Then("^Based on \"([^\"]*)\" check \"([^\"]*)\" and \"([^\"]*)\" card$")
	public void based_on_check_and_card(String Rate_plan, String red_sms, String red_sms_ar) throws Throwable
	{
		try {
//			ExtentReport.startTC("Check sms card based on rate plan (" +Rate_plan+")");
			Home.presssmscardEn();
			if (Rate_plan.equals("Red"))
			{
				Verification.verifyElementText(Home.remaingvalue, red_sms, red_sms_ar, "sms are correctly appeard", "Wrong sms value appeared");
				Screenshot.saveScreenshot(TestBase.driver, "Check sms  card  appear for red"); //take screenshot
				System.out.println(Home.remaingvalue.getText());
			}
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}  
	}
	
	
	@Then("^check on \"([^\"]*)\" and \"([^\"]*)\" card  Based on \"([^\"]*)\"$")
	public void check_on_and_card_Based_on(String internet_en, String internet_ar, String Rate_plan) throws Throwable
	{
		try {
			ExtentReport.startTC("Check internet card based on rate plan (" +Rate_plan+")");
			Home.pressintcardEn();
			if (Rate_plan.equals("Red"))
			{
				Verification.verifyElementText(Home.remaingvalue, internet_en, internet_ar, "internet correctly appeard", "Wrong internet value appeared");
				Screenshot.saveScreenshot(TestBase.driver, "Check internet  card  appear for red"); //take screenshot
				System.out.println(Home.remaingvalue.getText());
				System.out.println(Home.remaingvalue.getText());
			}
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}  
	}

}
