package UI.Tests.DemoQaTests;

import UI.Base.TestBase;
import UI.Pages.DemoQAPages.ElementsPage;
import UI.Pages.DemoQAPages.HomePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeTests extends TestBase {

    @Test
    public void elementsTest(){
        HomePage homePage = new HomePage(driver , wait , actions , js);
        homePage.openURL();
        homePage.clickOnElements();

    }
/*formsTest*/
    @Test
    public void formsTest(){
        HomePage homePage = new HomePage(driver , wait , actions , js);
        homePage.openURL();
        homePage.clickOnForms();

    }

    @Test
    public void alertsTest(){
        HomePage homePage = new HomePage(driver , wait , actions , js);
        homePage.openURL();
        homePage.clickOnFrames();

    }

    @Test
    public void widgetsTest(){
        HomePage homePage = new HomePage(driver , wait , actions , js);
        homePage.openURL();
        homePage.clickOnWidgets();

    }

    @Test
    public void interactionsTest(){
        HomePage homePage = new HomePage(driver , wait , actions , js);
        homePage.openURL();
        homePage.clickOnInteractions();

    }


}
