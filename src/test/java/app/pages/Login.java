package app.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.ExtentReport;
import utilities.GlobalParams;

public class Login {
    //----------------------------------Login Page Elements---------------------------------------

    @AndroidFindBy(id = "android:id/button1")
    public static WebElement allowButton; //Log out element in side menu

    @AndroidFindBy(id = "com.emeint.android.myservices:id/tvOnboardingHeader")
    public static WebElement Hi; //Hi text in login page

    @AndroidFindBy(xpath = "//android.widget.EditText[1]")
    @iOSXCUITFindBy(accessibility = "login-mobile")
    public static WebElement msisdn; //User msisdn filed element in login screen

    @AndroidFindBy(id = "com.emeint.android.myservices:id/btnLogin")
    @iOSXCUITFindBy(accessibility = "login-procced")
    //@AndroidFindBy(xpath = "//android.widget.Button[@text='Proceed']")
    public static WebElement proceedBtn; //NT user name text box

    @AndroidFindBy(id = "com.emeint.android.myservices:id/tvError")
    @iOSXCUITFindBy(accessibility = "login-error")
    public static WebElement loginErrorMsg; //incorrect credentials error message

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.EditText")
    @iOSXCUITFindBy(accessibility = "login-password")
    public static WebElement password; //Log out element in side menu

    @AndroidFindBy(id = "com.emeint.android.myservices:id/imgLanguage")
    public static WebElement changeLanguage; //Change language from En to Ar and vice versa

    //=====================================Actions==========================================
    public static void pressAllow() {
        allowButton.click();
    }

    public static void enterMSISDN(String mobileNumber) {
        msisdn.sendKeys(mobileNumber);
    }

    public static void pressProceed() {
        proceedBtn.click();
    }

    public static void enterPassword(String pass) {
        password.sendKeys(pass);
    }

    //===============================Valid Scenarios========================================
    public static void checkLanguageToAr() {
        try {
            if (!(Login.Hi.getText().equals("Hi,")) && GlobalParams.currentLanguage == GlobalParams.Language.ARABIC) //Check if language is not English
                Login.changeLanguage.click(); //Change language from Ar to En
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void validLogin(String mobileNumber, String pass) {
        enterMSISDN(mobileNumber); //Enter MSISDN
        pressProceed(); //Press Proceed Button
        pressProceed();
        enterPassword(pass); //Enter password
        pressProceed();


        //Press Proceed Button
        //Thread.sleep(2500);
        //Home.skip.click();
    }

    public static void changeLanguage() {
        Login.changeLanguage.click(); //Change language from En to Ar and vice versa
        if (GlobalParams.currentLanguage == GlobalParams.Language.ENGLISH) //If the language still En
        {
            ExtentReport.extent.endTest(ExtentReport.test); //close the test case in extent report
            GlobalParams.currentLanguage = GlobalParams.Language.ARABIC; //Change language to Ar
            PageObject.PageFactoryObject(); //Initializing page factory objects with new language
        }
    }

    //======================================================================================
    public Login(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}


