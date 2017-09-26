package support

import utilities.BeforeAfterScn
import static cucumber.api.groovy.Hooks.After
import static cucumber.api.groovy.Hooks.Before

BeforeAfterScn beforeAfterScn = new BeforeAfterScn()

Before() {
    println "BEFORE hook called"
    beforeAfterScn.before()
}
After() {
    println "AFTER hook called"
    beforeAfterScn.after()
}
