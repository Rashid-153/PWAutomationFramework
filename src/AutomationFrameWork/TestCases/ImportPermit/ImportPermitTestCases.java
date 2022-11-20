package AutomationFrameWork.TestCases.ImportPermit;

import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import AutomationFrameWork.Helpers.ImportPermitHelper;
import AutomationFrameWork.SetupFiles.Initilization;
import Locators.ImportPermitLocators;

public class ImportPermitTestCases extends Initilization {

	@Parameters("browsers")
	@BeforeTest

	public static void BeforeTest(String BrowserName) {
		// Initialize Browser
		Initilization.BrowsersType = BrowserName;
		Initilization.URL = "https://qa.psw.gov.pk/app/";

	}

	@DataProvider(name = "ImportPermit")
	public static Object[][] credentials() {
		// Sit Data
		return new Object[][] { { "0000298", "1730114351289", "3172094681", "maazmaaz97@gmail.com" } };
	}

	@Test(description = "ImportPermitTraderEnd2End", enabled = false /* , invocationCount = 10 */)

	public static void TC1() {

		ImportPermitHelper.CreateImportPermit();

	}

	@Test(description = "ImportPermit", enabled = false /* , invocationCount = 10 */)

	public static void TC2() {
	}

	@Test(description = "CreateImportPermit_AssigntoOfficer_CallDocumentRequest_CallDocumentRequestApproveal_SubmissionOfCallDocument"
			+ "_ApprovalofImportPermit", enabled = true)

	public static void TC3() {

		ImportPermitHelper.CreateImportPermit();
		ImportPermitHelper.Login("Shahzad", "shariq");

		ImportPermitHelper.gotoImportPermitPage();
		ImportPermitHelper.SearchImportPermitformStatus("Assigned to Officer");
		
		Initilization.click_On_Button("xpath", "//tr[@class='k-master-row']");

		Initilization.WebDriverWait(2);
		ImportPermitHelper.CallDocument();
		Initilization.WebDriverWait(2);
		ImportPermitHelper.logout();

		ImportPermitHelper.Login("Samar", "shariq");

		ImportPermitHelper.gotoImportPermitPage();
		ImportPermitHelper.SearchImportPermitformStatus("approval for call document");

		Initilization.click_On_Button("xpath", "//button[@class='k-button k-flat']");
		Initilization.WebDriverWait(2);

		Initilization.enter_Text("css", "div:nth-child(5)>span:nth-child(3)>textarea:nth-child(1)", "Done");
		ImportPermitHelper.ApproveCallDocumentRequest();
		ImportPermitHelper.logout();

		Initilization.WebDriverWait(2);
		ImportPermitHelper.Login("UN-00-0000297", "Test@123");

		Initilization.click_On_Button("xpath", ImportPermitLocators.importPermitTab);
		Initilization.WebDriverWait(8);
		
		ImportPermitHelper.SearchImportPermitformStatus("Documents Called");
		Initilization.click_On_Button("xpath", "//button[@class='k-button k-flat']");
		Initilization.WebDriverWait(2);

		ImportPermitHelper.documentUpload("Affidavit");
		ImportPermitHelper.documentUpload("Indentification");
		ImportPermitHelper.documentUpload("Lease");
		ImportPermitHelper.documentUpload("Noc");
		Initilization.WebDriverWait(2);
		Initilization.enter_Text("xpath", "//textarea[@tabindex='0']", "Done");

		Initilization.click_On_Button("xpath", "//button[normalize-space()='Submit']");

		ImportPermitHelper.UploadDocumentSubmit();

		ImportPermitHelper.logout();

		Initilization.WebDriverWait(2);

		ImportPermitHelper.Login("Shahzad", "shariq");
		ImportPermitHelper.gotoImportPermitPage();
		ImportPermitHelper.SearchImportPermitformStatus("Documents Submitted");
		Initilization.click_On_Button("xpath", "//tr[@class='k-master-row']");
		Initilization.WebDriverWait(2);
		ImportPermitHelper.ApproveImportPermit();
		ImportPermitHelper.logout();

	}

}
