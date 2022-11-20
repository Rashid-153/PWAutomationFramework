package AutomationFrameWork.TestCases.SubscriptionTestCases;

import AutomationFrameWork.Helpers.SubscriptionHelper;
import AutomationFrameWork.SetupFiles.Initilization;
import Locators.SubscriptionLocators;
import Locators.TraderRegistrationLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class SubscriptionPhysicalVerificationTestCases extends Initilization {

    static String NTNs;
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
        return new Object[][]{
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

                {"0000292", "3740504274611", "3172094681", "maazmaaz97@gmail.com", "Zong", "M/S HAIDERY PLYWOOD IND. PVT LIMITED", "27, Phase 1, Hattar Industrial Estate, Haripur Haripur", "Commercial", "Karachi"}
                /*	{ "0000292", "3740504274611", "3172094681", "maazmaaz97@gmail.com" },*/
                /*
                 * { "0656498", "3720178264574", "3172094681", "maazmaaz97@gmail.com" }, {
                 * "0000297", "1730113938011", "3172094681", "maazmaaz97@gmail.com" } , {
                 * "0000298", "1730114351289", "3172094681", "maazmaaz97@gmail.com" }
                 */

        };
//

    }

    @Test(priority = 1,description = "Subscription", enabled = true, dataProvider = "SubscriptionEndtoEnd")
    public static void ValidateSubscription(String NTN, String CNIC, String phoneNum, String email, String networkProvide, String BusinessName, String BusinessAddress, String UserSubType, String City) {
        // Data and Locators

        String nTN_Sub_Data = NTN;
        String cnic_Sub_Data = CNIC;
        String email_Sub_Data = email;
        String mobileNumber_Sub_Data = phoneNum;
        String networkProvider_Sub_Data = networkProvide;
        String smsOtp_IA_data;
        String emailOtp_IA_data;
        String userName = "UN-00-" + nTN_Sub_Data;
        NTNs=NTN;

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
        Initilization.enter_Text("xpath", SubscriptionLocators.networkProvider_Sub_Loc, networkProvider_Sub_Data + Keys.ENTER);
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
        Initilization.UpdatePaymentStatus(SubscriptionLocators.paymentUrl, paymentSlip);

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
        String Query = "\n" +
                "use MEBIRD; declare @YourField varchar(2000);\n" +
                "SELECT TOP 1 @YourField =  m.body FROM [Message] AS m WHERE m.Recepient='" + email_Sub_Data + "' AND m.[Subject]='Pakistan Single Window | Biometric Verification' ORDER BY m.ID DESC\n" +
                "\n" +
                "declare @Keyword varchar(2000) = 'href=\"'\n" +
                "declare @keyword1 varchar(74) = 'style=\"text-decoration:none;color:#000\">click here</a>.</p></em></body></html>'\n" +
                "select SUBSTRING(@YourField,charindex(@Keyword,@YourField) + LEN(@Keyword), LEN(@keyword1) ) AS body";
        Initilization.WebDriverWait(30);
        String verificationLink = SubscriptionHelper.CustomeDatabaseQueries(Query, "body");

        Initilization.OpenNewTab(verificationLink);
        System.out.println(verificationLink);
        Initilization.WebDriverWait(5);
        Initilization.click_On_CheckBox("xpath", "//input[@class='k-checkbox']");
        Initilization.WebDriverWait(2);
        Initilization.click_On_Button("xpath", "//button[@type='submit']");
        Initilization.WebDriverWait(2);
        Initilization.click_On_Button("xpath", "//button[@type='button']");

        Initilization.WebDriverWait(4);

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
        Initilization.WebDriverWait(5);


    }

    @Test(priority = 2, enabled = true, description = "verify Trader registartion", dataProvider = "SubscriptionEndtoEnd")
    public void ValidateTraderRegistration(String NTN, String CNIC, String phoneNum, String email, String networkProvide, String BusinessName, String BusinessAddress, String UserSubType, String City) {

        String userName = "UN-00-" + NTN;
        String businessName = BusinessName;
        String businessAddress = BusinessAddress;
        String userSubType = UserSubType;
        String city = City;

        String documentPath = Initilization.projectDirectory + "\\Resources\\dwd.png";


        Initilization.OpenUrl("https://" + Initilization.Environment + ".psw.gov.pk/app/");
        //Initilization.click_On_Button_Action("xpath", SubscriptionLocators.returntoHomePage_Loc);
        // Initilization.click_On_Button("xpath",

        // PSW Portal LoginPage
        // This Line will enter the UserName in the username Field
        Initilization.waitUntilElementtoLoad(10);
        Initilization.enter_Text("name", "userName", userName);
        // This Line will enter the pasword in the pasword Field
        Initilization.enter_Text("name", "password", SubscriptionLocators.password);
        // This Line will click on Submit Button
        Initilization.click_On_Button("xpath", SubscriptionLocators.loginBtn_Loc);
        Initilization.WebDriverWait(3);

        String actual = Initilization.Get_Bar_Validation_Msg("xpath", "//div[@role='alert']");
        Initilization.HardAssertion(null, null, actual, "Your physical verification is pending. You are required to appear before AC/DC User ID of Collectorate of jurisdiction to complete your verification process. You will be able to file declaration ONLY after physical verification");


        Initilization.click_On_Button("xpath", TraderRegistrationLocators.registrationMenu);

        System.out.println("Registration Menu Open Successfully");
        Initilization.WebDriverWait(2);

        /* Click on trader button */
        Initilization.click_On_Button("xpath", TraderRegistrationLocators.traderRegistrationButton);
        System.out.println("Trader Registration Form Open Successfully");

        /* Select Business Name */
        Initilization.click_On_Button("css", TraderRegistrationLocators.selectBusinessName);
        Initilization.enter_Text("css", TraderRegistrationLocators.selectBusinessName,
                businessName + Keys.ENTER);


        /* Select business address */
        Initilization.click_On_Button("css", TraderRegistrationLocators.selectBusinessAddress);
        Initilization.enter_Text("css", TraderRegistrationLocators.selectBusinessAddress,
                businessAddress + Keys.ENTER);


        /* Select User SubType */

        Initilization.click_On_Button("id", TraderRegistrationLocators.selectUserSubType);
        Initilization.enter_Text("id", TraderRegistrationLocators.selectUserSubType, userSubType + Keys.ENTER);

        /*select city*/

        Initilization.click_On_Button("id", TraderRegistrationLocators.selectCity);
        Initilization.enter_Text("id", TraderRegistrationLocators.selectCity, city + Keys.ENTER);


        /* Upload document */

        Initilization.enter_Text("name", TraderRegistrationLocators.chooseFiles,
                documentPath);
        Initilization.WebDriverWait(2);


        /* Click on submit button */

        Initilization.click_On_Button("xpath", TraderRegistrationLocators.submitButton);
        Initilization.WebDriverWait(3);

    }

    @Test(priority = 3, enabled = true, description = "Verify Hide Menus before physical verification")
    public void ValidateHideMenus() {
        String TraderRegisteredMessage = Initilization.Get_Bar_Validation_Msg("xpath", TraderRegistrationLocators.successAlert);
        Initilization.HardAssertion(null, null, TraderRegisteredMessage, "You are successfully registered as a Trader. However, your physical verification is pending before AC/DC User ID of MCC Appraisement Karachi East - Import. You will be able to file declaration ONLY after physical verification.");

        /* Click on Home Menu */
        Initilization.click_On_Button("xpath", TraderRegistrationLocators.homeMenu);
        Initilization.WebDriverWait(2);

        int MenuCount = driver.findElements(By.xpath(TraderRegistrationLocators.GoodsDeclarationMenu)).size();

        if (MenuCount > 0) {
            String goodsMenu = Initilization.Get_Bar_Validation_Msg("xpath", TraderRegistrationLocators.GoodsDeclarationMenu);
            Initilization.HardAssertion(null, null, goodsMenu, "Goods Declaration");
        } else {
            System.out.println("Case passed");
        }

    }

    @Test(priority = 4, enabled = true, description = "Verify Hide Menus before physical verification")
    public void ValidateVerificationThroughAPI(){

        //Get AspNetUserID according to the above NTN below is DB query for fetching
        String query="select ID from AspNetUser WHERE UserName LIKE '%"+NTNs+"%'";
        String AspNetUserID = SubscriptionHelper.CustomeDatabaseQueries(query,"ID");

        //Insert AspNetUserID into Physical verfication API
        String apiResponse=SubscriptionHelper.UpdatePhysicalVerificationStatus("https://10.1.4.59/qa",AspNetUserID);

        //Apply assertion on  API response
        Initilization.HardAssertion(null,null,apiResponse,"Verification Completetd");



    }

    @Test(priority = 5, enabled = false, description = "Verify Hided Menus should visible after physical verification")
    public void ValidateMenusShouldVisible(){

        //Verification completed below we have te test the hided menus should be visible

        Initilization.WebDriverWait(15);
        Initilization.click_On_Button("xpath", "//span//a//span[normalize-space()='Home']");
        Initilization.WebDriverWait(2);

        int MenuCount = driver.findElements(By.xpath(TraderRegistrationLocators.GoodsDeclarationMenu)).size();

        System.out.println(MenuCount);

        if (MenuCount == 0) {
            String goodsMenu = Initilization.Get_Bar_Validation_Msg("xpath",TraderRegistrationLocators.GoodsDeclarationMenu);
            Initilization.HardAssertion(null, null, goodsMenu, "Goods Declaration");

            Initilization.click_On_Button("xpath", SubscriptionLocators.username_Loc);

            Initilization.WebDriverWait(3);
            Initilization.click_On_Button("xpath", SubscriptionLocators.logout);

        } else {
            System.out.println("Verification not completed");

        }


    }


}

