package AutomationFrameWork.TestCases.EForm;

import org.openqa.selenium.NoSuchWindowException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import AutomationFrameWork.SetupFiles.Initilization;
import Locators.CarrierDeclarationLocators;
import Locators.EFormLocators;
import Locators.GoodDecelerationLocators;

public class EForm extends Initilization {
	
	@Parameters("browsers")
	@BeforeTest

	public static void BeforeTest(String BrowserName) {
		// Initialize Browser
		Initilization.BrowsersType = BrowserName;
		Initilization.URL = "https://qa.psw.gov.pk/app/";

	}
	
	@Test(description = "EFormEndToEndFlow", enabled = true)

	public static void TC1() throws NoSuchWindowException {
		
		Initilization.OpenUrl(URL);
		Initilization.WebDriverWait(5);
		// Enter UserName
		Initilization.enter_Text("name", "userName", GoodDecelerationLocators.username);
		// Enter Password
		Initilization.enter_Text("name", "password", GoodDecelerationLocators.password);
		// Click LoginButton
		Initilization.click_On_Button("css", GoodDecelerationLocators.loginBtn);
		Initilization.WebDriverWait(10);

		Initilization.click_On_Button("xpath", EFormLocators.UsersupportSystemMenu);
		Initilization.WebDriverWait(5);
		Initilization.click_On_Button("xpath",EFormLocators.UsersupportSystemSubMenu);
		Initilization.WebDriverWait(4);
		driver.switchTo().frame("frame");
		Initilization.WebDriverWait(2);
		Initilization.enter_Text("id", EFormLocators.Option_List ,"File request for issuance of Form E");
		Initilization.click_On_Button("id", EFormLocators.SearchBtn);
		Initilization.WebDriverWait(2);
		Initilization.click_On_Button("id", EFormLocators.Process);
		Initilization.WebDriverWait(2);
		Initilization.click_On_Button("id", EFormLocators.NewFormERequest);
		Initilization.WebDriverWait(2);
		Initilization.dropDown("id", EFormLocators.BusinessName, "P-1282, WEST CANAL ROAD, ABDULLAHPUR, FAISALABAD, Faisalabad Madina Town");
		Initilization.WebDriverWait(2);
		Initilization.enter_Text("name", EFormLocators.ConsineeName, "Muhammad Maaz");
		Initilization.enter_Text("name", EFormLocators.ConsigneeAddress, "Pavillion End Club");
		Initilization.dropDown("id", EFormLocators.Country, "398");
		Initilization.WebDriverWait(2);
		Initilization.dropDown("id", EFormLocators.DischargePort, "43844");
		Initilization.WebDriverWait(2);
		Initilization.dropDown("id", EFormLocators.CurrencyMain, "36");
		Initilization.WebDriverWait(2);
		Initilization.dropDown("id", EFormLocators.Terms, "5");
		Initilization.click_On_Button("name", EFormLocators.TermsOfSale);
		Initilization.WebDriverWait(4);
		Initilization.click_On_CheckBox("id", EFormLocators.FormEDocumentInformation1Check);
		Initilization.WebDriverWait(1);
		Initilization.click_On_CheckBox("id", EFormLocators.FormEDocumentInformation2Check);
		Initilization.WebDriverWait(1);
		Initilization.click_On_CheckBox("id", EFormLocators.FormEDocumentInformation3Check);
		Initilization.WebDriverWait(1);
		Initilization.click_On_CheckBox("id", EFormLocators.FormEDocumentInformation4Check);
		Initilization.WebDriverWait(1);
		Initilization.enter_Text("name", EFormLocators.FormEDocumentInformation1Text, "10");
		Initilization.WebDriverWait(1);
		Initilization.enter_Text("name", EFormLocators.FormEDocumentInformation2Text, "10");
		Initilization.WebDriverWait(1);
		Initilization.enter_Text("name", EFormLocators.FormEDocumentInformation3Text, "10");
		Initilization.WebDriverWait(1);		
		Initilization.enter_Text("name", EFormLocators.FormEDocumentInformation4Text, "70");
		Initilization.WebDriverWait(2);
		Initilization.enter_Text("name", EFormLocators.FormEDocumentInformation5Text, "10");	
		Initilization.WebDriverWait(2);
		Initilization.click_On_Button("id", EFormLocators.SaveTerms);		
		Initilization.WebDriverWait(2);
		Initilization.enter_Text("name",EFormLocators.GoodsDescription,"GoodsDescription");	
		Initilization.WebDriverWait(2);
		Initilization.enter_Text("name", EFormLocators.Quantity, "10");	
		Initilization.WebDriverWait(2);
		Initilization.enter_Text("id", EFormLocators.InvoiceValue, "12");	
		Initilization.WebDriverWait(2);
		Initilization.dropDown("id", EFormLocators.UOM, "3");
		Initilization.WebDriverWait(2);
		Initilization.click_On_Button("id", EFormLocators.Add);
		Initilization.WebDriverWait(5);
		Initilization.dropDown("name", EFormLocators.Bank, "23");
		Initilization.WebDriverWait(2);
		Initilization.dropDown("name", EFormLocators.City, "4200");
		Initilization.WebDriverWait(2);
		Initilization.dropDown("name", EFormLocators.Branch, "1475");
		Initilization.WebDriverWait(1);
		Initilization.click_On_CheckBox("id", EFormLocators.TraderDisclaimerBeforeSaved);
		Initilization.WebDriverWait(1);
		Initilization.click_On_Button("name",EFormLocators.SaveBottom);
		Initilization.WebDriverWait(4);
		Initilization.click_On_CheckBox("id",EFormLocators.TraderDisclaimerAfterSaved);
		Initilization.WebDriverWait(2);
		Initilization.click_On_Button("id",EFormLocators.SubmitBottom);
		Initilization.WebDriverWait(2);		
		
		
		
		
		
		
		
		Initilization.OpenUrl("https://test.weboc.gov.pk/");
		Initilization.WebDriverWait(3);
		
		Initilization.enter_Text("id", CarrierDeclarationLocators.login, "BNK-6987454");
		// Enter Password
		Initilization.enter_Text("id", CarrierDeclarationLocators.password, "123456");
		// Click LoginButton
		Initilization.click_On_Button("id", CarrierDeclarationLocators.loginBtn);
		Initilization.WebDriverWait(4);
		Initilization.click_On_Button("id", EFormLocators.lnkItem);
		Initilization.WebDriverWait(4);		
		Initilization.click_On_Button("name", EFormLocators.Process1);
		Initilization.WebDriverWait(2);
		Initilization.enter_Text("name", EFormLocators.AreaBankRemarks, "Remarks");	
		Initilization.WebDriverWait(2);
		Initilization.click_On_CheckBox("id", EFormLocators.Declaration);
		Initilization.WebDriverWait(2);		
		Initilization.click_On_Button("name", EFormLocators.ApproveBottom);
		Initilization.BrowserAlert("yes");
		Initilization.WebDriverWait(2);		
		
		
		
	}

}
