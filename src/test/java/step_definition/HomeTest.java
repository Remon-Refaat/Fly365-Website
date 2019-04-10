package step_definition;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.APIUtility;
import helper.DataBase;
import helper.GeneralMethods;
import helper.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Map;

public class HomeTest extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, 10);
    GeneralMethods gmObject = new GeneralMethods();
    APIUtility apiObject = new APIUtility();
    ConfirmationTest ctobject = new ConfirmationTest();
    public static String orderNumber = null;
    public static String pnrNumber = null;
    public static String currentWindow = driver.getWindowHandle();


    private By aboutUsLINK = By.xpath("//a[text()='About us']");
    private By firstContactUsLINK = By.xpath("//footer/div[1]//a[text()='Contact us']");
    private By secondContactUsLINK = By.xpath("//footer/div[2]//a[text()='Contact Us']");
    private By signInLINK = By.xpath("//a[text()='Sign in']");
    private By signUpLINK = By.xpath("//a[text()='Sign up']");
    private By fristSupportCentreLINK = By.xpath("//footer/div[1]//a[text()='Support Centre']");
    private By secondSupportCentreLINK = By.xpath("//footer/div[2]//a[text()='Support Centre']");
    private By faqsLINK = By.xpath("//a[text()='FAQs']");
    private By termsConditionsLINK = By.xpath("//a[text()='Terms and Conditions']");
    private By privacyPolicyLINK = By.xpath("//a[text()='Privacy policy']");
    private By aftaLINK = By.xpath("//a[@title='Afta']");
    private By logoFooterLink = By.xpath("//footer/div[2]/div/div/div[1]/div/div[1]/div/a");
    private By logoHeaderLink = By.xpath("/html/body/div[1]/div[1]/div/div/div[1]/div/a");
    private By flightsLink = By.xpath("//div[1]/div[1]/div/div/div[1]/div/div/a[1]");
    private By offersLink = By.xpath("//div[1]/div[1]/div/div/div[1]/div/div/a[2]");
    private By signInBTN = By.xpath("//a[text()='SIGN IN']");
    private By homePageHDR = By.xpath("//h2/span");
    private By oneWayTAB = By.id("tab-oneWay");
    private By roundTripTAB = By.id("tab-roundTrip");
    private By multiCityTAB = By.id("tab-multiStop");
    private By originTXT = By.xpath("//input[@name='origin']");
    private By destinationTXT = By.xpath("//input[@name='destination']");
    private By airportSearchResultOrigin = By.xpath("//li[contains(@id, '-0')]");
    private By airportSearchResultDestination = By.xpath("//li[contains(@id, '-0')]");
    private By departureCalenderDPK = By.xpath("//input[@name='fromDate']");
    private By departureRoundCalenderDPK = By.xpath("//input[@name='d']");
    private By returnRoundCalenderDPK = By.xpath("//input[@name='a']");
    private By passengerCabinTXT = By.xpath("//div[@class='bg-white text-sm h-50 px-3 rounded flex items-center text-primary-third font-medium el-popover__reference']");
    private By passengerCabinPOPOVER = By.xpath("//body/div[contains(@id,'el-popover')][1]");
    private By plusAdultBTN = By.xpath("//*[contains(@id,'el-popover')]//div[1]/div/span[2]");
    private By plusChildBTN = By.xpath("//*[contains(@id,'el-popover')]//div[2]/div/span[2]");
    private By plusInfantBTN = By.xpath("//*[contains(@id,'el-popover')]//div[3]/div/span[2]");
    private By searchNowBTN = By.xpath("//button[@class='btn uppercase btn-search-form font-bold lg:w-full w-2/5 m-auto btn-primary-second h-full']");
    private By findMyBookingLINK = By.xpath("//button[text()='Find My Booking']");
    private By findMyBookingEmailTXT = By.xpath("//div[@class='container p-8 retrieve-booking-form']//input[@placeholder='Email']");
    private By findMyBookingAirlineFly365OrderTXT = By.xpath("//div[@class='container p-8 retrieve-booking-form']//input[@placeholder='Fly365 Reference']");
    private By findMyBookingFindBookingBTN = By.xpath("//div[@class='container p-8 retrieve-booking-form']//button[text()='FIND BOOKING']");
    private By addMoreCitiesLINK = By.xpath("//div[@class='flex items-center btn-add-more float-left text-white text-xs h-6 px-1 cursor-pointer leading-normal']");
    private By subscriptionTXT = By.xpath("//input[@placeholder='Your Email']");
    private By subscribeBTN = By.xpath("//button[text()='subscribe']");
    private By subscriptionSuccessfullyMSG = By.xpath("/html/body/div[3]/div/div[1]/p");
    private By alreadySubscribedErrorMSG = By.xpath("//div[3]/div/div[1]/p");
    private By passengerRulesLINK = By.xpath("//*[contains(@id, 'el-popover-')]/div[2]/a");
    private By passengerRulesHDR = By.xpath("//div[@class='el-dialog__wrapper']//div[1]/span");
    private By originEmptyErrorMSG = By.xpath("//form//div[1]/div/div[1]/div/div[2]/span");
    private By destinationEmptyErrorMSG = By.xpath("//form//div[1]/div/div[2]/div/div[2]/span");
    private By departureDateEmptyErrorMSG = By.xpath("//form//div[2]/div/div[1]/div/div[2]/span");
    private By findMyBookingEmptyEmail1ErrorMSG = By.xpath("//div[@class='el-form-item mb-4 is-error']//span[@class='tooltiptext with-arrow']/span[1]");
    private By findMyBookingEmptyEmail2ErrorMSG = By.xpath("//div[@class='el-form-item mb-4 is-error']//span[@class='tooltiptext with-arrow']/span[2]");
    private By findMyBookingEmptyRef1ErrorMSG = By.xpath("//div[@class='el-form-item is-error']//span[@class='tooltiptext with-arrow']/span[1]");
    private By findMyBookingEmptyRef2ErrorMSG = By.xpath("//div[@class='el-form-item is-error']//span[@class='tooltiptext with-arrow']/span[2]");
    private By emptyEmailAtSubscribe = By.xpath("//div[@class='form-group']//span[@class='tooltiptext with-arrow']");


    @Given("^Navigate to Fly365 \"(.*)\" site$")
    public void NavigateToFly365Site(String site) {
        driver.navigate().to("https://nz.fly365" + site + ".com/en");
    }

    @And("^Press on 'About us'$")
    public void pressOnAboutUs() {
        driver.findElement(aboutUsLINK).click();
    }

    @And("^Press on first 'Contact Us'$")
    public void pressOnFirstContactUs() {
        driver.findElement(firstContactUsLINK).click();
    }

    @And("^Press on second 'Contact Us'$")
    public void pressOnSecondContactUs() {
        driver.findElement(secondContactUsLINK).click();
    }

    @And("^Press on 'Sign in'$")
    public void pressOnSignIn() {
        driver.findElement(signInLINK).click();
    }

    @And("^Press on 'Sign up'$")
    public void pressOnSignUp() {
        driver.findElement(signUpLINK).click();
    }

    @And("^Press on first 'Support Centre'$")
    public void pressOnFirstSupportCenter() {
        driver.findElement(fristSupportCentreLINK).click();
    }

    @And("^Press on second 'Support Centre'$")
    public void pressOnSecondSupportCenter() {
        driver.findElement(secondSupportCentreLINK).click();
    }

    @And("^Press on 'FAQs'$")
    public void pressOnFAQs() {
        driver.findElement(faqsLINK).click();
    }

    @And("^Press on 'Terms and Conditions'$")
    public void pressOnTermsAndConditions() {
        driver.findElement(termsConditionsLINK).click();
    }

    @And("^Press on 'Privacy policy'$")
    public void pressOnPrivacyPolicy() {
        driver.findElement(privacyPolicyLINK).click();
    }

    @And("^Press on 'afta'$")
    public void pressOnAfta() {
        driver.findElement(aftaLINK).click();
    }

    @And("^Press on Logo in footer$")
    public void pressOnLogoInFooter() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoFooterLink));
        driver.findElement(logoFooterLink).click();
    }

    @And("^Press on Logo in header$")
    public void pressOnLogoInHeader() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoHeaderLink));
        driver.findElement(logoHeaderLink).click();
    }

    @And("^Press on flights in header$")
    public void pressOnFlightsInHeader() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(flightsLink));
        driver.findElement(flightsLink).click();
    }

    @And("^Press on offers in header$")
    public void pressOnOffersInHeader() {
        driver.findElement(offersLink).click();
    }

    @And("^Press on Sign In button$")
    public void pressOnSignInButton() {
        driver.findElement(signInBTN).click();
    }

    @Then("^Home page is opened$")
    public void homePageIsOpened() {
        String headerText = driver.findElement(homePageHDR).getText();
        Assert.assertEquals(headerText, "Low Fares");
    }

    @And("^Select One Way trip$")
    public void selectOneWayTrip() {
        driver.findElement(oneWayTAB).click();
    }

    @And("^Select Round Trip trip$")
    public void selectRoundTripTrip() {
        driver.findElement(roundTripTAB).click();
    }

    @And("^Select Multi City trip$")
    public void selectMultiCityTrip() {
        driver.findElement(multiCityTAB).click();
    }

    @And("^Add airport to the Origin \"(.*)\"$")
    public void addAirportToTheOrigin(String originAirport) {
        driver.findElement(originTXT).sendKeys(originAirport);
        wait.until(ExpectedConditions.visibilityOfElementLocated(airportSearchResultOrigin));
        driver.findElement(airportSearchResultOrigin).click();
    }

    @And("^Add airport to the Destination \"(.*)\"$")
    public void addAirportToTheDestination(String destinationAirport) {
        driver.findElement(destinationTXT).sendKeys(destinationAirport);
        wait.until(ExpectedConditions.visibilityOfElementLocated(airportSearchResultDestination));
        driver.findElement(airportSearchResultDestination).click();
    }


    @And("^Select the date of the departure, after \"(.*)\" day from today$")
    public void selectTheDateOfTheDepartureAfterDayFromToday(int period) {
        String departureDate = gmObject.addDateWithCertainPeriodAndFormat(period, "dd MMM yyyy");
        driver.findElement(departureCalenderDPK).sendKeys(departureDate);
    }

    @And("^Select the date of the departure for round trip, after \"(.*)\" day from today$")
    public void selectTheDateOfTheDepartureForRoundTripAfterDayFromToday(int period) {
        driver.findElement(roundTripTAB).click();
        String returnDate = gmObject.addDateWithCertainPeriodAndFormat(period, "dd MMM yyyy");
        driver.findElement(departureRoundCalenderDPK).sendKeys(returnDate);
    }

    @And("^Select the date of the return for round trip, after \"(.*)\" day from today$")
    public void selectTheDateOfTheReturnForRoundTripAfterDayFromToday(int period) throws InterruptedException {
        String returnDate = gmObject.addDateWithCertainPeriodAndFormat(period, "dd MMM yyyy");
        driver.findElement(returnRoundCalenderDPK).sendKeys(returnDate);
        driver.findElement(roundTripTAB).click();
        Thread.sleep(500);
    }

    @And("^Press on Search Now$")
    public void pressOnSearchNow() {
        driver.findElement(searchNowBTN).click();
    }


    @And("^Book a trip from API for \"(.*)\" and get \"(.*)\"$")
    public void bookATripFromAPIForAndGet(String domain, String reference) {
        String requestUrl = "https://api.fly365" + domain + ".com/flight-search/search";
        String allAvailableTrips = apiObject.sendPostRequest(requestUrl, apiObject.oneWayAPI());
        String itinaryID = apiObject.getItineraryId(allAvailableTrips, 2);
        String cardID = apiObject.createCart(itinaryID, domain);
        apiObject.addPassenger(cardID, domain);
        if (reference.equals("Airline Reference")) {
            orderNumber = apiObject.checkoutTrip(cardID, domain)[0];
        }
        if (reference.equals("Fly365 Reference")) {
            pnrNumber = apiObject.checkoutTrip(cardID, domain)[1];
        }
    }


    @And("^Click on Find My Booking$")
    public void clickOnFindMyBooking() {
        driver.findElement(findMyBookingLINK).click();
    }

    @And("^Add a valid email address \"(.*)\"$")
    public void addAValidEmailAddress(String findMyBookingEmailAddress) {
        driver.findElement(findMyBookingEmailTXT).sendKeys(findMyBookingEmailAddress);
    }

    @And("^Add a valid \"(.*)\"$")
    public void addAValid(String reference) {

        if (reference.equals("Fly365 Reference")) {
            driver.findElement(findMyBookingAirlineFly365OrderTXT).sendKeys(pnrNumber);
        }
        if (reference.equals("Airline Reference")) {
            driver.findElement(findMyBookingAirlineFly365OrderTXT).sendKeys(orderNumber);
        }
    }

    @And("^Add a valid Reference 'Fly365 Ref'$")
    public void addAValidReferenceFly365Ref()  {
        driver.findElement(findMyBookingAirlineFly365OrderTXT).sendKeys(ctobject.fly356Refernce);

    }

    @And("^Press Find Booking$")
    public void pressFindBooking() {
        driver.findElement(findMyBookingFindBookingBTN).click();
    }


    @And("^Select Passengers: \"(.*)\" adult, \"(.*)\" child, \"(.*)\" infant$")
    public void selectPassengersAdultChildInfant(int adultCount, int childCount, int infantCount) {
        driver.findElement(passengerCabinTXT).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(passengerCabinPOPOVER));

        for (int counter = 0; counter < (adultCount - 1); counter++) {
            driver.findElement(plusAdultBTN).click();
        }

        for (int counter = 0; counter < childCount; counter++) {
            driver.findElement(plusChildBTN).click();
        }

        for (int counter = 0; counter < infantCount; counter++) {
            driver.findElement(plusInfantBTN).click();
        }

    }

    @And("^Select \"(.*)\" Class$")
    public void selectClass(String cabinClass) {

        driver.findElement(By.xpath("//span[text()='" + cabinClass + "']/preceding-sibling::span")).click();
    }


    @And("^Choose the number of flights \"(.*)\"$")
    public void chooseTheNumberOfFlights(int flightcount) {
        for (int counter = 2; counter < flightcount; counter++) {
            driver.findElement(addMoreCitiesLINK).click();
        }
    }

    @And("^Add the following origin, destinations and date periods$")
    public void addTheFollowingOriginDestinationsAndDatePeriods(DataTable multiCityData) throws InterruptedException {
        int i = 1;

        for (Map<String, String> flightDetails : multiCityData.asMaps(String.class, String.class)) {

            driver.findElement(By.xpath("//div[@class='search-form relative row justify-center']//form[" + i + "]//input[@name='origin']")).sendKeys(flightDetails.get("Origin"));
            gmObject.selectFromAutoCompleteDDL(flightDetails.get("Origin"));
            driver.findElement(By.xpath("//div[@class='search-form relative row justify-center']//form[" + i + "]//input[@name='destination']")).sendKeys(flightDetails.get("Destination"));
            gmObject.selectFromAutoCompleteDDL(flightDetails.get("Destination"));
            String returnDate = gmObject.addDateWithCertainPeriodAndFormat(Integer.parseInt(flightDetails.get("Date Period")), "dd MMM yyyy");
            driver.findElement(By.xpath("//div[@class='search-form relative row justify-center']//form[" + i + "]//input[@name='fromDate']")).sendKeys(returnDate);
            i++;
        }
    }


    // Subscription Email

    @And("^Add the email address \"(.*)\" to Subscription Email field$")
    public void addTheEmailAddressToSubscriptionEmailField(String emailAddress) {
        DataBase.execute_query_dbs("k8stage1.cl9iojf4kdop.eu-west-1.rds.amazonaws.com:5432", "user_api", "Select email from newsletter_users where email = '" + emailAddress + "'");
        if (DataBase.data != null) {
            DataBase.execute_query_dbs("k8stage1.cl9iojf4kdop.eu-west-1.rds.amazonaws.com:5432", "user_api", "delete from newsletter_users where email='" + emailAddress + "'");
        }
        driver.findElement(subscriptionTXT).sendKeys(emailAddress);
    }


    @When("^Press on SUBSCRIBE$")
    public void pressOnSUBSCRIBE() throws InterruptedException {
        driver.findElement(subscribeBTN).click();
        Thread.sleep(2000);

    }

    @Then("^Successfully validation message is displayed$")
    public void successfullyValidationMessageIsDisplayed() {
        Assert.assertEquals(driver.findElement(subscriptionSuccessfullyMSG).getText(), "You've subscribed successfully. Tune in for our updates and special offers");
    }


    @And("^Add previously subscribed email address \"(.*)\" to Subscription Email field$")
    public void addPreviouslySubscribedEmailAddressToSubscriptionEmailField(String emailAddress) throws Throwable {
        DataBase.execute_query_dbs("k8stage1.cl9iojf4kdop.eu-west-1.rds.amazonaws.com:5432", "user_api", "Select email from newsletter_users where email = '" + emailAddress +"'");
        if (DataBase.data == null) {
            DataBase.execute_query_dbs("k8stage1.cl9iojf4kdop.eu-west-1.rds.amazonaws.com:5432", "user_api", "insert into newsletter_users (email, \"isSubscribed\",\"storeId\",\"groupId\", \"isRegistered\")values('" + emailAddress + "',True,'fly365_nz','fly365',False)");
        }
        driver.findElement(subscriptionTXT).sendKeys(emailAddress);
    }

    @Then("^Error validation message is displayed$")
    public void errorValidationMessageIsDisplayed() {
        Assert.assertEquals(driver.findElement(alreadySubscribedErrorMSG).getText(),"You have already subscribed fly365");

    }

    @And("^Press on Passenger/Cabin pop over$")
    public void pressOnPassengerCabinPopOver() {
        driver.findElement(passengerCabinTXT).click();
    }

    @And("^Press on Passenger Rules link$")
    public void pressOnPassengerRulesLink() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passengerRulesLINK));
        driver.findElement(passengerRulesLINK).click();
    }

    @Then("^'Passenger Rules' pop up will be opened$")
    public void passengerRulesPopUpWillBeOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passengerRulesHDR));
        Assert.assertEquals(driver.findElement(passengerRulesHDR).getText(),"Passenger Rules");

    }


    @Then("^error message appear for each field$")
    public void errorMessageAppearForEachField() {
        String originerrormessage = driver.findElement(originEmptyErrorMSG).getText();
        Assert.assertEquals(originerrormessage, "!Please choose origin from the list");

        String destinationerrormessage = driver.findElement(destinationEmptyErrorMSG).getText();
        Assert.assertEquals(destinationerrormessage, "!Please choose destination from the list");

        String departureerrormessage = driver.findElement(departureDateEmptyErrorMSG).getText();
        Assert.assertEquals(departureerrormessage, "!Please enter required date");
    }

    @Then("^error message appear appear over the two fields$")
    public void errorMessageAppearAppearOverTheTwoFields() {
        String emailfinderrormessage1 = driver.findElement(findMyBookingEmptyEmail1ErrorMSG).getText();
        String emailfinderrormessage2 = driver.findElement(findMyBookingEmptyEmail2ErrorMSG).getText();

        Assert.assertEquals(emailfinderrormessage1+emailfinderrormessage2, "!Please enter email");

        String referrormessage1 = driver.findElement(findMyBookingEmptyRef1ErrorMSG).getText();
        String referrormessage2 = driver.findElement(findMyBookingEmptyRef2ErrorMSG).getText();

        Assert.assertEquals(referrormessage1+referrormessage2, "!Please enter Fly365 Ref.");
    }

    @Then("^empty subscribe error message appear$")
    public void emptySubscribeErrorMessageAppear() {
        String emptysubscriber = driver.findElement(emptyEmailAtSubscribe).getText();
        Assert.assertEquals(emptysubscriber, "!Please enter email");
    }

}
