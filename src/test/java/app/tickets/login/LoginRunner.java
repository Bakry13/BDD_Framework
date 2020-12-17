package app.tickets.login;

import io.cucumber.testng.CucumberOptions;
import utilities.TestBase;

@CucumberOptions(features="src/test/java/app/tickets/login/login.feature"
, glue= {"app/tickets/login","utilities","app/pages"}
, plugin= {"pretty","html:resources/reports/LoginApp.html"})
public class LoginRunner extends TestBase
{

}
