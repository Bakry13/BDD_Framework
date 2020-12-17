package app.tickets.billCard;

import io.cucumber.testng.CucumberOptions;
import utilities.TestBase;

@CucumberOptions(features = "src/test/java/app/tickets/billCard/billCard.feature"
        , glue = {"app/tickets/billCard", "utilities", "app/pages"}
        , plugin = {"pretty", "html:resources/reports/billCard.html"})
public class BillCardRunner extends TestBase {

}
