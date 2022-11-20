package AutomationFrameWork.Helpers;

import AutomationFrameWork.SetupFiles.Initilization;
import org.openqa.selenium.Keys;

import static AutomationFrameWork.Helpers.SingleDeclearationHelper.*;

public class SingleDeclarationWithAllOgaHelper extends Initilization {

    public static int totalQuantity = 0;

    public static void generalOGACommodity(int noOfItem, int noOfContainers, String agency){

        for (int i = 0; i < noOfItem; i++) {
            AddCommodityButton();
            Initilization.waitUntilElementtoLoad(15);
            //Initilization.waitUntilElementtoLoad(40);


            for (int j = 0; j < noOfContainers; j++) {
                Initilization.waitUntilElementtoLoad(10);
                AddContainerButton();
                ContainerInformation();

            }
            if (agency.equalsIgnoreCase("DPP")){
                Initilization.WebDriverWait(15);
                //SelectGeneralInformationTab();
                GeneralInformationAll(agency);
                SelectSupportingInformationTab();
                SupportingInformation();

                OGAsRequiredInformationTab();
                OGARequiredInformation();
                OGARequiredDocumentsTab();
                OGARequiredDocuments();

                Save();
                Initilization.waitUntilElementtoLoad(40);


            }
            else if (agency.equalsIgnoreCase("AQD")){

                Initilization.WebDriverWait(15);
                //SelectGeneralInformationTab();
                GeneralInformationAll(agency);
                SelectSupportingInformationTab();
                SupportingInformation();
                OGAsRequiredInformationTab();
                OGARequiredInformationAQD();
                OGARequiredDocumentsTab();
                OGARequiredDocumentsAQD();

                Save();
                Initilization.waitUntilElementtoLoad(40);


            }


        }
    }

    public static void GeneralInformationAll(String agency) {
        if (agency.equalsIgnoreCase("DPP")){

            Initilization.enter_Text("xpath", "//input[@placeholder='Please enter HS code']", "0601.1010" + Keys.ENTER);

            Initilization.WebDriverWait(8);
            Initilization.enter_Text("xpath", "//input[@placeholder='Please enter product code']", "9000- - - - - Bulbs (dormant): Other" + Keys.ENTER);
            Initilization.WebDriverWait(3);
            Initilization.enter_Text("name", "declaredDescription", "Some Random HSCode");
            String Unit = Initilization.randomBLNumber(2);
            Initilization.enter_Text("name", "unitValue", Unit + Keys.ENTER);
        }
        else if (agency.equalsIgnoreCase("AQD")) {
            Initilization.enter_Text("xpath", "//input[@placeholder='Please enter HS code']", "0201.1000" + Keys.ENTER);

            Initilization.WebDriverWait(4);
            Initilization.enter_Text("xpath", "//input[@placeholder='Please enter product code']", "0000- CARCASSES AND HALF- CARCASSES" + Keys.ENTER);
            Initilization.WebDriverWait(3);
            Initilization.enter_Text("name", "declaredDescription", "Some Random HSCode");
            String Unit = Initilization.randomBLNumber(2);
            Initilization.enter_Text("name", "unitValue", Unit + Keys.ENTER);
        }
    }











}
