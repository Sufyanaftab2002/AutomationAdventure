package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

// @RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/features", glue = "stepDefinition")
public class testrunner extends AbstractTestNGCucumberTests {}
