package AutomationFrameWork.TestCases.CarrierDeclaration;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import AutomationFrameWork.Helpers.CarrierDeclarationHelper;
import AutomationFrameWork.SetupFiles.Initilization;
import Locators.CarrierDeclarationLocators;
import Locators.SubscriptionLocators;

public class AirFrightCarrierDeclarationTestCases2 extends Initilization {
	@Parameters("browsers")
	@BeforeTest

	public static void BeforeTest(String BrowserName) {
		// Initialize Browser
		Initilization.BrowsersType = BrowserName;
		Initilization.URL = "http://test.weboc.gov.pk/";

	}

	@Test(description = "CarrierDeclaarationEndtoEnd", enabled = true, invocationCount = 40)
	public static void TC1() {
		// Data and Locators
		Initilization.OpenUrl(URL);

		String Serial = CarrierDeclarationHelper.randomBLNumber(7);
		// HomePage
		// Enter UserName
		Initilization.enter_Text("id", CarrierDeclarationLocators.login, "pia");
		// Enter Password
		Initilization.enter_Text("id", CarrierDeclarationLocators.password, "123456");
		// Click LoginButton
		Initilization.click_On_Button("id", CarrierDeclarationLocators.loginBtn);
		Initilization.WebDriverWait(4);

		// Click on Vessel Registration Button
		Initilization.click_On_Button("id", CarrierDeclarationLocators.FlightRegistration);
		// Enter Vessel Number
		Initilization.WebDriverWait(4);
		Initilization.enter_Text("id", CarrierDeclarationLocators.CompleteNumber, "KPAF-0019-01022022");
		// Click on Search Result
		Initilization.click_On_Button("xpath", CarrierDeclarationLocators.GDSearchCtrl);
		Initilization.WebDriverWait(4);

		// Click on First Result MainFest
		Initilization.click_On_Button("id", CarrierDeclarationLocators.AddMnfstAF);
		Initilization.WebDriverWait(4);
		// Click on Create Index Button
		Initilization.click_On_Button("name", CarrierDeclarationLocators.btnCreateAF);
		Initilization.WebDriverWait(4);

		// Random BL Number
		String blNum = "AWBL-" + CarrierDeclarationHelper.randomBLAlphaNumber(10);

		// Enter BL Number
		Initilization.enter_Text("id", CarrierDeclarationLocators.BlNoAF, blNum);
		// Enter BL Date
		Initilization.click_On_Button("id", CarrierDeclarationLocators.DateAF);
		//
		Initilization.WebDriverWait(4);
		Initilization.click_On_Button("id", CarrierDeclarationLocators.todayDateAF);
		Initilization.WebDriverWait(4);

		//
		Initilization.click_On_RadioButton("id", CarrierDeclarationLocators.IndexTypeAF);
		Initilization.WebDriverWait(4);

		// Select Index Type
		Initilization.dropDown("id", CarrierDeclarationLocators.IndexTypeAF, "1");
		Initilization.WebDriverWait(4);
		// Enter Importer Name
		Initilization.enter_Text("id", CarrierDeclarationLocators.ImporterNameAF, "Maaz");
		Initilization.WebDriverWait(4);
		// Enter Importer Address
		Initilization.enter_Text("id", CarrierDeclarationLocators.ImporterAddressAF, "PavillionEndClub");
		Initilization.WebDriverWait(4);
		// Select Importer Country
		Initilization.dropDown("id", CarrierDeclarationLocators.importerCountryAF, "586");
		Initilization.WebDriverWait(4);
		// Enter Importer City
		Initilization.dropDown("id", CarrierDeclarationLocators.ImporterCityAF, "23");
		Initilization.WebDriverWait(4);
		// Enter Consignor Name
		Initilization.enter_Text("id", CarrierDeclarationLocators.ConsignorNameAF, "Maaz");
		Initilization.WebDriverWait(4);
		// Enter Consignor Address
		Initilization.enter_Text("id", CarrierDeclarationLocators.ConsignorAddressAF, "Maaz");
		// Enter Consignor Country
		Initilization.dropDown("id", CarrierDeclarationLocators.ConsignorCountryAF, "156");
		Initilization.WebDriverWait(2);
		// Enter Port of Shippment
		Initilization.dropDown("id", CarrierDeclarationLocators.PortofShippmentAF, "221");
		// Enter Destination port Code
		Initilization.WebDriverWait(1);
		Initilization.dropDown("id", CarrierDeclarationLocators.DestinationportCodeAF, "23");
		Initilization.WebDriverWait(3);

		// Enter Port Of Load
		Initilization.enter_Text("id", CarrierDeclarationLocators.GrossWeightAF, "100");
		Initilization.WebDriverWait(1);
		Initilization.enter_Text("id", CarrierDeclarationLocators.NetWeightAF, "100");
		Initilization.WebDriverWait(1);
		Initilization.enter_Text("id", CarrierDeclarationLocators.FrightAF, "1");
		Initilization.WebDriverWait(1);
		Initilization.dropDown("id", CarrierDeclarationLocators.FrightCruencyAF, "36");
		Initilization.WebDriverWait(1);
		Initilization.enter_Text("id", CarrierDeclarationLocators.DecelerCustomsAF, "1");
		Initilization.WebDriverWait(1);
		Initilization.dropDown("id", CarrierDeclarationLocators.CustomeValueCurrencyAF, "36");
		Initilization.WebDriverWait(1);
		Initilization.dropDown("id", CarrierDeclarationLocators.ViaPortAF, "35");
		Initilization.WebDriverWait(1);

		Initilization.click_On_Button("id", CarrierDeclarationLocators.saveAF);
		Initilization.WebDriverWait(5);

		Initilization.click_On_Button("id", CarrierDeclarationLocators.AddItemsAF);
		Initilization.WebDriverWait(8);

		Initilization.enter_Text("id", CarrierDeclarationLocators.HSCodeAF, "9301.10");

		Initilization.enter_Text("id", CarrierDeclarationLocators.HscodeDescripitionAF, "9301.10");
		Initilization.WebDriverWait(3);
		Initilization.dropDown("id", CarrierDeclarationLocators.ModOfPackingAF, "40");
		Initilization.WebDriverWait(4);

		Initilization.enter_Text("id", CarrierDeclarationLocators.QuantityAF, "44");

		Initilization.WebDriverWait(2);

		Initilization.enter_Text("id", CarrierDeclarationLocators.NoOfPackagesAF, "10");
		Initilization.WebDriverWait(4);
		Initilization.click_On_Button("id", CarrierDeclarationLocators.saveITAF);
		Initilization.WebDriverWait(5);

		// Enter Importer Address
		Initilization.click_On_Button("id", CarrierDeclarationLocators.SubmitAF);

		Initilization.WebDriverWait(10);
		// Initilization.DriverClose();
		// return blNum;

	}

}
