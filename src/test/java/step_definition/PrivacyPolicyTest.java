package step_definition;

import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import helper.TestBase;


public class PrivacyPolicyTest extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, 10);


    private By privacyPolicyLINK = By.xpath("//a[@class='text-sm font-normal link router-link-exact-active router-link-active']");

    @Then("^'Privacy Policy' page is opened$")
    public void privacyPolicyPageIsOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(privacyPolicyLINK));
        String headerText = driver.findElement(privacyPolicyLINK).getText();
        Assert.assertEquals(headerText, "Privacy Policy");
    }
}
