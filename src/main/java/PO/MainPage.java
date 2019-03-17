package PO;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    AppiumDriver driver;
    WebDriverWait wait;

    @AndroidFindBy(id = "com.google.android.apps.maps:id/mylocation_button")
    private AndroidElement myLocationButton;

    @AndroidFindBy(id = "android:id/button1")  //for various cases
    private AndroidElement agreementButton;

    @AndroidFindBy(xpath = "//*[@text='Шукайте тут']")
    private AndroidElement searchTextBox;

    @AndroidFindBy(id = "com.google.android.apps.maps:id/search_omnibox_edit_text")
    private AndroidElement searchInput;

    @AndroidFindBy(id = "com.google.android.apps.maps:id/compass_container")
    private AndroidElement firstResultButton;

    @AndroidFindBy(xpath = "//android.support.design.chip.Chip[@content-desc=\"Покроково\"]")
    private AndroidElement buildWayButton;

    @AndroidFindBy(id = "com.google.android.apps.maps:id/start_button")
    private AndroidElement startButton;

    public MainPage(AppiumDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public MobileElement getMyLocationButton() {
        wait.until(ExpectedConditions.visibilityOf(myLocationButton));
        return myLocationButton;
    }

    public MobileElement getAgreementButton() {
        return agreementButton;
    }

    public MobileElement getSearchTextBox() {
        return searchTextBox;
    }

    public MobileElement getSearchInput() {
        wait.until(ExpectedConditions.visibilityOf(searchInput));

        return searchInput;
    }

    public MobileElement getFirstResultButton() {
        wait.until(ExpectedConditions.visibilityOf(firstResultButton));

        return firstResultButton;
    }

    public MobileElement getBuildWayButton() {
        wait.until(ExpectedConditions.visibilityOf(buildWayButton));

        return buildWayButton;
    }

    public MobileElement getStartButton() {
        wait.until(ExpectedConditions.visibilityOf(startButton));

        return startButton;
    }
}
