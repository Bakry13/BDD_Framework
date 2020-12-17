package api.tickets.consumption;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import utilities.ExtentReport;
import utilities.Verification;

public class ConsumptionTest
{
	ConsumptionProducts jwt_obj;
	ConsumptionProducts auth_obj;
	
	@Given("^user Called consumption Api once using jwt and other using & old auth with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_Called_consumption_Api_once_using_jwt_and_other_using_old_auth_with_and(String arg1, String arg2) throws Throwable
      {
		try {
			ExtentReport.startTC("Consumption API-Validate response with new inputs same as old response with old inputs");			
			Response jwt_consumption_response= ConsumptionEndPoints.consumptionRequest_JWT("1099759221", "Test@1234");
			Response auth_consumption_response= ConsumptionEndPoints.consumptionRequest("1099759221", "Test@1234");
			jwt_obj = new ConsumptionProducts(jwt_consumption_response); // create obj of response using jwts
			auth_obj = new ConsumptionProducts(auth_consumption_response); // create obj of response using auth
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("^compare two responses of consumption$")
	public void compare_two_responses() throws Throwable 
	{
	  try {
		Verification.verifyFloat(jwt_obj.UsedFlexes, auth_obj.UsedFlexes, "UsedFlexes ="+ jwt_obj.UsedFlexes, "UsedFlexes with jwt token = " + jwt_obj.UsedFlexes+"\n"+"UsedFlexes with Auth token = "+auth_obj.UsedFlexes);
		Verification.verifyFloat(jwt_obj.RemainingFlexes, auth_obj.RemainingFlexes, "RemainingFlexes ="+ jwt_obj.RemainingFlexes, "RemainingFlexes with jwt token = " + jwt_obj.RemainingFlexes+"\n"+"RemainingFlexes with Auth token = "+auth_obj.RemainingFlexes);
		Verification.verifyFloat(jwt_obj.UsedInternet, auth_obj.UsedInternet, "RemainingFlexes ="+ jwt_obj.UsedInternet, "RemainingFlexes with jwt token = " + jwt_obj.UsedInternet+"\n"+"UsedInternet with Auth token = "+auth_obj.UsedInternet);
		Verification.verifyFloat(jwt_obj.RemainingInternet, auth_obj.RemainingInternet, "RemainingInternet ="+ jwt_obj.UsedInternet, "RemainingInternet with jwt token = " + jwt_obj.RemainingInternet+"\n"+"RemainingInternet with Auth token = "+auth_obj.RemainingInternet);
		Verification.verifyFloat(jwt_obj.UsedSuperPass, auth_obj.UsedSuperPass, "UsedSuperPass ="+ jwt_obj.UsedSuperPass, "UsedSuperPass with jwt token = " + jwt_obj.UsedSuperPass+"\n"+"UsedSuperPass with Auth token = "+auth_obj.UsedSuperPass);
		Verification.verifyFloat(jwt_obj.RemainingSuperPass, auth_obj.RemainingSuperPass, "RemainingSuperPass ="+ jwt_obj.RemainingSuperPass, "RemainingSuperPass with jwt token = " + jwt_obj.RemainingSuperPass+"\n"+"RemainingSuperPass with Auth token = "+auth_obj.RemainingSuperPass);
		Verification.verifyFloat(jwt_obj.UsedFamilyInternet, auth_obj.UsedFamilyInternet, "UsedFamilyInternet ="+ jwt_obj.UsedFamilyInternet, "UsedFamilyInternet with jwt token = " + jwt_obj.UsedFamilyInternet+"\n"+"UsedFamilyInternet with Auth token = "+auth_obj.UsedFamilyInternet);
		Verification.verifyFloat(jwt_obj.RemainingFamilyInternet, auth_obj.RemainingFamilyInternet, "RemainingFamilyInternet ="+ jwt_obj.RemainingFamilyInternet, "RemainingFamilyInternet with jwt token = " + jwt_obj.RemainingFamilyInternet+"\n"+"RemainingFamilyInternet with Auth token = "+auth_obj.RemainingFamilyInternet);
		Verification.verifyFloat(jwt_obj.UsedFamilySMS, auth_obj.UsedFamilySMS, "UsedFamilySMS ="+ jwt_obj.UsedFamilySMS, "UsedFamilySMS with jwt token = " + jwt_obj.UsedFamilySMS+"\n"+"UsedFamilySMS with Auth token = "+auth_obj.UsedFamilySMS);
		Verification.verifyFloat(jwt_obj.RemainingFamilySMS, auth_obj.RemainingFamilySMS, "RemainingFamilySMS ="+ jwt_obj.RemainingFamilySMS, "RemainingFamilySMS with jwt token = " + jwt_obj.RemainingFamilySMS+"\n"+"RemainingFamilySMS with Auth token = "+auth_obj.RemainingFamilySMS);
		Verification.verifyFloat(jwt_obj.UsedFamilyMinutes, auth_obj.UsedFamilyMinutes, "UsedFamilyMinutes ="+ jwt_obj.UsedFamilyMinutes, "UsedFamilyMinutes with jwt token = " + jwt_obj.UsedFamilyMinutes+"\n"+"UsedFamilyMinutes with Auth token = "+auth_obj.UsedFamilyMinutes);
		Verification.verifyFloat(jwt_obj.RemainingFamilyMinutes, auth_obj.RemainingFamilyMinutes, "RemainingFamilyMinutes ="+ jwt_obj.RemainingFamilyMinutes, "UsedFlexes with jwt token = " + jwt_obj.RemainingFamilyMinutes+"\n"+"RemainingFamilyMinutes with Auth token = "+auth_obj.RemainingFamilyMinutes);
		Verification.verifyFloat(jwt_obj.UsedRoamingInternet, auth_obj.UsedRoamingInternet, "UsedRoamingInternet ="+ jwt_obj.UsedRoamingInternet, "UsedRoamingInternet with jwt token = " + jwt_obj.UsedRoamingInternet+"\n"+"UsedRoamingInternet with Auth token = "+auth_obj.UsedRoamingInternet);
		Verification.verifyFloat(jwt_obj.RemainingRoamingInternet, auth_obj.RemainingRoamingInternet, "RemainingRoamingInternet ="+ jwt_obj.RemainingRoamingInternet, "RemainingRoamingInternet with jwt token = " + jwt_obj.RemainingRoamingInternet+"\n"+"RemainingRoamingInternet with Auth token = "+auth_obj.RemainingRoamingInternet);
		Verification.verifyFloat(jwt_obj.UsedRoamingSMS, auth_obj.UsedRoamingSMS, "UsedRoamingSMS ="+ jwt_obj.UsedRoamingSMS, "UsedRoamingSMS with jwt token = " + jwt_obj.UsedRoamingSMS+"\n"+"UsedRoamingSMS with Auth token = "+auth_obj.UsedRoamingSMS);
		Verification.verifyFloat(jwt_obj.RemainingRoamingSMS, auth_obj.RemainingRoamingSMS, "RemainingRoamingSMS ="+ jwt_obj.RemainingRoamingSMS, "RemainingRoamingSMS with jwt token = " + jwt_obj.RemainingRoamingSMS+"\n"+"RemainingRoamingSMS with Auth token = "+auth_obj.RemainingRoamingSMS);
		Verification.verifyFloat(jwt_obj.UsedRoamingOutgoing, auth_obj.UsedRoamingOutgoing, "UsedRoamingOutgoing ="+ jwt_obj.UsedRoamingOutgoing, "UsedRoamingOutgoing with jwt token = " + jwt_obj.UsedRoamingOutgoing+"\n"+"UsedRoamingOutgoing with Auth token = "+auth_obj.UsedRoamingOutgoing);
		Verification.verifyFloat(jwt_obj.RemainingRoamingOutgoing, auth_obj.RemainingRoamingOutgoing, "RemainingRoamingOutgoing ="+ jwt_obj.RemainingRoamingOutgoing, "RemainingRoamingOutgoing with jwt token = " + jwt_obj.RemainingRoamingOutgoing+"\n"+"RemainingRoamingOutgoing with Auth token = "+auth_obj.RemainingRoamingOutgoing);
		Verification.verifyFloat(jwt_obj.UsedRoamingIncoming, auth_obj.UsedRoamingIncoming, "UsedRoamingIncoming ="+ jwt_obj.UsedRoamingIncoming, "UsedRoamingIncoming with jwt token = " + jwt_obj.UsedRoamingIncoming+"\n"+"UsedRoamingIncoming with Auth token = "+auth_obj.UsedRoamingIncoming);
		Verification.verifyFloat(jwt_obj.RemainingRoamingIncoming, auth_obj.RemainingRoamingIncoming, "RemainingRoamingIncoming ="+ jwt_obj.RemainingRoamingIncoming, "RemainingRoamingIncoming with jwt token = " + jwt_obj.RemainingRoamingIncoming+"\n"+"RemainingRoamingIncoming with Auth token = "+auth_obj.RemainingRoamingIncoming);
		Verification.verifyFloat(jwt_obj.UsedMinutes, auth_obj.UsedMinutes, "UsedMinutes ="+ jwt_obj.UsedMinutes, "UsedMinutes with jwt token = " + jwt_obj.UsedMinutes+"\n"+"UsedMinutes with Auth token = "+auth_obj.UsedMinutes);
		Verification.verifyFloat(jwt_obj.RemainingMinutes, auth_obj.RemainingMinutes, "RemainingMinutes ="+ jwt_obj.RemainingMinutes, "RemainingMinutes with jwt token = " + jwt_obj.RemainingMinutes+"\n"+"RemainingMinutes with Auth token = "+auth_obj.RemainingMinutes);
		Verification.verifyFloat(jwt_obj.UsedSMS, auth_obj.UsedSMS, "UsedSMS ="+ jwt_obj.UsedSMS, "UsedSMS with jwt token = " + jwt_obj.UsedSMS+"\n"+"UsedSMS with Auth token = "+auth_obj.UsedSMS);
		Verification.verifyFloat(jwt_obj.RemainingSMS, auth_obj.RemainingSMS, "RemainingSMS ="+ jwt_obj.RemainingSMS, "RemainingSMS with jwt token = " + jwt_obj.RemainingSMS+"\n"+"RemainingSMS with Auth token = "+auth_obj.RemainingSMS);
	  } catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
