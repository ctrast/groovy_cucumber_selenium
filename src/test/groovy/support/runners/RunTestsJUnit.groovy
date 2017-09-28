package support.runners

import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith

@CucumberOptions(
        monochrome = true,
        features = 'src/test/groovy/features',
        dryRun = false,
        glue = ['src/test/groovy/steps', 'src/test/groovy/features/support']
)

class RunTestsJUnit {
    //leave empty!
}