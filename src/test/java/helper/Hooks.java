package helper;

import cucumber.api.java.After;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import step_definition.HomeTest;

public class Hooks extends TestBase{

    WebDriverWait wait = new WebDriverWait(driver, 20);

    @After
    public void SignOut(){
        if (driver.findElement(By.xpath("//div/div[2]/span")).getText().trim().equals("John"))
        {
            driver.findElement(By.xpath("//span[@class='el-dropdown-link capitalize text-xs text-white el-dropdown-selfdefine']")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'Sign Out')]")));
            driver.findElement(By.xpath("//li[contains(text(),'Sign Out')]")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='SIGN IN']")));
        }

    }

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
