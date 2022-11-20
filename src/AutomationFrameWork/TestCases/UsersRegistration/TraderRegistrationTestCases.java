package AutomationFrameWork.TestCases.UsersRegistration;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import AutomationFrameWork.Helpers.SubscriptionHelper;
import AutomationFrameWork.Helpers.UserRegistrationHelper;
import AutomationFrameWork.SetupFiles.Initilization;
import Locators.CustomsRegistrationLocators;
import Locators.TraderRegistrationLocators;
import groovy.lang.DelegatesTo.Target;
import net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ParameterDefinition.Initial;

public class TraderRegistrationTestCases extends Initilization {

	public static String userName="UN-00-0949873";
	public static String password="Test@1234";
	public static String BusinessName="MUHAMMAD ISMAIL";
	public static String BusinessAddress="P-1282, WEST CANAL ROAD, ABDULLAHPUR, FAISALABAD, Faisalabad Madina Town";
	public static String UserSubType="Commercial";
	public static String documentPath= Initilization.projectDirectory+"\\Resources\\dwd.png";
	

	@Parameters("browsers")
	@BeforeTest
	
	public static void BeforeTest1(String BrowserName) {
	
		Initilization.BrowsersType = BrowserName;
		Initilization.URL = "https://qa.psw.gov.pk/";
		UserRegistrationHelper.clearUserRegistrationFromDataBase("0949873");
		
	}
	@Test(priority = 1, description = "Login")
	public void Login() {
		Initilization.click_On_Button("xpath", TraderRegistrationLocators.loginBtn);
		Initilization.WebDriverWait(3);
		SubscriptionHelper.Login(userName, password);
		
		
	}
	
	@Test(priority = 2, description = "verify Trader registartion")
	public void ValidateTraderRegistration() {
		
		/* Click on Registration Menu */
		
		Initilization.click_On_Button("xpath", TraderRegistrationLocators.registrationMenu);

		System.out.println("Registration Menu Open Successfully");
		Initilization.WebDriverWait(2);
		
		/* Click on trader button */
		Initilization.click_On_Button("xpath", TraderRegistrationLocators.traderRegistrationButton);
		System.out.println("Trader Registration Form Open Successfully");

		/* Select Business Name */
		Initilization.click_On_Button("css", TraderRegistrationLocators.selectBusinessName);
		Initilization.enter_Text("css", TraderRegistrationLocators.selectBusinessName,
				BusinessName+ Keys.ENTER);


		Initilization.click_On_Button("xpath", TraderRegistrationLocators.submitButton);
		/* Select business address */
		Initilization.click_On_Button("css", TraderRegistrationLocators.selectBusinessAddress);
		Initilization.enter_Text("css", TraderRegistrationLocators.selectBusinessAddress,
				BusinessAddress + Keys.ENTER);

		Initilization.click_On_Button("xpath", TraderRegistrationLocators.submitButton);

		/* Select User SubType */
		
		Initilization.click_On_Button("id", TraderRegistrationLocators.selectUserSubType);
		Initilization.enter_Text("id", TraderRegistrationLocators.selectUserSubType,UserSubType+ Keys.ENTER);

		Initilization.click_On_Button("xpath", TraderRegistrationLocators.submitButton);

		/* Upload document */
		
		Initilization.enter_Text("name", TraderRegistrationLocators.chooseFiles,
				documentPath);
		Initilization.WebDriverWait(2);
		

		/* Click on submit button */
		
		Initilization.click_On_Button("xpath", TraderRegistrationLocators.submitButton);
		Initilization.WebDriverWait(3);
		

		/* Apply Assertion on "Trader successfully registered" message */
		
		String actual=Initilization.Get_Bar_Validation_Msg("xpath", TraderRegistrationLocators.successAlert);
		Initilization.HardAssertion(null, null, actual, "You are successfully registered as a Trader.");

	}

	@Test(priority = 3, description = "Verify Trader specific menus appear on dashboard")
	public void validateTraderSpecificMenusAppear() {
	
		/* Click on Home Menu */
		Initilization.click_On_Button("xpath", TraderRegistrationLocators.homeMenu);
		Initilization.WebDriverWait(2);
		System.out.println("Home Menu Open Successfully");

		/* Apply assertion on trader specific menu */
		
		//String traderSpecificMenu = Initilization.get_Text("xpath", TraderRegistrationLocators.TraderMessagesMenu);

		Initilization.HardAssertion("xpath", TraderRegistrationLocators.TraderMessagesMenu,null, "Trader Messages");
		

	}

	@Test(priority = 4, description = "Verify Pin menus appear")

	public void validatePinnedMenusAppear() {
		

		WebElement hoverOnTraderMessagesMenu = Initilization.webElement("xpath",
				TraderRegistrationLocators.hoverOnTradermessagesMenu);

		Actions action = new Actions(driver);
		action.moveToElement(hoverOnTraderMessagesMenu).perform();

		Initilization.WebDriverWait(1);
		Initilization.click_On_Button("id", TraderRegistrationLocators.pinTraderMessagesButton);
		Initilization.WebDriverWait(1);

		/* Pin Recoveries menu */

		WebElement hoverOnRecoveriesMenu = Initilization.webElement("xpath",
				TraderRegistrationLocators.hoverOnRecoveriesMenu);
		action.moveToElement(hoverOnRecoveriesMenu).perform();

		Initilization.WebDriverWait(1);
		Initilization.click_On_Button("id", TraderRegistrationLocators.pinRecoveriesButton);
		Initilization.WebDriverWait(2);

		//String pinnedTraderMenus = Initilization.get_Text("xpath", TraderRegistrationLocators.traderMessagesMenu);
		
		Initilization.HardAssertion("xpath", TraderRegistrationLocators.traderMessagesMenu,null, "Trader Messages");
		
		//Assert.assertEquals(pinnedTraderMenus, "Trader Messages");

		//String pinnedRecoveriesMenus = Initilization.get_Text("xpath", TraderRegistrationLocators.recoveriesMenu);
		Initilization.HardAssertion("xpath", TraderRegistrationLocators.recoveriesMenu,null, "Recoveries");
		//Assert.assertEquals(pinnedRecoveriesMenus, "Recoveries");

	}

	@Test(priority = 5, description = "Verify Unpin menu disappear from the side bar")

	public void validateUnpinnedMenusDisappear() {
		
		WebElement hoverOnTraderMessagesMenu = Initilization.webElement("xpath",
				TraderRegistrationLocators.traderMessagesMenu);

		Actions action = new Actions(driver);
		action.moveToElement(hoverOnTraderMessagesMenu).perform();
		Initilization.WebDriverWait(1);
		Initilization.click_On_Button("id", TraderRegistrationLocators.traderMessageUnpinBtn);
		Initilization.WebDriverWait(2);

		
		//hover on recoveries menu
		WebElement hoverOnRecoveriesMenu = Initilization.webElement("xpath", TraderRegistrationLocators.recoveriesMenu);
		action.moveToElement(hoverOnRecoveriesMenu).perform();
		Initilization.WebDriverWait(1);
		
		
		//Click on Recoveries Un-pin button
		Initilization.click_On_Button("id", TraderRegistrationLocators.recoveriesUnpinBtn);
		Initilization.WebDriverWait(3);
		
	
		

	}
	@Test(priority = 6, description = "Verify search menu open")
	public void searchAndOpenMenus() {
		
		//click on search field
		Initilization.WebDriverWait(1);
		Initilization.click_On_Button("xpath", CustomsRegistrationLocators.searchField);
		
		//Sendkeys on search field
		Initilization.WebDriverWait(1);
		Initilization.enter_Text("xpath",CustomsRegistrationLocators.searchField, "Authorize customs agent");
		Initilization.WebDriverWait(1);
		
		//click on search result
		Initilization.click_On_Button("xpath", TraderRegistrationLocators.searchResult);
		Initilization.WebDriverWait(4);
		
		//verify search menu should be open
		Initilization.HardAssertion("xpath", TraderRegistrationLocators.openMenuTitle, null, "Authorize Customs Agent");
		Initilization.click_On_Button("xpath", CustomsRegistrationLocators.homeMenu);
	}

	@Test(priority = 7)
	public void Logout() {
		
		//Logout
		Initilization.click_On_Button("xpath", TraderRegistrationLocators.clickOnUserName);
		Initilization.click_On_Button("xpath", TraderRegistrationLocators.logoutBtn);
	}
}
