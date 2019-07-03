package step_definition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import helper.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class HubLogin extends TestBase {
    WebDriverWait wait = new WebDriverWait(driver, 30);


    private By HubLoginEmailTXT = By.xpath("//input[@id='inputEmail']");
    private By HubLoginPasswordTXT = By.xpath("//input[@id='inputPassword']");
    private By HubLoginBTN = By.xpath("//button[@class='btn btn-lg btn-primary btn-block']");
    private By HubDashWelcomeMSG = By.xpath("//h2[@class='d-flex justify-content-center align-items-center text-primary dashboard__title']");
    private By Tickets = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[2]");
    private By Firstinboxtitle = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/h3[1]/a[1]");


    @And("^Open hub login page$")
    public void openHubLoginPage() {
        driver.navigate().to("https://hub.fly365stage.com/login?redirect=/");
    }


    @And("^login into hub with super admin$")
    public void loginIntoHubWithSuperAdmin() {
        driver.findElement(HubLoginEmailTXT).sendKeys("superadmin@fly365.com");
        driver.findElement(HubLoginPasswordTXT).sendKeys("@Admin123");
        driver.findElement(HubLoginBTN).click();
        String WelcomeMSG = driver.findElement(HubDashWelcomeMSG).getText();
        Assert.assertEquals(WelcomeMSG, "Welcome to Fly365 Hub");
    }

    @And("^open Back office$")
    public void openBackoffice() {
        driver.navigate().to("https://backoffice.fly365stage.com/");
    }

    @And("^open tickets$")
    public void opentickets() throws InterruptedException {
        driver.findElement(Tickets).click();
        Thread.sleep(5000);
    }


    @Then("^contact us message appear as ticket$")
    public void contactusmessageappearasticket() {
        String Messagetitle = driver.findElement(Firstinboxtitle).getText().substring(0, 27);
        Assert.assertEquals(Messagetitle, "John Smith-General Question");

    }

}
