package helper;

import cucumber.api.java.After;
import org.openqa.selenium.JavascriptExecutor;
import step_definition.HomeTest;

public class Hooks extends TestBase{

    @After("@New_Tab")
    public void closeTheNewTab(){
        driver.close();
        driver.switchTo().window(HomeTest.currentWindow);
    }

    @After()
    public void clearTheCash(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.localStorage.clear();");
    }
}
