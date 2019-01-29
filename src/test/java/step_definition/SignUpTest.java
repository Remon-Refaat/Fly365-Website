package step_definition;

import com.github.javafaker.Faker;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
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


    @And("Open Sign up page")
    public void go_to_signup_page()  {
        driver.findElement(signUpBtn).click();
    }

    @And("Fill required data")
    public void fill_data()
    {
        Faker fakerdata = new Faker();
        //need specific data with integration with database
        driver.findElement(firstNameTxt).sendKeys(fakerdata.name().firstName());
        driver.findElement(lastNameTxt).sendKeys(fakerdata.name().lastName());
        driver.findElement(emailTxt).sendKeys(fakerdata.internet().emailAddress());
        driver.findElement(passwordTxt).sendKeys(fakerdata.internet().password());
    }

    @And("Click on Create Account")
    public void Click_button()
    {

        driver.findElement(creatAccountBtn).click();
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
}
