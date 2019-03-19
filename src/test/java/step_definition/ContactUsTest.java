package step_definition;

import cucumber.api.java.en.Then;
import helper.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;


public class ContactUsTest extends TestBase {


    private By contactUsHDR = By.xpath("//div[2]/h1");

    @Then("^'Contact Us' page is opened$")
    public void contactUsPageIsOpened() {
                String headerText = driver.findElement(contactUsHDR).getText();
                Assert.assertEquals(headerText, "Contact Us");
    }


}
