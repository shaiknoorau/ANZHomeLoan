package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features=".//Features/ANZHomeLoanCalculator.feature",
		glue = "stepDefinitions",
		dryRun = false,
		monochrome=true,
		publish = true,
		plugin = {"pretty","html:target/cucumber-report.html"},
		tags = "@e2etest"
		)
public class TestRun {

}
