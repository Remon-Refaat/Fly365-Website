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


    @And("^Open Sign up page$")
    public void go_to_signup_page() {
        driver.findElement(signUpBtn).click();
    }

    @And("^Fill required data$")
    public void fill_data() {
        Faker fakerdata = new Faker();
        //need specific data with integration with database
        driver.findElement(firstNameTxt).sendKeys("John");
        driver.findElement(lastNameTxt).sendKeys("Smith");
        driver.findElement(emailTxt).sendKeys("mido@mailinator.com");
        driver.findElement(passwordTxt).sendKeys(fakerdata.internet().password());
    }

    @And("^Click on Create Account$")
    public void Click_button() {

        driver.findElement(creatAccountBtn).click();
    }


    @And("^The new record set on database$")
    public void Check_DataBase() {
        DataBase.execute_query_dbs("k8stage1.cl9iojf4kdop.eu-west-1.rds.amazonaws.com:5432", "user_api", "select email from users where email='mido@mailinator.com'");
        System.out.println(DataBase.data);
        Assert.assertEquals(DataBase.data, "mido@mailinator.com");
        DataBase.execute_query_dbs("k8stage1.cl9iojf4kdop.eu-west-1.rds.amazonaws.com:5432", "user_api", "delete from users where email='mido@mailinator.com'");
    }

    @Then("^The user created successfully$")
    public void userCreatedSuccessfully() {

        driver.getTitle().contains("Fly365");
    }

    @Then("^'Sign Up' page is opened$")
    public void signUpPageIsOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SignUpHeader));
        String headerText = driver.findElement(SignUpHeader).getText();
        Assert.assertEquals(headerText, "Sign in or sign up");

    }
}
