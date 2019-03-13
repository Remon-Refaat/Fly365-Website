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


public class SignInTest extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, 60);
    private Faker fakerLogin = new Faker();

    private String hostName = "k8stage1.cl9iojf4kdop.eu-west-1.rds.amazonaws.com:5432";
    private String dbsName = "user_api";

    private By LoginBTN = By.xpath("//button[contains(text(),'Login')]");
    private By LoginHeaderBTN = By.xpath("//a[@class='text-black md:w-24 text-center w-full block float-right hover:text-white bg-white btn hover:bg-primary-second font-normal py-2 px-5 rounded-sm text-sm no-underline']");
    private By LoginEmailTXT = By.xpath("//input[@placeholder='john@example.com']");
    private By LoginPassWordTXT = By.xpath("//input[@placeholder='******************']");
    private By ProfileNameBTN = By.xpath("//span[@class='el-dropdown-link capitalize text-xs text-white el-dropdown-selfdefine']");
    private By LogoutBTN = By.xpath("//li[contains(text(),'Sign Out')]");
    private By AccountSettingBTN = By.xpath("//a[@class='account-links__link text-sm flex font-medium items-center link link-with-icon']");
    private By InvalidLogInMSG = By.xpath("//div[@class='tooltip error error']//span[@class='tooltiptext']");
    private By PassWordErrorMSG = By.xpath("//span[@class='tooltiptext with-arrow']");
    private By EmailErrorMSG = By.xpath("//span[@class='tooltiptext with-arrow']");
    private By HomePageTitle = By.xpath("//span[@class='text-primary-second']");
    private By SignInHeader = By.xpath("//div[@class='text-xs mb-8 text-primary-fourth']");


    @Then("^'Sign In' page is opened$")
    public void signInPageIsOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SignInHeader));
        String headerText = driver.findElement(SignInHeader).getText();
        Assert.assertEquals(headerText, "Good to see you again");
    }

    @And("^open login page$")
    public void openLoginPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginHeaderBTN));
        driver.findElement(LoginHeaderBTN).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginBTN));
        WebElement LoginPassWordTXT = driver.findElement(LoginBTN);
        Assert.assertTrue(LoginPassWordTXT.isDisplayed());
    }

    @And("^user enter email \"(.*)\"$")
    public void userEnterAValidEmail(String LoginEmail) {
        driver.findElement(LoginEmailTXT).sendKeys(LoginEmail);
    }

    @When("^the user click on login button$")
    public void theUserClickOnLoginButton() {
        driver.findElement(LoginBTN).click();
    }

    @Then("^the user shall be redirect to my booking page$")
    public void theUserShallBeRedirectToMyBookingPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(AccountSettingBTN));
        WebElement MyProfile = driver.findElement(AccountSettingBTN);
        Assert.assertTrue(MyProfile.isDisplayed());
    }

    @Given("^user enter unregistered email$")
    public void userEnterUnregisteredEmail() {
        driver.findElement(LoginEmailTXT).sendKeys(fakerLogin.internet().emailAddress());
    }

    @Then("^user shall see InValid Login Error Message$")
    public void userShallSeeInValidLogInErrorMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(InvalidLogInMSG));
        WebElement ErrorMessage = driver.findElement(InvalidLogInMSG);
        Assert.assertTrue(ErrorMessage.isDisplayed());
        String InValidLoginMSGText = driver.findElement(InvalidLogInMSG).getText();
        Assert.assertEquals(InValidLoginMSGText, "!Invalid Email or password");

    }

    @Then("^user shall see password error message$")
    public void userShallSeePasswordErrorMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PassWordErrorMSG));
        WebElement passWordErrorMessage = driver.findElement(PassWordErrorMSG);
        Assert.assertTrue(passWordErrorMessage.isDisplayed());
        String PassWordErrorMSGText = driver.findElement(PassWordErrorMSG).getText();
        Assert.assertEquals(PassWordErrorMSGText, "!Password length must be between 8 to 50 characters");
    }

    @Then("^user shall see empty password error message$")
    public void userShallSeeEmptyPasswordErrorMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PassWordErrorMSG));
        WebElement passWordErrorMessage = driver.findElement(PassWordErrorMSG);
        Assert.assertTrue(passWordErrorMessage.isDisplayed());
        String PassWordErrorMSGText = driver.findElement(PassWordErrorMSG).getText();
        Assert.assertEquals(PassWordErrorMSGText, "!Please enter password");
    }

    @And("^user enter password \"(.*)\"$")
    public void userEnterThePassWordMoreThanChars(String Password) {
        driver.findElement(LoginPassWordTXT).sendKeys(Password);
    }

    @Then("^user shall see email empty error message$")
    public void userShallSeeEmptyEmailErrorMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(EmailErrorMSG));
        WebElement emailErrorMessage = driver.findElement(EmailErrorMSG);
        Assert.assertTrue(emailErrorMessage.isDisplayed());
        String EMailErrorMSGText = driver.findElement(EmailErrorMSG).getText();
        Assert.assertEquals(EMailErrorMSGText, "!Please enter email");
    }

    @Then("^user shall see email error message$")
    public void userShallSeeEmailErrorMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(EmailErrorMSG));
        WebElement emailErrorMessage = driver.findElement(EmailErrorMSG);
        Assert.assertTrue(emailErrorMessage.isDisplayed());
        String EMailErrorMSGText = driver.findElement(EmailErrorMSG).getText();
        Assert.assertEquals(EMailErrorMSGText, "!Please enter a valid email");
    }

    @And("^user enter an empty email$")
    public void userEnterAnEmptyEmail() {
        driver.findElement(LoginEmailTXT).sendKeys("");
    }

    @And("^user enter empty password$")
    public void userEnterEmptyPassword() {
        driver.findElement(LoginPassWordTXT).sendKeys("");
    }

    @And("^user logout$")
    public void userLogout() {
        driver.findElement(ProfileNameBTN).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(LogoutBTN));
        driver.findElement(LogoutBTN).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginHeaderBTN));
        String homeText = driver.findElement(HomePageTitle).getText();
        Assert.assertEquals(homeText, "Low Fares");
    }

    @And("^insert new user at database \"(.*)\" \"(.*)\"$")
    public void insertNewUserAtDataBase(String userEmail, String userHashPassWord) {
        DataBase.execute_update(hostName, dbsName, "insert into users (email, \"lastName\",\"firstName\",password,\"storeId\", \"groupId\",\"isActive\",\"isLocked\")values('" + userEmail + "','Sayed','Mahmoud','" + userHashPassWord + "','fly365_com','fly365',True,False)");
    }

    @And("^delete new user at database \"(.*)\"$")
    public void deleteTheNewUserAtDataBase(String userEmail) {
        DataBase.execute_query_dbs(hostName, dbsName, "delete from users where email='" + userEmail + "'");
    }

}
