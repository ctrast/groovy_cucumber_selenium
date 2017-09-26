package support.runners

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
        monochrome = true,
        dryRun = false,
        features = "src/test/groovy/features/currentsprint",
        glue = ["src/test/groovy/steps/currentsprint", "src/test/groovy/support"]
)

public class CurrentSprint extends AbstractTestNGCucumberTests {
}
