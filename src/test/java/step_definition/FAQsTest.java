package step_definition;

import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import helper.TestBase;


public class FAQsTest extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, 10);

    By faqsLink = By.xpath("//a[@class='link text-sm font-normal mr-5 router-link-exact-active router-link-active']");

    @Then("^'FAQs' page is opened$")
    public void faqsPageIsOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(faqsLink));
        String headerText = driver.findElement(faqsLink).getText();
        Assert.assertEquals(headerText, "FAQs");
    }


}
