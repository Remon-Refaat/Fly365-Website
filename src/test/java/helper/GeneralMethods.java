package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class GeneralMethods extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, 10);

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
