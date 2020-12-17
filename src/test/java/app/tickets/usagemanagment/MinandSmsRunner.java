package app.tickets.usagemanagment;

import io.cucumber.testng.CucumberOptions;
import utilities.TestBase;


@CucumberOptions(features = "src/test/java/app/tickets/usagemanagment/MinandSms.feature"
, glue = {"app/tickets", "utilities", "app/pages"}
, plugin = {"pretty", "html:resources/reports/usagemanagment.html"})

public class MinandSmsRunner extends TestBase {
  
}
