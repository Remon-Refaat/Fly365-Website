package step_definition;

import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SignInTest extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, 10);

    By SignInHeader = By.xpath("//div[@class='text-xs mb-8 text-primary-fourth']");

    @Then("^'Sign In' page is opened$")
    public void signInPageIsOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SignInHeader));
        String headerText = driver.findElement(SignInHeader).getText();
        Assert.assertEquals(headerText,"Good to see you again");
    }



}
