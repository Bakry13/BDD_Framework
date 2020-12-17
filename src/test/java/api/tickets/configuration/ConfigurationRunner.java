package api.tickets.configuration;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;

import io.cucumber.testng.CucumberOptions;
import utilities.TestBase;


@CucumberOptions(features="src/test/java/api/tickets/configuration/configuration.feature"
, glue= {"api/tickets/configuration","utilities"}
, plugin= {"pretty","html:resources/reports/UpdateApp.html"})

public class ConfigurationRunner extends AbstractTestNGCucumberTests
{

}
