package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/feature",
        glue = "step",
        strict = true,
        plugin = {"com.qmetry.qaf.automation.cucumber.QAFCucumberPlugin"}
)

public class TestRunner {
}
