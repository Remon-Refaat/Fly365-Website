package helper;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class TestBase extends AbstractTestNGCucumberTests {

    public static WebDriver driver;

    @BeforeSuite
    @Parameters({"browser"})
    public void startDriver(@Optional("chrome") String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            Reporter.log("=====Chrome Browser Session Started=====", true);
            String chromePath = System.getProperty("user.dir") + "/Resources/chromedriver";
            System.setProperty("webdriver.chrome.driver", chromePath);
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            Reporter.log("=====FireFox Browser Session Started=====", true);
            String firefoxPath = System.getProperty("user.dir") + "/Resources/geckodriver";
            System.setProperty("webdriver.gecko.driver", firefoxPath);
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("safari")) {
            Reporter.log("=====Safari Browser Session Started=====", true);
            driver = new SafariDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);

        Reporter.log("=====Application Started=====", true);

    }

    @AfterSuite
    public void stopDriver() {
        driver.quit();
        Reporter.log("=====Browser Session End=====", true);
    }
}
