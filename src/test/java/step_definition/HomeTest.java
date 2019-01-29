package step_definition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.openqa.selenium.By;

public class HomeTest  extends TestBase{


    By aboutUsLink = By.xpath("//a[text()='About us']");
    By contactUsLink = By.xpath("//a[text()='Contact Us']");
    By signInLink = By.xpath("//a[text()='Sign in']");
    By signUpLink = By.xpath("//a[text()='Sign up']");
    By supportCenterLink = By.xpath("//a[text()='Support Center']");
    By faqsLink = By.xpath("//a[text()='FAQs']");
    By termsConditionsLink = By.xpath("//a[text()='Terms and Conditions']");
    By privacyPolicyLink = By.xpath("//a[text()='Privacy policy']");

    @Given("^Navigate to URl$")
    public void navigate_to_URl()
    {

        driver.navigate().to("https://www.fly365stage.com/en");
    }

    @And("^Press on 'About us'$")
    public void pressOnAboutUs() {
        driver.findElement(aboutUsLink).click();
    }

    @And("^Press on 'Contact Us'$")
    public void pressOnContactUs() {
        driver.findElement(contactUsLink).click();
    }

    @And("^Press on 'Sign in'$")
    public void pressOnSignIn() {
        driver.findElement(signInLink).click();
    }

    @And("^Press on 'Sign up'$")
    public void pressOnSignUp() {
        driver.findElement(signUpLink).click();
    }

    @And("^Press on 'Support Center'$")
    public void pressOnSupportCenter() {
        driver.findElement(supportCenterLink).click();
    }

    @And("^Press on 'FAQs'$")
    public void pressOnFAQs() {
        driver.findElement(faqsLink).click();
    }

    @And("^Press on 'Terms and Conditions'$")
    public void pressOnTermsAndConditions() {
        driver.findElement(termsConditionsLink).click();
    }

    @And("^Press on 'Privacy policy'$")
    public void pressOnPrivacyPolicy() {
        driver.findElement(privacyPolicyLink).click();
    }





}
