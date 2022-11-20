package AutomationFrameWork.TestCases.SingleDecleration;

import AutomationFrameWork.Helpers.SingleDeclearationConstants;
import AutomationFrameWork.Helpers.SingleDeclearationHelper;
import AutomationFrameWork.SetupFiles.Initilization;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import AutomationFrameWork.SetupFiles.Initilization;

public class SingleDeclerationImportAqdTestCases extends Initilization {

    @Parameters("browsers")
    @BeforeTest
    public static void BeforeTest(String BrowserName)
    {
        // Initialize Browser
        Initilization.BrowsersType = BrowserName;
        Initilization.URL = "https://" + Initilization.Environment + ".psw.gov.pk/app/";

    }


    @Test(description = "file_AQD_SingleDeclarationImportWithOpenAccount", enabled = true, invocationCount = 1)
    public static void fileAQDSingleDeclarationImportWithOpenAccount()
    {

        String ntn = "0133358";
        String userName = "UN-00-" + ntn;
        String password = "Test@1234";
        OpenUrl(Initilization.URL);
        //HomePage
        waitUntilElementtoLoad(30);
        // This Line will Click on Subscriber Button
        Login(userName, password);
        waitUntilElementtoLoad(10);
        SingleDeclearationHelper.OpenMenu();
        waitUntilElementtoLoad(10);


        SingleDeclearationHelper.CreateDeclerationImport();
        Initilization.WebDriverWait(2);

        SingleDeclearationHelper.TransactionTypeImport("0656564","Commercial","Home Consumption");
        waitUntilElementtoLoad(10);

        SingleDeclearationHelper.ConsigmentInformationImport();
        WebDriverWait(5 );
        SingleDeclearationHelper.FinancialInformationImport(SingleDeclearationConstants.Currency.UnitedStatesDollar.toString(),
                "Not Required",SingleDeclearationConstants.DeliveryTerm.CFR.toString()
                ,SingleDeclearationConstants.Bank.SoneriBank.toString(),
                "PK33SONE0001620000383733",SingleDeclearationConstants.ModeofPayment.OpenAccount.toString());
        WebDriverWait(5);
        
        SingleDeclearationHelper.CommodityInformationADQImport();
        WebDriverWait(5);
        SingleDeclearationHelper.ItemStructureAQD();
        //Proceed from Documents Tab
        SingleDeclearationHelper.Proceed();
        WebDriverWait(2);
        SingleDeclearationHelper.ValidateAndProceed();
        click_On_Button("xpath","//button[normalize-space()='OK']"); // Click on OK button after validating
        waitUntilElementtoLoad(5);
        SingleDeclearationHelper.SaveAndSubmitButton(); // Click on Save and submit button after creating SDImport
        WebDriverWait(6);
        SingleDeclearationHelper.PDAccountPayment();
        waitUntilElementtoLoad(10);


    }


}
