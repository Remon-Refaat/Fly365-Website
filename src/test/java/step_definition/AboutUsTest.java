package step_definition;

import cucumber.api.java.en.Then;
import helper.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;


public class AboutUsTest extends TestBase {


    private By aboutUsHDR = By.xpath("//header/span[1]");

    @Then("^'About Us' page is opened$")
    public void aboutUsPageIsOpened() {

        for (String windowID : driver.getWindowHandles()) {
            String title = driver.switchTo().window(windowID).getTitle();
            if (title.equals("Fly365 - AboutUs")) {
                String headerText = driver.findElement(aboutUsHDR).getText();
                try{
                    Assert.assertEquals(headerText, "About Fly365");
                }
                catch (AssertionError e)
                {
                    driver.close();
                    driver.switchTo().window(HomeTest.currentWindow);
                    Assert.assertTrue(e.getMessage().isEmpty());
                }

                driver.close();
                break;
            }
        }
        driver.switchTo().window(HomeTest.currentWindow);

    }


}
