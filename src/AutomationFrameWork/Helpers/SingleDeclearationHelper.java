package AutomationFrameWork.Helpers;
import java.io.File;
import java.security.Key;

import Locators.TraderRegistrationLocators;
import io.restassured.RestAssured;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import AutomationFrameWork.SetupFiles.Initilization;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.annotation.Nullable;

import static org.testng.Assert.*;


public class SingleDeclearationHelper extends Initilization {

	//SingleDeclearationConstants constant = new SingleDeclearationConstants();

	public static int totalQuantity = 0;

	public static void OpenMenu() {
		Initilization.waitUntilElementtoLoad(30);
		//openMenu_SingleDeclaration_Btn
		Initilization.click_On_Button("xpath", "//p[normalize-space()='Single Declaration']");

	}

	///
	/// PAGES OF THE SIGNLE DELERATION
	///

	public static void CreateDeclearation() {
		Initilization.WebDriverWait(10);
		Initilization.waitUntilElementtoLoad(10);
		//createDeclearation_Export_Btn
		Initilization.click_On_Button("xpath", "//p[normalize-space()='Export']");
		Initilization.WebDriverWait(2);

	}

	public static void TransactionType(String ntn, String consignmentCategory, String declarationType) {
		SelectNTNWindow();
		//ntn_txt
//		Initilization.enter_Text("id", "ntn-text-box", ntn);
//		Initilization.WebDriverWait(7);
		//
		Initilization.click_On_Button("xpath", "//tr[@class='k-master-row']");
		Initilization.WebDriverWait(2);
		Initilization.enter_Text("xpath", "//input[@placeholder='Select consignment category']",
				consignmentCategory + Keys.ENTER);
		Initilization.enter_Text("xpath", "//input[@placeholder='Select declaration type']",
				declarationType + Keys.ENTER);


	}


	public static void ConsignmentInformation(String collectorate, String consignment, String shed, String terminal, String consignorName, String consignorAddress) {

		Initilization.WebDriverWait(4);
		Initilization.enter_Text("xpath", "//input[@placeholder='Please select collectorate']",
				collectorate + Keys.ENTER);
		Initilization.WebDriverWait(3);
		Initilization.ClearField("xpath", "//input[@placeholder='Please select mode of consignment']");
		Initilization.enter_Text("xpath", "//input[@placeholder='Select consignor name']",
				consignorName + Keys.ENTER);
		Initilization.enter_Text("xpath", "//input[@placeholder='Select consignor address']",
				consignorAddress + Keys.ENTER);
		Initilization.enter_Text("xpath", "//input[@placeholder='Please select mode of consignment']",
				consignment + Keys.ENTER);
		Initilization.waitUntilElementtoLoad(40);
		Initilization.enter_Text("xpath", "//input[@placeholder='Please enter consignee name']",
				"Doe John" + Keys.ENTER);
		Initilization.enter_Text("xpath", "//input[@placeholder='Please enter consignee address']",
				"PLOT # 407 INDUSTRIAL AREA" + Keys.ENTER);

		Initilization.enter_Text("xpath", "//input[@placeholder='Please select port of shipment']",
				"Port Qasim (exports), karachi" + Keys.ENTER);
		Initilization.enter_Text("xpath", "//input[@placeholder='Please select destination country']",
				"China" + Keys.ENTER);
		Initilization.waitUntilElementtoLoad(10);
		Initilization.click_On_Button("xpath", "//input[@placeholder='Please select port of discharge']");
		// Initilization.enter_Text("xpath", "//input[@placeholder='Please select port of discharge']",
		// 		"AIN - Huaiyin");
		Initilization.enter_Text("xpath", "//input[@placeholder='Please select port of discharge']", "" +
				Keys.ARROW_DOWN);
		Initilization.waitUntilElementtoLoad(2);
		Initilization.enter_Text("xpath", "//input[@placeholder='Please select port of discharge']", "" +
				Keys.ENTER);

		Initilization.enter_Text("xpath", "//input[@placeholder='Please enter place of delivery']",
				"Huaiyin Port" + Keys.ENTER);
		Initilization.enter_Text("xpath", "//input[@placeholder='Please select shipping / air line']",
				"CHINA SHIPPING CONTAINER LINE CO." + Keys.ENTER);
		Initilization.SelectAllText("xpath", "//input[@placeholder='Please enter gross weight']");
		Initilization.enter_Text("xpath", "//input[@placeholder='Please enter gross weight']", "120" + Keys.ENTER);
		Initilization.SelectAllText("xpath", "//input[@placeholder='Please enter net weight']");
		Initilization.enter_Text("xpath", "//input[@placeholder='Please enter net weight']", "120" + Keys.ENTER);
		Initilization.enter_Text("xpath", "//input[@placeholder='Please enter marks']", "Marks" + Keys.ENTER);
		Initilization.enter_Text("xpath", "//input[@placeholder='Please select shed / location']",
				shed + Keys.ENTER);
		Initilization.enter_Text("xpath", "//input[@placeholder='Please select terminal']",
				terminal + Keys.ENTER);

	}

	public static void FinancialInformation(String currency, String FI, String deliveryTerm, String bank, String iban, String modeofPayment) {
		Initilization.enter_Text("xpath", "//input[@placeholder='Please select currency']",
				currency + Keys.ENTER);
		Initilization.waitUntilElementtoLoad(3);
		Initilization.enter_Text("xpath", "//input[@placeholder='Select Delivery Term']",
				deliveryTerm + Keys.ENTER);
		Initilization.waitUntilElementtoLoad(30);
		Initilization.enter_Text("xpath", "//input[@placeholder='Please select bank name']",
				bank + Keys.ENTER);
		Initilization.waitUntilElementtoLoad(30);
		Initilization.enter_Text("xpath", "//input[@placeholder='Please select IBAN']",
				iban + Keys.ENTER);
		Initilization.waitUntilElementtoLoad(10);
		Initilization.enter_Text("xpath", "//input[@placeholder='Please select Mode of Payment']",
				modeofPayment + Keys.ENTER);

		if (modeofPayment != SingleDeclearationConstants.ModeofPayment.OpenAccount.toString()) {
			FinancialInstrumentWindow(FI);
		} else {
			AddButton();

		}
		if (deliveryTerm == SingleDeclearationConstants.DeliveryTerm.CIF.toString()) {
			Initilization.enter_Text("xpath", "//input[@placeholder='Freight']", "10" + Keys.ENTER);
			Initilization.enter_Text("xpath", "//input[@placeholder='Insurance']", "1" + Keys.ENTER);
			Initilization.click_On_CheckBox("name", "insurancePercentageCheck");
		} else if (deliveryTerm == SingleDeclearationConstants.DeliveryTerm.FOB.toString()) {
			//Do Noting
		} else if (deliveryTerm == SingleDeclearationConstants.DeliveryTerm.CFR.toString()) {
			Initilization.enter_Text("xpath", "//input[@placeholder='Freight']", "200" + Keys.ENTER);
		}

	}

	public static void CommodityInformation(int noOfItem, int noOfContainers) {

		for (int i = 0; i < noOfItem; i++) {
			scrollUp();
			Initilization.waitUntilElementtoLoad(5);
			AddCommodityButton();
			Initilization.waitUntilElementtoLoad(5);
			//Initilization.waitUntilElementtoLoad(40);


			for (int j = 0; j < noOfContainers; j++) {
				Initilization.waitUntilElementtoLoad(5);
				AddContainerButton();
				ContainerInformation();

			}

			Initilization.waitUntilElementtoLoad(10);
			//SelectGeneralInformationTab();
			GeneralInformation("0301.1100");
			SelectSupportingInformationTab();
			SupportingInformation();
			Save();
			Initilization.waitUntilElementtoLoad(40);


		}

	}


	public static void CommodityInformationOGA(int noOfItem, int noOfContainers) {
		for (int i = 0; i < noOfItem; i++) {
			AddCommodityButton();
			Initilization.waitUntilElementtoLoad(15);
			//Initilization.waitUntilElementtoLoad(40);


			for (int j = 0; j < noOfContainers; j++) {
				Initilization.waitUntilElementtoLoad(10);
				AddContainerButton();
				ContainerInformation();

			}

			Initilization.WebDriverWait(15);
			//SelectGeneralInformationTab();
			GeneralInformationOGA();
			SelectSupportingInformationTab();
			SupportingInformation();

			OGAsRequiredInformationTab();
			OGARequiredInformation();
			OGARequiredDocumentsTab();
			OGARequiredDocuments();

			Save();
			Initilization.waitUntilElementtoLoad(40);


		}
	}

	public static void OGARequiredDocuments() {

		Initilization.click_On_Button("xpath", "(//a[@class='OGARequiredDocumentsExport_greenIcon__qKShq'])[1]");
		OGASelectFile();
		Initilization.WebDriverWait(3);
		Initilization.click_On_Button("xpath", "(//a[@class='OGARequiredDocumentsExport_greenIcon__qKShq'])[3]");
		OGASelectFile();
		Initilization.WebDriverWait(3);

	}
	public static void OGARequiredDocumentsAQD() {

		Initilization.WebDriverWait(3);
		Initilization.click_On_Button("xpath", "(//a[@class='OGARequiredDocumentsExport_greenIcon__qKShq'])[2]");
		OGASelectFile();
		Initilization.WebDriverWait(3);
	}
		public static void Documents() {

		Initilization.WebDriverWait(4);
		DocumentType("M - Invoice");
		Initilization.WebDriverWait(4);
		SelectFile();
		Initilization.WebDriverWait(4);
		Initilization.waitUntilElementtoLoad(40);
		DocumentType("M - Packing List");
		Initilization.WebDriverWait(2);
		SelectFile();
		Initilization.WebDriverWait(5);


	}

	public static void ReviewAndValidate(@Nullable String Agency) {
		Initilization.waitUntilElementtoLoad(5);
		scrollDown();
		if (Agency!=null) {
			OGASiteOfficeSelection(Agency);
		}
	}

	public static void OGASiteOfficeSelection(@Nullable String Agency) {
		if (Agency.equalsIgnoreCase("DPP")) {
			WebElement d = driver.findElement(By.xpath("//input[@placeholder='Please Select City']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", d);
			Initilization.click_On_Button("xpath", "//input[@placeholder='Please Select City']");
			Initilization.enter_Text("xpath", "//input[@placeholder='Please Select City']", "Karachi" + Keys.ENTER);
			Initilization.WebDriverWait(1);
			Initilization.click_On_Button("xpath", "//input[@placeholder='Please Select Agency Name']");
			Initilization.enter_Text("xpath", "//input[@placeholder='Please Select Agency Name']", "Sea Port Outpost, Karachi" + Keys.ENTER);
		}
		else if(Agency.equalsIgnoreCase("AQD")){
			WebElement d = driver.findElement(By.xpath("//input[@placeholder='Please Select City']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", d);
			Initilization.click_On_Button("xpath", "//input[@placeholder='Please Select City']");
			Initilization.enter_Text("xpath", "//input[@placeholder='Please Select City']", "Karachi" + Keys.ENTER);
			Initilization.WebDriverWait(1);
			Initilization.click_On_Button("xpath", "//input[@placeholder='Please Select Agency Name']");
			Initilization.enter_Text("xpath", "//input[@placeholder='Please Select Agency Name']", "Karachi AQD Directorate" + Keys.ENTER);


		}





	}


	public static String PaymentProcedure() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//p[@class='title font-semibold'])[1]")));
		String paymentSlip = Initilization.getTextxpath("(//p[@class='title font-semibold'])[1]");
		paymentSlip = paymentSlip.substring(6, 23);
		//System.out.println("PSID is 6 digits:" + paymentSlip);
		Initilization.UpdatePaymentStatus("https://" + Initilization.Environment + ".psw.gov.pk/api/ups/PSID/open", paymentSlip, "3000");
		String SDNumber = Initilization.getTextxpath("(//strong[@class='text-dark text-break'])[3]");
		return SDNumber;

	}

	///
	/// SINGLE DECLEARAIOTN POPUP WINDOWS
	///
	public static void SelectNTNWindow() {
		waitUntilVisibilityOfElementLocated(10, "//span[@class='k-icon k-i-search position-relative']");
		Initilization.click_On_Button("xpath", "//span[@class='k-icon k-i-search position-relative']");

	}

	public static void PackageInformationPage() {

	}

	public static void FinancialInstrumentWindow(String fi) {
		SearchFinancialInsrumentButton();
		Initilization.enter_Text("id", "trader-name-text-box", fi);
		Initilization.click_On_Button("xpath", "//table[@class='k-grid-table']");
		AddButton();
	}

	public static void QuotaWindow() {

	}

	public static void GeneralInformation(String hsCode) {
		Initilization.enter_Text("xpath", "//input[@placeholder='Please enter HS code']", hsCode + Keys.ENTER);
		Initilization.enter_Text("name", "declaredDescription", "Some Random HSCode");
		String Unit = Initilization.randomBLNumber(2);
		Initilization.enter_Text("name", "unitValue", Unit + Keys.ENTER);

	}

	public static void GeneralInformationOGA() {
		Initilization.enter_Text("xpath", "//input[@placeholder='Please enter HS code']", "0201.1000" + Keys.ENTER);
		// Initilization.enter_Text("xpath", "//input[@placeholder='Please enter product
		// code']", "0000"+ Keys.ENTER);
		Initilization.WebDriverWait(4);
		Initilization.enter_Text("xpath", "//input[@placeholder='Please enter product code']", "0000- CARCASSES AND HALF- CARCASSES" + Keys.ENTER);
		Initilization.WebDriverWait(3);
		Initilization.enter_Text("name", "declaredDescription", "Some Random HSCode");
		String Unit = Initilization.randomBLNumber(2);
		Initilization.enter_Text("name", "unitValue", Unit + Keys.ENTER);
	}


	public static void OGARequiredInformationAQD() {

		Initilization.enter_Text("xpath", "//input[@placeholder='Please select category']", "ANIMAL PRODUCTS" + Keys.ENTER);
		Initilization.enter_Text("xpath", "//input[@placeholder='Please enter quantity']", "2000" + Keys.ENTER);
		Initilization.enter_Text("xpath", "//input[@placeholder='Please select packing unit (for fee calculation)']", "Beef Quarter" + Keys.ENTER);
		Initilization.enter_Text("xpath", "//input[@placeholder='Please select temperature type']", "Ambient" + Keys.ENTER);
		Initilization.enter_Text("xpath", "//input[@placeholder='Please select temperature unit']", "Celsius" + Keys.ENTER);
		waitUntilVisibilityOfElementLocated(15,"//textarea[@placeholder='Please enter package distribution']");
		enter_Text("xpath","//textarea[@placeholder='Please enter package distribution']","Test Automation");
		Initilization.WebDriverWait(2);
		Initilization.click_On_Button_Action("xpath", "//button[normalize-space()='Get Documentary Requirement']");
		Initilization.WebDriverWait(10);

	}
	public static void OGARequiredInformation() {
		Initilization.enter_Text("xpath", "//input[@placeholder='Please select purpose of export']", "Sowing/cultivation" + Keys.ENTER);
		Initilization.enter_Text("xpath", "//input[@placeholder='Please select treatment provider company']", "PSW Fumigation Company" + Keys.ENTER);
		Initilization.enter_Text("xpath", "//input[@placeholder='Please select botanical name']", "Plantae" + Keys.ENTER);
		//	Initilization.enter_Text("xpath", "//input[@placeholder='Please enter treatment additional information(treatment type)']", "No" + Keys.ENTER);
		
		/*Initilization.enter_Text("xpath", "//input[@placeholder='Please enter temperature (in celsius)']", "23" + Keys.ENTER);
		Initilization.click_On_Button("xpath", "//a[@class='k-select k-select']");		
		Initilization.WebDriverWait(2);				
		Initilization.click_On_Button("xpath", "//span[@class='k-today']");
		Initilization.enter_Text("xpath", "//input[@name='FumigatorName']", "Muhammad Maaz" + Keys.ENTER);
		Initilization.enter_Text("xpath", "//input[@name='Treatment']", "H2K2L2" + Keys.ENTER);
		Initilization.enter_Text("xpath", "//input[@name='FumigationAdditionalInfo']", "No" + Keys.ENTER);
		Initilization.enter_Text("xpath", "//input[@placeholder='Please enter time duration (in minutes)']", "34" + Keys.ENTER);
		Initilization.enter_Text("xpath", "//input[@name='Concentration']", "High" + Keys.ENTER);
		Initilization.enter_Text("xpath", "//input[@name='AdditionalDeclaration']", "No" + Keys.ENTER);
		*/
		Initilization.WebDriverWait(2);
		Initilization.click_On_Button_Action("xpath", "//button[normalize-space()='Get Documentary Requirement']");

		Initilization.WebDriverWait(10);
	}

	public static void ContainerInformation() {
		String ContainerNumber = "MODO";
		ContainerNumber += Initilization.randomBLNumber(7);
		int quantity = Integer.parseInt(Initilization.randomBLNumber(3));
		totalQuantity += quantity;
		Initilization.enter_Text("xpath", "//input[@placeholder='Enter container number']",
				ContainerNumber + Keys.ENTER);
		Initilization.enter_Text("xpath", "//input[@placeholder='Enter Quantity']", Integer.toString(quantity) + Keys.ENTER);
		Initilization.enter_Text("xpath", "//input[@placeholder='Enter No of Package']",
				"200" + Keys.ENTER);
		Initilization.enter_Text("xpath", "//input[@placeholder='Select package type']", "DRUMS" + Keys.ENTER);
		Initilization.WebDriverWait(2);
		AddButton();
		Initilization.WebDriverWait(2);
		Initilization.click_On_Button("xpath", "//button[normalize-space()='Yes']");
		Initilization.WebDriverWait(2);

	}

	public static void SupportingInformation() {
		Initilization.enter_Text("name", "quantityStatisticalPurpose", Integer.toString(totalQuantity) + Keys.ENTER);
		totalQuantity = 0;
	}

	public static void RequiredDocuments() {
		Initilization.enter_Text("name", "quantityStatisticalPurpose", "100" + Keys.ENTER);

	}

	public static void NonDutyPaidWindow() {

	}

	///
	/// ACTIONS
	///
	public static void DeleteButton() {

	}

	public static void AddButton() {
		Initilization.click_On_Button("xpath", "//button[normalize-space()='Add']");
	}

	public static void EditButton() {

	}

	public static void SubmitButton() {

	}

	public static void Confirm() {
		waitUntilVisibilityOfElementLocated(10, "//button[normalize-space()='Confirm']");
		Initilization.click_On_Button("xpath", "//button[normalize-space()='Confirm']");

	}

	public static void SaveAndProceedButton() {
		waitUntilVisibilityOfElementLocated(5, "//button[normalize-space()='Save & Proceed']");
		Initilization.click_On_Button("xpath", "//button[normalize-space()='Save & Proceed']");

	}

	public static void SaveAndSubmitButton() {
		Initilization.click_On_Button("xpath", "//button[normalize-space()='Save and Submit']");

	}

	public static void Proceed() {
		//Initilization.waitUntilElementtoLoad(40);
		Initilization.click_On_Button("xpath", "//button[normalize-space()='Proceed']");
	}

	public static void Save() {
		Initilization.click_On_Button("xpath", "//button[normalize-space()='Save']");
	}

	public static void ValidateAndProceed() {
		Initilization.WebDriverWait(3);
		Initilization.click_On_Button("xpath","//button[normalize-space()='Validate & Proceed']");
		Initilization.WebDriverWait(3);
	}


	public static void SearchFinancialInsrumentButton() {
		Initilization.click_On_Button("xpath", "//span[@class='k-icon k-i-search position-relative']");
	}

	public static void AddCommodityButton() {
		Initilization.click_On_Button("xpath", "//button[normalize-space()='Add commodity']");
		Initilization.WebDriverWait(3);

	}

	public static void AddQuota() {

	}

	public static void AttachNonDutyPaidItem() {

	}

	public static void DocumentType(String documentType) {
		Initilization.enter_Text("xpath", "//input[@placeholder='Select Document Type']", documentType + Keys.ENTER);
	}

	public static void SelectFile() {

		WebElement d = driver.findElement(By.xpath("//div[@class='k-dropzone-hint']"));
		String path = projectDirectory + "\\Resources\\Invoice.pdf";

		Initilization.DropFile(new File(path), d, 745, 21);

	}

	public static void OGASelectFile() {
		waitUntilVisibilityOfElementLocated(5, "//div[@class='k-dropzone-hint']");
		WebElement d = driver.findElement(By.xpath("//div[@class='k-dropzone-hint']"));
		String path = projectDirectory + "\\Resources\\Invoice.pdf";

		Initilization.DropFile(new File(path), d, 745, 21);

	}

	public static void AddContainerButton() {
		Initilization.click_On_Button("xpath", "//button[normalize-space()='Add Container']");
		Initilization.WebDriverWait(3);
	}

	public static void SelectGeneralInformationTab() {
		Initilization.click_On_Button("xpath", "//p[normalize-space()='General Information']");
		Initilization.WebDriverWait(2);
	}

	public static void SelectContainersInformationTab() {
		Initilization.click_On_Button("xpath", "//p[normalize-space()='Containers Information']");
		Initilization.WebDriverWait(2);
	}

	public static void SelectSupportingInformationTab() {
		Initilization.click_On_Button("xpath", "//p[normalize-space()='Supporting Information']");
		Initilization.waitUntilElementtoLoad(5);
	}

	public static void SelectNonDutyPaidItemTab() {
		Initilization.click_On_Button("xpath", "//p[normalize-space()='Non Duty Paid Item']");
		Initilization.WebDriverWait(2);
	}

	public static void OGAsRequiredInformationTab() {
		Initilization.click_On_Button("xpath", "//p[contains(text(),'OGA')]");
		Initilization.waitUntilElementtoLoad(5);
	}

	public static void OGARequiredDocumentsTab() {
		Initilization.click_On_Button("xpath", "//p[normalize-space()='Required Documents']");
		Initilization.WebDriverWait(5);
	}


	///Random HSCode 
	///
	public static String getRandomHSCode_NonOGA() {
		String[] hscode = {"0401.1000", "9301.1000", "0301.1100", "0201.1000"};
		int index = Integer.parseInt(Initilization.randomNumber(1));
		System.out.print(hscode[index]);
		String temp = hscode[index];
		return temp;

	}

	public static String getRandomHSCode_OGA() {
		String[] hscode = {"0601.1010", "5301.1000", "0301.1100", "0201.1000"};
		String[] productCode = {"Sowing and cultivation", "9301.1000", "0301.1100", "0201.1000"};
		int index = Integer.parseInt(Initilization.randomNumber(1));
		System.out.print(hscode[index]);
		String temp = hscode[index];
		return temp;

	}

	public static String fileOGASingleDeclarationWithOpenAccount() {
		String ntn = "0133358";
		String userName = "UN-00-" + ntn;
		String password = "Test@1234";

		Initilization.OpenUrl(Initilization.URL);
		// HomePage
		Initilization.waitUntilElementtoLoad(10);
		// This Line will Click on Subscriber Button
		Initilization.Login(userName, password);
		Initilization.waitUntilElementtoLoad(10);
		SingleDeclearationHelper.OpenMenu();
		Initilization.WebDriverWait(6);


		SingleDeclearationHelper.CreateDeclearation();
		Initilization.waitUntilElementtoLoad(30);


		SingleDeclearationHelper.TransactionType("0656564", "Commercial", "Export Commercial Transaction");

		SingleDeclearationHelper.Confirm();
		Initilization.waitUntilElementtoLoad(10);
//		Initilization.WebDriverWait(20);


		SingleDeclearationHelper.ConsignmentInformation("Port Qasim (exports), karachi", "Containerized", "Qasim International Container Terminal", "Qasim International Container Terminal"
				,
				"BAMI KHAN FLOUR & GENERAL MILLS (PRIVATE)LIMITED",
				"OFFICE # 1 PLOT # 407 INDUSTRIAL AREA");
		SingleDeclearationHelper.SaveAndProceedButton();
		Initilization.waitUntilElementtoLoad(10);


		SingleDeclearationHelper.FinancialInformation
				(SingleDeclearationConstants.Currency.UnitedStatesDollar.toString(), "DIB-EXP-000434-18102021", SingleDeclearationConstants.DeliveryTerm.CIF.toString(),
						SingleDeclearationConstants.Bank.AlBarakaBank.toString(), "PK83DUIB0000001040001740", SingleDeclearationConstants.ModeofPayment.OpenAccount.toString());

		SingleDeclearationHelper.SaveAndProceedButton();
		Initilization.waitUntilElementtoLoad(10);


		SingleDeclearationHelper.CommodityInformationOGA(1, 1);
		Initilization.WebDriverWait(12);

		SingleDeclearationHelper.Proceed();
		Initilization.waitUntilElementtoLoad(10);


		SingleDeclearationHelper.Documents();
		SingleDeclearationHelper.Proceed();
		Initilization.WebDriverWait(5);

		SingleDeclearationHelper.ReviewAndValidate(null);
		Initilization.WebDriverWait(4);
		SingleDeclearationHelper.ValidateAndProceed();
		Initilization.waitUntilElementtoLoad(10);


		SingleDeclearationHelper.SaveAndSubmitButton();
		Initilization.WebDriverWait(10);
		String paymentSlip = Initilization.getTextxpath("(//p[@class='title font-semibold'])[1]");
		paymentSlip = paymentSlip.substring(6, 23);
		String psidAmount = Initilization.getTextxpath("(//p[@class='title font-semibold'])[2]");
		System.out.println(psidAmount);

		//System.out.println("PSID is 6 digits:" + paymentSlip);
		Initilization.UpdatePaymentStatus("http://" + Initilization.Environment + ".psw.gov.pk/api/ups/PSID/open", paymentSlip, psidAmount);
		String SDNumber = Initilization.getTextxpath("(//strong[@class='text-dark text-break'])[3]");

		System.out.println(SDNumber);

		//String SDNumber 
		//Initilization.logout();
		return SDNumber;


	}

	public static void CreateDeclerationImport() {
		waitUntilVisibilityOfElementLocated(25, "//p[normalize-space()='Import']");
		//createDeclearation_Export_Btn
		Initilization.click_On_Button("xpath", "//p[normalize-space()='Import']");
		Initilization.WebDriverWait(2);

	}

	public static void TransactionTypeImport(String ntn, String consignmentCategory, String declarationType) {
		SelectNTNWindow();
		Initilization.enter_Text("id", "ntn-text-box", ntn);
		Initilization.waitUntilElementtoLoad(50);
		//
		waitUntilVisibilityOfElementLocated(50, "//tr[@class='k-master-row']");
		Initilization.click_On_Button("xpath", "//tr[@class='k-master-row']");
		waitUntilVisibilityOfElementLocated(50, "//input[@placeholder='Select consignment category']");
		Initilization.enter_Text("xpath", "//input[@placeholder='Select consignment category']",
				consignmentCategory + Keys.ENTER);
		waitUntilVisibilityOfElementLocated(50, "//input[@placeholder='Select declaration type']");
		Initilization.enter_Text("xpath", "//input[@placeholder='Select declaration type']",
				declarationType + Keys.ENTER);
		waitUntilVisibilityOfElementLocated(50, "(//button[normalize-space()='Confirm'])[2]");
		click_On_Button("xpath", "(//button[normalize-space()='Confirm'])[2]");

	}

	public static void ConsigmentInformationImport() {
		//Enter Text in BL Number Field
		WebDriverWait(5);
		enter_Text("xpath", "//input[@placeholder='Please enter BL number']", "AWBL-78B6AB2A9B");
		//Enter BL Date
		WebDriverWait(5);
		click_On_Button("xpath", "//div[@class='pb-3 ConsignmentInfoImport_separator__3kbQF d-flex align-items-end justify-content-end col-sm-8']");
		waitUntilElementtoLoad(15);
		click_On_Button("xpath", "//a[@class='k-select k-select']");
		waitUntilElementtoLoad(15);
		click_On_Button("xpath", "//span[@class='k-today']");
		waitUntilElementtoLoad(15);
		click_On_Button("xpath", "//div[@class='pb-3 ConsignmentInfoImport_separator__3kbQF d-flex align-items-end justify-content-end col-sm-8']");
		waitUntilElementtoLoad(15);

		//Select VIR Number
		waitUntilVisibilityOfElementLocated(50, "//span[@class='k-icon k-i-search position-relative']");
		click_On_Button("xpath", "//span[@class='k-icon k-i-search position-relative']");

		waitUntilVisibilityOfElementLocated(50, "(//tr[@class='k-master-row'])[1]");
		click_On_Button("xpath", "(//tr[@class='k-master-row'])[1]");

		//Click IGM Info Button
		waitUntilElementtoLoad(50);
		waitUntilVisibilityOfElementLocated(50, "//button[normalize-space()='Get IGM Info']");
		click_On_Button("xpath", "//button[normalize-space()='Get IGM Info']");
		waitUntilElementtoLoad(15);
		SelectCollectrateDropdown();
		waitUntilElementtoLoad(15);

		SelectConsigneeNameDropdown();
		waitUntilElementtoLoad(15);

		SelectConsigneeAddressDropdown();
		waitUntilElementtoLoad(15);
		SaveAndProceedButton();


	}


	public static void FinancialInformationImport(String currency, String FI, String deliveryTerm, String bank, String iban, String modeofPayment) {
		waitUntilVisibilityOfElementLocated(15, "//input[@placeholder='Please select currency']");
		Initilization.enter_Text("xpath", "//input[@placeholder='Please select currency']",
				currency + Keys.ENTER);

		Initilization.waitUntilVisibilityOfElementLocated(15, "//input[@placeholder='Select Delivery Term']");
		Initilization.enter_Text("xpath", "//input[@placeholder='Select Delivery Term']",
				deliveryTerm + Keys.ENTER);

		waitUntilVisibilityOfElementLocated(15, "//input[@placeholder='Please select bank name']");
		Initilization.enter_Text("xpath", "//input[@placeholder='Please select bank name']",
				bank + Keys.ENTER);
		waitUntilVisibilityOfElementLocated(15, "//input[@placeholder='Please select IBAN']");
		Initilization.enter_Text("xpath", "//input[@placeholder='Please select IBAN']",
				iban + Keys.ENTER);

		Initilization.waitUntilVisibilityOfElementLocated(15, "//input[@placeholder='Please select Mode of Payment']");
		Initilization.enter_Text("xpath", "//input[@placeholder='Please select Mode of Payment']",
				modeofPayment + Keys.ENTER);

		if (modeofPayment != SingleDeclearationConstants.ModeofPayment.OpenAccount.toString()) {
			FinancialInstrumentWindow(FI);
		} else {
			AddButton();

		}

		if (deliveryTerm == SingleDeclearationConstants.DeliveryTerm.FOB.toString()) {
			enter_Text("xpath", "//input[@placeholder='Freight']", "1");
		} else if (deliveryTerm == SingleDeclearationConstants.DeliveryTerm.CFR.toString()) {
			//do Nothing
		}
		waitUntilVisibilityOfElementLocated(5, "//input[@placeholder='Landing Charges']");
		enter_Text("xpath", "//input[@placeholder='Landing Charges']", "1");
		waitUntilElementtoLoad(5);
		SaveAndProceedButton();

	}

	public static void CommodityInformationADQImport() {
		waitUntilVisibilityOfElementLocated(5, "//button[normalize-space()='Add commodity']");
		click_On_Button("xpath", "//button[normalize-space()='Add commodity']");
		WebDriverWait(10);
		GeneralInformationImportSDAQD();
		WebDriverWait(2);
		Duty_TaxesInformation();
		WebDriverWait(2);
		//OGARequiredInfoAQD();
		//WebDriverWait(3);
		//RequiredDocumentsSDImportAQD();
		Save();
		WebDriverWait(3);
		//Proceed(); // Proceed from Commodity Information Tab


	}


	public static String fileOGASingleDeclarationWithCFR_FI() {
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


		SingleDeclearationHelper.CreateDeclearation();
		Initilization.WebDriverWait(6);


		SingleDeclearationHelper.TransactionType("0656564", "Commercial", "Export Commercial Transaction");

		SingleDeclearationHelper.Confirm();
		Initilization.WebDriverWait(6);


		SingleDeclearationHelper.ConsignmentInformation("Port Qasim (exports), karachi", "Containerized", "Qasim International Container Terminal", "Qasim International Container Terminal"
				,
				"BAMI KHAN FLOUR & GENERAL MILLS (PRIVATE)LIMITED",
				"OFFICE # 1 PLOT # 407 INDUSTRIAL AREA");
		SingleDeclearationHelper.SaveAndProceedButton();
		Initilization.WebDriverWait(3);

		SingleDeclearationHelper.FinancialInformation
				(SingleDeclearationConstants.Currency.UnitedStatesDollar.toString(), "DIB-EXP-000001-19082022", SingleDeclearationConstants.DeliveryTerm.CFR.toString(),
						SingleDeclearationConstants.Bank.DubaiIslamicBank.toString(), "PK30DUIB0000005293451918", SingleDeclearationConstants.ModeofPayment.ContractCollection.toString());

		SingleDeclearationHelper.SaveAndProceedButton();
		Initilization.WebDriverWait(3);


		SingleDeclearationHelper.CommodityInformationOGA(1, 1);
		Initilization.WebDriverWait(10);

		SingleDeclearationHelper.Proceed();
		Initilization.WebDriverWait(5);


		SingleDeclearationHelper.Documents();
		SingleDeclearationHelper.Proceed();
		Initilization.WebDriverWait(5);

		SingleDeclearationHelper.ReviewAndValidate(null);
		Initilization.WebDriverWait(4);
		SingleDeclearationHelper.ValidateAndProceed();
		Initilization.WebDriverWait(10);


		SingleDeclearationHelper.SaveAndSubmitButton();
		Initilization.WebDriverWait(10);
		//String SDNumber = SingleDeclearationHelper.PaymentProcedure();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//p[@class='title font-semibold'])[1]")));
		String paymentSlip = Initilization.getTextxpath("(//p[@class='title font-semibold'])[1]");
		paymentSlip = paymentSlip.substring(6, 23);
		String psidAmount = Initilization.getTextxpath("(//p[@class='title font-semibold'])[2]");
		System.out.println(psidAmount);

		//System.out.println("PSID is 6 digits:" + paymentSlip);
		Initilization.UpdatePaymentStatus("https://" + Initilization.Environment + ".psw.gov.pk/api/ups/PSID/open", paymentSlip, psidAmount);
		String SDNumber = Initilization.getTextxpath("(//strong[@class='text-dark text-break'])[3]");

		System.out.println(SDNumber);

		//String SDNumber 
		//Initilization.logout();
		return SDNumber;

	}

	public static void SelectCollectrateDropdown() {

		waitUntilElementtoLoad(50);
		click_On_Button("xpath", "//input[@placeholder='Please select collectorate']");
		enter_Text("xpath", "//input[@placeholder='Please select collectorate']", "Karachi Air Freight Unit" + Keys.ENTER);
	}

	public static void SelectConsigneeNameDropdown() {
		waitUntilVisibilityOfElementLocated(15, "//input[@placeholder='Select consignee name']");
		enter_Text("xpath", "//input[@placeholder='Select consignee name']", "BAMI KHAN FLOUR & GENERAL MILLS (PRIVATE)LIMITED" + Keys.ENTER);

	}

	public static void SelectConsigneeAddressDropdown() {
		waitUntilVisibilityOfElementLocated(15, "//input[@placeholder='Select consignee name']");
		enter_Text("xpath", "//input[@placeholder='Select consignee address']", "OFFICE # 1 PLOT # 407 INDUSTRIAL AREA" + Keys.ENTER);
	}


	public static void GeneralInformationImportSDAQD() {    //Enter Data in HS Code

		waitUntilElementtoLoad(40);
		enter_Text("xpath", "//input[@placeholder='Please enter HS code']", "9201.1000" + Keys.ENTER);
		//waitUntilVisibilityOfElementLocated(15, "//input[@placeholder='Please enter product code']");
		//Enter Product Code
		//enter_Text("xpath", "//input[@placeholder='Please enter product code']", "0000- CARCASSES AND HALF- CARCASSES" + Keys.ENTER);
		waitUntilElementtoLoad(30);
		enter_Text("xpath", "//textarea[@placeholder='Please enter declared description']", "AutomationTestScript");
		WebDriverWait(3);
	}

	public static void GeneralInformationImportSDPSQCA() {    //Enter Data in HS Code
		waitUntilElementtoLoad(40);
		enter_Text("xpath", "//input[@placeholder='Please enter HS code']", "8501.4090" + Keys.ENTER);
		waitUntilVisibilityOfElementLocated(15, "//input[@placeholder='Please enter product code']");
		//Enter Product Code
		enter_Text("xpath", "//input[@placeholder='Please enter product code']", "1000- - - - - Induction motor " + Keys.ENTER);
		waitUntilVisibilityOfElementLocated(15, "//textarea[@placeholder='Please enter declared description']");
		enter_Text("xpath", "//textarea[@placeholder='Please enter declared description']", "AutomationTestScript");
		WebDriverWait(3);
	}

	public static void Duty_TaxesInformation() {
		waitUntilVisibilityOfElementLocated(15, "//p[normalize-space()='Duty & Taxes Information']");
		click_On_Button("xpath", "//p[normalize-space()='Duty & Taxes Information']");
		waitUntilVisibilityOfElementLocated(15, "(//input[@placeholder='Enter Quantity'])[1]");
		enter_Text("xpath", "(//input[@placeholder='Enter Quantity'])[1]", "100");
		waitUntilVisibilityOfElementLocated(15, "(//input[@placeholder='Enter Quantity'])[2]");
		enter_Text("xpath", "(//input[@placeholder='Enter Quantity'])[2]", "100");
		waitUntilVisibilityOfElementLocated(15, "//input[@name='unitValue']");
		enter_Text("xpath", "//input[@name='unitValue']", "5");
		waitUntilVisibilityOfElementLocated(15, "//input[@name='unitValueInvoice']");
		enter_Text("xpath", "//input[@name='unitValueInvoice']", "5");
		waitUntilVisibilityOfElementLocated(15, "//input[@placeholder='Item Import Type']");
		enter_Text("xpath", "//input[@placeholder='Item Import Type']", "Commercial" + Keys.ENTER);
		waitUntilVisibilityOfElementLocated(15, "//input[@placeholder='Origin']");
		enter_Text("xpath", "//input[@placeholder='Origin']", "Ireland" + Keys.ENTER);
		WebDriverWait(3);


	}

	public static void OGARequiredInfoAQD() {
		waitUntilElementtoLoad(50);
		click_On_Button("xpath", "(//div[@class='h-100'])[4]");
		waitUntilVisibilityOfElementLocated(15, "//input[@placeholder='Please select category']");
		enter_Text("xpath", "//input[@placeholder='Please select category']", "ANIMAL PRODUCT OTHER THAN SEMEN" + Keys.ENTER);
		waitUntilVisibilityOfElementLocated(15, "//input[@placeholder='Please enter quantity']");
		ClearField("xpath", "//input[@placeholder='Please enter quantity']");
		enter_Text("xpath", "//input[@placeholder='Please enter quantity']", "100");
		waitUntilVisibilityOfElementLocated(15, "//input[@placeholder='Please select uom']");
		enter_Text("xpath", "//input[@placeholder='Please select uom']", "Beef Quarter" + Keys.ENTER);
		waitUntilVisibilityOfElementLocated(15, "//textarea[@placeholder='Please enter package distribution']");
		enter_Text("xpath", "//textarea[@placeholder='Please enter package distribution']", "Test Automation");
		waitUntilVisibilityOfElementLocated(15, "//button[normalize-space()='Get Documentary Requirement']");
		click_On_Button("xpath", "//button[normalize-space()='Get Documentary Requirement']");
		waitUntilElementtoLoad(10);


	}

	public static void RequiredDocumentsSDImportAQD() {
		waitUntilVisibilityOfElementLocated(15, "//button[normalize-space()='Get Documentary Requirement']");
		click_On_Button("xpath", "//button[normalize-space()='Get Documentary Requirement']");
		waitUntilElementtoLoad(30);
		click_On_Button("xpath","(//p[@class='d-inline'])[7]");
		waitUntilVisibilityOfElementLocated(15, "(//a[@class='OGARequiredDocumentsImport_greenIcon__3VAot'])[4]");
		click_On_Button("xpath", "(//a[@class='OGARequiredDocumentsImport_greenIcon__3VAot'])[4]");
		OGASelectFile();
		waitUntilElementtoLoad(30);
		click_On_Button("xpath","(//a[@class='OGARequiredDocumentsImport_greenIcon__3VAot'])[5]");
		OGASelectFile();
		waitUntilElementtoLoad(30);
		click_On_Button("xpath","(//a[@class='OGARequiredDocumentsImport_greenIcon__3VAot'])[6]");
		OGASelectFile();
		WebDriverWait(3);

	}

	public static void ItemStructureAQD() {
		//waitUntilVisibilityOfElementLocated(20,"//a[@class='CommodityInfoImport_editIcon__3HTQR'])[1]");
		waitUntilElementtoLoad(20);
		click_On_Button("xpath", "(//a[@class='CommodityInfoImport_editIcon__3HTQR'])[1]");

//		waitUntilVisibilityOfElementLocated(20,"(//input[@class='custom-control-input'])[1]");
		waitUntilElementtoLoad(20);
		click_On_CheckBox("xpath", "(//input[@class='custom-control-input'])[1]");

//		waitUntilVisibilityOfElementLocated(20,"(//input[@class='custom-control-input'])[4]");
		waitUntilElementtoLoad(20);
		click_On_CheckBox("xpath", "(//input[@class='custom-control-input'])[4]");

//		waitUntilVisibilityOfElementLocated(20,"(//input[@class='custom-control-input'])[7]");
		waitUntilElementtoLoad(20);
		click_On_CheckBox("xpath", "(//input[@class='custom-control-input'])[7]");

//		waitUntilVisibilityOfElementLocated(20,"(//input[@class='custom-control-input'])[10]");
		waitUntilElementtoLoad(20);
		click_On_CheckBox("xpath", "(//input[@class='custom-control-input'])[10]");

//		waitUntilVisibilityOfElementLocated(20,"(//input[@class='custom-control-input'])[13]");
		waitUntilElementtoLoad(20);
		click_On_CheckBox("xpath", "(//input[@class='custom-control-input'])[13]");

//		waitUntilVisibilityOfElementLocated(20,"(//input[@class='custom-control-input'])[16]");
		waitUntilElementtoLoad(20);
		click_On_CheckBox("xpath", "(//input[@class='custom-control-input'])[16]");

//		waitUntilVisibilityOfElementLocated(20,"(//input[@class='custom-control-input'])[19]");
		waitUntilElementtoLoad(20);
		click_On_CheckBox("xpath", "(//input[@class='custom-control-input'])[19]");

//		waitUntilVisibilityOfElementLocated(20,"(//input[@class='custom-control-input'])[23]");
		waitUntilElementtoLoad(20);
		click_On_CheckBox("xpath", "(//input[@class='custom-control-input'])[23]");
		waitUntilElementtoLoad(10);
		click_On_Button("xpath", "//button[normalize-space()='Submit']");
		waitUntilElementtoLoad(10);
		SingleDeclearationHelper.Proceed();
		waitUntilElementtoLoad(10);

	}
	public static void ItemStructurePSQCA()
	{
		waitUntilElementtoLoad(20);
		click_On_Button("xpath", "(//a[@class='CommodityInfoImport_editIcon__3HTQR'])[1]");
		waitUntilElementtoLoad(30);
		click_On_CheckBox("xpath", "(//input[@class='custom-control-input'])[1]");
		waitUntilElementtoLoad(30);
		waitUntilElementtoLoad(20);
		click_On_CheckBox("xpath", "(//input[@class='custom-control-input'])[4]");
		waitUntilElementtoLoad(20);
		click_On_CheckBox("xpath", "(//input[@class='custom-control-input'])[7]");
		waitUntilElementtoLoad(20);
		click_On_CheckBox("xpath", "(//input[@class='custom-control-input'])[10]");
		waitUntilElementtoLoad(20);
		click_On_CheckBox("xpath", "(//input[@class='custom-control-input'])[13]");
		waitUntilElementtoLoad(20);
		click_On_CheckBox("xpath", "(//input[@class='custom-control-input'])[16]");
		waitUntilElementtoLoad(20);
		click_On_CheckBox("xpath", "(//input[@class='custom-control-input'])[19]");
		waitUntilElementtoLoad(10);
		click_On_Button("xpath", "//button[normalize-space()='Submit']");
		waitUntilElementtoLoad(10);
		SingleDeclearationHelper.Proceed();
		waitUntilElementtoLoad(10);


	}

	public static void PDAccountPayment() {
		String Status;
		waitUntilVisibilityOfElementLocated(10, "//span[normalize-space()='PD Account']");
		click_On_Button("xpath", "//span[normalize-space()='PD Account']"); // Click on PD account
		waitUntilVisibilityOfElementLocated(10, "//button[normalize-space()='Confirm Payment']");
		click_On_Button("xpath", "//button[normalize-space()='Confirm Payment']"); //Click on Confirm Payment
		waitUntilVisibilityOfElementLocated(10, "//button[normalize-space()='Confirm']");
		click_On_Button("xpath", "//button[normalize-space()='Confirm']"); // Click on Confirm Button
		WebDriverWait(5);
		Status = Initilization.getTextxpath("//div[normalize-space()='Payment Successful']");
		if (Status == "Payment Successful") {
			System.out.println("Payment Successful done");
		}


	}


	public static void DateSelector() {
		waitUntilVisibilityOfElementLocated(10, "//a[@class='k-select k-select']");
		click_On_Button("xpath", "//a[@class='k-select k-select']");

	}

	public static void CommodityInformationPSQCAImport() {
		waitUntilVisibilityOfElementLocated(30, "//button[normalize-space()='Add commodity']");
		click_On_Button("xpath", "//button[normalize-space()='Add commodity']");
		WebDriverWait(10);
		GeneralInformationImportSDPSQCA();
		WebDriverWait(2);
		Duty_TaxesInformation();
		WebDriverWait(2);
		OGARequiredInfoPSQCA();
		WebDriverWait(3);
		RequiredDocumentsSDImportPSQCA();
		Save();
		WebDriverWait(3);
		//Proceed(); // Proceed from Commodity Information Tab
	}
	public static void OGARequiredInfoPSQCA()
	{
		waitUntilElementtoLoad(50);
		click_On_Button("xpath","(//div[@class='h-100'])[4]");
		waitUntilElementtoLoad(30);
		enter_Text("xpath","//input[@placeholder='Please enter shelf life (days)']","10");

	}

	public static void PSQCAStandardElements()
	{
		waitUntilElementtoLoad(30);
		enter_Text("xpath","//input[@placeholder='Please select province (warehouse)']","Sindh");
		waitUntilElementtoLoad(30);
		enter_Text("xpath","//input[@placeholder='Please select city (warehouse)']","Karachi");
		waitUntilElementtoLoad(30);
		enter_Text("xpath","//input[@placeholder='Please select street and number/p.o. box (warehouse)']","Test-100");
		waitUntilElementtoLoad(30);
		enter_Text("xpath","//input[@placeholder='Please select postcode (warehouse)']","75900");
		waitUntilElementtoLoad(30);
	}

	public static void RequiredDocumentsSDImportPSQCA()
	{
		waitUntilElementtoLoad(30);
		click_On_Button("xpath","//button[normalize-space()='Get Documentary Requirement']");
		waitUntilElementtoLoad(30);
		click_On_Button("xpath","(//p[@class='d-inline'])[7]");
		waitUntilElementtoLoad(30);
		click_On_Button("xpath","(//a[@class='OGARequiredDocumentsImport_greenIcon__3VAot'])[4]");
		OGASelectFile();
		waitUntilElementtoLoad(30);

	}

}


