package Locators;

public class TraderRegistrationLocators {

	// Trader registration form locators
	public static String loginBtn="//button[normalize-space()='Login']";
	public static String registrationMenu = "//div[@class='d-flex col']";
 	public static String traderRegistrationButton = "//div[@class='pl-3 mb-4 mt-2']//div[@id='TR']";
 	public static String selectBusinessName = "#dllBusinessName";
 	public static String selectBusinessAddress="#dllBusinessAddress";
 	public static String selectUserSubType= "dllUserSubType";
	public static String selectCity= "dllCity";
 	public static String chooseFiles= "files";
 	public static String submitButton= "//button[normalize-space()='Submit']";
 	public static String successAlert= "//div[@role='alert']";
 	
 	// Home menu and card menus locators
 	
 	public static String homeMenu= "//div[@class='list-group']//a[@id='Home']";
 	public static String TraderMessagesMenu = "//p[normalize-space()='Trader Messages']";
	public static String GoodsDeclarationMenu = "//p[normalize-space()='Goods Declaration']";
 	public static String hoverOnTradermessagesMenu = "//p[normalize-space()='Trader Messages']";
 	public static String hoverOnRecoveriesMenu="//p[normalize-space()='Recoveries']";
 	public static String pinTraderMessagesButton="pin-Trader Messages";
 	public static String pinRecoveriesButton="pin-Recoveries";
 	
 	//Side bar menus and un-pin button locators
 	
 	public static String traderMessagesMenu="//div[@class='list-group']//a[@id='Trader Messages']";
 	public static String recoveriesMenu="//span[@class='menu-item-title pt-1 pb-1 pr-1'][normalize-space()='Recoveries']";
 	public static String traderMessageUnpinBtn="pin-Trader Messages";
 	public static String recoveriesUnpinBtn="pin-Recoveries";
 	public static String clickOnUserName="//span[@class='mr-1']";
 	public static String logoutBtn="//a[contains(text(),'Logout')]";
 	
 	//Search field loc-ators 
 	public static String searchField="//input[@id='txtTopSearch']";
 	public static String searchResult="//a[@class='result']";
 	public static String openMenuTitle="//p[@class='title']";

}
