package step_definition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import helper.TestBase;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class HomeTest extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, 10);

    By aboutUsLink = By.xpath("//a[text()='About us']");
    By contactUsLink = By.xpath("//a[text()='Contact Us']");
    By signInLink = By.xpath("//a[text()='Sign in']");
    By signUpLink = By.xpath("//a[text()='Sign up']");
    By supportCenterLink = By.xpath("//a[text()='Support Center']");
    By faqsLink = By.xpath("//a[text()='FAQs']");
    By termsConditionsLink = By.xpath("//a[text()='Terms and Conditions']");
    By privacyPolicyLink = By.xpath("//a[text()='Privacy policy']");
    By oneWayTab = By.id("tab-oneWay");
    By originTxt = By.xpath("//input[@name='origin']");
    By destinationTxt = By.xpath("//input[@name='destination']");
    By airportSearchResultOrigin = By.xpath("//li[contains(@id, '-0')]");
    By airportSearchResultDestination = By.xpath("//li[contains(@id, '-0')]");
    By calenderDatePicker = By.xpath("//input[@name='fromDate']");
    By searchNowBtn = By.xpath("//button[@class='btn uppercase font-bold w-full btn-primary-second h-full']");

    @Given("^Navigate to URl$")
    public void navigate_to_URl() {

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


    @And("^Select One Way trip$")
    public void selectOneWayTrip() {
        driver.findElement(oneWayTab).click();
    }

    @And("^Add airport to the Origin$")
    public void addAirportToTheOrigin() {
        driver.findElement(originTxt).sendKeys("Cairo International Airport (CAI), Egypt");
        wait.until(ExpectedConditions.visibilityOfElementLocated(airportSearchResultOrigin));
        driver.findElement(airportSearchResultOrigin).click();
    }

    @And("^Add airport to the Destination$")
    public void addAirportToTheDestination() {
        driver.findElement(destinationTxt).sendKeys("Dublin International (DUB), Ireland");
        wait.until(ExpectedConditions.visibilityOfElementLocated(airportSearchResultDestination));
        driver.findElement(airportSearchResultDestination).click();
    }

    @And("^Select the date of the trip$")
    public void selectTheDateOfTheTrip() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 10);
        String pattern = "dd MMM yyyy";
        SimpleDateFormat simpleFormat = new SimpleDateFormat(pattern);
        String date = simpleFormat.format(cal.getTime());
        driver.findElement(calenderDatePicker).sendKeys(date);
    }

    @And("^Press on Search Now$")
    public void pressOnSearchNow() throws InterruptedException {
        driver.findElement(searchNowBtn).click();
        Thread.sleep(10000);
    }


}
