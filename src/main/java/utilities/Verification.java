package utilities;

import com.relevantcodes.extentreports.LogStatus;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.openqa.selenium.WebElement;

import java.io.IOException;

/**
 * Helper class to verify elements and log action result
 */
public class Verification {
    public static boolean failureFlag = false;
    public static int statusCode = 0;
    public static String jsonString = "0";
    public static String code = "0";
    public static String reason = "0";
    public static String message = "0";

    //--------------------------------verify if a certain element exists----------------------------------------
    public static boolean verifyElement(WebElement element, String successText, String failureText) throws IOException {
        try {
            assert element.isDisplayed(); //find if the element is displayed
            ExtentReport.test.log(LogStatus.PASS, successText); //Record expected result
            failureFlag = true;
        } catch (Exception e) {
            ExtentReport.test.log(LogStatus.FAIL, failureText); //Write failure statement
            failureFlag = false;
            e.printStackTrace();
        }
        return failureFlag;
    }

    //--------------------------------verify if a certain element doesn't exists----------------------------------------
    public static boolean verifyElementNotExists(WebElement element, String successText, String failureText) throws IOException {
        try {
            assert element.isDisplayed(); //find if the element is displayed
            ExtentReport.test.log(LogStatus.FAIL, failureText); //Write failure statement
            failureFlag = false;
        } catch (Exception e) {
            ExtentReport.test.log(LogStatus.PASS, successText); //Write failure statement
            failureFlag = true;

            e.printStackTrace();
        }
        return failureFlag;
    }

    //--------------------------------verify if a certain Text exists----------------------------------------
    public static boolean verifyText(String elementText, String successText, String failureText) throws IOException {
        try {
            //	assert GlobalParams.scrollVertical(elementText).isDisplayed(); //find if the element is displayed

            ExtentReport.test.log(LogStatus.PASS, successText); //Record expected result
            failureFlag = true;
        } catch (Exception e) {
            ExtentReport.test.log(LogStatus.FAIL, failureText); //Write failure statement
            failureFlag = false;
            e.printStackTrace();
        }
        return failureFlag;
    }

    //-------------------------------verify the correctness of text of a certain element------------------------------
    public static boolean verifyElementText(WebElement element,
                                            String elementTextEn,
                                            String elementTextAr,
                                            String successText,
                                            String failureText) {
        try {
            String validatedText = "";
            if (GlobalParams.currentLanguage == GlobalParams.Language.ENGLISH)
                validatedText = elementTextEn;
            else
                validatedText = elementTextAr;
            System.out.println("\""+element.getText()+"\"");
            if (element.getText().equals(validatedText)) {
                ExtentReport.test.log(LogStatus.PASS, successText); //Record expected result
                failureFlag = true;
            } else {
                ExtentReport.test.log(LogStatus.FAIL, failureText); //Write failure statement
                failureFlag = false;
            }
        } catch (Exception e) {
            ExtentReport.test.log(LogStatus.FAIL, failureText); //Write failure statement
            failureFlag = false;
        }
        return failureFlag;
    }

    //-------------------------------verify the correctness of String value------------------------------
    public static boolean verifyString(String value, String expectedValue, String successText, String failureText) throws IOException {
        if (value.equals(expectedValue)) {
            ExtentReport.test.log(LogStatus.PASS, successText); //Record expected result
            failureFlag = true;
        } else {
            ExtentReport.test.log(LogStatus.FAIL, failureText); //Write failure statement
            failureFlag = false;
        }
        return failureFlag;
    }

    //-------------------------------verify the correctness of integer value------------------------------
    public static boolean verifyInt(int value, int expectedValue, String successText, String failureText) throws IOException {
        if (value == expectedValue) {
            ExtentReport.test.log(LogStatus.PASS, successText); //Record expected result
            failureFlag = true;
        } else {
            ExtentReport.test.log(LogStatus.FAIL, failureText); //Write failure statement
            failureFlag = false;
        }
        return failureFlag;
    }

    //-------------------------------verify the correctness of float value------------------------------
    public static boolean verifyFloat(float value, float expectedValue, String successText, String failureText) throws IOException {
        if (value == expectedValue) {
            ExtentReport.test.log(LogStatus.PASS, successText); //Record expected result
            failureFlag = true;
        } else {
            ExtentReport.test.log(LogStatus.FAIL, failureText); //Write failure statement
            failureFlag = false;
        }
        return failureFlag;
    }

    //-------------------------------verify the correctness of boolean value------------------------------
    public static boolean verifyBoolean(boolean value, boolean expectedValue, String successText, String failureText) throws IOException {
        if (value == expectedValue) {
            ExtentReport.test.log(LogStatus.PASS, successText); //Record expected result
            failureFlag = true;
        } else {
            ExtentReport.test.log(LogStatus.FAIL, failureText); //Write failure statement
            failureFlag = false;
        }
        return failureFlag;
    }

    //===========================================API Verification==========================================
    //-------------------------------verify Success Code 200------------------------------
    public static String success(Response response) throws IOException {
        statusCode = response.getStatusCode();
        jsonString = response.asString();
        verifyInt(statusCode, 200, "Status code = 200", "Status code = " + statusCode); //verify status code
        return jsonString;
    }

    //-------------------------------verify Not found 404 - 1001---loyalty---------------------------
    public static String notFound(Response response) throws IOException {
        statusCode = response.getStatusCode();
        jsonString = response.asString();
        verifyInt(statusCode, 404, "Status code = 404", "Status code = " + statusCode); //verify status code
        code = JsonPath.from(jsonString).get("code");
        verifyString(code, "1001", "Code = 1001", "Code = " + code); //verify body code
        reason = JsonPath.from(jsonString).get("reason");
        verifyString(reason, "No Data Found", "reasone is: No Data Found", "reason is: " + reason); //verify body code
        return jsonString;
    }

    //-------------------------------verify Not found 404 - 1006------------------------------
    public static String notFoundURL(Response response) throws IOException {
        statusCode = response.getStatusCode();
        jsonString = response.asString();
        verifyInt(statusCode, 404, "Status code = 404", "Status code = " + statusCode); //verify status code
        code = JsonPath.from(jsonString).get("code");
        verifyString(code, "1006", "Code = 1006", "Code = " + code); //verify body code
        reason = JsonPath.from(jsonString).get("reason");
        verifyString(reason, "Not Found", "reasone is: Not Found", "reason is: " + reason); //verify body code
        return jsonString;
    }

    //-------------------------------verify Unauthorized 401------------------------------
    public static String unauthorized(Response response) throws IOException {
        statusCode = response.getStatusCode();
        jsonString = response.asString();
        Verification.verifyInt(statusCode, 401, "Status code = 401", "Status code = " + statusCode); //verify status code
        return jsonString;
    }

    //-------------------------------verify Method Not Allowed 405------------------------------
    public static String methodNotAllowed(Response response) throws IOException {
        statusCode = response.getStatusCode();
        jsonString = response.asString();
        verifyInt(statusCode, 405, "Status code = 405", "Status code = " + statusCode); //verify status code
        code = JsonPath.from(jsonString).get("code");
        verifyString(code, "2003", "Code = 2003", "Code = " + code); //verify body code
        reason = JsonPath.from(jsonString).get("reason");
        verifyString(reason, "Method Not Accepted", "reason is: Method Not Accepted", "reason is: " + reason);
        return jsonString;
    }

    //-------------------------------Unsupported Media Type 415------------------------------
    public static String unsupportedMediaType(Response response) throws IOException {
        statusCode = response.getStatusCode();
        jsonString = response.asString();
        verifyInt(statusCode, 415, "Status code = 415", "Status code = " + statusCode); //verify status code
        code = JsonPath.from(jsonString).get("code");
        verifyString(code, "2004", "Code = 2004", "Code = " + code); //verify body code
        reason = JsonPath.from(jsonString).get("reason");
        verifyString(reason, "Media Type not supported", "reasone is: Media Type not supported", "reason is: " + reason);
        message = JsonPath.from(jsonString).get("message");
        verifyString(message, "Content-Type: 'null' Not supported", "message is: Content-Type: 'null' Not supported", "message is: " + message);
        return jsonString;
    }

    //-------------------------------Bad Request 400------------------------------
    public static String badRequest(Response response) throws IOException {
        statusCode = response.getStatusCode();
        jsonString = response.asString();
        verifyInt(statusCode, 400, "Status code = 400", "Status code = " + statusCode); //verify status code
        code = JsonPath.from(jsonString).get("code");
        verifyString(code, "1004", "Code = 1004", "Code = " + code); //verify body code
        reason = JsonPath.from(jsonString).get("reason");
        verifyString(reason, "Invalid Input", "reasone is: Invalid Input", "reason is: " + reason); //verify body code
        return jsonString;
    }

    //---------------------------------Forbidden 403--------------------------------
    public static String forbidden(Response response) throws IOException {
        statusCode = response.getStatusCode();
        jsonString = response.asString();
        verifyInt(statusCode, 403, "Status code = 403", "Status code = " + statusCode); //verify status code
        code = JsonPath.from(jsonString).get("code");
        verifyString(code, "2001", "Code = 2001", "Code = " + code); //verify body code
        reason = JsonPath.from(jsonString).get("reason");
        verifyString(reason, "Action Not Permitted", "reasone is: Action Not Permitted", "reason is: " + reason); //verify body code
        message = JsonPath.from(jsonString).get("message");
        verifyString(message, "Access is denied", "message is: Access is denied", "message is: " + message);
        return jsonString;
    }

    //-------------------------------Internal Server Error 500------------------------------
    public static String internalServerError(Response response) throws IOException {
        statusCode = response.getStatusCode();
        jsonString = response.asString();
        verifyInt(statusCode, 500, "Status code = 500", "Status code = " + statusCode); //verify status code
        code = JsonPath.from(jsonString).get("code");
        verifyString(code, "3999", "Code = 3999", "Code = " + code); //verify body code
        reason = JsonPath.from(jsonString).get("reason");
        verifyString(reason, "Generic System Error", "reasone is: Generic System Error", "reason is: " + reason);
        return jsonString;
    }
}