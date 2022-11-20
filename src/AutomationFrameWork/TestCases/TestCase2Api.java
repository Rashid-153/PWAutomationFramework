package AutomationFrameWork.TestCases;
import org.testng.annotations.Test;

import AutomationFrameWork.SetupFiles.AES;
import AutomationFrameWork.SetupFiles.Initilization;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
public class TestCase2Api {
	
	
	@Test

	
	
/*
 * public static void ConnectDatabase()
	 {   
		

        // Create a variable for the connection string.
        String connectionUrl = "jdbc:sqlserver://10.100.240.61:1433;databaseName=AUTH;user=sa;password=@Password1";

        try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
            //String SQL = "SELECT TOP 10 * FROM otplog";
        	String SQL = "SELECT * FROM otplog";
        	ResultSet rs = stmt.executeQuery(SQL);
            

            // Iterate through the data in the result set and display it.
            while (rs.next()) {
            	
                System.out.println(rs.getString("channelid") + " " + rs.getString("otpcode"));
                
            }
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
	 }
     */
     //GetsmsOTPFromDataBase
	public static void GetsmsOTPFromDataBase1(String ConnectionString,String APID) throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException
		{   
	
		
		//String[] data = new String[11] ;
		int pos =0;
		//APID6373
		APID ="6373"; 
		ConnectionString = "10.100.240.61:1433";

       // Create a variable for the connection string.
     String connectionUrl = "jdbc:sqlserver://10.100.240.61:1433;databaseName=AUTH;user=sa;password=@Password1";
		//String connectionUrl = "jdbc:sqlserver://"+ConnectionString+";databaseName=AUTH;user=sa;password=@Password1";
	     try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
        String SQL = "select Top 1 * from otplog where subscriptionApplicationID = '"+APID+"' and channelID = 1 order by createdOn desc";
       	//String SQL = "SELECT * FROM otplog";
       	ResultSet rs = stmt.executeQuery(SQL);
       	
       	

           // Iterate through the data in the result set and display it.
           while (rs.next()) {
        	   String data = rs.getString("otpcode");
        	   String Result;
        	   AES obj1 = new AES("#PSW-OTP-KEY-123");
               Result = obj1.soften(data);
        	
             
        	   System.out.println(Result);
             
               
           }
       }
       // Handle any errors that may have occurred.
       catch (SQLException e) {
           e.printStackTrace();
       }
      // return data;
	 
	
		
	 }
        
		
}



