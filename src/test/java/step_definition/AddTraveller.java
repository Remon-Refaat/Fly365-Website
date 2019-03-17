package step_definition;

import cucumber.api.java.en.And;
import helper.DataBase;
import helper.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddTraveller extends TestBase {
    WebDriverWait wait = new WebDriverWait(driver, 60);


    private By TravellerTAB = By.xpath("//a[@class='account-links__link text-sm flex items-center link link-with-icon mr-5']");
    private By AddTravellerBTN = By.xpath("//button[@class='btn px-3 py-2 btn-primary-second m-auto md:mt-0 mt-4']");
    private By TravellerHeaderTXT = By.xpath("//h3[@class='text-xl font-semibold']");
    private By SaveTravellerBTN = By.xpath("//button[@class='btn btn-primary-second w-full btn-add-traveller']");
    private By TravellerTitleDrop = By.xpath("//input[@placeholder='Title']");
    private By MRTitle = By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/ul[1]/li[1]");
    private By TravellerFirstNameTXT = By.xpath("//input[@placeholder='First name']");
    private By TravellerFamileyNameTXT = By.xpath("//input[@placeholder='Family name']");
    private By TravellerBirthDateDayDrop = By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/form[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]");
    private By Day1 = By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/ul[1]/li[1]");
    private By TravellerBirthDateMonth = By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/form[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/input[1]");
    private By Month1 = By.xpath("/html[1]/body[1]/div[6]/div[1]/div[1]/ul[1]/li[4]");
    private By TravellerBirthDateYear = By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/form[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/input[1]");
    private By Year1 = By.xpath("/html[1]/body[1]/div[7]/div[1]/div[1]/ul[1]/li[2]");
    private By SaveTravellerInnerBTN = By.xpath("//button[@class='btn btn-primary-second w-full btn-add-traveller']");
    private By AddedTraveller = By.xpath("//label[contains(text(),'ID Type')]");

    private String hostName = "k8stage1.cl9iojf4kdop.eu-west-1.rds.amazonaws.com:5432";
    private String dbsName = "user_api";


    @And("^User press on traveller tab$")
    public void userPressOnTravellerTab() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TravellerTAB));
        driver.findElement(TravellerTAB).click();
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

    @And("^user add traveller$")
    public void userEnterTravellerTitle() {
        driver.findElement(TravellerTitleDrop).click();
        driver.findElement(MRTitle).click();
        driver.findElement(TravellerFirstNameTXT).sendKeys("johnnnn");
        driver.findElement(TravellerFamileyNameTXT).sendKeys("smithhhh");
        driver.findElement(TravellerBirthDateDayDrop).click();
        driver.findElement(Day1).click();
        driver.findElement(TravellerBirthDateMonth).click();
        driver.findElement(Month1).click();
        driver.findElement(TravellerBirthDateYear).click();
        driver.findElement(Year1).click();
        driver.findElement(SaveTravellerInnerBTN).click();
        Assert.assertTrue(driver.findElement(AddedTraveller).isDisplayed());
    }

    @And("^Delete new traveller from database$")
    public void deleteNewTravellerFromDatabase() {
        DataBase.execute_query_dbs(hostName, dbsName, "delete from travellers where 'firstName'='johnnnn'");

    }
}
