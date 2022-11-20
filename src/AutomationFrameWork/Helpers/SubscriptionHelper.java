package AutomationFrameWork.Helpers;

import static io.restassured.RestAssured.given;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Packages for Decryption
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import AutomationFrameWork.SetupFiles.AES;
import AutomationFrameWork.SetupFiles.Initilization;
import Locators.SubscriptionLocators;
import io.restassured.RestAssured;
import io.restassured.response.Response;

//Channel Id 1 = Sms 
//Channel Id 2 = Email
//ConnectionString = "10.100.240.61:1433";

public class SubscriptionHelper extends Initilization {
	/**
	 * This Method is Get SMS OTM on the basic of Application ID form the DataBase
	 * 
	 * @param ConnectionString = Connection IP of the
	 * @param APID             = Application ID
	 * 
	 *                         Created by Muhammad Maaz
	 */
	public static String GetsmsOTPFromDataBase(String APID) {

		String Result = null;

		try (Statement stmt = Initilization.ConnectDatabase(Initilization.ConnectionString, Initilization.username,
				Initilization.password)) {
			String SQL = "select Top 1 * from otplog where subscriptionApplicationID = '" + APID
					+ "' and channelID = 1 order by createdOn desc";
			ResultSet rs = stmt.executeQuery(SQL);

			// Iterate through the data in the result set and display it.
			while (rs.next()) {
				String data = rs.getString("otpcode");

				AES obj1 = new AES("#PSW-OTP-KEY-123");
				Result = obj1.soften(data);
				// System.out.println(Result);

			}
		}
		// Handle any errors that may have occurred.
		catch (SQLException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Result;

	}

	/**
	 * This Method is Get Email OTM on the basic of Application ID form the DataBase
	 * 
	 * @param ConnectionString = Connection IP of the
	 * @param APID             = Application ID
	 * 
	 *                         Created by Muhammad Maaz
	 */
	public static String GetEmailOTPFromDataBase(String APID) {

		String Result = null;
		try (Statement stmt = Initilization.ConnectDatabase(Initilization.ConnectionString, Initilization.username,
				Initilization.password)) {
			String SQL = "select Top 1 * from otplog where subscriptionApplicationID = '" + APID
					+ "' and channelID = 2 order by createdOn desc";

			ResultSet rs = stmt.executeQuery(SQL);

			// Iterate through the data in the result set and display it.
			while (rs.next()) {
				String data = rs.getString("otpcode");

				AES obj1 = new AES("#PSW-OTP-KEY-123");
				Result = obj1.soften(data);
				// System.out.println(Result);
				// System.out.println(ResultSet);

			}
		}
		// Handle any errors that may have occurred.
		catch (SQLException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Result;

	}

	/**
	 * This Method is Get Activation URL on the basic of Application ID form the
	 * DataBase
	 * 
	 * @param ConnectionString = Connection IP of the
	 * @param APID             = Application ID
	 * 
	 *                         Created by Muhammad Maaz
	 */
	// Handle any errors that may have occurred.
	public static String GetActivationLinkFromDataBase(String APID) {

		String Result = null;
		// ConnectionString = "10.100.240.61:1433";

		// + ";databaseName=AUTH;user=sa;password=@qaxyz"; //@qaxyz @Password1
		try (Statement stmt = Initilization.ConnectDatabase(Initilization.ConnectionString, Initilization.username,
				Initilization.password)) {
			String SQL = "select ActivationURL from SubscriptionApplication where id =" + APID;
			ResultSet rs = stmt.executeQuery(SQL);
			while (rs.next()) {
				Result = rs.getString("ActivationUrl");
			}
			System.out.println(Result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Activation Link Fetch From DataBase Sucessfully");
		return Result;
	}

	/**
	 * This Method is Delete Account form the DataBase on the basis Application ID
	 * 
	 * @param connectionString = Connection IP of the
	 * @param APID             = Application ID
	 * 
	 *                         Created by Muhammad Maaz
	 */
	public static void DeleteApplicationIDFromDataBase(String NTN) {

		// String connectionUrl = "jdbc:sqlserver://" + ConnectionString
		// + ";databaseName=AUTH;user=sa;password=@qaxyz";
		try (Statement stmt = Initilization.ConnectDatabase(Initilization.ConnectionString, Initilization.username,
				Initilization.password)) {

			String SQL = "DECLARE @NTN NVARCHAR(50)  \n" +
					"SET @NTN ='"+NTN+"'\n" +
					"\n" +
					"DELETE FROM UPS.DBO.BillLineItem WHERE BillID IN (SELECT id FROM   UPS.DBO.Bill \n" +
					"WHERE  BillToPartyNTN = @NTN)  \n" +
					"\n" +
					"DELETE FROM   UPS.DBO.Bill \n" +
					"WHERE  BillToPartyNTN = @NTN  \n" +
					" \n" +
					" \n" +
					"DELETE  \n" +
					"FROM   FILENEST.dbo.[File] \n" +
					"WHERE  id IN (SELECT AttachedDocumentID  \n" +
					"              FROM   OGA.DBO.Attachment  \n" +
					"              WHERE  ownerdocumentid IN (SELECT id  \n" +
					"                                         FROM   OGA.DBO.AgencyBusinessRegistration \n" +
					"                                         WHERE  subscriptionid  IN (SELECT id\n" +
					"                                                                    FROM   AUTH.DBO.subscription  \n" +
					"                                                                    WHERE  subscriptionApplicationID IN (SELECT sa.ID  \n" +
					"                                                                                                         FROM     \n" +
					"                                                                                                                AUTH.DBO.SubscriptionApplication AS   \n" +
					"                                                                                                                sa  \n" +
					"                                                                                                         WHERE  sa.NTN =   \n" +
					"                                                                                                                @NTN))))  \n" +
					" \n" +
					"  \n" +
					"DELETE   \n" +
					"FROM   OGA.DBO.Attachment  \n" +
					"WHERE  ownerdocumentid IN (SELECT id  \n" +
					"                           FROM   OGA.DBO.AgencyBusinessRegistration  \n" +
					"                           WHERE  subscriptionid  IN (SELECT id  \n" +
					"                                                      FROM   AUTH.DBO.subscription  \n" +
					"                                                      WHERE  subscriptionApplicationID IN (SELECT sa.ID  \n" +
					"                                                                                           FROM     \n" +
					"                                                                                                  AUTH.DBO.SubscriptionApplication AS   \n" +
					"                                                                                                  sa  \n" +
					"                                                                                           WHERE  sa.NTN = @NTN)));    \n" +
					"  \n" +
					"DELETE   \n" +
					"FROM   auth.dbo.[NADRAMessageLog]  \n" +
					"WHERE  SubscriptionApplicationID IN (SELECT sa.ID  \n" +
					"                                     FROM   AUTH.DBO.SubscriptionApplication AS sa  \n" +
					"                                     WHERE  sa.NTN = @NTN);  \n" +
					"DELETE   \n" +
					"FROM   auth.dbo.OTPLog  \n" +
					"WHERE  SubscriptionApplicationID IN (SELECT sa.ID  \n" +
					"                                     FROM   AUTH.DBO.SubscriptionApplication AS sa  \n" +
					"                                     WHERE  sa.NTN = @NTN);  \n" +
					"  \n" +
					"DELETE   \n" +
					"FROM   AUTH.DBO.AuthorizedAgent \n" +
					"WHERE TraderNTN=@NTN OR AgentNTN = @NTN   \n" +
					"  \n" +
					"DELETE   \n" +
					"FROM   oga.dbo.RegistrationElementDataJson  \n" +
					"WHERE  OwnerDocumentID IN (SELECT abr.ID  \n" +
					"                           FROM   oga.dbo.AgencyBusinessRegistration AS abr  \n" +
					"                           WHERE  abr.BusinessID IN (SELECT o.ID  \n" +
					"                                                     FROM   auth.dbo.Organization AS o  \n" +
					"                                                     WHERE  o.SubscriptionApplicationID IN (SELECT sa.ID  \n" +
					"                                                                                            FROM    \n" +
					"                                                                                                   AUTH.DBO.SubscriptionApplication AS   \n" +
					"                                                                                                   sa  \n" +
					"                                                                                            WHERE  sa.NTN = @NTN)))  \n" +
					"                                                         \n" +
					"  \n" +
					"  \n" +
					"DELETE   \n" +
					"FROM   oga.dbo.AgencyBusinessRegistration  \n" +
					"WHERE  BusinessID IN (SELECT o.ID  \n" +
					"                      FROM   auth.dbo.Organization AS o  \n" +
					"                      WHERE  o.SubscriptionApplicationID IN ((  \n" +
					"                                                                SELECT sa.ID   \n" +
					"                                                                FROM   AUTH.DBO.SubscriptionApplication AS sa  \n" +
					"                                                                WHERE  sa.NTN = @NTN  \n" +
					"                                                            )))  \n" +
					"  \n" +
					"  \n" +
					"DELETE   \n" +
					"FROM   auth.dbo.OrganizationAddress  \n" +
					"WHERE  OrganizationID IN (SELECT o.ID  \n" +
					"                          FROM   auth.dbo.Organization AS o  \n" +
					"                          WHERE  o.SubscriptionApplicationID IN (SELECT sa.ID  \n" +
					"                                                                 FROM   AUTH.DBO.SubscriptionApplication AS sa  \n" +
					"                                                                 WHERE  sa.NTN = @NTN))  \n" +
					"   \n" +
					"DELETE  \n" +
					"FROM   auth.dbo.Director  \n" +
					"WHERE  OrganizationID IN (SELECT o.ID  \n" +
					"                          FROM   auth.dbo.Organization AS o \n" +
					"                          WHERE  o.SubscriptionApplicationID IN (SELECT sa.ID  \n" +
					"                                                                 FROM   AUTH.DBO.SubscriptionApplication AS sa  \n" +
					"                                                                WHERE  sa.NTN = @NTN))  \n" +
					"   \n" +
					"DELETE   \n" +
					"FROM   auth.dbo.Organization  \n" +
					"WHERE  SubscriptionApplicationID IN (SELECT sa.ID  \n" +
					"                                     FROM   AUTH.DBO.SubscriptionApplication AS sa  \n" +
					"                                     WHERE  sa.NTN = @NTN);  \n" +
					"  \n" +
					"DELETE  \n" +
					"FROM   AUTH.DBO.UserRole  \n" +
					"WHERE  AspNetUserID  IN (SELECT ANU.ID  \n" +
					"                         FROM   auth.dbo.AspNetUser AS anu  \n" +
					"                         WHERE  anu.RefDocumentID IN (SELECT sa.ID  \n" +
					"                                                      FROM   AUTH.DBO.SubscriptionApplication AS sa  \n" +
					"                                                      WHERE  sa.NTN = @NTN))   \n" +
					"  \n" +
					"DELETE FROM UserMenu WHERE AspNetUserID IN  (SELECT ANU.ID  \n" +
					"                         FROM   auth.dbo.AspNetUser AS anu  \n" +
					"                         WHERE  anu.RefDocumentID IN (SELECT sa.ID  \n" +
					"                                                      FROM   AUTH.DBO.SubscriptionApplication AS sa  \n" +
					"                                                      WHERE  sa.NTN = @NTN)) \n" +
					"  \n" +
					"DELETE   \n" +
					"FROM   auth.dbo.AspNetUser  \n" +
					"WHERE  RefDocumentID IN (SELECT sa.ID  \n" +
					"                         FROM   AUTH.DBO.SubscriptionApplication AS sa  \n" +
					"                         WHERE  sa.NTN = @NTN)  \n" +
					"  \n" +
					"  \n" +
					"DELETE   \n" +
					"FROM   AUTH.DBO.[Subscription]  \n" +
					"WHERE NTN = @NTN  \n" +
					"  \n" +
					"  \n" +
					"  \n" +
					"DELETE   \n" +
					"FROM   AUTH.DBO.SubscriptionApplication  \n" +
					"WHERE  NTN = @NTN\n";
			try {
				stmt.executeQuery(SQL);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
			System.out.println("Data Deleted Sucessfully");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
	}
	public static void DeleteAddressIDFromDataBase(String NTN) {

		// String connectionUrl = "jdbc:sqlserver://" + ConnectionString
		// + ";databaseName=AUTH;user=sa;password=@qaxyz";
		try (Statement stmt = Initilization.ConnectDatabase(Initilization.ConnectionString, Initilization.username,
				Initilization.password)) {

			String SQL = "Select * From Address where ID in(Select AddressID from\r\n"
					+ "AUTH.DBO.OrganizationAddress where OrganizationID in(Select ID from AUTH.DBO.Organization \r\n"
					+ "Where NTN = '"+NTN+"'))";
			try {
				stmt.executeQuery(SQL);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
			//	e.printStackTrace();
			}
			System.out.println("Data Deleted Sucessfully");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
	}
	public static void ResumeApplication(String ApID, String email)
	{
		
		Initilization.enter_Text("name", "applicationId", ApID);
		Initilization.enter_Text("name", "Email", email);
		Initilization.WebDriverWait(3);
		Initilization.click_On_Button("xpath", "//button[@type='submit']");
		Initilization.WebDriverWait(3);
	}
	
	public static void Login(String EnterUserName,String EnterPassword)
	{
		
		
		// This Line will enter the UserName in the username Field
		Initilization.enter_Text("name", "userName", EnterUserName);
		// This Line will enter the pasword in the pasword Field
		Initilization.enter_Text("name", "password", EnterPassword);
		// This Line will click on Submit Button
		Initilization.click_On_Button("css", "div>form>button");
		
		Initilization.WebDriverWait(3);
	}
	
	public static String FBRAPIData(String APIUrl, String NTN,String Parser)
	{
		RestAssured.baseURI = APIUrl;

		Response res = given().header("Authorization", "Bearer " + "5ef74cdc-1981-3bfc-8aef-74a03c0f7d56")
				.contentType("application/json")
				.body("{\r\n"
						+ "    \"IDENTIFICATION_NO\":\""+NTN+"\"\r\n"
						+ "}").when().post("");
		String body = res.getBody().jsonPath().getString(Parser);
		System.out.println(body);
		return body;
		
		
	}
	public static String GetCompanyFBRInfofromDatabase(String ColumnName,String NTN) {

		String Result = null;
			try (Statement stmt = Initilization.ConnectDatabase(Initilization.ConnectionString, Initilization.username,
				Initilization.password)) {
			String SQL = "use Auth \r\n"
					+ "Select * from CompanyInfoFBR where NTN = '"+NTN+"'";
			ResultSet rs = stmt.executeQuery(SQL);
			while (rs.next()) {
				Result = rs.getString(ColumnName);
			}
			System.out.println(Result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Result);
		return Result;
	}
	
	public static String GetOrganiazitonofNTN(String NTN,String ColumnName)
	{
		String Result = null;
		try (Statement stmt = Initilization.ConnectDatabase(Initilization.ConnectionString, Initilization.username,
				Initilization.password)) {
			String SQL = "use Auth Select name from Organization where NTN = '"+NTN+"'";
			ResultSet rs = stmt.executeQuery(SQL);
			while (rs.next()) {
				Result = rs.getString(ColumnName);
			}
			System.out.println(Result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Result);
		return Result;
	}
	
	/**
	 * This Method Allow the to Get the data from the database 
	 * 
	 * @param Quesries = Write your Desire Query 
	 * @param ColumnName             = Enter the Column Name 
	 * 
	 *                         Created by Muhammad Maaz
	 */
	public static String CustomeDatabaseQueries(String Quesries,String ColumnName)
	{
		String Result = null;
		try (Statement stmt = Initilization.ConnectDatabase(Initilization.ConnectionString, Initilization.username,
				Initilization.password)) {
			String SQL = Quesries;
			ResultSet rs = stmt.executeQuery(SQL);
			while (rs.next()) {
				Result = rs.getString(ColumnName);
			}
			System.out.println(Result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Result:: "+Result);
		return Result;
	}
	public static String CustomeDatabaseQueriesFullListofData(String Quesries,String ColumnName)
	{
		String Result ="";
		try (Statement stmt = Initilization.ConnectDatabase(Initilization.ConnectionString, Initilization.username,
				Initilization.password)) {
			String SQL = Quesries;
			ResultSet rs = stmt.executeQuery(SQL);
			while (rs.next()) {
				Result += rs.getString(ColumnName)+",";
			}
			System.out.println(Result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Result:: "+Result);
		return Result;
	}
	public static void ResumeApplicationNew(String APID, String Email)
	{
		Initilization.Reload();
		Initilization.WebDriverWait(3);
		Initilization.BrowserAlert("yes");
		Initilization.WebDriverWait(6);
		// Click on the resume application button
		Initilization.click_On_Button("xpath", SubscriptionLocators.resumeAppBtn_Loc);
		Initilization.WebDriverWait(5);

		Initilization.enter_Text("name", "applicationId", APID);
		Initilization.enter_Text("name", "Email", Email);
		Initilization.WebDriverWait(3);
		Initilization.click_On_Button("xpath", SubscriptionLocators.fetchApp_Loc);

	}
}
