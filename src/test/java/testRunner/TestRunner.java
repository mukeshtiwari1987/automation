package testRunner;
import java.io.File;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = ".//Features/landingPage.feature", glue = "stepDefinations", dryRun = false, plugin = { "pretty" })
public class TestRunner extends AbstractTestNGCucumberTests {


}
