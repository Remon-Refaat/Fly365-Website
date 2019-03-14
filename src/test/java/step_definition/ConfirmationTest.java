package step_definition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import helper.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ConfirmationTest extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, 10);

    By bookingConfirmationSuccessfulMSG = By.xpath("//div[text()='Thank you for booking with Fly365']");

    @Then("^'Thank you for booking with Fly365' message is displayed$")
    public void thankYouForBookingWithFlyMessageIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(bookingConfirmationSuccessfulMSG));
        Assert.assertTrue(driver.findElement(bookingConfirmationSuccessfulMSG).isDisplayed());
    }






//    public static void connectToEmail() {
//        try {
//            EmailUtililty emailUtililty = new EmailUtililty("john.smith.fly365@gmail.com", "@Fly12345", "smtp.gmail.com", EmailUtililty.EmailFolder.INBOX);
//            System.out.println("(((((((((((((((((");
//            System.out.println("(((((((((((((((((");
//            Message message = emailUtililty.getMessagesBySubject("Verify your email", false, 1)[0];
//            System.out.println(emailUtililty.getMessageContent(message));
//
//            System.out.println("(((((((((((((((((");
//            System.out.println("(((((((((((((((((");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            Assert.fail(e.getMessage());
//        }
//    }

    @And("^get data from database$")
    public void getDataFromDatabase() throws Exception {
//        Message email = emailObject.getEmail("john.smith.fly365@gmail.com", "@Fly12345", "Verify your email");
//        System.out.println("))))))))))))))))))))))");
//        System.out.println("))))))))))))))))))))))");
//
//        System.out.println(email.getFrom());
//        System.out.println(email.getContent());
//        email.writeTo(System.out);
//
//        System.out.println(email.getSubject());
//        System.out.println("))))))))))))))))))))))");

//connectToEmail();



    }





}
