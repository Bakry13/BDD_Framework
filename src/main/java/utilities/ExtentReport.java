package utilities;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.IOException;

/**
 * Manages the creation and steps of ExtentReport with the Hooks of TestNG & Cucumber
 */
public class ExtentReport {
    public static int tcNumb = 1;
    public static ExtentReports extent;
    public static ExtentTest test;

    //===========================================================================================================
    @BeforeTest
    @Parameters("ReportName")
    public void startReport(String ReportName) {
        tcNumb = 1;
        extent = new ExtentReports(System.getProperty("user.dir") + "/resources/reports/"
                + ReportName + ".html");
    }
    //-----------------------------------------------------------------------------------------------------------
    @AfterTest
    public void endReport() {
        extent.flush();
        extent.close();
    }
    //===========================================================================================================
//    static Scenario scenario;
//    @Before
//    public static void getTCName(Scenario scenario)
//    {
//    	System.out.println(scenario.getName());
//    	ExtentReport.startTC(scenario.getName());
//    }
    //-----------------------------------------------------------------------------------------------------------
    public static void startTC(String tcName) {
        String tcNumber = "1";
        String testCaseName = "0";
        tcNumber = Integer.toString(tcNumb++); //Counting test case number
        testCaseName = tcNumber + "-  " + tcName; //store test case name with its number
        test = extent.startTest(testCaseName); //Test Case name in extent report
    }

    //-----------------------------------------------------------------------------------------------------------
    @After
    public static void endTC() {
        extent.endTest(test); //close the test case in extent report
    }

    //===========================================================================================================
    public static void startEndTC(String keywordAction, String tcName) throws IOException {
        String tcNumber = "1";
        String testCaseName = "0";
        if (keywordAction.equals("StartOfTC") || keywordAction.equals("EndOfTest")) {
            if (tcNumb != 1) // if it is not the first test case we will end the previous one
            {
                extent.endTest(test); //close the test case in extent report
            }
            if ((keywordAction.equals("StartOfTC")))// if it is not the last test case we will start the next one
            {
                tcNumber = Integer.toString(tcNumb++); //Counting test case number
                testCaseName = tcNumber + "-  " + tcName; //store test case name with its number
                test = extent.startTest(testCaseName); //Test Case name in extent report
            }
        }
    }
}
