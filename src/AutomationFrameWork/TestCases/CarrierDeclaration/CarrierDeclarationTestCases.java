package AutomationFrameWork.TestCases.CarrierDeclaration;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import AutomationFrameWork.Helpers.CarrierDeclarationHelper;
import AutomationFrameWork.SetupFiles.Initilization;
import Locators.CarrierDeclarationLocators;
import Locators.SubscriptionLocators;


public class CarrierDeclarationTestCases extends Initilization {
	@Parameters("browsers")
	@BeforeTest

	public static void BeforeTest(String BrowserName) {
		// Initialize Browser
		Initilization.BrowsersType = BrowserName;
		Initilization.URL = "https://test.weboc.gov.pk/";
		

	}

	

	@Test(description = "CarrierDeclaarationEndtoEnd", enabled = true  ,invocationCount = 30 )
	public static void TC1() {
		// Data and Locators

		String Serial = CarrierDeclarationHelper.randomBLNumber(7);
		// HomePage
		// Enter UserName
		Initilization.enter_Text("id", CarrierDeclarationLocators.login, "shp_apl");
		// Enter Password
		Initilization.enter_Text("id", CarrierDeclarationLocators.password, "123456");
		// Click LoginButton
		Initilization.click_On_Button("id", CarrierDeclarationLocators.loginBtn);
		Initilization.WebDriverWait(4);
		
		// Click on Vessel Registration Button
		Initilization.click_On_Button("xpath", CarrierDeclarationLocators.VesselRegistration);
		// Enter Vessel Number 
		Initilization.enter_Text("id", CarrierDeclarationLocators.CompleteNumber, " KPPI-0449-13102022");
		// Click on Search Result
		Initilization.click_On_Button("xpath", CarrierDeclarationLocators.GDSearchCtrl);
		Initilization.WebDriverWait(4);

		// Click on First Result MainFest
		Initilization.click_On_Button("xpath",
				CarrierDeclarationLocators.lnkAddMnfst);
		Initilization.WebDriverWait(4);
		// Click on Create Index Button
		Initilization.click_On_Button("id", CarrierDeclarationLocators.btnCreate);
		Initilization.WebDriverWait(4);

		// Random BL Number
		String blNum = "BL-"+CarrierDeclarationHelper.randomBLAlphaNumber(10);

		// Enter BL Number
		Initilization.enter_Text("id", CarrierDeclarationLocators.BlNo, blNum);
		// Enter BL Date
		Initilization.click_On_Button("id", CarrierDeclarationLocators.Date);
		//
		Initilization.WebDriverWait(4);
		Initilization.click_On_Button("id", CarrierDeclarationLocators.todayDate);
		Initilization.WebDriverWait(4);

		// Enter BL Type
		Initilization.click_On_RadioButton("id", CarrierDeclarationLocators.BlType);
		Initilization.WebDriverWait(4);
		Initilization.click_On_RadioButton("id", CarrierDeclarationLocators.IndexType);
		Initilization.WebDriverWait(4);
		
		// Select Index Type
		Initilization.dropDown("id",CarrierDeclarationLocators.IndexType, "1");
		Initilization.WebDriverWait(4);
		// Enter Importer Name
		Initilization.enter_Text("id",CarrierDeclarationLocators.ImporterName, "Maaz");
		Initilization.WebDriverWait(4);
		// Enter Importer Address
		Initilization.enter_Text("id", CarrierDeclarationLocators.ImporterAddress,
				"PavillionEndClub");
		Initilization.WebDriverWait(4);
		// Select Importer Country
		Initilization.dropDown("id", CarrierDeclarationLocators.importerCountry, "586");
		Initilization.WebDriverWait(4);
		// Enter Importer City
		Initilization.dropDown("id", CarrierDeclarationLocators.ImporterCity, "24451");
		Initilization.WebDriverWait(4);
		// Enter Consignor Name
		Initilization.enter_Text("id", CarrierDeclarationLocators.ConsignorName, "Maaz");
		Initilization.WebDriverWait(4);
		// Enter Consignor Address
		Initilization.enter_Text("id", CarrierDeclarationLocators.ConsignorAddress, "Maaz");
		// Enter Consignor Country
		Initilization.dropDown("id", CarrierDeclarationLocators.ConsignorCountry, "8");
		// Enter Port of Shippment
		Initilization.enter_Text("id", CarrierDeclarationLocators.PortofShippment, "Karachi  (KHI)");
		// Enter Destination port Code
		Initilization.WebDriverWait(1);
		Initilization.dropDown("id", CarrierDeclarationLocators.DestinationportCode, "24440");
		Initilization.WebDriverWait(3);

		// Enter Port Of Load
		Initilization.enter_Text("id", CarrierDeclarationLocators.PortOfLoad, "Karachi  (KHI)");
		Initilization.WebDriverWait(4);
		// Enter Vessel Index
		Initilization.click_On_RadioButton("id", CarrierDeclarationLocators.VesselIndex);
		Initilization.WebDriverWait(4);
		// Enter Berth Location
		Initilization.dropDown("id", CarrierDeclarationLocators.BerthLocation, "1");
		Initilization.WebDriverWait(4);
		// Enter Vessel Index
		Initilization.click_On_RadioButton("id", CarrierDeclarationLocators.VesselIndex2);
		Initilization.WebDriverWait(4);
		// Enter Gross Weight
		Initilization.enter_Text("id", CarrierDeclarationLocators.GrossWeight, "33");
		Initilization.WebDriverWait(4);
		// Enter Net Weight
		Initilization.enter_Text("id", CarrierDeclarationLocators.NetWeight, "33");
		Initilization.WebDriverWait(4);
		// Enter Marks
		Initilization.enter_Text("id", CarrierDeclarationLocators.Marks, "Test 1245");
		Initilization.WebDriverWait(4);
		// Enter Save Button
		Initilization.click_On_Button("id", CarrierDeclarationLocators.btnSave);
		// Waiting
		Initilization.WebDriverWait(5);

		Initilization.click_On_Button("id", CarrierDeclarationLocators.lnkItems);
		Initilization.WebDriverWait(8);

		Initilization.enter_Text("id", CarrierDeclarationLocators.HsCode, "9301.10");

		Initilization.enter_Text("id", CarrierDeclarationLocators.HscodeDescripition, "9301.10");
		Initilization.WebDriverWait(3);
		Initilization.dropDown("id", CarrierDeclarationLocators.ModOfPacking, "40");
		Initilization.WebDriverWait(4);

		Initilization.enter_Text("id", CarrierDeclarationLocators.Quantity, "44");

		Initilization.click_On_Button("xpath", CarrierDeclarationLocators.Add);

		Initilization.WebDriverWait(4);

		Initilization.enter_Text("id", CarrierDeclarationLocators.Container,
				"APLU" + Serial);

		Initilization.enter_Text("id",
				CarrierDeclarationLocators.NoOfPackages, "10");
		Initilization.WebDriverWait(4);
		Initilization.click_On_Button("xpath", CarrierDeclarationLocators.SavebTn);

		Initilization.click_On_Button("id", CarrierDeclarationLocators.VesselIndexItem_btnSave);
		Initilization.WebDriverWait(4);
		Initilization.click_On_Button("id",CarrierDeclarationLocators.VesselIndexItem_btbBack);
		Initilization.WebDriverWait(6);

		Initilization.click_On_Button("xpath", CarrierDeclarationLocators.AddContainers);
		Initilization.WebDriverWait(4);
		Initilization.dropDown("id", CarrierDeclarationLocators.ISOCode, "1");

		Initilization.enter_Text("id", CarrierDeclarationLocators.ContainerNumber,
				"APLU" + Serial);

		Initilization.enter_Text("id", CarrierDeclarationLocators.sealNumber, "1244");

		Initilization.enter_Text("id", CarrierDeclarationLocators.grossWeight, "1000");

		Initilization.enter_Text("id", CarrierDeclarationLocators.NetWeight2, "900");

		Initilization.enter_Text("id", CarrierDeclarationLocators.SCO, "N");

		Initilization.enter_Text("id", CarrierDeclarationLocators.OwnershipContainer_NTN,
				"1199000");

		Initilization.click_On_Button("id", CarrierDeclarationLocators.VesselContainers_btnSave);
		Initilization.WebDriverWait(3);
		Initilization.click_On_Button("id", CarrierDeclarationLocators.VesselContainers_btbBack);

		// Enter Importer Address
		Initilization.click_On_Button("id", CarrierDeclarationLocators.VesselIndex_btnSubmit);

		Initilization.WebDriverWait(10);
		// Initilization.DriverClose();
		//return blNum;
		

	}

	

}
