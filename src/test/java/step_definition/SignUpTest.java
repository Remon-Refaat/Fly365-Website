package step_definition;

import com.github.javafaker.Faker;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import helper.DataBase;
import helper.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SignUpTest extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, 10);

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
//    public void insertNewUserInDatabase() {
//
//    }

    @And("Open Sign up page")
    public void go_to_signup_page()  {
        driver.findElement(signUpBtn).click();
    }

    @And("Fill required data")
    public void fill_data()
    {
        Faker fakerdata = new Faker();
        //need specific data with integration with database
        driver.findElement(firstNameTxt).sendKeys("John");
        driver.findElement(lastNameTxt).sendKeys("Smith");
        driver.findElement(emailTxt).sendKeys("omda@mailinator.com");
        driver.findElement(passwordTxt).sendKeys(fakerdata.internet().password());
    }

    @And("Enter First Name")
    public void fill_firstName()
    {
        driver.findElement(firstNameTxt).sendKeys("John");
    }

    @And("Enter Last Name")
    public void fill_lastName()
    {
        driver.findElement(lastNameTxt).sendKeys("Smith");
    }

    @And("Enter Email")
    public void fill_email()
    {
        Faker fakerdata = new Faker();
        driver.findElement(emailTxt).sendKeys(fakerdata.internet().emailAddress());
    }

    @And("^Check validation when enter (.*) First Name$")
    public void fill_firstName(String fName)
    {
        driver.findElement(firstNameTxt).sendKeys(fName);
        String error_message = driver.findElement(validationNameMessage).getText();
        Assert.assertEquals(error_message,"Name must be letters only");
    }


    @And("^Check validation when enter (.*) Last Name$")
    public void fill_lastName(String fName)
    {
        driver.findElement(lastNameTxt).sendKeys(fName);
        String error_message = driver.findElement(validationNameMessage).getText();
        Assert.assertEquals(error_message,"Name must be letters only");
    }

    @And("^Check validation when enter (.*) Email Address$")
    public void fill_email(String email)
    {
        driver.findElement(emailTxt).sendKeys(email);
        String error_message = driver.findElement(validationEmailMessage).getText();
        Assert.assertEquals(error_message,"Please enter a valid email");
    }

    @And("^Check validation when enter (.*) Password$")
    public void fill_invPassword(String invPass)
    {
        driver.findElement(passwordTxt).sendKeys(invPass);
        wait.until(ExpectedConditions.visibilityOfElementLocated(validationPasswordMessage));
        String pass_error = driver.findElement(validationPasswordMessage).getText();
        Assert.assertEquals(pass_error,"Password length must be between 8 to 50 characters");
    }

    @And("Enter Password")
    public void fill_password()
    {
        driver.findElement(passwordTxt).sendKeys("12345678");
    }

    @And("Click on Create Account")
    public void Click_button()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SignUpHeader));
        driver.findElement(creatAccountBtn).click();
    }


    @And("The new record set on database")
    public void Check_DataBase()
    {
        DataBase.execute_query_dbs("k8stage1.cl9iojf4kdop.eu-west-1.rds.amazonaws.com:5432","user_api","select email from users where email='omda@mailinator.com'");
        System.out.println(DataBase.data);
        Assert.assertEquals(DataBase.data,"omda@mailinator.com");
        DataBase.execute_query_dbs("k8stage1.cl9iojf4kdop.eu-west-1.rds.amazonaws.com:5432","user_api","delete from users where email='omda@mailinator.com'");
    }

    @Then("The user created successfully")
    public void userCreatedSuccessfully()
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
    public void leave_mandatory_fields()
    {
        Assert.assertEquals(firstNameRequiredMessage.toString(),"Please enter first name");
        Assert.assertEquals(lastNameRequiredMessage.toString(),"Please enter last name");
        Assert.assertEquals(emailRequiredMessage.toString(),"Please enter email");
        Assert.assertEquals(passwordRequiredMessage.toString(),"Please enter password");
    }

}
