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

public class BalanceStepDef 
{
	@Given("^user log in using jwt using \"(.*)\" and \"(.*)\" accourding to balance \"(.*)\"$")
	public void user_log_in_using_jwt_using_and(String msisdn, String password, String status) {
		try {
            ExtentReport.startTC("Login-Check login with valid msisdn that has" + status + "in balance card");
            Login.validLogin(msisdn, password); //login
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	@Then("^user view \"(.*)\" and \"(.*)\" card accourding to balance \"(.*)\"$")
	public void user_view_and_card(String balanceEn, String balanceAr, String status) throws IOException {
		Verification.verifyElementText(Home.loyaltyPoints, balanceEn, balanceAr, "balance is correctly appeard", "Wrong balance value appeared");
		Screenshot.saveScreenshot(TestBase.driver, "Login-Check login with valid msisdn that has" + status + "in balance card"); //take screenshot
	}
}
