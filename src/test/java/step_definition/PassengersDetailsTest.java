package step_definition;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import helper.GeneralMethods;
import helper.TestBase;
import org.openqa.selenium.By;

import java.util.Map;

public class PassengersDetailsTest extends TestBase {

    GeneralMethods generalMethodsObject = new GeneralMethods();

    By passengerTitleField = By.xpath("//div[@class='passenger-form mb-5'][1]//input[@placeholder='Title']");
    By passengerTitleDropDownList = By.xpath("//iframe[@name='_hjRemoteVarsFrame']//following::div[1]//ul");
    By passengerFirstNameTxt = By.xpath("//input[@placeholder='John']");
    By passengerMiddleNameTxt = By.xpath("//input[@placeholder='William']");
    By passengerLastNameTxt = By.xpath("//input[@placeholder='Smith']");
    By dayField = By.xpath("//input[@placeholder='Day']");
    By dayDropDownList = By.xpath("//body/div[4]//ul");
    By monthField = By.xpath("//input[@placeholder='Month']");
    By monthDropDownList = By.xpath("//body/div[5]//ul");
    By yearField = By.xpath("//input[@placeholder='Year']");
    By yearDropDownList = By.xpath("//body/div[6]//ul");
    By contactTitleField = By.xpath("//div[@class='contact-details-name px-12 py-10']//input[@placeholder='Title']");
    By contactTitleDropDownList = By.xpath("//body/div[7]//ul");
    By contactFirstNameTxt = By.xpath("//div[@class='contact-details-name px-12 py-10']//input[@placeholder='John']");
    By contactLastNameTxt = By.xpath("//div[@class='contact-details-name px-12 py-10']//input[@placeholder='Smith']");
    By contactEmailAddressTxt = By.xpath("//div[@class='contact-details-name px-12 py-10']//input[@placeholder='john@company.com']");
    By nextStepBTN = By.xpath("//button[text()='Next Step']");






    @And("^Add the following data in the passenger Details$")
    public void addTheFollowingDataInThePassengerDetails(DataTable passengerData) {
        for (Map<String, String> passengerDetails : passengerData.asMaps (String.class,String.class)){

            generalMethodsObject.selectFromAutoCompleteDDL(passengerTitleField, passengerTitleDropDownList, passengerDetails.get("Title"));
            driver.findElement(passengerFirstNameTxt).sendKeys(passengerDetails.get("First Name"));
            driver.findElement(passengerMiddleNameTxt).sendKeys(passengerDetails.get("Middle Name"));
            driver.findElement(passengerLastNameTxt).sendKeys(passengerDetails.get("Last Name"));
            generalMethodsObject.selectFromAutoCompleteDDL(dayField, dayDropDownList, passengerDetails.get("Day"));
            generalMethodsObject.selectFromAutoCompleteDDL(monthField, monthDropDownList, passengerDetails.get("Month"));
            generalMethodsObject.selectFromAutoCompleteDDL(yearField, yearDropDownList, passengerDetails.get("Year"));

        }
    }


    @And("^Add the following data in the Contact Details$")
    public void addTheFollowingDataInTheContactDetails(DataTable contactData) {

        for (Map<String, String> contactDetails : contactData.asMaps (String.class,String.class)){

            generalMethodsObject.selectFromAutoCompleteDDL(contactTitleField, contactTitleDropDownList, contactDetails.get("Title"));
            driver.findElement(contactFirstNameTxt).sendKeys(contactDetails.get("First Name"));
            driver.findElement(contactLastNameTxt).sendKeys(contactDetails.get("Last Name"));
            driver.findElement(contactEmailAddressTxt).sendKeys(contactDetails.get("Email"));
        }
    }

    @And("^Click on Next Step$")
    public void clickOnNextStep() throws InterruptedException {
        driver.findElement(nextStepBTN).click();
        Thread.sleep(8000);
    }



}
