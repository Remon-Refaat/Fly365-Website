package step_definition;

import cucumber.api.java.en.And;
import helper.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultTest extends TestBase {
    WebDriverWait wait = new WebDriverWait(driver, 40);

    private By bookThisTripBTN = By.xpath("//div[@class='search-container']/div[2]//button[contains(text(),'Book this flight')]");

    @And("^Choose a trip$")
    public void chooseATrip() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(bookThisTripBTN));
        driver.findElement(bookThisTripBTN).click();
    }

}
