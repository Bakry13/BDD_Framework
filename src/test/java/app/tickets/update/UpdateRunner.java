package app.tickets.update;

import io.cucumber.testng.CucumberOptions;
import utilities.TestBase;

@CucumberOptions(features="src/test/java/app/tickets/update/update.feature"
        , glue= {"app/tickets/update","utilities","app/pages"}
        , plugin= {"pretty","html:resources/reports/UpdateApp.html"})
public class UpdateRunner extends TestBase
{
}
