package support.runners

import cucumber.api.CucumberOptions
import cucumber.api.testng.AbstractTestNGCucumberTests

@CucumberOptions(
        monochrome = true,
        dryRun = false,
        tags="@regression",
        features = 'src/test/groovy/features/',
        glue = ['src/test/groovy/steps/', 'src/test/groovy/support']
)
class Regression extends AbstractTestNGCucumberTests {
}
