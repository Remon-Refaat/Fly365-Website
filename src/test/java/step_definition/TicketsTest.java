package step_definition;

import com.github.javafaker.Faker;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import helper.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import helper.APIUtility;

import java.io.IOException;

public class TicketsTest extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, 30);

    private By replyTXT = By.xpath("(//div[@role='presentation'])[1]");
    private By sendBTN = By.xpath("(//button//span[text()='Send'])");


   @Given("^Create a Rule from API for \"(.*)\"$")
    public void createContactUs(String domain) throws IOException {
       APIUtility.createRuleAPI(domain);
   }


}
