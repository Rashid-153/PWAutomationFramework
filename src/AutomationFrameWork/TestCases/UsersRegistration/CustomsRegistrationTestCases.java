package AutomationFrameWork.TestCases.UsersRegistration;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.Log;

import AutomationFrameWork.Helpers.SubscriptionHelper;
import AutomationFrameWork.Helpers.UserRegistrationHelper;
import AutomationFrameWork.SetupFiles.Initilization;
import AutomationFrameWork.SetupFiles.Listeners;
import Locators.CustomsRegistrationLocators;
import Locators.TraderRegistrationLocators;
import groovyjarjarantlr4.v4.runtime.tree.xpath.XPath;

import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomsRegistrationTestCases extends Initilization {

	public static String userName="UN-00-0949873";
	public static String password="Test@1234";
	public static String BusinessName="MUHAMMAD ISMAIL";
	public static String BusinessAddress="P-1282, WEST CANAL ROAD, ABDULLAHPUR, FAISALABAD, Faisalabad Madina Town";
	public static String documentPath = Initilization.projectDirectory+"\\Resources\\dwd.png";

	@Parameters("browsers")
	@BeforeTest

	public static void BeforeTest1(String BrowserName) {

		Initilization.BrowsersType = BrowserName;
		Initilization.URL = "https://qa.psw.gov.pk/";
		UserRegistrationHelper.clearUserRegistrationFromDataBase("0949873");

	}

	@Test(priority = 1, description = "Login")
	public void Login() {
		Initilization.click_On_Button("xpath", CustomsRegistrationLocators.loginBtn);
		Initilization.WebDriverWait(3);
		SubscriptionHelper.Login(userName, password);

	}

	@Test(priority = 2, description = "")
	public void ValidateCustomsRegistration() throws IOException {

		/* Click on Registration Menu */

		Initilization.click_On_Button("xpath", CustomsRegistrationLocators.registrationMenu);

		Initilization.WebDriverWait(2);

		Initilization.click_On_Button("xpath", CustomsRegistrationLocators.customsAgentRegistrationButton);

		/* object user for filling form */
		fillDetail("KCUS", "4");

		/* Apply Assertion on "Customs agent successfully registered" success message */

		Initilization.WebDriverWait(3);
		String actual=Initilization.Get_Bar_Validation_Msg("xpath", TraderRegistrationLocators.successAlert);
		Initilization.HardAssertion(null, null, actual, "You are successfully registered as a customs agent.");
		
		Initilization.WebDriverWait(3);
		Initilization.click_On_Button("xpath",CustomsRegistrationLocators.homeMenu);
	}

	
	
	@Test(priority = 3, description = "Verify with different license number",enabled = true)
	public void ValidateCustomsRegistrationWithDiff_License(){
		

		Initilization.click_On_Button("xpath", CustomsRegistrationLocators.registrationMenu);

		Initilization.WebDriverWait(2);

		Initilization.click_On_Button("xpath", CustomsRegistrationLocators.customsAgentRegistrationButton);

		Initilization.click_On_Button("xpath",CustomsRegistrationLocators.newAgentRegistration);
		
		fillDetail("LCUS", "9010406");

		/* Apply Assertion on "Customs agent successfully registered" success message */

		String actual=Initilization.Get_Bar_Validation_Msg("xpath", TraderRegistrationLocators.successAlert);
		Initilization.HardAssertion(null, null, actual, "You are successfully registered as a customs agent.");
		
		Initilization.click_On_Button("xpath",CustomsRegistrationLocators.homeMenu);
	}
	@Test(priority = 4, description = "Verify with same license number")
	public void ValidateCustomsRegistrationWithSame_License(){
		

		Initilization.click_On_Button("xpath", CustomsRegistrationLocators.registrationMenu);

		Initilization.WebDriverWait(2);

		Initilization.click_On_Button("xpath", CustomsRegistrationLocators.customsAgentRegistrationButton);

		Initilization.click_On_Button("xpath",CustomsRegistrationLocators.newAgentRegistration);
		
		fillDetail("LCUS", "9010406");

		/* Apply Assertion on "Customs agent successfully registered" success message */

		String actual=Initilization.Get_Bar_Validation_Msg("xpath", TraderRegistrationLocators.successAlert);
		Initilization.HardAssertion(null, null, actual, "Registration record already exists");
		
		
	}
	@Test(priority = 5, description = "Verify Customs agent menus appear")
	public void validateCustomsAgentSpecificMenusAppear() {

		/* Click on Home Menu */
		Initilization.click_On_Button("xpath", CustomsRegistrationLocators.homeMenu);
		Initilization.WebDriverWait(2);
		Listeners.logger.log(LogStatus.INFO, "Home menus open successfully");

		/* Apply assertion on Customs agent specific menus */

		Initilization.HardAssertion("xpath", CustomsRegistrationLocators.customsAgentSpecificMenu,null, "Appeals");
		Initilization.WebDriverWait(2);
		Initilization.HardAssertion("xpath", CustomsRegistrationLocators.trackDeclaration,null,  "Track Declarations");

	}
	
	@Test(priority = 6, description = "Verify Pin menus appear on sidebar")
	public void validatePinnedMenusAppear() {

		/* Pin Appeals menu */
		//Hover on Appeals menus
		WebElement hoverOnAppealsMenu = Initilization.webElement("xpath", CustomsRegistrationLocators.appeals);
		Actions action = new Actions(driver);
		action.moveToElement(hoverOnAppealsMenu).perform();
		
		
		//Click on Appeals Pin button
		
		 Initilization.WebDriverWait(1);
		 Initilization.click_On_Button("id",CustomsRegistrationLocators.pinBtnAppeals);
		 Initilization.WebDriverWait(1);
		
		/* Pin Recoveries menu */
		//Hover on Track declarations menus
		WebElement hoverOnTrackDecMenu = Initilization.webElement("xpath",
				CustomsRegistrationLocators.trackDeclaration);
		action.moveToElement(hoverOnTrackDecMenu).perform();

		//Click on Track declarations Pin button
		Initilization.WebDriverWait(1);
		Initilization.click_On_Button("id", CustomsRegistrationLocators.pinBtnTrackDec);
		Initilization.WebDriverWait(2);

		// Verify Appeals pin menus appear on side bar
		Initilization.HardAssertion("xpath", CustomsRegistrationLocators.sidebarAppeal,null,  "Appeals");

		// Verify Track declarations pin menus appear on side bar 
		Initilization.HardAssertion("xpath", CustomsRegistrationLocators.sidebarTrackDec,null,  "Track Declarations");
		
	}
	@Test(priority = 7, description = "Verify unpin menus disappear from the sidebar")

	public void validateUnpinnedMenusDisappear() {
		
		//Hover on side bar Appeal menu
		WebElement hoverOnAppealMenu = Initilization.webElement("xpath",CustomsRegistrationLocators.sidebarAppeal);
		Actions action = new Actions(driver);
		action.moveToElement(hoverOnAppealMenu).perform();
		Initilization.WebDriverWait(1);
		
		//click on Appeal menu un-pin  button 
		Initilization.click_On_Button("id", CustomsRegistrationLocators.unpinSidebarAppeal);
		Initilization.WebDriverWait(2);

		//Hover on side bar track declaration menu
		WebElement hoverOnTrackDecMenu = Initilization.webElement("xpath", CustomsRegistrationLocators.sidebarTrackDec);
		action.moveToElement(hoverOnTrackDecMenu).perform();
		Initilization.WebDriverWait(1);
		
		//click on track declaration unpin button
		Initilization.click_On_Button("id", CustomsRegistrationLocators.unpinSidebarTrack);
		Initilization.WebDriverWait(3);
		
	
		

	}
	@Test(priority = 8, description = "Verify search field w")
	public void searchAndOpenMenus() {
		
		//click on search field
		Initilization.WebDriverWait(1);
		Initilization.click_On_Button("xpath", CustomsRegistrationLocators.searchField);
		
		//Sendkeys on search field
		Initilization.WebDriverWait(1);
		Initilization.enter_Text("xpath",CustomsRegistrationLocators.searchField, "track declarations");
		Initilization.WebDriverWait(1);
		
		//click on search result
		Initilization.click_On_Button("xpath", CustomsRegistrationLocators.searchResult);
		Initilization.WebDriverWait(4);
		
		//verify search menu should be open
		Initilization.HardAssertion("xpath", CustomsRegistrationLocators.openMenutitle,null,  "Track Declarations");
		Initilization.click_On_Button("xpath", CustomsRegistrationLocators.homeMenu);
	}

	@Test(priority = 9)

	public void Logout() {
		
		//Logout
		Initilization.click_On_Button("xpath", TraderRegistrationLocators.clickOnUserName);
		Initilization.click_On_Button("xpath", TraderRegistrationLocators.logoutBtn);
		
		
	}

	public void fillDetail(String collectorate, String challanNumber) {
		Initilization.click_On_Button("css", CustomsRegistrationLocators.selectBusinessName);
		Initilization.enter_Text("css", CustomsRegistrationLocators.selectBusinessName, BusinessName + Keys.ENTER);

		Initilization.click_On_Button("xpath", CustomsRegistrationLocators.submitButton);

		/* Select business address */
		Initilization.click_On_Button("css", CustomsRegistrationLocators.selectBusinessAddress);
		Initilization.enter_Text("css", CustomsRegistrationLocators.selectBusinessAddress,
				BusinessAddress + Keys.ENTER);

		Initilization.click_On_Button("xpath", CustomsRegistrationLocators.submitButton);
		
		//Enter parent collectorate and license number
		Initilization.enter_Text("xpath", CustomsRegistrationLocators.txtCollactorate, collectorate);
		Initilization.enter_Text("xpath", CustomsRegistrationLocators.txtChallanNumber, challanNumber);
		
		//Click on validate button
		Initilization.click_On_Button("xpath", CustomsRegistrationLocators.btnValidateLicense);
		Initilization.WebDriverWait(2);
		
		//apply assertion on license validation
		WebElement abc = driver.findElement(By.cssSelector(CustomsRegistrationLocators.checkValidation));
		String getValue = abc.getAttribute("title");
		String expected = "License successfully validated";
		if (expected.equalsIgnoreCase(getValue)) {
			Listeners.assertOnSuccess(getValue, expected);
			Assert.assertEquals(getValue, expected);
		} else {
			Listeners.assertOnFail(getValue, expected);
			System.out.println("Validation Failed");
			Assert.assertEquals(getValue, expected);
		}

		Initilization.click_On_Button("xpath", CustomsRegistrationLocators.submitButton);
		
		//Choose and upload file
		Initilization.enter_Text("name", TraderRegistrationLocators.chooseFiles, documentPath);
		Initilization.WebDriverWait(2);

		//click on submit button
		Initilization.click_On_Button("xpath", TraderRegistrationLocators.submitButton);

	}
}
