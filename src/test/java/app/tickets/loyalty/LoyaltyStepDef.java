package app.tickets.loyalty;

import app.pages.Home;
import app.pages.Login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.ExtentReport;
import utilities.Screenshot;
import utilities.TestBase;
import utilities.Verification;

import java.io.IOException;

public class LoyaltyStepDef {

    @Given("^User have \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_have_and(String msisdn, String password) {
        try {
            Login.validLogin(msisdn, password); //login
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //----------DXL_FLAG and  update the UI accordingly--------------------------------

    @Then("^Get red points value \"([^\"]*)\" , \"([^\"]*)\" from  \"([^\"]*)\" based on \"([^\"]*)\"$")
    public void get_red_points_value_from_based_on(String redPointsEn, String redPointsAr, String state, String ConsumptionDXLFlag) throws IOException {
        try {
            ExtentReport.startTC("Loyalty-Check  " + redPointsEn + " points returned from " + state + " successfully");
            if (ConsumptionDXLFlag.equals("false") && state.equals("old home")) {
                Verification.verifyElementText(Home.loyaltyPoints,
                        redPointsEn,
                        redPointsAr,
                        "Points called from old home successfully",
                        "Error happen");
            } else if (ConsumptionDXLFlag.equals("true") && state.equals("red loyalty api")) {
                Verification.verifyElementText(Home.loyaltyPoints,
                        redPointsEn,
                        redPointsAr,
                        "Points called from DXL successfully",
                        "Error happen");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Screenshot.saveScreenshot(TestBase.driver, "Check  " + redPointsEn + " points returned from" + state + "successfully"); //take screenshot
    }

    //----------check red loyalty eligibility--------------------------------

    @Then("^loyalty card visibility is \"([^\"]*)\" based on \"([^\"]*)\"$")
    public void loyalty_card_visibility_is_based_on(String cardState, String userType) throws Throwable {
        try {
            ExtentReport.startTC("Loyalty-Check  in case: " + userType + " points card appears: " + cardState);
            if (cardState.equals("false") && userType.equals("mass")) {
                Verification.verifyElementNotExists(Home.pointsCard, "Card is not visible", "Card is visible");
            } else if (cardState.equals("false") && userType.equals("red business")) {
                Verification.verifyElementNotExists(Home.pointsCard, "Card is not visible", "Card is visible");
            } else if (cardState.equals("true") && userType.equals("red converged")) {
                Verification.verifyElement(Home.pointsCard, "Card is visible", "Card is not visible");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Screenshot.saveScreenshot(TestBase.driver, "Check  in case " + userType + " points card will appear"); //take screenshot
    }
}