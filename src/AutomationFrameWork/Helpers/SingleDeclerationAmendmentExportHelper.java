package AutomationFrameWork.Helpers;

import AutomationFrameWork.SetupFiles.Initilization;
import AutomationFrameWork.TestCases.SingleDecleration.SingleDeclerationExportTestCases;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class SingleDeclerationAmendmentExportHelper extends Initilization {

    public static void ConsigmentInformationAmendment(){
        Initilization.waitUntilElementtoLoad(30);
        Initilization.ClearField("xpath","//input[@name='blNumber']");
        Initilization.enter_Text("xpath","//input[@name='blNumber']","Automation Script"+Initilization.randomNumber(2)); // Enter BL number
        Initilization.waitUntilElementtoLoad(30);

        Initilization.ClearField("xpath","//input[@placeholder='Please select destination country']");
        Initilization.enter_Text("xpath","//input[@placeholder='Please select destination country']","Poland"+ Keys.ENTER); // Enter Destination Country
        Initilization.waitUntilElementtoLoad(30);

        Initilization.ClearField("xpath","//input[@placeholder='Please select port of discharge']");
        Initilization.enter_Text("xpath","//input[@placeholder='Please select port of discharge']","Darlowo"+Keys.ENTER);
        Initilization.waitUntilElementtoLoad(30);

        Initilization.ClearField("xpath","//input[@name='placeOfDelivery']");
        Initilization.enter_Text("xpath","//input[@name='placeOfDelivery']","Place-Automation");
        Initilization.waitUntilElementtoLoad(30);

        Initilization.ClearField("xpath","(//input[@class='k-input'])[3]");
        Initilization.enter_Text("xpath","(//input[@class='k-input'])[3]","MAERSK PAKISTAN (PVT) LTD.");
        Initilization.waitUntilElementtoLoad(30);

        Initilization.ClearField("xpath","(//input[@class='k-input k-formatted-value'])[1]");
        Initilization.enter_Text("xpath","(//input[@class='k-input k-formatted-value'])[1]","20,000");
        Initilization.waitUntilElementtoLoad(30);

        Initilization.ClearField("xpath","(//input[@class='k-input k-formatted-value'])[2]");
        Initilization.enter_Text("xpath","(//input[@class='k-input k-formatted-value'])[2]","1600");
        Initilization.waitUntilElementtoLoad(30);



    }
    public static void Click_CommodityInformationTabAmendment(){

        Initilization.click_On_Button("xpath", "//p[normalize-space()='Commodity Information']"); // click on Commodity tab
        Initilization.WebDriverWait(1);


    }



    public static void AmendContaiter(){

        Initilization.click_On_Button("xpath", "(//a[@class='AmendSDExport_delIcon__1Sqq0'])[2]"); // Click on  Item AmendIcon
        Initilization.waitUntilElementtoLoad(3);

        UpdateContainer();
        waitUntilElementtoLoad(5);
        AddContainer();
        waitUntilElementtoLoad(6);
        DeleteContainer();
        WebDriverWait(4);
        Initilization.click_On_Button("xpath","//button[@class='undefined btn btn-primary']"); // Go Back Action to 'Save and Submit Screen'
        Initilization.waitUntilElementtoLoad(5 );


    }

    public static void AmendItem(){


        DeleteItem();
        Initilization.waitUntilElementtoLoad(3 );

        Initilization.click_On_Button("xpath","//button[@class='undefined btn btn-primary']"); // Go Back Action to 'Save and Submit Screen'
        Initilization.waitUntilElementtoLoad(5 );

        SaveAndSubmitAmendment();

    }

public  static void UpdateContainer() {

       String CN = "AUTO";
       CN += Initilization.randomBLNumber(7);
        String randomNum;
        randomNum = Initilization.randomBLNumber(2);

        //CURD operations
        Initilization.WebDriverWait(3);
        Initilization.click_On_Button("xpath", "(//a[@class='AmendSDExport_delIcon__1Sqq0'])[1]"); //Click on  Container AmendIcon
        Initilization.waitUntilElementtoLoad(2);
        Initilization.ClearField("xpath","(//input[@name='containerNo'])[1]");
        Initilization.waitUntilElementtoLoad(10);
        Initilization.enter_Text("xpath", "(//input[@name='containerNo'])[1]", CN+Keys.ENTER);  //Update Container Number
        Initilization.waitUntilElementtoLoad(6);

        Initilization.ClearField("xpath","(//input[@name='noOfItems'])[1]");
        Initilization.enter_Text("xpath", "(//input[@name='noOfItems'])[1]", randomNum+Keys.ENTER);    // Update Number of Quantity
        Initilization.waitUntilElementtoLoad(6);
        Initilization.enter_Text("xpath", "//input[@name='noOfPackages']", randomNum+Keys.ENTER); // Update Number of Packages
        Initilization.waitUntilElementtoLoad(6);
        Initilization.ClearField("xpath", "(//input[@placeholder='Select package type'])[1]");
        Initilization.waitUntilElementtoLoad(6);
        Initilization.enter_Text("xpath", "(//input[@placeholder='Select package type'])[1]", "JOINTS"+Keys.ENTER); // Update Package Type
        Initilization.waitUntilElementtoLoad(6);
        //Initilization.click_On_Button("xpath", "//button[@type='submit']"); // Click on Submit Button
        Initilization.click_On_Button("xpath", "//button[@type='submit']"); // Click on Submit Button
        Initilization.waitUntilElementtoLoad(2);

        }

        public static void UpdateContainerBelow10PercentVariance()
        {
            String CN = "AUTO";
            CN += Initilization.randomBLNumber(7);
            String randomNum;
            randomNum = Initilization.randomBLNumber(2);

            //CURD operations
            Initilization.WebDriverWait(3);
            Initilization.click_On_Button("xpath","(//a[@class='AmendSDExport_delIcon__1Sqq0'])[2]");// Click on Item Amendment Icon
            Initilization.waitUntilElementtoLoad(2);
            Initilization.click_On_Button("xpath", "(//a[@class='AmendSDExport_delIcon__1Sqq0'])[1]"); //Click on  Container AmendIcon
            Initilization.waitUntilElementtoLoad(2);
            Initilization.ClearField("xpath","(//input[@name='containerNo'])[1]");
            Initilization.waitUntilElementtoLoad(10);
            Initilization.enter_Text("xpath", "(//input[@name='containerNo'])[1]", CN+Keys.ENTER);  //Update Container Number
            Initilization.waitUntilElementtoLoad(6);

            float Quantity= Float.parseFloat(Initilization.getTextxpath("(//input[@name='noOfItems'])[1]"));
            System.out.println(Quantity);
            float Variance = Quantity/100 *10;
            System.out.println(Variance);
            float TotalVariance=Quantity+Variance;
            System.out.println(TotalVariance);
            Initilization.ClearField("xpath","(//input[@name='noOfItems'])[1]");
            Initilization.enter_Text("xpath", "(//input[@name='noOfItems'])[1]", String.valueOf(TotalVariance)+Keys.ENTER);
            Initilization.waitUntilElementtoLoad(6);

            Initilization.ClearField("xpath", "(//input[@placeholder='Select package type'])[1]");
            Initilization.waitUntilElementtoLoad(6);

            Initilization.enter_Text("xpath", "(//input[@placeholder='Select package type'])[1]", "JOINTS"+Keys.ENTER); // Update Package Type
            Initilization.waitUntilElementtoLoad(6);

            //Initilization.click_On_Button("xpath", "//button[@type='submit']"); // Click on Submit Button
            Initilization.click_On_Button("xpath", "//button[@type='submit']"); // Click on Submit Button
            Initilization.waitUntilElementtoLoad(2);

        }

    public static void AddContainer()
    {
        String ContainerName= "ADDD";
        ContainerName+=Initilization.randomNumber(7);

        Initilization.enter_Text("xpath","//input[@name='containerNo']",ContainerName+Keys.ENTER); // Enter Container Number
        Initilization.waitUntilElementtoLoad(5);

        Initilization.enter_Text("xpath","//input[@name='quantity']","30");  // Enter Quantity
        Initilization.waitUntilElementtoLoad(5);

        Initilization.enter_Text("xpath","//input[@name='noOfPackages']","700"); // Enter No of Packages
        Initilization.waitUntilElementtoLoad(5);

        Initilization.ClearField("xpath","//input[@class='k-input']"); // Clear Field of Package Type
        Initilization.waitUntilElementtoLoad(5);

        Initilization.enter_Text("xpath","//input[@class='k-input']","SCRAP"+Keys.ENTER); // Enter Package Type
        Initilization.waitUntilElementtoLoad(5);

        Initilization.click_On_Button("xpath","//button[normalize-space()='Add Container']");
        Initilization.waitUntilElementtoLoad(5);

        Initilization.click_On_Button("xpath","//button[normalize-space()='Yes']");
        Initilization.waitUntilElementtoLoad(10);

    }

    public  static  void DeleteContainer()

    {
        Initilization.click_On_Button("xpath","(//a[@class='AmendSDExport_delIcon__1Sqq0'])[2]"); //Click on Delete Container Icon
        Initilization.waitUntilElementtoLoad(2);

    }

    public  static  void SaveAndSubmitAmendment(){
        Initilization.waitUntilElementtoLoad(30);
        Initilization.click_On_Button("xpath","//button[normalize-space()='Save and Submit']");
        Initilization.waitUntilElementtoLoad(30);

    }

    public  static void DeleteItem()
    {
        WebDriverWait(3);
        Initilization.click_On_Button("xpath","(//a[@class='AmendSDExport_delIcon__1Sqq0'])[3]");
        WebDriverWait(3);
    }

    public static void logOutAfterApproval(){
        Initilization.click_On_Button("xpath","//button[@class='menu-toggle pr-2 bg-light rounded-0 dropdown-toggle btn btn-flat']");
        Initilization.waitUntilElementtoLoad(5);
        Initilization.click_On_Button("xpath","//a[@class='py-3 dropdown-item'][3]");
        Initilization.WebDriverWait(3);
    }

    public static void Click_FinancialInformationTab()
    {
        Initilization.click_On_Button("xpath", "//p[normalize-space()='Financial Information']"); // click on Financial Infromation tab
        Initilization.waitUntilElementtoLoad(3);
    }


}


