package api.tickets.management;

import org.testng.annotations.Test;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features="src/test/java/api/tickets/management/Management.feature"
, glue= {"api/tickets/management","utilities"}
, plugin= {"pretty","html:resources/reports/usagemanagmentApi.html"})

public class ManagementRunner extends AbstractTestNGCucumberTests {
  
}
