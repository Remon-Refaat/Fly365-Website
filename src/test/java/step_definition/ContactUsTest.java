package step_definition;

import cucumber.api.java.en.Then;
import helper.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;


public class ContactUsTest extends TestBase {


    private By contactUsHDR = By.xpath("//div[2]/h1");

    @Then("^'Contact Us' page is opened$")
    public void contactUsPageIsOpened() {
        for (String windowID : driver.getWindowHandles()) {
            String title = driver.switchTo().window(windowID).getTitle();
            if (title.equals("Fly365 - ContactUs")) {
                String headerText = driver.findElement(contactUsHDR).getText();
                Assert.assertEquals(headerText, "Contact Us");
                driver.close();
                break;
            }
        }
        driver.switchTo().window(HomeTest.currentWindow);

    }


}
