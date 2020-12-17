package api.tickets.management;

import org.testng.annotations.Test;

import api.tickets.consumption.ConsumptionEndPoints;
import api.tickets.consumption.ConsumptionProducts;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import utilities.ExtentReport;
import utilities.Verification;

public class ManagmentTest
{
	ManagementProducts jwt_obj;
	ManagementProducts auth_obj;
	
	@Given("^user Called management Api once using jwt and other using & old auth with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_Called_management_Api_once_using_jwt_and_other_using_old_auth_with_and(String arg1, String arg2) throws Throwable 
	{
		try {
			ExtentReport.startTC("management API-Validate response with new inputs same as old response with old inputs");			
			Response jwt_management_response= ManagementEndPoints.managmentRequest_JWT("1099759221", "Test@1234");
			Response auth_management_response= ManagementEndPoints.managementRequest("1099759221", "Test@1234");
			jwt_obj = new ManagementProducts(jwt_management_response); // create obj of response using jwts
			auth_obj = new ManagementProducts(auth_management_response); // create obj of response using auth
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	@Then("^compare two responses of managment$")
	public void compare_two_responses_of_managment() throws Throwable
	{
		try {
			Verification.verifyFloat(jwt_obj.UsedMinutes, auth_obj.UsedMinutes, "UsedMinutes ="+ jwt_obj.UsedMinutes, "UsedMinutes with jwt token = " + jwt_obj.UsedMinutes+"\n"+"UsedMinutes with Auth token = "+auth_obj.UsedMinutes);
			Verification.verifyFloat(jwt_obj.UsedSMS, auth_obj.UsedSMS, "UsedSMS ="+ jwt_obj.UsedSMS, "UsedSMS with jwt token = " + jwt_obj.UsedSMS+"\n"+"UsedSMS with Auth token = "+auth_obj.UsedSMS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	


}
