package step_definition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import helper.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TopOffersTest extends TestBase {
    WebDriverWait wait = new WebDriverWait(driver, 10);

    private By bestOffersHDR = By.xpath("//h3[contains(text(),'Best Offers')]");
    private By firstOfferLNK = By.xpath("//h4[contains(text(),'upload offer')]");
    private By firstOfferHDR = By.xpath("//span[contains(text(),'upload offer')]");


    @Given("^Click on one offer from top offers$")
    public void clickOnOneOfferFromTopOffers() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(bestOffersHDR));
        driver.findElement(firstOfferLNK).click();
    }

    @Then("^Check the selected offer page open$")
    public void checkTheSelectedOfferPageOpen() {
        Assert.assertEquals(driver.findElement(firstOfferHDR).getText(), "NZ Offers 60");
    }
}
