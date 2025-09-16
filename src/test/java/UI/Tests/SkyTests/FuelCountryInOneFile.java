package UI.Tests.SkyTests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class FuelCountryInOneFile {

    private WebDriver driver ;
    private WebDriverWait waits ;
    private Actions actions;
    JavascriptExecutor js;

/*    private WebElement el(By by) { return wait.until(ExpectedConditions.visibilityOfElementLocated(by)); }
    private WebElement clickable(By by) { return wait.until(ExpectedConditions.elementToBeClickable(by)); }
    private void hover(WebElement e){ actions.moveToElement(e).pause(Duration.ofMillis(200)).perform(); }
    private void jsClick(WebElement e){ js.executeScript("arguments[0].click();", e); }
    private void scrollInto(WebElement e){ js.executeScript("arguments[0].scrollIntoView({block:'center'});", e); }
    private void setValueJS(WebElement e, String v){ js.executeScript("arguments[0].value=arguments[1]; arguments[0].dispatchEvent(new Event('input'));", e, v); }*/

    @BeforeClass
    public void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        waits = new WebDriverWait(driver , Duration.ofSeconds(20));
        actions = new Actions(driver);
        driver.get("https://www.skycargo.com/contact-support");
        /*Accept Cookies*/
        By acceptCookies= By.xpath("//button[@id='onetrust-accept-btn-handler' or contains(.,'Accept All')]");
        waits.until(ExpectedConditions.elementToBeClickable(acceptCookies)).click();
    }

    @Test
    public void moveToElement(){

        /*Hover on Contact Support Element*/
        By contactSupport = By.xpath("//span[@class='nav-border-active']");
        WebElement contactSupportElement = waits.until(ExpectedConditions.visibilityOfElementLocated(contactSupport));
        actions.moveToElement(contactSupportElement).pause(Duration.ofMillis(300)).perform();
        /*click on Fuel Index*/
        By fuelIndex = By.xpath("//div[@id='nav-child-Contact & Support']//a[@href='/contact-support/fuel-index/']");
        waits.until(ExpectedConditions.elementToBeClickable(fuelIndex)).click();

        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("/contact-support/fuel-index"));
        /*Scroll into Element*/
        By originSearch = By.xpath("//input[@id='react-select-2-input']");
        WebElement originSearchInput = waits.until(ExpectedConditions.visibilityOfElementLocated(originSearch));
        actions.scrollToElement(originSearchInput).perform();
        /*select Chile and Press Enter*/
        originSearchInput.sendKeys("Chile");
        originSearchInput.sendKeys(Keys.ENTER);

    }


    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) driver.quit();
    }


}
