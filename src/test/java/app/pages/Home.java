package app.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.GlobalParams;

public class Home {
    //----------------------------------Home Page Elements---------------------------------------
    @AndroidFindBy(id = "com.emeint.android.myservices:id/ivVodafoneLogo")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"vf icon\"]")
    public static WebElement logo;

    @AndroidFindBy(id = "com.emeint.android.myservices:id/laterTv")
    public static WebElement skipId; //Skip 400MB offer pop up

    @AndroidFindBy(id = "android:id/button1")
    public static WebElement noRateBtn; //No button in android pop up

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Skip']")
    public static WebElement skip; //Log out element in side menu
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='تخطي']")
    public static WebElement skip_Ar; //Log out element in side menu

    @AndroidFindBy(id = "com.emeint.android.myservices:id/pointsTV")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Loyalty-points\"]")
    public static WebElement loyaltyPoints; //red points

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='My points']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Loyalty-pointsCard\"]")
    public static WebElement pointsCard; //red points card
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='نقاطي']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Loyalty-pointsCard\"]")
    public static WebElement pointsCardAr; //red points card

    @AndroidFindBy(id = "com.emeint.android.myservices:id/updateBtn")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"update-button\"]")
    public static WebElement updateBtn; //update button

    @AndroidFindBy(id = "com.emeint.android.myservices:id/laterTv")
    public static WebElement laterBtn; //Later button


    @AndroidFindBy(id = "com.emeint.android.myservices:id/customWidgetsLayout")
    public static WebElement jokercard; // in addon


    @AndroidFindBy(id = "com.emeint.android.myservices:id/tvNumber")
    public static WebElement remaingvalue; // consumption remaining

    @AndroidFindBy(id = "com.emeint.android.myservices:id/tvConsumption")
    public static WebElement consumedvalue; // consumption total

    @AndroidFindBy(id = "com.emeint.android.myservices:id/contentTv")
    public static WebElement contentscript; // consumption card content script

    @AndroidFindBy(id = "com.emeint.android.myservices:id/tvLeftOf")
    public static WebElement leftofscript; // consumption left of id

    @AndroidFindBy(id = "com.emeint.android.myservices:id/tvunit")
    public static WebElement unit; // consumption unit

    @AndroidFindBy(id = "com.emeint.android.myservices:id/usedRenewal")
    public static WebElement usedscript; //  managment used script

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Flex']")
    public static WebElement flexcard; // consumption flex card
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='فليكس']")
    public static WebElement flexcardAr; // consumption flex card ar

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Minutes']")
    public static WebElement mincardEn; // consumption MIn card
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='دقائق']")
    public static WebElement mincardAr; // consumption MIn card ar

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='SMS']")
    public static WebElement smscardEn; // consumption sms card
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='رسائل']")
    public static WebElement smscardAr; // consumption sms card ar

    @AndroidFindBy(id = "com.emeint.android.myservices:id/cardLayoutBg")
    public static WebElement team010; // 010 team card
    //Eman's changes---------------------------------------------------------
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='My Bill']")
    public static WebElement billCardEn; // bill card English
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='اعرف فاتورتك']")
    public static WebElement billCardAr; // bill card Arabic

//-------------------------------------------------------------------------------
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Internet']")
    public static WebElement intcardEn; // consumption internet card
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='إنترنت']")
    public static WebElement intcardAr; // consumption internet card ar

    /* Bakry changes*/
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Roaming']")
    public static WebElement roamingEn; // consumption roaming card
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='التجوال']")
    public static WebElement roamingAr; // consumption roaming card ar

    @AndroidFindBy(id = "com.emeint.android.myservices:id/tvMessage")
    public static WebElement tvMessage; // consumption roaming card tv script while there is unused bundle

    @AndroidFindBy(id = "com.emeint.android.myservices:id/tvExpiryMessage")
    public static WebElement tvExpiryMessage; // consumption roaming card tv script while there is unused bundle

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView[2]")
    public static WebElement firstConsumptionValue; // first used consumption value of roaming tab

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView[2]")
    public static WebElement secondConsumptionValue; // second used consumption value of roaming tab

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.TextView[2]")
    public static WebElement thirdConsumptionValue; // third used consumption value of roaming tab

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.view.ViewGroup/android.widget.TextView[2]")
    public static WebElement fourthConsumptionValue; // fourth used consumption value of roaming tab

    @AndroidFindBy(xpath = "//com.emeint.android.myservices:id/clVOVContent")
    public static WebElement vovResourceId; // vov

    @AndroidFindBy(id = "com.emeint.android.myservices:id/btnRight")
    public static WebElement vovRechargeBtn; // vov recharge butto


    /*End of bakry change*/
    //=======================================Actions======================================
    public static void pressSkip() {
        skipId.click();
    }

    public static void pressNoRate() {
        noRateBtn.click();
    }

    public static void pressLater() {
        laterBtn.click();
    }

    public static void pressflexcardEn() {
        flexcard.click();
    }

    public static void pressmincardEn() throws InterruptedException {
        Thread.sleep(5000);
        mincardEn.click();
    }


    public static void presssmscardEn() throws InterruptedException {
        Thread.sleep(5000);
        smscardEn.click();
    }

    public static void pressintcardEn() throws InterruptedException {
        Thread.sleep(5000);
        intcardEn.click();
    }

    /*Bakry Change*/
    public static void pressroaming() throws InterruptedException {
        Thread.sleep(4000);
        roamingEn.click();
    }

    /*End of Bakry change*/


    //====================================================================================
    public Home(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        if (GlobalParams.currentLanguage == GlobalParams.Language.ARABIC) {
            //Updating Elements with Arabic values====
            skip = skip_Ar;
            pointsCard = pointsCardAr;
            mincardEn = mincardAr;
            smscardEn = smscardAr;
            flexcard = flexcardAr;
            intcardEn = intcardAr;
            /*Bakry Change*/
            roamingEn = roamingAr;
            /*End of Bakry Change*/
        }
    }


}