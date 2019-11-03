package step_definition;

import cucumber.api.java.en.And;
import helper.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FiltersTest extends TestBase {
    WebDriverWait wait = new WebDriverWait(driver, 30);

    private By airlineFilterBTN = By.xpath("//button[contains(text(),'AIRLINES')]");
    private By closeAirlineFilterBTN = By.xpath("((//div[@role='tooltip'])//*[contains(@class,'cursor-pointer pr-4 svg-icon svg-fill')])[6]");

    @And("^Click on Airline Filter$")
    public void clickOnAirlineFilter() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(airlineFilterBTN));
        driver.findElement(airlineFilterBTN).click();
    }

    @And("^Filter with the following Airline \"([^\"]*)\"$")
    public void filterWithTheFollowingAirline(String onlyAirline) throws Throwable {
        Thread.sleep(1000);
        WebElement airlineOnlyElmnt =driver.findElement(By.xpath("//span[contains(text(),'"+onlyAirline+"')]/ancestor::label/following-sibling::button"));
        airlineOnlyElmnt.click();
        Thread.sleep(1000);
        driver.findElement(closeAirlineFilterBTN).click();
    }
}
