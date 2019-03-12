package step_definition;

import com.github.javafaker.Faker;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.DataBase;
import helper.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import helper.TestBase;

public class AddTraveller extends TestBase {
    private WebDriverWait wait = new WebDriverWait(driver, 60);


    private By TravellerTAB = By.xpath("//a[@class='account-links__link text-sm flex items-center link link-with-icon mr-5 router-link-exact-active router-link-active']");
    private By AddTravellerBTN = By.xpath("//button[@class='btn px-3 py-2 btn-primary-second m-auto md:mt-0 mt-4']");
    private By TravellerHeaderTXT = By.xpath("//h3[@class='text-xl font-semibold']");
    private By SaveTravellerBTN = By.xpath("//button[@class='btn btn-primary-second w-full btn-add-traveller']");

    @And("^User press on traveller tab$")
    public void userPressOnTravellerTab() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TravellerTAB));
        driver.findElement(TravellerTAB).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AddTravellerBTN));
        String headerText = driver.findElement(TravellerHeaderTXT).getText();
        Assert.assertEquals(headerText, "Traveller Details");
    }


    @And("^user press on add traveller button$")
    public void userPressOnAddTravellerButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(AddTravellerBTN));
        driver.findElement(AddTravellerBTN).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(SaveTravellerBTN));
        String SaveBTNText = driver.findElement(SaveTravellerBTN).getText();
        Assert.assertEquals(SaveBTNText, "Save");


    }

}
