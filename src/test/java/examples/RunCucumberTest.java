package examples;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@CucumberOptions(
        features = "src/test/resources/examples",
        glue = {"examples"},
        plugin = { "pretty", "json:build/cucumber-reports.json"}
)
@RunWith(Cucumber.class)
public class RunCucumberTest {

}
