package steps.search

import appSearch.Google
import appSearch.Navigate
import cucumber.api.groovy.EN
import cucumber.api.groovy.Hooks
import utilities.Action
import utilities.UtilityHelper

this.metaClass.mixin Hooks
this.metaClass.mixin EN

Navigate navigate = new Navigate()
Google google = new Google()

Given(~/^The user is on the google search page$/) { ->
    navigate.Google()
}

And(~/^the user enters the search "([^"]*)"$/) { String arg1 ->
    google.googSearch_edt_sendKeys(arg1)
}
When(~/^the user presses Enter button$/) { ->
    Action.edt_sendKeysEnter()
}
Then(~/^search results list the "([^"]*)"$/) { String arg1 ->
    def value = UtilityHelper.divcontainsText(arg1)

   //TODO move assert to Utilities - pass in value to assert.
    assert value
}