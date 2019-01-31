package step_definition;

import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import helper.TestBase;


public class AboutUsTest extends TestBase{

    WebDriverWait wait = new WebDriverWait(driver, 10);

    By aboutUsHeader = By.xpath("//header/span[1]");

    @Then("^'About Us' page is opened$")
    public void aboutUsPageIsOpened() {

       wait.until(ExpectedConditions.visibilityOfElementLocated(aboutUsHeader));
        String headerText = driver.findElement(aboutUsHeader).getText();
        Assert.assertEquals(headerText,"About Fly365");

    }


}
