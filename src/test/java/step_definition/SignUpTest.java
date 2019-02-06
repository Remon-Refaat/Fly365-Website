package step_definition;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import helper.DataBase;
import helper.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Map;

public class SignUpTest extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, 30 );

    By SignUpHeader = By.xpath("//div[@class='text-xs mb-8 text-primary-fourth']");
    By signUpBtn = By.xpath("//li/a[text()='Sign up']");
    By firstNameTxt = By.xpath("//input[@placeholder='John']");
    By lastNameTxt = By.xpath("//input[@placeholder='Smith']");
    By emailTxt = By.xpath("//input[@placeholder='john@example.com']");
    By passwordTxt = By.xpath("//input[@placeholder='******************']");
    By creatAccountBtn = By.xpath("//button[text()='CREATE ACCOUNT']");
    By validationNameMessage = By.xpath("//span[text()='Name must be letters only']");
    By validationEmailMessage = By.xpath("//span[text()='Please enter a valid email']");
    By validationPasswordMessage = By.xpath("//span[text()='Password length must be between 8 to 50 characters']");
    By firstNameRequiredMessage = By.xpath("//span[text()='Please enter first name']");
    By lastNameRequiredMessage = By.xpath("//span[text()='Please enter last name']");
    By emailRequiredMessage = By.xpath("//span[text()='Please enter email']");
    By passwordRequiredMessage = By.xpath("//span[text()='Please enter password']");



//    @Given("^Insert new user in database$")
//    public void insertNewUserInDatabase()
//    {
//    }

    @And("Open Sign up page")
    public void OpenSignUpPage()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signUpBtn));
        driver.findElement(signUpBtn).click();
    }


    @And("^Fill required data \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\"$")
    public void fillRequiredData(String fName, String lName, String eMAIL, String password)
    {
            driver.findElement(firstNameTxt).sendKeys(fName);
            driver.findElement(lastNameTxt).sendKeys(lName);
            driver.findElement(emailTxt).sendKeys(eMAIL);
            driver.findElement(passwordTxt).sendKeys(password);
    }


    @And("^Fill the following required data$")
    public void fillTheFollowingRequiredData(DataTable usersData)
    {
        for (Map<String, String> userData : usersData.asMaps(String.class, String.class))
        {
            driver.findElement(firstNameTxt).sendKeys(userData.get("First Name"));
            driver.findElement(lastNameTxt).sendKeys(userData.get("Last Name"));
            driver.findElement(emailTxt).sendKeys(userData.get("Email Address"));
            driver.findElement(passwordTxt).sendKeys(userData.get("Password"));
        }
    }

//    @And("Enter First Name")
//    public void fill_firstName()
//    {
//        driver.findElement(firstNameTxt).sendKeys("John");
//    }
//
//    @And("Enter Last Name")
//    public void fill_lastName()
//    {
//        driver.findElement(lastNameTxt).sendKeys("Smith");
//    }
//
//    @And("Enter Email")
//    public void fill_email()
//    {
//        Faker fakerdata = new Faker();
//        driver.findElement(emailTxt).sendKeys(fakerdata.internet().emailAddress());
//    }

//    @And("Enter Password")
//    public void fill_password()
//    {
//        driver.findElement(passwordTxt).sendKeys("12345678");
//    }

    @And("Click on Create Account")
    public void clickOnCreateAccount()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(creatAccountBtn));
        driver.findElement(creatAccountBtn).click();
    }


    @And("The new record set on database")
    public void theNewRecordSetOnDatabase()
    {
        DataBase.execute_query_dbs("k8stage1.cl9iojf4kdop.eu-west-1.rds.amazonaws.com:5432","user_api","select email from users where email='john.smith.fly365@gmail.com'");
        System.out.println(DataBase.data);
        Assert.assertEquals(DataBase.data,"john.smith.fly365@gmail.com");
        DataBase.execute_query_dbs("k8stage1.cl9iojf4kdop.eu-west-1.rds.amazonaws.com:5432","user_api","delete from users where email='john.smith.fly365@gmail.com'");
    }

    @Then("The user created successfully")
    public void theUserCreatedSuccessfully()
    {
        driver.getTitle().contains("Fly365");
    }

    @Then("^'Sign Up' page is opened$")
    public void signUpPageIsOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SignUpHeader));
        String headerText = driver.findElement(SignUpHeader).getText();
        Assert.assertEquals(headerText,"Sign in or sign up");
    }

    @Then("The system display validation messages for all mandatory fields")
    public void theSystemDisplayValidationMessagesForAllMandatoryFields()
    {
        String fErrorMSG = driver.findElement(firstNameRequiredMessage).getText();
        Assert.assertEquals(fErrorMSG,"Please enter first name");

        String lErrorMSG = driver.findElement(lastNameRequiredMessage).getText();
        Assert.assertEquals(lErrorMSG,"Please enter last name");

        String eErrorMSG = driver.findElement(emailRequiredMessage).getText();
        Assert.assertEquals(eErrorMSG,"Please enter email");

        String pErrorMSG = driver.findElement(passwordRequiredMessage).getText();
        Assert.assertEquals(pErrorMSG,"Please enter password");
    }

    @Then("^The system should display validation message for invalid name$")
    public void theSystemShouldDisplayValidationMessageForInvalidName()
    {
        String error_message = driver.findElement(validationNameMessage).getText();
        Assert.assertEquals(error_message,"Name must be letters only");
    }

    @Then("^The system should display validation message for invalid email$")
    public void theSystemShouldDisplayValidationMessageForInvalidEmail()
    {
        String error_message = driver.findElement(validationEmailMessage).getText();
        Assert.assertEquals(error_message,"Please enter a valid email");
    }

    @Then("^The system should display validation message for invalid password$")
    public void theSystemShouldDisplayValidationMessageForInvalidPassword()
    {
        String pass_error = driver.findElement(validationPasswordMessage).getText();
        Assert.assertEquals(pass_error,"Password length must be between 8 to 50 characters");
    }

}
