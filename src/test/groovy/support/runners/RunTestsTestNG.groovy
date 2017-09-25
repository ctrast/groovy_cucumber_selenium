package steps

import cucumber.api.CucumberOptions
import cucumber.api.testng.AbstractTestNGCucumberTests


@CucumberOptions(
        monochrome = true,
        features = "src/test/groovy/features",
        dryRun = false,
        glue = ["src/test/groovy/steps", "src/test/groovy/features/support"]
)
class RunTestsTestNG extends AbstractTestNGCucumberTests{}
