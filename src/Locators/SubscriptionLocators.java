package Locators;

import AutomationFrameWork.SetupFiles.Initilization;

public class SubscriptionLocators {
 	public static String paymentUrl = "https://"+Initilization.Environment+".psw.gov.pk/api/ups/PSID/open";
 	public static String biometricUrl = "https://"+Initilization.Environment+".psw.gov.pk/api/auth/EDI/open";
 	public static String subscribeButtonCss = "//a[contains(@href,'/app/subscription')] | //a[normalize-space()='Subscribe']";
 	public static String iAgreeButtonX = "//input[@type='checkbox'] | //input[@role='checkbox']";
 	public static String proceedButtonX = "//button[normalize-space() = 'Proceed'] | //button[@type='submit']";
 	public static String nTN_Sub_Loc = "//input[@name='NTN'] | //input[@xpath='1'] | //input[@placeholder='Enter NTN']  ";
	//String nTN_Sub_Data = NTN;
 	public static String validateButton_Sub_Loc = "//button[normalize-space()='Validate'] | //button[@xpath='1'] | //button[@id='sub-info-button-validate'] | //button[@class='btn btn-primary']";
 	public static String cnic_Sub_Loc = "//input[@id='input-cnic']  |  //input[@xapth='1']  |  //input[@placeholder='Enter CNIC Number'] ";
	//String cnic_Sub_Data = CNIC;
 	public static String email_Sub_Loc = "//input[@name='Email']  | //input[@xpath='1']  | //input[@placeholder='Enter Email'] ";
	//String email_Sub_Data = email;
 	public static String mobileNumber_Sub_Loc = "//input[@name='CellNumber']  |  //input[@placeholder='Enter Mobile Number'] ";
	 public static String networkProvider_Sub_Loc = "//input[@placeholder='Select Network']";
	
	 //String mobileNumber_Sub_Data = phoneNum;
 	public static String generateVoucher_Sub_Loc = "//button[normalize-space()='Generate Voucher'] | //button[@xpath='1']";
 	public static String paymentSlip_Loc = "#sub-fee-slip-subscriptionFees-data";
 	public static String  ApIDText_Loc ="sub-fee-slip-applicationID-data";
 	public static String paidButton = "//p[@class='d-inline']//*[local-name()='svg'] | //p[@xpath='1']//*[local-name()='svg']";
 	public static String proceedBtn_Loc ="//button[@id='sub-info-button-sendOTP'] | //button[@type='submit'] | //button[@xpath='1'] | //button[normalize-space()='Proceed']";
 	public static String sendOTPBtn_Loc = "//button[@id='sub-info-button-sendOTP'] | //button[@xpath='1'] | //button[normalize-space()='Proceed']";
 	public static String smsOtp_IA_Loc = "//input[@name='cellOTP'] | //input[@placeholder='Enter Mobile OTP'] | //input[@value='Test@1']";
 	public static String smsOtp_IA_data;
 	public static String emailOtp_IA_Loc = "//input[@name='emailOTP'] | //input[@placeholder='Enter Email OTP'] | //input[@xpath='1']";
 	public static String emailOtp_IA_data;
 	public static String submitButton_IA_Loc = "//button[@xpath='1'] | //button[@type='submit'] | //button[normalize-space()='Submit']";
 	public static String resumeAppBtn_Loc = "//button[normalize-space()='Resume Subscription'] | //button[@type='button'] | //button[@xpath='1']";
 	public static String fetchApp_Loc = "//button[normalize-space()='Fetch Application']";
 	public static String biomatric_Proceed_btn_Loc = "//button [@class='btn btn-primary btn-block btn-sm'] | //button[normalize-space()='Proceed'] ";
	//String userName = "UN-00-" + nTN_Sub_Data;
 	public static String password = "Test@1234";
 	public static String passwordSet_Loc = "//input[@name='password'] | //input[@placeholder='Password']";
 	public static String confirmPasswordSet_Loc ="//input[@name='confirmPassword'] | //input[@placeholder='Confirm Password']";
 	public static String SubmitBtn_Loc =  "//button[normalize-space()='Create Password'] | //button[@type='submit']";
 	public static String returntoHomePage_Loc = "//button[normalize-space('Return to Home')] | //button[@class='k-button'] | //a[@href='/app/app']";
 	public static String loginBtn_Loc = "//button[@type='submit'] | //button[normalize-space()='Login'] ";
 	public static String username_Loc = "//button[@aria-haspopup='true'] | //button[@aria-expanded='false'] | //button[@eventkey='1']";
 	public static String cancelBtnLoc ="//h6[@id='sub-info-subtext-cancel'] | //strong[normalize-space()='Click here'] ";
 	public static String createAccountBtnLoc = "//p[@class='text-center']";
 	public static String paymentStatusLoc = "div[class='slip-box pl-2 col-4'] strong";
 	public static String logout = "//*[normalize-space(text()) = 'Logout']";
 	public static String ChangePassword ="//*[normalize-space(text()) = 'Change Password']";
 	public static String forgotPassword = "//p[normalize-space()='Having trouble logging in?']";
 	public static String userID = "//input[@name='userId']";
 	public static String CNIC = "//input[@id='input-cnic']";
 	public static String EmailAddress = "//input[@name='EmailAddress']";
 	public static String sendOTP = "//button[normalize-space()='Send OTP']";
 	public static String RecievedOTP = "//p[normalize-space()='I have received the OTP']";
 	public static String BusinessAddres = "(//span[@class='k-input'])[4]";
 	

}
