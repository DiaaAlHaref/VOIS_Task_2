/**
 * This is a task to search for a keyword then count the search result elements in the Second result page,
 * Third result page and then assert on the number of elements occured in both pages
 * /
 * <p>
 * /**
 * This Framework for VOIS CoE Team, performed on a task using Intellij IDE
 * Selenium WebDriver, TestNG, Allure Report Framework, Data Driven Framework
 */
package automationTest;


import fileReaders.PropertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.HandleExceptions;
import utilities.Logs;
import utilities.UiActions;

import java.io.ByteArrayInputStream;

/**
 * BaseClass Demonstrates WebDrivers loading and other classes inherit from
 *
 * @author Diaa AlHaref
 */


public class BaseTest {

    Logs Log = new Logs();

    String[] view = PropertiesFile.propertiesFileReader(new String[]{"baseUrl"});
    protected String url = view[0];

    /**
     * loads the drivers Chrome, FireFox, InternetExplorer
     *
     * @param browser takes name of the browsers as string "chrome" , "firefox" , "ie"
     */
    @BeforeClass
    @Parameters({"browser"}) //To Run Test From parallelTest.xml file used with Selenium Grid
    public void startupDrivers(@Optional("chrome") String browser) {
        //@optional used to run test by default value passed to it ex. ("chrome")
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                UiActions.driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                UiActions.driver = new FirefoxDriver();
                break;
            case "ie":
                System.setProperty("webdriver.ie.driver", "src//main//resources//IEDriverServer.exe");
                //WebDriverManager.iedriver().setup();
                UiActions.driver = new InternetExplorerDriver();
                break;
        }
        /**
         * Navigate directly to url
         * <p>Maximize window size</p>
         */
        UiActions.driver.navigate().to(url);   //Navigate to target url
        Log.info("Navigate to url");

        UiActions.driver.manage().window().maximize();  //Maximize browser window size
        Log.info("Browser window size maximized");
    }

    /**
     * Takes Screenshot on Failure
     *
     * @param result result when "Failure" exist
     */

    @AfterMethod
    @Attachment(value = "Screenshot", type = "image/png")
    public void takeScreenShotsOnFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            // in case of test case failure take screenshots
            System.out.println("*** Test execution *** " + " " + result.getMethod().getMethodName() + "  >>   " + " failed...");
            System.out.println("Taking Screenshot...");
            Allure.addAttachment("Page Screenshot",
                    new ByteArrayInputStream(((TakesScreenshot) UiActions.driver).getScreenshotAs(OutputType.BYTES)));
        }
    }

    /**
     * Exit the running browser
     */
    @AfterClass(enabled = false)
    public void tearDownBrowser() {
        try {
            UiActions.driver.quit();
        } catch (NoSuchSessionException e) {
            HandleExceptions.NoSuchSessionExceptionHandling(e);
        }
    }
}
