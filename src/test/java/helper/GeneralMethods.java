package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class GeneralMethods extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, 10);


    public void selectFromDDL(By field, String value) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(field));
        driver.findElement(field).click();
        Thread.sleep(2000);
        List<WebElement> allDDL = driver.findElements(By.xpath("//div[@class='el-select-dropdown el-popper']"));
        WebElement lastDDL = allDDL.get(allDDL.size() - 1);
        lastDDL.findElement(By.xpath("./div[1]/div[1]/ul[1]/li[span[contains(text(), '" + value + "')]]")).click();
    }

    public void selectFromAutoCompleteDDL(String value) throws InterruptedException {
        Thread.sleep(3000);
        List<WebElement> allDDL = driver.findElements(By.xpath("//div[@class='el-autocomplete-suggestion el-popper search-autocomplete']"));
        WebElement lastDDL = allDDL.get(allDDL.size() - 1);
        lastDDL.findElement(By.xpath("./div[1]/div[1]/ul[1]/li[div[contains(text(), '" + value + "')]]")).click();

    }

    public void clearLocalStorage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.localStorage.clear();");
        driver.navigate().refresh();
    }

    public String addDateWithCertainPeriodAndFormat(int period, String pattern) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, period);
        SimpleDateFormat simpleFormat = new SimpleDateFormat(pattern);
        String date = simpleFormat.format(cal.getTime());
        return date;
    }
}
