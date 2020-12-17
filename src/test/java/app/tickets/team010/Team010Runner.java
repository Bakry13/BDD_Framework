package app.tickets.team010;

import io.cucumber.testng.CucumberOptions;
import utilities.TestBase;

@CucumberOptions(features = "src/test/java/app/tickets/team010/team010.feature"
, glue = {"app/tickets/team010", "utilities", "app/pages"}
, plugin = {"pretty", "html:resources/reports/team010.html"})
public class Team010Runner extends TestBase {
}