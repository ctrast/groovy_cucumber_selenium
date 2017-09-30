package support.runners

import cucumber.api.CucumberOptions
import cucumber.api.testng.AbstractTestNGCucumberTests


@CucumberOptions(
        monochrome = true,
        dryRun = false,
        features = "src/test/groovy/features/",
        tags="@smoke",
        glue = ["src/test/groovy/steps/", "src/test/groovy/support"]
)
public class Smoke extends AbstractTestNGCucumberTests{}
