package AutomationFrameWork.Helpers;

import org.testng.util.RetryAnalyzerCount;

import com.fasterxml.jackson.databind.ser.std.SqlTimeSerializer;

import AutomationFrameWork.SetupFiles.Initilization;
import Locators.DPPExportCertificateLocators;

public class DPPExportCertificateHelper extends Initilization {


    public static String GetAssignDPPOfficerUserName(String sdNumber)
    {
        String Query = "DECLARE @id nvarchar(20)"
		+"select @id=id from OGA.dbo.ExportCertificate where SDDocumentNumber = '"+sdNumber+"'"+
		"USE WFE;"
		+"Declare @processId uniqueidentifier;"+
		"set @processId = (SELECT ProcessId FROM [WorkflowProcessInstancePersistence] WHERE ParameterName = 'ExportCertificateIDSubmitted' AND Value = @id);"+
		"SELECT Top 1 [Value] FROM [dbo].[WorkflowProcessInstancePersistence] WHERE ProcessId = @processId and [Value] Like '%DPP%' ORDER BY CreatedOn DESC";
		String DPPUser = Initilization.CustomeDatabaseQueries(Query, "Value");

        return DPPUser;
		

    }
    public static String   GetExportCertificateNumber(String sdNumber)
    {
        String Query = "select RequestDocumentNumber from OGA.dbo.ExportCertificate where SDDocumentNumber = '"+sdNumber+"'";
		String exportCertificate = Initilization.CustomeDatabaseQueries(Query, "RequestDocumentNumber");

        return exportCertificate;
		
        
    }
    public static String ExportCertificateApprovalViaEC() {
		//String ntn = "3612536";
		//String userName = "DPP-00-" + ntn;
		String password = "Test@1234";
	//	DPPExportCertificateLocators dppLocators = new DPPExportCertificateLocators();


		Initilization.OpenUrl(Initilization.URL);
		//SingleDeclerationExportTestCases sd = new SingleDeclerationExportTestCases();
		String SDNumber = SingleDeclearationHelper.fileOGASingleDeclarationWithOpenAccount();
		Initilization.WebDriverWait(10);
		Initilization.logout();
		
		//DPPExportCertificateHelper.GetAssignDPPOfficerUserName(SDNumber);
		String DPPUser = DPPExportCertificateHelper.GetAssignDPPOfficerUserName(SDNumber);
		
		System.out.println(DPPUser);
		//Initilization.logout();
		Initilization.WebDriverWait(3);
		
		Initilization.Login(DPPUser, password);
	
		// HomePage
		Initilization.waitUntilElementtoLoad(12);
		// This Line will Click on Subscriber Button
		//Initilization.Login(userName, password);
		Initilization.waitUntilElementtoLoad(6);
		//selectUserDropDown
		Initilization.click_On_Button("xpath", DPPExportCertificateLocators.selectUserDropDown);
		Initilization.waitUntilElementtoLoad(6);
		//selectEC
		Initilization.click_On_Button("xpath", DPPExportCertificateLocators.selectEC);
		Initilization.waitUntilElementtoLoad(6);

		
		String exportCertificate = DPPExportCertificateHelper.GetExportCertificateNumber(SDNumber);
		
		
		//Check if the user is Role is OF
		//Switch to this Role  
		//dppLocators.LPCOMenu
		Initilization.click_On_Button("xpath", DPPExportCertificateLocators.LPCOMenu);
		Initilization.waitUntilElementtoLoad(30);
		//dppLocators.exportCertificateMenu
		Initilization.click_On_Button("xpath", DPPExportCertificateLocators.exportCertificateMenu);
		//dppLocators.exportCertificateSearchBox
		Initilization.enter_Text("id",DPPExportCertificateLocators.exportCertificateSearchBox, exportCertificate);
		//dppLocators.exportCertificateGRID
		Initilization.click_On_Button("xpath", "//td[normalize-space()='"+exportCertificate+"']");		
		Initilization.scrollDown();	
		Initilization.WebDriverWait(3);
		//dppLocators.commodityInformationItem	
		Initilization.click_On_Button( "xpath", DPPExportCertificateLocators.commodityInformationItem);
		//dppLocators.commodityInformationItemRemarks
		Initilization.enter_Text("xpath", DPPExportCertificateLocators.commodityInformationItemRemarks, "Done");
		Initilization.waitUntilElementtoLoad(5);
		//dppLocators.commodityInformationItemApproveButton
		Initilization.click_On_Button("xpath", DPPExportCertificateLocators.commodityInformationItemApproveButton);
		Initilization.waitUntilElementtoLoad(5);
		//dppLocators.commodityInformationItemApprovalModalYes
		Initilization.click_On_Button("xpath", DPPExportCertificateLocators.commodityInformationItemApprovalModalYes);
		Initilization.waitUntilElementtoLoad(5);
		//dppLocators.commodityInformationItemApprovalConfirmationModalOK
		Initilization.click_On_Button("xpath", DPPExportCertificateLocators.commodityInformationItemApprovalConfirmationModalOK);
		Initilization.waitUntilElementtoLoad(5);
		//dppLocators.exportCertificateOfficeRemarks
		Initilization.enter_Text("xpath", DPPExportCertificateLocators.exportCertificateOfficeRemarks, "Done");
		Initilization.waitUntilElementtoLoad(5);
		//dppLocators.exportCertificateApproveButton
		Initilization.click_On_Button("xpath", DPPExportCertificateLocators.exportCertificateApproveButton);		
		Initilization.WebDriverWait(5);
		//dppLocators.exportCertificateApprovalModalYes
		Initilization.click_On_Button("xpath", DPPExportCertificateLocators.exportCertificateApprovalModalYes);
		Initilization.waitUntilElementtoLoad(5);
		//dppLocators.exportCertificateApprovalConfirmationModalOK
		Initilization.click_On_Button("xpath", DPPExportCertificateLocators.exportCertificateApprovalConfirmationModalOK);

		return SDNumber;

	}

    
}
