package testrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = {"pretty", "html:target/cucumber_rerun",
        "json:target/cucumber_rerun.json", "rerun:target/rerun.txt"}, features = {
        "@target/rerun.txt"}, glue = {"stepdefinitions", "commons"})
public class FailedTestsRunner extends AbstractTestNGCucumberTests {

}
