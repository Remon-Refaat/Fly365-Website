package step_definition;

import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import helper.TestBase;


public class ContactUsTest extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, 10);

    private By contactUsHDR = By.xpath("//div[2]/h1");

    @Then("^'Contact Us' page is opened$")
    public void contactUsPageIsOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(contactUsHDR));
        String headerText = driver.findElement(contactUsHDR).getText();
        Assert.assertEquals(headerText, "Contact Us");
    }


}
