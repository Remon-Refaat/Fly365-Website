package step_definition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import helper.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MyBookingTest extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, 10);

    private By hiHDR = By.xpath("//span[contains(text(),'Hi')]");
    private By recentBookingHDR = By.xpath("//p[text()='Your most recent bookings will show up here.']");
    private By noBookingHistoryMSG = By.xpath("//h3[text()='Sorry there is no booking history']");
    private By backToHomeBTN = By.linkText("BACK TO HOME");
    private By homePageHDR = By.xpath("//span[text()='Low Fares']");

    @And("^Click on My Booking$")
    public void clickOnMyBooking() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(hiHDR));
//        driver.findElement(By.xpath("//*[contains(@class,'el-icon--right svg-icon svg-fill')]")).click();
//        driver.findElement(By.linkText("My Account")).click();
    }

    @Then("^Check My Booking page opened$")
    public void checkMyBookingPageOpened() {
        Assert.assertEquals(driver.findElement(recentBookingHDR).getText(),"Your most recent bookings will show up here.");

    }

    @Then("^No Booking History displayed$")
    public void noBookingHistoryDisplayed() {
        Assert.assertEquals(driver.findElement(noBookingHistoryMSG).getText(),"Sorry there is no booking history");
    }

    @Then("^Back to Home Page when click on Back button$")
    public void backToHomePageWhenClickOnBackButton() {
        driver.findElement(backToHomeBTN).click();
        Assert.assertEquals(driver.findElement(homePageHDR).getText(),"Low Fares");
    }
}
