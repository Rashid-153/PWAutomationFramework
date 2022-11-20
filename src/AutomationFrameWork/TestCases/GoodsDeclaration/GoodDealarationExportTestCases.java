package AutomationFrameWork.TestCases.GoodsDeclaration;

import java.awt.RenderingHints.Key;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchWindowException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import AutomationFrameWork.Helpers.CarrierDeclarationHelper;
import AutomationFrameWork.Helpers.GoodDecelerationHelper;
import AutomationFrameWork.SetupFiles.Initilization;
import AutomationFrameWork.TestCases.EForm.EForm;
import Locators.GoodDecelerationExportLocators;
import Locators.GoodDecelerationLocators;
import Locators.SubscriptionLocators;

public class GoodDealarationExportTestCases extends Initilization {

	@Parameters("browsers")
	@BeforeTest

	public static void BeforeTest(String BrowserName) {
		// Initialize Browser
		Initilization.BrowsersType = BrowserName;
		Initilization.URL = "https://qa.psw.gov.pk/app/";

	}

	@DataProvider(name = "GoodDecalarationData")
	public static Object[][] credentials() {
		// Sit Data
		return new Object[][] { { "0000298", "1730114351289", "3172094681", "maazmaaz97@gmail.com" } };
	}

	@Test(description = "GoodDeclarationExportEndtoEnd", enabled = false, dataProvider = "GoodDecalarationData" /*
																											 * ,invocationCount
																											 * = 10
																											 */ )

	public static void TC1(String NTN, String CNIC, String phoneNum, String email) throws NoSuchWindowException {

		
		// Open URL
		// Enter UserName
		Initilization.enter_Text("name", "userName", GoodDecelerationExportLocators.username);
		// Enter Password
		Initilization.enter_Text("name", "password", GoodDecelerationExportLocators.password);
		// Click LoginButton
		Initilization.click_On_Button("css", GoodDecelerationExportLocators.loginBtn);
		Initilization.WebDriverWait(5);

		Initilization.click_On_Button("xpath", GoodDecelerationExportLocators.goodDecelerationMenu);

		Initilization.WebDriverWait(10);
		driver.switchTo().frame("frame");
		Initilization.WebDriverWait(2);
		Initilization.click_On_Button("id", GoodDecelerationExportLocators.createNewGD);
		Initilization.WebDriverWait(2);
		Initilization.dropDown("id", GoodDecelerationExportLocators.consignmentCategory, "9");

		Initilization.WebDriverWait(2);
		Initilization.dropDown("id", GoodDecelerationExportLocators.declarationType, "45");

		Initilization.click_On_Button("id", GoodDecelerationExportLocators.GDSelectionCreate);

		Initilization.WebDriverWait(5);
		Initilization.dropDown("id", GoodDecelerationExportLocators.collectorate, "23");
		Initilization.WebDriverWait(4);
		
		Initilization.WebDriverWait(2);		
		Initilization.enter_Text("id", GoodDecelerationExportLocators.ConsignorName, "Muhammad Maaz");
		
		Initilization.WebDriverWait(2);		
		Initilization.enter_Text("id", GoodDecelerationExportLocators.ConsignorAddress, "Pavillion End Club");
		
		Initilization.WebDriverWait(2);		
		Initilization.dropDown("id", GoodDecelerationExportLocators.PortOfShipment, "23");
		
		Initilization.WebDriverWait(2);		
		Initilization.dropDown("id", GoodDecelerationExportLocators.DestinationCountry, "398");
		
		Initilization.WebDriverWait(2);		
		Initilization.dropDown("id", GoodDecelerationExportLocators.PortOfDischarge, "43844");

		Initilization.WebDriverWait(2);		
		Initilization.enter_Text("id", GoodDecelerationExportLocators.PlaceofDelivery, "Karachi");
		
		Initilization.WebDriverWait(2);		
		Initilization.dropDown("id", GoodDecelerationExportLocators.AirLine, "1");

		
		Initilization.WebDriverWait(2);		
		Initilization.enter_Text("id", GoodDecelerationExportLocators.GrossWeight, "11");
		
		Initilization.WebDriverWait(2);		
		Initilization.enter_Text("id", GoodDecelerationExportLocators.NetWeight, "1");
		
		
		Initilization.WebDriverWait(2);		
		Initilization.enter_Text("id", GoodDecelerationExportLocators.Marks, "Mark");
		
		Initilization.WebDriverWait(2);		
		Initilization.enter_Text("id", GoodDecelerationExportLocators.GeneralDescription, "General Description of Good");
		
		Initilization.WebDriverWait(2);		
		Initilization.click_On_Button("id", GoodDecelerationExportLocators.Add);
		
		Initilization.WebDriverWait(4);		
		Initilization.enter_Text("id", GoodDecelerationExportLocators.Quantity, "1");
		
		Initilization.WebDriverWait(1);		
		Initilization.click_On_Button("id", GoodDecelerationExportLocators.Add);
		
		Initilization.WebDriverWait(2);		
		Initilization.dropDown("id", GoodDecelerationExportLocators.PaymentTerms, "34");

		Initilization.WebDriverWait(4);		
		Initilization.enter_Text("id", GoodDecelerationExportLocators.LcNo, "12121");
		
		Initilization.WebDriverWait(1);		
		Initilization.click_On_Button("id", GoodDecelerationExportLocators.Calendar);
		
		Initilization.WebDriverWait(1);		
		Initilization.click_On_Button("id", GoodDecelerationExportLocators.todayDate);
		
		Initilization.WebDriverWait(2);		
		Initilization.dropDown("id",  GoodDecelerationExportLocators.DeliveryTerm, "5");

		Initilization.WebDriverWait(2);		
		Initilization.dropDown("id",  GoodDecelerationExportLocators.Currency, "36");
		
		Initilization.WebDriverWait(4);		
		Initilization.enter_Text("name",  GoodDecelerationExportLocators.FobValue, "1");
		
		
		Initilization.WebDriverWait(4);		
		Initilization.dropDown("id", GoodDecelerationExportLocators.ExaminerGroup , "13");
		
		Initilization.WebDriverWait(4);		
		Initilization.enter_Text("name",  GoodDecelerationExportLocators.Freight, "9");
		
		Initilization.WebDriverWait(1);		
		Initilization.click_On_Button("name", GoodDecelerationExportLocators.SaveButtom);
	
		
		Initilization.WebDriverWait(1);		
		Initilization.click_On_Button("name",GoodDecelerationExportLocators.AddFormE);
	
		String parent = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		// Now iterate using Iterator
		Iterator<String> iterator = allWindowHandles.iterator();

		while (iterator.hasNext()) {
			String child_window = iterator.next();

			try {
				System.out.println("1");
				if (!parent.equalsIgnoreCase(child_window)) {
					driver.switchTo().window(child_window);
					Initilization.WebDriverWait(3);
					Initilization.click_On_CheckBox("xpath", GoodDecelerationExportLocators.selectEform);
					Initilization.WebDriverWait(3);
					Initilization.click_On_Button("id", GoodDecelerationExportLocators.attachBtn);

				}
			}

			catch (Exception e) {

				

			}
		}
		
		
		
		// switch to the parent window
		Initilization.WebDriverWait(3);
		driver.switchTo().window(parent);

		
		driver.switchTo().frame("frame");
		Initilization.WebDriverWait(2);
		
		
		Initilization.WebDriverWait(3);		
		Initilization.click_On_Button("id",GoodDecelerationExportLocators.lnkItems);
	
		
		Initilization.WebDriverWait(4);		
		Initilization.enter_Text("id", GoodDecelerationExportLocators.HsCode, "8501.1000");
		
		Initilization.WebDriverWait(4);		
		Initilization.click_On_CheckBox("name", GoodDecelerationExportLocators.DeclaredDescription);
		
		
		Initilization.WebDriverWait(4);		
		Initilization.enter_Text("name", GoodDecelerationExportLocators.DeclaredDescription, "Declared Description");
		
		Initilization.WebDriverWait(2);		
		Initilization.enter_Text("xpath", GoodDecelerationExportLocators.txtQuantity, "10");
		
		Initilization.WebDriverWait(2);		
		Initilization.enter_Text("xpath", GoodDecelerationExportLocators.Quantity_Statistical_Purpose, "10");
		
		
		Initilization.WebDriverWait(2);		
		Initilization.click_On_Button("xpath",GoodDecelerationExportLocators.UnitValue);
		
		Initilization.WebDriverWait(2);		
		Initilization.enter_Text("xpath", GoodDecelerationExportLocators.UnitValue, "1");
	
		Initilization.WebDriverWait(2);		
		Initilization.dropDown("name", GoodDecelerationExportLocators.WeightUnit, "7");
		
		Initilization.WebDriverWait(3);		
		Initilization.click_On_Button("name",GoodDecelerationExportLocators.SaveButtom);
	
		Initilization.WebDriverWait(3);		
		Initilization.click_On_Button("id",GoodDecelerationExportLocators.UploadDocument);
	
		Initilization.WebDriverWait(4);		
		Initilization.dropDown("name",GoodDecelerationExportLocators.DocumentType, "10");
		
		
		Initilization.WebDriverWait(2);		
		Initilization.enter_Text("name", GoodDecelerationExportLocators.DocUpload, projectDirectory+"\\Resources\\Application on DPP Prescribed Form 20.pdf");
	
		Initilization.WebDriverWait(3);		
		Initilization.click_On_Button("name",GoodDecelerationExportLocators.Upload);
	
		
		Initilization.WebDriverWait(3);		
		Initilization.click_On_Button("id",GoodDecelerationExportLocators.UploadDocument);
	
		Initilization.WebDriverWait(4);		
		Initilization.dropDown("name", GoodDecelerationExportLocators.DocumentType, "14");
		
		
		Initilization.WebDriverWait(2);		
		Initilization.enter_Text("name", GoodDecelerationExportLocators.DocUpload, projectDirectory+"\\Resources\\Application on DPP Prescribed Form 20.pdf");
	
		Initilization.WebDriverWait(3);		
		Initilization.click_On_Button("name", GoodDecelerationExportLocators.Upload);
	
		Initilization.WebDriverWait(3);		
		Initilization.click_On_Button("id",GoodDecelerationExportLocators.ExportPolicy);
	
		Initilization.WebDriverWait(1);		
		Initilization.click_On_Button("id",GoodDecelerationExportLocators.Disclaimer);
	
		
		Initilization.WebDriverWait(1);		
		Initilization.click_On_Button("name", GoodDecelerationExportLocators.SaveButtom);
	
		
		Initilization.WebDriverWait(3);		
		Initilization.click_On_Button("name", GoodDecelerationExportLocators.SubmitBottom);
	
		
	}
	@Test(description = "GoodDeclarationExportEndtoEndWithEform", enabled = true, dataProvider = "GoodDecalarationData" 
			  )

public static void TC2(String NTN, String CNIC, String phoneNum, String email) throws NoSuchWindowException {
		
		EForm.TC1();
		Initilization.OpenUrl(URL);		
		GoodDecelerationHelper.GoodDeceleration();

	}
}
