package step_definition;

import com.github.javafaker.Faker;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.APIUtility;
import helper.DataBase;
import helper.GeneralMethods;
import helper.TestBase;
import org.apache.commons.lang3.ObjectUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.security.Key;
import java.util.Locale;

public class Discount extends TestBase {

    GeneralMethods gm = new GeneralMethods();
    APIUtility api = new APIUtility();
    WebDriverWait wait = new WebDriverWait(driver, 30);

    private By systemBarMenuBTN = By.xpath("//div[@class='el-submenu__title']//img");
    private By discountBTN = By.xpath("/html/body/div[2]/ul/li[2]/a/span[2]");
    private By pageTitleText = By.xpath("//h4[@class='pull-left header-title']");
    private By createCampaignBTN = By.xpath("//a[@class='btn button-link']");
    private By discountNameTXT = By.xpath("//input[@id='Name']");
    private By discountStoreDDL = By.xpath("//div[@name='storeId']//input[@class='form-control']");
    private By discountStoreTXT = By.xpath("//span[@class='selected-tag']");
    private By discountPercentTXT = By.xpath("//input[@id='Discount Percent']");
    private By excludeCountryTXT = By.xpath("//div[@name='excludeCountry']//input[@class='form-control']");
    private By discountStatusTXT = By.xpath("//div[@name='isActive']//input[@class='form-control']");
    private By submitBTN = By.xpath("//input[@name='submit']");
    private By createdSuccMSG = By.xpath("//p[contains(text(),'Created Successfully')]");
    private By updatedSuccMSG = By.xpath("//p[contains(text(),'Updated Successfully')]");
    private By storeDiscountTAB = By.xpath("//span[contains(text(),'HK')]");
    private By editDiscountBTN = By.xpath("//i[@class='icon-edit']");
    private By clearSelectionBTN = By.xpath("//div[@name='isActive']//span[contains(text(),'×')]");
    private By settingsBTN = By.xpath("//span[contains(text(),'Settings')]");

    private Faker Fake = new Faker();
    String discountEnteredName = Fake.name().name();
    String discountName = null;
    String allTrips = null;
    String discountStatus = null;

    private String hostName = "k8stage1.cl9iojf4kdop.eu-west-1.rds.amazonaws.com:5432";
    private String dbsName = "discount_api";

    @And("^Open Discount$")
        public void openDiscount() {
            driver.findElement(systemBarMenuBTN).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(discountBTN));
            driver.findElement(discountBTN).click();
    }

    @And("^Click on Create Campaign$")
    public void clickOnCreateCampaign() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(createCampaignBTN));
            driver.findElement(createCampaignBTN).click();
    }

    @And("^Fill required data for discount rule$")
    public void fillRequiredDataForDiscountRule() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(discountNameTXT));
        driver.findElement(discountNameTXT).sendKeys("Test Discount");
        //gm.selectFromDDLHub("storeId", "fly365_au");
        driver.findElement(discountStoreDDL).sendKeys("fly365_com");
        driver.findElement(discountStoreDDL).sendKeys(Keys.ENTER);
        driver.findElement(discountPercentTXT).sendKeys("5");
        driver.findElement(excludeCountryTXT).sendKeys("No");
        driver.findElement(excludeCountryTXT).sendKeys(Keys.ENTER);
        driver.findElement(discountStatusTXT).sendKeys("Active");
        driver.findElement(discountStatusTXT).sendKeys(Keys.ENTER);
    }

    @And("^Click on Submit$")
    public void clickOnSubmit() throws InterruptedException {
            wait.until(ExpectedConditions.visibilityOfElementLocated(submitBTN));
            Thread.sleep(3000);
            driver.findElement(submitBTN).click();
    }

    @When("^Apply discount rule from API$")
    public void applyDiscountRuleFromAPI() {
            api.sendPostRequest("https://api.fly365stage.com/discount/campaign", api.createDiscount(discountEnteredName));
    }

    @And("^Make Search from API$")
    public void makeSearchFromAPI() throws InterruptedException {
            allTrips = api.sendPostRequest("https://nz.fly365stage.com/api/flight-search/search", api.oneWayAPI());
    }

    @And("^Open certain store$")
    public void openCertainStore() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(storeDiscountTAB));
            driver.findElement(storeDiscountTAB).click();
    }

    @And("^Click on Update Campaign$")
    public void clickOnUpdateCampaign() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(editDiscountBTN));
        Thread.sleep(4000);
        driver.findElement(editDiscountBTN).click();
    }

    @And("^Update Name of discount rule$")
    public void updateNameOfDiscountRule() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(discountNameTXT));
        driver.findElement(discountNameTXT).sendKeys(Keys.chord(Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE));
        driver.findElement(discountNameTXT).sendKeys("Update Test Discount");

    }

    @And("^Disable the discount rule$")
    public void disableTheDiscountRule() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(clearSelectionBTN));
        Thread.sleep(3000);
        driver.findElement(clearSelectionBTN).click();
        Thread.sleep(3000);
        driver.findElement(discountStatusTXT).sendKeys("Disabled");
        driver.findElement(discountStatusTXT).sendKeys(Keys.ENTER);
    }

    @And("^Open Discount Settings$")
    public void openDiscountSettings() {
            wait.until(ExpectedConditions.elementToBeClickable(settingsBTN));
            driver.findElement(settingsBTN).click();
    }

    @Then("^Discount page open$")
    public void discountPageOpen() {
        Assert.assertEquals(driver.findElement(pageTitleText).getText(),"Campaigns");
    }


    @Then("^Check Discount rule created successfully$")
    public void checkDiscountRuleCreatedSuccessfully() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(createdSuccMSG));
        Assert.assertTrue(true, String.valueOf(driver.findElement(createdSuccMSG).isDisplayed()));
    }


    @Then("^Check Discount rule applied$")
    public void checkDiscountRuleApplied() throws InterruptedException {
        Thread.sleep(8000);
        System.out.println(discountEnteredName);
        discountName = api.getDiscountName(allTrips,1);
        System.out.println(discountName);
        Assert.assertEquals(discountName, discountEnteredName);
    }


    @Then("^Check Discount rule updated successfully$")
    public void checkDiscountRuleUpdatedSuccessfully() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(updatedSuccMSG));
        Assert.assertTrue(true,String.valueOf(driver.findElement(updatedSuccMSG).isDisplayed()));
    }


    @Then("^Check Discount rule disabled$")
    public void checkDiscountRuleDisabled() {
        discountStatus = api.getDiscountStatus(allTrips, 1);
        Assert.assertTrue(false, discountStatus);
    }

    @And("^Delete new discount from database$")
    public void deleteNewDiscountFromDatabase() {
            DataBase.execute_query_dbs(hostName, dbsName, "select from campaigns where \"name\" = '" + discountEnteredName +"'");
            if (DataBase.data != null){
                DataBase.execute_query_dbs(hostName, dbsName, "delete from campaigns where \"name\" = '" + discountEnteredName +"'");
            }
        }
}
