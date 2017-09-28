package support.runners

import cucumber.api.CucumberOptions
import cucumber.api.testng.AbstractTestNGCucumberTests


@CucumberOptions(
        monochrome = true,
        dryRun = false,
        features = "src/test/groovy/features/smoke",
        glue = ["src/test/groovy/steps/smoke", "src/test/groovy/support"]
)
public class Smoke extends AbstractTestNGCucumberTests{}
