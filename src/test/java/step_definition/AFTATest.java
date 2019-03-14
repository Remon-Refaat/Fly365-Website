package step_definition;

import cucumber.api.java.en.And;
import org.openqa.selenium.By;
import org.testng.Assert;
import helper.TestBase;


public class AFTATest extends TestBase {

    private By aftaLINK = By.xpath("//a[@title='Afta']");
    private By aftaHDR = By.xpath("//div[@id='page_content']/h3");

    @And("^Press on 'afta' and verify that page is opened$")
    public void pressOnAftaAndVerifyThatPageIsOpened() throws InterruptedException {
        String currentWindow = driver.getWindowHandle();
        driver.findElement(aftaLINK).click();
        Thread.sleep(15000);
        for (String windowID : driver.getWindowHandles()) {
            String title = driver.switchTo().window(windowID).getTitle();
            if (title.equals("Australian Federation of Travel Agents")) {
                String headerText = driver.findElement(aftaHDR).getText();
                Assert.assertEquals(headerText, "WELCOME TO AFTA");
                driver.close();
                break;
            }
        }
        driver.switchTo().window(currentWindow);

    }

}
