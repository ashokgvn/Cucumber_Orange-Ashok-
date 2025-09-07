package testRunner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;


@CucumberOptions(dryRun=false, features = {"featurefiles/login.feature"},
glue = {"stepDefinition"},
plugin = {"pretty", "html:target/cucumber-reports/report.html", "json:target/cucumber-reports/report.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},monochrome=true)
public class AppTest extends AbstractTestNGCucumberTests {

}
