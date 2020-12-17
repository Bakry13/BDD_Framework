package app.tickets.usagemanagment;

import app.pages.Home;
import app.pages.Login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ExtentReport;
import utilities.Screenshot;
import utilities.TestBase;
import utilities.Verification;

public class MinandSmsStepDef {
	@When("^user press on Min card$")
	public void user_press_on_Min_card() throws Throwable
	{
		try {
		ExtentReport.startTC("Check Min card based on rate plan");
		Home.pressmincardEn();
		} catch (Exception e) {
			e.printStackTrace();
		    }   
	}

	@Then("^based on \"([^\"]*)\" check on Min \"([^\"]*)\" and \"([^\"]*)\" card and \"([^\"]*)\" card and \"([^\"]*)\" card$")
	public void based_on_check_on_Min_and_card_and_card_and_card(String Usertype, String Min_en, String Min_ar,String usedScript_en,String usedScript_ar) throws Throwable 

	{
		try {
	//	ExtentReport.startTC("Check Min card based on rate plan (" +Usertype+")");
		if (Usertype.equals("Mass"))
		{
			Verification.verifyElementText(Home.remaingvalue, Min_en, Min_ar, "sms are correctly appeard", "managment not called");
			Verification.verifyElementText(Home.usedscript, usedScript_en,usedScript_ar, "managment called successfully", "managment not called");			
			Screenshot.saveScreenshot(TestBase.driver, "Check Min appear for (" +Usertype+")"); //take screenshot						
		}
		else if (Usertype.equals("flexrevamp"))
		{
			Verification.verifyElementText(Home.remaingvalue, Min_en, Min_ar, "sms are correctly appeard", "managment not called");
			Verification.verifyElementText(Home.usedscript, usedScript_en,usedScript_ar, "managment called successfully", "managment not called");						
			Screenshot.saveScreenshot(TestBase.driver, "Check Min appear for (" +Usertype+")"); //take screenshot						
		}
		} catch (Exception e) {
			e.printStackTrace();
		    }   
	}

	

	@When("^user press on SMS card$")
	public void user_press_on_SMS_card() throws Throwable 
	{
		try {
			ExtentReport.startTC("Check sms card based on rate plan");
			Home.presssmscardEn();
		} catch (Exception e) {
			e.printStackTrace();
		    } 
	}

	@Then("^based on \"([^\"]*)\" check on SMS \"([^\"]*)\" and \"([^\"]*)\" card and \"([^\"]*)\" card and \"([^\"]*)\" card$")
	public void based_on_check_on_SMS_and_card_and_card_and_card(String Usertype, String sms_en, String sms_ar, String usedScript_en, String usedScript_ar) throws Throwable 

	{  
		try {
			
	//		ExtentReport.startTC("Check sms card based on rate plan (" +Usertype+")");			
          if (Usertype.equals("flexrevamp"))
		{
        	  System.out.println("test");
        	  Verification.verifyElementText(Home.remaingvalue, sms_en, sms_ar, "sms are correctly appeard", "managment not called");
		//	Verification.verifyElementText(Home.usedscript, usedScript_en,usedScript_ar, "managment called successfully", "managment not called");									
			Screenshot.saveScreenshot(TestBase.driver, "Check Min appear for (" +Usertype+")"); //take screenshot						
			System.out.println(Home.remaingvalue.getText());
			System.out.println(Home.contentscript.getText());
		}
		} catch (Exception e) {
			e.printStackTrace();
		    }   
	}


}
