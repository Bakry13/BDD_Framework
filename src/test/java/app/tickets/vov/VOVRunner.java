package app.tickets.vov;

import io.cucumber.testng.CucumberOptions;
import utilities.TestBase;

@CucumberOptions(features = "src/test/java/app/tickets/vov/vov.feature"
, glue = {"app/tickets", "utilities", "app/pages"}
, plugin = {"pretty", "html:resources/reports/vov.html"})
public class VOVRunner extends TestBase {
}