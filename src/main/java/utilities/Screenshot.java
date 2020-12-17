package utilities;

import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

/**
 * Handles the screenshot functionality and with capture and savingScreenshot
 */
public class Screenshot {
    public static String capture(AppiumDriver driver, String screenshotName) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String dest = System.getProperty("user.dir") + "/resources/screenshots/" + screenshotName; //Write screenshot name with the running language
        File destination = new File(dest);
        FileUtils.copyFile(source, destination);

        return dest;
    }

    public static void saveScreenshot(AppiumDriver driver, String screenshotName) throws IOException {
        String screenshotUpdatedName = screenshotName + "_" +
                GlobalParams.currentLanguage + "_" +
                new GlobalParams().getPlatformName().toString() + ".png";

        capture(driver, screenshotUpdatedName); //capture the screenshot
        String screenshotPath = "../screenshots/" + screenshotUpdatedName; //Saving images to be relative to extent report
        ExtentReport.test.log(LogStatus.PASS, "Screenshot Below: " + ExtentReport.test.addScreenCapture(screenshotPath)); //saving screenshot in extent report
    }

}
