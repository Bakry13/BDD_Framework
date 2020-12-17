package api.tickets.consumption;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import org.testng.annotations.Test;

//import io.cucumber.testng.CucumberOptions;
import utilities.TestBase;



@CucumberOptions(features="src/test/java/api/tickets/consumption/Consumption.feature"
, glue= {"api/tickets/consumption","utilities"}
, plugin= {"pretty","html:resources/reports/UpdateApp.html"})


public class ConsumptionRunner extends AbstractTestNGCucumberTests
{
 
}
