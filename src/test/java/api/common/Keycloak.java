package api.common;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Keycloak {
	public static final String keycloakAuthURL = "http://test1.vodafone.com.eg/auth/realms/vf-realm/protocol/openid-connect/token";
	public static final String clientSecret_Staging="fa33753c-2396-455b-b731-cd213b9c28f7";
	public static final String clientSecret_Production="a2ec6fff-0b7f-4aa4-a733-96ceae5c84c3";
	public static String clientSecret = clientSecret_Production;
	public static String statusCode = "0";
	public static String jsonString = "0";
	public static String jwtToken = "0";
	
	public static Response KeycloackRequest(String msisdn, String password)
	{
		RestAssured.baseURI =Routes.baseURL+Routes.keycloakAuth;
		Response response = given()
        			//Send body in Data Form type
	    			.formParam("username", msisdn)
	    			.formParam("password", password)
	    			.formParam("grant_type", "password")
	    			.formParam("client_id", "my-vodafone-app")
	    			.formParam("client_secret", clientSecret)
	    			.post(); //Make post action
        
        statusCode = Integer.toString(response.getStatusCode());
        System.out.println("Jwt status code is "+ statusCode);
        return response;
	}
	
	public static String getJwtToken(String msisdn, String password)
	{
		try {
			Response response = KeycloackRequest(msisdn, password); //Get the keycloak response
			jsonString =response.getBody().asString();	//Convert Jasone response to string
			jwtToken = JsonPath.from(jsonString).get("access_token");	//Get token from its node
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jwtToken;
    }

	public static void main( String[] args )
    {
    	System.out.println(getJwtToken("1030693069", "Test@1234"));
    }
}
