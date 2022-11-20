package AutomationFrameWork.TestCases.SingleDecleration;
import AutomationFrameWork.Helpers.DPPExportCertificateHelper;
import AutomationFrameWork.Helpers.SingleDeclerationAmendmentExportHelper;
import AutomationFrameWork.TestCases.ExportCertificate.DPPExportCertificateTestCases;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import AutomationFrameWork.Helpers.DPPExportCertificateHelper;
import AutomationFrameWork.Helpers.SingleDeclearationHelper;

//import AutomationFrameWork.Helpers.WebElement;

import AutomationFrameWork.SetupFiles.Initilization;

public class SingleDeclerationAmendmentExportTestCases extends SingleDeclerationAmendmentExportHelper {
    @Parameters("browsers")
    @BeforeTest
    public static void BeforeTest(String BrowserName) {
        // Initialize Browser
        Initilization.BrowsersType = BrowserName;
        Initilization.URL = "https://" + Initilization.Environment + ".psw.gov.pk/app/";

    }

    @Test(description = "SdAmendmentEndToEntFlow", enabled = false, invocationCount = 1)
    public static void Verify_EndToEndFlowAmendment() {
       /* String ntn = "0133358";
        String userName = "UN-00-" + ntn;
        String password = "Test@1234";

        Initilization.OpenUrl(Initilization.URL);
        // HomePage
        Initilization.waitUntilElementtoLoad(12);
        // This Line will Click on Subscriber Button
        Initilization.Login(userName, password);
        Initilization.waitUntilElementtoLoad(6);
        SingleDeclearationHelper.OpenMenu();
        Initilization.waitUntilElementtoLoad(18);*/

        String sdNumber = SingleDeclearationHelper.fileOGASingleDeclarationWithOpenAccount();

        Initilization.enter_Text("xpath", "//input[@placeholder='Search anything']", "Single Declaration"); //Enter Text in the search of UPS screen
        Initilization.waitUntilElementtoLoad(5);
        Initilization.click_On_Button("xpath", "//a[@class='result']");
        Initilization.WebDriverWait(4);

        Initilization.click_On_Button("xpath", "(//p[normalize-space()='Submitted'])[2]"); //Click on Export Submitted SD
        Initilization.WebDriverWait(5);

        Initilization.enter_Text("xpath", "//input[@placeholder='Search']", sdNumber);

        String gdStatus = SingleDeclerationAPI.getGDStatus(sdNumber);
        //String gdStatus="Submitted";

        Boolean sd = false;
        while (!sd) {
            if (gdStatus.equalsIgnoreCase("Assigned for Gate In Role")) {
                sd = true;
            }
            gdStatus = SingleDeclerationAPI.getGDStatus(sdNumber);
            //System.out.println(gdStatus);
            System.out.println("Waiting...");
            WebDriverWait(10);


        }


        System.out.println(gdStatus);

        Initilization.click_On_Button("xpath", "(//a[@class='ListSingleDeclaration_greenIcon__YMHOv'])[2]"); //Click on amend Icon on SD grid

        ConsigmentInformationAmendment();
        waitUntilElementtoLoad(8);

        Click_CommodityInformationTabAmendment();
        waitUntilElementtoLoad(3);

        AmendContaiter();
        WebDriverWait(3);

        SaveAndSubmitAmendment();

        WebDriverWait(5);


    }

    @Test(description = "SdConsignmentInformationTabAmendmentBeforeGateIn", enabled = false, invocationCount = 1)
    public static void Verify_ConsignmentInformationTabAmendmentExport() {
      /*  String ntn = "0133358";
        String userName = "UN-00-" + ntn;
        String password = "Test@1234";

        Initilization.OpenUrl(Initilization.URL);
        // HomePage
        Initilization.WebDriverWait(12);
        // This Line will Click on Subscriber Button
        Initilization.Login(userName, password);
        Initilization.WebDriverWait(6);
        SingleDeclearationHelper.OpenMenu();
        Initilization.WebDriverWait(15); */

        String sdNumber = SingleDeclearationHelper.fileOGASingleDeclarationWithOpenAccount();

        Initilization.enter_Text("xpath", "//input[@placeholder='Search anything']", "Single Declaration"); //Enter Text in the search of UPS screen
        Initilization.waitUntilElementtoLoad(5);
        Initilization.click_On_Button("xpath", "//a[@class='result']");
        Initilization.WebDriverWait(4);

        Initilization.click_On_Button("xpath", "(//p[normalize-space()='Submitted'])[2]"); //Click on Export Submitted SD
        Initilization.WebDriverWait(5);

        Initilization.enter_Text("xpath", "//input[@placeholder='Search']", sdNumber);

        String gdStatus = SingleDeclerationAPI.getGDStatus(sdNumber);
        //String gdStatus="Submitted";
        int counter=0;
        Boolean sd = false;
        while (!sd||counter>=300) {
            if (gdStatus.equalsIgnoreCase("Assigned for Gate In Role")) {
                sd = true;
            }
            gdStatus = SingleDeclerationAPI.getGDStatus(sdNumber);
            //System.out.println(gdStatus);
            System.out.println("Waiting...");
            WebDriverWait(10);
            counter+=1;


        }


        System.out.println(gdStatus);


        Initilization.click_On_Button("xpath", "(//p[normalize-space()='Submitted'])[2]"); //Click on Export Submitted SD
        Initilization.waitUntilElementtoLoad(30);

        Initilization.click_On_Button("xpath", "(//a[@class='ListSingleDeclaration_greenIcon__YMHOv'])[2]"); //Click on Amendment Icon in SD view
        waitUntilElementtoLoad(30);

        ConsigmentInformationAmendment();
        SaveAndSubmitAmendment();


    }


    @Test(description = "SdCommodityInformationAmendmentBeforeGateIn", enabled = false, invocationCount = 1)
    public static void Verify_Container_Update_or_Add() {
        String ntn = "0133358";
        String userName = "UN-00-" + ntn;
        String password = "Test@1234";

        Initilization.OpenUrl(Initilization.URL);
        // HomePage
        Initilization.WebDriverWait(12);
        // This Line will Click on Subscriber Button
        Initilization.Login(userName, password);
        Initilization.WebDriverWait(6);
        SingleDeclearationHelper.OpenMenu();
        Initilization.WebDriverWait(18);

        Initilization.click_On_Button("xpath", "(//p[normalize-space()='Submitted'])[2]"); //Click on Export Submitted SD
        Initilization.WebDriverWait(10);

        Initilization.click_On_Button("xpath", "(//a[@class='ListSingleDeclaration_greenIcon__YMHOv'])[2]"); //Click on Amendment Icon in SD view
        WebDriverWait(10);

        Click_CommodityInformationTabAmendment();
        Initilization.WebDriverWait(8);
        AmendContaiter();
        Initilization.WebDriverWait(4);
        SaveAndSubmitAmendment();

        Initilization.WebDriverWait(5);
    }


    @Test(description = "SdCommodityInformationAmendmentBeforeGateIn", enabled = false, invocationCount = 1)
    public static void Verify_Container_Delete() {
        String ntn = "0133358";
        String userName = "UN-00-" + ntn;
        String password = "Test@1234";

        Initilization.OpenUrl(Initilization.URL);
        // HomePage
        Initilization.WebDriverWait(12);
        // This Line will Click on Subscriber Button
        Initilization.Login(userName, password);
        Initilization.WebDriverWait(6);
        SingleDeclearationHelper.OpenMenu();
        Initilization.WebDriverWait(18);

        Initilization.click_On_Button("xpath", "(//p[normalize-space()='Submitted'])[2]"); //Click on Export Submitted SD
        Initilization.WebDriverWait(8);

        Initilization.click_On_Button("xpath", "(//a[@class='ListSingleDeclaration_greenIcon__YMHOv'])[2]"); //Click on Amendment Icon in SD view
        WebDriverWait(10);


        Click_CommodityInformationTabAmendment();

        Initilization.click_On_Button("xpath", "(//a[@class='AmendSDExport_delIcon__1Sqq0'])[2]"); // Click on  Item AmendIcon
        Initilization.WebDriverWait(10);

        AddContainer();
        Initilization.WebDriverWait(5);

        DeleteContainer();
        Initilization.WebDriverWait(4);

        Initilization.click_On_Button("xpath", "//button[@class='undefined btn btn-primary']"); // Go Back Action to 'Save and Submit Screen'
        Initilization.waitUntilElementtoLoad(5);

        SaveAndSubmitAmendment();

        Initilization.WebDriverWait(5);
    }

    @Test(description = "SdCommodityInformationAmendmentBeforeGateIn", enabled = false, invocationCount = 1)
    public static void Verify_CommodityInformation_Item_AmendmentExport() {
          /*  String ntn = "0133358";
            String userName = "UN-00-" + ntn;
            String password = "Test@1234";

            Initilization.OpenUrl(Initilization.URL);
            // HomePage
            Initilization.WebDriverWait(12);
            // This Line will Click on Subscriber Button
            Initilization.Login(userName, password);
            Initilization.WebDriverWait(6);
            SingleDeclearationHelper.OpenMenu();
            Initilization.WebDriverWait(18);*/

        String SDID = null;
        String sdNumber = SingleDeclearationHelper.fileOGASingleDeclarationWithOpenAccount();

        Initilization.enter_Text("xpath", "//input[@placeholder='Search anything']", "Single Declaration"); //Enter Text in the search of UPS screen
        Initilization.waitUntilElementtoLoad(5);
        Initilization.click_On_Button("xpath", "//a[@class='result']");
        Initilization.WebDriverWait(4);

        Initilization.click_On_Button("xpath", "(//p[normalize-space()='Submitted'])[2]"); //Click on Export Submitted SD
        Initilization.WebDriverWait(5);

        Initilization.enter_Text("xpath", "//input[@placeholder='Search']", sdNumber);

        String gdStatus = SingleDeclerationAPI.getGDStatus(sdNumber);
        //String gdStatus="Submitted";

        Boolean sd = false;
        while (!sd) {
            if (gdStatus.equalsIgnoreCase("Assigned for Gate In Role")) {
                sd = true;
            }
            gdStatus = SingleDeclerationAPI.getGDStatus(sdNumber);
            //System.out.println(gdStatus);
            System.out.println("Waiting...");
            WebDriverWait(10);


        }


        System.out.println(gdStatus);


        Initilization.click_On_Button("xpath", "(//a[@class='ListSingleDeclaration_greenIcon__YMHOv'])[2]"); //Click on Export Submitted SD
        Initilization.waitUntilElementtoLoad(5);


        String Query1 = "use SD select ID from SD where DocumentNumber='" + sdNumber + "'";
        SDID = Initilization.CustomeDatabaseQueries(Query1, "ID");

        String Query2 = "USE SD SELECT COUNT(ID) AS 'Count' FROM SDITEM WHERE SDID='" + SDID + "'";
        int SDItemCount = Integer.parseInt(Initilization.CustomeDatabaseQueries(Query2, "Count"));
        Click_CommodityInformationTabAmendment();
        Initilization.WebDriverWait(3);

        if (SDItemCount > 1) {
            AmendItem();
        } else {
            System.out.println("Atleast one commodity should be attached with SD ");
        }

        waitUntilElementtoLoad(5);


    }

    @Test(description = "Payment should be created when the user amend more than 10% variance in quantity after EC Approval", enabled = true, invocationCount = 1)
    public static void Verify_SDAmendment_AfterECApproval() {
        {
            String ntn = "0133358";
            String userName = "UN-00-" + ntn;
            String password = "Test@1234";

       String SDnumber= DPPExportCertificateHelper.ExportCertificateApprovalViaEC();
       Initilization.WebDriverWait(5);
            SingleDeclerationAmendmentExportHelper.logOutAfterApproval();
            Initilization.WebDriverWait(3);
            //Initilization.OpenUrl(Initilization.URL);
            // HomePage
            // This Line will Click on Subscriber Button
            Initilization.Login(userName, password);
            Initilization.waitUntilElementtoLoad(10);
            SingleDeclearationHelper.OpenMenu();
            Initilization.waitUntilElementtoLoad(10);

            Initilization.enter_Text("xpath", "//input[@placeholder='Search anything']", "Single Declaration"); //Enter Text in the top search bar
            Initilization.WebDriverWait(3);
            Initilization.click_On_Button("xpath", "//a[@class='result']");
            Initilization.waitUntilElementtoLoad(5);

            Initilization.click_On_Button("xpath", "(//p[normalize-space()='Submitted'])[2]"); //Click on Export Submitted SD
            Initilization.waitUntilElementtoLoad(5);

            Initilization.enter_Text("xpath", "//input[@placeholder='Search']",SDnumber);
            Initilization.waitUntilElementtoLoad(5);
            int counter= 0;
            String gdStatus = SingleDeclerationAPI.getGDStatus(SDnumber);
            Boolean sd = false;
            while (!sd||counter>=300) {
                if (gdStatus.equalsIgnoreCase("Assigned for Gate In Role")) {
                    sd = true;
                }
                gdStatus = SingleDeclerationAPI.getGDStatus(SDnumber);
                //System.out.println(gdStatus);
                System.out.println("Waiting...");
                WebDriverWait(10);
                counter+=10;


            }

            Initilization.click_On_Button("xpath", "(//a[@class='ListSingleDeclaration_greenIcon__YMHOv'])[2]"); //Click on Amendment Icon in SD view
            Initilization.WebDriverWait(3);


            ConsigmentInformationAmendment();
            Initilization.WebDriverWait(5);

            Click_CommodityInformationTabAmendment();
            Initilization.WebDriverWait(3);

            AmendContaiter();
            WebDriverWait(3);

            SaveAndSubmitAmendment();

            WebDriverWait(5);

            //Amendment Payment
            String paymentSlip = Initilization.getTextxpath("(//span[@class='title'])[5]");
            paymentSlip = paymentSlip.substring(6, 23);
            //System.out.println("PSID is 6 digits:" + paymentSlip);
            Initilization.UpdatePaymentStatus("https://"+Initilization.Environment+".psw.gov.pk/api/ups/PSID/open", paymentSlip,"2500");
          //  String SDNumber = Initilization.getTextxpath("(//strong[@class='text-dark text-break'])[3]");


            click_On_Button("xpath","//button[normalize-space()='OK']");
            Initilization.waitUntilElementtoLoad(5);

            Initilization.click_On_Button("xpath","(//button[@class='menu-toggle pr-2 bg-light rounded-0 dropdown-toggle btn btn-flat'])[2]");
            Initilization.waitUntilElementtoLoad(5);

            Initilization.click_On_Button("xpath","(//a[normalize-space()='Logout'])[1]");
            Initilization.WebDriverWait(2);

            // Approve Amendment Request from DPP officer
            String Query = "DECLARE @id nvarchar(20)"
                    +"select @id=id from OGA.dbo.ExportCertificate where SDDocumentNumber = '"+SDnumber+"'"+
                    "USE WFE;"
                    +"Declare @processId uniqueidentifier;"+
                    "set @processId = (SELECT ProcessId FROM [WorkflowProcessInstancePersistence] WHERE ParameterName = 'ExportCertificateIDSubmitted' AND Value = @id);"+
                    "SELECT Top 1 [Value] FROM [dbo].[WorkflowProcessInstancePersistence] WHERE ProcessId = @processId and [Value] Like '%DPP%' ORDER BY CreatedOn DESC";

            String DPPUser = Initilization.CustomeDatabaseQueries(Query, "Value");
            System.out.println(DPPUser);

            Initilization.WebDriverWait(3);

            Initilization.Login(DPPUser, password);

            Initilization.waitUntilElementtoLoad(12);


            Initilization.click_On_Button("xpath", "(//button[@aria-haspopup='true'])[2]");
            Initilization.waitUntilElementtoLoad(6);
            //selectEC
            Initilization.click_On_Button("xpath", "//span[normalize-space()='Entomologist - EC']");
            Initilization.waitUntilElementtoLoad(6);


            Query = "select RequestDocumentNumber from OGA.dbo.ExportCertificate where SDDocumentNumber = '"+SDnumber+"'";
            String exportCertificate = Initilization.CustomeDatabaseQueries(Query, "RequestDocumentNumber");

            Initilization.click_On_Button("xpath", "//p[normalize-space()='LPCO']");
            Initilization.waitUntilElementtoLoad(30);

            //dppLocators.exportCertificateMenu
            Initilization.click_On_Button("xpath", "//p[normalize-space()='Export Certificates']");

            Initilization.click_On_Button("xpath","(//span[@class='k-link'])[2]");

            //dppLocators.exportCertificateSearchBox
            Initilization.enter_Text("id","search-box",exportCertificate);
            waitUntilElementtoLoad(15);

            Initilization.click_On_Button("xpath", "//td[normalize-space()='"+exportCertificate+"']");
            waitUntilElementtoLoad(5);

            Initilization.scrollDown();
            Initilization.waitUntilElementtoLoad(10);

            Initilization.enter_Text("xpath","//textarea[@class='k-input']","abc");
            waitUntilElementtoLoad(5);

            Initilization.click_On_Button("xpath","//button[@title='Approve Amendment']");
            waitUntilElementtoLoad(5);

            Initilization.click_On_Button("xpath","//button[normalize-space()='Yes']");
            WebDriverWait(5);





        }

    }

    @Test(description = "Payment Should not be created when the user amend less than 10% variance in quantity after EC approval",enabled = false,invocationCount = 1)
    public static  void Verify_SDAmendment_lessthan10PercentVariance() {
        String ntn = "0133358";
        String userName = "UN-00-" + ntn;
        String password = "Test@1234";

        String SDnumber = DPPExportCertificateHelper.ExportCertificateApprovalViaEC();
        Initilization.WebDriverWait(5);
        SingleDeclerationAmendmentExportHelper.logOutAfterApproval();
        Initilization.WebDriverWait(3);
        //Initilization.OpenUrl(Initilization.URL);
        // HomePage
        // This Line will Click on Subscriber Button
        Initilization.Login(userName, password);
        Initilization.waitUntilElementtoLoad(10);
        SingleDeclearationHelper.OpenMenu();
        Initilization.waitUntilElementtoLoad(10);

        Initilization.enter_Text("xpath", "//input[@placeholder='Search anything']", "Single Declaration"); //Enter Text in the top search bar
        Initilization.WebDriverWait(3);
        Initilization.click_On_Button("xpath", "//a[@class='result']");
        Initilization.waitUntilElementtoLoad(5);

        Initilization.click_On_Button("xpath", "(//p[normalize-space()='Submitted'])[2]"); //Click on Export Submitted SD
        Initilization.waitUntilElementtoLoad(5);

        Initilization.enter_Text("xpath", "//input[@placeholder='Search']", SDnumber);
        Initilization.waitUntilElementtoLoad(5);
        int counter = 0;
        String gdStatus = SingleDeclerationAPI.getGDStatus(SDnumber);
        Boolean sd = false;
        while (!sd || counter >= 300) {
            if (gdStatus.equalsIgnoreCase("Assigned for Gate In Role")) {
                sd = true;
            }
            gdStatus = SingleDeclerationAPI.getGDStatus(SDnumber);
            //System.out.println(gdStatus);
            System.out.println("Waiting...");
            WebDriverWait(10);
            counter += 10;


        }

        Initilization.click_On_Button("xpath", "(//a[@class='ListSingleDeclaration_greenIcon__YMHOv'])[2]"); //Click on Amendment Icon in SD view
        Initilization.WebDriverWait(3);


        ConsigmentInformationAmendment();
        Initilization.WebDriverWait(5);

        Click_CommodityInformationTabAmendment();
        Initilization.WebDriverWait(3);

        UpdateContainerBelow10PercentVariance();
        WebDriverWait(3);

        SaveAndSubmitAmendment();

        WebDriverWait(5);

        //Amendment Payment
        String paymentSlip = Initilization.getTextxpath("(//span[@class='title'])[5]");
        paymentSlip = paymentSlip.substring(6, 23);
        //System.out.println("PSID is 6 digits:" + paymentSlip);
        Initilization.UpdatePaymentStatus("https://" + Initilization.Environment + ".psw.gov.pk/api/ups/PSID/open", paymentSlip, "2500");
        //  String SDNumber = Initilization.getTextxpath("(//strong[@class='text-dark text-break'])[3]");


        click_On_Button("xpath", "//button[normalize-space()='OK']");
        Initilization.waitUntilElementtoLoad(5);

        Initilization.click_On_Button("xpath", "(//button[@class='menu-toggle pr-2 bg-light rounded-0 dropdown-toggle btn btn-flat'])[2]");
        Initilization.waitUntilElementtoLoad(5);

        Initilization.click_On_Button("xpath", "(//a[normalize-space()='Logout'])[1]");
        Initilization.WebDriverWait(2);

        // Approve Amendment Request from DPP officer
        String Query = "DECLARE @id nvarchar(20)"
                + "select @id=id from OGA.dbo.ExportCertificate where SDDocumentNumber = '" + SDnumber + "'" +
                "USE WFE;"
                + "Declare @processId uniqueidentifier;" +
                "set @processId = (SELECT ProcessId FROM [WorkflowProcessInstancePersistence] WHERE ParameterName = 'ExportCertificateIDSubmitted' AND Value = @id);" +
                "SELECT Top 1 [Value] FROM [dbo].[WorkflowProcessInstancePersistence] WHERE ProcessId = @processId and [Value] Like '%DPP%' ORDER BY CreatedOn DESC";

        String DPPUser = Initilization.CustomeDatabaseQueries(Query, "Value");
        System.out.println(DPPUser);

        Initilization.WebDriverWait(3);

        Initilization.Login(DPPUser, password);

        Initilization.waitUntilElementtoLoad(12);


        Initilization.click_On_Button("xpath", "(//button[@aria-haspopup='true'])[2]");
        Initilization.waitUntilElementtoLoad(6);
        //selectEC
        Initilization.click_On_Button("xpath", "//span[normalize-space()='Entomologist - EC']");
        Initilization.waitUntilElementtoLoad(6);


        Query = "select RequestDocumentNumber from OGA.dbo.ExportCertificate where SDDocumentNumber = '" + SDnumber + "'";
        String exportCertificate = Initilization.CustomeDatabaseQueries(Query, "RequestDocumentNumber");

        Initilization.click_On_Button("xpath", "//p[normalize-space()='LPCO']");
        Initilization.waitUntilElementtoLoad(30);

        //dppLocators.exportCertificateMenu
        Initilization.click_On_Button("xpath", "//p[normalize-space()='Export Certificates']");

        Initilization.click_On_Button("xpath", "(//span[@class='k-link'])[2]");

        //dppLocators.exportCertificateSearchBox
        Initilization.enter_Text("id", "search-box", exportCertificate);
        waitUntilElementtoLoad(15);

        Initilization.click_On_Button("xpath", "//td[normalize-space()='" + exportCertificate + "']");
        waitUntilElementtoLoad(5);

        Initilization.scrollDown();
        Initilization.waitUntilElementtoLoad(10);

        Initilization.enter_Text("xpath", "//textarea[@class='k-input']", "abc");
        waitUntilElementtoLoad(5);

        Initilization.click_On_Button("xpath", "//button[@title='Approve Amendment']");
        waitUntilElementtoLoad(5);

        Initilization.click_On_Button("xpath", "//button[normalize-space()='Yes']");
        WebDriverWait(5);

    }

    @Test(description = "Remove Financial Instrument and Attach Open Account",enabled = false,invocationCount = 1)
    static public void AttachOpenAccount(){
        String sdNumber = SingleDeclearationHelper.fileOGASingleDeclarationWithOpenAccount();
        Initilization.enter_Text("xpath", "//input[@placeholder='Search anything']", "Single Declaration"); //Enter Text in the search of UPS screen
        Initilization.waitUntilElementtoLoad(5);
        Initilization.click_On_Button("xpath", "//a[@class='result']");
        Initilization.WebDriverWait(4);

        Initilization.click_On_Button("xpath", "(//p[normalize-space()='Submitted'])[2]"); //Click on Export Submitted SD
        Initilization.WebDriverWait(5);

        Initilization.enter_Text("xpath", "//input[@placeholder='Search']", sdNumber);

        String gdStatus = SingleDeclerationAPI.getGDStatus(sdNumber);
        //String gdStatus="Submitted";

        Boolean sd = false;
        while (!sd) {
            if (gdStatus.equalsIgnoreCase("Assigned for Gate In Role"))
            {
                sd = true;
            }
            gdStatus = SingleDeclerationAPI.getGDStatus(sdNumber);
            //System.out.println(gdStatus);
            System.out.println("Waiting...");
            WebDriverWait(10);

        }

        System.out.println(gdStatus);

        Initilization.click_On_Button("xpath", "(//a[@class='ListSingleDeclaration_greenIcon__YMHOv'])[2]"); //Click on amend Icon on SD grid
        SingleDeclerationAmendmentExportHelper.Click_FinancialInformationTab();// Click on Financial Information tab

        //Amendment in Financial Information Tab
        Initilization.ClearField("xpath","//input[@placeholder='Please select bank name']");
        Initilization.enter_Text("xpath","//input[@placeholder='Please select bank name']","Dubai Islamic Bank Pakistan Ltd");
        Initilization.waitUntilElementtoLoad(3);

        Initilization.ClearField("xpath","//input[@placeholder='Please select IBAN']");
        Initilization.enter_Text("xpath","//input[@placeholder='Please select IBAN']","PK30DUIB0000005293451918");
        Initilization.waitUntilElementtoLoad(3);

        Initilization.ClearField("xpath","//input[@placeholder='Please select Mode of Payment']");
        Initilization.enter_Text("xpath","//input[@placeholder='Please select Mode of Payment'","Open Account");
        Initilization.waitUntilElementtoLoad(3);

    }
}

