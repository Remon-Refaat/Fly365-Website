package step_definition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import helper.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AccountSettingsTest extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, 10);

    private By hiHDR = By.xpath("//span[contains(text(),'Hi')]");
    private By accountSettingsTAB = By.xpath("//a[contains(text(),'ACCOUNT SETTINGS')]");
    private By accountSettingsHDR = By.xpath("//p[contains(text(),'Account information details, Add or edit')]");
    private By firstNameTXT = By.xpath("//input[@placeholder='First Name']");
    private By saveBTN = By.xpath("//div[@class='account-form-container']//button[@type='submit'][contains(text(),'Save')]");
    private By updatedNameHDR = By.xpath("//div[contains(text(),'david')]");


    @And("^Click on Account Settings tab$")
    public void clickOnAccountSettingsTab() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(hiHDR));
        driver.findElement(accountSettingsTAB).click();
    }

    @Then("^Account Settings page opened$")
    public void accountSettingsPageOpened() {
        Assert.assertEquals(driver.findElement(accountSettingsHDR).getText(), "Account information details, Add or edit");
    }

    @Then("^Update First Name$")
    public void updateFirstName() {
        driver.findElement(firstNameTXT).clear();
        driver.findElement(firstNameTXT).sendKeys("david");
        driver.findElement(saveBTN).click();
    }

    @Then("^Check updated First Name$")
    public void checkUpdatedFirstName() {
        Assert.assertTrue(driver.findElement(updatedNameHDR).isDisplayed());
    }
}
