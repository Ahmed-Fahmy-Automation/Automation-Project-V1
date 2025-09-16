package UI.Tests.DemoQaTests;

import UI.Base.TestBase;
import UI.Pages.DemoQAPages.ElementsPage;
import UI.Pages.DemoQAPages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class ElementsTests extends TestBase {

    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>TextBox Tests<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

    @Test
    public void testTextBox (){
        HomePage homePage = new HomePage(driver , wait , actions , js );
        homePage.openURL();
        homePage.clickOnElements();
        ElementsPage elementsPage = new ElementsPage(driver,wait,actions,js);
        elementsPage.clickOnTextBox();
        elementsPage.enterTextBoxData("Ahmed Yahia" , "Ahmed@gmail.com" , "Dubai","Dubai");
    }

    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>CheckBox Tests<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

    @Test
    public void testCheckAllBox(){
        HomePage homePage = new HomePage(driver , wait , actions , js);
        homePage.openURL();
        homePage.clickOnElements();
        ElementsPage elementsPage = new ElementsPage(driver, wait , actions , js);
        elementsPage.clickOnCheckBox();
        //elementsPage.checkBox_checkAll();
    }

    @Test
    public void testSpecificCheckBox(){
        HomePage homePage = new HomePage(driver , wait , actions , js);
        homePage.openURL();
        homePage.clickOnElements();
        ElementsPage elementsPage = new ElementsPage(driver, wait , actions , js);
        elementsPage.clickOnCheckBox();
        elementsPage.checkBox_checkSpecificToggle("Download");
    }

    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Radio Buttons Tests<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

    @Test
    public void testYesRadioBtn(){
        HomePage homePage = new HomePage(driver , wait , actions , js);
        homePage.openURL();
        homePage.clickOnElements();
        ElementsPage elementsPage = new ElementsPage(driver, wait , actions , js );
        elementsPage.clickOnRadioBox();
        elementsPage.clickOnYesRadioBtn();
    }


    @Test
    public void testImpressiveRadioBtn(){
        HomePage homePage = new HomePage(driver , wait , actions , js);
        homePage.openURL();
        homePage.clickOnElements();
        ElementsPage elementsPage = new ElementsPage(driver, wait , actions , js );
        elementsPage.clickOnRadioBox();
        elementsPage.clickOnImpressiveRadioBtn();
    }


    @Test
    public void testNoRadioBtn(){
        HomePage homePage = new HomePage(driver , wait , actions , js);
        homePage.openURL();
        homePage.clickOnElements();
        ElementsPage elementsPage = new ElementsPage(driver, wait , actions , js );
        elementsPage.clickOnRadioBox();
        elementsPage.clickOnNoRadioBtn();
    }

    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>WebTables Functions<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

    @Test
    public void testAddNewRecordInWebTabel(){
        HomePage homePage = new HomePage(driver , wait , actions , js );
        homePage.openURL();
        homePage.clickOnElements();
        ElementsPage elementsPage = new ElementsPage(driver , wait , actions , js);
        elementsPage.clickOnWebTables();
        elementsPage.clickOnAddBtnWebTables("Ahmed" ,"Yahya" , "Ahmed@gmail.com","31",
                "10" , "IT");
    }

    @Test
    public void testEditOnRecordInWebTable(){
        HomePage homePage = new HomePage(driver, wait , actions , js );
        homePage.openURL();
        homePage.clickOnElements();
        ElementsPage elementsPage = new ElementsPage(driver , wait , actions , js );
        elementsPage.clickOnWebTables();
        elementsPage.clickOnAddBtnWebTables("Ahmed" , "Fahmy" , "Ahmed@gmail.com" , "31" , "10" , "IT");
        elementsPage.editOnTable("Ahmed" , "Ahmeeed");

    }

    @Test
    public void testDeleteOnRecordInWebTable(){
        HomePage homePage = new HomePage(driver, wait , actions , js );
        homePage.openURL();
        homePage.clickOnElements();
        ElementsPage elementsPage = new ElementsPage(driver , wait , actions , js );
        elementsPage.clickOnWebTables();
        elementsPage.clickOnAddBtnWebTables("Ahmed" , "Fahmy" , "Ahmed@gmail.com" , "31" , "10" , "IT");
        elementsPage.deleteFromTable("Ahmed");
    }

    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Buttons Functions<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
    @Test
    public void testDoubleClick(){
        HomePage homePage = new HomePage(driver , wait , actions , js);
        homePage.openURL();
        homePage.clickOnElements();
        ElementsPage elementsPage = new ElementsPage(driver , wait , actions , js );
        elementsPage.clickOnButtons();
        elementsPage.doubleClickAction();
    }

    @Test
    public void testRightClick(){
        HomePage homePage = new HomePage(driver , wait , actions , js);
        homePage.openURL();
        homePage.clickOnElements();
        ElementsPage elementsPage = new ElementsPage(driver , wait, actions , js );
        elementsPage.clickOnButtons();
        elementsPage.rightClickAction();
    }

    @Test
    public void testSingelClick(){
        HomePage homePage = new HomePage(driver , wait , actions , js);
        homePage.openURL();
        homePage.clickOnElements();
        ElementsPage elementsPage = new ElementsPage(driver , wait, actions , js );
        elementsPage.clickOnButtons();
        elementsPage.clickMeAction();
    }


    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Links Functions<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

    @Test
    public void testOpenNewTab(){
        HomePage homePage = new HomePage(driver , wait , actions , js);
        homePage.openURL();
        homePage.clickOnElements();
        ElementsPage elementsPage = new ElementsPage(driver , wait, actions , js );
        elementsPage.clickOnLinks();
        elementsPage.linkToOpenNewTab();


    }

    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Download and Uploads Functions<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

    @Test
    public void testDownloadAction ()  {
        HomePage homePage = new HomePage(driver , wait , actions , js );
        homePage.openURL();
        homePage.clickOnElements();
        ElementsPage elementsPage = new ElementsPage(driver , wait , actions , js);
        elementsPage.clickOnUploadAndDownload();
        elementsPage.clickOnDownloadLink();
        elementsPage.clickOnUploadLink();
    }

    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Dynamic Element Functions<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

    @Test
    public void testDynamicElement (){
        HomePage homePage = new HomePage(driver,wait,actions,js);
        homePage.openURL();
        homePage.clickOnElements();
        ElementsPage elementsPage = new ElementsPage(driver , wait , actions , js);
        elementsPage.clickOnDynamicPropoerty();
        elementsPage.clickOnDynamicBtn();
    }


}
