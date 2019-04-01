package step_definition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import helper.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

import static java.lang.Thread.*;

public class SearchTrips extends TestBase {
    WebDriverWait wait = new WebDriverWait(driver, 10);

    private By flightOptionsHDR = By.xpath("//span[text()='FLY365 MIX AND MATCH FLIGHT OPTIONS']");
    private By originAirportCode = By.xpath("//span[contains(normalize-space(text()),'AKL')]");
    private By destinationAirportCode = By.xpath("//span[contains(normalize-space(text()),'DXB')]");
    private By flightDetailsDHR = By.xpath("//p[contains(normalize-space(text()),'Your flights from')]");

    @And("^Scroll to the end of the page$")
    public void scrollToTheEndOfThePage() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(flightOptionsHDR));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < 18; i++) {
            js.executeScript("scrollBy(0,2500)");
        }
    }


    @Then("^Check count of search results$")
    public void checkCountOfSearchResults() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(flightOptionsHDR));
        String count = driver.findElement(By.xpath("//span[@class='ml-2 text-black text-sm font-medium']")).getText();
        System.out.println(count);
        List result = driver.findElements(flightOptionsHDR);
        String displayedCount = String.valueOf(result.size());
        System.out.println(displayedCount);
        Assert.assertEquals(displayedCount, count);
    }

    @Then("^The system display results as per search criteria$")
    public void theSystemDisplayResultsAsPerSearchCriteria() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(flightOptionsHDR));
        List originResult = driver.findElements(originAirportCode);
        int displayedOrigin = originResult.size();
        System.out.println(displayedOrigin);
        List destinationResult = driver.findElements(destinationAirportCode);
        int displayedDestination = destinationResult.size();
        System.out.println(displayedDestination);
        Assert.assertEquals(displayedOrigin, displayedDestination);
    }
}
