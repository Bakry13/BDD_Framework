package app.tickets.flexes;

import io.cucumber.testng.CucumberOptions;
import utilities.TestBase;


@CucumberOptions(features="src/test/java/app/tickets/flexes/Flexes.feature"
, glue= {"app/tickets","utilities", "app/pages"}
, plugin= {"pretty","html:resources/reports/LoyaltyApp.html"})

public class FlexRunner  extends TestBase
{
  
}
