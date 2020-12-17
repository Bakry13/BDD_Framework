package api.tickets.configuration;

import static io.restassured.RestAssured.given;

import api.common.Auth;
import api.common.Keycloak;
import api.common.Routes;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ConfigurationEndPoints 
{
	public static final String ConfigurationURL = "https://mobile.vodafone.com.eg/services/dxl/cc/channelConfiguration";
	static String token = "0";
	static Response response = null;
	//=========================Configuration Request for Android platform using jwt==================================
	public static Response androidConfigurationRequest_Jwt(String msisdn, String password)
	{
		//Get token at first
		 try {
			token= Keycloak.getJwtToken(msisdn, password);
			 //Then send request 
			 RestAssured.baseURI = Routes.baseURL+Routes.configuration+"/Android";
			 response = given()
					//Send header parameters
					 .header("Content-Type","application/json")
					 .header("Accept","application/json")
					 .header("msisdn",msisdn)
					 .header("api-host","ChannelConfigurationHost")
					 .header("access-token",token)
					 .queryParam("currentBuildNum","140")
					 .queryParam("priceGroupType","CONSUMER")
					 .queryParam("customerType","Postpaid")
					 .queryParam("contractSubType","DEFAULT")
			         .queryParam("msisdn",msisdn)
			         .queryParam("lineType","VOICE")
			         .queryParam("channelId","AnaVodafoneAndroid").get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	
	//=========================Configuration Request for Android platform using Old Auth==================================
		public static Response androidConfigurationRequest_Auth(String msisdn, String password)
		{
			//Get token at first
			 try {
				token= Auth.getToken(msisdn, password);
				 //Then send request 
				 RestAssured.baseURI = Routes.baseURL+Routes.configuration+"/Android";
				 response = given()
						//Send header parameters
						 .header("Content-Type","application/json")
						 .header("Accept","application/json")
						 .header("msisdn",msisdn)
						 .header("api-host","ChannelConfigurationHost")
						 .header("access-token",token)
						 .queryParam("currentBuildNum","140")
						 .queryParam("priceGroupType","CONSUMER")
						 .queryParam("customerType","Postpaid")
						 .queryParam("contractSubType","DEFAULT")
				         .queryParam("msisdn",msisdn)
				         .queryParam("lineType","VOICE")
				         .queryParam("channelId","AnaVodafoneAndroid").get();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return response;
		}
	//=========================Configuration Request for IOS platform==================================
	public static Response iosConfigurationRequest(String msisdn, String password)
	{
		//Get token at first
		try {
			token= Keycloak.getJwtToken(msisdn, password);
			 //Then send request
			 RestAssured.baseURI = Routes.baseURL+Routes.configuration+"/IOS";
			 response = given()
					//Send header parameters
					 .header("Content-Type","application/json")
					 .header("Accept","application/json")
					 .header("msisdn",msisdn)
					 .header("api-host","ChannelConfigurationHost")
					 .header("access-token",token)
					 .queryParam("currentBuildNum","140")
					 .queryParam("priceGroupType","CONSUMER")
					 .queryParam("customerType","Postpaid")
					 .queryParam("contractSubType","DEFAULT")
			         .queryParam("msisdn",msisdn)
			         .queryParam("lineType","VOICE")
			         .queryParam("channelId","AnaVodafoneIOS").get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
//==========================Test consumption==============================================
	public static void main( String[] args )
    {
		Response output= androidConfigurationRequest_Jwt("1000678688", "Test@1234");
		System.out.println("Configuration Status code: " + output.getStatusCode());
		System.out.println("Status message " + output.body().asString());
    }
}
