package app.tickets.usageConsumption;

import app.pages.Home;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ExtentReport;
import utilities.Screenshot;
import utilities.TestBase;
import utilities.Verification;

import java.io.IOException;

public class RoamingStepDef
{

	@When("^press on roaming tab$")
	public void press_on_roaming_tab() {
		try {
			Home.pressroaming(); //press on roaming tab
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	@Then("^The correct text of \"(.*)\" and \"(.*)\" appear$")
	public void the_correct_text_of_and_appear(String roamingScriptEn, String roamingScriptAr) throws IOException {
		try {
			ExtentReport.startTC("Verify correct script of roaming tab while there is not subscribed bundle");
			Verification.verifyElementText(Home.contentscript, roamingScriptEn, roamingScriptAr, "The correct text of roaming tab appeared", "roaming script does not exist");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Screenshot.saveScreenshot(TestBase.driver, "Verify correct script of roaming tab while there is not subscribed bundle");
	}

	@Then("^The correct text of \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\" appear$")
	public void the_correct_text_of_appear(String roamingScriptEn1, String roamingScriptAr1, String roamingScriptEn2, String roamingScriptAr2) throws IOException {
		try {
			ExtentReport.startTC("Verify correct script of roaming tab while there is unused subscribed bundle");
			Verification.verifyElementText(Home.tvMessage, roamingScriptEn1, roamingScriptAr1, "The correct text of roaming tab appeared", "roaming script does not exist");
			Verification.verifyElementText(Home.tvExpiryMessage, roamingScriptEn2, roamingScriptAr2, "The correct text of roaming tab appeared", "roaming script does not exist");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Screenshot.saveScreenshot(TestBase.driver, "Verify correct script of roaming tab while there is unused subscribed bundle");
	}

	@Then("^The correct values of \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\" appear$")
	public void the_correct_values_of_appear(String internetEn, String internetAr, String outgoingMinEn, String outgoingMinAr, String incomingMinEn, String incomingMinAr, String smsEn, String smsAr) throws IOException {
		try {
			ExtentReport.startTC("Verify consumed roaming data while there is used subscribed bundle");
			Verification.verifyElementText(Home.firstConsumptionValue, internetEn, internetAr, "The correct internet value of roaming appeared", "roaming internet value is not correct");
			Verification.verifyElementText(Home.secondConsumptionValue, outgoingMinEn, outgoingMinAr, "The correct outgoing min value of roaming appeared", "roaming outgoing min value is not correct");
			Verification.verifyElementText(Home.thirdConsumptionValue, incomingMinEn, incomingMinAr, "The correct incoming min value of roaming appeared", "roaming incoming min value is not correct");
			Verification.verifyElementText(Home.fourthConsumptionValue, smsEn, smsAr, "The correct sms value of roaming appeared", "roaming sms value is not correct");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Screenshot.saveScreenshot(TestBase.driver, "Verify consumed roaming data while there is used subscribed bundle");
	}
}
