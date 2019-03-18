package step_definition;

import cucumber.api.java.en.Then;
import helper.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;


public class PrivacyPolicyTest extends TestBase {


    private By privacyPolicyHDRLINK = By.xpath("//a[@class='text-sm font-normal link router-link-exact-active router-link-active']");

    @Then("^'Privacy Policy' page is opened$")
    public void privacyPolicyPageIsOpened() {
        for (String windowID : driver.getWindowHandles()) {
            String title = driver.switchTo().window(windowID).getTitle();
            if (title.equals("Fly365")) {
                String headerText = driver.findElement(privacyPolicyHDRLINK).getText();
                Assert.assertEquals(headerText, "Privacy Policy");
                break;
            }
        }
    }
}
