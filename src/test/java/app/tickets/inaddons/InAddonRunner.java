package app.tickets.inaddons;

import io.cucumber.testng.CucumberOptions;
import utilities.TestBase;


@CucumberOptions(features="src/test/java/app/tickets/inaddons/InAddons.feature"
, glue= {"app/tickets","utilities", "app/pages"}
, plugin= {"pretty","html:resources/reports/LoyaltyApp.html"})

public class InAddonRunner  extends TestBase
{
 
}
