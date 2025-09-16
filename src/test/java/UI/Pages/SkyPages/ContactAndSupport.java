package UI.Pages.SkyPages;

import UI.Base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class ContactAndSupport extends PageBase {


    private final By acceptCookies = By.xpath("//button[@id='onetrust-accept-btn-handler' or contains(.,'Accept All')]");
    private final By contactSupport = By.xpath("//span[@class='nav-border-active']");
    private final By fuelIndex = By.xpath("//div[@id='nav-child-Contact & Support']//a[@href='/contact-support/fuel-index/']");

    public ContactAndSupport(WebDriver driver, WebDriverWait wait, Actions actions, JavascriptExecutor js) {
        super(driver, wait, actions, js);
    }

    public ContactAndSupport open() {
        driver.get("https://www.skycargo.com/contact-support");
        // accept cookies if present
        try { clickable(acceptCookies).click(); } catch (Exception ignored) {}
        return this;
    }

    public ContactAndSupport hoverContactSupport() {
        hover(contactSupport);
        return this;
    }

    public FuelIndexPage clickFuelIndex() {
        clickable(fuelIndex).click();
        wait.until(ExpectedConditions.urlContains("/contact-support/fuel-index"));
        return new FuelIndexPage(driver, wait, actions, js);
    }
}

