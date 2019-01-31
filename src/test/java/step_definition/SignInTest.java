package step_definition;

import com.github.javafaker.Faker;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import helper.TestBase;


public class SignInTest extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, 10);

    By SignInHeader = By.xpath("//div[@class='text-xs mb-8 text-primary-fourth']");
    Faker fakerlogin = new Faker();
    String Email = fakerlogin.internet().emailAddress();
    String password = fakerlogin.internet().password();

    By LoginHeader = By.xpath("/html/body/div[1]/div[1]/div/div/div[2]/div/div[4]/a");
    By LoginEmail = By.xpath("/html/body/div[1]/div[2]/div/div[2]/div[3]/div/form/div[2]/div[1]/div/div/div[2]/div/div/div[1]/input");
    By LoginPassWord = By.xpath("/html/body/div[1]/div[2]/div/div[2]/div[3]/div/form/div[2]/div[2]/div/div/div[2]/div/div/div[1]/div/input");
    By LoginButton = By.xpath("/html/body/div[1]/div[2]/div/div[2]/div[3]/div/form/div[2]/div[4]/div/button");
    By ProfileName = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[4]/span[1]");
    By LogoutButton = By.xpath("//li[contains(text(),'Sign Out')]");


    @And("^user click on login button on home page$")
    public void user_click_on_login_button_on_home_page() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginHeader));
        driver.findElement(LoginHeader).click();
    }

    @And("^user enter a valid email$")
    public void user_enter_a_valid_email() {
        driver.findElement(LoginEmail).sendKeys("m.sayed.89@gmail.com");
        //driver.findElement(LoginEmail).sendKeys(fakerlogin.internet().emailAddress());

    }

    @And("^user enter the right password$")
    public void user_enter_the_right_password() {

        driver.findElement(LoginPassWord).sendKeys("@Test123");
        //driver.findElement(LoginPassWord).sendKeys(fakerlogin.internet().password());

    }

    @When("^the user click on login button$")
    public void the_user_click_on_login_button() {
        driver.findElement(LoginButton).click();

    }

    @Then("^the user shall be redirect to my booking page$")
    public void the_user_shall_be_redirect_to_my_booking_page() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div/div[2]/a")));
        WebElement MyProfile = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div/div[2]/a"));
        Assert.assertEquals(true, MyProfile.isDisplayed());

    }

    @Given("^user enter unregistered email$")
    public void user_enter_unregistered_email() {
        driver.findElement(LoginEmail).sendKeys("iamnotregistered@gmail.com");

    }

    @Then("^user shall see error message$")
    public void user_shall_see_error_message() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='tooltip error error']//span[@class='tooltiptext']")));
        WebElement errormessage = driver.findElement(By.xpath("//div[@class='tooltip error error']//span[@class='tooltiptext']"));
        Assert.assertEquals(errormessage.isDisplayed(), true);
    }


    @And("^user enter the wrong password$")
    public void user_enter_the_wrong_password() {
        driver.findElement(LoginPassWord).sendKeys("@test123");
    }

    @And("^user enter the password less than 8 chars$")
    public void user_Enter_The_Password_Less_Than_Chars() {
        driver.findElement(LoginPassWord).sendKeys("12345");
    }

    @Then("^user shall see password error message$")
    public void user_Shall_See_Password_ErrorMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='tooltiptext with-arrow']")));
        WebElement passworderrormessage = driver.findElement(By.xpath("//span[@class='tooltiptext with-arrow']"));
        Assert.assertEquals(passworderrormessage.isDisplayed(), true);
    }

    @And("^user enter the password more than 60 chars$")
    public void user_Enter_The_Password_more_Than_Chars() {
        driver.findElement(LoginPassWord).sendKeys("1111111111111111111111111111111111111111111111111111111111111");
    }


    @And("^user enter an invalid email$")
    public void user_Enter_An_In_valid_Email() {
        driver.findElement(LoginEmail).sendKeys("M.saYed.89gmailcom");

    }

    @Then("^user shall see email error message$")
    public void user_Shall_See_Email_Error_Message() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='tooltiptext with-arrow']")));
        WebElement emailerrormessage = driver.findElement(By.xpath("//span[@class='tooltiptext with-arrow']"));
        Assert.assertEquals(emailerrormessage.isDisplayed(), true);
    }

    @And("^user enter an empty email$")
    public void user_Enter_An_Empty_Email() {
        driver.findElement(LoginEmail).sendKeys("");

    }

    @And("^user enter empty password$")
    public void user_Enter_Empty_Password() {
        driver.findElement(LoginPassWord).sendKeys("");

    }

    @And("^user enter an upper case right email$")
    public void user_Enter_An_Upper_Case_Right_email() throws Throwable {
        driver.findElement(LoginEmail).sendKeys("M.saYed.89@gMail.com");

    }


    @And("^user logout$")
    public void user_Logout() {
        driver.findElement(ProfileName).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(LogoutButton));
        driver.findElement(LogoutButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginHeader));
        String homeText = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/h2[1]/span[1]")).getText();
        Assert.assertEquals(homeText, "Low Fares");


    }

    @Then("^'Sign In' page is opened$")
    public void signInPageIsOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SignInHeader));
        String headerText = driver.findElement(SignInHeader).getText();
        Assert.assertEquals(headerText, "Good to see you again");
    }


}
