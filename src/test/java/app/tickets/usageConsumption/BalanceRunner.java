package app.tickets.usageConsumption;

import io.cucumber.testng.CucumberOptions;
import utilities.TestBase;

@CucumberOptions(features = "src/test/java/app/tickets/usageConsumption/balance.feature"
, glue = {"app/tickets/usageConsumption", "utilities", "app/pages"}
, plugin = {"pretty", "html:resources/reports/balanceApp.html"})
public class BalanceRunner extends TestBase {
}