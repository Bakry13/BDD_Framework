package api.tickets.configuration;

import java.util.List;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ConfigurationFlags 
{
	String moduleIndex = "0";
	String featureIndex = "0";
	String apiIndex = "0";
	int apiSize = 0;
	int moduleSize = 0;
	int featureSize = 0;
	//=============Channel Configuration general Flags==========
	public String channelId = "does not exist";
	public String latestBuildNumber = "does not exist";
	public String updateType = "does not exist";
	//===========Channel Configuration dxl api Flags===========
	String apiId = "does not exist";
	public boolean consumptionDXLFlag = false;
	public boolean managementDXLFlag = false;
	//=======================Module Flags======================
	public String moduleId = "does not exist";
	public String featureId = "does not exist";
	//----------------------offers--------------------
	public String offersMinimumSupportVersion = "does not exist";
	//EOY feature
	public boolean eoyFlag = false;
	//----------------------Vodafone Cash--------------------
	public String cashMinimumSupportVersion = "does not exist";
	//Cash points feature
	public boolean cashPointsFlag = false;
	//----------------------010 team--------------------
	public String team010MinimumSupportVersion = "does not exist";
	//Is weekend promo feature
	public boolean isWeekendFlag = false;
	//----------------------Menu--------------------
	public String menuMinimumSupportVersion = "does not exist";
	//----------------------Home--------------------
	public String homeMinimumSupportVersion = "does not exist";
	//----------------------Mobile Internet--------------------
	public String miMinimumSupportVersion = "does not exist";
	//Nudge feature
	public boolean nudgeFlag = false;
//=======================Constructor to extract Flags from response=================
	public ConfigurationFlags(Response response)
	{
		String jsonString = response.asString(); //Convert response to string
		channelId = JsonPath.from(jsonString).get("channelId"); //get channel id (Android or IOS)
		latestBuildNumber = JsonPath.from(jsonString).get("latestBuildNumber"); //get Latest build number
		updateType = JsonPath.from(jsonString).get("updateType"); //get update type
		//------------------------------API loop------------------------
		List<String> apiList = response.jsonPath().getList("api"); // get api list
		apiSize = apiList.size(); //Get size of api array
		for (int apiIterator = 0; apiIterator < apiSize; apiIterator++)
		{
			apiIndex = Integer.toString(apiIterator);
			apiId =  JsonPath.from(jsonString).get("api.id["+apiIndex+"]"); //get api id
			if (apiId.equals("USE_CONS"))
			{
				consumptionDXLFlag = JsonPath.from(jsonString).get("api.dxlFlag["+apiIndex+"]"); //get usage consumption dxl flag
			}
			else if (apiId.equals("USG_MNG"))
			{
				managementDXLFlag = JsonPath.from(jsonString).get("api.dxlFlag["+apiIndex+"]"); //get usage management dxl flag
			}
		}
		//----------------------------Module loop------------------------
		List<String> moduleList = response.jsonPath().getList("module"); // get module list
		moduleSize = moduleList.size(); //Get size of api array
		for (int moduleIterator = 0; moduleIterator < moduleSize; moduleIterator++)
		{
			moduleIndex = Integer.toString(moduleIterator);
			moduleId =  JsonPath.from(jsonString).get("module.id["+moduleIndex+"]");
			if (moduleId.equals("user_offers"))
			{
				try {
					offersMinimumSupportVersion = JsonPath.from(jsonString).get("module.minimumSupportVersion["+moduleIndex+"]"); //get offers module min version number
					//-----------------offers Feature loop---------------------------
					List<String> OffersFeatureList = response.jsonPath().getList("module.feature["+moduleIndex+"]"); // get offers features list
					featureSize = OffersFeatureList.size(); //Get size of offers feature array
					for (int Featureterator = 0; Featureterator < featureSize; Featureterator++)
					{
						featureIndex = Integer.toString(Featureterator);
						featureId =  JsonPath.from(jsonString).get("module.feature["+moduleIndex+"].id["+featureIndex+"]"); //get feature id
						if (featureId.equals("EOY"))
						{
							eoyFlag = JsonPath.from(jsonString).get("module.feature["+moduleIndex+"].flag["+featureIndex+"]"); //get EOY flag
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else if (moduleId.equals("vodafone_cash"))
			{
				try {
					cashMinimumSupportVersion = JsonPath.from(jsonString).get("module.minimumSupportVersion["+moduleIndex+"]"); //get vodafone cash module min version number
					//-----------------Cash points Feature loop---------------------------
					List<String> CashFeatureList = response.jsonPath().getList("module.feature["+moduleIndex+"]"); // get cash points features list
					featureSize = CashFeatureList.size(); //Get size of offers feature array
					for (int Featureterator = 0; Featureterator < featureSize; Featureterator++)
					{
						featureIndex = Integer.toString(Featureterator);
						featureId =  JsonPath.from(jsonString).get("module.feature["+moduleIndex+"].id["+featureIndex+"]"); //get feature id
						if (featureId.equals("cashPoints"))
						{
							cashPointsFlag = JsonPath.from(jsonString).get("module.feature["+moduleIndex+"].flag["+featureIndex+"]"); //get cash points flag
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else if (moduleId.equals("010_team"))
			{
				try {
					team010MinimumSupportVersion = JsonPath.from(jsonString).get("module.minimumSupportVersion["+moduleIndex+"]"); //get 010 team module min version number
					//-----------------010 teams Feature loop---------------------------
					List<String> Team010FeatureList = response.jsonPath().getList("module.feature["+moduleIndex+"]"); // get 010 team features list
					featureSize = Team010FeatureList.size(); //Get size of offers feature array
					for (int Featureterator = 0; Featureterator < featureSize; Featureterator++)
					{
						featureIndex = Integer.toString(Featureterator);
						featureId =  JsonPath.from(jsonString).get("module.feature["+moduleIndex+"].id["+featureIndex+"]"); //get feature id
						if (featureId.equals("isWeekendPromo"))
						{
							isWeekendFlag = JsonPath.from(jsonString).get("module.feature["+moduleIndex+"].flag["+featureIndex+"]"); //get isWeekendPromo flag
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else if (moduleId.equals("Menu"))
			{
				menuMinimumSupportVersion = JsonPath.from(jsonString).get("module.minimumSupportVersion["+moduleIndex+"]"); //get Menu module min version number
			}
			else if (moduleId.equals("Home"))
			{
				homeMinimumSupportVersion = JsonPath.from(jsonString).get("module.minimumSupportVersion["+moduleIndex+"]"); //get Home module min version number
			}
			else if (moduleId.equals("mobile internet"))
			{
				try {
					miMinimumSupportVersion = JsonPath.from(jsonString).get("module.minimumSupportVersion["+moduleIndex+"]"); //get Home module min version number
					//-----------------mobile internet Feature loop---------------------------
					List<String> MIFeatureList = response.jsonPath().getList("module.feature["+moduleIndex+"]"); // get offers features list
					featureSize = MIFeatureList.size(); //Get size of offers feature array
					for (int Featureterator = 0; Featureterator < featureSize; Featureterator++)
					{
						featureIndex = Integer.toString(Featureterator);
						featureId =  JsonPath.from(jsonString).get("module.feature["+moduleIndex+"].id["+featureIndex+"]"); //get feature id
						if (featureId.equals("nudgeDays"))
						{
							nudgeFlag = JsonPath.from(jsonString).get("module.feature["+moduleIndex+"].flag["+featureIndex+"]"); //get nudgeDays flag
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	} //End of constructor
//=================================Test==================================
	public static void main( String[] args )
    {
		Response response= ConfigurationEndPoints.androidConfigurationRequest_Jwt("1099759221", "Test@1234");
		ConfigurationFlags obj = new ConfigurationFlags(response);
		
		System.out.println("channelId "+obj.channelId);
		System.out.println("latestBuildNumber "+obj.latestBuildNumber);
		System.out.println("updateType "+obj.updateType);
		System.out.println("consumptionDXLFlag "+obj.consumptionDXLFlag);
		System.out.println("managementDXLFlag "+obj.managementDXLFlag);
		System.out.println("offersMinimumSupportVersion "+obj.offersMinimumSupportVersion);
		System.out.println("cashMinimumSupportVersion "+obj.cashMinimumSupportVersion);
		System.out.println("team010MinimumSupportVersion "+obj.team010MinimumSupportVersion);
		System.out.println("menuMinimumSupportVersion "+obj.menuMinimumSupportVersion);
		System.out.println("homeMinimumSupportVersion "+obj.homeMinimumSupportVersion);
		System.out.println("miMinimumSupportVersion "+obj.miMinimumSupportVersion);
		System.out.println("eoyFlag "+obj.eoyFlag);
		System.out.println("isWeekendFlag "+obj.isWeekendFlag);
		System.out.println("nudgeFlag "+obj.nudgeFlag);
    }
}
