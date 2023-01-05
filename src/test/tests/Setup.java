package test.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import test.elements.LoginPage;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Setup {

    public WebDriver myWebDriver;
    public String MYURL;
    public String loginEmail;
    public String loginPassword;
    public String driver_selection;
    public Properties propertiesObject = new Properties();


   public Logger myLoggerSetup = Logger.getLogger("Setup");



    @BeforeSuite

    public void baseSetup() throws IOException {


        PropertyConfigurator.configure("src/log4j.properties");
        myLoggerSetup.info("Running the baseSetup, laying the ground work properly");
        checkOS();
    }

    public void checkOS() throws IOException {

        FileWriter setUpPropertiesFile = new FileWriter("src/driver-select.properties");
        propertiesObject.setProperty("driver_status", "chromedriver.exe");
        propertiesObject.store(setUpPropertiesFile, null);
        setUpPropertiesFile.close();

        //String OperatingSystem = System.getProperty("os.name");

       // myLoggerSetup.info("Running tests on " + OperatingSystem + " system. Now setting the correct Driver.");

        //if (OperatingSystem.contains("Linux")) {
           // propertiesObject.setProperty("driver_status", "chromedriver");
       // } else {
            //propertiesObject.setProperty("driver_status", "chromedriver.exe");
        //}

    }

    public void readConstantsValues() throws IOException {
        FileReader readMyConfig = new FileReader("src/config.properties");
        propertiesObject.load(readMyConfig);
        myLoggerSetup.info("Reading the config file now ...");
        MYURL = propertiesObject.getProperty("main_url");
        loginEmail = propertiesObject.getProperty("username");
        loginPassword = propertiesObject.getProperty("password");

        readMyConfig.close();
        FileReader readDriverSelect = new FileReader("src/driver-select.properties");
        propertiesObject.load(readDriverSelect);
        driver_selection = propertiesObject.getProperty("driver_status");
        readDriverSelect.close();

    }


    @BeforeMethod
    public void setup() throws IOException {

        readConstantsValues();
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        System.setProperty("webdriver.chrome.driver", "./WebDrivers/" + driver_selection);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        myWebDriver = new ChromeDriver(options);
        myLoggerSetup.info("Driver Defined");
        myWebDriver.manage().window().maximize();
        myLoggerSetup.info("Window maximized, now getting the URL");

        myWebDriver.get("http://" + MYURL);
        myLoggerSetup.info("Login-page opened successfully");
    }

    @AfterMethod
    public void teardown() {
        myLoggerSetup.info("All test completed, quitting the driver ...");
        myWebDriver.quit();
    }

    public void loginToTheModule() throws InterruptedException {

        LoginPage loginPageObj = new LoginPage(myWebDriver);
        Thread.sleep(10000);
        loginPageObj.setEmailInput(loginEmail);
        loginPageObj.setPasswordInput(loginPassword);
        loginPageObj.clickLoginBtn();
       }

    public void waitForThisTobeClickable(WebElement elementTowait) {
        WebDriverWait waitForOption = new WebDriverWait(myWebDriver, 10);
        waitForOption.until(ExpectedConditions.elementToBeClickable(elementTowait));
    }


}
