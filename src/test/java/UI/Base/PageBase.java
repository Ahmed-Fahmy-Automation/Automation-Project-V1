package UI.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class PageBase {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    protected JavascriptExecutor js;

    protected PageBase(WebDriver driver, WebDriverWait wait, Actions actions, JavascriptExecutor js) {
        this.driver = driver; this.wait = wait; this.actions = actions; this.js = js;
    }


    protected WebElement el(By by) { return wait.until(ExpectedConditions.visibilityOfElementLocated(by)); }
    protected WebElement clickable(By by) { return wait.until(ExpectedConditions.elementToBeClickable(by)); }
    protected void hover(By by){ actions.moveToElement(el(by)).pause(Duration.ofMillis(200)).perform(); }
    protected void jsClick(By by){ js.executeScript("arguments[0].click();", el(by)); }
    protected void scrollInto(By by){ js.executeScript("arguments[0].scrollIntoView({block:'center'});", el(by)); }
}