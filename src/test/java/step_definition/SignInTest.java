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

    private WebDriverWait wait = new WebDriverWait(driver, 60);
    private Faker fakerLogin = new Faker();

    private String userEmail = "m.sayed.89@gmail.com";
    private String userHashPassWord = "$2y$04$E3GLR2vVV0AKfvwm6L0MDeKpVfFw4kR58wb9ohNN.TpGoF6fdpoK.\n";
    private String userPassWord = "@Test123";
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

    By SignInHeader = By.xpath("//div[@class='text-xs mb-8 text-primary-fourth']");
    By LoginHeaderBtn = By.xpath("/html/body/div[1]/div[1]/div/div/div[2]/div/div[4]/a");
    By LoginEmailTxt = By.xpath("/html/body/div[1]/div[2]/div/div[2]/div[3]/div/form/div[2]/div[1]/div/div/div[2]/div/div/div[1]/input");
    By LoginPassWordTxt = By.xpath("/html/body/div[1]/div[2]/div/div[2]/div[3]/div/form/div[2]/div[2]/div/div/div[2]/div/div/div[1]/div/input");
    By LoginBtn = By.xpath("/html/body/div[1]/div[2]/div/div[2]/div[3]/div/form/div[2]/div[4]/div/button");
    By ProfileNameBtn = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[4]/span[1]");
    By LogoutBtn = By.xpath("//li[contains(text(),'Sign Out')]");
    @Then("^'Sign In' page is opened$")
    public void signInPageIsOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SignInHeader));
        String headerText = driver.findElement(SignInHeader).getText();
        Assert.assertEquals(headerText,"Good to see you again");
    }

    @And("^open login page$")
    public void openLoginPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginHeaderBTN));
        driver.findElement(LoginHeaderBTN).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginBTN));
        WebElement LoginPassWordTXT = driver.findElement(LoginBTN);
        Assert.assertTrue(LoginPassWordTXT.isDisplayed());
    }

    @And("^user enter a valid email$")
    public void userEnterAValidEmail() {
        driver.findElement(LoginEmailTXT).sendKeys(userEmail);
    }

    @And("^user enter the right password$")
    public void userEnterTheRightPassword() {
        driver.findElement(LoginPassWordTXT).sendKeys(userPassWord);
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

    @And("^user enter the wrong password$")
    public void userEnterTheWrongPassword() {
        driver.findElement(LoginPassWordTXT).sendKeys("@test123");
    }

    @And("^user enter the password less than 8 chars$")
    public void userEnterThePasswordLessThanChars() {
        driver.findElement(LoginPassWordTXT).sendKeys("12345");
    }

    @Then("^user shall see empty password error message$")
    public void userShallSeeEmptyPasswordErrorMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PassWordErrorMSG));
        WebElement passWordErrorMessage = driver.findElement(PassWordErrorMSG);
        Assert.assertTrue(passWordErrorMessage.isDisplayed());
        String PassWordErrorMSGText = driver.findElement(PassWordErrorMSG).getText();
        Assert.assertEquals(PassWordErrorMSGText, "!Please enter password");
    }

    @And("^user enter the password more than 60 chars$")
    public void userEnterThePassWordMoreThanChars() {
        driver.findElement(LoginPassWordTXT).sendKeys("1111111111111111111111111111111111111111111111111111111111111");
    }

    @And("^user enter an invalid email$")
    public void userEnterAnInValidEmail() {
        driver.findElement(LoginEmailTXT).sendKeys("M.saYed.89gmailcom");
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

    @And("^user enter an upper case right email$")
    public void userEnterAnUpperCaseRightEmail() {
        driver.findElement(LoginEmailTXT).sendKeys(userEmail.toUpperCase());
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

    @And("^insert new user at database$")
    public void insertNewUserAtDataBase() {
        DataBase.execute_update(hostName, dbsName, "insert into users (email, \"lastName\",\"firstName\",password,\"storeId\", \"groupId\",\"isActive\",\"isLocked\")values('" + userEmail + "','Sayed','Mahmoud','" + userHashPassWord + "','fly365_com','fly365',True,False)");
    }

    @And("^delete new user at database$")
    public void deleteTheNewUserAtDataBase() {
        DataBase.execute_query_dbs(hostName, dbsName, "delete from users where email='" + userEmail + "'");
    }

}
