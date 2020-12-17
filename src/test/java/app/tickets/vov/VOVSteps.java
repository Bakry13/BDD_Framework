package app.tickets.vov;

import app.pages.Home;
import io.cucumber.java.en.Then;
import utilities.ExtentReport;
import utilities.Screenshot;
import utilities.TestBase;
import utilities.Verification;

import java.io.IOException;

public class VOVSteps 
{
	@Then("^Verify recharge button \"(.*)\" and \"(.*)\" in VOV card$")
	public void verify_recharge_button_and_in_vov_card(String rechargeBtnEn, String rechargeBtnAr) throws IOException, InterruptedException {
		ExtentReport.startTC("Verify that Recharge card is displayed in VOV while there is not balance");
		Thread.sleep(5000);
		Verification.verifyElementText(Home.vovRechargeBtn, rechargeBtnEn, rechargeBtnAr+" ", "Recharge button is displayed in VOV", "Can not find recharge button in VOV");
		Screenshot.saveScreenshot(TestBase.driver, "Verify that Recharge card is displayed in VOV while there is not balance");
	}
}
