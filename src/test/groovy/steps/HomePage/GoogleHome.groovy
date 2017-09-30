package steps.HomePage

import appSearch.Google
import cucumber.api.groovy.EN
import cucumber.api.groovy.Hooks

this.metaClass.mixin Hooks
this.metaClass.mixin EN

Google google = new Google()


Then(~/^the google home page Logo is displayed$/) { ->
   def value = google.googSearch_btn_exists()
   assert value
}