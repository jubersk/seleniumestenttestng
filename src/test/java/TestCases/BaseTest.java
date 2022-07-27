package TestCases;

import Pages.HomePage;
import driverManager.DriverManagerType;
import driverManager.WebDrivers;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import util.utility;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected HomePage homePage;
    WebDriver driver;
    Properties properties;
    static String URL;

    @BeforeSuite
    public void setUp() {
        String propertyPath = System.getProperty("user.dir") + "//src//test//resources//Env.properties";
        try {
            driver = WebDrivers.getDriver(DriverManagerType.CHROME);
            properties = utility.loadProperties(propertyPath);
            URL = properties.getProperty("URL");
            homePage = new HomePage(driver);
            driver.get(URL);
            driver.manage().window().maximize();
        	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
           
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
   
    @AfterSuite
    public void destroyDriver() {
        driver.quit();
    }
}