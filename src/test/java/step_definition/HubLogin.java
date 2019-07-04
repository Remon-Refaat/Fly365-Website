package step_definition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import helper.GeneralMethods;
import helper.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class HubLogin extends TestBase {
    WebDriverWait wait = new WebDriverWait(driver, 30);

    private GeneralMethods gmObject = new GeneralMethods();


    private By HubLoginEmailTXT = By.xpath("//input[@id='inputEmail']");
    private By HubLoginPasswordTXT = By.xpath("//input[@id='inputPassword']");
    private By HubLoginBTN = By.xpath("//button[@class='btn btn-lg btn-primary btn-block']");
    private By HubDashWelcomeMSG = By.xpath("//h2[@class='d-flex justify-content-center align-items-center text-primary dashboard__title']");
    //private By HubHamMenu = By.xpath("//li[@class='header__top__left__el-submenu el-submenu']//div[@class='el-submenu__title']");
    //private By BackOffice = By.xpath("//input[@id='inputEmail']");
    private By Tickets = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[2]");
    private By Firstinboxtitle = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/h3[1]/a[1]");
    private By Createticket = By.xpath("//button[@class='btn text-white bg-primary-first button-ticket btn-secondary']");
    private By ticketEmail = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/input[1]");
    private By ticketsubject = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/input[1]");
    private By ticketbody = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[4]/div[2]/div[2]/div[1]");
    private By ticketstore = By.xpath("//input[@placeholder='Select Store']");
    private By nzticketstore = By.xpath("//span[contains(text(),'New Zealand')]");
    private By sendBTN = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[5]/div[2]/button[2]");


    @And("^Open hub login page$")
    public void openHubLoginPage() {
        driver.navigate().to("https://hub.fly365stage.com/login?redirect=/");
    }


    @And("^login into hub with super admin$")
    public void loginIntoHubWithSuperAdmin() {
        driver.findElement(HubLoginEmailTXT).sendKeys("john.smith.fly365@gmail.com");
        driver.findElement(HubLoginPasswordTXT).sendKeys("@Fly1020");
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
        String Messagetitle = driver.findElement(Firstinboxtitle).getText();
        Assert.assertTrue(Messagetitle.contains("John Smith-General Question"));

    }

    @And("^press on create ticket$")
    public void pressOnCreateTicket() {
        driver.findElement(Createticket).click();

    }

    @And("^fill message data$")
    public void fillMessageData() {
        driver.findElement(ticketEmail).sendKeys("john.smith.fly365@gmail.com");
        driver.findElement(ticketsubject).sendKeys("test001");
        driver.findElement(ticketbody).sendKeys("test send create ticket throw create ");
        driver.findElement(ticketstore).click();
        driver.findElement(nzticketstore).click();
    }

    @And("^press send$")
    public void pressSend() {
        driver.findElement(sendBTN).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    @Then("^ticket created$")
    public void ticketCreated() {
        String Messagetitle = driver.findElement(Firstinboxtitle).getText();
        Assert.assertTrue(Messagetitle.contains("test001"));
    }
}
