package utilities;

import org.testng.IAlterSuiteListener;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.List;

public class TestNGListener implements IAlterSuiteListener {

    GlobalParams.Language[] availableLanguages = GlobalParams.Language.values();
    GlobalParams.Platform[] availablePlatforms = GlobalParams.Platform.values();
    final private String LANGUAGE_PARAM = "Language";
    final private String PLATFORM_PARAM = "Platform";
    final private String REPORT_NAME_PARAM = "ReportName";
    final private String IS_API_PARAM = "IsAPI";

    @Override
    public void alter(List<XmlSuite> suites) {
        XmlSuite suite = suites.get(0);
        List<XmlTest> testsList = suite.getTests();
        suite.setTests(new ArrayList<XmlTest>()); //Remove all the tests in suite
        List<XmlTest> updatedTestsList = new ArrayList<>();
        for (XmlTest test : testsList) {

            //If the test type is API we will add ReportName Param then add it
            // to the tests list without any changes
            if (test.getParameter(IS_API_PARAM) != null &&
                    test.getParameter(IS_API_PARAM).equals("true")) {
                test.addParameter(REPORT_NAME_PARAM, test.getName());
                updatedTestsList.add(test);
                continue;
            }

            //Create the dynamic tests with both platforms and languages
            for (int langIndex = 0; langIndex < availableLanguages.length; langIndex++) {
                for (int platformIndex = 0; platformIndex < availablePlatforms.length; platformIndex++) {
                    XmlTest newTest = new XmlTest(suite);
                    newTest.setName(test.getName());
                    newTest.setClasses(test.getClasses());
                    newTest.setGroups(test.getSuite().getGroups());
                    String testName = newTest.getName() + "_" + availableLanguages[langIndex].name()
                            + "_" + availablePlatforms[platformIndex].name();
                    newTest.setName(testName);
                    newTest.addParameter(LANGUAGE_PARAM, availableLanguages[langIndex].name());
                    newTest.addParameter(REPORT_NAME_PARAM, testName);
                    newTest.addParameter(PLATFORM_PARAM, availablePlatforms[platformIndex].name());
                    updatedTestsList.add(newTest);
                }
            }
        }
        suite.setTests(updatedTestsList); //Add the new test list to the suit
    }
}