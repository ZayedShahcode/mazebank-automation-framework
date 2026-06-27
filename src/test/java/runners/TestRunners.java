package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features/Login.feature"},
        glue = {
                "stepdefs"
        },
        plugin = {"pretty"},
        monochrome = true
)
public class TestRunners extends AbstractTestNGCucumberTests {


}
