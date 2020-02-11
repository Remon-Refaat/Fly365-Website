package features.Flight;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import helper.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;


public class SocialLogin extends TestBase {


    private By googleBTN = By.xpath("//span[contains(text(), 'Google')]");
    private By googleAccount = By.xpath("(//div[@id='profileIdentifier'])[1]");





    @And("^click on Google Login button$")
    public void click_on_Google_Login_button(){
        driver.findElement(googleBTN).click();

    }

    @And("^Sign in with google account option$")
    public void  sign_in_with_google_account_option() {
            String parentWindow = driver.getWindowHandle();

            WebDriverWait wait = new WebDriverWait(driver,5);
            wait.until(ExpectedConditions.numberOfWindowsToBe(2));
            Set<String> s1 = driver.getWindowHandles();
            Iterator<String> i1 = s1.iterator();
            while(i1.hasNext())
            {
                String next_tab = i1.next();
                if (!parentWindow.equalsIgnoreCase(next_tab))
                {
                    driver.switchTo().window(next_tab);
                    WebDriverWait wait2 = new WebDriverWait(driver, 20);
                    wait2.until(ExpectedConditions.elementToBeClickable(googleAccount)).click();
                }
            }
            throw new PendingException();
        }
    @Then("^Assert that user logged in successfully$")
    public void assertThatUserLoggedInSuccessfully() {

    }


}

