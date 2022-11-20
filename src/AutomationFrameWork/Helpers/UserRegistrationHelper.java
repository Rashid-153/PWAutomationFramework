package AutomationFrameWork.Helpers;

import java.sql.SQLException;
import java.sql.Statement;

import AutomationFrameWork.SetupFiles.Initilization;

public class UserRegistrationHelper {

	public static void clearUserRegistrationFromDataBase(String NTN) {

		// String connectionUrl = "jdbc:sqlserver://" + ConnectionString
		// + ";databaseName=AUTH;user=sa;password=@qaxyz";
		try (Statement stmt = Initilization.ConnectDatabase(Initilization.ConnectionString, Initilization.username,
				Initilization.password)) {

			String SQL = "DECLARE @NTN NVARCHAR(50) \r\n"
					+ "SET @NTN = '"+NTN+"'\r\n"
					+ "\r\n"
					+ "DELETE \r\n"
					+ "FROM   FILENEST.dbo.[File]\r\n"
					+ "WHERE  id IN (SELECT AttachedDocumentID\r\n"
					+ "              FROM   OGA.DBO.Attachment\r\n"
					+ "              WHERE  ownerdocumentid IN (SELECT id\r\n"
					+ "                                         FROM   OGA.DBO.AgencyBusinessRegistration\r\n"
					+ "                                         WHERE  subscriptionid  IN (SELECT id\r\n"
					+ "                                                                    FROM   AUTH.DBO.subscription\r\n"
					+ "                                                                    WHERE  subscriptionApplicationID IN (SELECT sa.ID\r\n"
					+ "                                                                                                         FROM   \r\n"
					+ "                                                                                                                AUTH.DBO.SubscriptionApplication AS \r\n"
					+ "                                                                                                                sa\r\n"
					+ "                                                                                                         WHERE  sa.NTN = \r\n"
					+ "                                                                                                                @NTN))))\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "DELETE \r\n"
					+ "FROM   OGA.DBO.Attachment\r\n"
					+ "WHERE  ownerdocumentid IN (SELECT id\r\n"
					+ "                           FROM   OGA.DBO.AgencyBusinessRegistration\r\n"
					+ "                           WHERE  subscriptionid  IN (SELECT id\r\n"
					+ "                                                      FROM   AUTH.DBO.subscription\r\n"
					+ "                                                      WHERE  subscriptionApplicationID IN (SELECT sa.ID\r\n"
					+ "                                                                                           FROM   \r\n"
					+ "                                                                                                  AUTH.DBO.SubscriptionApplication AS \r\n"
					+ "                                                                                                  sa\r\n"
					+ "                                                                                           WHERE  sa.NTN = @NTN)));  \r\n"
					+ "\r\n"
					+ "DELETE \r\n"
					+ "FROM   AUTH.DBO.AuthorizedAgent\r\n"
					+ "WHERE  TraderAspNetUserID IN (SELECT auth.dbo.AspNetUser.ID\r\n"
					+ "                              FROM   auth.dbo.AspNetUser\r\n"
					+ "                              WHERE  RefDocumentID IN (SELECT sa.ID\r\n"
					+ "                                                       FROM   AUTH.DBO.SubscriptionApplication AS sa\r\n"
					+ "                                                       WHERE  sa.NTN = @NTN))\r\n"
					+ "DELETE \r\n"
					+ "FROM   oga.dbo.RegistrationElementDataJson\r\n"
					+ "WHERE  OwnerDocumentID IN (SELECT abr.ID\r\n"
					+ "                           FROM   oga.dbo.AgencyBusinessRegistration AS abr\r\n"
					+ "                           WHERE  abr.BusinessID IN (SELECT o.ID\r\n"
					+ "                                                     FROM   auth.dbo.Organization AS o\r\n"
					+ "                                                     WHERE  o.SubscriptionApplicationID IN (SELECT sa.ID\r\n"
					+ "                                                                                            FROM   \r\n"
					+ "                                                                                                   AUTH.DBO.SubscriptionApplication AS \r\n"
					+ "                                                                                                   sa\r\n"
					+ "                                                                                            WHERE  sa.NTN = @NTN)))\r\n"
					+ "DELETE \r\n"
					+ "FROM   oga.dbo.AgencyBusinessRegistration\r\n"
					+ "WHERE  BusinessID IN (SELECT o.ID\r\n"
					+ "                      FROM   auth.dbo.Organization AS o\r\n"
					+ "                      WHERE  o.SubscriptionApplicationID IN ((\r\n"
					+ "                                                                SELECT sa.ID\r\n"
					+ "                                                                FROM   AUTH.DBO.SubscriptionApplication AS sa\r\n"
					+ "                                                                WHERE  sa.NTN = @NTN\r\n"
					+ "                                                            )))\r\n"
					+ "\r\n"
					+ "DELETE \r\n"
					+ "FROM   AUTH.DBO.UserRole\r\n"
					+ "WHERE  AspNetUserID  IN (SELECT ANU.ID\r\n"
					+ "                         FROM   auth.dbo.AspNetUser AS anu\r\n"
					+ "                         WHERE  anu.RefDocumentID IN (SELECT sa.ID\r\n"
					+ "                                                      FROM   AUTH.DBO.SubscriptionApplication AS sa\r\n"
					+ "                                                      WHERE  sa.NTN = @NTN)) AND RoleCode IN ('TR','CA')\r\n"
					+ "                                                      \r\n"
					+ "UPDATE auth.dbo.AspNetUser SET LastLoggedInRoleCode = 'UN' WHERE ID = (SELECT auth.dbo.AspNetUser.ID\r\n"
					+ "                              FROM   auth.dbo.AspNetUser\r\n"
					+ "                              WHERE  RefDocumentID IN (SELECT sa.ID\r\n"
					+ "                                                       FROM   AUTH.DBO.SubscriptionApplication AS sa\r\n"
					+ "                                                       WHERE  sa.NTN = @NTN))\r\n"
					+ "";
			try {
				stmt.executeQuery(SQL);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Data Deleted Sucessfully");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
