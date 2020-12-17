package utilities;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class GeneralHandler {
    /**
     * This is a general handler class to the pop ups and unexpected messages of the App
     */


    //-----------------------------Handling RED welcome screen-------------------------------------------

    //continue button locating
    @AndroidFindBy(id = "com.emeint.android.myservices:id/btnContinue")
    public static WebElement continueBtn; // Continue button

    //Method to handle RED welcome screen
    public static void pressContinueBtn() {

        continueBtn.click();
    }

    //-----------------------------Handling rating pop up -------------------------------------------

    //No button locating
    @AndroidFindBy(id = "android:id/button1")
    public static WebElement NoRateBtn; //No button in android pop up

    //Method to handle RED welcome screen
    public static void pressNoBtn() {
        NoRateBtn.click();
    }


}
