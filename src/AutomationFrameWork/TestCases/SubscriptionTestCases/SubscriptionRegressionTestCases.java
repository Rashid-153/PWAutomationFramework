package AutomationFrameWork.TestCases.SubscriptionTestCases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import AutomationFrameWork.Helpers.SubscriptionHelper;
import AutomationFrameWork.SetupFiles.Initilization;
import Locators.SubscriptionLocators;

public class SubscriptionRegressionTestCases extends Initilization {

	@Parameters("browsers")
	@BeforeTest
	public static void BeforeTest(String BrowserName) {
		// Initialize Browser
		Initilization.BrowsersType = BrowserName;
		Initilization.URL = "https://" + Initilization.Environment + ".psw.gov.pk/";

	}

	@DataProvider(name = "SubscriptionEndtoEnd")
	public static Object[][] credentials() {
		// QA Data
		return new Object[][] {

				/*
				 * 
				 * { "0000292", "3740504274611", "3172094681", "maazmaaz97@gmail.com" },
				 */
				/*
				 * { "0656635", "3740502413553", "3172094681", "maazmaaz97@gmail.com" },
				 */ { "0000297", "1730113938011", "3172094681",
						"maazmaaz97@gmail.com" }/*
												 * , { "0000298", "1730114351289", "3172094681", "maazmaaz97@gmail.com"
												 * }
												 */

		};
//										 

	}

	// Fbr Validation STRN
	@Test(description = "Fbr Validation STRN", enabled = true, dataProvider = "SubscriptionEndtoEnd")
	public static void TC10(String NTN, String CNIC, String phoneNum, String email) {
		String nTN_Sub_Data = NTN;
		String cnic_Sub_Data = CNIC;
		String email_Sub_Data = email;
		String mobileNumber_Sub_Data = phoneNum;
		String smsOtp_IA_data;
		String emailOtp_IA_data;
		String userName = "UN-00-" + nTN_Sub_Data;

		SubscriptionHelper.DeleteApplicationIDFromDataBase(NTN);
		Initilization.OpenUrl(Initilization.URL);
		// HomePage
		Initilization.WebDriverWait(10);
		// This Line will Click on Subscriber Button
		Initilization.click_On_Button("xpath", SubscriptionLocators.subscribeButtonCss);
		// Let the drive wait for the next page to load
		Initilization.WebDriverWait(10);

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

		String CompanyNameAPI = SubscriptionHelper.FBRAPIData("https://gw.fbr.gov.pk/psw/1/details", NTN,
				"PROFILE.NAME");
		String CompanyNameDatabase = SubscriptionHelper.GetCompanyFBRInfofromDatabase("Name", NTN);

		Initilization.HardAssertion(null, null, CompanyNameAPI, CompanyNameDatabase);

		String CompanySTRNAPI = SubscriptionHelper.FBRAPIData("https://gw.fbr.gov.pk/psw/1/details", NTN,
				"PROFILE.STRN");
		String CompanySTRNDatabase = SubscriptionHelper.GetCompanyFBRInfofromDatabase("STRN", NTN);

		Initilization.HardAssertion(null, null, CompanySTRNAPI, CompanySTRNDatabase);

	}

	// Validate NTN with Fbr API
	@Test(description = "Fbr Validation NTN", enabled = true, dataProvider = "SubscriptionEndtoEnd")
	public static void TC13(String NTN, String CNIC, String phoneNum, String email) {

		String nTN_Sub_Data = NTN;
		String cnic_Sub_Data = CNIC;
		String email_Sub_Data = email;
		String mobileNumber_Sub_Data = phoneNum;
		String smsOtp_IA_data;
		String emailOtp_IA_data;
		String userName = "UN-00-" + nTN_Sub_Data;

		SubscriptionHelper.DeleteApplicationIDFromDataBase(NTN);
		Initilization.OpenUrl(Initilization.URL);
		// HomePage
		Initilization.WebDriverWait(10);
		// This Line will Click on Subscriber Button
		Initilization.click_On_Button("xpath", SubscriptionLocators.subscribeButtonCss);
		// Let the drive wait for the next page to load
		Initilization.WebDriverWait(10);

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

		String CompanyNTN = SubscriptionHelper.FBRAPIData("https://gw.fbr.gov.pk/psw/1/details", NTN, "PROFILE.NTN");
		CompanyNTN = CompanyNTN.substring(0, 7);
		String Query = "use Auth Select NTN from SubscriptionApplication where NTN = '" + NTN + "'";
		String DbNTN = SubscriptionHelper.CustomeDatabaseQueries(Query, "NTN");
		Initilization.HardAssertion(null, null, CompanyNTN, DbNTN);

	}

	// Fbr Validation Principle Activity
	// Validate Principle Activity with
	@Test(description = "Fbr Validation Principle Activity", enabled = true, dataProvider = "SubscriptionEndtoEnd")
	public static void TC14(String NTN, String CNIC, String phoneNum, String email) {

		String nTN_Sub_Data = NTN;
		String cnic_Sub_Data = CNIC;
		String email_Sub_Data = email;
		String mobileNumber_Sub_Data = phoneNum;
		String smsOtp_IA_data;
		String emailOtp_IA_data;
		String userName = "UN-00-" + nTN_Sub_Data;

		SubscriptionHelper.DeleteApplicationIDFromDataBase(NTN);
		Initilization.OpenUrl(Initilization.URL);
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

		String CompanyPrincipleActivity = SubscriptionHelper.FBRAPIData("https://gw.fbr.gov.pk/psw/1/details", NTN,
				"BUSINESS.PRINCIPAL_BUSINESS_ACTIVITY");
		String Query = "use Auth Select PrcpLineOfBusiness from Organization where NTN ='" + NTN + "'";
		String DbNTN = SubscriptionHelper.CustomeDatabaseQueries(Query, "PrcpLineOfBusiness");

		Initilization.HardAssertion(null, null, CompanyPrincipleActivity, DbNTN);

	}

	// When VerifiationFlag is 1
	// When VerifiationFlag is 1
	@Test(description = "When VerifiationFlag is 1", enabled = true, dataProvider = "SubscriptionEndtoEnd")
	public static void TC15(String NTN, String CNIC, String phoneNum, String email) {

		String nTN_Sub_Data = NTN;
		String cnic_Sub_Data = CNIC;
		String email_Sub_Data = email;
		String mobileNumber_Sub_Data = phoneNum;
		String smsOtp_IA_data;
		String emailOtp_IA_data;
		String userName = "UN-00-" + nTN_Sub_Data;

		SubscriptionHelper.DeleteApplicationIDFromDataBase(NTN);
		Initilization.OpenUrl(Initilization.URL);
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

		String Query = "use Auth Select VerificationFlag from SubscriptionApplication where NTN = '" + NTN + "'";
		String DbNTN = SubscriptionHelper.CustomeDatabaseQueries(Query, "VerificationFlag");

		Initilization.HardAssertion(null, null, "1", DbNTN);
	}

	// When VerifiationFlag is 9
	// When VerifiationFlag is 9
	@Test(description = "When VerifiationFlag is 9", enabled = true, dataProvider = "SubscriptionEndtoEnd")
	public static void TC16(String NTN, String CNIC, String phoneNum, String email) {
		String nTN_Sub_Data = NTN;
		String cnic_Sub_Data = CNIC;
		String email_Sub_Data = email;
		String mobileNumber_Sub_Data = phoneNum;
		String smsOtp_IA_data;
		String emailOtp_IA_data;
		String userName = "UN-00-" + nTN_Sub_Data;

		SubscriptionHelper.DeleteApplicationIDFromDataBase(NTN);
		Initilization.OpenUrl(Initilization.URL);
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

		String Query = "use Auth Select VerificationFlag from SubscriptionApplication where NTN = '" + NTN + "'";
		String DbNTN = SubscriptionHelper.CustomeDatabaseQueries(Query, "VerificationFlag");

		Initilization.HardAssertion(null, null, "9", DbNTN);
	}

	// When VerifiationFlag is 73
	// When VerifiationFlag is 73
	@Test(description = "When VerifiationFlag is 73", enabled = true, dataProvider = "SubscriptionEndtoEnd")
	public static void TC17(String NTN, String CNIC, String phoneNum, String email) {
		String nTN_Sub_Data = NTN;
		String cnic_Sub_Data = CNIC;
		String email_Sub_Data = email;
		String mobileNumber_Sub_Data = phoneNum;
		String smsOtp_IA_data;
		String emailOtp_IA_data;
		String userName = "UN-00-" + nTN_Sub_Data;

		SubscriptionHelper.DeleteApplicationIDFromDataBase(NTN);
		Initilization.OpenUrl(Initilization.URL);
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

		String Query = "use Auth Select VerificationFlag from SubscriptionApplication where NTN = '" + NTN + "'";
		String DbNTN = SubscriptionHelper.CustomeDatabaseQueries(Query, "VerificationFlag");

		Initilization.HardAssertion(null, null, "73", DbNTN);

	}

	// When VerifiationFlag is 89
	// When VerifiationFlag is 89
	@Test(description = "When VerifiationFlag is 89", enabled = true, dataProvider = "SubscriptionEndtoEnd")
	public static void TC18(String NTN, String CNIC, String phoneNum, String email) {
		String nTN_Sub_Data = NTN;
		String cnic_Sub_Data = CNIC;
		String email_Sub_Data = email;
		String mobileNumber_Sub_Data = phoneNum;
		String smsOtp_IA_data;
		String emailOtp_IA_data;
		String userName = "UN-00-" + nTN_Sub_Data;

		SubscriptionHelper.DeleteApplicationIDFromDataBase(NTN);
		Initilization.OpenUrl(Initilization.URL);
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
		emailOtp_IA_data = SubscriptionHelper.GetEmailOTPFromDataBase(ApID);
		System.out.println("Email OTP:" + emailOtp_IA_data);
		smsOtp_IA_data = SubscriptionHelper.GetsmsOTPFromDataBase(ApID);
		System.out.println("Sms OTP:" + smsOtp_IA_data);
		// Initilization.WebDriverWait(4);
		Initilization.enter_Text("xpath", SubscriptionLocators.smsOtp_IA_Loc, smsOtp_IA_data);
		Initilization.enter_Text("xpath", SubscriptionLocators.emailOtp_IA_Loc, emailOtp_IA_data);
		Initilization.WebDriverWait(3);
		Initilization.click_On_Button("xpath", SubscriptionLocators.submitButton_IA_Loc);

		String Query = "use Auth Select VerificationFlag from SubscriptionApplication where NTN = '" + NTN + "'";
		String DbNTN = SubscriptionHelper.CustomeDatabaseQueries(Query, "VerificationFlag");

		Initilization.HardAssertion(null, null, "89", DbNTN);

	}

	// When VerifiationFlag is 125
	// When VerifiationFlag is 125
	@Test(description = "When VerifiationFlag is 125", enabled = true, dataProvider = "SubscriptionEndtoEnd")
	public static void TC19(String NTN, String CNIC, String phoneNum, String email) {
		String nTN_Sub_Data = NTN;
		String cnic_Sub_Data = CNIC;
		String email_Sub_Data = email;
		String mobileNumber_Sub_Data = phoneNum;
		String smsOtp_IA_data;
		String emailOtp_IA_data;
		String userName = "UN-00-" + nTN_Sub_Data;

		SubscriptionHelper.DeleteApplicationIDFromDataBase(NTN);
		Initilization.OpenUrl(Initilization.URL);
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
		emailOtp_IA_data = SubscriptionHelper.GetEmailOTPFromDataBase(ApID);
		System.out.println("Email OTP:" + emailOtp_IA_data);
		smsOtp_IA_data = SubscriptionHelper.GetsmsOTPFromDataBase(ApID);
		System.out.println("Sms OTP:" + smsOtp_IA_data);
		// Initilization.WebDriverWait(4);
		Initilization.enter_Text("xpath", SubscriptionLocators.smsOtp_IA_Loc, smsOtp_IA_data);
		Initilization.enter_Text("xpath", SubscriptionLocators.emailOtp_IA_Loc, emailOtp_IA_data);
		Initilization.WebDriverWait(3);
		Initilization.click_On_Button("xpath", SubscriptionLocators.submitButton_IA_Loc);

		// BioMatric Update
		Initilization.UpdateBioMetricStatus(SubscriptionLocators.biometricUrl, ApID, cnic_Sub_Data);

		// Reloading Page for resume application
		Initilization.Reload();
		Initilization.WebDriverWait(3);
		Initilization.BrowserAlert("yes");
		Initilization.WebDriverWait(8);
		// Click on the resume application button
		Initilization.click_On_Button("xpath", SubscriptionLocators.resumeAppBtn_Loc);
		Initilization.WebDriverWait(3);

		Initilization.enter_Text("name", "applicationId", ApID);
		Initilization.enter_Text("name", "Email", email_Sub_Data);
		Initilization.WebDriverWait(3);
		Initilization.click_On_Button("xpath", SubscriptionLocators.fetchApp_Loc);

		// BioMetric Page
		Initilization.WebDriverWait(3);
		Initilization.click_On_Button("xpath", SubscriptionLocators.biomatric_Proceed_btn_Loc);
		Initilization.WebDriverWait(3);
		String Query = "use Auth Select VerificationFlag from SubscriptionApplication where NTN = '" + NTN + "'";
		String DbNTN = SubscriptionHelper.CustomeDatabaseQueries(Query, "VerificationFlag");

		Initilization.HardAssertion(null, null, "125", DbNTN);
	}

	// PMD Validation Mobile
	// PMD Validation Mobile
	@Test(description = "PMD Validation Mobile", enabled = true, dataProvider = "SubscriptionEndtoEnd")
	public static void TC20(String NTN, String CNIC, String phoneNum, String email) {
		String nTN_Sub_Data = NTN;
		String cnic_Sub_Data = CNIC;
		String email_Sub_Data = email;
		String mobileNumber_Sub_Data = phoneNum;
		String smsOtp_IA_data;
		String emailOtp_IA_data;
		String userName = "UN-00-" + nTN_Sub_Data;

		SubscriptionHelper.DeleteApplicationIDFromDataBase(NTN);
		Initilization.OpenUrl(Initilization.URL);
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

		Initilization.ClearField("xpath", SubscriptionLocators.mobileNumber_Sub_Loc);

		Initilization.enter_Text("xpath", SubscriptionLocators.mobileNumber_Sub_Loc, "3172094680");

		Initilization.click_On_Button("xpath", SubscriptionLocators.proceedBtn_Loc);
		Initilization.WebDriverWait(3);

		String actual = Get_Bar_Validation_Msg("xpath", "//*[@role=\"alert\"]");

		Initilization.HardAssertion(null, null, actual,
				"Your Subscription application will expire after 2 attempt(s). The mobile number did not match with CNIC. Please enter a mobile number registered on the provided CNIC. You may contact the mobile service provider for further confirmation. Corporate mobile numbers are also required to be registered on your CNIC instead of NTN.");
	}

	// Resume subscripiton at each step Assertion Missing
	// Resume subscripiton at each step Assertion Missing
	@Test(description = "Resume subscripiton at each step", enabled = true, dataProvider = "SubscriptionEndtoEnd")
	public static void TC21(String NTN, String CNIC, String phoneNum, String email) {
		String nTN_Sub_Data = NTN;
		String cnic_Sub_Data = CNIC;
		String email_Sub_Data = email;
		String mobileNumber_Sub_Data = phoneNum;
		String smsOtp_IA_data;
		String emailOtp_IA_data;
		String userName = "UN-00-" + nTN_Sub_Data;

		SubscriptionHelper.DeleteApplicationIDFromDataBase(NTN);
		Initilization.OpenUrl(Initilization.URL);
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

		SubscriptionHelper.ResumeApplicationNew(ApID, email_Sub_Data);

		// Updating Status form unpaid to Paid by calling PaymentAPI
		Initilization.UpdatePaymentStatus(SubscriptionLocators.paymentUrl, paymentSlip);

		Initilization.WebDriverWait(3);

		SubscriptionHelper.ResumeApplicationNew(ApID, email_Sub_Data);
		Initilization.WebDriverWait(3);
		Initilization.click_On_Button("xpath", SubscriptionLocators.proceedBtn_Loc);
		Initilization.WebDriverWait(3);
		SubscriptionHelper.ResumeApplicationNew(ApID, email_Sub_Data);
		Initilization.WebDriverWait(3);
		// Clicking on Send OTP Button
		Initilization.click_On_Button("xpath", SubscriptionLocators.sendOTPBtn_Loc);
		Initilization.WebDriverWait(3);
		emailOtp_IA_data = SubscriptionHelper.GetEmailOTPFromDataBase(ApID);
		System.out.println("Email OTP:" + emailOtp_IA_data);
		smsOtp_IA_data = SubscriptionHelper.GetsmsOTPFromDataBase(ApID);
		System.out.println("Sms OTP:" + smsOtp_IA_data);
		// Initilization.WebDriverWait(4);
		Initilization.enter_Text("xpath", SubscriptionLocators.smsOtp_IA_Loc, smsOtp_IA_data);
		Initilization.enter_Text("xpath", SubscriptionLocators.emailOtp_IA_Loc, emailOtp_IA_data);
		Initilization.WebDriverWait(3);
		Initilization.click_On_Button("xpath", SubscriptionLocators.submitButton_IA_Loc);
		SubscriptionHelper.ResumeApplicationNew(ApID, email_Sub_Data);

		// BioMatric Update
		Initilization.UpdateBioMetricStatus(SubscriptionLocators.biometricUrl, ApID, cnic_Sub_Data);

		// Reloading Page for resume application
		SubscriptionHelper.ResumeApplicationNew(ApID, email_Sub_Data);

	}

	// Double payment not done on same PSID.
	// Double payment not done on same PSID.
	@Test(description = "Double payment not done on same PSID.", enabled = true, dataProvider = "SubscriptionEndtoEnd")
	public static void TC22(String NTN, String CNIC, String phoneNum, String email) {
		String nTN_Sub_Data = NTN;
		String cnic_Sub_Data = CNIC;
		String email_Sub_Data = email;
		String mobileNumber_Sub_Data = phoneNum;
		String smsOtp_IA_data;
		String emailOtp_IA_data;
		String userName = "UN-00-" + nTN_Sub_Data;

		SubscriptionHelper.DeleteApplicationIDFromDataBase(NTN);
		Initilization.OpenUrl(Initilization.URL);
		// HomePage

		// This Line will Click on Subscriber Button
		Initilization.click_On_Button("xpath", SubscriptionLocators.subscribeButtonCss);
		// Let the drive wait for the next page to load
		Initilization.WebDriverWait(15);

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
		Initilization.WebDriverWait(12);
		final String  actual = Initilization.UpdatePaymentStatus(SubscriptionLocators.paymentUrl, paymentSlip);
		Initilization.HardAssertion(null, null, Initilization.UpdatePaymentStatus(SubscriptionLocators.paymentUrl, paymentSlip), "Bill is blocked/duplicate");

	}

	
	// Resend Create Password Link
	@Test(description = "Resend Create Password Link", enabled = true, dataProvider = "SubscriptionEndtoEnd")
	public static void TC24(String NTN, String CNIC, String phoneNum, String email) {

		String nTN_Sub_Data = NTN;
		String cnic_Sub_Data = CNIC;
		String email_Sub_Data = email;
		String mobileNumber_Sub_Data = phoneNum;
		String smsOtp_IA_data;
		String emailOtp_IA_data;
		String userName = "UN-00-" + nTN_Sub_Data;

		SubscriptionHelper.DeleteApplicationIDFromDataBase(NTN);
		Initilization.OpenUrl(Initilization.URL);
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
		emailOtp_IA_data = SubscriptionHelper.GetEmailOTPFromDataBase(ApID);
		System.out.println("Email OTP:" + emailOtp_IA_data);
		smsOtp_IA_data = SubscriptionHelper.GetsmsOTPFromDataBase(ApID);
		System.out.println("Sms OTP:" + smsOtp_IA_data);
		// Initilization.WebDriverWait(4);
		Initilization.enter_Text("xpath", SubscriptionLocators.smsOtp_IA_Loc, smsOtp_IA_data);
		Initilization.enter_Text("xpath", SubscriptionLocators.emailOtp_IA_Loc, emailOtp_IA_data);
		Initilization.WebDriverWait(3);
		Initilization.click_On_Button("xpath", SubscriptionLocators.submitButton_IA_Loc);

		// BioMatric Update
		Initilization.UpdateBioMetricStatus(SubscriptionLocators.biometricUrl, ApID, cnic_Sub_Data);

		// Reloading Page for resume application
		Initilization.Reload();
		Initilization.WebDriverWait(3);
		Initilization.BrowserAlert("yes");
		Initilization.WebDriverWait(8);
		// Click on the resume application button
		Initilization.click_On_Button("xpath", SubscriptionLocators.resumeAppBtn_Loc);
		Initilization.WebDriverWait(3);

		Initilization.enter_Text("name", "applicationId", ApID);
		Initilization.enter_Text("name", "Email", email_Sub_Data);
		Initilization.WebDriverWait(3);
		Initilization.click_On_Button("xpath", SubscriptionLocators.fetchApp_Loc);

		// BioMetric Page
		Initilization.WebDriverWait(3);
		Initilization.click_On_Button("id", "sub-fee-subtext-resendlink");
		Initilization.WebDriverWait(3);
		String Query = "use MEBIRD Select Top 1 * from MessageAttemptLog where Recepient = '" + email
				+ "' order by AttemptedOn desc";
		String Actual = SubscriptionHelper.CustomeDatabaseQueries(Query, "AttemptStatusCode");

		Initilization.HardAssertion(null, null, Actual, "S");
	}

	// If PSID is expired then payment cannot be done.
	// If PSID is expired then payment cannot be done.
	@Test(description = "If PSID is expired then payment cannot be done.", enabled = true, dataProvider = "SubscriptionEndtoEnd")
	public static void TC25(String NTN, String CNIC, String phoneNum, String email) {
		String nTN_Sub_Data = NTN;
		String cnic_Sub_Data = CNIC;
		String email_Sub_Data = email;
		String mobileNumber_Sub_Data = phoneNum;
		String smsOtp_IA_data;
		String emailOtp_IA_data;
		String userName = "UN-00-" + nTN_Sub_Data;

		SubscriptionHelper.DeleteApplicationIDFromDataBase(NTN);
		Initilization.OpenUrl(Initilization.URL);
		// HomePage

		// This Line will Click on Subscriber Button
		Initilization.click_On_Button("xpath", SubscriptionLocators.subscribeButtonCss);
		// Let the drive wait for the next page to load
		Initilization.WebDriverWait(5);

		// Terms and Conditions Page
		//// This Line will Click on I Agree to the team and condition Button
		Initilization.click_On_CheckBox("xpath", SubscriptionLocators.iAgreeButtonX);

		// This Line will Click on Proceed Button
		Initilization.click_On_Button("xpath", SubscriptionLocators.proceedButtonX);
		Initilization.WebDriverWait(12);

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

		String Query = "Use UPS Update Bill set ExpiryDate = '2021-07-11 10:24:09' where BillDocumentNumber = '"
				+ paymentSlip + "'";
		SubscriptionHelper.CustomeDatabaseQueries(Query, "ExpiryDate");

		// Updating Status form unpaid to Paid by calling PaymentAPI
		String Actual = Initilization.UpdatePaymentStatus(SubscriptionLocators.paymentUrl, paymentSlip);

		Initilization.HardAssertion(null, null, Actual, "PSID is expired");
	}

	// If PSID is expired then Resume Application should not work.
	// If PSID is expired then payment cannot be done.
	@Test(description = "If PSID is expired then Resume Application should not work.", enabled = true, dataProvider = "SubscriptionEndtoEnd")
	public static void TC26(String NTN, String CNIC, String phoneNum, String email) {
		String nTN_Sub_Data = NTN;
		String cnic_Sub_Data = CNIC;
		String email_Sub_Data = email;
		String mobileNumber_Sub_Data = phoneNum;
		String smsOtp_IA_data;
		String emailOtp_IA_data;
		String userName = "UN-00-" + nTN_Sub_Data;

		SubscriptionHelper.DeleteApplicationIDFromDataBase(NTN);
		Initilization.OpenUrl(Initilization.URL);
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
		String Query = "use Auth Update SubscriptionApplication set CreatedOn = '2021-06-01 11:55:49' where NTN = '"
				+ NTN + "'";
		SubscriptionHelper.CustomeDatabaseQueries(Query, "CreatedOn");

		// Reloading Page for resume application
		Initilization.Reload();
		Initilization.WebDriverWait(3);
		Initilization.BrowserAlert("yes");
		Initilization.WebDriverWait(8);
		// Click on the resume application button
		Initilization.click_On_Button("xpath", SubscriptionLocators.resumeAppBtn_Loc);
		Initilization.WebDriverWait(3);

		Initilization.enter_Text("name", "applicationId", ApID);
		Initilization.enter_Text("name", "Email", email_Sub_Data);
		Initilization.WebDriverWait(3);
		Initilization.click_On_Button("xpath", SubscriptionLocators.fetchApp_Loc);
		// String Actual
		String actualResult = Initilization.Get_Bar_Validation_Msg("xpath", "//div[@role='alert']");

		Initilization.HardAssertion(null, null, actualResult, "Your application is expired.");

	}

	// If application is expired then biomatric cannot be done.
	// If application is expired then biometric cannot be done.
	@Test(description = "If application is expired then biometric cannot be done.", enabled = true, dataProvider = "SubscriptionEndtoEnd")
	public static void TC27(String NTN, String CNIC, String phoneNum, String email) {
		String nTN_Sub_Data = NTN;
		String cnic_Sub_Data = CNIC;
		String email_Sub_Data = email;
		String mobileNumber_Sub_Data = phoneNum;
		String smsOtp_IA_data;
		String emailOtp_IA_data;
		String userName = "UN-00-" + nTN_Sub_Data;

		SubscriptionHelper.DeleteApplicationIDFromDataBase(NTN);
		Initilization.OpenUrl(Initilization.URL);
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
		emailOtp_IA_data = SubscriptionHelper.GetEmailOTPFromDataBase(ApID);
		System.out.println("Email OTP:" + emailOtp_IA_data);
		smsOtp_IA_data = SubscriptionHelper.GetsmsOTPFromDataBase(ApID);
		System.out.println("Sms OTP:" + smsOtp_IA_data);
		// Initilization.WebDriverWait(4);
		Initilization.enter_Text("xpath", SubscriptionLocators.smsOtp_IA_Loc, smsOtp_IA_data);
		Initilization.enter_Text("xpath", SubscriptionLocators.emailOtp_IA_Loc, emailOtp_IA_data);
		Initilization.WebDriverWait(3);
		Initilization.click_On_Button("xpath", SubscriptionLocators.submitButton_IA_Loc);

		// BioMatric Update
		String Query = "use Auth Update SubscriptionApplication set CreatedOn = '2021-06-01 11:55:49' where NTN = '"
				+ NTN + "'";
		SubscriptionHelper.CustomeDatabaseQueries(Query, "CreatedOn");

		String actualResult = Initilization.UpdateBioMetricStatus(SubscriptionLocators.biometricUrl, ApID,
				cnic_Sub_Data);

		// String Actual

		Initilization.HardAssertion(null, null, actualResult, "Verification Completetd");

	}

	// Biometric verification cannot be done without PMD Verification.
	// Biometric verification cannot be done without PMD Verification.
	@Test(description = "Biometric verification cannot be done without PMD Verification.", enabled = true, dataProvider = "SubscriptionEndtoEnd")

	public static void TC28(String NTN, String CNIC, String phoneNum, String email) {

		String nTN_Sub_Data = NTN;
		String cnic_Sub_Data = CNIC;
		String email_Sub_Data = email;
		String mobileNumber_Sub_Data = phoneNum;
		String smsOtp_IA_data;
		String emailOtp_IA_data;
		String userName = "UN-00-" + nTN_Sub_Data;

		SubscriptionHelper.DeleteApplicationIDFromDataBase(NTN);
		Initilization.OpenUrl(Initilization.URL);
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

		// BioMatric Update
		String actualResult = Initilization.UpdateBioMetricStatus(SubscriptionLocators.biometricUrl, ApID,
				cnic_Sub_Data);

		Initilization.HardAssertion(null, null, actualResult, "Not ready for biometric verification");
	}

	// Biometric verification cannot be done without OTPs Verification.
	// Biometric verification cannot be done without OTPs Verification.
	@Test(description = "Biometric verification cannot be done without OTPs Verification.", enabled = true, dataProvider = "SubscriptionEndtoEnd")

	public static void TC29(String NTN, String CNIC, String phoneNum, String email) {

		String nTN_Sub_Data = NTN;
		String cnic_Sub_Data = CNIC;
		String email_Sub_Data = email;
		String mobileNumber_Sub_Data = phoneNum;
		String smsOtp_IA_data;
		String emailOtp_IA_data;
		String userName = "UN-00-" + nTN_Sub_Data;

		SubscriptionHelper.DeleteApplicationIDFromDataBase(NTN);
		Initilization.OpenUrl(Initilization.URL);
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
		// BioMatric Update
		String actualResult = Initilization.UpdateBioMetricStatus(SubscriptionLocators.biometricUrl, ApID,
				cnic_Sub_Data);

		Initilization.HardAssertion(null, null, actualResult, "Not ready for biometric verification");
	}

	// Forgot Password
	// Forgot Password
	@Test(description = "Forgot Password", enabled = true, dataProvider = "SubscriptionEndtoEnd")
	public static void TC30(String NTN, String CNIC, String phoneNum, String email) {

		String nTN_Sub_Data = NTN;
		String cnic_Sub_Data = CNIC;
		String email_Sub_Data = email;
		String mobileNumber_Sub_Data = phoneNum;
		String smsOtp_IA_data;
		String emailOtp_IA_data;
		String userName = "UN-00-" + nTN_Sub_Data;

		SubscriptionHelper.DeleteApplicationIDFromDataBase(NTN);
		Initilization.OpenUrl(Initilization.URL);
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
		emailOtp_IA_data = SubscriptionHelper.GetEmailOTPFromDataBase(ApID);
		System.out.println("Email OTP:" + emailOtp_IA_data);
		smsOtp_IA_data = SubscriptionHelper.GetsmsOTPFromDataBase(ApID);
		System.out.println("Sms OTP:" + smsOtp_IA_data);
		// Initilization.WebDriverWait(4);
		Initilization.enter_Text("xpath", SubscriptionLocators.smsOtp_IA_Loc, smsOtp_IA_data);
		Initilization.enter_Text("xpath", SubscriptionLocators.emailOtp_IA_Loc, emailOtp_IA_data);
		Initilization.WebDriverWait(3);
		Initilization.click_On_Button("xpath", SubscriptionLocators.submitButton_IA_Loc);

		// BioMatric Update
		Initilization.UpdateBioMetricStatus(SubscriptionLocators.biometricUrl, ApID, cnic_Sub_Data);

		// Reloading Page for resume application
		Initilization.Reload();
		Initilization.WebDriverWait(3);
		Initilization.BrowserAlert("yes");
		Initilization.WebDriverWait(8);

		// Click on the resume application button
		Initilization.click_On_Button("xpath", SubscriptionLocators.resumeAppBtn_Loc);
		Initilization.WebDriverWait(3);

		Initilization.enter_Text("name", "applicationId", ApID);
		Initilization.enter_Text("name", "Email", email_Sub_Data);
		Initilization.WebDriverWait(3);
		Initilization.click_On_Button("xpath", SubscriptionLocators.fetchApp_Loc);

		// BioMetric Page
		Initilization.WebDriverWait(3);
		Initilization.click_On_Button("xpath", SubscriptionLocators.biomatric_Proceed_btn_Loc);
		Initilization.WebDriverWait(3);

		String activationUrl = SubscriptionHelper.GetActivationLinkFromDataBase(ApID);

		Initilization.OpenNewTab(activationUrl);
		Initilization.WebDriverWait(8);
		Initilization.waitUntilElementtoLoad(5);

		// Create Password Page
		// This Line will add password in the password field
		Initilization.enter_Text("xpath", SubscriptionLocators.passwordSet_Loc, SubscriptionLocators.password);

		Initilization.WebDriverWait(3);
		// This Line will add confirm password in the confirm password field
		Initilization.enter_Text("xpath", SubscriptionLocators.confirmPasswordSet_Loc, SubscriptionLocators.password);
		// This Line will click on Confirm Button
		Initilization.click_On_Button("xpath", SubscriptionLocators.SubmitBtn_Loc);
		// Let the page to load
		Initilization.WebDriverWait(5);

		// Return to
		// This Line will click on Return to HomePage Button
		Initilization.click_On_Button("xpath", SubscriptionLocators.returntoHomePage_Loc);
		// Let the page to load
		Initilization.WebDriverWait(4);

		// PSW Portal LoginPage
		Initilization.click_On_Button("xpath", SubscriptionLocators.forgotPassword);
		Initilization.WebDriverWait(4);
		Initilization.enter_Text("xpath", SubscriptionLocators.userID, userName);
		Initilization.enter_Text("xpath", SubscriptionLocators.CNIC, CNIC);
		Initilization.enter_Text("xpath", SubscriptionLocators.EmailAddress, email);

		Initilization.click_On_Button("xpath", SubscriptionLocators.sendOTP);
		Initilization.WebDriverWait(4);
		Initilization.click_On_Button("xpath", SubscriptionLocators.RecievedOTP);

		Initilization.WebDriverWait(3);
		emailOtp_IA_data = SubscriptionHelper.GetEmailOTPFromDataBase(ApID);
		System.out.println("Email OTP:" + emailOtp_IA_data);
		smsOtp_IA_data = SubscriptionHelper.GetsmsOTPFromDataBase(ApID);
		System.out.println("Sms OTP:" + smsOtp_IA_data);

		Initilization.enter_Text("xpath", SubscriptionLocators.smsOtp_IA_Loc, smsOtp_IA_data);
		Initilization.enter_Text("xpath", SubscriptionLocators.emailOtp_IA_Loc, emailOtp_IA_data);
		Initilization.WebDriverWait(3);
		Initilization.click_On_Button("xpath", SubscriptionLocators.submitButton_IA_Loc);

		Initilization.WebDriverWait(3);

		activationUrl = SubscriptionHelper.GetActivationLinkFromDataBase(ApID);

		Initilization.OpenNewTab(activationUrl);
		Initilization.WebDriverWait(8);
		Initilization.waitUntilElementtoLoad(5);

		// Create Password Page
		// This Line will add password in the password field
		Initilization.enter_Text("xpath", SubscriptionLocators.passwordSet_Loc, SubscriptionLocators.password);

		Initilization.WebDriverWait(3);
		// This Line will add confirm password in the confirm password field
		Initilization.enter_Text("xpath", SubscriptionLocators.confirmPasswordSet_Loc, SubscriptionLocators.password);
		// This Line will click on Confirm Button
		Initilization.click_On_Button("xpath", SubscriptionLocators.SubmitBtn_Loc);
		// Let the page to load
		Initilization.WebDriverWait(10);

		// Return to
		// This Line will click on Return to HomePage Button
		Initilization.click_On_Button("xpath", SubscriptionLocators.returntoHomePage_Loc);
		// Let the page to load
		Initilization.WebDriverWait(8);

		// PSW Portal LoginPage
		// This Line will enter the UserName in the username Field
		Initilization.waitUntilElementtoLoad(10);
		Initilization.enter_Text("name", "userName", userName);
		// This Line will enter the pasword in the pasword Field
		Initilization.enter_Text("name", "password", SubscriptionLocators.password);
		// This Line will click on Submit Button
		Initilization.click_On_Button("xpath", SubscriptionLocators.loginBtn_Loc);
		Initilization.WebDriverWait(3);

		// PSW Portal HomePage
		// This Line will click on LogOut Button
		Initilization.click_On_Button("xpath", SubscriptionLocators.username_Loc);

		Initilization.WebDriverWait(3);
		Initilization.click_On_Button("xpath", SubscriptionLocators.logout);
		Initilization.WebDriverWait(3);
	}

	// Single Business Name and single business address.
	@Test(description = "single Business Name and single business address.", enabled = true, dataProvider = "SubscriptionEndtoEnd")

	public static void TC31(String NTN, String CNIC, String phoneNum, String email) {

		String nTN_Sub_Data = "0133549";
		String cnic_Sub_Data = CNIC;
		String email_Sub_Data = email;
		String mobileNumber_Sub_Data = phoneNum;
		String smsOtp_IA_data;
		String emailOtp_IA_data;
		String userName = "UN-00-" + nTN_Sub_Data;

		SubscriptionHelper.DeleteApplicationIDFromDataBase("0133549");
		Initilization.OpenUrl(Initilization.URL);
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
		Initilization.WebDriverWait(4);

		// Subscription Page
		// This Line will Add NTN Number in the NTN Field
		Initilization.enter_Text("xpath", SubscriptionLocators.nTN_Sub_Loc, nTN_Sub_Data);
		// This Line will Click on Validate NTN Button
		Initilization.click_On_Button("xpath", SubscriptionLocators.validateButton_Sub_Loc);
		Initilization.WebDriverWait(4);
		String CompanyAddressAPI = SubscriptionHelper.FBRAPIData("https://gw.fbr.gov.pk/psw/1/details", "0133549",
				"ADDRESS.ADDRESS");
		String actual = Initilization.get_Text("xpath", SubscriptionLocators.BusinessAddres);
		Initilization.WebDriverWait(4);
		System.out.println("UI Address::" + CompanyAddressAPI);
		// System.out.println("FBR API::"+actual);
		Initilization.HardAssertion(null, null, actual, CompanyAddressAPI);

	}

	// CNIC should be from the populated CNIC list.
	@Test(description = "CNIC should be from the populated CNIC list.", enabled = true, dataProvider = "SubscriptionEndtoEnd")

	public static void TC32(String NTN, String CNIC, String phoneNum, String email) {

		String nTN_Sub_Data = NTN;
		String cnic_Sub_Data = CNIC;
		String email_Sub_Data = email;
		String mobileNumber_Sub_Data = phoneNum;
		String smsOtp_IA_data;
		String emailOtp_IA_data;
		String userName = "UN-00-" + nTN_Sub_Data;

		SubscriptionHelper.DeleteApplicationIDFromDataBase(NTN);
		Initilization.OpenUrl(Initilization.URL); // HomePage

		// This Line will Click on Subscriber Button
		Initilization.click_On_Button("xpath", SubscriptionLocators.subscribeButtonCss); // Let the drive wait for the
																							// next
		// page to load
		Initilization.WebDriverWait(2);

		// Terms and Conditions Page //// This Line will Click on I Agree to the team
		// and condition Button
		Initilization.click_On_CheckBox("xpath", SubscriptionLocators.iAgreeButtonX);

		// This Line will Click on Proceed Button
		Initilization.click_On_Button("xpath", SubscriptionLocators.proceedButtonX);
		Initilization.WebDriverWait(2);

		// Subscription Page // This Line will Add NTN Number in the NTN Field
		Initilization.enter_Text("xpath", SubscriptionLocators.nTN_Sub_Loc, nTN_Sub_Data); // This Line will Click on
																							// Validate NTN Button
		Initilization.click_On_Button("xpath", SubscriptionLocators.validateButton_Sub_Loc);

		String MemberCNIC = SubscriptionHelper.FBRAPIData("https://gw.fbr.gov.pk/psw/1/details", NTN,
				"BUSINESS_MEMBERS.CNIC");
		String qurery = "use auth select * from SubscriptionApplication where NTN = '" + NTN + "'";
		Initilization.WebDriverWait(7);
		String actual = SubscriptionHelper.CustomeDatabaseQueries(qurery, "CNICs");
		actual = "[" + actual + "]";
		MemberCNIC = MemberCNIC.replaceAll("\\s+", "");

		Initilization.HardAssertion(null, null, MemberCNIC, actual);
	}

	// Multiple Business Name compare with FBR API.
	@Test(description = "CNIC should be from the populated CNIC list.", enabled = true, dataProvider = "SubscriptionEndtoEnd")

	public static void TC33(String NTN, String CNIC, String phoneNum, String email) {

		String nTN_Sub_Data = "0222346";
		String cnic_Sub_Data = CNIC;
		String email_Sub_Data = email;
		String mobileNumber_Sub_Data = phoneNum;
		String smsOtp_IA_data;
		String emailOtp_IA_data;
		String userName = "UN-00-" + nTN_Sub_Data;

		SubscriptionHelper.DeleteApplicationIDFromDataBase("0222346");
		Initilization.OpenUrl(Initilization.URL); // HomePage

		// This Line will Click on Subscriber Button
		Initilization.click_On_Button("xpath", SubscriptionLocators.subscribeButtonCss); // Let the drive wait for the
																							// next
		// page to load
		Initilization.WebDriverWait(12);

		// Terms and Conditions Page //// This Line will Click on I Agree to the team
		// and condition Button
		Initilization.click_On_CheckBox("xpath", SubscriptionLocators.iAgreeButtonX);

		// This Line will Click on Proceed Button
		Initilization.click_On_Button("xpath", SubscriptionLocators.proceedButtonX);
		Initilization.WebDriverWait(12);

		// Subscription Page // This Line will Add NTN Number in the NTN Field
		Initilization.enter_Text("xpath", SubscriptionLocators.nTN_Sub_Loc, nTN_Sub_Data); // This Line will Click on
																							// Validate NTN Button
		Initilization.click_On_Button("xpath", SubscriptionLocators.validateButton_Sub_Loc);

		String BusinessName = SubscriptionHelper.FBRAPIData("https://gw.fbr.gov.pk/psw/1/details", "0222346",
				"BUSINESS.BUSINESS_NAME");
		System.out.println("Before Change:"+BusinessName);
		BusinessName = BusinessName.replaceAll("\\s+", "");
		System.out.println("After Change:"+BusinessName);
		String qurery = "use Auth Select Name from Organization  where ntn ='" + "0222346"
				+ "'";
		String actual = SubscriptionHelper.CustomeDatabaseQueriesFullListofData(qurery, "Name");
		int L = actual.length();
		actual = actual.substring(0, L - 1);
		actual = "[" + actual + "]";
		actual = actual.replaceAll("\\s+", "");
		System.out.println(BusinessName);
		System.out.println(actual);
		Initilization.HardAssertion(null, null, BusinessName, actual);

	}

	// Multiple Business Address compare with FBR API.
	@Test(description = "Multiple Business Address compare with FBR API.", enabled = true, dataProvider = "SubscriptionEndtoEnd")

	public static void TC34(String NTN, String CNIC, String phoneNum, String email) {

		String nTN_Sub_Data = "0222346";
		String cnic_Sub_Data = CNIC;
		String email_Sub_Data = email;
		String mobileNumber_Sub_Data = phoneNum;
		String smsOtp_IA_data;
		String emailOtp_IA_data;
		String userName = "UN-00-" + nTN_Sub_Data;

		SubscriptionHelper.DeleteApplicationIDFromDataBase("0222346");
		Initilization.OpenUrl(Initilization.URL); // HomePage

		// This Line will Click on Subscriber Button
		Initilization.click_On_Button("xpath", SubscriptionLocators.subscribeButtonCss); // Let the drive wait for the
																							// next
		// page to load
		Initilization.WebDriverWait(2);

		// Terms and Conditions Page //// This Line will Click on I Agree to the team
		// and condition Button
		Initilization.click_On_CheckBox("xpath", SubscriptionLocators.iAgreeButtonX);

		// This Line will Click on Proceed Button
		Initilization.click_On_Button("xpath", SubscriptionLocators.proceedButtonX);
		Initilization.WebDriverWait(2);

		// Subscription Page // This Line will Add NTN Number in the NTN Field
		Initilization.enter_Text("xpath", SubscriptionLocators.nTN_Sub_Loc, nTN_Sub_Data); // This Line will Click on
																							// Validate NTN Button
		Initilization.click_On_Button("xpath", SubscriptionLocators.validateButton_Sub_Loc);

		String BusinessName = SubscriptionHelper.FBRAPIData("https://gw.fbr.gov.pk/psw/1/details", "0222346",
				"BUSINESS_ADDRESS.ADDRESS");
		BusinessName = BusinessName.replaceAll("\\s+", "");

		String qurery = "use auth select o.NTN,o.Name,a.AddressComplete,o.PrcpLineOfBusiness  from organization as o \r\n"
				+ "inner join OrganizationAddress as oa\r\n"
				+ "on oa.OrganizationID = o.id inner join Address as a on a.id = oa.AddressID where NTN = '" + "0222346"
				+ "'";
		String actual = SubscriptionHelper.CustomeDatabaseQueriesFullListofData(qurery, "AddressComplete");
		int L = actual.length();
		actual = actual.substring(0, L - 1);
		actual = "[" + actual + "]";
		actual = actual.replaceAll("\\s+", "");
		System.out.println(BusinessName);
		System.out.println(actual);
		Initilization.HardAssertion(null, null, BusinessName, actual);

	}

	// Multiple Principle Activity compare with FBR API.
	@Test(description = "Multiple Principle Activity compare with FBR API.", enabled = true, dataProvider = "SubscriptionEndtoEnd")

	public static void TC35(String NTN, String CNIC, String phoneNum, String email) {

		String nTN_Sub_Data = "0222346";
		String cnic_Sub_Data = CNIC;
		String email_Sub_Data = email;
		String mobileNumber_Sub_Data = phoneNum;
		String smsOtp_IA_data;
		String emailOtp_IA_data;
		String userName = "UN-00-" + nTN_Sub_Data;

		SubscriptionHelper.DeleteApplicationIDFromDataBase("0222346");
		Initilization.OpenUrl(Initilization.URL); // HomePage

		// This Line will Click on Subscriber Button
		Initilization.click_On_Button("xpath", SubscriptionLocators.subscribeButtonCss); // Let the drive wait for the
																							// next
		// page to load
		Initilization.WebDriverWait(12);

		// Terms and Conditions Page //// This Line will Click on I Agree to the team
		// and condition Button
		Initilization.click_On_CheckBox("xpath", SubscriptionLocators.iAgreeButtonX);

		// This Line will Click on Proceed Button
		Initilization.click_On_Button("xpath", SubscriptionLocators.proceedButtonX);
		Initilization.WebDriverWait(12);

		// Subscription Page // This Line will Add NTN Number in the NTN Field
		Initilization.enter_Text("xpath", SubscriptionLocators.nTN_Sub_Loc, nTN_Sub_Data); // This Line will Click on
																							// Validate NTN Button
		Initilization.click_On_Button("xpath", SubscriptionLocators.validateButton_Sub_Loc);

		String BusinessActivity = SubscriptionHelper.FBRAPIData("https://gw.fbr.gov.pk/psw/1/details", "0222346",
				"BUSINESS.PRINCIPAL_BUSINESS_ACTIVITY");
		BusinessActivity = BusinessActivity.replaceAll("\\s+", "");

		/*
		 * String qurery =
		 * "use auth select o.PrcpLineOfBusiness  from organization as o \r\n" +
		 * "inner join OrganizationAddress as oa\r\n" +
		 * "on oa.OrganizationID = o.id inner join Address as a on a.id = oa.AddressID where NTN = '"
		 * + "0222346" + "'";
		 */
		String qurery = "select PrcpLineOfBusiness from organization as o where NTN = '" + "0222346"
				+ "'";
		String actual = SubscriptionHelper.CustomeDatabaseQueriesFullListofData(qurery, "PrcpLineOfBusiness");
		
		int L = actual.length();
		actual = actual.substring(0, L - 1);
		actual = "[" + actual + "]";
		actual = actual.replaceAll("\\s+", "");
		System.out.println(BusinessActivity);
		System.out.println(actual);
		Initilization.HardAssertion(null, null, BusinessActivity, actual);

	}

	// Automate Principal Activity is not mandatory so that voucher can be generated
	// and subscription will proceed.
	@Test(description = "Automate Principal Activity is not mandatory so that voucher can be generated and subscription will proceed.", enabled = true, dataProvider = "SubscriptionEndtoEnd")

	public static void TC36(String NTN, String CNIC, String phoneNum, String email) {
		// Data and Locators

		String nTN_Sub_Data = "0656788";
		String cnic_Sub_Data = "35202-2783221-9";
		String email_Sub_Data = email;
		String mobileNumber_Sub_Data = phoneNum;
		String smsOtp_IA_data;
		String emailOtp_IA_data;
		String userName = "UN-00-" + nTN_Sub_Data;

		SubscriptionHelper.DeleteApplicationIDFromDataBase("0656788");
		Initilization.OpenUrl(Initilization.URL);
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
		Initilization.HardAssertion("id", "sub-fee-slip-subscriptionFees-label", null, "Payment Slip ID (PSID)");
	}

	// Automate STRN is not mandatory so that voucher can be generated and
	// subscription will proceed.
	@Test(description = "Automate STRN is not mandatory so that voucher can be generated and subscription will proceed.", enabled = true, dataProvider = "SubscriptionEndtoEnd")

	public static void TC37(String NTN, String CNIC, String phoneNum, String email) {
		// Data and Locators

		String nTN_Sub_Data = "0231200";
		String cnic_Sub_Data = "42201-1033941-1";
		String email_Sub_Data = email;
		String mobileNumber_Sub_Data = phoneNum;
		String smsOtp_IA_data;
		String emailOtp_IA_data;
		String userName = "UN-00-" + nTN_Sub_Data;

		SubscriptionHelper.DeleteApplicationIDFromDataBase("0231200");
		Initilization.OpenUrl(Initilization.URL);
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
		Initilization.HardAssertion("id", "sub-fee-slip-subscriptionFees-label", null, "Payment Slip ID (PSID)");
	}

	// Automate following fields are mandatory for subscription process, so that
	// voucher cannot be generated: "Company Name Business Name Business Address"
	@Test(description = "Automate STRN is not mandatory so that voucher can be generated and subscription will proceed.", enabled = true, dataProvider = "SubscriptionEndtoEnd")

	public static void TC38(String NTN, String CNIC, String phoneNum, String email) {
		// Data and Locators

		String nTN_Sub_Data = "0224317";
		String cnic_Sub_Data = "3520112587765";
		String email_Sub_Data = email;
		String mobileNumber_Sub_Data = phoneNum;
		String smsOtp_IA_data;
		String emailOtp_IA_data;
		String userName = "UN-00-" + nTN_Sub_Data;

		SubscriptionHelper.DeleteApplicationIDFromDataBase("0231200");
		Initilization.OpenUrl(Initilization.URL);
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
		String actual = Initilization.Get_Bar_Validation_Msg("xpath", "//div[@role='alert']");

		Initilization.HardAssertion(null, null, actual,
				"Please provide CNIC from the list populated.");
	}

	// Automate following fields are mandatory for subscription process, so that
	// voucher cannot be generated: "Company Name Business Name Business Address"
	@Test(description = "Automate STRN is not mandatory so that voucher can be generated and subscription will proceed.", enabled = true, dataProvider = "SubscriptionEndtoEnd")

	public static void TC39(String NTN, String CNIC, String phoneNum, String email) {
		// Data and Locators

		String nTN_Sub_Data = NTN;
		String cnic_Sub_Data = CNIC;
		String email_Sub_Data = email;
		String mobileNumber_Sub_Data = phoneNum;
		String smsOtp_IA_data;
		String emailOtp_IA_data;
		String userName = "UN-00-" + nTN_Sub_Data;

		SubscriptionHelper.DeleteApplicationIDFromDataBase(NTN);
		Initilization.OpenUrl(Initilization.URL);
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
		SubscriptionHelper.DeleteAddressIDFromDataBase(nTN_Sub_Data);

		Initilization.Reload();
		Initilization.WebDriverWait(3);
		Initilization.BrowserAlert("yes");
		Initilization.WebDriverWait(8);
		// Terms and Conditions Page
		//// This Line will Click on I Agree to the team and condition Button
		Initilization.click_On_CheckBox("xpath", SubscriptionLocators.iAgreeButtonX);

		// This Line will Click on Proceed Button
		Initilization.click_On_Button("xpath", SubscriptionLocators.proceedButtonX);
		Initilization.WebDriverWait(2);

		// Subscription Page
		// This Line will Add NTN Number in the NTN Field
		Initilization.enter_Text("xpath", SubscriptionLocators.nTN_Sub_Loc, nTN_Sub_Data);
		Initilization.WebDriverWait(2);
		// This Line will Click on Validate NTN Button
		Initilization.click_On_Button("xpath", SubscriptionLocators.validateButton_Sub_Loc);
		// Let the driver wait to check if the voucher is already generated or not
		Initilization.WebDriverWait(7);

	}

	// Verify biometric verification with data in Urdu.
	@Test(description = "Verify biometric verification with data in Urdu.", enabled = true, dataProvider = "SubscriptionEndtoEnd")

	public static void TC40(String NTN, String CNIC, String phoneNum, String email) {
		// Data and Locators

		String nTN_Sub_Data = NTN;
		String cnic_Sub_Data = CNIC;
		String email_Sub_Data = email;
		String mobileNumber_Sub_Data = phoneNum;
		String smsOtp_IA_data;
		String emailOtp_IA_data;
		String userName = "UN-00-" + nTN_Sub_Data;

		SubscriptionHelper.DeleteApplicationIDFromDataBase(NTN);
		Initilization.OpenUrl(Initilization.URL);
		// HomePage

		// This Line will Click on Subscriber Button
		Initilization.click_On_Button("xpath", SubscriptionLocators.subscribeButtonCss);
		// Let the drive wait for the next page to load
		Initilization.WebDriverWait(150);

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
		emailOtp_IA_data = SubscriptionHelper.GetEmailOTPFromDataBase(ApID);
		System.out.println("Email OTP:" + emailOtp_IA_data);
		smsOtp_IA_data = SubscriptionHelper.GetsmsOTPFromDataBase(ApID);
		System.out.println("Sms OTP:" + smsOtp_IA_data);
		// Initilization.WebDriverWait(4);
		Initilization.enter_Text("xpath", SubscriptionLocators.smsOtp_IA_Loc, smsOtp_IA_data);
		Initilization.enter_Text("xpath", SubscriptionLocators.emailOtp_IA_Loc, emailOtp_IA_data);
		Initilization.WebDriverWait(3);
		Initilization.click_On_Button("xpath", SubscriptionLocators.submitButton_IA_Loc);

		// BioMatric Update
		Initilization.UpdateBioMetricStatusUrdu(SubscriptionLocators.biometricUrl, ApID, cnic_Sub_Data);

	}

	// Change Password
	@Test(description = "ChangePassword", enabled = true, dataProvider = "SubscriptionEndtoEnd")

	public static void TC43Change_Password(String NTN, String CNIC, String phoneNum, String email) {
		// Data and Locators

		String nTN_Sub_Data = NTN;
		String cnic_Sub_Data = CNIC;
		String email_Sub_Data = email;
		String mobileNumber_Sub_Data = phoneNum;
		String smsOtp_IA_data;
		String emailOtp_IA_data;
		String userName = "UN-00-" + nTN_Sub_Data;

		SubscriptionHelper.DeleteApplicationIDFromDataBase(NTN);
		Initilization.OpenUrl(Initilization.URL);
		// HomePage

		// This Line will Click on Subscriber Button
		Initilization.click_On_Button("xpath", SubscriptionLocators.subscribeButtonCss);
		// Let the drive wait for the next page to load
		Initilization.WebDriverWait(10);

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
		emailOtp_IA_data = SubscriptionHelper.GetEmailOTPFromDataBase(ApID);
		System.out.println("Email OTP:" + emailOtp_IA_data);
		smsOtp_IA_data = SubscriptionHelper.GetsmsOTPFromDataBase(ApID);
		System.out.println("Sms OTP:" + smsOtp_IA_data);
		// Initilization.WebDriverWait(4);
		Initilization.enter_Text("xpath", SubscriptionLocators.smsOtp_IA_Loc, smsOtp_IA_data);
		Initilization.enter_Text("xpath", SubscriptionLocators.emailOtp_IA_Loc, emailOtp_IA_data);
		Initilization.WebDriverWait(3);
		Initilization.click_On_Button("xpath", SubscriptionLocators.submitButton_IA_Loc);

		// BioMatric Update
		Initilization.UpdateBioMetricStatus(SubscriptionLocators.biometricUrl, ApID, cnic_Sub_Data);

		// Reloading Page for resume application
		Initilization.Reload();
		Initilization.WebDriverWait(3);
		Initilization.BrowserAlert("yes");

		// Click on the resume application button
		Initilization.click_On_Button("xpath", SubscriptionLocators.resumeAppBtn_Loc);
		Initilization.WebDriverWait(3);

		Initilization.enter_Text("name", "applicationId", ApID);
		Initilization.enter_Text("name", "Email", email_Sub_Data);
		Initilization.WebDriverWait(3);
		Initilization.click_On_Button("xpath", SubscriptionLocators.fetchApp_Loc);

		// BioMetric Page
		Initilization.WebDriverWait(3);
		Initilization.click_On_Button("xpath", SubscriptionLocators.biomatric_Proceed_btn_Loc);
		Initilization.WebDriverWait(3);

		String activationUrl = SubscriptionHelper.GetActivationLinkFromDataBase(ApID);

		Initilization.OpenNewTab(activationUrl);
		Initilization.WebDriverWait(8);
		Initilization.waitUntilElementtoLoad(5);

		// Create Password Page
		// This Line will add password in the password field
		Initilization.enter_Text("xpath", SubscriptionLocators.passwordSet_Loc, SubscriptionLocators.password);

		Initilization.WebDriverWait(3);
		// This Line will add confirm password in the confirm password field
		Initilization.enter_Text("xpath", SubscriptionLocators.confirmPasswordSet_Loc, SubscriptionLocators.password);
		// This Line will click on Confirm Button
		Initilization.click_On_Button("xpath", SubscriptionLocators.SubmitBtn_Loc);
		// Let the page to load
		Initilization.WebDriverWait(5);

		// Return to
		// This Line will click on Return to HomePage Button
		Initilization.click_On_Button("xpath", SubscriptionLocators.returntoHomePage_Loc);

		// Let the page to load
		Initilization.WebDriverWait(8);

		// PSW Portal LoginPage
		// This Line will enter the UserName in the username Field
		Initilization.waitUntilElementtoLoad(10);
		Initilization.enter_Text("name", "userName", userName);
		// This Line will enter the pasword in the pasword Field
		Initilization.enter_Text("name", "password", SubscriptionLocators.password);
		// This Line will click on Submit Button
		Initilization.click_On_Button("xpath", SubscriptionLocators.loginBtn_Loc);
		Initilization.WebDriverWait(3);

		// PSW Portal HomePage
		// This Line will click on LogOut Button
		Initilization.click_On_Button("xpath", SubscriptionLocators.username_Loc);

		Initilization.WebDriverWait(3);
		Initilization.click_On_Button("xpath", SubscriptionLocators.ChangePassword);
		Initilization.WebDriverWait(3);
		Initilization.enter_Text("xpath", "//input[@name='currentPassword']", SubscriptionLocators.password);
		Initilization.WebDriverWait(1);
		Initilization.enter_Text("xpath", "//input[@name='password']", "Test@12345");
		Initilization.WebDriverWait(1);
		Initilization.enter_Text("xpath", "//input[@name='confirmPassword']", "Test@12345");
		Initilization.WebDriverWait(1);

		Initilization.click_On_Button("xpath", "//button[@type='submit']");
		Initilization.WebDriverWait(3);
		// Delete the Created User
		// SubscriptionHelper.DeleteApplicationIDFromDataBase(nTN_Sub_Data);
		Initilization.click_On_Button("xpath", SubscriptionLocators.username_Loc);

		Initilization.click_On_Button("xpath", SubscriptionLocators.logout);

		Initilization.WebDriverWait(10);

		Initilization.waitUntilElementtoLoad(10);
		Initilization.enter_Text("name", "userName", userName);
		// This Line will enter the pasword in the pasword Field
		Initilization.enter_Text("name", "password", "Test@12345");
	}

	// Verify voucher is generating with PSID, Application ID, Amount, Due Date and
	// Payment Status.
	
	@Test(description = "Verify voucher is generating with PSID, Application ID, Amount, Due Date and Payment Status", enabled = true, dataProvider = "SubscriptionEndtoEnd")

	public static void TC41_Verify_voucher_is_generating_with_PSID_Application_ID_Amount_Due_Date_and_Payment_Status(
			String NTN, String CNIC, String phoneNum, String email) {
		// Data and Locators

		String nTN_Sub_Data = NTN;
		String cnic_Sub_Data = CNIC;
		String email_Sub_Data = email;
		String mobileNumber_Sub_Data = phoneNum;
		String smsOtp_IA_data;
		String emailOtp_IA_data;
		String userName = "UN-00-" + nTN_Sub_Data;

		SubscriptionHelper.DeleteApplicationIDFromDataBase(NTN);
		Initilization.OpenUrl(Initilization.URL);
		// HomePage

		// This Line will Click on Subscriber Button
		Initilization.click_On_Button("xpath", SubscriptionLocators.subscribeButtonCss);
		// Let the drive wait for the next page to load
		Initilization.WebDriverWait(40);

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
		String PaymentSlipStatus = "true";
		String PaymentStatus = "true";
		String DueDateStatus = "true";
		String apidStatus = "true";
		String statusStatus = "true";
		// PaymentSlip
		String PaymentSlip = Initilization.get_Text("xpath", "(//h6[@id='sub-fee-slip-subscriptionFees-data'])[1]");
		System.out.println(PaymentSlip);
		if (PaymentSlip.length() > 5) {

			PaymentSlipStatus = "true";

		} else {
			PaymentSlipStatus = "true";
		}

		// Payment
		String Payment = Initilization.get_Text("xpath", "(//h6[@id='sub-fee-slip-subscriptionFees-data'])[2]");

		// Due Date
		String DueDate = Initilization.get_Text("xpath", "//h6[@id='sub-fee-slip-duedate-data']");
		System.out.println(DueDate);
		if (DueDate.length() > 5) {

			DueDateStatus = "true";

		} else {
			DueDateStatus = "true";
		}

		// APID
		String apid = Initilization.get_Text("xpath", "(//h6[@id='sub-fee-slip-applicationID-data'])[1]");
		System.out.println(DueDate);
		if (apid.length() > 4) {

			apidStatus = "true";

		} else {
			apidStatus = "true";
		}
		// Payment Status
		String status = Initilization.get_Text("xpath", "(//h6[@id='sub-fee-slip-applicationID-data'])[2]");
		System.out.println(status);
		if (apid.length() > 4) {

			statusStatus = "true";

		} else {
			statusStatus = "true";
		}
	}
	@Test(description = "SubscriptionEndtoEnd", enabled = true, dataProvider = "SubscriptionEndtoEnd")

	public static void TC44_PMD_Attemp_And_Expiry_APID_Check_With_ResumeApplicaiton(String NTN, String CNIC,
			String phoneNum, String email) {
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
		Initilization.WebDriverWait(40);
		// This Line will Click on Subscriber Button
		Initilization.click_On_Button("xpath", SubscriptionLocators.subscribeButtonCss);
		// Let the drive wait for the next page to load
		Initilization.WebDriverWait(60);

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
		Initilization.WebDriverWait(4);
		Initilization.click_On_Button("xpath", SubscriptionLocators.generateVoucher_Sub_Loc);
		Initilization.WebDriverWait(4);
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

		Initilization.HardAssertion(null, null, actualResult,
				"Your Subscription application will expire after 2 attempt(s). The mobile number did not match with CNIC. Please enter a mobile number registered on the provided CNIC. You may contact the mobile service provider for further confirmation. Corporate mobile numbers are also required to be registered on your CNIC instead of NTN.");

		Initilization.Reload();
		Initilization.WebDriverWait(3);
		Initilization.BrowserAlert("yes");

		Initilization.WebDriverWait(10);
		// Click on the resume application button
		Initilization.click_On_Button("xpath", SubscriptionLocators.resumeAppBtn_Loc);
		Initilization.WebDriverWait(3);

		Initilization.enter_Text("name", "applicationId", ApID);
		Initilization.enter_Text("name", "Email", email_Sub_Data);
		Initilization.WebDriverWait(3);
		Initilization.click_On_Button("xpath", SubscriptionLocators.fetchApp_Loc);
		Initilization.WebDriverWait(10);
		Initilization.click_On_Button("xpath", SubscriptionLocators.proceedBtn_Loc);
		Initilization.WebDriverWait(10);
		actualResult = Initilization.Get_Bar_Validation_Msg("xpath", "//div[@role='alert']");
		Initilization.WebDriverWait(4);
		Initilization.HardAssertion(null, null, actualResult,
				"Your Subscription application will expire after 1 attempt(s). The mobile number did not match with CNIC. Please enter a mobile number registered on the provided CNIC. You may contact the mobile service provider for further confirmation. Corporate mobile numbers are also required to be registered on your CNIC instead of NTN.");

		Initilization.Reload();
		Initilization.WebDriverWait(3);
		Initilization.BrowserAlert("yes");

		Initilization.WebDriverWait(10);
		// Click on the resume application button
		Initilization.click_On_Button("xpath", SubscriptionLocators.resumeAppBtn_Loc);
		Initilization.WebDriverWait(3);

		Initilization.enter_Text("name", "applicationId", ApID);
		Initilization.enter_Text("name", "Email", email_Sub_Data);
		Initilization.WebDriverWait(3);
		Initilization.click_On_Button("xpath", SubscriptionLocators.fetchApp_Loc);
		Initilization.WebDriverWait(4);
		Initilization.click_On_Button("xpath", SubscriptionLocators.proceedBtn_Loc);
		Initilization.WebDriverWait(10);
		actualResult = Initilization.Get_Bar_Validation_Msg("xpath", "//div[@role='alert']");
		Initilization.WebDriverWait(4);
		Initilization.HardAssertion(null, null, actualResult,
				"Dear Subscriber, your subscription application has expired due to multiple failed attempts of mobile number verification against provided CNIC. Please contact your Mobile service provider and restart your Subscription process again.");
		Initilization.WebDriverWait(2);
		Initilization.Reload();
		Initilization.WebDriverWait(3);
		Initilization.BrowserAlert("yes");
		Initilization.WebDriverWait(3);
	}

	@Test(description = "SubscriptionEndtoEnd", enabled = true, dataProvider = "SubscriptionEndtoEnd")

	public static void TC45_PMD_Attemp_And_Expiry_APID_Check(String NTN, String CNIC, String phoneNum, String email) {
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
		Initilization.WebDriverWait(60);

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

		Initilization.HardAssertion(null, null, actualResult,
				"Your Subscription application will expire after 2 attempt(s). The mobile number did not match with CNIC. Please enter a mobile number registered on the provided CNIC. You may contact the mobile service provider for further confirmation. Corporate mobile numbers are also required to be registered on your CNIC instead of NTN.");

		Initilization.click_On_Button("xpath", SubscriptionLocators.proceedBtn_Loc);
		Initilization.WebDriverWait(10);
		actualResult = Initilization.Get_Bar_Validation_Msg("xpath", "//div[@role='alert']");

		Initilization.HardAssertion(null, null, actualResult,
				"Your Subscription application will expire after 1 attempt(s). The mobile number did not match with CNIC. Please enter a mobile number registered on the provided CNIC. You may contact the mobile service provider for further confirmation. Corporate mobile numbers are also required to be registered on your CNIC instead of NTN.");

		Initilization.click_On_Button("xpath", SubscriptionLocators.proceedBtn_Loc);
		Initilization.WebDriverWait(10);
		actualResult = Initilization.Get_Bar_Validation_Msg("xpath", "//div[@role='alert']");

		Initilization.HardAssertion(null, null, actualResult,
				"Dear Subscriber, your subscription application has expired due to multiple failed attempts of mobile number verification against provided CNIC. Please contact your Mobile service provider and restart your Subscription process again.");

	}
	

}
