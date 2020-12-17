package app.tickets.update;

import app.pages.Home;
import app.pages.Login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ExtentReport;
import utilities.Screenshot;
import utilities.TestBase;
import utilities.Verification;

import java.io.IOException;

public class UpdateStepDef {
    @Given("^build number is less than last build number$")
    public void build_number_is_less_than_last_build_number() {
        ExtentReport.startTC("Update-Check that update dialog appears when build number is less than latest build number");
    }

    @When("^user login by jwt using \"(.*)\" and \"(.*)\"$")
    public void user_login_by_jwt_using_and(String msisdn, String password) {
        Login.validLogin(msisdn, password); //login
    }

    @Then("validate that update dialog exists")
    public void validate_that_update_dialog_exists() throws IOException {
        try {
            Verification.verifyElement(Home.updateBtn, "Update button is displayed", "Update button does not exist");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Screenshot.saveScreenshot(TestBase.driver, "Check that update dialog appears when build number is less than latest build number"); //take screenshot
    }
}
