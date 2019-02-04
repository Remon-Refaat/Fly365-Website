package step_definition;

import cucumber.api.java.en.And;
import helper.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultTest extends TestBase {
    WebDriverWait wait = new WebDriverWait(driver, 10);

    By bookThisTripBtn = By.xpath("//div[@class='search-container']/div[1]//button[contains(text(),'Book this flight')]");

    @And("^Choose a trip$")
    public void chooseATrip() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(bookThisTripBtn));
        driver.findElement(bookThisTripBtn).click();
        Thread.sleep(7000);
    }

}
