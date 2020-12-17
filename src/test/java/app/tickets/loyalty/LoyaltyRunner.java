package app.tickets.loyalty;

import io.cucumber.testng.CucumberOptions;
import utilities.TestBase;

@CucumberOptions(features="src/test/java/app/tickets/loyalty/loyalty.feature"
, glue= {"app/tickets/loyalty","utilities","app/pages"}
, plugin= {"pretty","html:resources/reports/LoyaltyApp.html"})
public class LoyaltyRunner extends TestBase
{
}


