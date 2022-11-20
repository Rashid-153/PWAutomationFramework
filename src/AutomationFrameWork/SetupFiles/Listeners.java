package AutomationFrameWork.SetupFiles;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.util.Date;

public class Listeners extends Initilization implements ITestListener {

	public static ExtentReports extent;
	public static ExtentTest logger;

	public void onStart(ITestContext testContext) {
		
		//Date format 
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy, hh.mm.ss aa");
    	String dateString = dateFormat.format(new Date()).toString();
		
    	//Generate HTML report
		extent = new ExtentReports("D:\\TestResults_" +dateString+ ".html", false);
		//Create first log
		logger = extent.startTest("Configuration");
	}

	/**
	 * 
	 * @param locatortype
	 * @param value
	 * @param text
	 */
	public static void onSuccess(String message,String locatortype, String value, String text) { // create new entry in the report

		try {
			logger.log(LogStatus.PASS, message+"<br><b>Locator Type :</b> " + locatortype + ",<b> Value : </b>" + value + ",-" + text
					+ logger.addScreenCapture(capture(driver)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @param locatortype
	 * @param value
	 * @param text
	 */
	public static void onFail(String message,String locatortype, String value, String text) {

		try {
			logger.log(LogStatus.FAIL, message+"<br><b> Locator Type:</b>" + locatortype + "<b> and Value:</b>" + value
					+ "-" + text + logger.addScreenCapture(capture(driver)));
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param actual
	 * @param expected
	 *
	 */
	public static void assertOnSuccess(String actual, String expected) { // create new entry in th report

		try {
			logger.log(LogStatus.PASS,
					"Assert Passed as Actual Result is equal to the Expected Result." + " <br><b> Actual result :</b> " + actual
							+ " <b> Expected Result : </b>" + expected + logger.addScreenCapture(capture(driver)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @param actual
	 * @param expected
	 */

	public static void assertOnFail(String actual, String expected) {

		try {
			logger.log(LogStatus.FAIL,
					"Assert Failed as Actual Result is not equal to the Expected Result." + "<br> <b> Actual result :</b> "
							+ actual + " <b> Expected Result : </b>" + expected + logger.addScreenCapture(capture(driver)));
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void onFinish(ITestContext testContext) {
		extent.flush();
	}

	// Screen capture
	public static String capture(WebDriver driver) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File("D://../Pics/" + System.currentTimeMillis() + ".png");
		String errflpath = Dest.getAbsolutePath();
		FileUtils.copyFile(scrFile, Dest);
		return errflpath;

	}
}
