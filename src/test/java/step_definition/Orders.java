package step_definition;

import cucumber.api.java.en.Then;
import helper.APIUtility;
import helper.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Orders extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, 30);
    private By airLineref = By.xpath("//div[@class='d-flex text-center flex-column']//h3");
    private By flyref = By.xpath("//span[@class='d-block order-link']");
    private By storeUserid = By.xpath("//small[text()='Store User']/following-sibling::strong");
    private By paymentGatwayid = By.xpath("//small[text()='Payment Gateway']/following-sibling::strong");
    private By displayedPrice = By.xpath("//small[text()='Displayed Price']/following-sibling::strong");
    private By discountCampaign = By.xpath("//small[text()='Campaign']/following-sibling::strong");
    private By discountAmount = By.xpath("//small[text()='Amount']/following-sibling::strong");


    @Then("^Assert that Airline reference is correct$")
    public void assertThatAirlineReferenceIsCorrect() throws InterruptedException {
        Thread.sleep(4000);
        Assert.assertEquals(driver.findElement(airLineref).getText().trim(),APIUtility.airLineRef);

    }

    @Then("^Assert that Fly reference is correct$")
    public void assertThatFlyReferenceIsCorrect() throws InterruptedException {
        Thread.sleep(4000);
        Assert.assertEquals(driver.findElement(flyref).getText().trim(),APIUtility.flyRef);
    }

    @Then("^Assert that store user is correct$")
    public void assertThatStoreUserIsCorrect() throws InterruptedException {
        Thread.sleep(4000);
        Assert.assertEquals(driver.findElement(storeUserid).getText(),APIUtility.storeUser);

    }

    @Then("^Assert that Payment Gateway is correct$")
    public void assertThatPaymentGatewayIsCorrect() throws InterruptedException {
        Thread.sleep(4000);
        Assert.assertEquals(driver.findElement(paymentGatwayid).getText(),APIUtility.paymentGateway);
    }

    @Then("^Assert that total price is correct$")
    public void assertThatTotalPriceIsCorrect() throws InterruptedException {
        Thread.sleep(4000);
        Assert.assertEquals(driver.findElement(displayedPrice).getText().replaceAll("0*\\D*$",""),APIUtility.totalPrice);
    }

    @Then("^Assert that Discount campaign name is correct$")
    public void assertThatDiscountCampaignNameIsCorrect() throws InterruptedException {
        Thread.sleep(4000);
        Assert.assertEquals(driver.findElement(discountCampaign).getText(),APIUtility.discountName);
    }
}
