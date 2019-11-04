package step_definition;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import helper.GeneralMethods;
import helper.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Map;

public class PassengersDetailsTest extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, 40);

    private GeneralMethods gmObject = new GeneralMethods();


    private By contactTitleField = By.id("contact-fullname");
    private By contactFirstNameTXT = By.xpath("//div[@class='el-form-item col-sm-8 col-lg-6']//input[@placeholder='First Name']");
    private By contactLastNameTXT = By.xpath("//div[@class='el-form-item col-sm-8 col-lg-6']//input[@placeholder='Family Name']");
    private By contactEmailAddressTXT = By.id("contact-email");
    private By phoneNumbereTXT = By.xpath("//*[@id='contact-details']/div[4]/div[2]/div/div/div[1]/div/input");
    private By nextStepBTN = By.xpath("//button[text()='Next Step']");
    private By firstReadMoreLINK = By.xpath("//p/a[1]");
    private By secondReadMoreLINK = By.xpath("//p/a[2]");
    private By flightDetailsLink = By.xpath("//li/div/div/div[1]/div[3]");
    private By firstReadMoreHDR = By.xpath("//div[@class='el-dialog__wrapper'][1]/div[1]/div[1]/span");
    private By secondReadMoreHDR = By.xpath("//div[@class='el-dialog__wrapper'][2]/div[1]/div[1]/span");
    private By totalTravelTimeHDR = By.xpath("//div[3]//div[2]/div/div/div[1]/div/div[1]");
    private By passengerTitleEmptyErrorMSG = By.xpath("//span[contains(text(),'Please enter title')]");
    private By passenegerFirstNameEmptyErrorMSG = By.xpath("//body/div[@class='app-container']/div[@class='relative router-view-container border-t border-primary-first']/div[@class='passengers bg-secondary-fourth']/div[@class='content-passengers container md:px-0 px-8']/div[@class='row']/div[@class='col-lg-16 col-sm-24']/div[@id='passenger-form-0']/div/div[@class='bg-white lg:px-12 px-3 pt-10 pb-5']/div[@class='col-md-24 passenger-form']/form[@class='el-form passenger-form__content']/div[@class='first-name-container mb-4']/div[@class='flex flex-col']/div[@class='form-items flex flex-col md:flex-row justify-between items-center']/div[@class='row']/div[2]/div[1]/div[1]/div[2]/span[1]");
    private By passenegerLastNameEmptyErrorMSG = By.xpath("//body/div[@class='app-container']/div[@class='relative router-view-container border-t border-primary-first']/div[@class='passengers bg-secondary-fourth']/div[@class='content-passengers container md:px-0 px-8']/div[@class='row']/div[@class='col-lg-16 col-sm-24']/div[@id='passenger-form-0']/div/div[@class='bg-white lg:px-12 px-3 pt-10 pb-5']/div[@class='col-md-24 passenger-form']/form[@class='el-form passenger-form__content']/div[@class='first-name-container mb-4']/div[@class='flex flex-col']/div[@class='form-items flex flex-col md:flex-row justify-between items-center']/div[@class='row']/div[4]/div[1]/div[1]/div[2]/span[1]");
    private By PassengerBirthDateEmptyErrorMSG = By.xpath("//div[@class='col-md-14']//span[@class='tooltiptext with-arrow']");
    private By ContactDetialsTitleEmptyErroeMSG = By.xpath("//div[@class='el-form-item col-sm-8 col-lg-3 is-error']//span[@class='tooltiptext with-arrow']");
    private By ContactdetailsFirstNameEmptyErrorMSG = By.xpath("//body/div[@class='app-container']/div[@class='relative router-view-container border-t border-primary-first']/div[@class='passengers bg-secondary-fourth']/div[@class='content-passengers container md:px-0 px-8']/div[@class='row']/div[@class='col-lg-16 col-sm-24']/div[@class='contact-details passengers-details bg-white rounded md:mb-5 mb-3']/div[@class='contact-details-name lg:px-12 px-6 py-10']/div[@class='row']/div[@class='contact-details-form col-24']/div[@class='w-full col-lg-24 mb-0 md:mb-5']/form[@id='contact-details']/div[@class='row mb-3 md:mb-5']/div[3]/div[1]/div[2]/span[1]");
    private By ContactDetailsLastNameEmptyErrorMSG = By.xpath("//body/div[@class='app-container']/div[@class='relative router-view-container border-t border-primary-first']/div[@class='passengers bg-secondary-fourth']/div[@class='content-passengers container md:px-0 px-8']/div[@class='row']/div[@class='col-lg-16 col-sm-24']/div[@class='contact-details passengers-details bg-white rounded md:mb-5 mb-3']/div[@class='contact-details-name lg:px-12 px-6 py-10']/div[@class='row']/div[@class='contact-details-form col-24']/div[@class='w-full col-lg-24 mb-0 md:mb-5']/form[@id='contact-details']/div[@class='row mb-3 md:mb-5']/div[4]/div[1]/div[2]/span[1]");
    private By ContactDetailsEmailEmptyErrorMSg = By.xpath("//div[@class='col-lg-15']//div[@class='el-form-item is-error']//span[@class='tooltiptext with-arrow']");
    private By ContactDetailsPhoneEmptyErrorMSG = By.xpath("//div[@class='col-lg-15']//div[@class='el-form-item w-full is-error']//span[@class='tooltiptext with-arrow']");
    private By holdHoursMSG = By.xpath("//small[@class='pl-2 mt-2 text-primary-fourth']");

    @And("^Add the following data in the passenger Details$")
    public void addTheFollowingDataInThePassengerDetails(DataTable passengerData) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nextStepBTN));
        int i = 0;

        for (Map<String, String> passengerDetails : passengerData.asMaps(String.class, String.class)) {

            gmObject.selectFromDDL(By.id("title-" + i + ""), passengerDetails.get("Title"));
            driver.findElement(By.id("passenger-firstname-" + i + "")).sendKeys(passengerDetails.get("First Name"));
            driver.findElement(By.id("middlename-" + i + "")).sendKeys(passengerDetails.get("Middle Name"));
            driver.findElement(By.id("lastName-" + i + "")).sendKeys(passengerDetails.get("Last Name"));
            gmObject.selectFromDDL(By.xpath("//*[@id='birthdate-" + i + "']//input[@placeholder='Day']"), passengerDetails.get("Day"));
            gmObject.selectFromDDL(By.xpath("//*[@id='birthdate-" + i + "']//input[@placeholder='Month']"), passengerDetails.get("Month"));
            gmObject.selectFromDDL(By.xpath("//*[@id='birthdate-" + i + "']//input[@placeholder='Year']"), passengerDetails.get("Year"));
            i++;
        }


    }

    @And("^Add the following data in the Contact Details$")
    public void addTheFollowingDataInTheContactDetails(DataTable contactData) throws InterruptedException {

        for (Map<String, String> contactDetails : contactData.asMaps(String.class, String.class)) {

            gmObject.selectFromDDL(contactTitleField, contactDetails.get("Title"));
            driver.findElement(contactFirstNameTXT).sendKeys(contactDetails.get("First Name"));
            driver.findElement(contactLastNameTXT).sendKeys(contactDetails.get("Last Name"));
            driver.findElement(contactEmailAddressTXT).sendKeys(contactDetails.get("Email"));
            driver.findElement(phoneNumbereTXT).sendKeys(contactDetails.get("Phone Number"));
        }
    }

    @And("^Click on Next Step$")
    public void clickOnNextStep() {
        driver.findElement(nextStepBTN).click();
    }


    @Then("^'Passenger' page will be opened$")
    public void passengerPageWillBeOpened() {
        Assert.assertEquals(driver.getTitle(), "Fly365 - passengers");
    }

    @And("^Press on first 'Read more'$")
    public void pressOnFirstReadMore() {
        driver.findElement(firstReadMoreLINK).click();
    }

    @And("^Press on second 'Read more'$")
    public void pressOnSecondReadMore() {
        driver.findElement(secondReadMoreLINK).click();
    }

    @And("^Press on 'Flights Details'$")
    public void pressOnFlightsDetails() {
        driver.findElement(flightDetailsLink).click();
    }

    @Then("^'If you have one name' pop up will be opened$")
    public void ifYouHaveOneNamePopUpWillBeOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstReadMoreHDR));
        Assert.assertEquals("If you have one name", driver.findElement(firstReadMoreHDR).getText());
    }

    @Then("^'Correct name format' pop up will be opened$")
    public void correctNameFormatPopUpWillBeOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(secondReadMoreHDR));
        Assert.assertEquals("Correct name format", driver.findElement(secondReadMoreHDR).getText());
    }

    @Then("^'Flights Details' is displayed$")
    public void flightsDetailsIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(totalTravelTimeHDR));
        Assert.assertTrue(driver.findElement(totalTravelTimeHDR).isDisplayed());
    }

    @Then("^error message appear for each field at fill passenger details$")
    public void errorMessageAppearForEachFieldAtFillPassengerDetails() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passengerTitleEmptyErrorMSG));
        String passnegerEmptyTitle = driver.findElement(passengerTitleEmptyErrorMSG).getText();
        Assert.assertEquals(passnegerEmptyTitle, "Please enter title");

        String passenegeremptyfirstname = driver.findElement(passenegerFirstNameEmptyErrorMSG).getText();
        Assert.assertEquals(passenegeremptyfirstname, "!Please enter first name");

        String passenegeremptylastname = driver.findElement(passenegerLastNameEmptyErrorMSG).getText();
        Assert.assertEquals(passenegeremptylastname, "!Please enter family name");

        String passenegeremptybirthdate = driver.findElement(PassengerBirthDateEmptyErrorMSG).getText();
        Assert.assertEquals(passenegeremptybirthdate, "!Please enter birth date");

        String ContactEmptyTitle = driver.findElement(ContactDetialsTitleEmptyErroeMSG).getText();
        Assert.assertEquals(ContactEmptyTitle, "!Please enter title");

        String ContactemptyFirstname = driver.findElement(ContactdetailsFirstNameEmptyErrorMSG).getText();
        Assert.assertEquals(ContactemptyFirstname, "!Please enter first name");

        String ContactemptyLastName = driver.findElement(ContactDetailsLastNameEmptyErrorMSG).getText();
        Assert.assertEquals(ContactemptyLastName, "!Please enter family name");

        String Contactemptyemail = driver.findElement(ContactDetailsEmailEmptyErrorMSg).getText();
        Assert.assertEquals(Contactemptyemail, "!Please enter email");

        String ContactemptyPhone = driver.findElement(ContactDetailsPhoneEmptyErrorMSG).getText();
        Assert.assertEquals(ContactemptyPhone, "!Please enter Phone Number");

    }

    @Then("^Hold hours is displayed with this value \"([^\"]*)\" correctly in passenger details$")
    public void holdHoursIsDisplayedWithThisValueCorrectlyInPassengerDetails(String holdHours) throws Throwable {
        wait.until(ExpectedConditions.visibilityOfElementLocated(holdHoursMSG));
        WebElement holdHoursmsgElmnt = driver.findElement(holdHoursMSG);
        Assert.assertEquals(holdHoursmsgElmnt.getText() , "(Valid for "+holdHours+" hours )");

    }
}
