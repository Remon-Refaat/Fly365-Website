package step_definition;

import com.github.javafaker.Faker;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class ForgetPasswordTest extends TestBase {
    private WebDriverWait wait = new WebDriverWait(driver, 60);
    private Faker fakerLogin = new Faker();

    private By ForgetPassWordBTN = By.xpath("//a[@class='link-forgot text-sm no-underline text-primary-fourth hover:text-black']");
    private By ForgeEmailTXT = By.xpath("//input[@placeholder='john@example.com']");
    private By SendEmailBTN = By.xpath("//button[contains(text(),'Send')]");
    private By EmailErrorMSG = By.xpath("//span[@class='tooltiptext with-arrow']");
    private By LoginBTN = By.xpath("//button[contains(text(),'Login')]");


    @And("^press on forget password link$")
    public void pressOnForgetPasswordLink() {
        driver.findElement(ForgetPassWordBTN).click();
    }

    @And("^enter email at forget password text \"(.*)\"$")
    public void enterEmailAtForgetPasswordText(String registeredEmail) {
        driver.findElement(ForgeEmailTXT).sendKeys(registeredEmail);
    }

    @When("^click on send email button$")
    public void enterOnSendEmailButton() {
        driver.findElement(SendEmailBTN).click();
    }


    @Then("^page shall be redirect to login page$")
    public void pageShallBeRedirectToLoginPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginBTN));
        Assert.assertEquals(driver.getTitle(), "Fly365 - Login");
    }

    @And("^enter invalid email formation at email text at forget password page \"(.*)\"$")
    public void enterInvalidEmailFormationAtEmailTextAtForgetPasswordPage(String inValidEmail) {
        driver.findElement(ForgeEmailTXT).sendKeys(inValidEmail);
    }

    @And("^enter unregistered email at forget password page$")
    public void enterUnregisteredEmailAtForgetPasswordPage() {
        driver.findElement(ForgeEmailTXT).sendKeys(fakerLogin.internet().emailAddress());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("^user shall see empty email error message at forget password page$")
    public void userShallSeeEmptyEmailErrorMessageAtForgetPasswordPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(EmailErrorMSG));
        WebElement ErrorMessage = driver.findElement(EmailErrorMSG);
        Assert.assertTrue(ErrorMessage.isDisplayed());
        String EmptyEmailMSGText = driver.findElement(EmailErrorMSG).getText();
        Assert.assertEquals(EmptyEmailMSGText, "!Please enter email");
    }

    @Then("^user shall see email error message at forget password page$")
    public void userShallSeeEmailErrorMessageAtForgetPasswordPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(EmailErrorMSG));
        WebElement ErrorMessage = driver.findElement(EmailErrorMSG);
        Assert.assertTrue(ErrorMessage.isDisplayed());
        String EmptyEmailMSGText = driver.findElement(EmailErrorMSG).getText();
        Assert.assertEquals(EmptyEmailMSGText, "!Please enter a valid email");
    }

    @Then("^user shall see email not registered error message at forget password page$")
    public void userShallSeeEmailNotRegisteredErrorMessageAtForgetPasswordPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(EmailErrorMSG));
        WebElement ErrorMessage = driver.findElement(EmailErrorMSG);
        Assert.assertTrue(ErrorMessage.isDisplayed());
        String EmptyEmailMSGText = driver.findElement(EmailErrorMSG).getText();
        Assert.assertEquals(EmptyEmailMSGText, "!we can't find any account with this email");
    }

}
