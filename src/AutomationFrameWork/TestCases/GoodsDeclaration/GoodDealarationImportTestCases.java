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
import AutomationFrameWork.SetupFiles.Initilization;
import Locators.GoodDecelerationLocators;
import Locators.SubscriptionLocators;

public class GoodDealarationImportTestCases extends Initilization {

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

	@Test(description = "GoodDeclarationEndtoEnd", enabled = true, dataProvider = "GoodDecalarationData" /*
																											 * ,invocationCount
																											 * = 10
																											 */ )

	public static void TC1(String NTN, String CNIC, String phoneNum, String email) throws NoSuchWindowException {

		String blNumber = CarrierDeclarationHelper.CarrierDeceleration();

		// Open URL
		Initilization.OpenUrl(URL);
		Initilization.WebDriverWait(5);
		// Enter UserName
		Initilization.enter_Text("name", "userName", GoodDecelerationLocators.username);
		// Enter Password
		Initilization.enter_Text("name", "password", GoodDecelerationLocators.password);
		// Click LoginButton
		Initilization.click_On_Button("css", GoodDecelerationLocators.loginBtn);
		Initilization.WebDriverWait(5);

		Initilization.click_On_Button("xpath", GoodDecelerationLocators.goodDecelerationMenu);
		
		Initilization.WebDriverWait(10);
		driver.switchTo().frame("frame");
		Initilization.WebDriverWait(2);
		Initilization.click_On_Button("id", GoodDecelerationLocators.createNewGD);
		Initilization.WebDriverWait(2);
		Initilization.dropDown("id", GoodDecelerationLocators.consignmentCategory, "1");

		Initilization.WebDriverWait(2);
		Initilization.dropDown("name", GoodDecelerationLocators.declarationType, "47");

		Initilization.click_On_Button("id", GoodDecelerationLocators.GDSelectionCreate);

		Initilization.WebDriverWait(5);
		Initilization.dropDown("css", GoodDecelerationLocators.collectorate, "45");
		Initilization.WebDriverWait(4);
		Initilization.enter_Text("id", GoodDecelerationLocators.bLNumber, blNumber);
		Initilization.WebDriverWait(2);
		Initilization.WebDriverWait(2);
		Initilization.click_On_Button("id", GoodDecelerationLocators.VIR_NumberButton);
		Initilization.WebDriverWait(4);

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
					Initilization.click_On_Button("id", GoodDecelerationLocators.VesselName);

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
		Initilization.click_On_Button("css", GoodDecelerationLocators.BLDate);
		Initilization.click_On_Button("css", GoodDecelerationLocators.CurrentBLDate);
		Initilization.WebDriverWait(2);
		Initilization.click_On_Button("id", GoodDecelerationLocators.GetIgmInfo);
		Initilization.WebDriverWait(3);
		Initilization.dropDown("id", GoodDecelerationLocators.PaymentTerms, "33");
		// #ctl00_ContentPlaceHolder2_Financials1_txtLcNo
		Initilization.WebDriverWait(3);
		Initilization.enter_Text("id", GoodDecelerationLocators.LcNo, "331333");
		// #ctl00_ContentPlaceHolder2_Financials1_txtLcDate_imgCalendar
		Initilization.WebDriverWait(3);
		Initilization.click_On_Button("css", GoodDecelerationLocators.LCDateBtn);
		// #ctl00_ContentPlaceHolder2_Financials1_txtLcDate_calendarButtonExtender_today
		Initilization.WebDriverWait(3);
		Initilization.click_On_Button("css", GoodDecelerationLocators.LCCurrentDate);
		// ctl00_ContentPlaceHolder2_Financials1_ddlBank
		Initilization.WebDriverWait(3);
		Initilization.dropDown("css", GoodDecelerationLocators.Bank, "50");
		// #ctl00_ContentPlaceHolder2_Financials1_ddlDeliveryTerm
		Initilization.WebDriverWait(3);
		Initilization.dropDown("css", GoodDecelerationLocators.DeliveryTerm, "5");
		Initilization.WebDriverWait(3);
		Initilization.dropDown("css", GoodDecelerationLocators.Currency, "840");
		Initilization.WebDriverWait(3);
		Initilization.enter_Text("id", GoodDecelerationLocators.Insurance, "1");
		Initilization.click_On_Button("css", GoodDecelerationLocators.InsuranceCheckbox);
		Initilization.WebDriverWait(3);
		Initilization.enter_Text("id", GoodDecelerationLocators.ExchangeRate, "10");
		Initilization.click_On_Button("css", GoodDecelerationLocators.SaveButton);

		Initilization.WebDriverWait(5);
		Initilization.click_On_Button("css", GoodDecelerationLocators.LnkItems);
		Initilization.WebDriverWait(3);

		Initilization.enter_Text("id", GoodDecelerationLocators.HSCode, "9301.9021");
		Initilization.driver.findElement(By.id(GoodDecelerationLocators.HSCodeTextBox)).sendKeys(Keys.ENTER);
//			

		Initilization.WebDriverWait(3);
		Initilization.enter_Text("id", GoodDecelerationLocators.DeclaredDescription, "9301.9021");

		Initilization.WebDriverWait(2);
		Initilization.enter_Text("id", GoodDecelerationLocators.Quantity, "5");
		Initilization.driver.findElement(By.id(GoodDecelerationLocators.Quantity)).sendKeys(Keys.ENTER);
//				
		Initilization.WebDriverWait(2);
		Initilization.enter_Text("id", GoodDecelerationLocators.Statistical_Purpose, "5");
		Initilization.driver.findElement(By.id(GoodDecelerationLocators.Statistical_Purpose)).sendKeys(Keys.ENTER);
//				
		Initilization.WebDriverWait(2);
		Initilization.enter_Text("id", GoodDecelerationLocators.International_Traded, "5");
		Initilization.driver.findElement(By.id(GoodDecelerationLocators.International_Traded)).sendKeys(Keys.ENTER);
//				
		Initilization.WebDriverWait(2);
		Initilization.enter_Text("id", GoodDecelerationLocators.UnitValue, "10");
		Initilization.driver.findElement(By.id(GoodDecelerationLocators.UnitValue)).sendKeys(Keys.ENTER);
//				
		Initilization.WebDriverWait(2);
		Initilization.dropDown("id", GoodDecelerationLocators.Origion, "4");
		Initilization.driver.findElement(By.id(GoodDecelerationLocators.Origion)).sendKeys(Keys.ENTER);
//				

		Initilization.WebDriverWait(2);
		Initilization.enter_Text("id", GoodDecelerationLocators.UnitPriceInvoice, "10");
		Initilization.driver.findElement(By.id(GoodDecelerationLocators.UnitPriceInvoice)).sendKeys(Keys.ENTER);
//				
		Initilization.WebDriverWait(2);
		Initilization.dropDown("id", GoodDecelerationLocators.ItemImportType, "2");
		Initilization.driver.findElement(By.id(GoodDecelerationLocators.ItemImportType)).sendKeys(Keys.ENTER);
//				
		Initilization.WebDriverWait(2);
		Initilization.click_On_Button("id", GoodDecelerationLocators.SaveBottom1);

		Initilization.WebDriverWait(4);

		String parent1 = driver.getWindowHandle();
		Set<String> s1 = driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I2 = s1.iterator();
		String child_window1;
		try {
			while (I2.hasNext()) {

				child_window1 = I2.next();

				Initilization.WebDriverWait(5);

				if (!parent1.equals(child_window1)) {
					driver.switchTo().window(child_window1);

					System.out.println("\nWindow Switch :: " + driver.switchTo().window(child_window1).getTitle());

					Initilization.click_On_Button("id", GoodDecelerationLocators.ItemStructureDescription1);
					Initilization.WebDriverWait(2);

					Initilization.click_On_Button("id", GoodDecelerationLocators.ItemStructureDescription2);
					Initilization.WebDriverWait(2);

					Initilization.click_On_Button("id", GoodDecelerationLocators.ItemStructureDescription3);
					Initilization.WebDriverWait(2);

					Initilization.click_On_Button("id", GoodDecelerationLocators.ItemStructureDescription4);
					Initilization.WebDriverWait(2);

					Initilization.click_On_Button("id", GoodDecelerationLocators.SaveBottom2);
					Initilization.WebDriverWait(2);

					Initilization.click_On_Button("id", GoodDecelerationLocators.CancelBotton);
					Initilization.WebDriverWait(2);

				}

			}

		} catch (Exception e) {

		}

		// switch to the parent window driver.switchTo().window(parent);
		System.out.println("\nWindow Switch :: " + driver.switchTo().window(parent).getTitle());
		// driver.switchTo().window(parent1);
		driver.switchTo().frame("frame");

		Initilization.WebDriverWait(2);
		Initilization.click_On_Button("id", GoodDecelerationLocators.CancelBotton2);
		Initilization.WebDriverWait(2);

		Initilization.click_On_Button("id", GoodDecelerationLocators.CompleteListBottom);
		Initilization.WebDriverWait(2);

		Initilization.click_On_Button("id", GoodDecelerationLocators.CompleteListBottom);
		Initilization.WebDriverWait(5);

		Initilization.click_On_Button("id", GoodDecelerationLocators.SubmitBottom);
		Initilization.WebDriverWait(4);

		Initilization.click_On_Button("id", GoodDecelerationLocators.TraderDeclaration1);
		Initilization.WebDriverWait(1);

		Initilization.click_On_Button("id", GoodDecelerationLocators.TraderDeclaration2);
		Initilization.WebDriverWait(1);

		Initilization.click_On_Button("id", GoodDecelerationLocators.TraderDeclaration3);
		Initilization.WebDriverWait(1);

		Initilization.click_On_Button("id", GoodDecelerationLocators.TraderDeclaration4);
		Initilization.WebDriverWait(1);

		Initilization.click_On_Button("id", GoodDecelerationLocators.SubmitButton1);
		Initilization.WebDriverWait(3);

		Initilization.dropDown("id", GoodDecelerationLocators.PaymentMode, "2");
		Initilization.WebDriverWait(2);

		Initilization.click_On_Button("css", GoodDecelerationLocators.SubmitBottom2);
		Initilization.WebDriverWait(2);

	}
}
