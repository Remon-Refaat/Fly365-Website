package step_definition;

import cucumber.api.java.en.Then;
import helper.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;


public class OffersTest extends TestBase {

    private By offersHDR = By.xpath("//h2/span");

    @Then("^Offers page is opened$")
    public void offersPageIsOpened() {
        for (String windowID : driver.getWindowHandles()) {
            String title = driver.switchTo().window(windowID).getTitle();
            if (title.equals("Fly365 - Our Offers")) {
                String headerText = driver.findElement(offersHDR).getText();
                Assert.assertEquals(headerText, "Offers");
                break;
            }
        }
    }


}
