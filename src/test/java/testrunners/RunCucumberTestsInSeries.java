package testrunners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json",
        "rerun:target/rerun.txt"}, features = {"classpath:features"}, glue = {"stepdefinitions",
        "commons"})
public class RunCucumberTestsInSeries extends AbstractTestNGCucumberTests {

}
