package api.tickets.configuration;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import utilities.ExtentReport;
import utilities.Screenshot;
import utilities.TestBase;
import utilities.Verification;

public class ConfigurationTest
{
	ConfigurationFlags jwt_obj;
	ConfigurationFlags auth_obj;
	@Given("^user Called configuration Api once using jwt and other using & old auth\"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_Called_configuration_Api_once_using_jwt_and_other_using_old_auth_and(String msisdn, String password) throws Throwable
	{
		try {
			ExtentReport.startTC("Configuration API-Validate response with new inputs same as old response with old inputs");
			Response jwt_config_response=  ConfigurationEndPoints.androidConfigurationRequest_Jwt("1030693069", "Test@1234");
			Response auth_config_response= ConfigurationEndPoints.androidConfigurationRequest_Auth("1030693069", "Test@1234");
			jwt_obj = new ConfigurationFlags(jwt_config_response); // create obj of response using jwt
			auth_obj = new ConfigurationFlags(auth_config_response); // create obj of response using auth
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Then("^compare two responses$")
	public void compare_two_responses() throws Throwable
	{
		try {
			Verification.verifyString(jwt_obj.channelId, auth_obj.channelId, "Channel Id ="+ jwt_obj.channelId, "Channel Id with jwt token = " + jwt_obj.channelId+"\n"+"Channel Id with Auth token = "+auth_obj.channelId); //Verify Channel Id
    		Verification.verifyString(jwt_obj.latestBuildNumber,auth_obj.latestBuildNumber, "latestBuildNumber ="+jwt_obj.latestBuildNumber, "latest build with jwt token = " + jwt_obj.latestBuildNumber+"\n"+"latest build with Auth token = "+auth_obj.latestBuildNumber); //Verify latest build number
    		Verification.verifyString(jwt_obj.updateType, auth_obj.updateType, "updateType = "+jwt_obj.updateType, "update Type with jwt token = " + jwt_obj.updateType+"\n"+"update  Type with Auth token = "+auth_obj.updateType); //Verify update type
    		Verification.verifyBoolean(jwt_obj.consumptionDXLFlag,auth_obj.consumptionDXLFlag, "Consumption DXL Flag "+jwt_obj.consumptionDXLFlag, "consumptionDXLFlag with jwt token = " + jwt_obj.consumptionDXLFlag+"\n"+"consumptionDXLFlag with Auth token = "+auth_obj.consumptionDXLFlag); //Verify usage consumption dxl flag
    		Verification.verifyBoolean(jwt_obj.managementDXLFlag, auth_obj.managementDXLFlag, "Management DXL Flag = "+jwt_obj.managementDXLFlag, "managementDXLFlag with jwt token = " + jwt_obj.managementDXLFlag+"\n"+"managementDXLFlag with Auth token = "+auth_obj.managementDXLFlag); //Verify usage management dxl flag
    		Verification.verifyString(jwt_obj.offersMinimumSupportVersion,auth_obj.offersMinimumSupportVersion, "Offers Minimum Support Version ="+jwt_obj.offersMinimumSupportVersion, "offers Minimum Support Version with jwt token = " + jwt_obj.offersMinimumSupportVersion+"\n"+"offers Minimum Support Version with Auth token = "+auth_obj.offersMinimumSupportVersion); //Verify offers min support version
    		Verification.verifyString(jwt_obj.cashMinimumSupportVersion, auth_obj.cashMinimumSupportVersion, "Cash Minimum Support Version ="+jwt_obj.cashMinimumSupportVersion,"cash Minimum Support Version with jwt token = " + jwt_obj.cashMinimumSupportVersion+"\n"+"cash Minimum Support Version with Auth token = "+auth_obj.cashMinimumSupportVersion); //Verify cash min support version
    		Verification.verifyString(jwt_obj.team010MinimumSupportVersion, auth_obj.team010MinimumSupportVersion, "010 Team Minimum Support Version = "+jwt_obj.team010MinimumSupportVersion, "team010 Minimum Support Version with jwt token = " + jwt_obj.team010MinimumSupportVersion+"\n"+"team010 Minimum Support Version with Auth token = "+auth_obj.team010MinimumSupportVersion); //Verify 010 Team min support version
    		Verification.verifyString(jwt_obj.menuMinimumSupportVersion, auth_obj.menuMinimumSupportVersion, "Menu Minimum Support Version = "+jwt_obj.menuMinimumSupportVersion, "menu Minimum Support Version with jwt token = " + jwt_obj.menuMinimumSupportVersion+"\n"+"menu Minimum Support Version with Auth token = "+auth_obj.menuMinimumSupportVersion); //Menu min support version
    		Verification.verifyString(jwt_obj.homeMinimumSupportVersion, auth_obj.homeMinimumSupportVersion, "Home Minimum Support Version ="+jwt_obj.homeMinimumSupportVersion, "home Minimum Support Version with jwt token = " + jwt_obj.homeMinimumSupportVersion+"\n"+"home Minimum Support Version with Auth token = "+auth_obj.homeMinimumSupportVersion); //Home min support version
    		Verification.verifyString(jwt_obj.miMinimumSupportVersion, auth_obj.miMinimumSupportVersion, "MI Minimum Support Version = "+jwt_obj.miMinimumSupportVersion, "mi Minimum Support Version with jwt token = " + jwt_obj.miMinimumSupportVersion+"\n"+"mi Minimum Support Version with Auth token = "+auth_obj.miMinimumSupportVersion); //MI min support version
    		Verification.verifyBoolean(jwt_obj.eoyFlag, auth_obj.eoyFlag, "EOY Flag = "+jwt_obj.eoyFlag, "eoy Flag with jwt token = " + jwt_obj.eoyFlag+"\n"+"eoyFlag with Auth token = "+auth_obj.eoyFlag); //EOY Flag
    		Verification.verifyBoolean(jwt_obj.isWeekendFlag, auth_obj.isWeekendFlag, "Is Weekend promo Flag ="+jwt_obj.isWeekendFlag, "isWeekend Flag with jwt token = " + jwt_obj.isWeekendFlag+"\n"+"isWeekend Flag with Auth token = "+auth_obj.isWeekendFlag); //EOY Flag
    		Verification.verifyBoolean(jwt_obj.nudgeFlag,auth_obj.nudgeFlag, "Nudge Days Flag "+jwt_obj.nudgeFlag, "nudge Flag with jwt token = " + jwt_obj.nudgeFlag+"\n"+"nudge Flag with Auth token = "+auth_obj.nudgeFlag); //Nudge Days Flag
    		Verification.verifyBoolean(jwt_obj.cashPointsFlag, auth_obj.cashPointsFlag, "Vodafone cash points Flag ="+jwt_obj.cashPointsFlag, "cash Points Flag with jwt token = " + jwt_obj.cashPointsFlag+"\n"+"cash Points Flag with Auth token = "+auth_obj.cashPointsFlag); //Cash points Flag
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
