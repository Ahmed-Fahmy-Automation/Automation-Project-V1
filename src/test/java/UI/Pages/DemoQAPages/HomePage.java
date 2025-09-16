package UI.Pages.DemoQAPages;

import UI.Base.PageBase;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage extends PageBase {

    public HomePage(WebDriver driver , WebDriverWait wait , Actions actions , JavascriptExecutor js){
        super(driver,wait , actions , js );
    }

    @Step
    public HomePage openURL(){
        driver.get("https://demoqa.com/");
        return this ;
    }

    @Step
    public HomePage clickOnElements(){
        By elementsTab = By.xpath("//h5[text()='Elements']/..");
        wait.until(ExpectedConditions.elementToBeClickable(elementsTab)).click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/elements"));
        return this ;
    }

    @Step
    public HomePage clickOnForms(){
        By elementsTab = By.xpath("//h5[text()='Forms']/..");
        wait.until(ExpectedConditions.elementToBeClickable(elementsTab)).click();
        return this ;
    }

    @Step
    public HomePage clickOnFrames(){
        By elementsTab = By.xpath("//h5[text()='//h5[text()='Alerts, Frame & Windows']/..']/..");
        wait.until(ExpectedConditions.elementToBeClickable(elementsTab)).click();
        return this ;
    }

    @Step
    public HomePage clickOnWidgets(){
        By elementsTab = By.xpath("//h5[text()='Widgets']/..");
        wait.until(ExpectedConditions.elementToBeClickable(elementsTab)).click();
        return this ;
    }

    @Step
    public HomePage clickOnInteractions(){
        By elementsTab = By.xpath("//h5[text()='Interactions']/..");
        wait.until(ExpectedConditions.elementToBeClickable(elementsTab)).click();
        return this ;
    }


}
