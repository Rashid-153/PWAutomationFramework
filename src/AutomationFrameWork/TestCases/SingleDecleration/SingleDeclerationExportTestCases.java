package AutomationFrameWork.TestCases.SingleDecleration;

import AutomationFrameWork.Helpers.SingleDeclarationWithAllOgaHelper;
import AutomationFrameWork.Helpers.SingleDeclearationConstants;
import AutomationFrameWork.Helpers.SingleDeclearationHelper;
import AutomationFrameWork.SetupFiles.Initilization;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SingleDeclerationExportTestCases extends Initilization {

    static String Agency="AQD";
    static String  consignorName="BAMI KHAN FLOUR & GENERAL MILLS (PRIVATE)LIMITED";
    static String consignorAddress="OFFICE # 1 PLOT # 407 INDUSTRIAL AREA";
    static String ntn = "0133358";
    static String traderNTN="0656564";
    static String userName = "UN-00-" + ntn;
    static String password = "Test@1234";
    static String FINumber="DIB-EXP-000434-18102021";
    static String IBAN="PK83DUIB0000001040001740";





    @Parameters("browsers")
    @BeforeTest
    public static void BeforeTest(String BrowserName) {
        // Initialize Browser
        Initilization.BrowsersType = BrowserName;
        Initilization.URL = "https://" + Initilization.Environment + ".psw.gov.pk/app/";

    }

    @Test(description = "fileNonOGASingleDeclarationWithCIF", enabled = false, invocationCount = 1)
    public static void Verify_fileNonOGASingleDeclarationWithCIF() {


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


        SingleDeclearationHelper.TransactionType(traderNTN, SingleDeclearationConstants.ConsignmentCategory.Commercial.toString(), SingleDeclearationConstants.DeclarationType.ExportCommercialTransaction.toString());

        SingleDeclearationHelper.Confirm();
        Initilization.WebDriverWait(6);


        SingleDeclearationHelper.ConsignmentInformation(
                SingleDeclearationConstants.Collectorate.PortQasimExportKarachi.toString(),
                SingleDeclearationConstants.ConsignmentMode.Containerized.toString(),
                SingleDeclearationConstants.Shed.QasimInternationalContainerTerminal.toString(),
                SingleDeclearationConstants.Terminal.QasimInternationalContainerTerminal.toString(),
                consignorName,
                consignorAddress);

        SingleDeclearationHelper.SaveAndProceedButton();
        Initilization.WebDriverWait(3);


        SingleDeclearationHelper.FinancialInformation(
                SingleDeclearationConstants.Currency.UnitedStatesDollar.toString(),
                FINumber, SingleDeclearationConstants.DeliveryTerm.CIF.toString(),
                SingleDeclearationConstants.Bank.AlBarakaBank.toString(),
                IBAN, SingleDeclearationConstants.ModeofPayment.OpenAccount.toString());


        SingleDeclearationHelper.SaveAndProceedButton();
        Initilization.WebDriverWait(3);


        SingleDeclearationHelper.CommodityInformation(1, 1);
        Initilization.WebDriverWait(10);

        SingleDeclearationHelper.Proceed();
        Initilization.WebDriverWait(5);


        SingleDeclearationHelper.Documents();
        SingleDeclearationHelper.Proceed();
        Initilization.WebDriverWait(8);


        SingleDeclearationHelper.ValidateAndProceed();
        Initilization.WebDriverWait(10);


        SingleDeclearationHelper.SaveAndSubmitButton();


    }

    @Test(description = "fileOGASingleDeclarationWithOpenAccount", enabled = false, invocationCount = 1)
    public static void fileOGASingleDeclarationWithOpenAccount() {


        Initilization.OpenUrl(Initilization.URL);
        // HomePage
        Initilization.waitUntilElementtoLoad(30);
        // This Line will Click on Subscriber Button
        Initilization.Login(userName, password);
        Initilization.waitUntilElementtoLoad(10);
        SingleDeclearationHelper.OpenMenu();
        Initilization.waitUntilElementtoLoad(10);


        SingleDeclearationHelper.CreateDeclearation();
        Initilization.waitUntilElementtoLoad(10);
        WebDriverWait wait = new WebDriverWait(driver, 30);


        SingleDeclearationHelper.TransactionType(
                "0656564",
                SingleDeclearationConstants.ConsignmentCategory.Commercial.toString(),
                SingleDeclearationConstants.DeclarationType.ExportCommercialTransaction.toString());

        SingleDeclearationHelper.Confirm();
        Initilization.waitUntilElementtoLoad(10);
        //Initilization.WebDriverWait(20);


        SingleDeclearationHelper.ConsignmentInformation(
                SingleDeclearationConstants.Collectorate.PortQasimExportKarachi.toString(),
                SingleDeclearationConstants.ConsignmentMode.Containerized.toString(),
                SingleDeclearationConstants.Shed.QasimInternationalContainerTerminal.toString(),
                SingleDeclearationConstants.Terminal.QasimInternationalContainerTerminal.toString(), consignorName, consignorAddress);


        SingleDeclearationHelper.SaveAndProceedButton();
        Initilization.waitUntilElementtoLoad(10);


        SingleDeclearationHelper.FinancialInformation(
                SingleDeclearationConstants.Currency.UnitedStatesDollar.toString(),
                FINumber, SingleDeclearationConstants.DeliveryTerm.CIF.toString(),
                SingleDeclearationConstants.Bank.AlBarakaBank.toString(),
                IBAN, SingleDeclearationConstants.ModeofPayment.OpenAccount.toString());

        SingleDeclearationHelper.SaveAndProceedButton();
        Initilization.waitUntilElementtoLoad(10);


        SingleDeclearationHelper.CommodityInformationOGA(1, 1);
        Initilization.WebDriverWait(12);

        SingleDeclearationHelper.Proceed();
        Initilization.waitUntilElementtoLoad(10);


        SingleDeclearationHelper.Documents();
        SingleDeclearationHelper.Proceed();
        Initilization.waitUntilElementtoLoad(10);

        SingleDeclearationHelper.ReviewAndValidate(null);
        Initilization.WebDriverWait(4);
        SingleDeclearationHelper.ValidateAndProceed();
        Initilization.waitUntilElementtoLoad(10);


        SingleDeclearationHelper.SaveAndSubmitButton();
        Initilization.WebDriverWait(10);
        //String SDNumber = SingleDeclearationHelper.PaymentProcedure();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//p[@class='title font-semibold'])[1]")));
        String paymentSlip = Initilization.getTextxpath("(//p[@class='title font-semibold'])[1]");
        paymentSlip = paymentSlip.substring(6, 23);
        //System.out.println("PSID is 6 digits:" + paymentSlip);
        Initilization.UpdatePaymentStatus("https://" + Initilization.Environment + ".psw.gov.pk/api/ups/PSID/open", paymentSlip, "3000");
        String SDNumber = Initilization.getTextxpath("(//strong[@class='text-dark text-break'])[3]");

        String psidAmount = Initilization.getTextxpath("(//p[@class='title font-semibold'])[2]");
        System.out.println(psidAmount);

        System.out.println(SDNumber);

        //String SDNumber
        Initilization.logout();
        //return SDNumber;


    }

    @Test(description = "fileNonOGASingleDeclarationWithCIF", enabled = false)
    public static void Verify_filewithNonOGAandOGASingleDeclarationWithCIF() {

        Initilization.OpenUrl(Initilization.URL);
        // HomePage
        Initilization.WebDriverWait(12);
        // This Line will Click on Subscriber Button
        Initilization.Login(userName, password);
        Initilization.WebDriverWait(6);
        SingleDeclearationHelper.OpenMenu();
        Initilization.WebDriverWait(8);


        SingleDeclearationHelper.CreateDeclearation();
        Initilization.WebDriverWait(6);


        SingleDeclearationHelper.TransactionType(traderNTN, SingleDeclearationConstants.ConsignmentCategory.Commercial.toString()
                , SingleDeclearationConstants.DeclarationType.ExportCommercialTransaction.toString());

        SingleDeclearationHelper.Confirm();
        Initilization.WebDriverWait(6);


        SingleDeclearationHelper.ConsignmentInformation(SingleDeclearationConstants.Collectorate.PortQasimExportKarachi.toString(),
                SingleDeclearationConstants.ConsignmentMode.Containerized.toString(),
                SingleDeclearationConstants.Shed.QasimInternationalContainerTerminal.toString(),
                SingleDeclearationConstants.Terminal.QasimInternationalContainerTerminal.toString(),
                consignorName,
                consignorAddress);


        SingleDeclearationHelper.SaveAndProceedButton();
        Initilization.WebDriverWait(3);

        SingleDeclearationHelper.FinancialInformation
                (SingleDeclearationConstants.Currency.UnitedStatesDollar.toString(), FINumber, SingleDeclearationConstants.DeliveryTerm.CIF.toString(),
                        SingleDeclearationConstants.Bank.AlBarakaBank.toString(), IBAN, SingleDeclearationConstants.ModeofPayment.OpenAccount.toString());

        SingleDeclearationHelper.SaveAndProceedButton();
        Initilization.WebDriverWait(3);

        //SingleDeclearationHelper.CommodityInformation(2,2);
        SingleDeclearationHelper.CommodityInformationOGA(2, 2);
        Initilization.WebDriverWait(10);

        SingleDeclearationHelper.Proceed();
        Initilization.WebDriverWait(5);


        SingleDeclearationHelper.Documents();
        SingleDeclearationHelper.Proceed();
        Initilization.WebDriverWait(8);

        SingleDeclearationHelper.ReviewAndValidate(null);
        SingleDeclearationHelper.ValidateAndProceed();
        Initilization.WebDriverWait(10);


        SingleDeclearationHelper.SaveAndSubmitButton();


    }

    @Test(description = "fileNonOGASingleDeclarationWithCIF", enabled = false)
    public static void Verify_filewithNonOGAandOGASingleDeclarationWithCIF_Partshipment() {


        Initilization.OpenUrl(Initilization.URL);
        // HomePage
        Initilization.WebDriverWait(12);
        // This Line will Click on Subscriber Button
        Initilization.Login(userName, password);
        Initilization.WebDriverWait(6);
        SingleDeclearationHelper.OpenMenu();
        Initilization.WebDriverWait(8);


        SingleDeclearationHelper.CreateDeclearation();
        Initilization.WebDriverWait(6);


        SingleDeclearationHelper.TransactionType(traderNTN, SingleDeclearationConstants.ConsignmentCategory.Commercial.toString(), SingleDeclearationConstants.DeclarationType.ExportCommercialTransaction.toString());

        SingleDeclearationHelper.Confirm();
        Initilization.WebDriverWait(6);


        SingleDeclearationHelper.ConsignmentInformation(SingleDeclearationConstants.Collectorate.PortQasimExportKarachi.toString(),
                SingleDeclearationConstants.ConsignmentMode.Containerized.toString(),
                SingleDeclearationConstants.Shed.QasimInternationalContainerTerminal.toString(),
                SingleDeclearationConstants.Terminal.QasimInternationalContainerTerminal.toString(),
                consignorName,
                consignorAddress);



        SingleDeclearationHelper.SaveAndProceedButton();
        Initilization.WebDriverWait(3);

        SingleDeclearationHelper.FinancialInformation
                (SingleDeclearationConstants.Currency.UnitedStatesDollar.toString(), FINumber, SingleDeclearationConstants.DeliveryTerm.CIF.toString(),
                        SingleDeclearationConstants.Bank.AlBarakaBank.toString(), IBAN, SingleDeclearationConstants.ModeofPayment.OpenAccount.toString());


        SingleDeclearationHelper.SaveAndProceedButton();
        Initilization.WebDriverWait(3);

        SingleDeclearationHelper.CommodityInformation(5, 2);
        SingleDeclearationHelper.CommodityInformationOGA(5, 2);
        Initilization.WebDriverWait(10);

        SingleDeclearationHelper.Proceed();
        Initilization.WebDriverWait(5);


        SingleDeclearationHelper.Documents();
        SingleDeclearationHelper.Proceed();
        Initilization.WebDriverWait(8);

        SingleDeclearationHelper.ReviewAndValidate(null);
        SingleDeclearationHelper.ValidateAndProceed();
        Initilization.WebDriverWait(10);


        SingleDeclearationHelper.SaveAndSubmitButton();


    }

    @Test(description = "fileOGAGeneral", enabled = true, invocationCount = 1)
    public static void fileOGAGeneral() {



        Initilization.OpenUrl(Initilization.URL);
        // HomePage



        Initilization.waitUntilElementtoLoad(30);
        // This Line will Click on Subscriber Button
        Initilization.Login(userName, password);

        Initilization.waitUntilElementtoLoad(10);
        SingleDeclearationHelper.OpenMenu();
        Initilization.waitUntilElementtoLoad(10);


        SingleDeclearationHelper.CreateDeclearation();
        Initilization.waitUntilElementtoLoad(10);
        WebDriverWait wait = new WebDriverWait(driver, 30);


        SingleDeclearationHelper.TransactionType(traderNTN,
                SingleDeclearationConstants.ConsignmentCategory.Commercial.toString(),
                SingleDeclearationConstants.DeclarationType.ExportCommercialTransaction.toString());

        SingleDeclearationHelper.Confirm();
        Initilization.waitUntilElementtoLoad(10);
        //Initilization.WebDriverWait(20);


        SingleDeclearationHelper.ConsignmentInformation(
                SingleDeclearationConstants.Collectorate.PortQasimExportKarachi.toString(),
                SingleDeclearationConstants.ConsignmentMode.Containerized.toString(),
                SingleDeclearationConstants.Shed.QasimInternationalContainerTerminal.toString(),
                SingleDeclearationConstants.Terminal.QasimInternationalContainerTerminal.toString(),
                consignorName,
                consignorAddress);


        SingleDeclearationHelper.SaveAndProceedButton();
        Initilization.waitUntilElementtoLoad(10);


        SingleDeclearationHelper.FinancialInformation
                (SingleDeclearationConstants.Currency.UnitedStatesDollar.toString(), FINumber, SingleDeclearationConstants.DeliveryTerm.CIF.toString(),
                        SingleDeclearationConstants.Bank.AlBarakaBank.toString(), IBAN, SingleDeclearationConstants.ModeofPayment.OpenAccount.toString());

        SingleDeclearationHelper.SaveAndProceedButton();
        Initilization.waitUntilElementtoLoad(10);


        SingleDeclarationWithAllOgaHelper.generalOGACommodity(1, 1, Agency);
        Initilization.WebDriverWait(12);

        SingleDeclearationHelper.Proceed();
        Initilization.waitUntilElementtoLoad(10);


        SingleDeclearationHelper.Documents();
        SingleDeclearationHelper.Proceed();
        Initilization.waitUntilElementtoLoad(10);

        SingleDeclearationHelper.ReviewAndValidate(Agency);
        Initilization.WebDriverWait(4);
        SingleDeclearationHelper.ValidateAndProceed();
        Initilization.waitUntilElementtoLoad(10);


        SingleDeclearationHelper.SaveAndSubmitButton();
        Initilization.WebDriverWait(10);
        //String SDNumber = SingleDeclearationHelper.PaymentProcedure();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//p[@class='title font-semibold'])[1]")));
        String paymentSlip = Initilization.getTextxpath("(//p[@class='title font-semibold'])[1]");
        paymentSlip = paymentSlip.substring(6, 23);
        //System.out.println("PSID is 6 digits:" + paymentSlip);
        Initilization.UpdatePaymentStatus("https://" + Initilization.Environment + ".psw.gov.pk/api/ups/PSID/open", paymentSlip, "3000");
        String SDNumber = Initilization.getTextxpath("(//strong[@class='text-dark text-break'])[3]");

        String psidAmount = Initilization.getTextxpath("(//p[@class='title font-semibold'])[2]");
        System.out.println(psidAmount);

        System.out.println(SDNumber);

        //String SDNumber
        Initilization.logout();
        //return SDNumber;


    }



}
