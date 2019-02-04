package step_definition;

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

    WebDriverWait wait = new WebDriverWait(driver, 10);

    //Faker fakerlogin = new Faker();
    //String Email = fakerlogin.internet().emailAddress();
    //String password = fakerlogin.internet().password();
    String userEmail = "m.sayed.89@gmail.com";
    String userHashPassWord = "$2y$04$E3GLR2vVV0AKfvwm6L0MDeKpVfFw4kR58wb9ohNN.TpGoF6fdpoK.\n";
    String userPassWord = "@Test123";
    String hostName = "k8stage1.cl9iojf4kdop.eu-west-1.rds.amazonaws.com:5432";
    String dbsName = "user_api";

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
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginHeaderBtn));
        driver.findElement(LoginHeaderBtn).click();
    }

    @And("^user enter a valid email$")
    public void userEnterAValidEmail() {
        driver.findElement(LoginEmailTxt).sendKeys(userEmail);
        //driver.findElement(LoginEmail).sendKeys(fakerlogin.internet().emailAddress());

    }

    @And("^user enter the right password$")
    public void userEnterTheRightPassword() {

        driver.findElement(LoginPassWordTxt).sendKeys(userPassWord);
        //driver.findElement(LoginPassWord).sendKeys(fakerlogin.internet().password());

    }

    @When("^the user click on login button$")
    public void theUserClickOnLoginButton() {
        driver.findElement(LoginBtn).click();

    }

    @Then("^the user shall be redirect to my booking page$")
    public void theUserShallBeRedirectToMyBookingPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div/div[2]/a")));
        WebElement MyProfile = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div/div[2]/a"));
        Assert.assertEquals(true, MyProfile.isDisplayed());

    }

    @Given("^user enter unregistered email$")
    public void userEnterUnregisteredEmail() {
        driver.findElement(LoginEmailTxt).sendKeys("iamnotregistered@gmail.com");

    }

    @Then("^user shall see error message$")
    public void userShallSeeErrorMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='tooltip error error']//span[@class='tooltiptext']")));
        WebElement errormessage = driver.findElement(By.xpath("//div[@class='tooltip error error']//span[@class='tooltiptext']"));
        Assert.assertEquals(errormessage.isDisplayed(), true);
    }


    @And("^user enter the wrong password$")
    public void userEnterTheWrongPassword() {
        driver.findElement(LoginPassWordTxt).sendKeys("@test123");
    }

    @And("^user enter the password less than 8 chars$")
    public void userEnterThePasswordLessThanChars() {
        driver.findElement(LoginPassWordTxt).sendKeys("12345");
    }

    @Then("^user shall see password error message$")
    public void userShallSeePasswordErrorMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='tooltiptext with-arrow']")));
        WebElement passworderrormessage = driver.findElement(By.xpath("//span[@class='tooltiptext with-arrow']"));
        Assert.assertEquals(passworderrormessage.isDisplayed(), true);
    }

    @And("^user enter the password more than 60 chars$")
    public void userEnterThePasswordmoreThanChars() {
        driver.findElement(LoginPassWordTxt).sendKeys("1111111111111111111111111111111111111111111111111111111111111");
    }


    @And("^user enter an invalid email$")
    public void userEnterAnInValidEmail() {
        driver.findElement(LoginEmailTxt).sendKeys("M.saYed.89gmailcom");

    }

    @Then("^user shall see email error message$")
    public void userShallSeeEmailErrorMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='tooltiptext with-arrow']")));
        WebElement emailerrormessage = driver.findElement(By.xpath("//span[@class='tooltiptext with-arrow']"));
        Assert.assertEquals(emailerrormessage.isDisplayed(), true);
    }

    @And("^user enter an empty email$")
    public void userEnterAnEmptyEmail() {
        driver.findElement(LoginEmailTxt).sendKeys("");

    }

    @And("^user enter empty password$")
    public void userEnterEmptyPassword() {
        driver.findElement(LoginPassWordTxt).sendKeys("");

    }

    @And("^user enter an upper case right email$")
    public void userEnterAnUpperCaseRightEmail() {
        driver.findElement(LoginEmailTxt).sendKeys(userEmail.toUpperCase());

    }


    @And("^user logout$")
    public void userLogout() {
        driver.findElement(ProfileNameBtn).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(LogoutBtn));
        driver.findElement(LogoutBtn).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginHeaderBtn));
        String homeText = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/h2[1]/span[1]")).getText();
        Assert.assertEquals(homeText, "Low Fares");


    }

    @And("^insert new user at database$")
    public void insertNewUserAtDataBase() {
        DataBase.execute_update(hostName, dbsName, "insert into users (email, \"lastName\",\"firstName\",password,\"storeId\", \"groupId\")values('" + userEmail + "','Sayed','Mahmoud','" + userHashPassWord + "','fly365_com','fly365')");
    }


    @And("^delete new user at database$")
    public void deleteTheNewUserAtDataBase() {

        DataBase.execute_query_dbs(hostName, dbsName, "delete from users where email='" + userEmail + "'");
    }


}
