package step_definition;

import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import helper.TestBase;


public class SupportCenterTest extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, 10);


    By supportCenterLink = By.xpath("//a[@class='link text-sm font-normal mr-5 router-link-exact-active router-link-active']");

    @Then("^'Support Center' page is opened$")
    public void supportCenterPageIsOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(supportCenterLink));
        String headerText = driver.findElement(supportCenterLink).getText();
        Assert.assertEquals(headerText, "Support Center");
    }


}
