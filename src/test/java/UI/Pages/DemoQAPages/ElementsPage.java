package UI.Pages.DemoQAPages;

import UI.Base.FileDownloadHelper;
import UI.Base.PageBase;
import com.google.common.base.CaseFormat;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static java.awt.SystemColor.desktop;

public class ElementsPage extends PageBase {

    public ElementsPage (WebDriver driver , WebDriverWait wait , Actions actions , JavascriptExecutor js ){
        super(driver , wait , actions, js);
    }


    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>TextBoxs Functions<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

    @Step ("clickOnTextBox")
    public ElementsPage clickOnTextBox(){
        By textBox = By.xpath("//li[@id='item-0']");
        wait.until(ExpectedConditions.elementToBeClickable(textBox)).click();
        return this;
    }

    @Step
    public ElementsPage enterTextBoxData(String full_Name , String email_data , String currentAdd , String permAddress){
        By fullName= By.id("userName");
        wait.until(ExpectedConditions.visibilityOfElementLocated(fullName)).sendKeys(full_Name);
        By email= By.id("userEmail");
        wait.until(ExpectedConditions.visibilityOfElementLocated(email)).sendKeys(email_data);
        By currentAddress= By.id("currentAddress");
        wait.until(ExpectedConditions.visibilityOfElementLocated(currentAddress)).sendKeys(currentAdd);
        By permeanentAdd= By.id("permanentAddress");
        wait.until(ExpectedConditions.visibilityOfElementLocated(permeanentAdd)).sendKeys(permAddress);
        By submitButton= By.id("submit");
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
        By nameOutpu = By.xpath("//div[@id='output']//p[@id='name']");
        WebElement nameOutputEl = driver.findElement(nameOutpu);
        Assert.assertFalse(nameOutputEl.getText().isEmpty());
        return this ;
    }

    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>CheckBoxs Functions<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/



    @Step("click On Check Box")
    public ElementsPage clickOnCheckBox(){
        By textBox = By.xpath("//li[@id='item-1']");
        wait.until(ExpectedConditions.elementToBeClickable(textBox)).click();
        return this;
    }

    /*@Step("click on Check All box")
    public ElementsPage checkBox_checkAll(){
        By checkAll =By.xpath("//div[@id='tree-node']//span[@class='rct-checkbox']");
        wait.until(ExpectedConditions.elementToBeClickable(checkAll)).click();
        By spans = By.xpath("//div[@id='result']/span");
        List<WebElement> spansEl = driver.findElements(spans);
        List<String> text = spansEl.stream()
                .map(WebElement::getText)
                .filter(t -> !t.isEmpty())
                .toList();
        System.out.println("All texts: " + text);
        return this;
    }*/

    @Step
    public ElementsPage checkBox_checkSpecificToggle(String value){
        By checkToggle =By.xpath("//span[@class='rct-text']/button[@title='Toggle'][@type='button']");
        wait.until(ExpectedConditions.elementToBeClickable(checkToggle)).click();
        String text ;

        switch(value) {
            case "Desktop":
                By checkDeskTop = By.xpath("//input[@id='tree-node-desktop']/following-sibling::span[@class='rct-checkbox']");
                wait.until(ExpectedConditions.elementToBeClickable(checkDeskTop)).click();
                text = driver.findElement(By.xpath("//span[@class='text-success'][1]")).getText();
                Assert.assertEquals(text , "desktop");
                break;

            case"Documents":
                By checkDocument = By.xpath("//input[@id='tree-node-documents']/following-sibling::span[@class='rct-checkbox']");
                wait.until(ExpectedConditions.elementToBeClickable(checkDocument)).click();
                text = driver.findElement(By.xpath("//span[@class='text-success'][1]")).getText();
                Assert.assertEquals(text , "documents");
                break ;
            case"Download":
                By checkDownload = By.xpath("//input[@id='tree-node-downloads']/following-sibling::span[@class='rct-checkbox']");
                wait.until(ExpectedConditions.elementToBeClickable(checkDownload)).click();
                text = driver.findElement(By.xpath("//span[@class='text-success'][1]")).getText();
                Assert.assertEquals(text , "downloads");
                break;
        }

        return this;
    }


    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Radio Buttons Functions<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

    @Step ("clickOnRadioBox")
    public ElementsPage clickOnRadioBox(){
        By textBox = By.xpath("//li[@id='item-2']");
        wait.until(ExpectedConditions.elementToBeClickable(textBox)).click();
        return this;
    }

    @Step ("clickOnYesRadioBtn")
    public ElementsPage clickOnYesRadioBtn(){
        By yesLabel = By.xpath("//label[@for='yesRadio']");
        wait.until(ExpectedConditions.elementToBeClickable(yesLabel)).click();
        By yesResult = By.xpath("//p[text()='You have selected ']/span[contains(text(),'Yes')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(yesResult));
        String text = driver.findElement(yesResult).getText();
        Assert.assertEquals(text , "Yes");
        By yesRadioBtn = By.xpath("//input[@type='radio'][@id='yesRadio']");
        Assert.assertTrue(driver.findElement(yesRadioBtn).isSelected());
        return  this ;
    }

    @Step ("clickOnImpressiveRadioBtn")
    public ElementsPage clickOnImpressiveRadioBtn(){
        By impressiveLabel = By.xpath("//label[@for='impressiveRadio']");
        wait.until(ExpectedConditions.elementToBeClickable(impressiveLabel)).click();
        By impressiveText = By.xpath("//p[text()='You have selected ']/span[text()='Impressive']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(impressiveText));
        String text = driver.findElement(impressiveText).getText();
        Assert.assertEquals(text , "Impressive");
        By impressiveRadioBtn = By.xpath("//input[@id='impressiveRadio']");
        Assert.assertTrue(driver.findElement(impressiveRadioBtn).isSelected());
        return  this ;
    }

    @Step("clickOnNoRadioBtn")
    public ElementsPage clickOnNoRadioBtn(){
        //By noLabel = By.xpath("//label[@for='noRadio']");
        By noLabel = By.xpath("//input[@id='noRadio']");
        Assert.assertFalse(driver.findElement(noLabel).isEnabled());
        return this ;
    }

    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Web Tables Functions<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

    @Step ("clickOnWebTables")
    public ElementsPage clickOnWebTables(){
        By textBox = By.xpath("//li[@id='item-3']");
        wait.until(ExpectedConditions.elementToBeClickable(textBox)).click();
        return this;
    }

    @Step("ClickOnAddButton")
    public ElementsPage clickOnAddBtnWebTables(String fName , String lName ,String email , String age,
                                               String salary , String department){
        By addBtn = By.xpath("//button[@id='addNewRecordButton']");
        wait.until(ExpectedConditions.elementToBeClickable(addBtn)).click();
        By firstNameTxt = By.xpath("//input[@id='firstName']");
        driver.findElement(firstNameTxt).sendKeys(fName);
        By lastNameTxt = By.xpath("//input[@id='lastName']");
        driver.findElement(lastNameTxt).sendKeys(lName);
        By emailTxt = By.xpath("//input[@id='userEmail']");
        driver.findElement(emailTxt).sendKeys(email);
        By ageTxt = By.xpath("//input[@id='age']");
        driver.findElement(ageTxt).sendKeys(age);
        By salaryTxt = By.xpath("//input[@id='salary']");
        driver.findElement(salaryTxt).sendKeys(salary);
        By DepartmentTxt = By.xpath("//input[@id='department']");
        driver.findElement(DepartmentTxt).sendKeys(department);
        By submitBtn = By.xpath("//button[@id='submit']");
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
        By tableResult = By.xpath("//div[text()='"+fName+"']");
        Assert.assertTrue(driver.findElement(tableResult).isDisplayed());
        return this ;
    }

    @Step("editOnTable")
    public ElementsPage editOnTable(String searchData , String newData){
        By searchTxtbox = By.xpath("//input[@id='searchBox']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchTxtbox)).sendKeys(searchData);
        By editBtn = By.xpath("//span[@id='edit-record-4']");
        wait.until(ExpectedConditions.elementToBeClickable(editBtn)).click();
        By firstNameTxt = By.xpath("//input[@id='firstName']");
        driver.findElement(firstNameTxt).clear();
        driver.findElement(firstNameTxt).sendKeys(newData);
        By submitBtn = By.xpath("//button[@id='submit']");
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
        By tableResult = By.xpath("//div[text()='"+newData+"']");
        Assert.assertTrue(driver.findElement(tableResult).isDisplayed());
        return this ;
    }

    @Step("deleteFromTable")
    public ElementsPage deleteFromTable(String searchData ){
        By searchTxtbox = By.xpath("//input[@id='searchBox']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchTxtbox)).sendKeys(searchData);
        By deleteBtn = By.xpath("//span[@id='delete-record-4']");
        wait.until(ExpectedConditions.elementToBeClickable(deleteBtn)).click();
        By tableEmptyResult = By.xpath("//div[text()='No rows found']");
        Assert.assertTrue(driver.findElement(tableEmptyResult).isDisplayed());
        return this ;
    }



    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Buttons Functions<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

    @Step ("clickOnButtons")
    public ElementsPage clickOnButtons(){
        By textBox = By.xpath("//li[@id='item-4']");
        wait.until(ExpectedConditions.elementToBeClickable(textBox)).click();
        return this;
    }

    @Step ("Double Click Action")
    public ElementsPage doubleClickAction(){
        By doubleClickBtn = By.id("doubleClickBtn");
        wait.until(ExpectedConditions.elementToBeClickable(doubleClickBtn));
        actions.doubleClick(driver.findElement(doubleClickBtn)).pause(Duration.ofMillis(300)).perform();
        By doubleClickResult = By.id("doubleClickMessage");
        wait.until(ExpectedConditions.visibilityOfElementLocated(doubleClickResult));
        Assert.assertTrue(driver.findElement(doubleClickResult).isDisplayed());
        return this;

    }

    @Step ("Right Click Action")
    public ElementsPage rightClickAction(){
        By rightClickBtn = By.id("rightClickBtn");
        wait.until(ExpectedConditions.visibilityOfElementLocated(rightClickBtn));
        actions.contextClick(driver.findElement(rightClickBtn)).pause(Duration.ofMillis(300)).perform();
        By rightClickReults = By.id("rightClickMessage");
        wait.until(ExpectedConditions.visibilityOfElementLocated(rightClickReults));
        Assert.assertTrue(driver.findElement(rightClickReults).isDisplayed());
        return this ;
    }

    @Step ("Click Me Action")
    public ElementsPage clickMeAction(){
        By clickMeBtn = By.xpath("//button[text()='Click Me']");
        wait.until(ExpectedConditions.elementToBeClickable(clickMeBtn)).click();
        By clickMeReults = By.id("dynamicClickMessage");
        wait.until(ExpectedConditions.visibilityOfElementLocated(clickMeReults));
        Assert.assertTrue(driver.findElement(clickMeReults).isDisplayed());
        return this ;
    }


    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Links Functions<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/


    @Step ("clickOnLinks")
    public ElementsPage clickOnLinks(){
        By textBox = By.xpath("//li[@id='item-5']");
        wait.until(ExpectedConditions.elementToBeClickable(textBox)).click();
        return this;
    }

    @Step ("Links to open new tab")
    public ElementsPage linkToOpenNewTab(){
        By homeLink = By.id("simpleLink");
        wait.until(ExpectedConditions.elementToBeClickable(homeLink)).click();
        List <String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String secondTabURL = driver.getCurrentUrl();
        Assert.assertEquals("https://demoqa.com/", secondTabURL);
        return this ;
    }

    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Links Images Functions<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/


    @Step ("clickOnBrokenLinksImage")
    public ElementsPage clickOnBrokenLinksImage(){
        By textBox = By.xpath("//li[@id='item-6']");
        wait.until(ExpectedConditions.elementToBeClickable(textBox)).click();
        return this;
    }


    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Upload and Download Functions<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/


    @Step ("clickOnUploadAndDownload")
    public ElementsPage clickOnUploadAndDownload(){
        By textBox = By.xpath("//li[@id='item-7']");
        wait.until(ExpectedConditions.elementToBeClickable(textBox)).click();
        return this;
    }

    @Step ("Download Actions")
    public ElementsPage clickOnDownloadLink()  {
        By downloadBtn = By.id("downloadButton");
        wait.until(ExpectedConditions.elementToBeClickable(downloadBtn)).click();
        return this ;
    }

    @Step ("Upload Actions")
    public ElementsPage clickOnUploadLink()  {
        By chooseFileBtn = By.xpath("//input[@id='uploadFile']");
        Assert.assertTrue(driver.findElement(chooseFileBtn).isDisplayed());
        WebElement fileInput = wait.until(ExpectedConditions.presenceOfElementLocated(chooseFileBtn));
        fileInput.sendKeys("C:\\Users\\ahmed.fahmy\\Desktop\\ApiPracticle\\DownloadAndUpload\\Upload\\sampleFile.jpeg");
        return this ;
    }

    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Dynamic Property Functions<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/


    @Step ("clickOnDynamicPropoerty")
    public ElementsPage clickOnDynamicPropoerty() {
        By textBox = By.xpath("//li[@id='item-8']");
        scrollInto(textBox);
        wait.until(ExpectedConditions.elementToBeClickable(textBox)).click();
        return this;
    }


    @Step
    public ElementsPage clickOnDynamicBtn (){
        By enableAfterBtn = By.id("enableAfter");
        wait.until(ExpectedConditions.elementToBeClickable(enableAfterBtn)).click();
        Assert.assertTrue(driver.findElement(enableAfterBtn).isEnabled());
        By visibleAfterBtn = By.id("visibleAfter");
        wait.until(ExpectedConditions.visibilityOfElementLocated(visibleAfterBtn));
        Assert.assertTrue(driver.findElement(visibleAfterBtn).isDisplayed());
        return this ;
    }
}
