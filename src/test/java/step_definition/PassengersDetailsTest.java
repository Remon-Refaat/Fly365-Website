package step_definition;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import helper.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;

public class PassengersDetailsTest extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, 10);



    By titleField = By.xpath("//input[@placeholder='Title']");
    By titleDropDownList = By.xpath("//body/div[7]//ul");
    By firstNameTxt = By.xpath("//input[@placeholder='John']");
    By middleNameTxt = By.xpath("//input[@placeholder='William']");
    By lastNameTxt = By.xpath("//input[@placeholder='Smith']");
    By dayField = By.xpath("//input[@placeholder='Day']");
    By dayDropDownList = By.xpath("//body/div[4]//ul");
    By monthField = By.xpath("//input[@placeholder='Month']");
    By monthDropDownList = By.xpath("//body/div[5]//ul");
    By yearField = By.xpath("//input[@placeholder='Year']");
    By yearDropDownList = By.xpath("//body/div[6]//ul");




    @And("^Add the following data in the passenger Details$")
    public void addTheFollowingDataInThePassengerDetails(DataTable passengerData) throws InterruptedException {
        for (Map<String, String> passengerDetails : passengerData.asMaps (String.class,String.class)){

//            selectFromAutoCompleteDDL(titleField, titleDropDownList, passengerDetails.get("Title"));
            driver.findElement(titleField).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(titleDropDownList));
            WebElement select1 = driver.findElement(titleDropDownList);
            List<WebElement> options1 = select1.findElements(By.tagName("li"));
            for (WebElement option1 : options1) {

                if(passengerDetails.get("Title").equals(option1.getText().trim()))

                    option1.click();
            }

            driver.findElement(firstNameTxt).sendKeys(passengerDetails.get("First Name"));
            driver.findElement(middleNameTxt).sendKeys(passengerDetails.get("Middle Name"));
            driver.findElement(lastNameTxt).sendKeys(passengerDetails.get("Last Name"));
            selectFromAutoCompleteDDL(dayField, dayDropDownList, passengerDetails.get("Day"));
            selectFromAutoCompleteDDL(monthField, monthDropDownList, passengerDetails.get("Month"));
            selectFromAutoCompleteDDL(yearField, yearDropDownList, passengerDetails.get("Year"));






//            driver.findElement(monthList).sendKeys(passengerDetails.get("February"));
//            driver.findElement(yearList).sendKeys(passengerDetails.get("1985"));

            Thread.sleep(7000);
        }
    }

    public void selectFromAutoCompleteDDL(By field, By dropDownList, String value)
    {
        driver.findElement(field).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(dropDownList));
        WebElement select1 = driver.findElement(dropDownList);
        List<WebElement> options1 = select1.findElements(By.tagName("li"));
        for (WebElement option1 : options1) {

            if(value.equals(option1.getText().trim()))

                option1.click();
        }
    }


}
