package testrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json",
        "rerun:target/rerun.txt"}, features = {"classpath:features"}, glue = {"stepdefinitions",
        "commons"})
public class RunCucumberTestsInParallel extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
