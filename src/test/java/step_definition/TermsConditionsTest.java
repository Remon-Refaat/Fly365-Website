package step_definition;

import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import helper.TestBase;


public class TermsConditionsTest extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, 10);


    By termsConditionsLink = By.xpath("//a[@class='link text-sm font-normal mr-5 router-link-exact-active router-link-active']");

    @Then("^'Terms and Conditions' page is opened$")
    public void termsAndConditionsPageIsOpened() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(termsConditionsLink));
        String headerText = driver.findElement(termsConditionsLink).getText();
        Assert.assertEquals(headerText, "Terms and Conditions");
    }
}
