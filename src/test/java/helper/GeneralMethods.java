package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class GeneralMethods extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, 10);

//    public void selectFromAutoCompleteDDL(By field, By dropDownList, String value)
//    {
//        driver.findElement(field).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(dropDownList));
//        WebElement select1 = driver.findElement(dropDownList);
//        List<WebElement> options1 = select1.findElements(By.tagName("li"));
//        for (WebElement option1 : options1) {
//
//            if(value.equals(option1.getText().trim()))
//
//                option1.click();
//        }
//    }


public void selectFromAutoCompleteDDL(By field, String value) throws InterruptedException {
    wait.until(ExpectedConditions.visibilityOfElementLocated(field));
    driver.findElement(field).click();
    Thread.sleep(2000);
    List<WebElement> allDDL = driver.findElements(By.xpath("//div[@class='el-select-dropdown el-popper']"));
    WebElement lastDDL = allDDL.get(allDDL.size() - 1);
    lastDDL.findElement(By.xpath("./div[1]/div[1]/ul[1]/li[span[contains(text(), '"+value+"')]]")).click();
}


//        public void selectFromAutoCompleteDDL(By field, String value) throws InterruptedException {
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(field));
//        driver.findElement(field).click();
//        Thread.sleep(2000);
//        List<WebElement> allDDL = driver.findElements(By.xpath("//div[@class='el-select-dropdown el-popper']"));
//        WebElement lastDDL = allDDL.get(allDDL.size() - 1);
//        List<WebElement> options1 = lastDDL.findElements(By.xpath("./div[1]/div[1]/ul[1]/li[span[contains(text(), '"+value+"')]]"));
//
//        for (WebElement option1 : options1) {
//
//            if(value.equals(option1.getText().trim()))
//
//                option1.click();
//        }
//    }

    public String addDateWithCertainPeriodAndFormat(int period, String pattern){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, period);
        SimpleDateFormat simpleFormat = new SimpleDateFormat(pattern);
        String date = simpleFormat.format(cal.getTime());
        return date;
    }
}
