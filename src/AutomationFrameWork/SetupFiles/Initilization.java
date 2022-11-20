package AutomationFrameWork.SetupFiles;


import java.io.File;
import java.io.IOException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

//import static AutomationFrameWork.SetupFiles.Initilization.logger;
//import static AutomationFrameWork.SetupFiles.Initilization.report;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.beust.jcommander.internal.Nullable;

import com.relevantcodes.extentreports.LogStatus;

import static io.restassured.RestAssured.*;

//import Locators.ImportPermitLocators;



/**
 * @author PSW-KHI-0004
 *
 */
/**
 * @author PSW-KHI-0004
 *
 */
public class Initilization {

	public static WebDriver driver;
	public static String BrowsersType;
	public static String URL;
	public static WebDriverWait wait;
	public static String TestCaseName;

	public static String Environment = "qa";
	public static String ConnectionString = "10.1.4.54";
	public static String username = "Ebad.zaheer";
	public static String password = "pral@1234";
	public static String methodNameUsingClassInstance;
	public static String projectDirectory = System.getProperty("user.dir");

	@BeforeMethod
	public void BeforeMethod(ITestResult result) throws IOException {

		methodNameUsingClassInstance = result.getMethod().getMethodName()+ ":" + result.getMethod().getDescription();
	 
		Listeners.logger = Listeners.extent.startTest(methodNameUsingClassInstance);

	}

	/* Old Method using .exe File to launch browser -- SHABBIR 
	 * @BeforeClass public static void setup() throws IOException {
	 * 
	 * RestAssured.useRelaxedHTTPSValidation();
	 * 
	 * if (BrowsersType.equalsIgnoreCase("firefox")) {
	 * System.setProperty("webdriver.gecko.driver", projectDirectory +
	 * "\\Resources\\geckodriver.exe"); driver = new FirefoxDriver();
	 * Reporter.log("Browser Opened"); Listeners.logger.log(LogStatus.INFO,
	 * "Firefox Browser started ");
	 * 
	 * driver.get(URL); Reporter.log("Application");
	 * Listeners.logger.log(LogStatus.PASS, "Application Opened"); } else if
	 * (BrowsersType.equalsIgnoreCase("chrome")) {
	 * 
	 * System.setProperty("webdriver.chrome.driver", projectDirectory +
	 * "\\Resources\\chromedriver.exe");
	 * 
	 * ChromeOptions opt = new ChromeOptions();
	 * opt.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,
	 * UnexpectedAlertBehaviour.ACCEPT);
	 * opt.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
	 * opt.addArguments("--ignore-ssl-errors=yes");
	 * opt.addArguments("--ignore-certificate-errors");
	 * 
	 * driver = new ChromeDriver(opt); // driver = new ChromeDriver();
	 * 
	 * Reporter.log("Browser Opened"); Listeners.logger.log(LogStatus.INFO,
	 * "Chrome Browser started "); driver.manage().window().maximize();
	 * driver.get(URL); Reporter.log("Application");
	 * Listeners.logger.log(LogStatus.PASS, "Application Opened");
	 * 
	 * Reporter.log("Application Opened Opened");
	 * 
	 * } else if (BrowsersType.equalsIgnoreCase("IE")) {
	 * System.setProperty("webdriver.ie.driver",
	 * "C:\\SeleniumDriverServer\\IEDriverServer.exe"); driver = new
	 * InternetExplorerDriver(); Reporter.log("Browser Opened");
	 * Listeners.logger.log(LogStatus.INFO, "IE Browser started ");
	 * 
	 * driver.get(URL); Reporter.log("Application");
	 * Listeners.logger.log(LogStatus.PASS, "Application Opened");
	 * Reporter.log("Application Opened Opened"); }
	 * 
	 * }
	 */
	
	// New Method using Direct Maven Dependency to launch browser -- SHABBIR 
	  @BeforeClass public static void setup() throws IOException {
	  
	  RestAssured.useRelaxedHTTPSValidation();
	  
	  if (BrowsersType.equalsIgnoreCase("firefox")) {
	  System.setProperty("webdriver.gecko.driver", projectDirectory +
	  "\\Resources\\geckodriver.exe"); driver = new FirefoxDriver();
	  Reporter.log("Browser Opened"); Listeners.logger.log(LogStatus.INFO,
	  "Firefox Browser started ");
	  
	  driver.get(URL); Reporter.log("Application");
	  Listeners.logger.log(LogStatus.PASS, "Application Opened"); } 
	  
	  else if
	  (BrowsersType.equalsIgnoreCase("chrome")) {
	  
          WebDriverManager.chromedriver().setup();
        //  driver = new ChromeDriver();
	  
	  ChromeOptions opt = new ChromeOptions();
	  opt.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,
	  UnexpectedAlertBehaviour.ACCEPT);
	  opt.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
      //opt.addArguments("--headless", "--window-size=1920,1200");
	  opt.addArguments("--ignore-ssl-errors=yes");
	  opt.addArguments("--ignore-certificate-errors");
	  
	  driver = new ChromeDriver(opt); // driver = new ChromeDriver();
	  
	  Reporter.log("Browser Opened"); Listeners.logger.log(LogStatus.INFO,
	  "Chrome Browser started "); driver.manage().window().maximize();
	  driver.get(URL); Reporter.log("Application");
	  Listeners.logger.log(LogStatus.PASS, "Application Opened");
	  
	  Reporter.log("Application Opened Opened");
	  
	  } else if (BrowsersType.equalsIgnoreCase("IE")) {
	  System.setProperty("webdriver.ie.driver",
	  "C:\\SeleniumDriverServer\\IEDriverServer.exe"); driver = new
	  InternetExplorerDriver(); Reporter.log("Browser Opened");
	  Listeners.logger.log(LogStatus.INFO, "IE Browser started ");
	  
	  driver.get(URL); Reporter.log("Application");
	  Listeners.logger.log(LogStatus.PASS, "Application Opened");
	  Reporter.log("Application Opened Opened"); }
	  
	  }
	 
	
	
	

	// this method is used  to set locator type e.g ID,NAME etc and its value
	public static By locatorValue(String locatorType, String value) {
		By by;
		switch (locatorType) {
			case "id":
				by = By.id(value);
				break;
			case "name":
				by = By.name(value);
				break;
			case "xpath":
				by = By.xpath(value);
				break;
			case "css":
				by = By.cssSelector(value);
				break;
			case "linkText":
				by = By.linkText(value);
				break;
			case "partialLinkText":
				by = By.partialLinkText(value);
				break;
			default:
				by = null;
				break;
		}
		return by;
	}

	// WebElement SendKeys Method
	public static void enter_Text(String locatorType, String value, String text) {

		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			// scrolling until the element is visible
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			element.sendKeys(text);

		} catch (Exception e) {
			Listeners.onFail("<b>Enter Text Failed</b>", locatorType, value, text);
			System.err.format("No Element Found to enter text" + e);
			// driver.close();
		}

		try {
			Thread.sleep(100);
			Listeners.onSuccess("<b>Enter Text Successfully</b>", locatorType, value, text);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String getText(String value) {
		String abc;
		abc = driver.findElement(By.id(value)).getText();
		return abc;
	}

	/**
	 * @param locatorType
	 * @param value
	 * @return
	 */
	public static String get_Text(String locatorType, String value) {
		String getFieldText;
		if (locatorType == "id") {
			getFieldText = driver.findElement(By.id(value)).getText();

		} else if (locatorType == "xpath") {
			getFieldText = driver.findElement(By.xpath(value)).getText();
		} else if (locatorType == "css") {
			getFieldText = driver.findElement(By.cssSelector(value)).getText();
		} else if (locatorType == "name") {
			getFieldText = driver.findElement(By.name(value)).getText();
		} else if (locatorType == "className") {
			getFieldText = driver.findElement(By.className(value)).getText();
		} else if (locatorType == "tagName") {
			getFieldText = driver.findElement(By.tagName(value)).getText();
		} else if (locatorType == "linkText") {
			getFieldText = driver.findElement(By.linkText(value)).getText();
		} else {
			return "No element found";
		}

		return getFieldText;
	}

	/**
	 * @param locatorType
	 * @param value
	 * @return
	 */
	public static WebElement webElement(String locatorType, String value) {
		WebElement getElement = null;
		if (locatorType == "id") {
			getElement = driver.findElement(By.id(value));

		} else if (locatorType == "xpath") {
			getElement = driver.findElement(By.xpath(value));
		} else if (locatorType == "css") {
			getElement = driver.findElement(By.cssSelector(value));
		} else if (locatorType == "name") {
			getElement = driver.findElement(By.name(value));
		} else if (locatorType == "className") {
			getElement = driver.findElement(By.className(value));
		} else if (locatorType == "tagName") {
			getElement = driver.findElement(By.tagName(value));
		} else if (locatorType == "linkText") {
			getElement = driver.findElement(By.linkText(value));
		} else {
			System.out.println("No WebElement Found");

		}

		return getElement;
	}

	/**
	 * @param locatorType
	 * @param value
	 */
	public static void click_On_Link(String locatorType, String value) {
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			// scrolling until the element is visible
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			element.click();
		} catch (Exception e) {
			System.err.format("No Element Found to enter text" + e);

			// Call listener method on test fail.
			Listeners.onFail("<b>Click Failed</b>", locatorType, value, " -Locator Not Found!!");
			System.err.format("No Element Found to enter text" + e);

		}
		try {
			// thread to sleep for 1000 milliseconds
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	/**
	 * @param locatorType
	 * @param value
	 */
	public static void click_On_Button(String locatorType, String value) {
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			// scrolling until the element is visible
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			element.click();
			// Call listener method on clicked Pass.
			Listeners.onSuccess("<b>Clicked Successfully</b>", locatorType, value, "-Button");
		} catch (Exception e) {
			System.err.format("No Element Found to perform click" + e);
			// Call listener method on test fail.
			Listeners.onFail("<b>Click Failed</b>", locatorType, value, " -Locator Not Found!!");
			System.err.format("No Element Found to enter text" + e);

		}


	}

	public static void Submit_On_Button(String locatorType, String value) {
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			// scrolling until the element is visible
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			element.submit();
			// Call listener method on clicked Pass.
			Listeners.onSuccess("<b>Submit Successfully</b>", locatorType, value, "-Button");
		} catch (Exception e) {
			System.err.format("No Element Found to perform click" + e);
			// Call listener method on test fail.
			Listeners.onFail("<b>Submit Failed</b>", locatorType, value, " -Locator Not Found!!");
			System.err.format("No Element Found to enter text" + e);

		}


	}


	public static void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
	}

	public static void scrollUp() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
	}

	public static void click_On_Button_Action(String locatorType, String value) {
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			// scrolling until the element is visible
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().build().perform();

			// Call listener method on clicked Pass.
			Listeners.onSuccess("<b>Clicked Successfully</b>", locatorType, value, "-Button");
		} catch (Exception e) {
			System.err.format("No Element Found to perform click" + e);
			// Call listener method on test fail.
			Listeners.onFail("<b>Click Failed</b>", locatorType, value, " -Locator Not Found!!");
			System.err.format("No Element Found to enter text" + e);

		}

	}

	/**
	 * @param locatorType
	 * @param value
	 */
	public static void click_On_CheckBox(String locatorType, String value) {
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			// scrolling until the element is visible
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			element.click();
			// Call listener method on test Pass.
			Listeners.onSuccess("<b>Clicked on Checkbox Successfully</b>", locatorType, value, "CheckBox");
		} catch (Exception e) {
			System.err.format("No Element Found to perform click" + e);
			// Call listener method on test fail.
			Listeners.onFail("<b>Click on CheckBox Failed</b>", locatorType, value, " -Locator Not Found!!");
			System.err.format("No Element Found to enter text" + e);

		}

	}

	/**
	 * @param locatorType
	 * @param value
	 */
	public static void click_On_RadioButton(String locatorType, String value) {
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			// scrolling until the element is visible
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			element.click();
		} catch (Exception e) {
			System.err.format("No Element Found to perform click" + e);
			// Call listener method on test fail.
			Listeners.onFail("<b>Click on Radio button failed</b>", locatorType, value, " -Locator Not Found!!");
			System.err.format("No Element Found to enter text" + e);

			// driver.close();

		}

	}

	/**
	 * @param locatorType
	 * @param value
	 * @param Dd_Type
	 * @param dD_Value
	 */
	public static void select_From_Dd(String locatorType, String value, String Dd_Type, String dD_Value) {

		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);

			Select dropdown = new Select(element);
			// scrolling until the element is visible
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			if (Dd_Type == "text") {
				dropdown.selectByVisibleText(dD_Value);
			} else if (Dd_Type == "index") {
				dropdown.selectByIndex(1);
			} else if (Dd_Type == dD_Value) {
				dropdown.selectByValue(dD_Value);
			}
		} catch (Exception e) {
			System.err.format("No Element Found to perform click" + e);
			// Call listener method on test fail.
			Listeners.onFail("<b>Select field selection failed</b> ", locatorType, value, "Locator Not Found");
			System.err.format("No Element Found to enter text" + e);

			// driver.close();

		}
	}

	public static String getAppUrl() {
		String url = driver.getCurrentUrl();
		return url;
	}

	public static void DriverClose() {
		driver.quit();

	}

	/**
	 * @param locatorType
	 * @param value
	 * @param ActualResult
	 * @param ExpectedResult
	 */

	public static void HardAssertion(@Nullable String locatorType, @Nullable String value, String ActualResult,
									 String ExpectedResult) {

		if (locatorType != null) {
			By locator;

			locator = locatorValue(locatorType, value);
			String element = driver.findElement(locator).getText();
			System.out.println("Actual:" + element + "\nExpected:" + ExpectedResult);
			Assert.assertEquals(element, ExpectedResult);
			if (element.equalsIgnoreCase(ExpectedResult)) {
				// call listener method on assert pass
				Listeners.assertOnSuccess(element, ExpectedResult);
				Assert.assertEquals(element, ExpectedResult);
			} else {
				Listeners.assertOnFail(element, ExpectedResult);
				Assert.assertEquals(element, ExpectedResult);
			}

		} else {
			Assert.assertEquals(ActualResult, ExpectedResult);
			if (ActualResult.equalsIgnoreCase(ExpectedResult)) {
				// call listener method on assert pass
				Listeners.assertOnSuccess(ActualResult, ExpectedResult);
				Assert.assertEquals(ActualResult, ExpectedResult);
			} else {
				// Call listener method on test fail.
				Listeners.assertOnFail(ActualResult, ExpectedResult);
				Assert.assertEquals(ActualResult, ExpectedResult);
			}

		}

	}

	/**
	 * This Method is used for PaymentStatus Update
	 *
	 * @param APIUrl = For API URL
	 * @param PSID   data Created by Haris Khan Update by Muhammad Maaz
	 * @return
	 */
	public static String UpdatePaymentStatus(String APIUrl, String PSID) {
		RestAssured.baseURI = APIUrl;

		Response res = given().contentType("application/json").

				body("{\r\n" + "    \"methodId\": \"1411\",\r\n" + "    \"data\": {\r\n"
						+ "        \"username\" : \"onelink\",\r\n" + "        \"password\" : \"@PSW#1947\",\r\n"
						+ "        \"psid\" : \"" + PSID + "\",\r\n"
						+ "        \"transaction_auth_id\" : \"112233\",\r\n"
						+ "        \"transaction_amount\" : \"0000000050000\",\r\n"
						+ "        \"tran_time\" : \"120911\",\r\n" + "        \"tran_date\" : \"20220329\",\r\n"
						+ "        \"bank_mnemonic\" : \"UBL\",\r\n"
						+ "        \"reserved\" : \"PSID20210126024932|1122332|PSW:58400;GST:13600;FE:8000;\"\r\n"
						+ "    },\r\n" + "    \"signature\": \"\",\r\n" + "    \"pagination\": {\r\n"
						+ "        \"offset\": 10,\r\n" + "        \"size\": 10,\r\n"
						+ "        \"sortColumn\": \"\",\r\n" + "        \"sortOrder\": \"\"\r\n" + "    }\r\n" + "}"

				).when().post("");

		String body = res.getBody().jsonPath().getString("message.description");
		System.out.println(body);
		// return body;

		return body;

	}
	public static void logout() {
		// This Line will click on LogOut Button
		Initilization.click_On_Button("xpath", "(//button[@aria-haspopup='true'] )[2]");

		Initilization.WebDriverWait(3);
		Initilization.click_On_Button("xpath", "(//*[normalize-space(text()) = 'Logout'])[1]");
		Initilization.WebDriverWait(3);
	}

	public static String GetUserToken(String NTN)
    {
        RestAssured.baseURI = "https://"+Initilization.Environment+".psw.gov.pk/auth/connect/token";

		Response res = given().contentType("application/x-www-form-urlencoded; charset=utf-8")
        .formParam("grant_type", "password")
        .formParam("username", "UN-00-"+NTN)
        .formParam("password", "Test@1234")
        .formParam("client_id", "psw.client.spa").when()
        .post("");
		String body = res.getBody().jsonPath().getString("access_token");
		System.out.println("TOKEN GENERATED :: "+body);	
        String token =body; 
		return token;
        // if(token!=null)
        // {
        //     return token;
        // }
        // else {  System.out.println("Cannot Generate Token Either Server is down or User not exist");        
        //     return "Cannot Generate Token Either Server is down or User not exist"; }
 
    }
	/**
	 * This Method is used for PaymentStatus Update
	 *
	 * @param APIUrl = For API URL
	 * @param PSID   = PSID 
	 * @param AMount = Amount  
	 * @return
	 * data Created by Muhammad Maaz
	 */
	
	public static String UpdatePaymentStatus(String APIUrl, String PSID,String Amount) {
		//RestAssured.baseURI = APIUrl;
		//#region		
		System.out.println(PSID);
		System.out.println(Amount);
		//#endregion
		Amount =psidValueCreator(Amount);
		String token = GetUserToken("0656564");
		WebDriverWait(2);
		Response res = given().header("Authorization", "Bearer " + token).contentType("application/json").

				body("{\r\n"
				+ "    \"methodId\": \"1411\",\r\n"
				+ "    \"data\": {\r\n"
				+ "        \"username\" : \"onelink\",\r\n"
				+ "        \"password\" : \"@PSW#1947\",\r\n"
				+ "        \"psid\" : \""+PSID+"\",\r\n"
				+ "        \"transaction_auth_id\" : \"112233\",\r\n"
				+ "        \"transaction_amount\" : \""+Amount+"\",\r\n"
				+ "        \"tran_time\" : \"122330\",\r\n"
				+ "        \"tran_date\" : \"20210802\",\r\n"
				+ "        \"bank_mnemonic\" : \"NBP\",\r\n"
				+ "        \"reserved\" : \"20210621064647975|1122331|PSW:58400;GST:13600;FE:8000;\"\r\n"
				+ "    },\r\n"
				+ "    \"signature\": \"\",\r\n"
				+ "    \"pagination\": {\r\n"
				+ "        \"offset\": 10,\r\n"
				+ "        \"size\": 10,\r\n"
				+ "        \"sortColumn\": \"\",\r\n"
				+ "        \"sortOrder\": \"\"\r\n"
				+ "    }\r\n"
				+ "}").when().post("http://10.1.4.54:8080/internal/ups/onelink/open");
		String body = res.getBody().jsonPath().getString("message.description");
		System.out.println(body);
		// return body;

		return body;

	}
	/**
	 * This Method Allow the to Get the data from the database 
	 * 
	 * @param Quesries = Write your Desire Query 
	 * @param ColumnName             = Enter the Column Name 
	 * 
	 *                         Created by Muhammad Maaz
	 */
	public static String CustomeDatabaseQueries(String Quesries,String ColumnName)
	{
		String Result = null;
		try (Statement stmt = Initilization.ConnectDatabase(Initilization.ConnectionString, Initilization.username,
				Initilization.password)) {
			String SQL = Quesries;
			ResultSet rs = stmt.executeQuery(SQL);
			while (rs.next()) {
				Result = rs.getString(ColumnName);
			}
			System.out.println(Result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Result:: "+Result);
		return Result;
	}
	public static String psidValueCreator(String amount)
	{
		System.out.println(amount);
		int total =13;int remain=0;	
		amount=amount.substring(4);
		System.out.println("1::"+amount);
		amount = amount.replace(",","");
		amount+="00";
		remain = amount.length();
		remain =total-remain;
		//System.out.println("remain"+remain);
		amount = zeroNumberGenerator(remain)+amount;
		System.out.println("Amount with Numbers :: "+amount);
		return amount;
	
	}
	

	/**
	 * This Method is used for Biometric Status Update
	 *
	 * @param APIUrl = For API URL
	 * @param APID   = For Application ID
	 * @param CNIC   =For CNIC
	 *               <p>
	 *               Created by Muhammad Maaz
	 */
	public static String UpdateBioMetricStatus(String APIUrl, String APID, String CNIC) {
		RestAssured.baseURI = APIUrl;

		Response res = given().contentType("application/json")
				.body("{\r\n" + "	\"methodId\":\"1021\",\r\n" + "	\"data\":{\r\n" + "	\"applicationId\":\"" + APID
						+ "\",\r\n" + "	\"cnic\":\"" + CNIC + "\",\r\n" + "	\"transactionId\":\"123\",\r\n"
						+ "	\"biometricStatus\":\"Verified\",\r\n" + "	\"name\":\"Jackson\",\r\n"
						+ "	\"fatherName\":\"John\",\r\n" + "	\"dateOfBirth\":\"05-07-2021\",\r\n"
						+ "	\"currentAddress\":\"Flat B5, DHA Karachi, Pakistan\",\r\n"
						+ "	\"permanentAddress\":\"Flat B5, DHA Karachi, Pakistan\"\r\n" + "    }\r\n" + "}"

				).when().post("");

		String body = res.getBody().jsonPath().getString("message.description");
		System.out.println(body);
		return body;

	}

	public static String UpdateBioMetricStatusUrdu(String APIUrl, String APID, String CNIC) {
		RestAssured.baseURI = APIUrl;

		Response res = given().contentType("application/json")
				.body("{\r\n" + "	\"methodId\":\"1021\",\r\n" + "	\"data\":{\r\n" + "	\"applicationId\":\"" + APID
						+ "\",\r\n" + "	\"cnic\":\"" + CNIC + "\",\r\n" + "	\"transactionId\":\"123\",\r\n"
						+ "	\"biometricStatus\":\"Verified\",\r\n" + "	\"name\":\"محمد جنید۔\",\r\n"
						+ "	\"fatherName\":\"محمد اقبال احمد خان\",\r\n" + "	\"dateOfBirth\":\"05-07-2021\",\r\n"
						+ "	\"currentAddress\":\"فلیٹ بی 5 ، ڈی ایچ اے کراچی ، پاکستان۔\",\r\n"
						+ "	\"permanentAddress\":\"فلیٹ بی 5 ، ڈی ایچ اے کراچی ، پاکستان۔\"\r\n" + "    }\r\n" + "}"

				).when().post("");

		String body = res.getBody().jsonPath().getString("message.description");
		System.out.println(body);
		return body;

	}


	public static String UpdatePhysicalVerificationStatus(String APIUrl, String AspNetUserID) {
		RestAssured.baseURI = APIUrl;

		RequestSpecification request= RestAssured.given();

		System.out.println("API start");

		//Get token
		JsonPath jsonPath = RestAssured.given()
				.contentType("application/x-www-form-urlencoded")
				.formParam("client_Id", "ADWEBCY06")
				.formParam("grant_type", "client_credentials")
				.formParam("client_secret", "DrVu81EP")
				.header("Host","sit.psw.gov.pk")
				.when()
				.post("/auth/connect/token")
				.then()
				.statusCode(200)
				.contentType("application/json")
				.extract().jsonPath();

		String tokenType = jsonPath.getString("Bearer");
		String accessToken = jsonPath.getString("access_token");

		System.out.println(accessToken);

		String VerificationPayload= "{\n" +
				"    \"messageId\": \"a1374655-5eb8-4a0e-9eb5-989521cd1ca8\",\n" +
				"    \"timestamp\": \"20211217121006\",\n" +
				"    \"senderId\": \"WEBOC\",\n" +
				"    \"receiverId\": \"PSW\",\n" +
				"    \"methodId\": \"1142\",\n" +
				"    \"data\": {\n" +
				"        \"userId\": \""+AspNetUserID+"\"\n" +
				"    },\n" +
				"    \"signature\": \"3CTkaU7sb81ucnR2PIoEyChUyl+vNlo9Yru1o7Rws1M=\"\n" +
				"}";

		//Add token in API and post

		Response res=request.header("Authorization", "Bearer " + accessToken)
				.header("Host","sit.psw.gov.pk")
				.contentType("application/json")
				.body(VerificationPayload)
				.post("/api/auth/user/wsecure");


		System.out.println(res);

		String apiResopnse = res.getBody().jsonPath().getString("message.description");
		System.out.println(apiResopnse);
		return apiResopnse;

	}

	/**
	 * This Method is made for Explicit Wait (1 = 1 Second)
	 * Initilization.WebDriverWait(1);
	 *
	 * @param sec = 1 Second
	 *
	 *            * Created by Muhammad Maaz
	 */
	public static void WebDriverWait(int sec) {
		try {
			// thread to sleep for 1000 milliseconds
			Thread.sleep(sec * 1000);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	/**
	 * This Method is made for Explicit Wait (1 = 1 Second)
	 * Initilization.WebDriverWait(1);
	 *
	 * @param type = Write yes or no
	 *
	 *             Created by Muhammad Maaz
	 */
	public static void BrowserAlert(String type) {
		try {
			if (type == "yes") {
				driver.switchTo().alert().accept();
			}
			if (type == "no") {
				driver.switchTo().alert().dismiss();
			}
		} catch (Exception e) {

		}
	}

// Reload method is created by Muhammad Maaz
	/**
	 * This Method is made to Reload the Current WebPage
	 *
	 * Created by Muhammad Maaz
	 */
	public static void Reload()

	{
		driver.navigate().refresh();
	}

	/**
	 * This Method is made to OpenUrl
	 *
	 * @param url = link of the webpage
	 *
	 *            Created by Muhammad Maaz
	 */
	public static void OpenUrl(String url) {
		driver.get(url);
		Initilization.WebDriverWait(3);
		try {
			SSLContext ssl_ctx = SSLContext.getInstance("TLS");
			TrustManager[] trust_mgr = new TrustManager[] { new X509TrustManager() {
				public X509Certificate[] getAcceptedIssuers() {
					return null;
				}

				public void checkClientTrusted(X509Certificate[] certs, String t) {
				}

				public void checkServerTrusted(X509Certificate[] certs, String t) {
				}
			} };
			ssl_ctx.init(null, // key manager
					trust_mgr, // trust manager
					new SecureRandom()); // random number generator
			HttpsURLConnection.setDefaultSSLSocketFactory(ssl_ctx.getSocketFactory());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		}
	}

	public static void OpenNewTab(String url) {
		String link = "window.open('" + url + "','_blank');";
		((JavascriptExecutor) driver).executeScript(link);
		for (String windowHandle : driver.getWindowHandles()) {
			driver.switchTo().window(windowHandle);

		}
	}

	/**
	 * This Method will Get text form Css Selector
	 *
	 * @param value = Locator Created by Muhammad Maaz
	 * @return
	 */
	public static String getTextcss(String value) {
		String abc = null;
		try {
			abc = driver.findElement(By.cssSelector((value))).getText();
		} catch (Exception e) {
			// Reporter.log("network server is slow..check internet connection");
			// Log.info("Unable to open the website");
			// throw new Error("network server is slow..check internet connection");
		}

		return abc;
	}
	public static String getTextxpath(String value) {
		String abc = null;
		try {
			abc = driver.findElement(By.xpath((value))).getText();
		} catch (Exception e) {
			// Reporter.log("network server is slow..check internet connection");
			// Log.info("Unable to open the website");
			// throw new Error("network server is slow..check internet connection");
		}

		return abc;
	}

	/**
	 * This Method will connect to the Database
	 *
	 * @param ConnectionString = IP Address of the Database
	 * @param username         = username of the Database
	 * @param Password         = password of the Database Created by Muhammad Maaz
	 * @return
	 * @throws SQLException
	 */
	public static Statement ConnectDatabase(String ConnectionString, String username, String Password)
			throws SQLException {
		Statement stmt = null;

		String connectionUrl = "jdbc:sqlserver://" + ConnectionString + ";databaseName=AUTH;user=" + username
				+ ";password=" + Password;
		Connection con = DriverManager.getConnection(connectionUrl);
		stmt = con.createStatement();
		if (stmt != null) {
			System.out.println("Connection Sucessfull");
		}
		return stmt;

	}

	/**
	 * This Method will Wait until the Element is loaded
	 *
	 * @param sec = Time in Second 
	 * Created by Muhammad Maaz
	 */
	public static void waitUntilElementtoLoad(int sec) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}

	/**
	 * This Method return true if the added Locator is Enable
	 *
	 * @param locatorType = Type of the Locator
	 * @param value       = Value of the locator Created by Muhammad Maaz
	 * @return true or false
	 */
	public static boolean IsLocatorEnable(String locatorType, String value) {
		By locator;
		locator = locatorValue(locatorType, value);
		boolean element = driver.findElement(locator).isEnabled();
		if (element) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This Method return true if the added Locator is Displayed
	 *
	 * @param locatorType = Type of the Locator
	 * @param value       = Value of the locator Created by Muhammad Maaz
	 * @return true or false
	 */
	public static boolean IsLocatorDisplayed(String locatorType, String value) {
		By locator;
		locator = locatorValue(locatorType, value);
		boolean element = driver.findElement(locator).isDisplayed();
		if (element) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This Method return true if the added Locator is Selected
	 *
	 * @param locatorType = Type of the Locator
	 * @param value       = Value of the locator Created by Muhammad Maaz
	 * @return true or false
	 *
	 */
	public static boolean IsLocatorSelected(String locatorType, String value) {
		By locator;
		locator = locatorValue(locatorType, value);
		boolean element = driver.findElement(locator).isSelected();
		if (element) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This Method is used to select the a value in a Dropdown
	 *
	 * @param locatorType = Type of the Locator
	 * @param value       = Value of the element locator
	 * @param index       = Index of the dropdown option Created by Muhammad Maaz
	 *                    with assistance of Rashid
	 * @return void
	 *
	 */
	public static void dropDown(String locatorType, String value, String index) {
		By locator;
		locator = locatorValue(locatorType, value);
		WebElement secCountryEle = driver.findElement(locator);
		Select countrySelectBox = new Select(secCountryEle);

		countrySelectBox.selectByValue(index);
	}

	public static void windowsSwitch() {
		String parentWindow = driver.getWindowHandle();
		Set<String> s1 = driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I2 = s1.iterator();
		String child_Window;
		while (I2.hasNext()) {

			child_Window = I2.next();
			Initilization.WebDriverWait(5);

			if (!parentWindow.equals(child_Window)) {
				driver.switchTo().window(child_Window);
				System.out.println("\nWindow Switch To Child Window");
			}
		}
	}

	public static String Get_Bar_Validation_Msg(String locatorType, String locatorValue) {
		By locator;
		locator = locatorValue(locatorType, locatorValue);
		WebElement t = driver.findElement(locator);
		String ss = t.getText();
		ss = ss.substring(14, ss.length());
		System.out.println("getText:" + ss);
		return ss;
	}

	public static String Get_Bar_Validation_Msg_ResumeApplication(String locatorType, String locatorValue) {
		By locator;
		int startSlice;
		locator = locatorValue(locatorType, locatorValue);
		WebElement t = driver.findElement(locator);
		String ss = t.getText();
		ss = ss.substring(10, ss.length());
		System.out.println("getText:" + ss);
		return ss;
	}

	public static String Get_Bar_Validation_Msg_PhysicalVerificationPending(String locatorType, String locatorValue) {
		By locator;
		int startSlice;
		locator = locatorValue(locatorType, locatorValue);
		WebElement t = driver.findElement(locator);
		String ss = t.getText();
		ss = ss.substring(10, ss.length());
		System.out.println("getText:" + ss);
		return ss;
	}

	public static void ClearField(String locatorType, String locatorValue) {
		By locator;
		locator = locatorValue(locatorType, locatorValue);
		driver.findElement(locator).sendKeys(Keys.CONTROL, "a");
		driver.findElement(locator).sendKeys(Keys.BACK_SPACE);

	}
	public static void SelectAllText(String locatorType, String locatorValue) {
		By locator;
		locator = locatorValue(locatorType, locatorValue);
		driver.findElement(locator).sendKeys(Keys.CONTROL, "a");


	}
	public static void Login(String EnterUserName,String EnterPassword)
	{


		// This Line will enter the UserName in the username Field
		Initilization.enter_Text("name", "userName", EnterUserName);
		// This Line will enter the pasword in the pasword Field
		Initilization.enter_Text("name", "password", EnterPassword);
		// This Line will click on Submit Button
		Initilization.click_On_Button("css", "div>form>button");

		Initilization.WebDriverWait(3);
	}

	public static String randomBLNumber(int n)
    {

        // chose a Character random from this String
        String AlphaNumericString = "0123456789";


        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                = (int)(AlphaNumericString.length()
                        * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                          .charAt(index));
        }
        System.out.println("Serial Number :: "+sb);
        return sb.toString();
    }
	//Method is used for creating a valid amount of PSID 
	public static String zeroNumberGenerator(int n)
    {

        // chose a Character random from this String
        String AlphaNumericString = "0";


        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                = (int)(AlphaNumericString.length()
                        * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                          .charAt(index));
        }
        System.out.println("Number of Zero Generated :: "+sb);
        return sb.toString();
    }
	public static String randomNumber(int n)
    {

        // chose a Character random from this String
        String AlphaNumericString = "012";


        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                = (int)(AlphaNumericString.length()
                        * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                          .charAt(index));
        }
        System.out.println("Random :: "+sb);
        return sb.toString();
    }

	public static void DropFile(File filePath, WebElement target, int offsetX, int offsetY) {
	    if(!filePath.exists())
	        throw new WebDriverException("File not found: " + filePath.toString());

	    WebDriver driver = ((RemoteWebElement)target).getWrappedDriver();
	    JavascriptExecutor jse = (JavascriptExecutor)driver;
	    WebDriverWait wait = new WebDriverWait(driver, 30);

	    String JS_DROP_FILE =
	        "var target = arguments[0]," +
	        "    offsetX = arguments[1]," +
	        "    offsetY = arguments[2]," +
	        "    document = target.ownerDocument || document," +
	        "    window = document.defaultView || window;" +
	        "" +
	        "var input = document.createElement('INPUT');" +
	        "input.type = 'file';" +
	        "input.style.display = 'none';" +
	        "input.onchange = function () {" +
	        "  var rect = target.getBoundingClientRect()," +
	        "      x = rect.left + (offsetX || (rect.width >> 1))," +
	        "      y = rect.top + (offsetY || (rect.height >> 1))," +
	        "      dataTransfer = { files: this.files };" +
	        "" +
	        "  ['dragenter', 'dragover', 'drop'].forEach(function (name) {" +
	        "    var evt = document.createEvent('MouseEvent');" +
	        "    evt.initMouseEvent(name, !0, !0, window, 0, 0, 0, x, y, !1, !1, !1, !1, 0, null);" +
	        "    evt.dataTransfer = dataTransfer;" +
	        "    target.dispatchEvent(evt);" +
	        "  });" +
	        "" +
	        "  setTimeout(function () { document.body.removeChild(input); }, 25);" +
	        "};" +
	        "document.body.appendChild(input);" +
	        "return input;";

	    WebElement input =  (WebElement)jse.executeScript(JS_DROP_FILE, target, offsetX, offsetY);
	    input.sendKeys(filePath.getAbsoluteFile().toString());
	    wait.until(ExpectedConditions.stalenessOf(input));

	}
	public static void waitUntilVisibilityOfElementLocated(int sec, String element)

	{

		By locator  = By.xpath(element);

		WebDriverWait wait = new WebDriverWait(driver,sec);

		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));



	}
	public static void SelectDateFromCalender()
	{
		waitUntilVisibilityOfElementLocated(15,"//a[@class='k-select k-select']");
		click_On_Button("xpath","//a[@class='k-select k-select']");
	}
}
