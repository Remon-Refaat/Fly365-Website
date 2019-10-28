package step_definition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import helper.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ConfirmationTest extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, 20);
    public static String fly356Refernce;


    private By bookingConfirmationSuccessfulMSG = By.xpath("//div[text()='Thank you for booking with Fly365']");
    private By fly365ReferenceHDR = By.xpath("//span[text()='Fly365 Ref.:']/following-sibling::strong");
    private By totalPriceAfterConfirmationVAL = By.xpath("//p[contains(text(),'Total')]/following-sibling::p");

    @Then("^'Thank you for booking with Fly365' message is displayed$")
    public void thankYouForBookingWithFlyMessageIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(bookingConfirmationSuccessfulMSG));
        Assert.assertTrue(driver.findElement(bookingConfirmationSuccessfulMSG).isDisplayed());
    }




    @And("^Get the 'Fly365 Ref' code$")
    public void getTheFlyRefCode() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(fly365ReferenceHDR));
        fly356Refernce = driver.findElement(fly365ReferenceHDR).getText();
    }


    @Then("^The total fare is the same before and after the booking$")
    public void theTotalFareIsTheSameBeforeAndAfterTheBooking() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(totalPriceAfterConfirmationVAL));
        String totalPriceAfterConfirmation = driver.findElement(totalPriceAfterConfirmationVAL).getText().trim();
        Assert.assertEquals(totalPriceAfterConfirmation,SearchResultTest.tripPrice);
    }
}
