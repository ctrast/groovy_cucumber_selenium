package utilities

import driver.WebDriverFactory
import dto.Browser

class BeforeAfterScn {

    static void before() {
        Browser browserDto = new Browser()
        browserDto.setName("Chrome")
        String gridhubul = ""
        WebDriverFactory.initialize(gridhubul, browserDto)

    }


    static void after() {
        WebDriverFactory.closeBrowser()
        WebDriverFactory.quitDriver()
    }
}
