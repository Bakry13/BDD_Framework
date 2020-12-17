package app.tickets.usageConsumption;

import io.cucumber.testng.CucumberOptions;
import utilities.TestBase;

@CucumberOptions(features = "src/test/java/app/tickets/usageConsumption/roaming.feature"
, glue = {"app/tickets", "utilities", "app/pages"}
, plugin = {"pretty", "html:resources/reports/roamingApp.html"})
public class RoamingRunner extends TestBase {
}