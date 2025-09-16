package UI.Pages.DemoQAPages;

import UI.Base.PageBase;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.Format;
import java.time.Duration;
import java.util.List;

public class FromsPage extends PageBase {

    public FromsPage(WebDriver driver , WebDriverWait wait , Actions actions , JavascriptExecutor js){
        super(driver , wait , actions , js);
    }

    @Step
    public FromsPage selectParcticeForm(){
        By practiceForm = By.xpath("//span[text()='Practice Form']/..");
        wait.until(ExpectedConditions.elementToBeClickable(practiceForm))
                .click();
        return this;
    }

    @Step
    public FromsPage fillTheAllDataForForm(String day ,String month ,String year) {

        By firstNameTxt = By.id("firstName");
        By lastNameTxt = By.id("lastName");
        By userEmailTxt = By.id("userEmail");
        By maleChoice = By.xpath("//label[@for='gender-radio-1']");
        By userNumberTxt = By.id("userNumber");
        By datePicker = By.id("dateOfBirthInput");
        By datepicker__year_list = By.xpath("//select[@class='react-datepicker__year-select']/option");
        By datepicker__month = By.xpath("//select[@class='react-datepicker__month-select']/option");
        By datepicker__day = By.xpath("//div[text()='"+day+"']");
        By subjectTxt = By.xpath("//div[@id='subjectsContainer']/div/div[1]");
        By sportHobbiesBox = By.xpath("//label[@for='hobbies-checkbox-1']");
        By readingHobbiesBox = By.xpath("//label[@for='hobbies-checkbox-2']");
        By musicHobbiesBox = By.xpath("//label[@for='hobbies-checkbox-3']");
        By chooseFileInput = By.id("uploadPicture");
        By currentAddressTxtArea = By.id("currentAddress");
        By selectState = By.xpath("//div[@id='stateCity-wrapper']/div[2]/div");
        By selectCity = By.xpath("//div[@id='stateCity-wrapper']/div[3]");
        By submitBtn = By.id("submit");


        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameTxt))
                .sendKeys("Ahmed");
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameTxt))
                .sendKeys("Yahya");
        wait.until(ExpectedConditions.visibilityOfElementLocated(userEmailTxt))
                .sendKeys("Ahmed@gmail.com");
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(maleChoice)))
                .click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(userNumberTxt))
                .sendKeys("9715033060");
        wait.until(ExpectedConditions.visibilityOfElementLocated(datePicker)).click();
        List<WebElement> yearlist = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(datepicker__year_list));
        List<WebElement>monthList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(datepicker__month));
        for (WebElement selectedYear : yearlist){
            if (selectedYear.getText().equalsIgnoreCase(year)){
                selectedYear.click();
                break;
            }
        }
        for (WebElement months : monthList){
            if (months.getText().equalsIgnoreCase(month)){
                months.click();
                break;
            }
        }
        wait.until(ExpectedConditions.elementToBeClickable(subjectTxt)).click();
        actions.sendKeys(driver.findElement(subjectTxt),"English").pause(Duration.ofMillis(500)).perform();
        actions.sendKeys(Keys.ENTER).perform();
        wait.until(ExpectedConditions.elementToBeClickable(sportHobbiesBox))
                .click();
        wait.until(ExpectedConditions.elementToBeClickable(readingHobbiesBox))
                .click();
        wait.until(ExpectedConditions.elementToBeClickable(musicHobbiesBox))
                .click();
        WebElement chooseFileInputEl = wait.until(ExpectedConditions.presenceOfElementLocated(chooseFileInput));
        chooseFileInputEl.sendKeys("C:\\Users\\ahmed.fahmy\\Desktop\\ApiPracticle\\DownloadAndUpload\\Upload\\sampleFile.jpeg");
        wait.until(ExpectedConditions.visibilityOfElementLocated(currentAddressTxtArea))
                .sendKeys("Ahmed Fahmy");
        wait.until(ExpectedConditions.elementToBeClickable(selectState)).click();
        actions.sendKeys(driver.findElement(selectState),"NCR");
        actions.sendKeys(Keys.ENTER).perform();
        wait.until(ExpectedConditions.elementToBeClickable(selectCity)).click();
        actions.sendKeys(driver.findElement(selectCity),"Delhi");
        actions.sendKeys(Keys.ENTER).perform();
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn))
                .click();
        return this;

    }
}
