package app.pages;

import io.appium.java_client.MobileBy;
import io.cucumber.java.After;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import utilities.GlobalParams;
import utilities.TestBase;

public class PageObject extends TestBase {
    //--------------------------------Objects of Page Factory--------------------------------------------------
    @BeforeTest
    public static void PageFactoryObject() {
        GlobalParams GlobalPageObject = new GlobalParams();
        Home homePageObject = new Home(driver);
        Login loginPageObject = new Login(driver);
    }

    @After
    public static void launchApp() {
        driver.resetApp(); //restart app again
    }

    //==================================================================================================

    //Find element by visible text using scroll
    public static WebElement scrollVertical(String visibleText) {
        GlobalParams globalParams = new GlobalParams();
        String uiAnimatorText = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + visibleText + "\").instance(0))";
        WebElement element;
        switch (globalParams.getPlatformName()) {
            case IOS:
                element = driver.findElement(MobileBy.IosUIAutomation(uiAnimatorText));
                break;
            case ANDROID:
                element = driver.findElement(MobileBy.AndroidUIAutomator(uiAnimatorText));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + globalParams.getPlatformName());
        }
        return element;
    }

    public static WebElement scrollHorizontal(String ResourceId, String ClassName, String visibleText) {
        GlobalParams globalParams = new GlobalParams();
        String uiAnimatorText = "new UiScrollable(new UiSelector()."
                + "resourceId(\"" + ResourceId + "\")).setAsHorizontalList().getChildByText("
                + "new UiSelector().className(\"" + ClassName + "\"), \"" + visibleText + "\")";

        WebElement element;
        switch (globalParams.getPlatformName()) {
            case IOS:
                element = driver.findElement(MobileBy.IosUIAutomation(uiAnimatorText));
                break;
            case ANDROID:
                element = driver.findElement(MobileBy.AndroidUIAutomator(uiAnimatorText));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + globalParams.getPlatformName());
        }
        return element;
    }

}