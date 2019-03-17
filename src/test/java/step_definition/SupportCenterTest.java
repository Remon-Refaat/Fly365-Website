package step_definition;

import cucumber.api.java.en.Then;
import helper.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;


public class SupportCenterTest extends TestBase {


    private By supportCenterHDRLINK = By.xpath("//a[@class='link text-sm font-normal mr-5 router-link-exact-active router-link-active']");

    @Then("^'Support Centre' page is opened$")
    public void supportCentrePageIsOpened() {

        for (String windowID : driver.getWindowHandles()) {
            String title = driver.switchTo().window(windowID).getTitle();
            if (title.equals("Fly365")) {
                String headerText = driver.findElement(supportCenterHDRLINK).getText();
                Assert.assertEquals(headerText, "Support Centre");
                driver.close();
                break;
            }
        }
        driver.switchTo().window(HomeTest.currentWindow);

    }


}
