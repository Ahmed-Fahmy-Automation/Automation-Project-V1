package UI.Tests.DemoQaTests;

import UI.Base.TestBase;
import UI.Pages.DemoQAPages.FromsPage;
import UI.Pages.DemoQAPages.HomePage;
import org.testng.annotations.Test;

public class FormsTests extends TestBase {

    @Test
    public void testPracticeForms(){
        HomePage homePage = new HomePage(driver,wait,actions , js);
        homePage.openURL();
        homePage.clickOnForms();
        FromsPage formsPage = new FromsPage(driver,wait,actions,js);
        formsPage.selectParcticeForm ();
        formsPage.fillTheAllDataForForm("19" ,"September" ,"1994");
    }
}
