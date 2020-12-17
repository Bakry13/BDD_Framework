package api.tickets.consumption;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import api.common.Auth;
import api.common.Keycloak;
import api.common.Routes;

public class ConsumptionEndPoints {
	static String token;
	static Response response = null;
//=============consumption request using auth=============================
	public static Response consumptionRequest(String MSISDN, String Password)
	{
		//Get token at first
		try {
			token= Auth.getToken(MSISDN, Password); 
			 //Then send request
			 RestAssured.baseURI = Routes.baseURL+Routes.consumption;
			 response = given()
					//Send header parameters
					 .header("Content-Type","application/json")
					 .header("Accept","application/json")
					 .header("msisdn",MSISDN)
					 .header("api-host","usageConsumptionHost")
					 .header("access-token",token)
					 .queryParam("@type","aggregated") 
			         .queryParam("relatedParty.id",MSISDN).get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
//=============consumption request using JWT=============================
		public static Response consumptionRequest_JWT(String MSISDN, String Password)
		{
			//Get token at first
			try {
				token= Keycloak.getJwtToken(MSISDN, Password);
				 //Then send request 
				 RestAssured.baseURI = Routes.baseURL+Routes.consumption;
				 response = given()
						//Send header parameters
						 .header("Content-Type","application/json")
						 .header("Accept","application/json")
						 .header("msisdn","0"+MSISDN)
						 .header("api-host","usageConsumptionHost")
						 .header("access-token",token)
						 .header("api-version","v2")
						 .header("Authorization","Bearer "+token)
						 .queryParam("@type","aggregated") 
				         .queryParam("relatedParty.id",MSISDN).get();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return response;
		}
//==========================Test consumption==============================================
	public static void main( String[] args )
    {
		Response output=consumptionRequest_JWT("1030693069", "Test@1234");
		System.out.println("Loyalty Status code: " + output.getStatusCode());
		System.out.println("Status message " + output.body().asString());
    }

}
