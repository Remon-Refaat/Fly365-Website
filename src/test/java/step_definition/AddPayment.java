package step_definition;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import helper.DataBase;
import helper.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.postgresql.replication.PGReplicationConnectionImpl;
import org.testng.Assert;

import java.util.Map;

public class AddPayment extends TestBase {
    WebDriverWait wait = new WebDriverWait(driver, 60);

    private By PaymentTab = By.xpath("//a[@class='account-links__link flex text-sm items-center link link-with-icon mr-5']");
    private By PaymentHeaderTXT = By.xpath("//h3[@class='text-xl font-bold']");
    private By AddPaymentBTN = By.xpath("//button[@class='btn px-3 py-2 m-auto md:mt-0 mt-4 btn-primary-second']");
    private By SavePaymentBTN = By.xpath("//button[@class='btn btn-primary-second add-button']");
    private By CardNoTXT = By.xpath("//input[@placeholder='xxxx xxxx xxxx xxxx']");
    private By CardHolderTXT = By.xpath("//input[@placeholder='John Doe']");
    private By EXPDateTXT = By.xpath("//input[@placeholder='MM/YY']");
    private By CVVTXT = By.xpath("//input[@placeholder='123']");
    private By AddedCard = By.xpath("//button[text()='ADD']");
    private By DeleteCardBTN = By.xpath("//button[text()='REMOVE CARD']");
    private By ConfirmDeleteCardBTN = By.xpath("//button[@class='btn btn-primary-second w-32 ml-2']");
    private By ConfirmDeleteTXT = By.xpath("//h3[@class='mt-8 text-xl mb-2 font-bold flex justify-center']");
    private By selectDefaultBTN = By.xpath("//button[text()='SELECT DEFAULT']");
    private By cancelBTN = By.xpath("//button[text()='CANCEL']");
    private By cardAddSuccMSG = By.xpath("//p[contains(text(),'Card addedd successfully')]");

    private String hostName = "k8stage1.cl9iojf4kdop.eu-west-1.rds.amazonaws.com:5432";
    private String dbsName = "payment_api";


    @And("^User press on payment tab$")
    public void userPressOnPaymentTab() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(PaymentTab));
        driver.findElement(PaymentTab).click();
        String pHeaderText = driver.findElement(PaymentHeaderTXT).getText();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(AddPaymentBTN));
        //Assert.assertEquals(pHeaderText, "My Credit Cards");
    }

    @And("^user press on add payment button$")
    public void userPressOnAddPaymentButton() {
        // wait.until(ExpectedConditions.visibilityOfElementLocated(AddPaymentBTN));
        driver.findElement(AddPaymentBTN).click();
        // wait.until(ExpectedConditions.visibilityOfElementLocated(AddPaymentBTN));
        String SavePaymentBTNText = driver.findElement(SavePaymentBTN).getText();
        //Assert.assertEquals(SavePaymentBTNText, "ADD");
    }

    @And("^user add Payment$")
    public void userAddPayment() {
        driver.findElement(CardNoTXT).sendKeys("4000068558002134");
        driver.findElement(CardHolderTXT).sendKeys("john");
        driver.findElement(EXPDateTXT).sendKeys("1234");
        driver.findElement(CVVTXT).sendKeys("123");
        driver.findElement(SavePaymentBTN).click();
        // Assert.assertTrue(driver.findElement(AddedCard).isDisplayed());

    }

    @And("^Delete new payment from website$")
    public void deleteNewPaymentFromWebsite() {
        driver.findElement(DeleteCardBTN).click();
        driver.findElement(ConfirmDeleteCardBTN).click();
        Assert.assertTrue(driver.findElement(ConfirmDeleteTXT).isDisplayed());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @And("^Delete payment card from database$")
    public void deletePaymentCardFromDatabase() {
        DataBase.execute_query_dbs(hostName,dbsName,"delete from user_cards where user_cards.\"lastFourDigits\" = '2134' AND user_cards.\"cardType\" = 'user_card'");
        DataBase.execute_query_dbs(hostName,dbsName,"delete from user_cards where user_cards.\"lastFourDigits\" = '4242' AND user_cards.\"cardType\" = 'user_card'");

    }

    @And("^Add the following payment card details$")
    public void addTheFollowingPaymentCardDetails(DataTable paymentDetails) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cancelBTN));

        for (Map<String, String> paymentData : paymentDetails.asMaps(String.class, String.class)) {

            driver.findElement(CardNoTXT).sendKeys(paymentData.get("Card Number"));
            driver.findElement(CardHolderTXT).sendKeys(paymentData.get("Holder Name"));
            driver.findElement(EXPDateTXT).sendKeys(paymentData.get("Expiry Date"));
            driver.findElement(CVVTXT).sendKeys(paymentData.get("CVV"));
        }
    }

    @And("^Click Save button$")
    public void clickSaveBuuton() {
        driver.findElement(SavePaymentBTN).click();
    }

    @And("^Change the default card$")
    public void changeTheDefaultCard() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectDefaultBTN));
        driver.findElement(selectDefaultBTN).click();

    }

    @And("^Add another card$")
    public void addAnotherCard() {
        driver.findElement(cancelBTN).click();
        driver.findElement(AddPaymentBTN).click();
    }

    @Then("^Success message is displayed$")
    public void successMessageIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cardAddSuccMSG));
        Assert.assertTrue(driver.findElement(cardAddSuccMSG).isDisplayed());
    }
}
