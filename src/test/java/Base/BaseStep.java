package Base;

import Common.DriverClass;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class BaseStep {
    public WebDriver driver;
    public String url = "";
    public WebDriver getWebDriver() {
        return DriverClass.driver;
    }
    @BeforeClass
    public void initializeTestBase()throws InterruptedException{
        String browser="";
        Properties property=new Properties();
        String proFileName="/cucumber.properties";
        InputStream inputStream= getClass().getResourceAsStream(proFileName);
        try {
            if(inputStream!=null){
                property.load(inputStream);
                browser=System.getProperty("Browser")!=null? System.getProperty("Browser"): property.getProperty("browser");
                url= property.getProperty("ServerPath");
                setDriver(browser,url);
            }else{
                    throw new FileNotFoundException("the file is not found");
                }
        }catch (IOException e){
            e.getMessage();
        }
    }

    private void setDriver(String browser, String url) {
        if(DriverClass.driver==null){
            switch (browser) {
                case "chrome":
                    DriverClass.driver = initChromeDriver(url);
                    break;
                case "firefox":
                    DriverClass.driver = initFirefoxDriver(url);
                    break;

            }
        }else{
            DriverClass.driver.get(url);


        }
    }

    private WebDriver initFirefoxDriver(String url) {
        WebDriver driver;
        if(System.getProperty("os.name").toLowerCase().contains("windows")){
            System.setProperty("webdriver.firefox.marionette",System.getProperty("user.dir")+"\\src\\test\\java\\driver\\geckodriver.exe");
        }
        driver = new FirefoxDriver();
        driver.get(url);

        return driver;
    }

    private WebDriver initChromeDriver(String appURL) {
        WebDriver driver;
        if(System.getProperty("os.name").toLowerCase().contains("windows")){
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\java\\driver\\chromedriver.exe");
        }
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setCapability("applicationCacheEnabled", false);
        driver=new ChromeDriver(cap);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(appURL);
        return driver;
    }

    public void PageScrolldown() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,300)", "");

    }

    @AfterClass
    public void closeDriver(){
        DriverClass.driver.close();
        DriverClass.driver.quit();
    }
}
