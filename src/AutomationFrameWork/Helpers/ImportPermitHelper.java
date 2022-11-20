package AutomationFrameWork.Helpers;

import static io.restassured.RestAssured.given;

import org.openqa.selenium.Keys;

import AutomationFrameWork.SetupFiles.Initilization;
import Locators.ImportPermitLocators;
import Locators.SubscriptionLocators;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ImportPermitHelper {

	public static void Login(String username, String password) {
		// Enter UserName
		Initilization.enter_Text("name", ImportPermitLocators.username, username);
		// Enter Password
		Initilization.enter_Text("name", ImportPermitLocators.password, password);
		// Click LoginButton
		Initilization.click_On_Button("css", ImportPermitLocators.login);
		Initilization.WebDriverWait(2);
	}

	public static void BasicInformation(String importerName,String  importerAddress ) {

		Initilization.click_On_Button("xpath", ImportPermitLocators.importerName);

		Initilization.enter_Text("xpath", ImportPermitLocators.importerName, "Maaz" + Keys.ENTER);

		Initilization.click_On_Button("xpath", ImportPermitLocators.importerAddress);

		Initilization.enter_Text("xpath", ImportPermitLocators.importerAddress,
				"98 JAMRUD ROAD, PESHAWAR INDUSTRIAL ESTATE, JAMRUD ROAD HAYATABAD, Peshawar Peshawar" + Keys.ENTER);

	}

	public static void ExporterInformation(String exporterName,String country,String city,String email,String cellNumber,String address) {

		Initilization.enter_Text("xpath", ImportPermitLocators.exporterName, exporterName);

		Initilization.click_On_Button("id", ImportPermitLocators.country);

		Initilization.enter_Text("id", ImportPermitLocators.country, country);

		Initilization.click_On_Button("id", ImportPermitLocators.city);

		Initilization.enter_Text("id", ImportPermitLocators.city, city);

		Initilization.enter_Text("id", ImportPermitLocators.email, email);

		Initilization.enter_Text("xpath", ImportPermitLocators.cellNumber, cellNumber);

		Initilization.enter_Text("id", ImportPermitLocators.address, address);

	}

	public static void DemographicInformation(String countryOfOrigin,String importingFrom,String prescribedPortofEntry ) {

		Initilization.click_On_Button("id", ImportPermitLocators.countryOfOrigin);

		Initilization.enter_Text("id", ImportPermitLocators.countryOfOrigin, countryOfOrigin);

		Initilization.click_On_Button("id", ImportPermitLocators.importingFrom);

		Initilization.enter_Text("id", ImportPermitLocators.importingFrom, importingFrom);

		Initilization.click_On_Button("id", ImportPermitLocators.prescribedPortofEntry);

		Initilization.enter_Text("id", ImportPermitLocators.prescribedPortofEntry, prescribedPortofEntry);

	}

	public static void Commodities(String HSCode,String productCode  ,String purposeOfImport
			,String quantity ,String noOfPackages ,String PackageType  ,String  otherDescription) {

		Initilization.enter_Text("id", ImportPermitLocators.HSCode, HSCode);

		Initilization.enter_Text("id", ImportPermitLocators.productCode,productCode);

		Initilization.click_On_Button("id", ImportPermitLocators.purposeOfImport);

		Initilization.enter_Text("id", ImportPermitLocators.purposeOfImport, purposeOfImport);

		Initilization.enter_Text("id", ImportPermitLocators.quantity, quantity);

		Initilization.enter_Text("id", ImportPermitLocators.noOfPackages, noOfPackages);

		Initilization.click_On_Button("id", ImportPermitLocators.PackageType);

		Initilization.enter_Text("id", ImportPermitLocators.PackageType, PackageType);

		//Initilization.enter_Text("id", ImportPermitLocators.numOfConsignments, numOfConsignments);

		Initilization.enter_Text("id", ImportPermitLocators.otherDescription, otherDescription);

	}

	public static void DocumentInformation() {
		
		ImportPermitHelper.documentUpload("Application on DPP Prescribed Form 3");
		ImportPermitHelper.documentUpload("Proforma Invoice");
		ImportPermitHelper.documentUpload("Fee Challan");
		ImportPermitHelper.documentUpload("NOC from NBC if the imported product is GMO");

	}

	public static void ApproveImportPermit() {

		Initilization.click_On_Button("xpath", "//button[@class='mr-2 my-3 btn btn-primary']");
		Initilization.WebDriverWait(2);
		Initilization.click_On_Button("xpath", "//button[normalize-space()='Yes']");
		Initilization.WebDriverWait(2);
		Initilization.click_On_Button("xpath", "//a[normalize-space()='OK']");

	}

	public static void ApproveCallDocumentRequest() {

		Initilization.click_On_Button("xpath", "//button[@class='mr-2 my-2 btn btn-primary']");
		Initilization.WebDriverWait(2);
		Initilization.click_On_Button("xpath", "//button[normalize-space()='Yes']");
		Initilization.WebDriverWait(2);
		Initilization.click_On_Button("xpath", "//a[normalize-space()='OK']");

	}

	public static void UploadDocumentSubmit() {

		Initilization.WebDriverWait(2);
		Initilization.click_On_Button("xpath", "//button[@class='k-button ml-3']");
		Initilization.WebDriverWait(2);
		Initilization.click_On_Button("xpath", "//a[normalize-space()='OK']");

	}

	public static void RejectImportPermit() {

		Initilization.click_On_Button("xpath", "//button[@class='mr-2 my-3 btn btn-error']");
		Initilization.WebDriverWait(2);
		Initilization.click_On_Button("xpath", "//button[normalize-space()='Yes']");
		Initilization.WebDriverWait(2);
		Initilization.click_On_Button("xpath", "//a[normalize-space()='OK']");

	}

	public static void RefertoNextLevel() {

		Initilization.click_On_Button("xpath", "//button[normalize-space()='Refer to Next Level']");
		Initilization.WebDriverWait(2);
		Initilization.click_On_Button("xpath", "//button[normalize-space()='Yes']");
		Initilization.WebDriverWait(2);
		Initilization.click_On_Button("xpath", "//a[normalize-space()='OK']");

	}

	public static void CallDocument() {

		Initilization.WebDriverWait(3);
		Initilization.click_On_Button("xpath", "//button[normalize-space()='Call Documents']");
		Initilization.WebDriverWait(2);
		otherDocument("Noc");
		otherDocument("Lease");
		otherDocument("Indentification");
		otherDocument("Affidavit");
		Initilization.enter_Text("xpath", "//textarea[@class='k-input']", "Done");
		Initilization.click_On_Button("xpath", "//p[normalize-space()='Submit']");
		Initilization.WebDriverWait(1);
		Initilization.click_On_Button("xpath", "//button[normalize-space()='Yes']");
		Initilization.WebDriverWait(1);
		Initilization.click_On_Button("xpath", "//a[normalize-space()='OK']");

	}

	private static void otherDocument(String documentName) {
		Initilization.WebDriverWait(1);
		Initilization.click_On_CheckBox("xpath", "//input[ @type ='checkbox']");
		Initilization.WebDriverWait(1);
		Initilization.enter_Text("xpath", "//input[@name='name01']", documentName);
		Initilization.click_On_Button("xpath", "//button[normalize-space()='Add Other Document']");
		Initilization.click_On_CheckBox("xpath", "//input[ @type ='checkbox']");
		Initilization.WebDriverWait(1);
	}

	public static void UpdatePaymentStatus(String APIUrl, String PSID) {
		RestAssured.baseURI = APIUrl;

		Response res = given().contentType("application/json").

				body("{\r\n" + "    \"methodId\": \"1411\",\r\n" + "    \"data\": {\r\n"
						+ "        \"username\" : \"onelink\",\r\n" + "        \"password\" : \"@PSW#1947\",\r\n"
						+ "        \"psid\" : \"" + PSID + "\",\r\n"
						+ "        \"transaction_auth_id\" : \"112233\",\r\n"
						+ "        \"transaction_amount\" : \"0000000080000\",\r\n"
						+ "        \"tran_time\" : \"120911\",\r\n" + "        \"tran_date\" : \"20201208\",\r\n"
						+ "        \"bank_mnemonic\" : \"UBL\",\r\n"
						+ "        \"reserved\" : \"PSID20210126024932|1122332|PSW:58400;GST:13600;FE:8000;\"\r\n"
						+ "    },\r\n" + "    \"signature\": \"\",\r\n" + "    \"pagination\": {\r\n"
						+ "        \"offset\": 10,\r\n" + "        \"size\": 10,\r\n"
						+ "        \"sortColumn\": \"\",\r\n" + "        \"sortOrder\": \"\"\r\n" + "    }\r\n" + "}"

				).when().post("");

		String body = res.getBody().asString();
		System.out.println(body);

	}

	public static void logout() {
		// This Line will click on LogOut Button
		Initilization.click_On_Button("css", SubscriptionLocators.username_Loc);

		Initilization.WebDriverWait(3);
		Initilization.click_On_Button("xpath", SubscriptionLocators.logout);
		Initilization.WebDriverWait(3);
	}

	public static void gotoImportPermitPage() {
		Initilization.click_On_Button("xpath",
				"//span[@class='menu-item-title pt-1 pb-1 pr-1'][normalize-space()='Todo List']");

		Initilization.click_On_Button("xpath", "//p[normalize-space()='Import Permits']");

	}

	public static void SearchImportPermitformStatus(String status) {
		Initilization.WebDriverWait(3);

		Initilization.enter_Text("id", "search-box", status);
		Initilization.WebDriverWait(1);
		//Initilization.click_On_Button("xpath", "//tr[@class='k-master-row']");
	}

	public static void documentUpload(String DocumentName) {

		Initilization.click_On_Button("id", ImportPermitLocators.documentType);
		Initilization.enter_Text("id", ImportPermitLocators.documentType, DocumentName + Keys.ENTER);
		Initilization.enter_Text("xpath", ImportPermitLocators.selectFiles,
				"C:\\Users\\PSW-KHI-0004\\Downloads\\sampleFile.JPEG");
	}
	
	public static void CreateImportPermit()
	{
		// Initilization.setup();
				ImportPermitHelper.Login("UN-00-0000297", "Test@123");
				Initilization.click_On_Button("xpath", ImportPermitLocators.importPermitTab);

				Initilization.WebDriverWait(4);

				Initilization.click_On_Button("xpath", ImportPermitLocators.createImportPermitTab);

				Initilization.WebDriverWait(3);

				ImportPermitHelper.BasicInformation("Maaz" + Keys.ENTER,
						"98 JAMRUD ROAD, PESHAWAR INDUSTRIAL ESTATE, JAMRUD ROAD HAYATABAD, Peshawar Peshawar" + Keys.ENTER);
				Initilization.click_On_Button("xpath", ImportPermitLocators.saveAndProceed);

				ImportPermitHelper.ExporterInformation("Maaaz", "Afghanistan" + Keys.ENTER, "Andkhoy" + Keys.ENTER,
						"maazmaaz97@gmail.com", "32 313 231", "A22");
				Initilization.click_On_Button("xpath", ImportPermitLocators.saveAndProceed);

				ImportPermitHelper.DemographicInformation("United Arab Emirates" + Keys.ENTER, "Anguilla" + Keys.ENTER,
						"Gwadar Port" + Keys.ENTER);
				Initilization.click_On_Button("xpath", ImportPermitLocators.saveAndProceed);

				ImportPermitHelper.Commodities("0601.2000", "1004" + Keys.ENTER, "Commercial Sowing" + Keys.ENTER, "22", "22",
						"DRUMS" + Keys.ENTER,  "35");
				Initilization.click_On_Button("xpath", ImportPermitLocators.saveAndProceed);

				ImportPermitHelper.DocumentInformation();
				Initilization.click_On_Button("xpath", "//button[normalize-space()='Submit']");

				Initilization.click_On_Button("css", "button.k-button.ml-3");

				String psid = Initilization.get_Text("xpath", "//div[@class='col']//span[@class='title']");
				System.out.println("PSID:" + psid);

				ImportPermitHelper.UpdatePaymentStatus("https://qa02.psw.gov.pk/api/ups/PSID/open", psid);
				Initilization.click_On_Button("xpath", "//a[normalize-space()='OK']");

				ImportPermitHelper.logout();
	}

}
