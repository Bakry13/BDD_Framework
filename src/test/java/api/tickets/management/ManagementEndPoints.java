package api.tickets.management;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import api.common.Auth;
import api.common.Keycloak;
import api.common.Routes;

public class ManagementEndPoints {
	static String token;
	static Response response = null;
	
//=============management request using auth=============================
	public static Response managementRequest(String MSISDN, String Password)
	{
		//Get token at first
		try {
			token= Auth.getToken(MSISDN, Password);
			 //Then send request
			 RestAssured.baseURI = Routes.baseURL+Routes.management;
			 response = given()
					//Send header parameters
					 .header("msisdn",MSISDN)
					 .header("api-host","UsageManagementHost")
					 .header("access-token",token)
					 .queryParam("@type","Aggregated") 
			         .queryParam("relatedParty.id",MSISDN).get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	//=============managament request using JWT=============================
			public static Response managmentRequest_JWT(String MSISDN, String Password)
			{
				//Get token at first
				try {
					token= Keycloak.getJwtToken(MSISDN, Password);
					 //Then send request 
					 RestAssured.baseURI = Routes.baseURL+Routes.management;
					 response = given()
							//Send header parameters
							 .header("msisdn","0"+MSISDN)
							 .header("api-host","UsageManagementHost")
							 .header("access-token",token)
							 .header("api-version","v2")
							 .header("Authorization","Bearer "+token)
							 .queryParam("@type","Aggregated") 
					         .queryParam("relatedParty.id",MSISDN).get();
				} catch (Exception e) {
					e.printStackTrace();
				}
				return response;
			}	
//==========================Test consumption==============================================
	public static void main( String[] args )
    {
		Response output=managmentRequest_JWT("1099759221", "Test@1234");
		System.out.println(" Status code: " + output.getStatusCode());
		System.out.println("Status message " + output.body().asString());
    }
}
