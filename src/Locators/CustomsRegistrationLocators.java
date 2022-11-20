package Locators;

public class CustomsRegistrationLocators {
	
	
 	//Customs agent registration form locators
	public static String loginBtn="//button[normalize-space()='Login']";
	public static String registrationMenu = "//div[@class='d-flex col']";
	
	public static String newAgentRegistration="//button[normalize-space()='New registration']";
	public static String customsAgentRegistrationButton = "//span[@aria-label='Customs Agent']";
 	
	
	public static String selectBusinessName = "#dllBusinessName";
 	public static String selectBusinessAddress="#dllBusinessAddress";
 	public static String txtCollactorate="//input[@id='txtCollectorate']";
 	public static String txtChallanNumber="//input[@id='txtChallanNumber']";
 	public static String btnValidateLicense="//button[normalize-space()='Validate']";
 	public static String checkValidation=" div:nth-child(9) > div > div > span";
 	public static String chooseFiles= "files";
 	public static String submitButton= "//button[normalize-space()='Submit']";
 	public static String successAlert= "alert-success";
 	
 	//Home button and card menus locators
 	
 	public static String homeMenu= "//div[@class='list-group']//a[@id='Home']";
 	public static String customsAgentSpecificMenu="//p[normalize-space()='Appeals']";
 	public static String trackDeclaration="//p[normalize-space()='Track Declarations']";
 	public static String appeals="//p[normalize-space()='Appeals']";
 	public static String pinBtnAppeals="pin-Appeals";
 	public static String pinBtnTrackDec="pin-Track Declarations";
 	
 	//Side bar menus locators 
 	
 	public static String sidebarAppeal="//span[@class='menu-item-title pt-1 pb-1 pr-1'][normalize-space()='Appeals']";
 	public static String sidebarTrackDec="//div[@class='list-group']//a[@id='Track Declarations']";
 	public static String unpinSidebarAppeal="pin-Appeals";
 	public static String unpinSidebarTrack="pin-Track Declarations";
 	
 	//Search field locators
 	
 	public static String searchField="//input[@id='txtTopSearch']";
 	public static String searchResult="//a[@class='result']";
 	public static String openMenutitle="//p[@class='title']";
}
