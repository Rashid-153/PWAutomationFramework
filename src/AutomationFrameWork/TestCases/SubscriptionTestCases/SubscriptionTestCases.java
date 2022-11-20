package AutomationFrameWork.TestCases.SubscriptionTestCases;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import AutomationFrameWork.Helpers.SubscriptionHelper;
import AutomationFrameWork.SetupFiles.AES;
import AutomationFrameWork.SetupFiles.Initilization;
import Locators.SubscriptionLocators;

public class SubscriptionTestCases extends Initilization {

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
			/*{"0656651","3630263410611","3360801243","maazmaaz97@gmail.com"},//Hassaan
			{"0656656","6110167317453","3360801243","maazmaaz97@gmail.com"},
			{"0656781","6110118809631","3360801243","maazmaaz97@gmail.com"},
			{"0656848","6110110432433","3360801243","maazmaaz97@gmail.com"},
			{"0656910","6110185714372","3360801243","maazmaaz97@gmail.com"},
			{"0656916","3520128318133","3360801243","maazmaaz97@gmail.com"},//Hassaan			
			{"0224164","3520224157461","3350357964","maazmaaz97@gmail.com"},//Sarah
			/*{"0224304","3520144395823","3350357964","maazmaaz97@gmail.com"},
			{"0224306","3520217823021","3350357964","maazmaaz97@gmail.com"},
			{"0225872","3630226287771","3350357964","maazmaaz97@gmail.com"},
			{"0225883","3520255154111","3350357964","maazmaaz97@gmail.com"},
			{"0225898","3520114104450","3350357964","maazmaaz97@gmail.com"},
			{"0225900","4230125994126","3350357964","maazmaaz97@gmail.com"},
			{"0225961","3520258846785","3350357964","maazmaaz97@gmail.com"},
			{"0225968","3520267658185","3350357964","maazmaaz97@gmail.com"},//Sarah
			{"0305725","3410125678697","3070033153","maazmaaz97@gmail.com"},//Rashid
			{"0305726","3410193165721","3070033153","maazmaaz97@gmail.com"},
			{"0305732","3410124347682","3070033153","maazmaaz97@gmail.com"},
			{"0305739","3410124278425","3070033153","maazmaaz97@gmail.com"},
			{"0305759","3520136876499","3070033153","maazmaaz97@gmail.com"},
			{"0305774","3410124765176","3070033153","maazmaaz97@gmail.com"},*/
			/*{"0388094","3460321364522","3070033153","maazmaaz97@gmail.com"},
			{"0388096","3460321235047","3070033153","maazmaaz97@gmail.com"},*/
		//	{"0388413","3460344952546","3070033153","maazmaaz97@gmail.com"},//Rashid
		
			{ "0000292", "3740504274611", "3172094681", "maazmaaz97@gmail.com","Zong" }
			/*	{ "0000292", "3740504274611", "3172094681", "maazmaaz97@gmail.com" },*/
			/*
			 * { "0656498", "3720178264574", "3172094681", "maazmaaz97@gmail.com" }, {
			 * "0000297", "1730113938011", "3172094681", "maazmaaz97@gmail.com" } , {
			 * "0000298", "1730114351289", "3172094681", "maazmaaz97@gmail.com" }
			 */
			
		};
//										 
		
	}


	@Test(description = "SubscriptionEndtoEnd", enabled = true, dataProvider = "SubscriptionEndtoEnd")

	public static void TC1(String NTN, String CNIC, String phoneNum, String email, String networkProvide) {
		// Data and Locators

		String nTN_Sub_Data = NTN;
		String cnic_Sub_Data = CNIC;
		String email_Sub_Data = email;
		String mobileNumber_Sub_Data = phoneNum;
		String networkProvider_Sub_Data = networkProvide;
		String smsOtp_IA_data;
		String emailOtp_IA_data;
		String userName = "UN-00-" + nTN_Sub_Data;
		
		SubscriptionHelper.DeleteApplicationIDFromDataBase(NTN);
		Initilization.OpenUrl(Initilization.URL); 
		// HomePage
		
			// This Line will Click on Subscriber Button
		Initilization.click_On_Button("xpath", SubscriptionLocators.subscribeButtonCss);
		// Let the drive wait for the next page to load
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
		// This Line will Select Network Field
		Initilization.enter_Text("xpath", SubscriptionLocators.networkProvider_Sub_Loc, networkProvider_Sub_Data+Keys.ENTER);
		// This Line will Click on Generated Voucher Button
		Initilization.click_On_Button("xpath", SubscriptionLocators.generateVoucher_Sub_Loc);
		// Initilization.UpdateBioMatricStatus(Url, Apid, Cnic);
		Initilization.WebDriverWait(10);

		// PaymentProcess Page
		// Gathering Payment Slip ID (PSID)
		String paymentSlip = Initilization.getTextcss(SubscriptionLocators.paymentSlip_Loc);
		paymentSlip = paymentSlip.substring(6, 23);
		System.out.println("PSID is 6 digits:" + paymentSlip);

		// Gathering Application ID (ApID)
		String ApID = Initilization.getText(SubscriptionLocators.ApIDText_Loc);

		System.out.println("ApID is :" + ApID);

		// Updating Status form unpaid to Paid by calling PaymentAPI
		Initilization.UpdatePaymentStatus("https://"+Initilization.Environment+".psw.gov.pk/api/ups/PSID/open", paymentSlip);

		Initilization.WebDriverWait(10);

		Initilization.click_On_Button("xpath", SubscriptionLocators.paidButton);
		Initilization.WebDriverWait(5);
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

		Initilization.WebDriverWait(10);
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
	//	Initilization.waitUntilElementtoLoad(5);

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
		//https://qa.psw.gov.pk/app/
		Initilization.OpenUrl("https://"+Initilization.Environment+".psw.gov.pk/app/"); 
		//Initilization.click_On_Button_Action("xpath", SubscriptionLocators.returntoHomePage_Loc);
		// Initilization.click_On_Button("xpath",
		
		// Let the page to load
		Initilization.WebDriverWait(4);

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
		// Delete the Created User
		//SubscriptionHelper.DeleteApplicationIDFromDataBase(nTN_Sub_Data);
		
		
		
	}
	//Ensure system is changing payment status from 'Unpaid' to 'Paid' after execution of payment utility.
	@Test(description = "PaymentStatusPaidAfterResumeSubscription", enabled = false, dataProvider = "SubscriptionEndtoEnd")

	public static void TC2(String NTN, String CNIC, String phoneNum, String email) {

		String nTN_Sub_Data = NTN;
		String cnic_Sub_Data = CNIC;
		String email_Sub_Data = email;
		String mobileNumber_Sub_Data = phoneNum;
		
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
		Initilization.WebDriverWait(15);
		// Initilization.UpdateBioMatricStatus(Url, Apid, Cnic);
		String ApID = Initilization.get_Text("xpath", "(//h6[@id='sub-fee-slip-applicationID-data'])[1]");

		System.out.println("ApID is :" + ApID);
		//String paymentSlip = Initilization.get_Text("xpath", "(//h6[@id='sub-fee-slip-subscriptionFees-data'])[1]");
		String paymentSlip = Initilization.getTextcss(SubscriptionLocators.paymentSlip_Loc);
		paymentSlip = paymentSlip.substring(6, 23);
		Initilization.UpdatePaymentStatus(SubscriptionLocators.paymentUrl, paymentSlip);
		Initilization.WebDriverWait(10);
		Initilization.click_On_Button("xpath", SubscriptionLocators.paidButton);
		Initilization.click_On_Button("xpath", SubscriptionLocators.cancelBtnLoc);
		Initilization.BrowserAlert("yes");
		Initilization.waitUntilElementtoLoad(2);
		Initilization.click_On_Button("xpath", SubscriptionLocators.createAccountBtnLoc);
		Initilization.waitUntilElementtoLoad(2);
		Initilization.click_On_Button("xpath", SubscriptionLocators.resumeAppBtn_Loc);
		Initilization.waitUntilElementtoLoad(2);
		SubscriptionHelper.ResumeApplication(ApID, email);
		//
		Initilization.HardAssertion("css", SubscriptionLocators.paymentStatusLoc, null, "Paid");
		SubscriptionHelper.DeleteApplicationIDFromDataBase(nTN_Sub_Data);
		
	}

	@Test(description = "PaymentStatusUnPaidAfterResumeSubscription", enabled = false, dataProvider = "SubscriptionEndtoEnd")

	public static void TC3(String NTN, String CNIC, String phoneNum, String email) {

		String nTN_Sub_Data = NTN;
		String cnic_Sub_Data = CNIC;
		String email_Sub_Data = email;
		String mobileNumber_Sub_Data = phoneNum;
		//SubscriptionHelper.DeleteApplicationIDFromDataBase(NTN);
		Initilization.OpenUrl(URL);
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
		Initilization.waitUntilElementtoLoad(5);
		String ApID = Initilization.getText("sub-fee-slip-applicationID-data");

		System.out.println("ApID is :" + ApID);

		Initilization.click_On_Button("css", "#sub-info-subtext-cancel");
		Initilization.BrowserAlert("yes");
		Initilization.WebDriverWait(3);
		Initilization.click_On_Button("xpath", "//p[@class='text-center']");
		Initilization.WebDriverWait(3);
		Initilization.click_On_Button("xpath", "//button[@class='d-inline btn btn-primary btn-sm']");
		Initilization.WebDriverWait(3);
		SubscriptionHelper.ResumeApplication(ApID, email);
		//
		Initilization.WebDriverWait(15);

		Initilization.HardAssertion("css", "div[class='slip-box pl-2 col-4'] strong", null, "Unpaid");
		SubscriptionHelper.DeleteApplicationIDFromDataBase(nTN_Sub_Data);
		
	}

	@Test(description = "BiomatricStatusNotVerifiedAfterResumeSubscription", enabled =false, dataProvider = "SubscriptionEndtoEnd")

	public static void TC4(String NTN, String CNIC, String phoneNum, String email) {

		String nTN_Sub_Data = NTN;
		String cnic_Sub_Data = CNIC;
		String email_Sub_Data = email;
		String mobileNumber_Sub_Data = phoneNum;
		String smsOtp_IA_data;
		String emailOtp_IA_data;
			//SubscriptionHelper.DeleteApplicationIDFromDataBase(NTN);
		Initilization.OpenUrl(URL);
//		// HomePage
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
		Initilization.waitUntilElementtoLoad(5);
		// Initilization.UpdateBioMatricStatus(Url, Apid, Cnic);
		String ApID = Initilization.getText("sub-fee-slip-applicationID-data");

		System.out.println("ApID is :" + ApID);
		String paymentSlip = Initilization.getTextcss(SubscriptionLocators.paymentSlip_Loc);
		paymentSlip = paymentSlip.substring(6, 23);
		Initilization.UpdatePaymentStatus(SubscriptionLocators.paymentUrl, paymentSlip);
		Initilization.WebDriverWait(10);
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
		Initilization.WebDriverWait(1);

		// Cancel Application
		Initilization.click_On_Button("css", "#sub-info-subtext-cancel");
		Initilization.BrowserAlert("yes");
		Initilization.waitUntilElementtoLoad(2);
		Initilization.click_On_Button("xpath", "//p[@class='text-center']");
		Initilization.waitUntilElementtoLoad(2);
		Initilization.click_On_Button("xpath", "//button[@class='d-inline btn btn-primary btn-sm']");
		Initilization.waitUntilElementtoLoad(2);
		SubscriptionHelper.ResumeApplication(ApID, email);
		//
		Initilization.HardAssertion("xpath", "//strong[normalize-space()='Not Verified']", null, "Not Verified");
		SubscriptionHelper.DeleteApplicationIDFromDataBase(nTN_Sub_Data);
		
	}

//	Ensure system is changing biometric status from 'Unverified' to 'Verified' after execution of biometric verification utility.

	@Test(description = "BiomatricStatusVerifiedAfterResumeSubscription", enabled = false, dataProvider = "SubscriptionEndtoEnd")

	public static void TC5(String NTN, String CNIC, String phoneNum, String email) {

		String nTN_Sub_Data = NTN;
		String cnic_Sub_Data = CNIC;
		String email_Sub_Data = email;
		String mobileNumber_Sub_Data = phoneNum;
		String smsOtp_IA_data;
		String emailOtp_IA_data;
		
		//SubscriptionHelper.DeleteApplicationIDFromDataBase(NTN);
		Initilization.OpenUrl(URL);
//		// Initilizaiton.ConnectDatabase(Initilization.ConnectionString,Initilization.username,Initilization.password);
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
		Initilization.waitUntilElementtoLoad(5);
		// Initilization.UpdateBioMatricStatus(Url, Apid, Cnic);
		String ApID = Initilization.getText("sub-fee-slip-applicationID-data");

		System.out.println("ApID is :" + ApID);
		String paymentSlip = Initilization.getTextcss(SubscriptionLocators.paymentSlip_Loc);
		paymentSlip = paymentSlip.substring(6, 23);
		Initilization.UpdatePaymentStatus(SubscriptionLocators.paymentUrl, paymentSlip);
		Initilization.WebDriverWait(10);
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
		Initilization.WebDriverWait(1);
		// BioMatric Update
		Initilization.UpdateBioMetricStatus(SubscriptionLocators.biometricUrl, ApID, cnic_Sub_Data);
		Initilization.WebDriverWait(1);

		// Cancel Application
		Initilization.click_On_Button("css", "#sub-info-subtext-cancel");
		Initilization.BrowserAlert("yes");
		Initilization.waitUntilElementtoLoad(2);
		Initilization.click_On_Button("xpath", "//p[@class='text-center']");
		Initilization.waitUntilElementtoLoad(2);
		Initilization.click_On_Button("xpath", "//button[@class='d-inline btn btn-primary btn-sm']");
		Initilization.waitUntilElementtoLoad(2);
		SubscriptionHelper.ResumeApplication(ApID, email);
		//
		Initilization.HardAssertion("xpath", "//strong[normalize-space()='Verified']", null, "Verified");
		SubscriptionHelper.DeleteApplicationIDFromDataBase(nTN_Sub_Data);
		
	}

	@Test(description = "VerifytheAlreadySubcribedUser", enabled = false, dataProvider = "SubscriptionEndtoEnd")
	public static void TC6(String NTN, String CNIC, String phoneNum, String email)

	{
		String nTN_Sub_Data = "0000292";
		//SubscriptionHelper.DeleteApplicationIDFromDataBase(NTN);
		
		Initilization.OpenUrl(URL);
//		// This Line will Click on Subscriber Button
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
		Initilization.WebDriverWait(3);

		String actual = Get_Bar_Validation_Msg("xpath", "//*[@role=\"alert\"]");

		Initilization.HardAssertion(null, null, actual,
				"This NTN is already registered, please click login or forgot password to continue.");
		
	}

	@Test(description = "Ensure system is validating NTN during subscription process.", enabled = false, dataProvider = "SubscriptionEndtoEnd")
	public static void TC7(String NTN, String CNIC, String phoneNum, String email)

	{
		// Data and Locators
		String nTN_Sub_Data = NTN;
		String cnic_Sub_Data = "17301-1393801-3";
		String email_Sub_Data = email;
		String mobileNumber_Sub_Data = phoneNum;
		
		Initilization.OpenUrl(URL);
//		// This Line will Click on Subscriber Button
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
		Initilization.WebDriverWait(8);
		// This Line will Add CNIC in the CNIC Field
		Initilization.enter_Text("xpath", SubscriptionLocators.cnic_Sub_Loc, cnic_Sub_Data);
		// This Line will Add Email in the Email Field
		Initilization.enter_Text("xpath", SubscriptionLocators.email_Sub_Loc, email_Sub_Data);
		// This Line will Add MobileNumber in the MobileNumber Field
		Initilization.enter_Text("xpath", SubscriptionLocators.mobileNumber_Sub_Loc, mobileNumber_Sub_Data);
		// This Line will Click on Generated Voucher Button
		Initilization.click_On_Button("xpath", SubscriptionLocators.generateVoucher_Sub_Loc);

		String actual = Get_Bar_Validation_Msg("xpath", "//*[@role=\"alert\"]");

		Initilization.HardAssertion(null, null, actual, "Please provide CNIC from the list populated.");
		SubscriptionHelper.DeleteApplicationIDFromDataBase(nTN_Sub_Data);
		
	}
	
	@Test(description = "Ensure system is validating NTN during subscription process.", enabled = false, dataProvider = "SubscriptionEndtoEnd")
	public static void TC8(String NTN, String CNIC, String phoneNum, String email)

	{
		// Data and Locators
		String nTN_Sub_Data = "0000297";
		String cnic_Sub_Data = "17301-1393801-3";
		String email_Sub_Data = email;
		String mobileNumber_Sub_Data = phoneNum;
		//SubscriptionHelper.DeleteApplicationIDFromDataBase(NTN);
		Initilization.OpenUrl(URL);
//		// This Line will Click on Subscriber Button
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
		Initilization.WebDriverWait(3);
		// This Line will Click on Generated Voucher Button
		Initilization.WebDriverWait(2);
		Initilization.HardAssertion("xpath", "//*[normalize-space(text()) = 'Manufacturing/Manufacture of other textiles/Manufacture of other textiles n.e.c.']", null, "Manufacturing/Manufacture of other textiles/Manufacture of other textiles n.e.c.");
		//Initilization.HardAssertion("xpath", "//*[normalize-space(text()) = '17301XXXXX411']", null, "17301XXXXX411");
		Initilization.HardAssertion("xpath","(//*[normalize-space(text()) = 'FRONTIER WOOLLEN MILLS (PVT.) LIMITED'])[2]", null, "FRONTIER WOOLLEN MILLS (PVT.) LIMITED");
		Initilization.HardAssertion("xpath", "//*[normalize-space(text()) = '98 JAMRUD ROAD, PESHAWAR INDUSTRIAL ESTATE, JAMRUD ROAD HAYATABAD, Peshawar Peshawar']", null, "98 JAMRUD ROAD, PESHAWAR INDUSTRIAL ESTATE, JAMRUD ROAD HAYATABAD, Peshawar Peshawar");
		SubscriptionHelper.DeleteApplicationIDFromDataBase(nTN_Sub_Data);
		
	}
	
	@Test(description = "Testing the Validate Button 1000 Times", enabled = false, dataProvider = "SubscriptionEndtoEnd",invocationCount = 150)
	public static void TC9(String NTN, String CNIC, String phoneNum, String email)

	{
		// Data and Locators
		String nTN_Sub_Data = NTN;
		String cnic_Sub_Data = "17301-1393801-3";
		String email_Sub_Data = email;
		String mobileNumber_Sub_Data = phoneNum;
		//SubscriptionHelper.DeleteApplicationIDFromDataBase(NTN);
		Initilization.OpenUrl(URL);
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
		//Comment for Random Scenarios
		/*
		 * int counter=1000; while(counter!=0) { Initilization.click_On_Button("xpath",
		 * SubscriptionLocators.validateButton_Sub_Loc); counter--; }
		 */
		
	}
	
		
}
