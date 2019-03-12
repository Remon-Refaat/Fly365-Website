package step_definition;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import helper.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

public class PaymentTest extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, 10);


    By cardHolderNameTXT = By.id("card-holder-name");
    By cardNumberTXT = By.id("card-number");
    By cardExpireDateTXT = By.id("card-expiry-date");
    By cardCVVTXT = By.id("card-cvv");
    By addressLine1TXT = By.xpath("//input[@placeholder='Address Line 1']");
    By addressLine2TXT = By.xpath("//input[@placeholder='Address Line 2']");
    By stateTXT = By.xpath("//input[@placeholder='State']");
    By zipTXT = By.xpath("//input[@placeholder='Zip Code']");
    By acknowledgeBOX = By.xpath("//form/div[1]//span[@class='el-checkbox__inner']");
    By fareRulesBOX = By.xpath("//form/div[2]//span[@class='el-checkbox__inner']");
    By payNowBTN = By.xpath("//button[contains(text(),'PAY')]");

    @And("^Add a valid data for the credit card$")
    public void addAValidDataForTheCreditCard(DataTable paymentCardData) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(cardHolderNameTXT));

        for (Map<String, String> paymentCardDetails : paymentCardData.asMaps(String.class, String.class)) {
            driver.findElement(cardHolderNameTXT).sendKeys(paymentCardDetails.get("Card Holder Number"));
            driver.findElement(cardNumberTXT).sendKeys(paymentCardDetails.get("Card Number"));
            driver.findElement(cardExpireDateTXT).sendKeys(paymentCardDetails.get("Card Expire Date"));
            driver.findElement(cardCVVTXT).sendKeys(paymentCardDetails.get("Card CVV"));
        }


    }

    @And("^Add a valid data for the Billing Address$")
    public void addAValidDataForTheBillingAddress(DataTable billingAddressData) {

        for (Map<String,String> billingAddressDetails : billingAddressData.asMaps(String.class,String.class)){
            driver.findElement(addressLine1TXT).sendKeys(billingAddressDetails.get("Addres Line 1"));
            driver.findElement(addressLine2TXT).sendKeys(billingAddressDetails.get("Addres Line 2"));
            driver.findElement(stateTXT).sendKeys(billingAddressDetails.get("State"));
            driver.findElement(zipTXT).sendKeys(billingAddressDetails.get("Zip Code"));
        }
    }

    @And("^Select the Fare Rules and Terms and Conditions$")
    public void selectTheFareRulesAndTermsAndConditions() {
        driver.findElement(fareRulesBOX).click();

    }

    @And("^Press on Pay button$")
    public void pressOnPayButton() {
        driver.findElement(payNowBTN).click();

    }

    @And("^Select the passenger name as passport acknowledgment$")
    public void selectThePassengerNameAsPassportAcknowledgment() {
        driver.findElement(acknowledgeBOX).click();
    }
}
