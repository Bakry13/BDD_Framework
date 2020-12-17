package app.tickets.flexWidgets;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import utilities.ExtentReport;
import utilities.Screenshot;
import utilities.TestBase;

import java.io.IOException;

public class flexWidgetsStepDef 
{
	Scenario scenario;
	@Then("^I verify \"(.*)\", \"(.*)\", \"(.*)\" and \"(.*)\" accourding to \"(.*)\"$")
	public void i_verify_and_accourding_to(String superFlex, String offers365, String flexExtra, String flexTransfer, String ratePlan) throws IOException {
		//ExtentReport.startTC(scenario.getName());
		if (ratePlan.equals("flexOpen"))
		{
			
		}
		Screenshot.saveScreenshot(TestBase.driver, scenario.getName());
	}
}
