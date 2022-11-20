package AutomationFrameWork.TestCases.SingleDecleration;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import AutomationFrameWork.SetupFiles.Initilization;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SingleDeclerationAPI {

    static String  getGDStatus(String sdNumber)

    {
        String SDStatus= null;

        String SDID =null;

        String trackingID = null;

        //Data WebocTracking ID and SDID agasit SD Number
        String Query1="use SD select ID from SD.dbo.SD where DocumentNumber='"+sdNumber+"'";
        SDID=Initilization.CustomeDatabaseQueries(Query1,"ID");
        String Query2 = "use SD select WebocGDID from SD.dbo.SD where DocumentNumber='"+sdNumber+"'";
        trackingID=Initilization.CustomeDatabaseQueries(Query2,"WebocGDID");

        //Datafeed

        //

        RestAssured.baseURI = "https://10.200.21.62:7001/GDP";

        Response res = given().header("Authorization", "Bearer " + "LldoPIqZvgIM7j2Uy6OZA7EsVxj18j40ydZaOrId4ZCSuWkrx3B4dA==")

                .contentType("application/json")

                .body("{\r\n"

                        + "    \"methodID\": 1099,\r\n"

                        + "    \"data\": {\r\n"

                        + "        \"PSW_Tracking_ID\": "+SDID+",\r\n"

                        + "        \"tracking_ID\": "+trackingID+"\r\n"

                        + "    }\r\n"

                        + "}").when().post("");

        SDStatus =  res.getBody().jsonPath().getString("data.gD_Status");

        System.out.println(SDStatus);

        return SDStatus;





       // return SDStatus;

    }

    public static String GetUserToken(String NTN)
    {
        RestAssured.baseURI = "https://qa.psw.gov.pk/auth/connect/token";

		Response res = given().contentType("application/x-www-form-urlencoded; charset=utf-8")
        .formParam("grant_type", "password")
        .formParam("username", "UN-00-"+NTN)
        .formParam("password", "Test@1234")
        .formParam("client_id", "psw.client.spa").when()
        .post("");
		String body = res.getBody().jsonPath().getString("access_token");
		System.out.println("TOKEN GENERATED :: "+body);	
        String token =body; 

        if(token!=null)
        {
            return token;
        }
        else {  System.out.println("Cannot Generate Token Either Server is down or User not exist");        
            return "Cannot Generate Token Either Server is down or User not exist"; }
 
    }
///This Method the Following Fields 
///1)CompanyName 2)OrganizationName 3)organizationAddress
   public static List<String> GetUserData(String NTN)
    {
        String token =GetUserToken(NTN);
        List<String> userdata=new ArrayList<String>();

        RestAssured.baseURI = "https://qa.psw.gov.pk/api/auth/user/open";

		Response res = given().header("Authorization", "Bearer " + token)
				.contentType("application/json")
				.body("{\r\n"
				+ "    \"methodId\": \"1135\",\r\n"
				+ "    \"data\": {\r\n"
				+ "        \"role\": \"TR\",\r\n"
				+ "        \"agentLicense\": \"\"\r\n"
				+ "    },\r\n"
				+ "    \"pagination\": {}\r\n"
				+ "}").when().post("");
		userdata.add(res.getBody().jsonPath().getString("data.tradersInfo.companyName"));
        userdata.add(res.getBody().jsonPath().getString("data.tradersInfo.organizations.organizationName"));
        userdata.add(res.getBody().jsonPath().getString("data.tradersInfo.organizations.organizationAddresses[0].organizationAddress[0][0]"));
        System.out.println(userdata.get(2)); 


        return userdata;
    }
    
    
}
