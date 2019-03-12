package step_definition;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import helper.GeneralMethods;
import helper.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

public class PassengersDetailsTest extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, 20);

    GeneralMethods gmObject = new GeneralMethods();
    

    By contactTitleField = By.id("contact-fullname");
    By contactFirstNameTXT = By.xpath("//div[@class='el-form-item col-sm-8 col-lg-6']//input[@placeholder='First Name']");
    By contactLastNameTXT = By.xpath("//div[@class='el-form-item col-sm-8 col-lg-6']//input[@placeholder='Family Name']");
    By contactEmailAddressTXT = By.id("contact-email");
    By nextStepBTN = By.xpath("//button[text()='Next Step']");





    @And("^Add the following data in the passenger Details$")
    public void addTheFollowingDataInThePassengerDetails(DataTable passengerData) throws InterruptedException {

        int i = 0;

        for (Map<String, String> passengerDetails : passengerData.asMaps (String.class,String.class)){

            gmObject.selectFromAutoCompleteDDL(By.id("title-"+i+""), passengerDetails.get("Title"));
            driver.findElement(By.id("firstname-"+i+"")).sendKeys(passengerDetails.get("First Name"));
            driver.findElement(By.id("middlename-"+i+"")).sendKeys(passengerDetails.get("Middle Name"));
            driver.findElement(By.id("lastName-"+i+"")).sendKeys(passengerDetails.get("Last Name"));
            gmObject.selectFromAutoCompleteDDL(By.xpath("//*[@id='birthdate-"+i+"']//input[@placeholder='Day']"), passengerDetails.get("Day"));
            gmObject.selectFromAutoCompleteDDL(By.xpath("//*[@id='birthdate-"+i+"']//input[@placeholder='Month']"), passengerDetails.get("Month"));
            gmObject.selectFromAutoCompleteDDL(By.xpath("//*[@id='birthdate-"+i+"']//input[@placeholder='Year']"), passengerDetails.get("Year"));
            i++;
        }


    }
    @And("^Add the following data in the Contact Details$")
    public void addTheFollowingDataInTheContactDetails(DataTable contactData) throws InterruptedException {

        for (Map<String, String> contactDetails : contactData.asMaps (String.class,String.class)){

            gmObject.selectFromAutoCompleteDDL(contactTitleField, contactDetails.get("Title"));
            driver.findElement(contactFirstNameTXT).sendKeys(contactDetails.get("First Name"));
            driver.findElement(contactLastNameTXT).sendKeys(contactDetails.get("Last Name"));
            driver.findElement(contactEmailAddressTXT).sendKeys(contactDetails.get("Email"));
        }
    }

    @And("^Click on Next Step$")
    public void clickOnNextStep() throws InterruptedException {
        driver.findElement(nextStepBTN).click();
        Thread.sleep(8000);
    }



}
