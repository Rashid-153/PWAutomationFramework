package AutomationFrameWork.TestCases.SubscriptionTestCases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import AutomationFrameWork.Helpers.SubscriptionHelper;
import AutomationFrameWork.SetupFiles.Initilization;
import Locators.SubscriptionLocators;

public class SubscriptionNegatvieTestCases extends Initilization {

	@Parameters("browsers")
	@BeforeTest
	public static void BeforeTest(String BrowserName) {
		// Initialize Browser
		Initilization.BrowsersType = BrowserName;
		Initilization.URL = "https://"+Initilization.Environment+".psw.gov.pk/";

	}

	@DataProvider(name = "SubscriptionEndtoEnd")
	public static Object[][] credentials() {
		// QA Data
		return new Object[][] {

				
			{ "0656616", "3740502413553", "3172094681", "maazmaaz97@gmail.com" },
				 { "0000297", "1730113938011", "3172094681", "maazmaaz97@gmail.com" } ,  {
				  "0000298", "1730114351289", "3172094681", "maazmaaz97@gmail.com" }
				 };
//										 */
		
	}		
	
	///
	/// Welcome to PSW Subscription Page
	///
	//Ensure that Resume Application Feature Validation works perfectly or not
	@Test(description = "Resume Application with Invalid Application ID", enabled = true, dataProvider = "SubscriptionEndtoEnd")

	public static void TC1(String NTN, String CNIC, String phoneNum, String email) {

		String nTN_Sub_Data = NTN;
		String cnic_Sub_Data = CNIC;
		String email_Sub_Data = email;
		String mobileNumber_Sub_Data = phoneNum;
		
		SubscriptionHelper.DeleteApplicationIDFromDataBase(NTN);
		Initilization.OpenUrl(URL);
		// HomePage
		Initilization.WebDriverWait(12);
		// This Line will Click on Subscriber Button
		Initilization.click_On_Button("xpath", SubscriptionLocators.subscribeButtonCss);
		// Let the drive wait for the next page to load
		Initilization.WebDriverWait(3);
		
		Initilization.click_On_Button("xpath", SubscriptionLocators.resumeAppBtn_Loc);
		Initilization.WebDriverWait(3);

		Initilization.enter_Text("name", "applicationId", "121333");
		Initilization.enter_Text("name", "Email", email_Sub_Data);
		Initilization.WebDriverWait(3);
		Initilization.click_On_Button("xpath", SubscriptionLocators.fetchApp_Loc);
		Initilization.WebDriverWait(3);
		String actualResult =Initilization.Get_Bar_Validation_Msg("xpath", "//div[@role='alert']");
		
		Initilization.HardAssertion(null,null, actualResult, "Invalid Application ID.");
	
		Initilization.WebDriverWait(2);		
		Initilization.OpenUrl(URL);
		Initilization.BrowserAlert("yes");
		
		
	}

	@Test(description = "Resume Application with Invalid Email Format", enabled = false, dataProvider = "SubscriptionEndtoEnd")

	public static void TC2(String NTN, String CNIC, String phoneNum, String email) {

		String nTN_Sub_Data = NTN;
		String cnic_Sub_Data = CNIC;
		String email_Sub_Data = "maazmaaz@g.c";
		String mobileNumber_Sub_Data = phoneNum;
		
		SubscriptionHelper.DeleteApplicationIDFromDataBase(NTN);
		Initilization.OpenUrl(URL);
		// HomePage
		// This Line will Click on Subscriber Button
		Initilization.click_On_Button("xpath", SubscriptionLocators.subscribeButtonCss);
		// Let the drive wait for the next page to load
		Initilization.WebDriverWait(2);
		
		Initilization.click_On_Button("xpath", SubscriptionLocators.resumeAppBtn_Loc);
		Initilization.WebDriverWait(3);

		Initilization.enter_Text("name", "applicationId", "63475");
		Initilization.enter_Text("name", "Email", email_Sub_Data);
		Initilization.WebDriverWait(3);
		Initilization.click_On_Button("xpath", SubscriptionLocators.fetchApp_Loc);
		Initilization.WebDriverWait(3);
	//	String actualResult =Initilization.Get_Bar_Validation_Msg_ResumeApplication("xpath", "//div[@role='alert']");
		
		Initilization.HardAssertion("xpath", "//div[@role='alert']",null, "Please enter valid email.");
		
		Initilization.WebDriverWait(2);		
		Initilization.OpenUrl(URL);
		Initilization.BrowserAlert("yes");
		
		
	}
	@Test(description = "Resume Application without Application ID and Email", enabled = false, dataProvider = "SubscriptionEndtoEnd")

	public static void TC3(String NTN, String CNIC, String phoneNum, String email) {

		String nTN_Sub_Data = NTN;
		String cnic_Sub_Data = CNIC;
		String email_Sub_Data = "maazmaaz@g.c";
		String mobileNumber_Sub_Data = phoneNum;
		
		Initilization.OpenUrl(URL);
		// HomePage
		// This Line will Click on Subscriber Button
		Initilization.click_On_Button("xpath", SubscriptionLocators.subscribeButtonCss);
		// Let the drive wait for the next page to load
		Initilization.WebDriverWait(2);
		
		Initilization.click_On_Button("xpath", SubscriptionLocators.resumeAppBtn_Loc);
		Initilization.WebDriverWait(3);

		Initilization.WebDriverWait(3);
		Initilization.click_On_Button("xpath", SubscriptionLocators.fetchApp_Loc);
		Initilization.WebDriverWait(3);
		Initilization.HardAssertion("xpath","//div[normalize-space()='Application ID cannot be empty.']", null, "Application ID cannot be empty.");
		Initilization.HardAssertion("xpath","//div[normalize-space()='Email cannot be empty.']", null, "Email cannot be empty.");
	
		Initilization.WebDriverWait(2);		
		Initilization.OpenUrl(URL);
		Initilization.BrowserAlert("yes");
		
	}
	
	@Test(description = "SubscriptionEndtoEnd", enabled = false, dataProvider = "SubscriptionEndtoEnd")

	public static void TC4(String NTN, String CNIC, String phoneNum, String email) {
		// Data and Locators

		String nTN_Sub_Data = NTN;
		String cnic_Sub_Data = CNIC;
		String email_Sub_Data = email;
		String mobileNumber_Sub_Data = phoneNum;
		String smsOtp_IA_data;
		String emailOtp_IA_data;
		String userName = "UN-00-" + nTN_Sub_Data;
		Initilization.OpenUrl(URL);
		
		SubscriptionHelper.DeleteApplicationIDFromDataBase(NTN);
		// HomePage
		
			// This Line will Click on Subscriber Button
		Initilization.click_On_Button("xpath", SubscriptionLocators.subscribeButtonCss);
		// Let the drive wait for the next page to load
		Initilization.WebDriverWait(2);

		// Terms and Conditions Page
		//// This Line will Click on I Agree to the team and condition Button
		Initilization.click_On_CheckBox("xpath", SubscriptionLocators.iAgreeButtonX);

		// This Line will Click on Proceed Button
		Initilization.click_On_Button("xpath", SubscriptionLocators.proceedButtonX);
		Initilization.WebDriverWait(2);

		// Subscription Page
		// This Line will Add NTN Number in the NTN Field
		Initilization.click_On_Button("xpath", SubscriptionLocators.nTN_Sub_Loc);		
		Initilization.WebDriverWait(4);
		
		Initilization.HardAssertion("xpath", "//div[@role='alert']", null, "Please enter valid NTN.");
		
		Initilization.enter_Text("xpath", SubscriptionLocators.nTN_Sub_Loc, "!24!$%%");
		
		Initilization.HardAssertion("xpath", "//div[@role='alert']", null, "Please enter valid NTN.");
		
		Initilization.WebDriverWait(2);		
		Initilization.OpenUrl(URL);
		Initilization.BrowserAlert("yes");
		
		
		
}
	@Test(description = "SubscriptionEndtoEnd", enabled = false, dataProvider = "SubscriptionEndtoEnd")

	public static void TC5(String NTN, String CNIC, String phoneNum, String email) {
		// Data and Locators

		String nTN_Sub_Data = NTN;
		String cnic_Sub_Data = CNIC;
		String email_Sub_Data = email;
		String mobileNumber_Sub_Data = phoneNum;
		String smsOtp_IA_data;
		String emailOtp_IA_data;
		String userName = "UN-00-" + nTN_Sub_Data;
		Initilization.OpenUrl(URL);
		
		SubscriptionHelper.DeleteApplicationIDFromDataBase(NTN);
		// HomePage
		
			// This Line will Click on Subscriber Button
		Initilization.click_On_Button("xpath", SubscriptionLocators.subscribeButtonCss);
		// Let the drive wait for the next page to load
		Initilization.WebDriverWait(2);

		// Terms and Conditions Page
		//// This Line will Click on I Agree to the team and condition Button
		Initilization.click_On_CheckBox("xpath", SubscriptionLocators.iAgreeButtonX);

		// This Line will Click on Proceed Button
		Initilization.click_On_Button("xpath", SubscriptionLocators.proceedButtonX);
		Initilization.WebDriverWait(2);

		// Subscription Page
		// This Line will Add NTN Number in the NTN Field	
		Initilization.enter_Text("xpath", SubscriptionLocators.nTN_Sub_Loc, "0656616");
		
		Initilization.click_On_Button("xpath", SubscriptionLocators.validateButton_Sub_Loc);
		// Let the driver wait to check if the voucher is already generated or not
		Initilization.WebDriverWait(7);
		
		Initilization.enter_Text("xpath", SubscriptionLocators.email_Sub_Loc,"MFFA@DC");
		
		Initilization.click_On_Button("xpath", SubscriptionLocators.cnic_Sub_Loc);
		// This Line will Add Email in the Email Field
		// This Line will Add MobileNumber in the MobileNumber Field
		Initilization.click_On_Button("xpath", SubscriptionLocators.mobileNumber_Sub_Loc);
		
		
		
		Initilization.HardAssertion("xpath", "//div[normalize-space()='Please enter valid email.']", null, "Please enter valid email.");
		
		Initilization.HardAssertion("xpath", "//div[@id='input-cnic_error']", null, "Please enter 13 characters without special characters.");
		
		Initilization.HardAssertion("xpath", "(//div//div[@role='alert'])[3]", null, "Please enter 13 characters without special characters. e.g.+921231231231");
	
		Initilization.WebDriverWait(2);		
		Initilization.OpenUrl(URL);
		Initilization.BrowserAlert("yes");
		
}
	
	@Test(description = "SubscriptionEndtoEnd", enabled = false, dataProvider = "SubscriptionEndtoEnd")

	public static void TC6(String NTN, String CNIC, String phoneNum, String email) {
		// Data and Locators

		String nTN_Sub_Data = NTN;
		String cnic_Sub_Data = CNIC;
		String email_Sub_Data = email;
		String mobileNumber_Sub_Data = phoneNum;
		String smsOtp_IA_data;
		String emailOtp_IA_data;
		String userName = "UN-00-" + nTN_Sub_Data;
		Initilization.OpenUrl(URL);
		
		SubscriptionHelper.DeleteApplicationIDFromDataBase(NTN);
		// HomePage
		
			// This Line will Click on Subscriber Button
		Initilization.click_On_Button("xpath", SubscriptionLocators.subscribeButtonCss);
		// Let the drive wait for the next page to load
		Initilization.WebDriverWait(2);

		// Terms and Conditions Page
		//// This Line will Click on I Agree to the team and condition Button
		Initilization.click_On_CheckBox("xpath", SubscriptionLocators.iAgreeButtonX);

		// This Line will Click on Proceed Button
		Initilization.click_On_Button("xpath", SubscriptionLocators.proceedButtonX);
		Initilization.WebDriverWait(2);

		// Subscription Page
		// This Line will Add NTN Number in the NTN Field	
		Initilization.enter_Text("xpath", SubscriptionLocators.nTN_Sub_Loc, "0656616");
		
		Initilization.click_On_Button("xpath", SubscriptionLocators.validateButton_Sub_Loc);
		// Let the driver wait to check if the voucher is already generated or not
		Initilization.WebDriverWait(7);
		
		Initilization.enter_Text("xpath", SubscriptionLocators.email_Sub_Loc,"maazmaaz97@gmail.com");
		
		Initilization.enter_Text("xpath", SubscriptionLocators.cnic_Sub_Loc,"31231-2312313-1");
		// This Line will Add Email in the Email Field
		// This Line will Add MobileNumber in the MobileNumber Field
		Initilization.enter_Text("xpath", SubscriptionLocators.mobileNumber_Sub_Loc,"3172094681");
		
		Initilization.click_On_Button("xpath", SubscriptionLocators.generateVoucher_Sub_Loc);
		Initilization.WebDriverWait(3);
		String actualResult = Initilization.Get_Bar_Validation_Msg("xpath", "//div[@role='alert']");
		
		Initilization.HardAssertion(null, null, actualResult, "Please provide CNIC from the list populated.");
		
		Initilization.WebDriverWait(2);		
		Initilization.OpenUrl(URL);
		Initilization.BrowserAlert("yes");
		
}
	@Test(description = "SubscriptionEndtoEnd", enabled = false, dataProvider = "SubscriptionEndtoEnd")

	public static void TC7(String NTN, String CNIC, String phoneNum, String email) {
		// Data and Locators

		String nTN_Sub_Data = "0656616";
		String cnic_Sub_Data = "6110161741422";
		String email_Sub_Data = email;
		String mobileNumber_Sub_Data = "3236936736";
		String smsOtp_IA_data;
		String emailOtp_IA_data;
		String userName = "UN-00-" + nTN_Sub_Data;
		
		Initilization.OpenUrl(URL);
		SubscriptionHelper.DeleteApplicationIDFromDataBase(NTN);
		// HomePage
		
			// This Line will Click on Subscriber Button
		Initilization.click_On_Button("xpath", SubscriptionLocators.subscribeButtonCss);
		// Let the drive wait for the next page to load
		Initilization.WebDriverWait(2);

		// Terms and Conditions Page
		//// This Line will Click on I Agree to the team and condition Button
		Initilization.click_On_CheckBox("xpath", SubscriptionLocators.iAgreeButtonX);

		// This Line will Click on Proceed Button
		Initilization.click_On_Button("xpath", SubscriptionLocators.proceedButtonX);
		Initilization.WebDriverWait(2);

		// Subscription Page
		// This Line will Add NTN Number in the NTN Field
		Initilization.enter_Text("xpath", SubscriptionLocators.nTN_Sub_Loc, nTN_Sub_Data);
		// This Line will Click on Validate NTN Button
		Initilization.click_On_Button("xpath", SubscriptionLocators.validateButton_Sub_Loc);
		// Let the driver wait to check if the voucher is already generated or not
		Initilization.WebDriverWait(7);
		// This Line will Add CNIC in the CNIC Field
		Initilization.enter_Text("xpath", SubscriptionLocators.cnic_Sub_Loc, cnic_Sub_Data);
		// This Line will Add Email in the Email Field
		Initilization.enter_Text("xpath", SubscriptionLocators.email_Sub_Loc, email_Sub_Data);
		// This Line will Add MobileNumber in the MobileNumber Field
		Initilization.enter_Text("xpath", SubscriptionLocators.mobileNumber_Sub_Loc, mobileNumber_Sub_Data);
		// This Line will Click on Generated Voucher Button
		Initilization.click_On_Button("xpath", SubscriptionLocators.generateVoucher_Sub_Loc);
		// Initilization.UpdateBioMatricStatus(Url, Apid, Cnic);
		Initilization.WebDriverWait(3);

		// PaymentProcess Page
		// Gathering Payment Slip ID (PSID)
		String paymentSlip = Initilization.getTextcss(SubscriptionLocators.paymentSlip_Loc);
		paymentSlip = paymentSlip.substring(6, 23);
		System.out.println("PSID is 6 digits:" + paymentSlip);

		// Gathering Application ID (ApID)
		String ApID = Initilization.getText(SubscriptionLocators.ApIDText_Loc);

		System.out.println("ApID is :" + ApID);

		// Updating Status form unpaid to Paid by calling PaymentAPI
		Initilization.UpdatePaymentStatus(SubscriptionLocators.paymentUrl, paymentSlip);

		Initilization.WebDriverWait(3);

		Initilization.click_On_Button("xpath", SubscriptionLocators.paidButton);
		Initilization.click_On_Button("xpath", SubscriptionLocators.proceedBtn_Loc);
		Initilization.WebDriverWait(10);
		String actualResult = Initilization.Get_Bar_Validation_Msg("xpath", "//div[@role='alert']");
		
		Initilization.HardAssertion(null, null, actualResult, "Your Subscription application will expire after 2 attempt(s). The mobile number did not match with CNIC. Please enter a mobile number registered on the provided CNIC. You may contact the mobile service provider for further confirmation. Corporate mobile numbers are also required to be registered on your CNIC instead of NTN.");
		
		Initilization.WebDriverWait(2);		
		Initilization.OpenUrl(URL);
		Initilization.BrowserAlert("yes");
		

		}
	@Test(description = "SubscriptionEndtoEnd", enabled = false, dataProvider = "SubscriptionEndtoEnd")

	public static void TC8(String NTN, String CNIC, String phoneNum, String email) {
		// Data and Locators

		String nTN_Sub_Data = "0656616";
		String cnic_Sub_Data = "6110161741422";
		String email_Sub_Data = email;
		String mobileNumber_Sub_Data = phoneNum;
		String smsOtp_IA_data;
		String emailOtp_IA_data;
		String userName = "UN-00-" + nTN_Sub_Data;
		
		Initilization.OpenUrl(URL);
		//SubscriptionHelper.DeleteApplicationIDFromDataBase(NTN);
		// HomePage
		
			// This Line will Click on Subscriber Button
		Initilization.click_On_Button("xpath", SubscriptionLocators.subscribeButtonCss);
		// Let the drive wait for the next page to load
		Initilization.WebDriverWait(2);

		// Terms and Conditions Page
		//// This Line will Click on I Agree to the team and condition Button
		Initilization.click_On_CheckBox("xpath", SubscriptionLocators.iAgreeButtonX);

		// This Line will Click on Proceed Button
		Initilization.click_On_Button("xpath", SubscriptionLocators.proceedButtonX);
		Initilization.WebDriverWait(2);

		// Subscription Page
		// This Line will Add NTN Number in the NTN Field
		Initilization.enter_Text("xpath", SubscriptionLocators.nTN_Sub_Loc, nTN_Sub_Data);
		// This Line will Click on Validate NTN Button
		Initilization.click_On_Button("xpath", SubscriptionLocators.validateButton_Sub_Loc);
		// Let the driver wait to check if the voucher is already generated or not
		Initilization.WebDriverWait(7);
		// This Line will Add CNIC in the CNIC Field
		Initilization.enter_Text("xpath", SubscriptionLocators.cnic_Sub_Loc, cnic_Sub_Data);
		// This Line will Add Email in the Email Field
		Initilization.enter_Text("xpath", SubscriptionLocators.email_Sub_Loc, email_Sub_Data);
		// This Line will Add MobileNumber in the MobileNumber Field
		Initilization.enter_Text("xpath", SubscriptionLocators.mobileNumber_Sub_Loc, mobileNumber_Sub_Data);
		// This Line will Click on Generated Voucher Button
		Initilization.click_On_Button("xpath", SubscriptionLocators.generateVoucher_Sub_Loc);
		// Initilization.UpdateBioMatricStatus(Url, Apid, Cnic);
		Initilization.WebDriverWait(3);

		// PaymentProcess Page
		// Gathering Payment Slip ID (PSID)
		String paymentSlip = Initilization.getTextcss(SubscriptionLocators.paymentSlip_Loc);
		paymentSlip = paymentSlip.substring(6, 23);
		System.out.println("PSID is 6 digits:" + paymentSlip);

		// Gathering Application ID (ApID)
		String ApID = Initilization.getText(SubscriptionLocators.ApIDText_Loc);

		System.out.println("ApID is :" + ApID);

		// Updating Status form unpaid to Paid by calling PaymentAPI
		Initilization.UpdatePaymentStatus(SubscriptionLocators.paymentUrl, paymentSlip);

		Initilization.WebDriverWait(3);

		Initilization.click_On_Button("xpath", SubscriptionLocators.paidButton);
		Initilization.click_On_Button("xpath", SubscriptionLocators.proceedBtn_Loc);
		Initilization.WebDriverWait(3);

		// Clicking on Send OTP Button
		Initilization.click_On_Button("xpath", SubscriptionLocators.sendOTPBtn_Loc);
		Initilization.WebDriverWait(3);
		emailOtp_IA_data = "ffffff";
		System.out.println("Email OTP:" + emailOtp_IA_data);
		smsOtp_IA_data = "ffffff";
		System.out.println("Sms OTP:" + smsOtp_IA_data);
		// Initilization.WebDriverWait(4);
		Initilization.enter_Text("xpath", SubscriptionLocators.smsOtp_IA_Loc, smsOtp_IA_data);
		Initilization.enter_Text("xpath", SubscriptionLocators.emailOtp_IA_Loc, emailOtp_IA_data);
		Initilization.WebDriverWait(3);
		
		Initilization.HardAssertion("xpath", "//div[normalize-space()='Please enter valid mobile OTP']", null, "Please enter valid mobile OTP");
		Initilization.HardAssertion("xpath", "//div[normalize-space()='Please enter valid email OTP']", null, "Please enter valid email OTP");
		
		
		Initilization.WebDriverWait(2);		
		Initilization.OpenUrl(URL);
		Initilization.BrowserAlert("yes");
		
	}
	
	@Test(description = "SubscriptionEndtoEnd", enabled = false, dataProvider = "SubscriptionEndtoEnd", invocationCount = 80)

	public static void TC9(String NTN, String CNIC, String phoneNum, String email) {
		// Data and Locators

		String nTN_Sub_Data = NTN;
		String cnic_Sub_Data = CNIC;
		String email_Sub_Data = email;
		String mobileNumber_Sub_Data = phoneNum;
		String smsOtp_IA_data;
		String emailOtp_IA_data;
		String userName = "UN-00-" + nTN_Sub_Data;
		
		Initilization.OpenUrl(URL);
		//SubscriptionHelper.DeleteApplicationIDFromDataBase(NTN);
		// HomePage
		
			// This Line will Click on Subscriber Button
		Initilization.click_On_Button("xpath", SubscriptionLocators.subscribeButtonCss);
		// Let the drive wait for the next page to load
		Initilization.WebDriverWait(2);

		// Terms and Conditions Page
		//// This Line will Click on I Agree to the team and condition Button
		Initilization.click_On_CheckBox("xpath", SubscriptionLocators.iAgreeButtonX);

		// This Line will Click on Proceed Button
		Initilization.click_On_Button("xpath", SubscriptionLocators.proceedButtonX);
		Initilization.WebDriverWait(2);

		// Subscription Page
		// This Line will Add NTN Number in the NTN Field
		Initilization.enter_Text("xpath", SubscriptionLocators.nTN_Sub_Loc, nTN_Sub_Data);
		// This Line will Click on Validate NTN Button
		Initilization.click_On_Button("xpath", SubscriptionLocators.validateButton_Sub_Loc);
		// Let the driver wait to check if the voucher is already generated or not
		Initilization.WebDriverWait(7);
		// This Line will Add CNIC in the CNIC Field
		Initilization.enter_Text("xpath", SubscriptionLocators.cnic_Sub_Loc, cnic_Sub_Data);
		// This Line will Add Email in the Email Field
		Initilization.enter_Text("xpath", SubscriptionLocators.email_Sub_Loc, email_Sub_Data);
		// This Line will Add MobileNumber in the MobileNumber Field
		Initilization.enter_Text("xpath", SubscriptionLocators.mobileNumber_Sub_Loc, mobileNumber_Sub_Data);
		// This Line will Click on Generated Voucher Button
		Initilization.click_On_Button("xpath", SubscriptionLocators.generateVoucher_Sub_Loc);
		// Initilization.UpdateBioMatricStatus(Url, Apid, Cnic);
		Initilization.WebDriverWait(3);

		// PaymentProcess Page
		// Gathering Payment Slip ID (PSID)
		String paymentSlip = Initilization.getTextcss(SubscriptionLocators.paymentSlip_Loc);
		paymentSlip = paymentSlip.substring(6, 23);
		System.out.println("PSID is 6 digits:" + paymentSlip);

		// Gathering Application ID (ApID)
		String ApID = Initilization.getText(SubscriptionLocators.ApIDText_Loc);

		System.out.println("ApID is :" + ApID);

		// Updating Status form unpaid to Paid by calling PaymentAPI
		Initilization.UpdatePaymentStatus(SubscriptionLocators.paymentUrl, paymentSlip);

		Initilization.WebDriverWait(3);

	
		
		Initilization.WebDriverWait(2);		
		Initilization.OpenUrl(URL);
		Initilization.BrowserAlert("yes");
		
	}

}
