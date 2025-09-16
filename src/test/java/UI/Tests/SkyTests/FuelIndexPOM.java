package UI.Tests.SkyTests;

import UI.Base.TestBase;
import UI.Pages.SkyPages.ContactAndSupport;
import UI.Pages.SkyPages.FuelIndexPage;
import org.testng.annotations.Test;

public class FuelIndexPOM extends TestBase {

    @Test
    public void selectOriginCountry(){
        ContactAndSupport contactAndSupport = new ContactAndSupport(driver,wait,actions,js);
        FuelIndexPage fuelIndexPage = new FuelIndexPage(driver,wait,actions,js);

        contactAndSupport.open();
        contactAndSupport.hoverContactSupport();
        contactAndSupport.clickFuelIndex();
        fuelIndexPage.currentUrl();
        fuelIndexPage.selectOrigin("Chile");
        String currentURL = fuelIndexPage.currentUrl();
        fuelIndexPage.isCountrySelected(currentURL);
    }
}
