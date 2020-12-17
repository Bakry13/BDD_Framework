package app.tickets.login;

import app.pages.Home;
import app.pages.Login;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ExtentReport;
import utilities.Screenshot;
import utilities.TestBase;
import utilities.Verification;

import java.io.IOException;

public class LoginStepDef {
    @When("^user login using \"(.*)\" and \"(.*)\" with \"(.*)\"$")
    public void user_have_and_with(String msisdn, String password, String status) {
        try {
            ExtentReport.startTC("Login-Check login with valid msisdn and " + status + " password");
            Login.validLogin(msisdn, password); //login
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("^view \"(.*)\" based on password \"(.*)\" with errorMsg \"(.*)\" , \"(.*)\"$")
    public void view_based_on_password(String result, String status, String errorMsgEn, String errorMsgAr) {
        try {
            if (status.equals("valid")) {
                Verification.verifyElement(Home.logo, "Home Screen is opened", "Login failed and home is not opened"); // verify that home screen is opened
                Screenshot.saveScreenshot(TestBase.driver, "Check login with valid msisdn and " + status + " password"); //take screenshot
            } else if (status.equals("invalid")) {
                Verification.verifyElementText(Login.loginErrorMsg,
                        errorMsgEn,
                        errorMsgAr,
                        "Incorrect credentials error message appears",
                        "Incorrect credentials error message does not appear"); //verify error message with incorrect credential

                Screenshot.saveScreenshot(TestBase.driver, "Check login with valid msisdn and " + status + " password"); //take screenshot
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}