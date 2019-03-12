package step_definition;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import helper.APIUtility;
import helper.GeneralMethods;
import helper.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

public class HomeTest extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, 10);
    GeneralMethods gmObject = new GeneralMethods();
    APIUtility apiObject = new APIUtility();
    public static String orderNumber = null;
    public static String pnrNumber = null;


    By aboutUsLINK = By.xpath("//a[text()='About us']");
    By firstContactUsLINK = By.xpath("//footer/div[1]//a[text()='Contact us']");
    By secondContactUsLINK = By.xpath("//footer/div[2]//a[text()='Contact Us']");
    By signInLINK = By.xpath("//a[text()='Sign in']");
    By signUpLINK = By.xpath("//a[text()='Sign up']");
    By fristSupportCenterLINK = By.xpath("//footer/div[1]//a[text()='Support Center']");
    By secondSupportCenterLINK = By.xpath("//footer/div[2]//a[text()='Support Center']");
    By faqsLINK = By.xpath("//a[text()='FAQs']");
    By termsConditionsLINK = By.xpath("//a[text()='Terms and Conditions']");
    By privacyPolicyLINK = By.xpath("//a[text()='Privacy policy']");
    By oneWayTAB = By.id("tab-oneWay");
    By roundTripTAB = By.id("tab-roundTrip");
    By multiCityTAB = By.id("tab-multiStop");
    By originTXT = By.xpath("//input[@name='origin']");
    By destinationTXT = By.xpath("//input[@name='destination']");
    By airportSearchResultOrigin = By.xpath("//li[contains(@id, '-0')]");
    By airportSearchResultDestination = By.xpath("//li[contains(@id, '-0')]");
    By departureCalenderDPK = By.xpath("//input[@name='fromDate']");
    By departureRoundCalenderDPK = By.xpath("//input[@name='d']");
    By returnRoundCalenderDPK = By.xpath("//input[@name='a']");
    By passengerCabinBOX = By.xpath("//div[@class='bg-white text-sm h-50 px-3 rounded flex items-center text-primary-third font-medium el-popover__reference']");
    By passengerCabinPOPUP = By.xpath("//body/div[contains(@id,'el-popover')][1]");
    By plusAdultICON = By.xpath("//*[contains(@id,'el-popover')]//div[1]/div/span[2]");
    By plusChildICON = By.xpath("//*[contains(@id,'el-popover')]//div[2]/div/span[2]");
    By plusInfantICON = By.xpath("//*[contains(@id,'el-popover')]//div[3]/div/span[2]");
    By searchNowBTN = By.xpath("//button[@class='btn uppercase btn-search-form font-bold lg:w-full w-2/5 m-auto btn-primary-second h-full']");
    By findMyBookingLINK = By.xpath("//button[text()='Find My Booking']");
    By findMyBookingEmailTXT = By.xpath("//div[@class='container p-8 retrieve-booking-form']//input[@placeholder='Email']");
    By findMyBookingAirlineFly365OrderTXT = By.xpath("//div[@class='container p-8 retrieve-booking-form']//input[@placeholder='Airline / Fly365 Reference']");
    By findMyBookingFindBookingBTN = By.xpath("//div[@class='container p-8 retrieve-booking-form']//button[text()='FIND BOOKING']");
    By addMoreCities = By.xpath("//div[@class='flex items-center btn-add-more float-left text-white text-xs h-6 px-1 cursor-pointer leading-normal']");


    @Given("^Navigate to Fly365 \"(.*)\" site$")
    public void NavigateToFly365Site(String site) {
        driver.navigate().to("https://www.fly365"+site+".com/en");
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

    @And("^Press on first 'Support Center'$")
    public void pressOnFirstSupportCenter() {
        driver.findElement(fristSupportCenterLINK).click();
    }

    @And("^Press on second 'Support Center'$")
    public void pressOnSecondSupportCenter() {
        driver.findElement(secondSupportCenterLINK).click();
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


    @And("^Select One Way trip$")
    public void selectOneWayTrip() {
        driver.findElement(oneWayTAB).click();
    }

    @And("^Select Round Trip trip$")
    public void selectRoundTripTrip() {
        gmObject.clearLocalStorage();
        driver.findElement(roundTripTAB).click();
    }

    @And("^Select Multi City trip$")
    public void selectMultiCityTrip() {
        gmObject.clearLocalStorage();
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
    public void selectTheDateOfTheDepartureAfterDayFromToday(int period)  {
        String departureDate = gmObject.addDateWithCertainPeriodAndFormat(period,"dd MMM yyyy");
        driver.findElement(departureCalenderDPK).sendKeys(departureDate);
    }

    @And("^Select the date of the departure for round trip, after \"(.*)\" day from today$")
    public void selectTheDateOfTheDepartureForRoundTripAfterDayFromToday(int period)  {
        String returnDate = gmObject.addDateWithCertainPeriodAndFormat(period,"dd MMM yyyy");
        driver.findElement(departureRoundCalenderDPK).sendKeys(returnDate);
    }

    @And("^Select the date of the return for round trip, after \"(.*)\" day from today$")
    public void selectTheDateOfTheReturnForRoundTripAfterDayFromToday(int period)  {
        String returnDate = gmObject.addDateWithCertainPeriodAndFormat(period,"dd MMM yyyy");
        driver.findElement(returnRoundCalenderDPK).sendKeys(returnDate);
    }

    @And("^Press on Search Now$")
    public void pressOnSearchNow() {
        driver.findElement(searchNowBTN).click();
    }


    @And("^Book a trip from API for \"(.*)\" and get \"(.*)\"$")
    public void bookATripFromAPIForAndGet(String domain, String reference) {
        String requestUrl="https://api.fly365"+domain+".com/flight/search";
        String allAvailableTrips = apiObject.sendPostRequest(requestUrl,apiObject.oneWayAPI());
        String itinaryID = apiObject.getItineraryId(allAvailableTrips, 2);
        String cardID = apiObject.createCart(itinaryID);
        apiObject.addPassenger(cardID);
        if (reference.equals("Fly365 Reference")){
            orderNumber = apiObject.checkoutTrip(cardID)[0];
        }
        if (reference.equals("Airline Reference")){
            pnrNumber = apiObject.checkoutTrip(cardID)[1];
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
    public void addAValidReference(String reference) {

        if (reference.equals("Fly365 Reference")){
            driver.findElement(findMyBookingAirlineFly365OrderTXT).sendKeys(orderNumber);
        }
        if (reference.equals("Airline Reference")){
            driver.findElement(findMyBookingAirlineFly365OrderTXT).sendKeys(pnrNumber);
        }
    }

    @And("^Press Find Booking$")
    public void pressFindBooking() {
        driver.findElement(findMyBookingFindBookingBTN).click();
    }


    @And("^Select Passengers: \"(.*)\" adult, \"(.*)\" child, \"(.*)\" infant$")
    public void selectPassengersAdultChildInfant(int adultCount, int childCount, int infantCount)  {
        driver.findElement(passengerCabinBOX).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(passengerCabinPOPUP));

        for (int counter = 0; counter < (adultCount - 1); counter++) {
            driver.findElement(plusAdultICON).click();
        }

        for (int counter = 0; counter < childCount; counter++) {
            driver.findElement(plusChildICON).click();
        }

        for (int counter = 0; counter < infantCount; counter++) {
            driver.findElement(plusInfantICON).click();
        }

    }

    @And("^Select \"(.*)\" Class$")
    public void selectClass(String cabinClass)  {

        driver.findElement(By.xpath("//span[text()='"+cabinClass+"']/preceding-sibling::span")).click();
    }


    @And("^Choose the number of flights \"(.*)\"$")
    public void chooseTheNumberOfFlights(int flightcount)  {
        for (int counter = 2; counter < flightcount; counter++) {
            driver.findElement(addMoreCities).click();
        }
    }

    @And("^Add the following origin, destinations and date periods$")
    public void addTheFollowingOriginDestinationsAndDatePeriods(DataTable multiCityData) throws InterruptedException {
        int i = 1;

        for (Map<String, String> flightDetails : multiCityData.asMaps (String.class,String.class)){

            driver.findElement(By.xpath("//div[@class='search-form relative row justify-center']//form["+i+"]//input[@name='origin']")).sendKeys(flightDetails.get("Origin"));
            gmObject.selectFromAutoCompleteDDL(flightDetails.get("Origin"));
            driver.findElement(By.xpath("//div[@class='search-form relative row justify-center']//form["+i+"]//input[@name='destination']")).sendKeys(flightDetails.get("Destination"));
            gmObject.selectFromAutoCompleteDDL(flightDetails.get("Destination"));
            String returnDate = gmObject.addDateWithCertainPeriodAndFormat(Integer.parseInt(flightDetails.get("Date Period")),"dd MMM yyyy");
            driver.findElement(By.xpath("//div[@class='search-form relative row justify-center']//form["+i+"]//input[@name='fromDate']")).sendKeys(returnDate);
            i++;
        }
    }



}
