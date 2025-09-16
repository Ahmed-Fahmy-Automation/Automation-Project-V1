package UI.Pages.SkyPages;

import UI.Base.PageBase;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FuelIndexPage extends PageBase {
    private final By originSearchInput = By.xpath("//input[@id='react-select-2-input']");
    private final By selectedPlaceholder = By.xpath("//div[@id='react-select-2-placeholder' or //div[contains(@class,'singleValue')]]");

    public FuelIndexPage(WebDriver d, WebDriverWait w, Actions a, JavascriptExecutor j) {
        super(d, w, a, j);
    }

    public FuelIndexPage selectOrigin(String country) {
        WebElement input = el(originSearchInput);
        actions.scrollToElement(input).perform();
        input.sendKeys(country);
        input.sendKeys(Keys.ENTER);
        return this;
    }

    public String currentUrl() {
        return driver.getCurrentUrl();
    }

    public boolean isCountrySelected(String expected) {
        // react-select renders selected value as placeholder/singleValue text
        try {
            String txt = el(By.xpath("//div[contains(@class,'singleValue') and contains(.,'" + expected + "')]")).getText();
            return txt.contains(expected);
        } catch (Exception e) {
            // fallback: placeholder text check (older render)
            return el(selectedPlaceholder).getText().contains(expected);
        }
    }
}
