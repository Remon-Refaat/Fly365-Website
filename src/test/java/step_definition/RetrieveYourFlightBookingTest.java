package step_definition;

import cucumber.api.java.en.Then;
import helper.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RetrieveYourFlightBookingTest extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, 10);

    private By retrieveYourFlightBookingHDR = By.xpath("//div[text()='Retrieve your flight booking']");
    private By fly365RefHDR = By.xpath("//strong[@class='txt-primary-second font-semibold ml-1']");
    private By airlineRefHDR = By.xpath("//strong[@class='text-primary-first font-semibold ml-1']");

//    @Then("^The system will retrieve the details of the Booking for this \"(.*)\"$")
//    public void theSystemWillRetrieveTheDetailsOfTheBookingForThis(String reference) {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(retrieveYourFlightBookingHDR));
//        if (reference.equals("Fly365 Reference")) {
//            Assert.assertEquals(HomeTest.orderNumber, driver.findElement(fly365RefHDR).getText());
//        }
//        if (reference.equals("Airline Reference")) {
//            Assert.assertEquals(HomeTest.pnrNumber, driver.findElement(airlineRefHDR).getText());
//        }
//    }

}
