import PO.MainPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.functions.ExpectedCondition;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class GPSTest {

    AppiumDriver driver = null;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "AQH7N17C09005428");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appActivity", "com.google.android.maps.MapsActivity");
        capabilities.setCapability("appPackage", "com.google.android.apps.maps");

        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Parameters({"destination"})
    @Test
    public void FindDestinationAndGoPositiveTestCase (String destination) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        MainPage mainPage = new MainPage(driver, wait);
        mainPage.getMyLocationButton().click();
        mainPage.getAgreementButton().click();
        mainPage.getSearchTextBox().click();
        mainPage.getSearchInput().sendKeys(destination);
        mainPage.getFirstResultButton().click();
        mainPage.getBuildWayButton().click();
//        mainPage.getAgreementButton().click();
        mainPage.getStartButton().click();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
