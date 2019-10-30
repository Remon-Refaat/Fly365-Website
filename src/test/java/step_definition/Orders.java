package step_definition;

import cucumber.api.java.en.Then;
import helper.APIUtility;
import helper.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Orders extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, 30);
    private By airLineref = By.xpath("//div[@class='d-flex text-center flex-column']//h3");
    private By flyref = By.xpath("//span[@class='d-block order-link']");

    @Then("^Assert that Airline reference is correct$")
    public void assertThatAirlineReferenceIsCorrect() throws InterruptedException {
        Assert.assertEquals(driver.findElement(airLineref).getText().trim(),APIUtility.airLineRef);

    }

    @Then("^Assert that Fly reference is correct$")
    public void assertThatFlyReferenceIsCorrect() {
        Assert.assertEquals(driver.findElement(flyref).getText().trim(),APIUtility.flyRef);
    }
}
