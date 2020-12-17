package app.tickets.billCard;

import app.pages.Home;
import app.pages.Login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.*;

import java.io.IOException;

public class BillCardStepDef {
    @Given("^user login using jwt using \"(.*)\" and \"(.*)\" and \"(.*)\"$")
    public void user_login_using_jwt_using_and(String msisdn, String password, String RatePlan) {
        try {
            ExtentReport.startTC("Verify that bill card exists in " + RatePlan);
            Login.validLogin(msisdn, password); //login
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("user view bill card for {string}")
    public void user_view_bill_card(String RatePlan) throws IOException {
        try{
            GeneralHandler.pressContinueBtn();
        }catch (Exception e){

        }
        switch (GlobalParams.currentLanguage) {
            case ENGLISH:
                Verification.verifyElement(Home.billCardEn, "bill card is correctly appeared in " + RatePlan, "bill card does not exist in " + RatePlan);
                Screenshot.saveScreenshot(TestBase.driver, "Verify that bill card exists in " + RatePlan); //take screenshot
                break;
            case ARABIC:

                Verification.verifyElement(Home.billCardAr, "bill card is correctly appeared in " + RatePlan, "bill card does not exist in " + RatePlan);
                Screenshot.saveScreenshot(TestBase.driver, "Verify that bill card exists in " + RatePlan); //take screenshot
                break;
        }
    }


}
