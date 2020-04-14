package tests;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.*;
import pages.PageGenerator;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import static io.github.bonigarcia.wdm.WebDriverManager.*;
/*Browser and environment initilization via maven
 * */

public class BaseTest {

    //    public static PropertiesFile prop = new PropertiesFile();
    public WebDriver driver;


    public WebDriverManager webDriverManager;


    public WebDriverWait wait;
    public PageGenerator page;

//    public WebDriver getDriver() {
//        return driver;
//    }

    @BeforeTest
    public void setupBrowser() {
        // setup the different browsers  using WebDriverManager*****//
        String browser = System.getProperty("browser");
        try {

            switch (browser) {
                case "chrome":
                    chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("disable-infobars");
                    chromeOptions.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
                    driver = new ChromeDriver(chromeOptions);
                    System.out.println("Chrome browser selected");

                    break;
                case "firefox":
                    firefoxdriver().setup();
                    FirefoxOptions options = new FirefoxOptions();
                    options.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
                    driver = new FirefoxDriver(options);
                    System.out.println("firefox browser selected");
                    break;

                case "safari":
                    SafariDriver.builder().build();
                    driver = new SafariDriver();
                    System.out.println(" Safari browser selected");
                    break;

                case "edge":
                    edgedriver().setup();
                    driver = new EdgeDriver();
                    System.out.println("Edge browser selected");
                    break;

                case "ie":
                    iedriver().setup();
                    InternetExplorerOptions Ioptions = new InternetExplorerOptions();
                    Ioptions.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
                    driver = new InternetExplorerDriver();
                    System.out.println("explorer browser selected");
                    break;

                default:
                    System.out.println("browser not selected");


            }
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.manage().window().maximize();

            wait = new WebDriverWait(driver, 45, 1000);


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Null pointer exception");
        }
    }



//    @BeforeTest
//    public void waitforpage() {
//        waitForPageLoaded();
//    }


    //************ run for Windows users only ( to enable driver files in the proejct under ' Executables'  ************//

//    @BeforeTest
//    public void setBrowser() {
//        String browser = System.getProperty("browser");
//
//        if (browser.equalsIgnoreCase("chrome")) {
//            System.out.println(browser);
//            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\Executables\\chromedriver.exe");
//
//            ChromeOptions chromeOptions = new ChromeOptions();
//            chromeOptions.addArguments("disable-infobars");
//            chromeOptions.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
//            driver = new ChromeDriver(chromeOptions);
//
//        } else if (browser.equalsIgnoreCase("firefox")) {
//            System.out.println(browser);
//            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"src\\test\\Executables\\geckodriver.exe");
//            FirefoxOptions options = new FirefoxOptions();
//            options.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
//            driver = new FirefoxDriver(options);
//
//        } else if (browser.equalsIgnoreCase("ie")) {
//            System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\test\\Executables\\IEDriverServer.exe");
//            InternetExplorerOptions Ioptions = new InternetExplorerOptions();
//            Ioptions.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
//            driver = new InternetExplorerDriver();
//
//        } else if (browser.equalsIgnoreCase("edge")) {
//            //set path to Edge.exe
//            System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+ "\\src\\test\\Executables\\msedgedriver.exe");
//            //create Edge instance
//            driver = new EdgeDriver();
//
//        } else {
//            //If no browser passed throw exception
//            System.out.println("no browser selected");
//
//        }
//        driver.manage().deleteAllCookies();
//        //SET  Window to a Standard size
//        Dimension dimension = new Dimension(1920, 1080);
//        driver.manage().window().setSize(dimension);
////        driver.manage().window().maximize();
//        wait = new WebDriverWait(driver, 30, 1000);
//        //Instantiate the Page Class
//
//        //*****Will incorporate to run HEADLESS browser to avoid resizing issue on finding elements !!!*******
//
//    }


//    @BeforeTest            //***** enable when user has 2 environment urls to test!********//
//    public void setEnv() {
//
//
//        String env = System.getProperty("env");
//        try {
//            if (env.equalsIgnoreCase("qa")) {
//
//                System.setProperty("qaEnv", "QAurladdress"); // setup the QA env
//                driver.get(System.getProperty("qaEnv"));
//                System.out.println("Current environment running is " + driver.getCurrentUrl());
//
//            } else if (env.equalsIgnoreCase("prod")) {
//                System.setProperty("prodEnv", "Productionurladdress");  // setup the PROD env
//                driver.get(System.getProperty("prodEnv"));
//                System.out.println("Current environment running is " + driver.getCurrentUrl());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }
//
//    }


    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(1000);

            WebDriverWait wait = new WebDriverWait(driver, 45);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");

        }
        Reporter.log("  page JS  loaded", true);
    }

    @BeforeMethod
    public void methodLevelSetup() throws Exception {
        //Instantiate the Page Class
        page = new PageGenerator(driver);

    }
    /*Use this AFTERMETHOD only if user wants screenshots of every method ran to have a small regression evidence of end user process
     * otherwise use avenstack report to show all methods passed and failed in html report
     * */

//    @AfterMethod
//    public void AfterMethodLevelSetup(ITestResult result) throws Exception {
//        if (ITestResult.FAILURE == result.getStatus()) {
//            Tools.getScreenshot.captureFailScreenshot(result.getName());
//            System.out.println("Method failed:" + result.getName());
//        }
//        if (ITestResult.SUCCESS == result.getStatus()) {
//            System.out.println("Method Successful:" + result.getName());
//            getScreenshot.captureScreenshotwithURL();
//            Thread.sleep(1200);
//
//        }
//    }

    @AfterClass
    public void getLogs() {
//        driver.manage().logs().getAvailableLogTypes();

        System.out.println("================== BROWSER LOGS =======================");
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());


        }
        System.out.println("================== BROWSER LOGS =======================");

    }

    @AfterTest
    public void afterTest(ITestContext testContext) {
        System.out.println("Finishing up running tests" + testContext.getName() + ">");
    }

    @AfterSuite
    public void terminateSession() {
        System.out.println("Suite finished running.");
        if (driver != null) {
            driver.quit();
        }
    }


}