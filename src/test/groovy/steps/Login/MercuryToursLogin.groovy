package steps.Login

import appSearch.MTFlightFinder
import appSearch.MTHome
import appSearch.Navigate
import cucumber.api.PendingException
import cucumber.api.groovy.EN
import cucumber.api.groovy.Hooks

this.metaClass.mixin Hooks
this.metaClass.mixin EN

navigate = Navigate.newInstance()
MTHome mtHome = new MTHome()
MTFlightFinder flightFinder = new MTFlightFinder()

Given(~/^The user is on the Mercury Tours home page$/) { ->
    navigate.MercuryHome()
}
And(~/^the user enters the username "([^"]*)"$/) { String arg1 ->
    mtHome.username_edt_sendKeys(arg1)
}
And(~/^the user enter the password "([^"]*)"$/) { String arg1 ->
    mtHome.passsword_edt_sendKeys(arg1)
}
When(~/^the user presses Sign-In button$/) { ->
   mtHome.signin_btn_click()
}
Then(~/^the Flight Finder page is displayed$/) { ->
   def value = flightFinder.FlightFinder_img_exists()
    assert value
}