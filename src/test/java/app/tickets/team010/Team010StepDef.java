package app.tickets.team010;

import app.pages.Home;
import app.pages.Login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.ExtentReport;
import utilities.Screenshot;
import utilities.TestBase;
import utilities.Verification;

import java.io.IOException;

public class Team010StepDef {
		@Given("^user login using jwt using \"(.*)\" and \"(.*)\"$")
		public void user_login_using_jwt_using_and(String msisdn, String password) {
			try {
	            ExtentReport.startTC("Verify that 010 team card exists");
	            Login.validLogin(msisdn, password); //login
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		}

		@Then("^user view 010teams card$")
		public void user_view_010teams_card() throws IOException {
			Verification.verifyElement(Home.team010,"010 team card is correctly appeard", "010 team card does not exist");
			Screenshot.saveScreenshot(TestBase.driver, "Verify that 010 team card exists"); //take screenshot
		}
}
